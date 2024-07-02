
package charquitec.Codigo;

import java.util.Objects;
public class Nodo {
    String nombre;
    boolean esRol;
    public String vendedor;
    public String cliente;
    public String monto;
    public Nodo siguiente;
    
    public Nodo(String nombre, boolean esRol) {
        this.nombre = nombre;
        this.esRol = esRol;
    }
    public Nodo(String vendedor, String cliente, String monto) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.monto = monto;
        this.siguiente = null;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return nombre.equals(nodo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    

    @Override
    public String toString() {
        return nombre;
    }
}
