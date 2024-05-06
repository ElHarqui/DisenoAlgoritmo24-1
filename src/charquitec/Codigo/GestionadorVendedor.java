
package charquitec.Codigo;

public class GestionadorVendedor {
    final int MAX = 10; 
    int numDato=0;
    public  Vendedor [] unVendedor = new Vendedor[MAX];
    
    public void registroVendedor(String nombre,String apellido, String codigo){
        if(numDato < MAX){
            Vendedor ObjDato = new Vendedor(nombre  ,apellido,codigo);
            this.unVendedor[numDato]=ObjDato;
            numDato = numDato+1;
        }
    }
    //comentario
    public int cantidadVendedor(){   
        return numDato;
    }
    public void eliminarVendedor(String codigo){
        for(int i = 0; i < numDato; i++) {
            if (unVendedor[i].getCodigo().equals(codigo)) {
                // Mover los elementos restantes una posición hacia atrás
                for(int j = i; j < numDato - 1; j++) {
                    unVendedor[j] = unVendedor[j + 1];
                }
                unVendedor[numDato - 1] = null; // Asignar null al último elemento para evitar duplicados
                numDato--;
            }
        }
    }  
}
