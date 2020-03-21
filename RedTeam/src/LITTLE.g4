/* Define grammar called LITTLE */

grammar LITTLE;
PROGRAM: 'PROGRAM';
BEGIN: 'BEGIN';
END: 'END';
FUNCTION: 'FUNCTION';
WRITE: 'WRITE';
IF: 'IF';
ELSE: 'ELSE';
ENDIF: 'ENDIF';
WHILE: 'WHILE';
ENDWHILE: 'ENDWHILE';
CONTINUE: 'CONTINUE';
BREAK: 'BREAK';
RETURN: 'RETURN';
INT: 'INT';
VOID: 'VOID';
STRING: 'STRING';
FLOAT: 'FLOAT';
READ: 'READ';

KEYWORD : ( PROGRAM | BEGIN | END | FUNCTION | WRITE | IF | ELSE | ENDIF | WHILE | ENDWHILE | CONTINUE | BREAK | RETURN | INT | VOID | STRING | FLOAT | READ);

// Spaces, return, tab, and new lines characters
WS : [ \r\t\n]+ -> skip; // skip spaces, tabs, newlines

SEMICOLON_OP: ';';
ASSIGN_OP: ':=';
PLUS_OP: '+';
MINUS_OP: '-';
STAR_OP: '*';
FSLASH_OP: '/';
EQ_OP: '=';
NOTEQ_OP: '!=';
LT_OP: '<';
GT_OP: '>';
OPEN_PARAN_OP: '(';
CLOSE_PARAN_OP: ')';
COMMA_OP: ',';
LT_EQ_OP: '<=';
GT_EQ_OP: '>=';
// Operator tokens
OPERATOR : ASSIGN_OP | PLUS_OP | MINUS_OP | STAR_OP | FSLASH_OP | EQ_OP | NOTEQ_OP | LT_OP | GT_OP | OPEN_PARAN_OP | CLOSE_PARAN_OP | SEMICOLON_OP | COMMA_OP | LT_EQ_OP | GT_EQ_OP;

//integer number
INTLITERAL : [0-9]+;

//floating point number available in two different format
FLOATLITERAL : [0-9]*'.'[0-9]*;

//any sequence of characters except '"'
STRINGLITERAL : ["](.)*?["];

//Starts with "--" and lasts till the end of line
COMMENT : '--'(.)*?[\n] -> skip;

// Identifier tokens
IDENTIFIER : ([a-zA-Z])+([a-zA-Z0-9])*;

program: PROGRAM id BEGIN pgm_body END;
id: IDENTIFIER;
decl: string_decl decl | var_decl decl | ;
string_decl: STRING id ASSIGN_OP str SEMICOLON_OP;
str: STRINGLITERAL;
pgm_body: decl func_declarations;

/* Variable Declaration */
var_decl: var_type id_list SEMICOLON_OP;
var_type: FLOAT | INT;
any_type: var_type | VOID ;
id_list: id id_tail;
id_tail: COMMA_OP id id_tail | ;

/* Function Declarations */
func_declarations: func_decl func_declarations | ;
func_decl: FUNCTION any_type id OPEN_PARAN_OP param_decl_list CLOSE_PARAN_OP BEGIN func_body END;
func_body: decl stmt_list;

/* Function Paramater List */
param_decl_list: param_decl param_decl_tail | ;
param_decl: var_type id;
param_decl_tail: COMMA_OP param_decl param_decl_tail | ;

/* Statement List */
stmt_list: stmt stmt_list | ;
stmt: base_stmt | if_stmt | while_stmt;
base_stmt: assign_stmt | read_stmt | write_stmt | return_stmt;

/* Basic Statements */
assign_stmt: assign_expr SEMICOLON_OP;
assign_expr: id ASSIGN_OP expr;
read_stmt: READ OPEN_PARAN_OP id_list CLOSE_PARAN_OP SEMICOLON_OP;
write_stmt: WRITE OPEN_PARAN_OP id_list CLOSE_PARAN_OP SEMICOLON_OP;
return_stmt: RETURN expr SEMICOLON_OP;

mulop: STAR_OP | FSLASH_OP;
expr: expr_prefix factor;
expr_prefix: expr_prefix factor addop | ;
factor: factor_prefix postfix_expr;
factor_prefix: factor_prefix postfix_expr mulop | ;
postfix_expr: primary | call_expr;
call_expr: id OPEN_PARAN_OP expr_list CLOSE_PARAN_OP;
expr_list: expr expr_list_tail | ;
expr_list_tail: COMMA_OP expr expr_list_tail | ;
primary: OPEN_PARAN_OP expr CLOSE_PARAN_OP | id | INTLITERAL | FLOATLITERAL;
addop: PLUS_OP | MINUS_OP;

/* Complex Statements and Condition */
if_stmt: IF OPEN_PARAN_OP cond CLOSE_PARAN_OP decl stmt_list else_part ENDIF;
else_part: ELSE decl stmt_list | ;
cond: expr compop expr;
compop: LT_OP | GT_OP | EQ_OP | NOTEQ_OP | LT_EQ_OP | GT_EQ_OP;

/* While statements */
while_stmt: WHILE OPEN_PARAN_OP cond CLOSE_PARAN_OP decl stmt_list ENDWHILE;


