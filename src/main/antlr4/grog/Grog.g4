grammar Grog;

program: function* expression?;

function:  FUNC name=IDENTIFIER lambda;

block: expression;

expression
    : left=expression POWER<assoc=right> right=expression #PowerExpr
    | left=expression (TIMES | DIV) right=expression #TimesExpr
    | left=expression (PLUS | MINUS) right=expression #PlusExpr
    | left=expression (GREATER | LESS | GREATER_OR_EQUAL | LESS_OR_EQUAL | EQUAL | DIFFERENT) right=expression #ComparisonExpr
    | left=expression (AND | OR) right=expression #BooleanExpr
    | NOT value=expression #NegativeExpr
    | name=IDENTIFIER LPAREN parameters+=expression (COMMA parameters+=expression)? RPAREN #FunctionCallExpr
    | value=lambda #LambdaExpr
    | value=IDENTIFIER #ReferenceExpr
    | value=NUMBER #NumberExpr
    ;

lambda: LPAREN (parameters+=parameter (COMMA parameters+=parameter)* )? RPAREN ASSIGN expression;

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
AND: '&';
OR: '|';
IDENTIFIER: VALID_ID_START VALID_ID_CHAR*;
NUMBER: DIGIT+ ('.' DIGIT+)?;
fragment VALID_ID_START: ('a' .. 'z') | ('A' .. 'Z') | '_';
fragment VALID_ID_CHAR: VALID_ID_START | DIGIT;
fragment DIGIT: '0' .. '9';

WS: [ \r\n\t] + -> skip;
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);