package estudioimpresion.factory;

import estudioimpresion.modelo.*;
import java.util.Scanner;

public class MetodoPagoFactory {
    private static final Scanner sc = new Scanner(System.in);

    public static MetodoPago crearMetodo(int opcion) {
        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese número de tarjeta: ");
                String numero = sc.nextLine();
                System.out.print("Ingrese código CVV: ");
                String cvv = sc.nextLine();
                return new TarjetaCredito("Tarjeta de Crédito", numero, cvv);
            }
            case 2 -> {
                System.out.print("Ingrese correo de PayPal: ");
                String email = sc.nextLine();
                return new PayPal("PayPal", email);
            }
            case 3 -> {
                System.out.println("Pago en efectivo seleccionado.");
                return new Efectivo("Efectivo");
            }
            default -> throw new IllegalArgumentException("Opción de pago inválida.");
        }
    }
}
