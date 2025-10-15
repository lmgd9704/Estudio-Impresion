package estudioimpresion.modelo;

public class TarjetaCredito extends MetodoPago {
    private String numero;
    private String cvv;

    public TarjetaCredito(String nombre, String numero, String cvv) {
        super(nombre);
        this.numero = numero;
        this.cvv = cvv;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con tarjeta " + numero + " por $" + monto);
        return true;
    }
}
