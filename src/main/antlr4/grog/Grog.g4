grammar Grog;

program: (type |function)* expression?;

type: 
    TYPE name=IDENTIFIER ASSIGN (
        functions+=function
        | LBRACE (functions+=function)+ RBRACE
    )
    ;

function:  FUNC name=IDENTIFIER lambda;

expression
    : left=expression POWER<assoc=right> right=expression #PowerExpr
    | left=expression (operator=TIMES | operator=DIVIDE) right=expression #TimesExpr
    | left=expression (operator=PLUS | operator=MINUS) right=expression #PlusExpr
    | left=expression (operator=GREATER | operator=LESS | operator=GREATER_OR_EQUAL | operator=LESS_OR_EQUAL | EQUAL | DIFFERENT) right=expression #ComparisonExpr
    | left=expression (operator=AND | operator=OR) right=expression #BooleanExpr
    | NOT value=expression #NegativeExpr
    | functionCall #FunctionCallExpr
    | value=lambda #LambdaExpr
    | atom #AtomExpr
    ;

functionCall
    : name=IDENTIFIER LPAREN parameters+=expression (COMMA parameters+=expression)? RPAREN
    ;

atom
    : value=IDENTIFIER #ReferenceExpr
    | value=NUMBER #NumberExpr
    | value=BOOLEAN #BooleanLiteralExpr
    ;

lambda: LPAREN (parameters+=parameter (COMMA parameters+=parameter)* )? RPAREN ASSIGN expression;

parameter: name=IDENTIFIER (COLON typeDecl=typeDeclaration)?;

typeDeclaration: IDENTIFIER;

TYPE: 'type';
LBRACE: '{';
RBRACE: '}';
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
DIFFERENT: '!=';
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
BOOLEAN: 'true' | 'false';
IDENTIFIER: VALID_ID_START VALID_ID_CHAR*;
NUMBER: DIGIT+ ('.' DIGIT+)?;
fragment VALID_ID_START: ('a' .. 'z') | ('A' .. 'Z') | '_';
fragment VALID_ID_CHAR: VALID_ID_START | DIGIT;
fragment DIGIT: '0' .. '9';

WS: [ \r\n\t] + -> skip;
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);