package estudioimpresion.modelo;

public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precio;

    public Producto() {}

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double obtenerPrecio();

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
