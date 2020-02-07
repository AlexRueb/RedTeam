// Define grammar called LITTLE
grammar justin;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

/* Program */
program : 'PROGRAM' id 'BEGIN' pgm_body 'END';

id : IDENTIFIER;
IDENTIFIER : ([A-Z]|[a-z]);
pgm_body :  'pgm_body'; //decl func_declarations;

//decl : string_decl decl | var_decl decl | empty;

