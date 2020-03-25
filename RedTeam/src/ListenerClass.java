import java.util.Stack;

public class ListenerClass extends LITTLEBaseListener {

    //Stack<SymbolTable> tables;
    //int counter = 0;

    //LinkedHashMap<String,String> currentSymbolTable;
    //Stack<LinkedHashMap<String,String>> symbolTables;
    //Stack<String> symbolTableNames;
    int blockNum;
    SymbolTable current;
    Stack<SymbolTable> tables;

    public ListenerClass(){
        tables = new Stack<>();
        blockNum = 1;
    }

    //TODO: Implement all methods that would have their own scope
    //TODO: Create a stack of scopes

    @Override
    public void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx){
        // Create symbol table
        createSymbolTable("GLOBAL");
    }

    @Override
    public void enterIf_stmt(LITTLEParser.If_stmtContext ctx){
        // Create symbol table
        createBlockSymbolTable();
    }

    @Override
    public void enterFunc_decl(LITTLEParser.Func_declContext ctx){
        // Create symbol table
        createSymbolTable(ctx.id().getText());
    }

    @Override
    public void enterElse_part(LITTLEParser.Else_partContext ctx){
        if(ctx.decl() != null){
            createBlockSymbolTable();
        }
    }

    @Override
    public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx){
        // Create symbol table
        createBlockSymbolTable();
    }

    @Override
    public void enterString_decl(LITTLEParser.String_declContext ctx){
        insertSymbolTableStr(ctx.id().getText(), ctx.children.get(0).getText(), ctx.str().getText());
    }

    @Override
    public void enterVar_decl(LITTLEParser.Var_declContext ctx){
        String varType = ctx.var_type().getText();
        insertSymbolTableVar(ctx.id_list().id().getText(), varType);
        LITTLEParser.Id_tailContext idlctx = ctx.id_list().id_tail();
        while(idlctx.id() != null){
            insertSymbolTableVar(idlctx.id().getText(), varType);
            idlctx = idlctx.id_tail();
        }
    }

    @Override
    public void enterParam_decl_list(LITTLEParser.Param_decl_listContext ctx){
        if(ctx.param_decl() != null) {
            String varType = ctx.param_decl().var_type().getText();
            String name = ctx.param_decl().id().getText();
            insertSymbolTableVar(name, varType);
            LITTLEParser.Param_decl_tailContext pdtctx = ctx.param_decl_tail();
            while (pdtctx.param_decl() != null) {
                varType = pdtctx.param_decl().var_type().getText();
                name = pdtctx.param_decl().id().getText();
                insertSymbolTableVar(name, varType);
                pdtctx = pdtctx.param_decl_tail();
            }
        }
    }

    private void insertSymbolTableVar(String name, String type){
        if(current.values.containsKey(name)){
            System.out.println("DECLARATION ERROR "+name);
            System.exit(-1);
        } else {
            current.values.put(name, "type "+type);
        }
    }

    private void insertSymbolTableStr(String name, String type, String val){
        if(current.values.containsKey(name)){
            System.out.println("DECLARATION ERROR "+name);
            System.exit(-1);
        } else {
            current.values.put(name, "type "+type+" value "+val);
        }
    }

    private void createSymbolTable(String name){
        tables.push(new SymbolTable(name));
        current = tables.peek();
    }

    private void createBlockSymbolTable(){
        // Push new symbol table on stack
        String name = "BLOCK "+this.blockNum;
        createSymbolTable(name);
        this.blockNum++;
    }

    public void printSymbolTables(){
        Stack<String> tempStack = new Stack<>();
        while(!tables.empty()){
            Stack<String> tempStack2 = new Stack<>();
            SymbolTable temp = tables.pop();
            temp.values.forEach((k,v)-> tempStack2.push("name "+k+" "+v));

            while(!tempStack2.empty()){
                tempStack.push(tempStack2.pop());
            }
            tempStack.push("Symbol table " + temp.name);
        }
        while(!tempStack.empty()){
            System.out.println(tempStack.pop());
        }
    }


}