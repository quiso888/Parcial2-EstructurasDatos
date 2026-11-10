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
        if (pila == null || pila.estaVacia()) {
            return false;
        }

        // 1. Buscar la caja pasando las de encima a una pila auxiliar.
        Pila<Caja> auxiliar = new Pila<>();
        Caja retirada = null;
        while (!pila.estaVacia()) {
            Caja actual = pila.desapilar();
            if (actual.getCodigo().equals(codigo)) {
                retirada = actual;
                break;
            }
            auxiliar.apilar(actual);
        }

        // 2. Devolver las cajas de encima (si no se encontró, la pila queda exactamente igual).
        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }
        if (retirada == null) {
            return false;
        }

        // 3. Separar por posición (1 = cima). Las pilas auxiliares quedan invertidas.
        Pila<Caja> impares = new Pila<>();
        Pila<Caja> pares = new Pila<>();
        int posicion = 1;
        while (!pila.estaVacia()) {
            if (posicion % 2 != 0) impares.apilar(pila.desapilar());
            else pares.apilar(pila.desapilar());
            posicion++;
        }

        // 4. Reconstruir: primero el grupo que va al fondo, luego el que va arriba.
        //    Al desapilar las auxiliares salen del más profundo al más alto, así se conserva el orden.
        Pila<Caja> arriba = retirada.getValor() % 2 == 0 ? impares : pares;
        Pila<Caja> abajo = retirada.getValor() % 2 == 0 ? pares : impares;
        while (!abajo.estaVacia()) pila.apilar(abajo.desapilar());
        while (!arriba.estaVacia()) pila.apilar(arriba.desapilar());
        return true;
    }
}
