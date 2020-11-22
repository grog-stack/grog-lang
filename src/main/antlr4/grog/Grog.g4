grammar Grog;

program: function* expression?;

function: 'func' name=IDENTIFIER lambda;

block: expression;

expression
    : expression '^'<assoc=right> expression
    | expression ('*' | '/') expression
    | expression ('+' | '-') expression
    | expression ('>' | '<' | '>=' | '<=' | '=='| '!=') expression
    | expression ('&' | '|') expression
    | '!' expression
    | name=IDENTIFIER '(' parameters+=expression (',' parameters+=expression)? ')'
    | lambda
    | IDENTIFIER
    | NUMBER
    ;

lambda: '(' (parameters+=parameter (',' parameters+=parameter)* )? ')' '<-' expression;

parameter: name=IDENTIFIER (':' type=typeDeclaration)?;

typeDeclaration: IDENTIFIER;

FUNC: 'func';
COMMA: ',';
SEMICOLON: ';';
LPAREN: '(';
RPAREN: ')';
DOT: '.';
GREATER_THAN: '>';
LESS_THAN: '<';
GREATER_THAN_OR_EQUAL_TO: '>=';
LESS_THAN_OR_EQUAL_TO: '<=';
EQUAL_TO: '==';
DIFFERNT_FROM: '!=';
NOT: '!';
TIMES: '*';
DIVIDE: '/';
PLUS: '+';
MINUS: '-';
POWER: '^';
IDENTIFIER: VALID_ID_START VALID_ID_CHAR*;
NUMBER: DIGIT+ ('.' DIGIT+)?;
fragment VALID_ID_START: ('a' .. 'z') | ('A' .. 'Z') | '_';
fragment VALID_ID_CHAR: VALID_ID_START | DIGIT;
fragment DIGIT: '0' .. '9';
WS: [ \r\n\t] + -> skip;