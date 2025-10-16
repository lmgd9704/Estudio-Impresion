package estudioimpresion.modelo;

public class Efectivo extends MetodoPago {

    public Efectivo(String nombre) {
        super(nombre);
    }


    public boolean procesarPago(double monto) {
        System.out.println("Pago en efectivo recibido por $" + monto);
        return true;
    }
}
