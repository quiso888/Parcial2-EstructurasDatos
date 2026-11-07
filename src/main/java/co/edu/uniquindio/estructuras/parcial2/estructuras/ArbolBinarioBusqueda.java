package co.edu.uniquindio.estructuras.parcial2.estructuras;

/**
 * Árbol binario de búsqueda propio con claves enteras únicas.
 * Incluye inserción, eliminación (por predecesor o sucesor), los cuatro recorridos
 * y una impresión en consola para comparar con el dibujo a mano.
 */
public class ArbolBinarioBusqueda {

    /** Opción para eliminar un nodo con dos hijos. */
    public enum OpcionEliminacion {
        /** Reemplaza por el mayor del subárbol izquierdo. */
        PREDECESOR,
        /** Reemplaza por el menor del subárbol derecho. */
        SUCESOR
    }

    private NodoABB raiz;

    public NodoABB getRaiz() {
        return raiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    /** Inserta la clave. Retorna false si ya existía (los códigos son únicos). */
    public boolean insertar(int clave) {
        if (raiz == null) {
            raiz = new NodoABB(clave);
            return true;
        }
        return insertar(raiz, clave);
    }

    private boolean insertar(NodoABB nodo, int clave) {
        if (clave == nodo.getClave()) {
            return false;
        }
        if (clave < nodo.getClave()) {
            if (nodo.getIzquierdo() == null) {
                nodo.setIzquierdo(new NodoABB(clave));
                return true;
            }
            return insertar(nodo.getIzquierdo(), clave);
        }
        if (nodo.getDerecho() == null) {
            nodo.setDerecho(new NodoABB(clave));
            return true;
        }
        return insertar(nodo.getDerecho(), clave);
    }

    public boolean contiene(int clave) {
        NodoABB actual = raiz;
        while (actual != null) {
            if (clave == actual.getClave()) return true;
            actual = clave < actual.getClave() ? actual.getIzquierdo() : actual.getDerecho();
        }
        return false;
    }

    /** Elimina la clave usando la opción indicada cuando el nodo tiene dos hijos. */
    public boolean eliminar(int clave, OpcionEliminacion opcion) {
        if (!contiene(clave)) {
            return false;
        }
        raiz = eliminar(raiz, clave, opcion);
        return true;
    }

    private NodoABB eliminar(NodoABB nodo, int clave, OpcionEliminacion opcion) {
        if (nodo == null) return null;
        if (clave < nodo.getClave()) {
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), clave, opcion));
        } else if (clave > nodo.getClave()) {
            nodo.setDerecho(eliminar(nodo.getDerecho(), clave, opcion));
        } else {
            // Caso 1 y 2: hoja o un solo hijo
            if (nodo.getIzquierdo() == null) return nodo.getDerecho();
            if (nodo.getDerecho() == null) return nodo.getIzquierdo();
            // Caso 3: dos hijos
            if (opcion == OpcionEliminacion.PREDECESOR) {
                int reemplazo = mayor(nodo.getIzquierdo()).getClave();
                nodo.setClave(reemplazo);
                nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), reemplazo, opcion));
            } else {
                int reemplazo = menor(nodo.getDerecho()).getClave();
                nodo.setClave(reemplazo);
                nodo.setDerecho(eliminar(nodo.getDerecho(), reemplazo, opcion));
            }
        }
        return nodo;
    }

    private NodoABB mayor(NodoABB nodo) {
        while (nodo.getDerecho() != null) nodo = nodo.getDerecho();
        return nodo;
    }

    private NodoABB menor(NodoABB nodo) {
        while (nodo.getIzquierdo() != null) nodo = nodo.getIzquierdo();
        return nodo;
    }

    // ------------------------------------------------------------------ recorridos

    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inorden(raiz, sb);
        return sb.toString().trim();
    }

    private void inorden(NodoABB n, StringBuilder sb) {
        if (n == null) return;
        inorden(n.getIzquierdo(), sb);
        sb.append(n.getClave()).append(' ');
        inorden(n.getDerecho(), sb);
    }

    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preorden(raiz, sb);
        return sb.toString().trim();
    }

    private void preorden(NodoABB n, StringBuilder sb) {
        if (n == null) return;
        sb.append(n.getClave()).append(' ');
        preorden(n.getIzquierdo(), sb);
        preorden(n.getDerecho(), sb);
    }

    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postorden(raiz, sb);
        return sb.toString().trim();
    }

    private void postorden(NodoABB n, StringBuilder sb) {
        if (n == null) return;
        postorden(n.getIzquierdo(), sb);
        postorden(n.getDerecho(), sb);
        sb.append(n.getClave()).append(' ');
    }

    /** Recorrido por niveles usando la Cola propia. */
    public String amplitud() {
        StringBuilder sb = new StringBuilder();
        if (raiz == null) return "";
        Cola<NodoABB> cola = new Cola<>();
        cola.encolar(raiz);
        while (!cola.estaVacia()) {
            NodoABB n = cola.desencolar();
            sb.append(n.getClave()).append(' ');
            if (n.getIzquierdo() != null) cola.encolar(n.getIzquierdo());
            if (n.getDerecho() != null) cola.encolar(n.getDerecho());
        }
        return sb.toString().trim();
    }

    /**
     * Dibuja el árbol "acostado": la raíz queda a la izquierda, el subárbol derecho
     * arriba y el izquierdo abajo. Gire la cabeza a la izquierda para leerlo.
     */
    public String dibujar() {
        StringBuilder sb = new StringBuilder();
        dibujar(raiz, 0, sb);
        return sb.toString();
    }

    private void dibujar(NodoABB n, int nivel, StringBuilder sb) {
        if (n == null) return;
        dibujar(n.getDerecho(), nivel + 1, sb);
        sb.append("        ".repeat(nivel)).append(n.getClave()).append('\n');
        dibujar(n.getIzquierdo(), nivel + 1, sb);
    }
}
