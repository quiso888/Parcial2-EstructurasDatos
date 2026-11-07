package co.edu.uniquindio.estructuras.parcial2.ejercicio1;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;

/** Ejecuta los datos de prueba del ejercicio 1 y muestra lo que pide el enunciado. */
public class DemoEjercicio1 {

    public static final String EXPRESION = "(A + B) * C - (A - B) * D";

    public static Pila<Caja> pilaDePrueba() {
        Pila<Caja> pila = new Pila<>();
        pila.apilar(new Caja("C1", 2));
        pila.apilar(new Caja("C2", 4));
        pila.apilar(new Caja("C3", 6));
        pila.apilar(new Caja("C4", 8));
        pila.apilar(new Caja("C5", 3));
        pila.apilar(new Caja("C6", 9));
        pila.apilar(new Caja("C7", 5));
        return pila;
    }

    public static void ejecutar() {
        System.out.println("=== EJERCICIO 1A - Retiro de cajas ===");
        RetiroCajas retiro = new RetiroCajas();
        Pila<Caja> pila = pilaDePrueba();
        System.out.println("Pila inicial (tope -> fondo): " + pila);
        try {
            for (String codigo : new String[]{"C3", "C4", "C7"}) {
                boolean r = retiro.retirarCaja(pila, codigo);
                System.out.println("retirarCaja(" + codigo + ") = " + r + "  ->  " + pila);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(">>> PENDIENTE: " + e.getMessage());
            System.out.println("    (la parte B necesita la pila final de la parte A)");
            return;
        }
        System.out.println("Pila final (cima -> fondo):   " + pila);

        System.out.println();
        System.out.println("=== EJERCICIO 1B - Evaluación de la expresión ===");
        // Se toman los valores de las 4 cajas finales (de la cima al fondo).
        double[] v = new double[4];
        for (int i = 0; i < 4 && !pila.estaVacia(); i++) {
            v[i] = pila.desapilar().getValor();
        }
        double a = v[0];
        double b = v[1] / a;
        double c = v[2] + a;
        double d = (v[3] + c) * a;
        System.out.println("A = " + EvaluadorExpresiones.formatear(a)
                + ", B = " + EvaluadorExpresiones.formatear(b)
                + ", C = " + EvaluadorExpresiones.formatear(c)
                + ", D = " + EvaluadorExpresiones.formatear(d));

        EvaluadorExpresiones ev = new EvaluadorExpresiones();
        System.out.println("Infija:   " + EXPRESION);
        Cola<String> postfija = ev.infijaAPostfija(EXPRESION);
        System.out.println("Postfija: " + EvaluadorExpresiones.comoTexto(postfija));
        Cola<String> numerica = ev.reemplazarVariables(postfija,
                new String[]{"A", "B", "C", "D"}, new double[]{a, b, c, d});
        System.out.println("Con valores: " + EvaluadorExpresiones.comoTexto(numerica));

        Cola<PasoEvaluacion> tabla = new Cola<>();
        double resultado = ev.evaluarPostfija(numerica, tabla);
        System.out.println();
        System.out.println(String.format("%-8s | %-28s | %s", "Elemento", "Operación", "Pila (fondo -> cima)"));
        System.out.println("-".repeat(70));
        while (!tabla.estaVacia()) {
            System.out.println(tabla.desencolar());
        }
        System.out.println("Resultado final = " + EvaluadorExpresiones.formatear(resultado));
    }
}
