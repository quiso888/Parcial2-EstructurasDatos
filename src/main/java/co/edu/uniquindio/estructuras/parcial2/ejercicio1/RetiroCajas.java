package co.edu.uniquindio.estructuras.parcial2.ejercicio1;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;

/**
 * Ejercicio 1 (parte A) - Retiro de cajas.
 * Responsable: Sergio.
 */
public class RetiroCajas {

    /**
     * Busca la caja con el código dado, la retira y reorganiza las restantes.
     *
     * Reglas (posiciones contadas desde la cima, empezando en 1, DESPUÉS de retirar la caja):
     *  - valor retirado PAR   -> arriba las de posiciones IMPARES, luego las PARES.
     *  - valor retirado IMPAR -> arriba las de posiciones PARES, luego las IMPARES.
     *  - Cada grupo conserva su orden relativo.
     *  - Si no existe el código o la pila está vacía: la pila queda igual y se retorna false.
     *
     * Solo se permiten operaciones de la Pila propia y pilas propias auxiliares.
     */
    public boolean retirarCaja(Pila<Caja> pila, String codigo) {
        // TODO (Sergio): implementar retirarCaja.
        // Pistas:
        //  1. Si la pila está vacía → false.
        //  2. Desapilar a una pila auxiliar hasta encontrar el código (o vaciar la pila).
        //  3. Devolver las cajas de la auxiliar a la pila. Si no se encontró → false (queda igual).
        //  4. Recorrer la pila contando posiciones desde 1 y repartir en dos pilas: impares y pares.
        //  5. Valor PAR: impares arriba. Valor IMPAR: pares arriba.
        //     Apilar primero el grupo de abajo y luego el de arriba (desapilando las auxiliares).
        throw new UnsupportedOperationException("Ejercicio 1: retirarCaja (Sergio)");
    }
}
