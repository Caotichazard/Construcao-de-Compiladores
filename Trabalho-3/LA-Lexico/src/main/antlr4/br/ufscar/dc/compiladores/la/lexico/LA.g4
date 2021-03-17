grammar LA;




programa: declaracoes 'algoritmo' corpo 'fim_algoritmo' EOF;

declaracoes: (decl_global_local)*;

decl_global_local: declaracao_global | declaracao_local;

declaracao_local: 'declare' variavel 
| 'constante' IDENT ':' tipo_basico '=' valor_constante 
| 'tipo' IDENT ':' tipo
;

variavel: identificador (',' identificador)* ':' tipo;

identificador:  IDENT ('.' IDENT)* dimensao;

dimensao: ('[' exp_aritmetica ']')*;

tipo: registro | tipo_estendido;

tipo_basico: 'literal' | 'inteiro' | 'real' | 'logico';
tipo_basico_ident: tipo_basico | IDENT;
tipo_estendido: ('^')? tipo_basico_ident;

valor_constante: CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso';

registro: 'registro' (variavel)* 'fim_registro' ;

declaracao_global: 'procedimento' IDENT '(' (parametros)? ')' (declaracao_local)* (cmd)* 'fim_procedimento' 
    | 'funcao' IDENT '(' (parametros)? ')' ':' tipo_estendido (declaracao_local)* (cmd)* 'fim_funcao'
    ;

parametro: ('var')? identificador (',' identificador)* ':'  tipo_estendido;
parametros: parametro (',' parametro)*;

corpo: (declaracao_local)* (cmd)*;

cmd returns [ String tipoComando ]
    : cmd_leia | cmd_escreva | cmd_se | cmd_caso | cmd_para | cmd_enquanto | cmd_faca | cmd_atribuicao { $tipoComando = "Atribuicao"; }
    | cmd_chamada | cmd_retorne
    ;

cmd_leia: 'leia' '(' ('^')? identificador (',' ('^')? identificador)* ')';
cmd_escreva: 'escreva' '(' expressao (',' expressao)* ')';
cmd_se: 'se' expressao 'entao' (cmd)* ('senao' (cmd)*)? 'fim_se';
cmd_caso: 'caso' exp_aritmetica 'seja' selecao ('senao' (cmd)*)? 'fim_caso' ;
cmd_para: 'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd)* 'fim_para';
cmd_enquanto: 'enquanto' expressao 'faca' (cmd)* 'fim_enquanto' ;
cmd_faca: 'faca' (cmd)* 'ate' expressao;
cmd_atribuicao: ('^')? identificador '<-' expressao;
cmd_chamada: IDENT '(' expressao (',' expressao)* ')';
cmd_retorne: 'retorne' expressao ;

selecao: (item_selecao)* ;
item_selecao: constantes ':' (cmd)*;
constantes: numero_intervalo (',' numero_intervalo)* ;
numero_intervalo: (op_unario)? NUM_INT ('..' (op_unario)? NUM_INT)? ;
op_unario: '-';
exp_aritmetica: termo (op1 termo)*;
termo: fator (op2 fator)*;
fator: parcela (op3 parcela)*;

op1: '+'| '-';
op2: '*'| '/';
op3: '%';


parcela: (op_unario)? parcela_unario | parcela_nao_unario;
parcela_unario: ('^')? identificador
    | IDENT '(' expressao (',' expressao)* ')'
    | NUM_INT
    | NUM_REAL
    | '(' expressao ')'
     ;

parcela_nao_unario: '&' identificador | CADEIA
    ;

exp_relacional: exp_aritmetica (op_relacional exp_aritmetica)? ;

op_relacional: '=' | '<>' | '>=' | '<=' | '>' | '<';

expressao: termo_logico (op_logico_1 termo_logico)*;
termo_logico: fator_logico (op_logico_2 fator_logico)*;
fator_logico: ('nao')? parcela_logica;
parcela_logica: TIPO_LOGICO=('verdadeiro'|'falso') | exp_relacional ;

op_logico_1: 'ou';
op_logico_2: 'e';


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

COMENT_NFECHADO : '{' ~('}')* '\n';

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;


ERROR_CHAR: .;