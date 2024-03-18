grammar Lama;
UIDENT : [A-Z][a-zA-Z 0-9]*;
LIDENT : [a-z][a-zA-Z 0-9]*;
DECIMAL : '-'?[0-9]+;
STRING : '"'([^"])*'"';
CHAR : [a-z][A-Z];
INFIX : '+'|'*'|'/'|'%'|'$'|'#'|'@'|'!'|'|'|'&'|'ˆ'|'?'|'<'|'>'|':='|'-';

lama_import : IMPORT UIDENT ';';
compilationUnit : lama_import* scopeExpression;
scopeExpression : definition* expression?;
definition
        : variableDefinition
        | functionDefinition
        ;

variableDefinition: (VAR | PUBLIC) variableDefinitionSequence ';' ;
variableDefinitionSequence
    : variableDefinitionItem ( ',' variableDefinitionItem )*;
variableDefinitionItem : LIDENT ( '=' basicExpression )?;
functionDefinition :
    PUBLIC?  FUN LIDENT '(' functionArguments ')' functionBody;
functionArguments : (LIDENT ( ',' LIDENT )*)?;
functionBody : '{' scopeExpression '}';

/**
EXPRESSIONS
**/

expression : basicExpression ( ';' expression );
basicExpression : binaryExpression;
binaryExpression
        : binaryOperand INFIX binaryOperand
        | binaryOperand
        ;
binaryOperand : '-'? postfixExpression;
postfixExpression
        : primary
        | postfixExpression '(' ( expression ( ',' expression )* )? ')'
        | postfixExpression '[' expression ']';
primary : DECIMAL
        | STRING
        | CHAR
        | LIDENT
        | TRUE
        |FALSE
        |FUN '(' functionArguments ')' functionBody
        |SKIP_
        |'(' scopeExpression ')'
        |listExpression
        |arrayExpression
        |sExpression
        |ifExpression
        |whileDoExpression
        |doWhileExpression
        |forExpression
        |caseExpression
        ;

arrayExpression : '[' (expression ( ',' expression )*)? ']';
listExpression : '{' (expression ( ',' expression )*)? '}';
sExpression : UIDENT ('(' expression  ( ',' expression )* ')' )?;

/**Conditional Expressions**/
ifExpression : IF expression THEN scopeExpression elsePart? FI;
elsePart
        : ELIF expression THEN scopeExpression elsePart?
        | ELSE scopeExpression
        ;

/**Loop Expressions**/
whileDoExpression : WHILE expression DO scopeExpression OD;
doWhileExpression : DO scopeExpression WHILE expression OD;
forExpression
        : FOR scopeExpression ',' expression ',' expression DO scopeExpression OD;


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
        |LIDENT  ('@' pattern)?  
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
        ;
        
wildcardPattern : '_';
sExprPattern : UIDENT ('(' pattern ( ',' pattern)* ')')?;
arrayPattern : '[' (pattern ( ',' pattern)*)? ']';
listPattern : '{' (pattern ( ',' pattern)*)* '}';

caseExpression : CASE expression OF caseBranches ESAC;
caseBranches : caseBranch ( '|' caseBranch )* ;
caseBranch : pattern '->' scopeExpression;

/**
* KEYWORDS
**/

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