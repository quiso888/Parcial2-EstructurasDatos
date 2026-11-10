package co.edu.uniquindio.estructuras.parcial2;

import co.edu.uniquindio.estructuras.parcial2.ejercicio2.DemoEjercicio2;
import co.edu.uniquindio.estructuras.parcial2.ejercicio2.HistorialEditor;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ejercicio2Test {

    private final HistorialEditor editor = new HistorialEditor();
    private static final String ORIGINAL = "[A6 -> A5 -> A4 -> A3 -> A2 -> A1]";

    @Test
    void ejemploDelEnunciado() {
        Pila<String> original = DemoEjercicio2.historialDePrueba();
        assertEquals("[A5 -> A4 -> A3]", editor.obtenerSegmento(original, 2, 4).toString());
        assertEquals(ORIGINAL, original.toString());
    }

    @Test
    void inicioIgualAFin() {
        Pila<String> original = DemoEjercicio2.historialDePrueba();
        assertEquals("[A4]", editor.obtenerSegmento(original, 3, 3).toString());
        assertEquals(ORIGINAL, original.toString());
    }

    @Test
    void rangoCompleto() {
        Pila<String> original = DemoEjercicio2.historialDePrueba();
        assertEquals(ORIGINAL, editor.obtenerSegmento(original, 1, 6).toString());
        assertEquals(ORIGINAL, original.toString());
    }

    @Test
    void rangosInvalidosRetornanPilaVacia() {
        Pila<String> original = DemoEjercicio2.historialDePrueba();
        assertTrue(editor.obtenerSegmento(original, 0, 2).estaVacia());
        assertTrue(editor.obtenerSegmento(original, 4, 2).estaVacia());
        assertTrue(editor.obtenerSegmento(original, 5, 7).estaVacia());
        assertEquals(ORIGINAL, original.toString());
    }
}
