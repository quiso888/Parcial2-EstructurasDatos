package co.edu.uniquindio.estructuras.parcial2.ejercicio3;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;

/** Ejecuta los datos de prueba del ejercicio 3 con capacidad de 14 kg. */
public class DemoEjercicio3 {

    public static final int CAPACIDAD = 14;

    public static Cola<Paquete> colaDePrueba() {
        Cola<Paquete> cola = new Cola<>();
        cola.encolar(new Paquete("P1", TipoEntrega.NORMAL, 4));
        cola.encolar(new Paquete("P2", TipoEntrega.URGENTE, 7));
        cola.encolar(new Paquete("P3", TipoEntrega.NORMAL, 3));
        cola.encolar(new Paquete("P4", TipoEntrega.URGENTE, 5));
        cola.encolar(new Paquete("P5", TipoEntrega.NORMAL, 6));
        cola.encolar(new Paquete("P6", TipoEntrega.URGENTE, 4));
        cola.encolar(new Paquete("P7", TipoEntrega.NORMAL, 2));
        return cola;
    }

    public static void ejecutar() {
        System.out.println("=== EJERCICIO 3 - Selección de paquetes (capacidad " + CAPACIDAD + " kg) ===");
        Cola<Paquete> pendientes = colaDePrueba();
        System.out.println("Cola inicial (frente -> final): " + pendientes);
        SeleccionPaquetes seleccion = new SeleccionPaquetes();
        Cola<Paquete> seleccionados = seleccion.seleccionarPaquetes(pendientes, CAPACIDAD);
        System.out.println("Paquetes evaluados:");
        Cola<String> bitacora = seleccion.getBitacora();
        while (!bitacora.estaVacia()) {
            System.out.println("   " + bitacora.desencolar());
        }
        System.out.println("Cola retornada (seleccionados): " + seleccionados);
        System.out.println("Cola de pendientes:             " + pendientes);
        System.out.println("Capacidad disponible restante:  " + seleccion.getCapacidadRestante() + " kg");
    }
}
