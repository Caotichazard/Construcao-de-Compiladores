#!/bin/bash
for file in saida/*.txt; do
    echo "testando $file"
    diff "$file" "minhasSaidas/${file##*/}"
done