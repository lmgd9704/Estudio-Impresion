package estudioimpresion.factory;

import estudioimpresion.modelo.*;
import java.util.Scanner;

public class ProductoFactory {
    private static final Scanner sc = new Scanner(System.in);

    public static Producto crearProducto(int opcion) {
        switch (opcion) {
            case 1 -> {
                System.out.println("Seleccione nombre de la cámara:");
                System.out.println("1. Canon EOS");
                System.out.println("2. Nikon Coolpix");
                System.out.println("3. Sony Alpha");
                System.out.println("4. Otro");
                System.out.print("Opción: ");
                int nombreOpc = sc.nextInt(); sc.nextLine();

                String nombreCam = switch (nombreOpc) {
                    case 1 -> "Canon EOS";
                    case 2 -> "Nikon Coolpix";
                    case 3 -> "Sony Alpha";
                    default -> {
                        System.out.print("Ingrese nombre personalizado: ");
                        yield sc.nextLine();
                    }
                };

                System.out.println("Seleccione marca:");
                System.out.println("1. Canon");
                System.out.println("2. Nikon");
                System.out.println("3. Sony");
                System.out.println("4. Otra");
                System.out.print("Opción: ");
                int marcaOpc = sc.nextInt(); sc.nextLine();

                String marca = switch (marcaOpc) {
                    case 1 -> "Canon";
                    case 2 -> "Nikon";
                    case 3 -> "Sony";
                    default -> {
                        System.out.print("Ingrese marca personalizada: ");
                        yield sc.nextLine();
                    }
                };

                System.out.print("Ingrese modelo: ");
                String modelo = sc.nextLine();
                System.out.print("Ingrese precio: ");
                double precioCam = sc.nextDouble(); sc.nextLine();

                return new Camara(1, nombreCam, precioCam, marca, modelo);
            }

            case 2 -> {
                System.out.print("Ingrese nombre de la foto: ");
                String nombreFoto = sc.nextLine();
                System.out.println("Seleccione tamaño de impresión:");
                System.out.println("1. 4x6  \n2. 5x7  \n3. 8x10");
                System.out.print("Opción: ");
                int t = sc.nextInt(); sc.nextLine();
                String tamano = switch (t) {
                    case 1 -> "4x6";
                    case 2 -> "5x7";
                    case 3 -> "8x10";
                    default -> "Personalizado";
                };
                System.out.print("Color (Color / Blanco y Negro): ");
                String color = sc.nextLine();
                System.out.print("Resolución (ej: 1080p, 4K): ");
                String resolucion = sc.nextLine();

                System.out.println("Seleccione tipo de papel:");
                System.out.println("1. Brillante");
                System.out.println("2. Mate");
                System.out.println("3. Satinado");
                System.out.println("4. Otro");
                System.out.print("Opción: ");
                int papelOpc = sc.nextInt(); sc.nextLine();
                String tipoPapel = switch (papelOpc) {
                    case 1 -> "Cartulina";
                    case 2 -> "Bond";
                    case 3 -> "Papel Fotografico";
                    default -> {
                        System.out.print("Ingrese tipo de papel personalizado: ");
                        yield sc.nextLine();
                    }
                };

                System.out.print("Ingrese precio: ");
                double precioFoto = sc.nextDouble(); sc.nextLine();

                return new Foto(2, nombreFoto, precioFoto, tamano, color, resolucion, tipoPapel);
            }

            default -> throw new IllegalArgumentException("Opción de producto inválida.");
        }
    }
}
