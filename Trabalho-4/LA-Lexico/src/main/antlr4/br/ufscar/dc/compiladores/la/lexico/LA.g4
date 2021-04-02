grammar LA;




programa: definicoes declaracoes EOF;

definicoes: (definicao)*;

declaracoes: (declaracao)*;

definicao: 'defina' IDENT ':' (campo)*  'fim_defina';



declaracao: 'declare' IDENT ':' (valores)* 'fim_declare';

campo: IDENT ':' tipo ',';

valores: (IDENT)? ':' '{' (valor)* '}';

valor: IDENT ':' tipo ',';

tipo: IDENT | 'CADEIA' | 'NUMERO' | DATA;

IDENT: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

DATA: ('0'..'9')?('0'..'9') '/' ('0'..'9')?('0'..'9') '/' ('0'..'9')+;

NUM_INT	: ('0'..'9')+
	;
NUM_REAL	: ('0'..'9')+ ('.' ('0'..'9')+)?
	;




CADEIA 	: '"' ( ESC_SEQ | ~('\''|'\\'|'\n'|'\r') )+? '"';
CADEIA_NFIM 	: '"' ~('"')* ('\n'|'\r')   ;
fragment
ESC_SEQ	: '\\\'';


COMENTARIO
    :   '/*' ~('\n'|'\r'|'}')*  '*/'?  {skip();}
    ;

COMENT_NFECHADO : '/*' ~('}')* '\n';

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;


ERROR_CHAR: .;