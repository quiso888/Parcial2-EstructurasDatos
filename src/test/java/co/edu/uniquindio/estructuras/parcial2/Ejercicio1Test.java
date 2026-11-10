package co.edu.uniquindio.estructuras.parcial2;

import co.edu.uniquindio.estructuras.parcial2.ejercicio1.*;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio1Test {

    private final RetiroCajas retiro = new RetiroCajas();
    private final EvaluadorExpresiones ev = new EvaluadorExpresiones();

    @Test
    void secuenciaDelEnunciado() {
        Pila<Caja> pila = DemoEjercicio1.pilaDePrueba();
        assertEquals("[C7:5 -> C6:9 -> C5:3 -> C4:8 -> C3:6 -> C2:4 -> C1:2]", pila.toString());

        assertTrue(retiro.retirarCaja(pila, "C3")); // valor 6 par: impares arriba
        assertEquals("[C7:5 -> C5:3 -> C2:4 -> C6:9 -> C4:8 -> C1:2]", pila.toString());

        assertTrue(retiro.retirarCaja(pila, "C4")); // valor 8 par
        assertEquals("[C7:5 -> C2:4 -> C1:2 -> C5:3 -> C6:9]", pila.toString());

        assertTrue(retiro.retirarCaja(pila, "C7")); // valor 5 impar: pares arriba
        assertEquals("[C1:2 -> C6:9 -> C2:4 -> C5:3]", pila.toString());
    }

    @Test
    void codigoInexistenteNoCambiaLaPila() {
        Pila<Caja> pila = DemoEjercicio1.pilaDePrueba();
        String antes = pila.toString();
        assertFalse(retiro.retirarCaja(pila, "C99"));
        assertEquals(antes, pila.toString());
    }

    @Test
    void pilaVaciaRetornaFalse() {
        assertFalse(retiro.retirarCaja(new Pila<>(), "C1"));
    }

    @Test
    void conversionAPostfija() {
        assertEquals("A B + C * A B - D * -",
                EvaluadorExpresiones.comoTexto(ev.infijaAPostfija(DemoEjercicio1.EXPRESION)));
        assertEquals("A B C * +", EvaluadorExpresiones.comoTexto(ev.infijaAPostfija("A + B * C")));
    }

    @Test
    void evaluacionConValoresDeLasCajas() {
        // Pila final: C1:2, C6:9, C2:4, C5:3 → A=2, B=9/2=4.5, C=4+2=6, D=(3+6)*2=18
        Cola<String> postfija = ev.infijaAPostfija(DemoEjercicio1.EXPRESION);
        Cola<String> numerica = ev.reemplazarVariables(postfija,
                new String[]{"A", "B", "C", "D"}, new double[]{2, 4.5, 6, 18});
        Cola<PasoEvaluacion> tabla = new Cola<>();
        assertEquals(84.0, ev.evaluarPostfija(numerica, tabla), 1e-9);
        assertEquals(11, tabla.tamanio()); // una fila por token
    }
}
