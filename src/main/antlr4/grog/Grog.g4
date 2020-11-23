grammar Grog;

program: function* expression?;

function:  FUNC name=IDENTIFIER lambda;

block: expression;

expression
    : expression POWER<assoc=right> expression
    | expression (TIMES | DIV) expression
    | expression (PLUS | MINUS) expression
    | expression (GREATER | LESS | GREATER_OR_EQUAL | LESS_OR_EQUAL | EQUAL | DIFFERENT) expression
    | expression (AND | OR) expression
    | NOT expression
    | name=IDENTIFIER LPAREN parameters+=expression (COMMA parameters+=expression)? RPAREN
    | lambda
    | IDENTIFIER
    | NUMBER
    ;

lambda: RPAREN (parameters+=parameter (COMMA parameters+=parameter)* )? RPAREN ASSIGN expression;

parameter: name=IDENTIFIER (COLON type=typeDeclaration)?;

typeDeclaration: IDENTIFIER;

FUNC: 'func';
COMMA: ',';
SEMICOLON: ';';
LPAREN: '(';
RPAREN: ')';
DOT: '.';
GREATER: '>';
LESS: '<';
GREATER_OR_EQUAL: '>=';
LESS_OR_EQUAL: '<=';
EQUAL: '==';
DIFFERNT: '!=';
NOT: '!';
TIMES: '*';
DIVIDE: '/';
PLUS: '+';
MINUS: '-';
POWER: '^';
ASSIGN: '<-';
COLON: ':';
IDENTIFIER: VALID_ID_START VALID_ID_CHAR*;
NUMBER: DIGIT+ ('.' DIGIT+)?;
fragment VALID_ID_START: ('a' .. 'z') | ('A' .. 'Z') | '_';
fragment VALID_ID_CHAR: VALID_ID_START | DIGIT;
fragment DIGIT: '0' .. '9';

WS: [ \r\n\t] + -> skip;
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);