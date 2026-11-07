@echo off
REM Compila y ejecuta SIN Maven (solo necesita el JDK 17 o superior).
REM Uso: run.bat   |   run.bat 3   |   run.bat todos
chcp 65001 > nul
cd /d "%~dp0"
if exist out rmdir /s /q out
mkdir out
dir /s /b src\main\java\*.java > fuentes.txt
javac -encoding UTF-8 -d out @fuentes.txt
del fuentes.txt
java -Dfile.encoding=UTF-8 -cp out co.edu.uniquindio.estructuras.parcial2.Main %*
