
package charquitec.Codigo;

public class GestionadorProducto {
    int MAX = 10; 
    int numDato=0;
    public  Producto [] unProducto = new Producto[MAX];
    
    public void registroProducto(String nombre, String ID, float precio, int cantidad){
        if(numDato>=MAX){

        }
        else{
            Producto ObjDato = new Producto(nombre  ,ID,precio,cantidad);
            this.unProducto[numDato]=ObjDato;
            numDato = numDato+1;
        }
    }
    //comentario
    public int cantidadProductos(){   
        return numDato;
    }
    public void eliminarProducto(String codigo){
        for(int i = 0; i < numDato; i++) {
            if (unProducto[i].getID().equals(codigo)) {
                // Mover los elementos restantes una posición hacia atrás
                for(int j = i; j < numDato - 1; j++) {
                    unProducto[j] = unProducto[j + 1];
                }
                unProducto[numDato - 1] = null; // Asignar null al último elemento para evitar duplicados
                numDato--;
            }
        }
    }   
    }

