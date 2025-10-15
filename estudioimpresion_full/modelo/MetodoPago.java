package estudioimpresion.modelo;

public abstract class MetodoPago {
    protected String nombre;

    public MetodoPago(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean procesarPago(double monto);
}
