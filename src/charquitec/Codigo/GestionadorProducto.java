
package charquitec.Codigo;

import java.util.List;
import java.util.Map;


public class GestionadorProducto {

    final int MAX = 50; 

    int numDato=0;
    public  Producto [] unProducto = new Producto[MAX];
    PersistenciaXML dataProducto=new PersistenciaXML("DataProductos.xml");
    public GestionadorProducto(){
        
    }
    
    public boolean registroProducto(String ID, String nombre, float precio, int cantidad) {
        if (existeProducto(ID)) {
            System.out.println("Ya existe un producto con el ID: " + ID);
            return false; 
        }

        if (numDato < MAX) {
            Producto ObjDato = new Producto(ID, nombre, precio, cantidad);
            dataProducto.EscribirLineaXML(ObjDato.toStringXML());
            this.unProducto[numDato] = ObjDato;
            numDato = numDato + 1;
            System.out.println("Producto registrado con éxito: " + ID);
            return true; // Registro exitoso
        } else {
            System.out.println("Límite de productos sobrepasado");
            return false; // No se pudo registrar por límite alcanzado
        }
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
        dataProducto.EliminarPorID(codigo);
    }
    /*
    public void LeerDatosXML(){     //Lee el archivo xml y lo guarda en clases como el metodo registroProducto() pero solo al iniciar el programa
        this.numDato = 0;
        PersistenciaXML Data = new PersistenciaXML("DataProductos.xml");
        System.out.println("lee");
        ProductosLeidos = Data.LeerArchivoXML();

        int tamano = ProductosLeidos.size();     //Obtener el largo del List<String>
        System.out.println("el tamaño es de "+tamano);

        String ProductoLeido ; 
        if (tamano <+this.MAX){                               //Solo si no sobrepasa el maximo  se procede a crear los objetos tipo Producto y agregarlos al Lista de objetos
            for (int i = 0; i < tamano; i++){
               ProductoLeido = ProductosLeidos.get(i);
               String[] DataProducto = ProductoLeido.split(";");
               Producto ObjDato = new Producto(DataProducto[0] ,DataProducto[1],Float.parseFloat(DataProducto[2]),Integer.parseInt(DataProducto[3]));
               this.unProducto[numDato]=ObjDato;
               numDato = numDato+1;        

           }           
        }else{
            System.out.println("Limite de ");
        }
    }
*/

    //comentario ESTO DEBERIAS HACERLO CON UN GETTER
    public int cantidadProductos(){   
        return numDato;
    }  
    public int ObtenerCantidad(String codigo) {
        int cantidad = 0;
        for (int i = 0; i < numDato; i++) {  // Cambiado a i < numDato
            if (codigo.equals(unProducto[i].getID())) {
                cantidad = unProducto[i].getCantidad();
                return cantidad; // Retorno temprano
            }
        }
        return cantidad; // Retornar cantidad por defecto (0) si no se encuentra el producto
    }

    public int getnumDato(){
        return this.numDato;
    }
    public Producto getProducto(int i){
        return this.unProducto[i];
    }
      
    public boolean existeProducto(String ID) {
    for (int i = 0; i < numDato; i++) {
        if (unProducto[i] != null && unProducto[i].getID().equals(ID)) {
            return true;
        }
    }
    return false;
}
    public void LeerDatosXMLHASH(){     //Lee el archivo xml y lo guarda en clases como el metodo registroProducto() pero solo al iniciar el programa
        this.numDato = 0;
        GestionadorTablaHash Data = new GestionadorTablaHash("hashTable.xml");
        //PersistenciaXML Data = new PersistenciaXML("DataProductos.xml");
        System.out.println("lee");
       
        Map<String, String>  ProductosLeidos =  Data.loadFromXML();
       // List<String> ProductosLeidos = Data.LeerArchivoXML();

        int tamano = ProductosLeidos.size();     //Obtener el largo del List<String>
        System.out.println("el tamaño es de "+tamano);

        String ProductoLeido ; 
        if (tamano <+this.MAX){                               //Solo si no sobrepasa el maximo  se procede a crear los objetos tipo Producto y agregarlos al Lista de objetos
            for (int i = 0; i < tamano; i++){
               ProductoLeido = ProductosLeidos.get(i);
               String[] DataProducto = ProductoLeido.split(";");
               Producto ObjDato = new Producto(DataProducto[0] ,DataProducto[1],Float.parseFloat(DataProducto[2]),Integer.parseInt(DataProducto[3]));
               this.unProducto[numDato]=ObjDato;
               numDato = numDato+1;        

           }           
        }else{
            System.out.println("Limite de ");
        }
    }

    
}
