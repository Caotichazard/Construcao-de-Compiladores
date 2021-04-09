grammar LA;




programa: (definicao)*  (declaracao)*;



declaracao: 'declare' IDENT ':' (valores(',')?)* 'fim_declare';



definicao: 'defina' IDENT ':' (campo)*  'fim_defina';





campo: IDENT ':' tipo ',';

valores: (IDENT ':')? '{' (valor)* '}';

valor: IDENT ':' (entradaSimples | entradaVetor) ',';

entradaSimples: entrada;

entradaVetor: '[' (entrada ',')* ']';

tipo: 'CADEIA' | 'NUMERO' | 'DATA'| IDENT;

entrada: NUM | CADEIA | DATA | referencia;

referencia: ( IDENT ('.')?)+;

IDENT: ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* | ('_');

DATA: ('0'..'9')?('0'..'9') '/' ('0'..'9')?('0'..'9') '/' ('0'..'9')+;


NUM	: ('0'..'9')+ ('.' ('0'..'9')+)?
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