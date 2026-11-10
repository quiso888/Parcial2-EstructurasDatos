package co.edu.uniquindio.estructuras.parcial2.ejercicio3;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;

/**
 * Ejercicio 3 - Selección de paquetes para una jornada.
 * Responsable: Nicolás.
 *
 * RESTRICCIÓN: todo el procesamiento debe ser RECURSIVO (prohibido for, while y do-while
 * dentro de esta clase). Se puede usar pendientes.tamanio() para saber cuántos elementos
 * procesar en cada recorrido.
 */
public class SeleccionPaquetes {

    /** Capacidad que sobró después de la última selección (para mostrarla en el informe). */
    private int capacidadRestante;

    /** Bitácora: "P2 URGENTE 7kg -> SELECCIONADO (quedan 7 kg)" o "... -> PENDIENTE (no cabe)". */
    private Cola<String> bitacora = new Cola<>();

    public int getCapacidadRestante() {
        return capacidadRestante;
    }

    public Cola<String> getBitacora() {
        return bitacora;
    }

    /**
     * Retorna una NUEVA cola con los paquetes seleccionados y los retira de 'pendientes'.
     *
     *  1. Primero los URGENTES en orden de registro, luego los NORMALES en orden de registro.
     *  2. Si peso <= capacidad restante -> se selecciona y se descuenta.
     *  3. Si no cabe -> queda pendiente y se sigue con el siguiente.
     *  4. La cola retornada conserva el orden de selección (urgentes y luego normales).
     *  5. Los pendientes conservan entre sí su orden de registro.
     *  6. Si capacidad <= 0 -> cola vacía y 'pendientes' sin cambios.
     */
    public Cola<Paquete> seleccionarPaquetes(Cola<Paquete> pendientes, int capacidad) {
        bitacora = new Cola<>();
        Cola<Paquete> seleccionados = new Cola<>();
        capacidadRestante = Math.max(capacidad, 0);
        if (pendientes == null || capacidad <= 0) {
            capacidadRestante = capacidad;
            return seleccionados;
        }
        // Recorrido 1: urgentes. Recorrido 2: normales.
        // Cada recorrido "rota" la cola exactamente tamanio() veces: los que no se seleccionan
        // vuelven al final, así que los pendientes conservan su orden original.
        recorrer(pendientes, seleccionados, TipoEntrega.URGENTE, pendientes.tamanio());
        recorrer(pendientes, seleccionados, TipoEntrega.NORMAL, pendientes.tamanio());
        return seleccionados;
    }

    /** Procesa 'restantes' paquetes del frente de la cola, de forma recursiva. */
    private void recorrer(Cola<Paquete> pendientes, Cola<Paquete> seleccionados, TipoEntrega tipo, int restantes) {
        if (restantes == 0) {
            return; // caso base
        }
        Paquete p = pendientes.desencolar();
        if (p.getTipo() == tipo) {
            if (p.getPeso() <= capacidadRestante) {
                capacidadRestante -= p.getPeso();
                seleccionados.encolar(p);
                bitacora.encolar(p + " -> SELECCIONADO (quedan " + capacidadRestante + " kg)");
            } else {
                pendientes.encolar(p);
                bitacora.encolar(p + " -> PENDIENTE (no cabe, quedan " + capacidadRestante + " kg)");
            }
        } else {
            pendientes.encolar(p); // no es del tipo de este recorrido: vuelve al final sin evaluarse
        }
        recorrer(pendientes, seleccionados, tipo, restantes - 1);
    }
}
