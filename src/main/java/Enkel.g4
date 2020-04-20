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
forCondition : iterator=varRef 'in' left=expression'..'right=expression;
expressionList : expression (',' expression)* ;
expression :
            varRef #VARREFERENCE
           | val #VALUE
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

varRef : ID ;
val : NUMBER
      | STRING ;

//lexer rules (tokens)
VARIABLE : 'val' ;
PRINT : 'println' ;
EQUALS : '=' ;
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z0-9]+ ;
WS: [ \t\n\r]+ -> skip ;