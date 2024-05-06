
package charquitec.Codigo;

import java.util.List;


public class GestionadorProducto {
    final int MAX = 10; 
    int numDato=0;
    public  Producto [] unProducto = new Producto[MAX];
    public GestionadorProducto(){
        
    }
    
    public void registroProducto(String nombre, String ID, float precio, int cantidad){
        if(numDato < MAX){
            Producto ObjDato = new Producto(nombre  ,ID,precio,cantidad);
            GuardarProducto(ObjDato.toStringXML(),"DataProductos");
            this.unProducto[numDato]=ObjDato;
            numDato = numDato+1;
        }else{
            System.out.println("Limite de productos sobrepasado");
        }
    }
    public void GuardarProducto(String StringXML,String NombreArchivo){
       PersistenciaXML Data = new PersistenciaXML("charquitec\\Data\\"+NombreArchivo+".xml");
       Data.EscribirLineaXML(StringXML);
       
    }
    public void LeerDatosXML(){     //Lee el archivo xml y lo guarda en clases como el metodo registroProducto() pero solo al iniciar el programa
        this.numDato = 0;
        PersistenciaXML Data = new PersistenciaXML("charquitec\\Data\\"+"DataProductos"+".xml");//Nombre de la ruta del archivo .xml
        List<String> ProductosLeidos = Data.LeerArchivoXML();  //Guardar cada linea en un espacio del List<String>
        int tamano = ProductosLeidos.size();                   //Obtener el largo del List<String>
        String ProductoLeido ; 
        if (tamano < this.MAX){                               //Solo si no sobrepasa el maximo  se procede a crear los objetos tipo Producto y agregarlos al Lista de objetos
            for (int i = 0; i < tamano; i++){
               ProductoLeido = ProductosLeidos.get(i);
               String[] DataProducto = ProductoLeido.split(";");
               Producto ObjDato = new Producto(DataProducto[1] ,DataProducto[0],Float.parseFloat(DataProducto[2]),Integer.parseInt(DataProducto[3]));
               this.unProducto[numDato]=ObjDato;
               numDato = numDato+1;        

           }           
        }else{
            System.out.println("Limite de Productos sobrepasado");
        }
    }
    //comentario ESTO DEBERIAS HACERLO CON UN GETTER
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
    public int getnumDato(){
        return this.numDato;
    }
    public Producto getProducto(int i){
        return this.unProducto[i];
    }
    
}
