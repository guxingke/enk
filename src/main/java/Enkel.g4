//header
grammar Enkel;

//parser rules
compilationUnit : ( blockStatement )* EOF;
blockStatement : variableDeclaration
               | printStatement
               | expressionList ;
variableDeclaration : VARIABLE name EQUALS expression;
name : ID ;
printStatement : PRINT expression ;
expressionList : expression (',' expression)* ;
expression :
            varReference #VARREFERENCE
           | value        #VALUE
           |  '('expression '*' expression')' #MULTIPLY
           | expression '*' expression  #MULTIPLY
           | '(' expression '/' expression ')' #DIVIDE
           | expression '/' expression #DIVIDE
           | '(' expression '+' expression ')' #ADD
           | expression '+' expression #ADD
           | '(' expression '-' expression ')' #SUBSTRACT
           | expression '-' expression #SUBSTRACT
           ;

varReference: ID ;
value : NUMBER
      | STRING ;

//lexer rules (tokens)
VARIABLE : 'val' ;
PRINT : 'print' ;
EQUALS : '=' ;
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z0-9]+ ;
WS: [ \t\n\r]+ -> skip ;