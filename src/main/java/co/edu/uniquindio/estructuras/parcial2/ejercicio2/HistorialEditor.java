package co.edu.uniquindio.estructuras.parcial2.ejercicio2;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;

/**
 * Ejercicio 2 - Obtener un segmento del historial.
 * Responsable: Nicolás.
 */
public class HistorialEditor {

    /**
     * Retorna una NUEVA pila con las acciones entre las posiciones inicio y fin (incluidas),
     * contadas desde la cima empezando en 1. La acción de la posición 'inicio' queda en la cima.
     *
     *  - La pila original debe quedar con los mismos elementos y en el mismo orden.
     *  - Si inicio < 1, inicio > fin o fin > tamaño -> retorna pila vacía.
     *  - Solo operaciones de la Pila propia (puede usar pilas auxiliares).
     *
     * Ejemplo: original A6 -> A5 -> A4 -> A3 -> A2 -> A1, inicio=2, fin=4 -> A5 -> A4 -> A3
     */
    public <T> Pila<T> obtenerSegmento(Pila<T> original, int inicio, int fin) {
        // TODO (Nicolás): implementar obtenerSegmento.
        // Pistas:
        //  1. Validar el rango; si es inválido retornar una pila vacía.
        //  2. Vaciar la original en una auxiliar contando posiciones; las que estén en
        //     [inicio, fin] apilarlas también en una pila 'segmento'.
        //  3. Restaurar la original desde la auxiliar.
        //  4. Invertir 'segmento' en la pila resultado para que 'inicio' quede en la cima.
        throw new UnsupportedOperationException("Ejercicio 2: obtenerSegmento (Nicolás)");
    }
}
