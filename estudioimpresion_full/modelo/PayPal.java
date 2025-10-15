package estudioimpresion.modelo;

public class PayPal extends MetodoPago {
    private String email;

    public PayPal(String nombre, String email) {
        super(nombre);
        this.email = email;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal (" + email + ") por $" + monto);
        return true;
    }
}
