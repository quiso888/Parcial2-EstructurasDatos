package co.edu.uniquindio.estructuras.parcial2.ejercicio1;

/** Una fila de la tabla de evaluación: elemento procesado, operación y pila resultante. */
public class PasoEvaluacion {
    private final String elemento;
    private final String operacion;
    private final String pila;

    public PasoEvaluacion(String elemento, String operacion, String pila) {
        this.elemento = elemento;
        this.operacion = operacion;
        this.pila = pila;
    }

    public String getElemento() { return elemento; }
    public String getOperacion() { return operacion; }
    public String getPila() { return pila; }

    @Override
    public String toString() {
        return String.format("%-8s | %-28s | %s", elemento, operacion, pila);
    }
}
