package co.edu.uniquindio.estructuras.parcial2;

import co.edu.uniquindio.estructuras.parcial2.ejercicio3.DemoEjercicio3;
import co.edu.uniquindio.estructuras.parcial2.ejercicio3.Paquete;
import co.edu.uniquindio.estructuras.parcial2.ejercicio3.SeleccionPaquetes;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio3Test {

    @Test
    void datosDelEnunciadoCon14kg() {
        Cola<Paquete> pendientes = DemoEjercicio3.colaDePrueba();
        SeleccionPaquetes s = new SeleccionPaquetes();
        Cola<Paquete> sel = s.seleccionarPaquetes(pendientes, 14);
        assertEquals("[P2(URGENTE,7kg) -> P4(URGENTE,5kg) -> P7(NORMAL,2kg)]", sel.toString());
        assertEquals("[P1(NORMAL,4kg) -> P3(NORMAL,3kg) -> P5(NORMAL,6kg) -> P6(URGENTE,4kg)]", pendientes.toString());
        assertEquals(0, s.getCapacidadRestante());
    }

    @Test
    void capacidadCeroNoCambiaNada() {
        Cola<Paquete> pendientes = DemoEjercicio3.colaDePrueba();
        String antes = pendientes.toString();
        Cola<Paquete> sel = new SeleccionPaquetes().seleccionarPaquetes(pendientes, 0);
        assertTrue(sel.estaVacia());
        assertEquals(antes, pendientes.toString());
    }

    @Test
    void capacidadGrandeSeleccionaTodoUrgentesPrimero() {
        Cola<Paquete> pendientes = DemoEjercicio3.colaDePrueba();
        Cola<Paquete> sel = new SeleccionPaquetes().seleccionarPaquetes(pendientes, 100);
        assertEquals(7, sel.tamanio());
        assertEquals("P2", sel.frente().getCodigo());
        assertTrue(pendientes.estaVacia());
    }

    /** El enunciado prohíbe ciclos en este ejercicio: la prueba revisa el código fuente. */
    @Test
    void noUsaCiclos() throws Exception {
        Path fuente = Path.of("src/main/java/co/edu/uniquindio/estructuras/parcial2/ejercicio3/SeleccionPaquetes.java");
        String codigo = Files.readString(fuente)
                .replaceAll("(?s)/\\*.*?\\*/", "")
                .replaceAll("//[^\\n]*", "");
        assertFalse(codigo.matches("(?s).*\\b(for|while|do)\\s*[({].*"),
                "SeleccionPaquetes no debe usar for, while ni do-while");
    }
}
