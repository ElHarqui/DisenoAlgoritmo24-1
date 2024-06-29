
package charquitec.Codigo;


public class GestionadorProductoCarrito extends GestionadorProducto{
    final int MAX = 50; 
    int numDatoCarrito=0;
    public  Producto [] unProductoCarrito = new Producto[MAX];
    public void AgregarAlCarrito(String nombre, String ID, float precio, int cantidad){
        if(numDatoCarrito < MAX){
            Producto ObjDato = new Producto(nombre  ,ID,precio,cantidad);
            //GuardarProducto(ObjDato.toStringXML(),"DataVentas");
            this.unProducto[numDatoCarrito]=ObjDato;
            numDatoCarrito = numDatoCarrito+1;
            System.out.println(nombre+ID+precio+cantidad);
        }else{
            System.out.println("Limite de productos sobrepasado--");
        
     }       
    }
    public void eliminarProductoCarrito(String codigo){
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
    public int getnumDatoCarrito(){
        return this.numDatoCarrito;
    }
}
