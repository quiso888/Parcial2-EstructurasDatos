package co.edu.uniquindio.estructuras.parcial2.estructuras;

/**
 * Cola propia (FIFO) implementada con nodos enlazados (frente y final).
 * Operaciones permitidas en los ejercicios: encolar, desencolar, frente, estaVacia y tamanio.
 */
public class Cola<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;

    /** Agrega un elemento al final. O(1) */
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            primero = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
        }
        ultimo = nuevo;
        tamanio++;
    }

    /** Retira y retorna el elemento del frente. O(1) */
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        tamanio--;
        return dato;
    }

    /** Retorna (sin retirar) el elemento del frente. O(1) */
    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return primero.getDato();
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public int tamanio() {
        return tamanio;
    }

    /** Muestra el contenido desde el frente hasta el final: [P1 -> P2 -> ...]. Solo para imprimir. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) sb.append(" -> ");
            actual = actual.getSiguiente();
        }
        return sb.append("]").toString();
    }
}
