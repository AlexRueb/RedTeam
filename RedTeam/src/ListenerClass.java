import java.util.ArrayList;
import java.util.Stack;

public class ListenerClass extends LITTLEBaseListener {

    int blockNum;
    SymbolTable current;
    Stack<SymbolTable> tables;
    ArrayList<ASTNode> ast = new ArrayList<ASTNode>();
    int temp = 0;
    public enum IdType {
        FUNC, FLOAT, STRING, INT, NONE;
    }
    IdType curId = IdType.NONE;

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
        curId = IdType.FUNC;

        ast.add(new ASTNode("LABEL",ctx.id().getText(),"",""));
    }

    @Override
    public void exitFunc_decl(LITTLEParser.Func_declContext ctx)
    {
        curId = IdType.NONE;
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
        curId = IdType.STRING;
    }

    @Override
    public void enterAssign_expr(LITTLEParser.Assign_exprContext ctx) {
        int value = temp;

        ast.addAll(buildExpression(ctx.expr().getText()));

        String s = getTypeFromSymbolTable(ctx.id().getText());

        if(temp == value){
            ast.add(new ASTNode("STORE" + s.charAt(0), ctx.expr().getText(), "", ctx.id().getText()));
        }
        else{
            ast.add(new ASTNode("STORE" + s.charAt(0), "T"+temp, "", ctx.id().getText()));
        }
    }

    @Override
    public void enterId(LITTLEParser.IdContext ctx) {
        switch(curId){
            case FUNC:
                curId = IdType.NONE;
                break;
            case STRING: case INT: case FLOAT:
                break;
            case NONE:
                break;
        }
    }

    @Override public void enterWrite_stmt(LITTLEParser.Write_stmtContext ctx)
    {
        String[] ids = ctx.id_list().getText().split(",");
        for(String id : ids){
            switch(getTypeFromSymbolTable(id)){
                case "STRING" :
                    ast.add(new ASTNode("WRITES",id,"",""));
                    break;
                case "INT" :
                    ast.add(new ASTNode("WRITEI",id,"",""));
                    break;
                case "FLOAT" :
                    ast.add(new ASTNode("WRITEF",id,"",""));
                    break;
            }
        }
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
    public void enterVar_type(LITTLEParser.Var_typeContext ctx)
    {
        if(curId != IdType.FUNC){
            if(ctx.getText().equals("INT")){
                curId = IdType.INT;
            }
            else if(ctx.getText().equals("FLOAT")){
                curId = IdType.FLOAT;
            }
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

    @Override public void enterRead_stmt(LITTLEParser.Read_stmtContext ctx)
    {
        String[] ids = ctx.id_list().getText().split(",");
        for(String id : ids){
            Stack<SymbolTable> temp = tables;
            for(int i = 0; i < temp.size(); i++){
                SymbolTable var = temp.pop();
                for(int k = 0; k < var.values.size(); k++) {
                    switch(var.values.get(k)){
                        case "STRING" :
                            ast.add(new ASTNode("READS",id,"",""));
                            break;
                        case "INT" :
                            ast.add(new ASTNode("READI",id,"",""));
                            break;
                        case "FLOAT" :
                            ast.add(new ASTNode("READF",id,"",""));
                            break;
                    }
                }
            }
        }
    }

    @Override
    public void exitString_decl(LITTLEParser.String_declContext ctx)
    {
        curId = IdType.NONE;
    }

    @Override public void exitVar_decl(LITTLEParser.Var_declContext ctx)
    {
        curId = IdType.NONE;
    }

    @Override public void exitParam_decl(LITTLEParser.Param_declContext ctx)
    {
        curId = IdType.NONE;
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

    private ArrayList<ASTNode> buildExpression(String expr)
    {
        String type = null;
        String[] ids = expr.split("\\+|\\-|\\*|\\/");
        String id = ids[0];
        id = id.replaceAll(" ","");
        id = id.replaceAll("[()]", "");
        type = getTypeFromSymbolTable(id);
        if(type != "INT" && type != "FLOAT"){
            if(id.contains(".")){
                type = "FLOAT";
            }
            else{
                type = "INT";
            }
        }

        ArrayList<ASTNode> exprIR = new ArrayList<ASTNode>();
        if(expr.contains("(")){
            int paren = 0;
            int sIndex = -1;
            for(int i = 0; i < expr.length(); i++)
            {
                if(expr.charAt(i) == '('){
                    if(paren==0){
                        sIndex = i;
                    }
                    paren++;
                }
                else if(expr.charAt(i) == ')')
                {
                    paren--;
                }
                if(sIndex != -1 && paren == 0)
                {
                    exprIR.addAll(buildExpression(expr.substring(sIndex+1, i)));
                    expr = expr.substring(0,sIndex) + "T" + temp + expr.substring(i+1,expr.length());
                    i=0;
                    sIndex = -1;
                }
            }
        }
        int sIndex = 0, mulIndex = -1;
        for(int i = 0; i < expr.length(); i++)
        {
            if(expr.charAt(i) == '*' || expr.charAt(i) == '/' || expr.charAt(i) == '+' || expr.charAt(i) == '-' || (i == expr.length()-1 && mulIndex != -1))
            {
                if(expr.charAt(i) == '*' || expr.charAt(i) == '/')
                {
                    mulIndex = i;
                }
                else if(mulIndex == -1)
                {
                    sIndex = i+1;
                }
                else{
                    if(i == expr.length()-1)
                    {
                        exprIR.add(makeIRMul(expr.substring(sIndex, mulIndex),expr.charAt(mulIndex),expr.substring(mulIndex+1, i+1),type));
                        expr = expr.substring(0,sIndex) + "T" + temp + expr.substring(i+1,expr.length());
                    }
                    else
                    {
                        exprIR.add(makeIRMul(expr.substring(sIndex, mulIndex),expr.charAt(mulIndex),expr.substring(mulIndex+1, i),type));
                        expr = expr.substring(0,sIndex) + "T" + temp + expr.substring(i,expr.length());
                    }
                    i=0;
                    mulIndex = -1;
                    sIndex = 0;
                }
            }
        }

        int addIndex = -1;
        for(int i = 0; i < expr.length(); i++)
        {
            if(expr.charAt(i) == '+' || expr.charAt(i) == '-' || (i == expr.length()-1 && addIndex != -1))
            {
                if(addIndex == -1){
                    addIndex = i;
                }
                else
                {
                    if(i == expr.length()-1)
                    {
                        exprIR.add(makeIRAdd(expr.substring(0, addIndex),expr.charAt(addIndex),expr.substring(addIndex+1, i+1),type));
                        expr = expr.substring(0,0) + "T" + temp + expr.substring(i+1,expr.length());
                    }
                    else
                    {
                        exprIR.add(makeIRAdd(expr.substring(0, addIndex),expr.charAt(addIndex),expr.substring(addIndex+1, i), type));
                        expr = expr.substring(0,0) + "T" + temp + expr.substring(i,expr.length());
                    }
                    i=0;
                    addIndex = -1;
                }
            }
        }
        return exprIR;
    }

    public ASTNode makeIRAdd(String val1, char op, String val2, String type)
    {
        ASTNode exprIR = null;
        val1.replace(" ", "");
        val2.replace(" ", "");
        if(op == '+'){
            temp++;
            exprIR=new ASTNode("ADD" + type.charAt(0),val1,val2,"T"+temp);
        }
        else if(op == '-'){
            temp++;
            exprIR=new ASTNode("SUB" + type.charAt(0),val1,val2,"T"+temp);
        }
        return exprIR;
    }

    public ASTNode makeIRMul(String val1, char op, String val2, String type)
    {
        ASTNode exprIR = null;
        val1.replace(" ", "");
        val2.replace(" ", "");
        if(op == '*'){
            temp++;
            exprIR=new ASTNode("MULT" + type.charAt(0),val1,val2,"T"+temp);
        }
        else if(op == '/'){
            temp++;
            exprIR=new ASTNode("DIV" + type.charAt(0),val1,val2,"T"+temp);
        }
        return exprIR;
    }

    public ASTNode makeIRCond(String exp1, String op, String exp2, String label)
    {
        ASTNode condIR =null;
        String oper = "";
        switch(op){
            case "!=":
                oper = "EQ";
                break;
            case "=":
                oper = "NE";
                break;
            case ">=":
                oper = "LT";
                break;
            case "<=":
                oper = "GT";
                break;
            case ">":
                oper = "LE";
                break;
            case "<":
                oper = "GE";
                break;
        }
        condIR = new ASTNode(oper,exp1,exp2,label);
        return condIR;
    }

    public String getTypeFromSymbolTable(String var){
        Stack<SymbolTable> temp = tables;
        for(int i = 0; i < temp.size(); i++){
            SymbolTable variable = temp.pop();
            for(int k = 0; k < variable.values.size(); k++) {
                if (variable.values.get(var).equals(var)) {
                    return variable.values.get(var);
                }
            }
        }
        return null;
    }
}