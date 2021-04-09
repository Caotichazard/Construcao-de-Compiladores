# Trabalho 4

este diretório corresponde ao Trabalho 4 da matéria de Construção de compiladores

## Descrição da linguagem

Esta é uma linguagem criada com o propósito de facilitar a geração de objetos json abstraindo sua sintaxe e permitindo o uso e referencia entre objetos. 

Além disso, pela sua estrutura, extender ela para atender outros formatos como XML, CSV e etc é possível mantendo sua legibilidade.






## Grupo
- Guilherme Locca Salomão, RA: 758569

## Acesso rápido
Segue links para acesso rapido a arquivos importantes:
- [.jar principal](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-4/LA-Lexico/target/LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar)
- [Gramatica](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-4/LA-Lexico/src/main/antlr4/br/ufscar/dc/compiladores/la/lexico/LA.g4) 
- [Classe Principal](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-4/LA-Lexico/src/main/java/br/ufscar/dc/compiladores/la/lexico/Principal.java)
- [Classe da Tabela de Entradas](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-4/LA-Lexico/src/main/java/br/ufscar/dc/compiladores/la/lexico/TabelaDeEntradas.java)
- [Classe Utiliátios Semanticos](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-4/LA-Lexico/src/main/java/br/ufscar/dc/compiladores/la/lexico/LASemanticoUtils.java)

## Dependencias
Este projeto foi feito com Java utilizando Maven, para isso é necessário:
- Java 1.8 ou mais recente
- Maven 3.6.2 ou mais recente

Para executar esse programa é necessário as seguintes dependencias:
- antlr4 4.7.2

e os seguintes Plugins:
- antlr4-maven-plugin 4.7.2
- maven-assembly-plugin

## Compilação
Tendo o projeto configurado, basta executar o comando
`mvn compile`


## Execução
Localizar o arquivo `LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar` 

Para executar o programa basta usar o seguinte comando:\
`java -jar Caminho/para/LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar Caminho/para/arquivo/de/teste/arquivo_de_teste.txt Caminho/para/arquivo/de/saida/arquivo_de_saida.txt`


A saida será um arquivo localizado no diretório alvo com o nome fornecido


## Formatação e uso

Para usar esta linguagem de programação é necessário criar um documento de entrada que segue o seguinte padrão
```
defina OBJETO:
    CAMPO_1 : TIPO,
    CAMPO_2 : TIPO,
    CAMPO_3 : TIPO,
fim_defina

declare OBJETO
    NOME_OBJETO : {
        CAMPO_1 : VALOR_1,
        CAMPO_2 : VALOR_2,
        CAMPO_3 : VALOR_3,
    },
    _ : {
        CAMPO_1 : VALOR_1,
        CAMPO_2 : [VALOR_2.1,VALOR_2.2,],
        CAMPO_3 : VALOR_3,
    }
fim_declare
```

onde 

- OBJETO é o nome da definição
- CAMPO_N é o nome do campo do objeto
- TIPO é a definição do tipo do campo
- NOME_OBJETO é o nome da instancia do objeto

### Tipos aceitos
- `NUMERO` para numeros reais ou inteiros
- `CADEIA` para cadeias de caracteres ou strings
- `DATA` para datas, seguindo o formato DD/MM/AAAA

### Declarações
Quando for realizada a declaração de uma instancia de um objeto, é necessário garantir a compatibilidade de tipos com a definição, caso contrário não ocorrera a geração do codigo de saida.


Durante a declaração de uma instancia, os campos podem aceitar um unico valor para o campo, ou um conjunto de valores, declarados como:

```
CAMPO_N : [ VALOR_1, VALOR_2, ..., VALOR_N,],
```

Além disso, caso haja duas definições de Objetos e haja ao menos uma declaração de cada, há a possibilidade de se referenciar um dos valores de uma declaração de um objeto.

Para usar isto deve-se seguir a seguinte formatação:
```
CAMPO : OBJETO.INSTANCIA_OBJETO.CAMPO
```
um exemplo de uso desta linguagem se encontra no seguinte exemplo:

```
defina Autor :
    Nome : CADEIA,
    
fim_defina

defina Livro :
    Nome : CADEIA,
    Autor : CADEIA,  
fim_defina

declare Autor:
    Staveley : {
        Nome : "Brian Staveley",
        
    },
    Tolkien : {
        Nome : "J.R.R Tolkien",
        
    }
fim_declare


declare Livro:
    _ : {
        Nome : "Rei das laminas",
        Autor : Autor.Staveley.Nome,
    },
    _ : {
        Nome : "Senhor dos Aneis: A sociedade do Anel",
        Autor : "Tolkien",    
    },
    
fim_declare
```

caso queira entender mais como usa e ver mais exemplos práticos entre na secção de [Casos de Teste](https://github.com/Caotichazard/Construcao-de-Compiladores/tree/main/Trabalho-4/casos_de_teste)