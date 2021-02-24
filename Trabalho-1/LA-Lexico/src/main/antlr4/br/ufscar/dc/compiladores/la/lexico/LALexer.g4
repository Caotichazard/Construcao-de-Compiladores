lexer grammar LALexer;



PALAVRAS_CHAVE: 'escreva' | 'leia' | 'fim_algoritmo' | 'algoritmo' |'declare' | 'para' | 'ate' | 'faca' |'fim_para'
    | 'enquanto' | 'fim_enquanto' |'registro' | 'fim_registro' | 'procedimento' | 'var' | 'fim_procedimento'
    | 'funcao' | 'fim_funcao' | 'tipo' | 'retorne' | 'constante'
    ;

INTEIRO: 'inteiro';

LITERAL: 'literal';

REAL: 'real';

LOGICO: 'logico';

SIMBOLOS: ':' | ',' | '(' | ')' | '.' | '[' | ']';

OPERADORES: '+' | '-' | '/' | '*' | '<-' | '..' | '<>' | '%' |'^' | '&';

OPLOGICOS: 'e' | 'ou' | 'nao' | '>' | '<' | '=' | '<=' | '>=' | 'se' | 'senao' | 'fim_se' | 'entao' | 'caso' | 'seja' | 'fim_caso'
    | 'falso'   | 'verdadeiro'
    ;

IDENT: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

NUM_INT	: ('0'..'9')+
	;
NUM_REAL	: ('0'..'9')+ ('.' ('0'..'9')+)?
	;



CADEIA 	: '"' ( ESC_SEQ | ~('\''|'\\'|'\n'|'\r') )+? '"';
CADEIA_NFIM 	: '"' ~('"')* ('\n'|'\r')   ;
fragment
ESC_SEQ	: '\\\'';


COMENTARIO
    :   '{' ~('\n'|'\r'|'}')*  '}'?  {skip();}
    ;

COMENT_NFECHADO : '{' ~('}')*;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;

ERROR_CHAR: .;