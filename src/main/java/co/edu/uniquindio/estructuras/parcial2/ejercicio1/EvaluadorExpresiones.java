package co.edu.uniquindio.estructuras.parcial2.ejercicio1;

import co.edu.uniquindio.estructuras.parcial2.estructuras.Cola;
import co.edu.uniquindio.estructuras.parcial2.estructuras.Pila;

/**
 * Ejercicio 1 (parte B) - Conversión de infija a postfija y evaluación con pila.
 * Responsable: Sergio.
 *
 * Los tokens se manejan en una Cola propia (frente = primer token).
 * Variables: letras (A, B, C, D). Operadores: + - * / ^ y paréntesis.
 */
public class EvaluadorExpresiones {

    /** Separa una expresión como "(A + B) * C" en tokens: ( A + B ) * C. Ya implementado. */
    public Cola<String> tokenizar(String expresion) {
        Cola<String> tokens = new Cola<>();
        String limpia = expresion.replace('×', '*').replace('÷', '/').replace('−', '-');
        int i = 0;
        while (i < limpia.length()) {
            char c = limpia.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
            } else if (Character.isLetterOrDigit(c) || c == '.') {
                int inicio = i;
                while (i < limpia.length() && (Character.isLetterOrDigit(limpia.charAt(i)) || limpia.charAt(i) == '.')) i++;
                tokens.encolar(limpia.substring(inicio, i));
            } else {
                tokens.encolar(String.valueOf(c));
                i++;
            }
        }
        return tokens;
    }

    public static boolean esOperador(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("^");
    }

    public static int prioridad(String op) {
        switch (op) {
            case "^": return 3;
            case "*": case "/": return 2;
            case "+": case "-": return 1;
            default: return 0;
        }
    }

    /**
     * Convierte de notación infija a POSTFIJA con el algoritmo visto en clase (pila de operadores).
     * Ejemplo: "(A + B) * C" -> cola [A, B, +, C, *].
     */
    public Cola<String> infijaAPostfija(String expresion) {
        Cola<String> entrada = tokenizar(expresion);
        Cola<String> salida = new Cola<>();
        Pila<String> operadores = new Pila<>();
        while (!entrada.estaVacia()) {
            String t = entrada.desencolar();
            if (t.equals("(")) {
                operadores.apilar(t);
            } else if (t.equals(")")) {
                while (!operadores.estaVacia() && !operadores.cima().equals("(")) {
                    salida.encolar(operadores.desapilar());
                }
                if (!operadores.estaVacia()) operadores.desapilar(); // quita "("
            } else if (esOperador(t)) {
                // ^ es asociativo a la derecha; los demás a la izquierda
                while (!operadores.estaVacia() && esOperador(operadores.cima())
                        && (prioridad(operadores.cima()) > prioridad(t)
                            || (prioridad(operadores.cima()) == prioridad(t) && !t.equals("^")))) {
                    salida.encolar(operadores.desapilar());
                }
                operadores.apilar(t);
            } else {
                salida.encolar(t); // operando
            }
        }
        while (!operadores.estaVacia()) {
            salida.encolar(operadores.desapilar());
        }
        return salida;
    }

    /**
     * Reemplaza cada variable de la expresión postfija por su valor. Ya implementado.
     * nombres[i] se reemplaza por valores[i]. La cola original no se modifica.
     */
    public Cola<String> reemplazarVariables(Cola<String> postfija, String[] nombres, double[] valores) {
        Cola<String> resultado = new Cola<>();
        int n = postfija.tamanio();
        for (int k = 0; k < n; k++) {
            String t = postfija.desencolar();
            postfija.encolar(t); // se rota para dejar la cola original intacta
            String reemplazo = t;
            for (int i = 0; i < nombres.length; i++) {
                if (nombres[i].equals(t)) reemplazo = formatear(valores[i]);
            }
            resultado.encolar(reemplazo);
        }
        return resultado;
    }

    /**
     * Evalúa una expresión POSTFIJA numérica usando una Pila propia.
     * Por cada token agrega un PasoEvaluacion a la cola 'tabla' (elemento, operación, pila después del paso).
     *   - Operando: se apila.                         operación: "Apilar 2"
     *   - Operador: se desapilan b (cima) y a, se calcula a op b y se apila el resultado.
     *                                                 operación: "2 + 4.5 = 6.5"
     * Retorna el resultado final (el único elemento que queda en la pila).
     */
    public double evaluarPostfija(Cola<String> postfija, Cola<PasoEvaluacion> tabla) {
        Pila<Double> pila = new Pila<>();
        int n = postfija.tamanio();
        for (int k = 0; k < n; k++) {
            String t = postfija.desencolar();
            postfija.encolar(t);
            String operacion;
            if (esOperador(t)) {
                double b = pila.desapilar();
                double a = pila.desapilar();
                double r = operar(a, b, t);
                pila.apilar(r);
                operacion = formatear(a) + " " + t + " " + formatear(b) + " = " + formatear(r);
            } else {
                double valor = Double.parseDouble(t);
                pila.apilar(valor);
                operacion = "Apilar " + formatear(valor);
            }
            if (tabla != null) tabla.encolar(new PasoEvaluacion(t, operacion, pilaComoTexto(pila)));
        }
        return pila.desapilar();
    }

    /** Aplica el operador. Ya implementado. */
    public static double operar(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "^": return Math.pow(a, b);
            default: throw new IllegalArgumentException("Operador no válido: " + op);
        }
    }

    /** Muestra la pila de fondo a cima, como se escribe en la tabla: [2 | 4.5]. Ya implementado. */
    public static String pilaComoTexto(Pila<Double> pila) {
        Pila<Double> aux = new Pila<>();
        while (!pila.estaVacia()) aux.apilar(pila.desapilar());
        StringBuilder sb = new StringBuilder("[");
        while (!aux.estaVacia()) {
            double v = aux.desapilar();
            sb.append(formatear(v));
            if (!aux.estaVacia()) sb.append(" | ");
            pila.apilar(v);
        }
        return sb.append("]").toString();
    }

    /** 6.0 -> "6", 4.5 -> "4.5". Ya implementado. */
    public static String formatear(double v) {
        if (v == Math.rint(v) && !Double.isInfinite(v)) return String.valueOf((long) v);
        return String.valueOf(Math.round(v * 10000) / 10000.0);
    }

    /** Une los tokens de una cola en un texto separado por espacios. Ya implementado. */
    public static String comoTexto(Cola<String> tokens) {
        StringBuilder sb = new StringBuilder();
        int n = tokens.tamanio();
        for (int k = 0; k < n; k++) {
            String t = tokens.desencolar();
            sb.append(t).append(' ');
            tokens.encolar(t);
        }
        return sb.toString().trim();
    }
}
