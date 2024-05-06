
package charquitec.Codigo;


public class GestionadorProductoCarrito {
    final int MAX = 10; 
    int numDato=0;
    public  Producto [] unProductoCarrito = new Producto[MAX];
    
    public void registroProducto(String nombre, String ID, float precio, int cantidad){
        if(numDato < MAX){
            Producto ObjDato = new Producto(nombre  ,ID,precio,cantidad);
            this.unProductoCarrito[numDato]=ObjDato;
            numDato = numDato+1;
        }
    }
    //comentario
    public int cantidadProductos(){   
        return numDato;
    }
    public void eliminarProductoCarrito(String codigo){
        for(int i = 0; i < numDato; i++) {
            if (unProductoCarrito[i].getID().equals(codigo)) {
                // Mover los elementos restantes una posición hacia atrás
                for(int j = i; j < numDato - 1; j++) {
                    unProductoCarrito[j] = unProductoCarrito[j + 1];
                }
                unProductoCarrito[numDato - 1] = null; // Asignar null al último elemento para evitar duplicados
                numDato--;
            }
        }
    }  
    public void registroProductoCarrito(String ID,String nombre,  float precio, int cantidad){
        if(numDato>=MAX){

        }
        else{
            Producto ObjDato = new Producto(nombre  ,ID,precio,cantidad);
            this.unProductoCarrito[numDato]=ObjDato;
            numDato = numDato+1;
        }
    }  
}
