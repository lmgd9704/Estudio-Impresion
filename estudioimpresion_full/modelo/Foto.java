package estudioimpresion.modelo;

public class Foto extends Producto {
    private String tamano;
    private String color;
    private String resolucion;
    private String tipoPapel;

    public Foto(int id, String nombre, double precio, String tamano, String color, String resolucion, String tipoPapel) {
        super(id, nombre, precio);
        this.tamano = tamano;
        this.color = color;
        this.resolucion = resolucion;
        this.tipoPapel = tipoPapel;
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Foto: " + nombre + " [" + tamano + ", " + color + ", " + resolucion + ", Papel: " + tipoPapel + "]";
    }
}
