grammar Grog;

program: function*;

function: 'func' name=IDENTIFIER lambda ';';

lambda: '(' (parameters+=parameter (',' parameters+=parameter)* )?')' '<-' ;

parameter: name=IDENTIFIER ':' type=IDENTIFIER;

IDENTIFIER: VALID_ID_START VALID_ID_CHAR*;
fragment VALID_ID_START: ('a' .. 'z') | ('A' .. 'Z') | '_';
fragment VALID_ID_CHAR: VALID_ID_START | DIGIT;
fragment DIGIT: '0' .. '9';
WS: [ \r\n\t] + -> skip;