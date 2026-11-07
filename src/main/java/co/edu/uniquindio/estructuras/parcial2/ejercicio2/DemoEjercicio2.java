package co.edu.uniquindio.estructuras.parcial2.ejercicio2;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;

/** Ejecuta el ejemplo del enunciado y algunos casos borde del ejercicio 2. */
public class DemoEjercicio2 {

    public static Pila<String> historialDePrueba() {
        Pila<String> pila = new Pila<>();
        for (int i = 1; i <= 6; i++) {
            pila.apilar("A" + i);
        }
        return pila;
    }

    public static void ejecutar() {
        System.out.println("=== EJERCICIO 2 - Segmento del historial ===");
        HistorialEditor editor = new HistorialEditor();
        Pila<String> original = historialDePrueba();
        System.out.println("Original (tope -> fondo): " + original);
        int[][] casos = {{2, 4}, {3, 3}, {1, 6}, {0, 2}, {4, 2}, {5, 7}};
        for (int[] caso : casos) {
            Pila<String> seg = editor.obtenerSegmento(original, caso[0], caso[1]);
            System.out.println("inicio=" + caso[0] + ", fin=" + caso[1] + " -> " + seg
                    + "   | original queda: " + original);
        }
    }
}
