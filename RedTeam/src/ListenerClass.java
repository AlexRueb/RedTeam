import java.util.Stack;

public class ListenerClass extends LITTLEBaseListener {

    int blockNum;
    SymbolTable current;
    Stack<SymbolTable> tables;

    public ListenerClass(){
        tables = new Stack<>();
        blockNum = 1;
    }

    @Override
    public void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx){
        createSymbolTable("GLOBAL");
    }

    @Override
    public void enterIf_stmt(LITTLEParser.If_stmtContext ctx){
        createNewSymbolTable();
    }

    @Override
    public void enterFunc_decl(LITTLEParser.Func_declContext ctx){
        createSymbolTable(ctx.id().getText());
    }

    @Override
    public void enterElse_part(LITTLEParser.Else_partContext ctx){
        if(ctx.decl() != null){
            createNewSymbolTable();
        }
    }

    @Override
    public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx){
        createNewSymbolTable();
    }

    @Override
    public void enterString_decl(LITTLEParser.String_declContext ctx){
        insertStr(ctx.id().getText(), ctx.children.get(0).getText(), ctx.str().getText());
    }

    @Override
    public void enterAssign_expr(LITTLEParser.Assign_exprContext ctx) {

    }

    @Override
    public void enterId(LITTLEParser.IdContext ctx) {

    }

    @Override
    public void enterVar_decl(LITTLEParser.Var_declContext ctx){
        String varType = ctx.var_type().getText();
        insertVar(ctx.id_list().id().getText(), varType);
        LITTLEParser.Id_tailContext tailCtx = ctx.id_list().id_tail();
        while(tailCtx.id() != null){
            insertVar(tailCtx.id().getText(), varType);
            tailCtx = tailCtx.id_tail();
        }

    }

    @Override
    public void enterParam_decl_list(LITTLEParser.Param_decl_listContext ctx){
        if(ctx.param_decl() != null) {
            String varType = ctx.param_decl().var_type().getText();
            String name = ctx.param_decl().id().getText();
            insertVar(name, varType);
            LITTLEParser.Param_decl_tailContext tailCtx = ctx.param_decl_tail();
            while (tailCtx.param_decl() != null) {
                varType = tailCtx.param_decl().var_type().getText();
                name = tailCtx.param_decl().id().getText();
                insertVar(name, varType);
                tailCtx = tailCtx.param_decl_tail();
            }
        }
    }

    private void insertVar(String name, String type){
        if(current.values.containsKey(name)){
            System.out.println("DECLARATION ERROR " + name);
            System.exit(-1);
        } else {
            current.values.put(name, "type " + type);
        }
    }

    private void insertStr(String name, String type, String val){
        if(current.values.containsKey(name)){
            System.out.println("DECLARATION ERROR " + name);
            System.exit(-1);
        } else {
            current.values.put(name, "type " + type + " value " + val);
        }
    }

    private void createSymbolTable(String name){
        tables.push(new SymbolTable(name));
        current = tables.peek();
    }

    private void createNewSymbolTable(){
        // Push new symbol table on stack
        String name = "BLOCK " + blockNum;
        createSymbolTable(name);
        blockNum++;
    }

    public void printSymbolTables(){
        Stack<String> tempStack = new Stack<>();
        while(!tables.empty()){
            Stack<String> tempStack2 = new Stack<>();
            SymbolTable temp = tables.pop();
            temp.values.forEach((k, v) ->
                    tempStack2.push("name " + k + " " + v));

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