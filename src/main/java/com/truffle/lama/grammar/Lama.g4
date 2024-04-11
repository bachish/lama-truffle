grammar Lama;

/**
* KEYWORDS
**/
WHITESPACES: [ \t\r\n\u000C]+ -> skip;
AFTER: 'after';
ARRAY: 'array';
AT: 'at';
BEFORE: 'before';
BOX: 'box';
CASE: 'case';
DO: 'do';
ELIF: 'elif';
ELSE: 'else';
ESAC: 'esac';
ETA: 'eta';
FALSE: 'false';
FI: 'fi';
FOR: 'for';
FUN: 'fun';
IF: 'if';
IMPORT: 'import';
INFIXL: 'infixl';
INFIXR: 'infixr';
LAZY: 'lazy';
OD: 'od';
OF: 'of';
PUBLIC: 'public';
SEXP: 'sexp';
SKIP_: 'skip';
STR: 'str';
SYNTAX: 'syntax';
THEN: 'then';
TRUE: 'true';
VAL: 'val';
VAR: 'var';
WHILE: 'while';
INFIX : '!!'|'+'|'*'|'/'|'%'|'$'|'#'|'@'|'!'|'&'|'ˆ'|'?'|'<'|'>'|':='|'-';
UIDENT : [A-Z][a-zA-Z0-9]*;
LIDENT : [a-z][a-zA-Z0-9]*;
DECIMAL : '-'?[0-9]+;
STRING : '"' (~'"' | '""')* '"';
CHAR : [a-z][A-Z];


lama_import : IMPORT UIDENT ';';
compilationUnit : lama_import* scopeExpression;
scopeExpression : definition* seqExpression?;
definition
        : variableDefinitions
        | functionDefinition
        ;

variableDefinitions: (VAR | PUBLIC) variableDefinitionItem ( ',' variableDefinitionItem )* ';' ;
variableDefinitionItem : LIDENT ( '=' binaryExpression )?;
functionDefinition :
    PUBLIC?  FUN LIDENT '(' functionArguments ')' functionBody;
functionArguments : (LIDENT ( ',' LIDENT )*)?;
functionBody : '{' scopeExpression '}';

/**
EXPRESSIONS
**/

seqExpression : binaryExpression ( ';' seqExpression )?;
binaryExpression
        : left=binaryOperand INFIX right=binaryOperand      #binaryOperation
        | binaryOperand                                     #unaryOperation
        ;
binaryOperand : '-'? postfixExpression;

postfixExpression
        : primary
        | postfixExpression '(' ( seqExpression ( ',' seqExpression )* )? ')'
        | postfixExpression '[' seqExpression ']';

primary : DECIMAL                                       #decimal
        | STRING                                        #str
        | CHAR                                          #char
        | TRUE                                          #true
        | FALSE                                          #false
        | FUN '(' functionArguments ')' functionBody     #fun
        | SKIP_                                          #skip
        | '(' scopeExpression ')'                        #scope
        | listExpression                                 #list
        | arrayExpression                                #array
        | sExpression                                    #sexp
        | ifExpression                                   #ifexp
        | whileDoExpression                              #while
        | doWhileExpression                              #dowhile
        | forExpression                                  #for
        | caseExpression                                 #case
        | LIDENT                                        #lident
        ;

arrayExpression : '[' (seqExpression ( ',' seqExpression )*)? ']';
listExpression : '{' (seqExpression ( ',' seqExpression )*)? '}';
sExpression : UIDENT ('(' seqExpression  ( ',' seqExpression )* ')' )?;

/**Conditional Expressions**/
ifExpression : IF seqExpression THEN scopeExpression elsePart? FI;
elsePart
        : ELIF seqExpression THEN scopeExpression elsePart?
        | ELSE scopeExpression
        ;

/**Loop Expressions**/
whileDoExpression : WHILE seqExpression DO scopeExpression OD;
doWhileExpression : DO scopeExpression WHILE seqExpression OD;
forExpression
        : FOR scopeExpression ',' seqExpression ',' seqExpression DO scopeExpression OD;


/**
* PATTERN MATCHING
**/

pattern : consPattern | simplePattern;
consPattern : simplePattern ':' pattern;
simplePattern 
        : wildcardPattern 
        |sExprPattern 
        |arrayPattern 
        |listPattern 
        |'-'? DECIMAL
        |STRING 
        |CHAR 
        |TRUE 
        |FALSE 
        |'#' BOX 
        |'#' VAL 
        |'#' STR 
        |'#' ARRAY 
        |'#' SEXP 
        |'#' FUN 
        |'(' pattern ')'
        |LIDENT  ('@' pattern)?
        ;
        
wildcardPattern : '_';
sExprPattern : UIDENT ('(' pattern ( ',' pattern)* ')')?;
arrayPattern : '[' (pattern ( ',' pattern)*)? ']';
listPattern : '{' (pattern ( ',' pattern)*)* '}';

caseExpression : CASE seqExpression OF caseBranches ESAC;
caseBranches : caseBranch ( '|' caseBranch )* ;
caseBranch : pattern '->' scopeExpression;

