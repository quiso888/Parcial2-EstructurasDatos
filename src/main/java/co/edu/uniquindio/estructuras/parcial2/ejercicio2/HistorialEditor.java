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
        Pila<T> resultado = new Pila<>();
        if (original == null || inicio < 1 || inicio > fin || fin > original.tamanio()) {
            return resultado;
        }

        // 1. Vaciar la original en una auxiliar, guardando las del rango en 'segmento'.
        Pila<T> auxiliar = new Pila<>();
        Pila<T> segmento = new Pila<>();
        int posicion = 1;
        while (!original.estaVacia()) {
            T accion = original.desapilar();
            if (posicion >= inicio && posicion <= fin) {
                segmento.apilar(accion); // queda 'fin' en la cima
            }
            auxiliar.apilar(accion);
            posicion++;
        }

        // 2. Restaurar la original (la auxiliar está invertida).
        while (!auxiliar.estaVacia()) {
            original.apilar(auxiliar.desapilar());
        }

        // 3. Invertir el segmento para que 'inicio' quede en la cima.
        while (!segmento.estaVacia()) {
            resultado.apilar(segmento.desapilar());
        }
        return resultado;
    }
}
