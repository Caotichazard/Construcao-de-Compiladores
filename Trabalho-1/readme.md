# Trabalho 1 

este diretório corresponde ao Trabalho 1 da matéria de Construção de compiladores

## Grupo
- Guilherme Locca Salomão, RA: 758569

## Acesso rápido
Segue links para acesso rapido a arquivos importantes:
- [.jar principal](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-1/LA-Lexico/target/LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar)
- [Lexer](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-1/LA-Lexico/src/main/antlr4/br/ufscar/dc/compiladores/la/lexico/LALexer.g4) 
- [Classe Principal](https://github.com/Caotichazard/Construcao-de-Compiladores/blob/main/Trabalho-1/LA-Lexico/src/main/java/br/ufscar/dc/compiladores/la/lexico/Principal.java)

## Dependencias
Este projeto foi feito com Java utilizando Maven, para isso é necessário:
- Java 1.8 ou mais recente
- Maven 3.6.2 ou mais recente

Para executar esse programa é necessário as seguintes dependencias:
- antlr4 4.7.2

e os seguintes Plugins:
- antlr4-maven-plugin 4.7.2
- maven-assembly-plugin

Tendo o projeto configurado, basta executar o comando
`mvn compile`

Após isso localizar o arquivo
`LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar` 
na pasta Target

Para executar o programa basta usar o seguinte comando:\
`java -jar Caminho/para/LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar Caminho/para/arquivo/de/teste/arquivo_de_teste.txt Caminho/para/arquivo/de/saida/arquivo_de_saida.txt`

A saida será um arquivo localizado no diretório alvo com o nome fornecido
