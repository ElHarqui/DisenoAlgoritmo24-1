
package charquitec.Codigo;


public abstract class GestionadorPersona {
    final int MAX = 50; 
    int numDato=0;
    public  Persona [] unPersona;
    
    public abstract void Registrar(String nombre,String apellido, String codigo);
    public abstract void Eliminar(String codigo);
    public abstract void LeerDatosXML();
    

    public int cantidadPersona(){   
        return this.numDato;
    }
    
    public Persona getPersona(int i){
        return this.unPersona[i];
    }
}
