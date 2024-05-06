
package charquitec.Codigo;

import java.util.ArrayList;
import java.util.List;


public class GestionadorCliente extends GestionadorPersona {
    final int MAX = 10; 
    int numDato=0;
    public  Cliente [] unCliente = new Cliente[MAX];
    
    public void GuardarCliente(String StringXML,String NombreArchivo){
       PersistenciaXML Data = new PersistenciaXML("charquitec\\Data\\"+NombreArchivo+".xml");
       Data.EscribirLineaXML(StringXML);
       
    }
    public void LeerClientes(){     //Lee el archivo xml y lo guarda en clases como el metodo registroCliente() pero solo al iniciar el programa
        this.numDato = 0;
        PersistenciaXML Data = new PersistenciaXML("charquitec\\Data\\"+"DataClientes"+".xml");//Nombre de la ruta del archivo .xml
        List<String> UsuariosLeidos = Data.LeerArchivoXML();  //Guardar cada linea en un espacio del List<String>
        int tamano = UsuariosLeidos.size();                   //Obtener el largo del List<String>
        String UsuarioLeido ; 
        if (tamano < this.MAX){                               //Solo si no sobrepasa el maximo  se procede a crear los objetos tipo cliente y agregarlos al Lista de objetos
            for (int i = 0; i < tamano; i++){
               UsuarioLeido = UsuariosLeidos.get(i);
               String[] DataUsuario = UsuarioLeido.split(";");
               Cliente ObjDato = new Cliente(DataUsuario[1] ,DataUsuario[2],DataUsuario[0]);
               this.unCliente[numDato]=ObjDato;
               numDato = numDato+1;        
           }           
        }else{
            System.out.println("Limite de clientes sobrepasado");
        }
    }
}
