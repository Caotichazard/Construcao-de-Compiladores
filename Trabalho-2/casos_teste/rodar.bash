#!/bin/bash

for i in {1..62}
    do 
        echo "Testando arquivo $i"
        $(java -jar /home/salomao/Documentos/BCC/Compiladores/Construcao-de-Compiladores/Trabalho-2/LA-Lexico/target/LA-Lexico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada/$i.txt minhasSaidas/$i.txt)
    done