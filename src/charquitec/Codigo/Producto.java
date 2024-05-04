
package charquitec.Codigo;


public class Producto {
    private String nombre;
    private String ID;
    private float precio;
    private int cantidad;

    public Producto(String nombre, String ID, float precio, int cantidad) {
        this.nombre = nombre;
        this.ID = ID;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto:" + "\nNombre:" + nombre + "\nID:" + ID + "\nPrecio:" + precio + "\nCantidad:" + cantidad ;
    }
    
}
