# Parcial 2 · Estructuras de Datos (Universidad del Quindío)

Proyecto Java con las estructuras **propias** (Pila, Cola y ABB) y la solución de los ejercicios de
código del Parcial II (1 a 4). El ejercicio 5 (AVL y rojo-negro) se resuelve a mano en el documento.

| Integrante | Identificación | Responsable de |
|---|---|---|
| Sergio | | Ejercicio 1 (retiro de cajas + expresión postfija) + 5c a mano |
| Nicolás | | Ejercicios 2 y 3 (segmento de historial + selección recursiva) + 5a a mano |
| Santiago | | Ejercicio 4a (conteo por rango) + 4b y 5b a mano |

## Requisitos
- JDK 17 o superior (`java -version`).
- Maven no es obligatorio: el proyecto trae `mvnw` (Maven Wrapper) y scripts `run.sh` / `run.bat`.

## Cómo ejecutar
```bash
# Opción 1: sin Maven
./run.sh            # menú (Windows: run.bat)
./run.sh todos      # todos los ejercicios seguidos
./run.sh 3          # solo el ejercicio 3

# Opción 2: con Maven Wrapper
./mvnw test                         # corre las pruebas JUnit (Windows: mvnw.cmd test)
./mvnw -q compile exec:java         # abre el menú
```
En IntelliJ / NetBeans / VS Code: *Abrir proyecto* → seleccionar `pom.xml` → ejecutar `Main`.

## Estructura
```
src/main/java/co/edu/uniquindio/estructuras/parcial2/
├── Main.java                 menú de consola
├── estructuras/              Nodo, Pila, Cola, NodoABB, ArbolBinarioBusqueda
├── ejercicio1/               Caja, RetiroCajas, EvaluadorExpresiones, PasoEvaluacion, DemoEjercicio1
├── ejercicio2/               HistorialEditor, DemoEjercicio2
├── ejercicio3/               Paquete, TipoEntrega, SeleccionPaquetes (recursivo), DemoEjercicio3
└── ejercicio4/               ConsultaEquipos, DemoEjercicio4
src/test/java/...             pruebas JUnit 5 con los resultados esperados
```

Los ejercicios de árboles (4b y 5) se entregan **a mano** en el documento. `DemoEjercicio4` imprime el
ABB, sus recorridos y la eliminación del 41 para comprobar el dibujo.
