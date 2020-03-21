import java.util.Stack;

public class LittleListener extends LITTLEBaseListener {

    Stack<SymbolTable> tables;

    //TODO: Implement all methods that would have their own scope
    //TODO: Create a stack of scopes
    // I don't think this is all of them.. I'm not sure.
    public LittleListener(){
        tables = new Stack<SymbolTable>();
    }

    @Override public void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx) {
        SymbolTable table = new SymbolTable("Global");
        tables.push(table);
    }

    @Override public void enterVar_decl(LITTLEParser.Var_declContext ctx) {
        // Add the token to the top of the current stack
        tables.peek().values.put(ctx.var_type().getText(), ctx.toString());
    }

    @Override public void enterFunc_body(LITTLEParser.Func_bodyContext ctx) {
        // Create a new table for this scope
        SymbolTable cur = new SymbolTable("TABLE: " + ctx.getText());
    }

    @Override public void enterIf_stmt(LITTLEParser.If_stmtContext ctx) {
        // Create a new table for this scope
        SymbolTable cur = new SymbolTable("TABLE: " + ctx.getText());
    }

    @Override public void enterElse_part(LITTLEParser.Else_partContext ctx) {
        // Create a new table for this scope
        SymbolTable cur = new SymbolTable("TABLE: " + ctx.getText());
    }

    @Override public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx) {
        // Create a new table for this scope
        SymbolTable cur = new SymbolTable("TABLE: " + ctx.getText());
    }


}