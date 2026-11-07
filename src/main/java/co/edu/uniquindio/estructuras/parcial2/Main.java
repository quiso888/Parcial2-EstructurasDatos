package co.edu.uniquindio.estructuras.parcial2;

import co.edu.uniquindio.estructuras.parcial2.ejercicio1.DemoEjercicio1;
import co.edu.uniquindio.estructuras.parcial2.ejercicio2.DemoEjercicio2;
import co.edu.uniquindio.estructuras.parcial2.ejercicio3.DemoEjercicio3;
import co.edu.uniquindio.estructuras.parcial2.ejercicio4.DemoEjercicio4;

import java.util.Scanner;

/**
 * Punto de entrada. Menú en consola para ejecutar cada ejercicio con los datos del enunciado.
 * El ejercicio 5 (AVL y rojo-negro) se resuelve a mano en el documento.
 * También acepta un argumento: 1..4 para un ejercicio, "todos" para ejecutar todo sin menú.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            ejecutarOpcion(args[0]);
            return;
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("===== PARCIAL 2 - ESTRUCTURAS DE DATOS =====");
            System.out.println("1. Retiro de cajas y evaluación de expresión");
            System.out.println("2. Segmento del historial");
            System.out.println("3. Selección de paquetes (recursivo)");
            System.out.println("4. ABB: consulta por rango y eliminación");
            System.out.println("5. Ejecutar todo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            if (!sc.hasNextLine()) return;
            String op = sc.nextLine().trim();
            if (op.equals("0")) return;
            ejecutarOpcion(op.equals("5") ? "todos" : op);
        }
    }

    private static void ejecutarOpcion(String op) {
        switch (op) {
            case "1": seguro(DemoEjercicio1::ejecutar); break;
            case "2": seguro(DemoEjercicio2::ejecutar); break;
            case "3": seguro(DemoEjercicio3::ejecutar); break;
            case "4": seguro(DemoEjercicio4::ejecutar); break;
            case "todos":
                seguro(DemoEjercicio1::ejecutar);
                System.out.println();
                seguro(DemoEjercicio2::ejecutar);
                System.out.println();
                seguro(DemoEjercicio3::ejecutar);
                System.out.println();
                seguro(DemoEjercicio4::ejecutar);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    /** Ejecuta una demo; si un método aún no está implementado muestra un aviso en vez de caerse. */
    private static void seguro(Runnable demo) {
        try {
            demo.run();
        } catch (UnsupportedOperationException e) {
            System.out.println(">>> PENDIENTE: " + e.getMessage());
        }
    }
}
