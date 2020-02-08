grammar bridget;

KEYWORDS : ['PROGRAM', 'BEGIN', 'END', 'FUNCTION', 'WRITE', 'IF', 'ELSE', 'ENDIF', 'WHILE', 'ENDWHILE', 'CONTINUE', 'BREAK','RETURN', 'INT', 'VOID', 'STRING', 'FLOAT'];
OPERATORS : [':=', '+', '-', '*', '/', '=', '!=', '<', '>', '(', ')', ';', ',', '<=', '>='];
//integer number
INTLITERAL : [0-9]+;

//floating point number available in two different format
FLOATLITERAL : [0-9]*.[0-9]*;

//any sequence of characters except '"'
STRINGLITERAL : '"'[.*!'|!"*]+'"';

//Starts with "--" and lasts till the end of line
COMMENT : [--][.*][\n];

