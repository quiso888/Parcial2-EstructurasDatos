package co.edu.uniquindio.estructuras.parcial2.estructuras;

/**
 * Pila propia (LIFO) implementada con nodos enlazados.
 * Operaciones permitidas en los ejercicios: apilar, desapilar, cima, estaVacia y tamanio.
 */
public class Pila<T> {
    private Nodo<T> tope;
    private int tamanio;

    /** Agrega un elemento en la cima. O(1) */
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
        tamanio++;
    }

    /** Retira y retorna el elemento de la cima. O(1) */
    public T desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        tamanio--;
        return dato;
    }

    /** Retorna (sin retirar) el elemento de la cima. O(1) */
    public T cima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return tope.getDato();
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int tamanio() {
        return tamanio;
    }

    /** Muestra el contenido desde la cima hasta el fondo: [C7 -> C6 -> ...]. Solo para imprimir. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = tope;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) sb.append(" -> ");
            actual = actual.getSiguiente();
        }
        return sb.append("]").toString();
    }
}
