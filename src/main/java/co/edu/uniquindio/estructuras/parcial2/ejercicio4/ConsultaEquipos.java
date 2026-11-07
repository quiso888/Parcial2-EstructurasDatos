package co.edu.uniquindio.estructuras.parcial2.ejercicio4;

import co.edu.uniquindio.estructuras.parcial2.estructuras.NodoABB;

/**
 * Ejercicio 4a - Consulta de equipos por rango en un ABB.
 * Responsable: Santiago.
 */
public class ConsultaEquipos {

    /**
     * Cuenta RECURSIVAMENTE cuántos códigos están en [inferior, superior] (extremos incluidos).
     * Debe aprovechar el orden del ABB para NO visitar subárboles que no pueden aportar:
     *  - si clave < inferior -> solo puede haber resultados a la derecha
     *  - si clave > superior -> solo puede haber resultados a la izquierda
     *  - si está en el rango -> cuenta 1 + izquierda + derecha
     * Árbol vacío o inferior > superior -> 0.
     */
    public int contarEquiposEnRango(NodoABB raiz, int inferior, int superior) {
        if (raiz == null || inferior > superior) {
            return 0;
        }
        if (raiz.getClave() < inferior) {
            return contarEquiposEnRango(raiz.getDerecho(), inferior, superior);
        }
        if (raiz.getClave() > superior) {
            return contarEquiposEnRango(raiz.getIzquierdo(), inferior, superior);
        }
        return 1 + contarEquiposEnRango(raiz.getIzquierdo(), inferior, superior)
                 + contarEquiposEnRango(raiz.getDerecho(), inferior, superior);
    }
}
