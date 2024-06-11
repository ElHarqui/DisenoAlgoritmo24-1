
package charquitec.Codigo;

import java.util.List;

public class GestionadorVendedor extends GestionadorPersona {

    public GestionadorVendedor(){
        unPersona = new Vendedor[MAX];
    }
    
    @Override
    public void Registrar(String nombre,String apellido, String codigo){
        if(numDato < MAX){
            Vendedor ObjDato = new Vendedor(nombre ,apellido,codigo);
            GuardarDatoXML(ObjDato.toStringXML(),"DataVendedores");
            this.unPersona[numDato]= ObjDato;
            numDato = numDato+1;
        }else{
            System.out.println("Limite de Vendedores sobrepasado");
        }
    } 

    @Override
    public void LeerDatosXML(){     //Lee el archivo xml y lo guarda en clases como el metodo registroVendedor() pero solo al iniciar el programa
        this.numDato = 0;
        PersistenciaXML Data = new PersistenciaXML("DataVendedores"+".xml");//Nombre de la ruta del archivo .xml
        List<String> UsuariosLeidos = Data.LeerArchivoXML();  //Guardar cada linea en un espacio del List<String>
        int tamano = UsuariosLeidos.size();                   //Obtener el largo del List<String>
        String UsuarioLeido ; 
        if (tamano < this.MAX){                               //Solo si no sobrepasa el maximo  se procede a crear los objetos tipo Vendedor y agregarlos al Lista de objetos
            for (int i = 0; i < tamano; i++){
               UsuarioLeido = UsuariosLeidos.get(i);
               String[] DataUsuario = UsuarioLeido.split(";");
               Vendedor ObjDato = new Vendedor(DataUsuario[1] ,DataUsuario[2],DataUsuario[0]);
               this.unPersona[numDato]=ObjDato;
               numDato = numDato+1;        
           }           
        }else{
            System.out.println("Limite de vendedores sobrepasado");
        }
    }
}
