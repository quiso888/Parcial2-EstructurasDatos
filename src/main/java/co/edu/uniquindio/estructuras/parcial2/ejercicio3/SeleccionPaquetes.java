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
        // TODO (Nicolás): implementar seleccionarPaquetes SIN for/while/do-while.
        // Pistas:
        //  - Guarde la capacidad en 'capacidadRestante'. Si capacidad <= 0 → retornar cola vacía.
        //  - Haga dos recorridos recursivos: uno para URGENTE y otro para NORMAL.
        //  - Cada recorrido procesa exactamente pendientes.tamanio() paquetes: desencola uno;
        //    si es del tipo buscado y cabe → a seleccionados; si no → vuelve a encolarse en pendientes.
        //    Así los pendientes conservan su orden original.
        //  - Registre cada paquete evaluado en 'bitacora'.
        throw new UnsupportedOperationException("Ejercicio 3: seleccionarPaquetes (Nicolás)");
    }

    // TODO (Nicolás): escriba aquí el método recursivo auxiliar, por ejemplo:
    // private void recorrer(Cola<Paquete> pendientes, Cola<Paquete> seleccionados, TipoEntrega tipo, int restantes)
    //   caso base: restantes == 0
}
