/* Define grammar called LITTLE */

grammar LITTLE;

KEYWORD : ('PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'WRITE' | 'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' | 'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT' | 'READ');

// Spaces, return, tab, and new lines characters
WS : [ \r\t\n]+ -> skip; // skip spaces, tabs, newlines

// Operator tokens
OPERATOR : (':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' | ';' | ',' | '<=' | '>=');

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


