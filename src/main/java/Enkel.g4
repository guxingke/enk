//header
grammar Enkel;

//parser rules
compilationUnit : ( function )* EOF;

function: 'fun' 'main' '(' ')' block ;

block : '{' statement* '}' ;

statement : block
   | variableDeclaration
   | printStatement
   | expressionList
   | ifStatement
   | forStatement
 ;
variableDeclaration : VARIABLE name EQUALS expression;
name : ID ;
printStatement : PRINT '(' expression ')';
ifStatement :  'if'  ('(')? expression (')')? trueStatement=statement ('else' falseStatement=statement)?;
forStatement : 'for' ('(')? forCondition (')')? statement;
forCondition : iterator=varReference 'in' left=expression'..'right=expression;
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
           | expression cmp='>' expression #conditionalExpression
           | expression cmp='<' expression #conditionalExpression
           | expression cmp='==' expression #conditionalExpression
           | expression cmp='!=' expression #conditionalExpression
           | expression cmp='>=' expression #conditionalExpression
           | expression cmp='<=' expression #conditionalExpression
           ;

varReference: ID ;
value : NUMBER
      | STRING ;

//lexer rules (tokens)
VARIABLE : 'val' ;
PRINT : 'println' ;
EQUALS : '=' ;
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z0-9]+ ;
WS: [ \t\n\r]+ -> skip ;