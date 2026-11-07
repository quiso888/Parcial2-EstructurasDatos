package co.edu.uniquindio.estructuras.parcial2;

import co.edu.uniquindio.estructuras.parcial2.ejercicio4.ConsultaEquipos;
import co.edu.uniquindio.estructuras.parcial2.ejercicio4.DemoEjercicio4;
import co.edu.uniquindio.estructuras.parcial2.estructuras.ArbolBinarioBusqueda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio4Test {

    private final ConsultaEquipos consulta = new ConsultaEquipos();
    private final ArbolBinarioBusqueda abb = DemoEjercicio4.arbolDePrueba();

    @Test
    void conteosPorRango() {
        assertEquals(8, consulta.contarEquiposEnRango(abb.getRaiz(), 13, 47));
        assertEquals(13, consulta.contarEquiposEnRango(abb.getRaiz(), 1, 100));
        assertEquals(1, consulta.contarEquiposEnRango(abb.getRaiz(), 45, 49));
        assertEquals(2, consulta.contarEquiposEnRango(abb.getRaiz(), 41, 43));
    }

    @Test
    void casosBorde() {
        assertEquals(0, consulta.contarEquiposEnRango(null, 1, 10));
        assertEquals(0, consulta.contarEquiposEnRango(abb.getRaiz(), 50, 10));
        assertEquals(0, consulta.contarEquiposEnRango(abb.getRaiz(), 61, 99));
    }

    @Test
    void recorridosDelArbolDePrueba() {
        assertEquals("6 12 13 16 20 22 41 43 44 47 50 52 60", abb.inorden());
        assertEquals("41 20 16 6 13 12 22 52 47 43 44 50 60", abb.preorden());
        assertEquals("12 13 6 16 22 20 44 43 50 47 60 52 41", abb.postorden());
        assertEquals("41 20 52 16 22 47 60 6 43 50 13 44 12", abb.amplitud());
    }
}
