#!/usr/bin/env bash
# Compila y ejecuta SIN Maven (solo necesita el JDK 17 o superior).
# Uso: ./run.sh          -> menú
#      ./run.sh 3        -> solo el ejercicio 3
#      ./run.sh todos    -> todos los ejercicios
set -e
cd "$(dirname "$0")"
rm -rf out && mkdir -p out
javac -encoding UTF-8 -d out $(find src/main/java -name "*.java")
java -Dfile.encoding=UTF-8 -cp out co.edu.uniquindio.estructuras.parcial2.Main "$@"
