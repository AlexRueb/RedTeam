/* Define grammar called LITTLE */

grammar justin;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
CAPS :[A-Z]+;

/* Program */
program : PROGRAM id BEGIN pgm_body END;
id : IDENTIFIER;
IDENTIFIER : ([A-Z]|[a-z])+([A-Z]|[a-z]|[0-9])*;
pgm_body :  decl func_declarations;
decl : string_decl decl | var_decl decl | '';

/* Global String Declaration */
string_decl : STRING id ':=' str;
str : STRINGLITERAL;

/* Variable Declaration */
var_decl : var_type id_list ;
var_type : FLOAT | INT;
any_type : var_type | VOID ;
id_list : id id_tail;
id_tail : id id_tail | '';

/* Function Declarations */
func_declarations : func_decl func_declarations | '';
func_decl : FUNCTION any_type id (param_decl_list) BEGIN func_body END;
func_body : decl stmt_list;

/* Function Paramater List */
param_decl_list : param_decl param_decl_tail | '';
param_decl : var_type id;
param_decl_tail : param_decl param_decl_tail | '';

/* Statement List */
stmt_list : stmt stmt_list | '';
stmt : base_stmt | if_stmt | while_stmt;
base_stmt : assign_stmt | read_stmt | write_stmt | return_stmt;

/* Basic Statements */
assign_stmt : assign_expr ;
assign_expr : id ':=' expr;
read_stmt : READ ( id_list );
write_stmt  : WRITE ( id_list );
return_stmt  : RETURN expr ;