grammar alex;
/* Expressions*/
expr: expr_prefix factor;
expr_prefix: (expr_prefix factor addop) | '';
factor: factor_prefix postfix_expr;
factor_prefix: factor_prefix factor addop | '';
postfix_expr: primary | call_expr;
call_expr: id '(' expr_list ')';
expr_list: expr expr_list_tail | '';
expr_list_tail: ',' expr expr_list_tail | '';
primary: '(' expr ')' | id | INTLITERAL | FLOATLITERAL;
addop: '+' | '-';
mulup: '*' | '/';

/* Complex Statements and Condition */
if_stmt: IF '(' cond ')' decl stmt_list else_part ENDIF;
else_part: ELSE decl stmt_list | empty;
cond: expr compop expr;
compop: '<' | '>' | '=' | '!=' | '<=' | '>=';

/* While statements */
while_stmt: WHILE '(' cond ')' decl stmt_list ENDWHILE;