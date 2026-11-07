package co.edu.uniquindio.estructuras.parcial2.ejercicio3;

/** Paquete pendiente: código único, tipo de entrega y peso en kg. */
public class Paquete {
    private final String codigo;
    private final TipoEntrega tipo;
    private final int peso;

    public Paquete(String codigo, TipoEntrega tipo, int peso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getCodigo() { return codigo; }
    public TipoEntrega getTipo() { return tipo; }
    public int getPeso() { return peso; }

    @Override
    public String toString() {
        return codigo + "(" + tipo + "," + peso + "kg)";
    }
}
