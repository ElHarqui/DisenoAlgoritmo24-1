
package charquitec.Codigo;


public class Vendedor extends Persona {
    
    public Vendedor(String nombre,String apellido, String codigo) {
        super(nombre,apellido, codigo);
    }

    @Override
    public String toString() {
        return "Vendedor:"+nombre+"\nApellido:"+apellido+"\nCodigo:"+codigo;
    }
    
}
