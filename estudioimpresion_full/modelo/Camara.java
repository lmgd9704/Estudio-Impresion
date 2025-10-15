package estudioimpresion.modelo;

public class Camara extends Producto {
    private String marca;
    private String modelo;

    public Camara(int id, String nombre, double precio, String marca, String modelo) {
        super(id, nombre, precio);
        this.marca = marca;
        this.modelo = modelo;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public String toString() {
        return "Cámara: " + nombre + " (" + marca + " - " + modelo + ")";
    }
}
