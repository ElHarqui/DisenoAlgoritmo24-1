
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
    public void registroProductoCarrito(String ID,String nombre,  float precio, int cantidad){
        if(numDato>=MAX){

        }
        else{
            Producto ObjDato = new Producto(nombre  ,ID,precio,cantidad);
            this.unProducto[numDato]=ObjDato;
            numDato = numDato+1;
        }
    }
    public int ObtenerCantidad(String codigo){
        int cantidad=0;
        for(int i=0; i< numDato - 1; i++) {
            if(codigo.equals(unProducto[i].getID())){
                cantidad=unProducto[i].getCantidad();
                System.out.println("Se leyo esto");
            }
        }
        return cantidad;
    }
    public void ActualizarCantidad(String codigo,int cantidad){
        for(int i=0; i< numDato - 1; i++) {
            if(codigo==unProducto[i].getID()){
                unProducto[i].setCantidad(cantidad);
            }
        }
    }
    
    }

