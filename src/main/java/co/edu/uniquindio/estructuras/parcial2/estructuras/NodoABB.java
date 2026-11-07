package co.edu.uniquindio.estructuras.parcial2.estructuras;

/** Nodo del árbol binario de búsqueda con clave entera. */
public class NodoABB {
    private int clave;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB(int clave) {
        this.clave = clave;
    }

    public int getClave() { return clave; }
    public void setClave(int clave) { this.clave = clave; }
    public NodoABB getIzquierdo() { return izquierdo; }
    public void setIzquierdo(NodoABB izquierdo) { this.izquierdo = izquierdo; }
    public NodoABB getDerecho() { return derecho; }
    public void setDerecho(NodoABB derecho) { this.derecho = derecho; }
}
