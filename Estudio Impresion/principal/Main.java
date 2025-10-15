package estudioimpresion.principal;

import estudioimpresion.modelo.*;
import estudioimpresion.factory.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Colores ANSI (pueden no funcionar en todas las consolas)
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_BOLD = "\u001B[1m"; // Negrita

        // Marco superior
        System.out.println(ANSI_BLUE + ANSI_BOLD + "╔══════════════════════════════════════╗" + ANSI_RESET);
        System.out.println(ANSI_BLUE + ANSI_BOLD + "║==== ESTUDIO DE IMPRESIONES ==== " + ANSI_RESET + "\uD83D\uDDA8" + ANSI_BLUE + ANSI_BOLD + "║" + ANSI_RESET);
        System.out.println(ANSI_BLUE + ANSI_BOLD + "╚══════════════════════════════════════╝" + ANSI_RESET);

        System.out.println("\n" + ANSI_YELLOW + ANSI_BOLD + "¡BIENVENIDO! " + ANSI_RESET + "AQUÍ PUEDES CONFIGURAR TU PEDIDO DE IMPRESIÓN.\n");

        // Selección del tipo de producto
        int opcionProd = obtenerOpcionProducto(sc, ANSI_YELLOW, ANSI_RESET, ANSI_BOLD);
        Producto producto = ProductoFactory.crearProducto(opcionProd);

        System.out.println("\n" + ANSI_GREEN + ANSI_BOLD + "¡PERFECTO, HAS SELECCIONADO:" + ANSI_RESET);
        System.out.println(producto);
        System.out.println("PRECIO BASE: $" + producto.obtenerPrecio() + "\n");

        // Selección del método de pago
        int opcionPago = obtenerOpcionPago(sc, ANSI_YELLOW, ANSI_RESET, ANSI_BOLD);
        MetodoPago pago = MetodoPagoFactory.crearMetodo(opcionPago);

        // Procesamiento del pago
        System.out.println("\n" + ANSI_YELLOW + ANSI_BOLD + "PROCESANDO PAGO CON " + ANSI_RESET + pago.getClass().getSimpleName().toUpperCase() + "...");
        pago.procesarPago(producto.obtenerPrecio());

        //Marco inferior
        System.out.println(ANSI_BLUE + ANSI_BOLD + "╔══════════════════════════════════════╗" + ANSI_RESET);
        System.out.println(ANSI_GREEN + ANSI_BOLD + "✅ ¡PEDIDO COMPLETADO CON ÉXITO!" + ANSI_RESET + ANSI_BLUE + ANSI_BOLD + "║" + ANSI_RESET);
        System.out.println(ANSI_GREEN + ANSI_BOLD + "GRACIAS POR TU COMPRA. ¡QUE DISFRUTES DE TU IMPRESIÓN!" + ANSI_RESET + " \uD83D\uDE0A\n");
        System.out.println(ANSI_BLUE + ANSI_BOLD + "╚══════════════════════════════════════╝" + ANSI_RESET);

        sc.close();
    }

    // Métodos para obtener opciones del usuario con validación
    private static int obtenerOpcionProducto(Scanner sc, String ANSI_YELLOW, String ANSI_RESET, String ANSI_BOLD) {
        int opcion;
        while (true) {
            System.out.println(ANSI_YELLOW + ANSI_BOLD + "SELECCIONE EL TIPO DE PRODUCTO:" + ANSI_RESET);
            System.out.println("1. CÁMARA \uD83D\uDCF7");
            System.out.println("2. FOTO \uD83D\uDDBC");
            System.out.print("OPCIÓN: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (opcion >= 1 && opcion <= 2) {
                    return opcion;
                } else {
                    System.out.println(ANSI_YELLOW + ANSI_BOLD + "OPCIÓN INVÁLIDA. POR FAVOR, SELECCIONE 1 O 2." + ANSI_RESET + "\n");
                }
            } else {
                System.out.println(ANSI_YELLOW + ANSI_BOLD + "ENTRADA INVÁLIDA. POR FAVOR, INGRESE UN NÚMERO." + ANSI_RESET + "\n");
                sc.next(); // Limpiar entrada inválida
            }
        }
    }

    private static int obtenerOpcionPago(Scanner sc, String ANSI_YELLOW, String ANSI_RESET, String ANSI_BOLD) {
        int opcion;
        while (true) {
            System.out.println(ANSI_YELLOW + ANSI_BOLD + "SELECCIONE UN MÉTODO DE PAGO:" + ANSI_RESET);
            System.out.println("1. TARJETA DE CRÉDITO \uD83D\uDCB3");
            System.out.println("2. PAYPAL \uD83D\uDCB3");
            System.out.println("3. EFECTIVO \uD83D\uDCB5");
            System.out.print("OPCIÓN: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (opcion >= 1 && opcion <= 3) {
                    return opcion;
                } else {
                    System.out.println(ANSI_YELLOW + ANSI_BOLD + "OPCIÓN INVÁLIDA. POR FAVOR, SELECCIONE 1, 2 O 3." + ANSI_RESET + "\n");
                }
            } else {
                System.out.println(ANSI_YELLOW + ANSI_BOLD + "ENTRADA INVÁLIDA. POR FAVOR, INGRESE UN NÚMERO." + ANSI_RESET + "\n");
                sc.next(); // Limpiar entrada inválida
            }
        }
    }
}

