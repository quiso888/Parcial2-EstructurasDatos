package co.edu.uniquindio.estructuras.parcial2;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaColaTest {

    @Test
    void pilaEsLifo() {
        Pila<Integer> p = new Pila<>();
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        assertEquals(3, p.tamanio());
        assertEquals(3, p.cima());
        assertEquals(3, p.desapilar());
        assertEquals(2, p.desapilar());
        assertEquals("[1]", p.toString());
    }

    @Test
    void colaEsFifo() {
        Cola<String> c = new Cola<>();
        c.encolar("a");
        c.encolar("b");
        c.encolar("c");
        assertEquals("a", c.frente());
        assertEquals("a", c.desencolar());
        assertEquals("[b -> c]", c.toString());
        assertEquals(2, c.tamanio());
    }

    @Test
    void desapilarVaciaLanzaExcepcion() {
        assertThrows(IllegalStateException.class, () -> new Pila<Integer>().desapilar());
        assertThrows(IllegalStateException.class, () -> new Cola<Integer>().desencolar());
    }
}
