package co.edu.uniquindio.estructuras.parcial2.ejercicio4;

import co.edu.uniquindio.estructuras.parcial2.estructuras.ArbolBinarioBusqueda;
import co.edu.uniquindio.estructuras.parcial2.estructuras.ArbolBinarioBusqueda.OpcionEliminacion;

/** Ejercicio 4: consulta por rango (código) y verificación del ABB que se dibuja a mano. */
public class DemoEjercicio4 {

    public static final int[] INSERCIONES = {41, 20, 52, 16, 6, 13, 12, 60, 22, 47, 50, 60, 43, 44};

    public static ArbolBinarioBusqueda arbolDePrueba() {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        for (int clave : INSERCIONES) {
            abb.insertar(clave);
        }
        return abb;
    }

    public static void ejecutar() {
        System.out.println("=== EJERCICIO 4 - Árbol binario de búsqueda ===");
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        for (int clave : INSERCIONES) {
            boolean ok = abb.insertar(clave);
            if (!ok) System.out.println("(" + clave + " ya existe: se ignora porque los códigos son únicos)");
        }
        System.out.println("Árbol (acostado, raíz a la izquierda):");
        System.out.print(abb.dibujar());
        System.out.println("Inorden:   " + abb.inorden());
        System.out.println("Preorden:  " + abb.preorden());
        System.out.println("Postorden: " + abb.postorden());
        System.out.println("Amplitud:  " + abb.amplitud());

        System.out.println();
        System.out.println("4a - contarEquiposEnRango");
        ConsultaEquipos consulta = new ConsultaEquipos();
        int[][] rangos = {{13, 47}, {1, 100}, {45, 49}, {50, 10}};
        try {
            for (int[] r : rangos) {
                System.out.println("   [" + r[0] + ", " + r[1] + "] -> "
                        + consulta.contarEquiposEnRango(abb.getRaiz(), r[0], r[1]));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(">>> PENDIENTE: " + e.getMessage());
        }

        for (OpcionEliminacion op : OpcionEliminacion.values()) {
            ArbolBinarioBusqueda copia = arbolDePrueba();
            copia.eliminar(41, op);
            System.out.println();
            System.out.println("4b - Eliminar 41 usando " + op
                    + (op == OpcionEliminacion.PREDECESOR ? " (mayor del subárbol izquierdo)" : " (menor del subárbol derecho)"));
            System.out.print(copia.dibujar());
            System.out.println("Inorden:  " + copia.inorden());
            System.out.println("Amplitud: " + copia.amplitud());
        }
    }
}
