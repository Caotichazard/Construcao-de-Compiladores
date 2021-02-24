#!/bin/bash

for i in {1..37}
    do 
        echo "Testando arquivo $i"
        $(java -jar /home/salomao/Documentos/BCC/Compiladores/Construcao-de-Compiladores/Trabalho-1/LA-Lexico/target/LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada/entrada_$i.txt minhasSaidas/saida_$i.txt)
    done