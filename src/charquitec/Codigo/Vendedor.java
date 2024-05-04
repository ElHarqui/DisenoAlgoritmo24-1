
package charquitec.Codigo;


public class Vendedor extends Persona {
    
    public Vendedor(String nombre,String apellido, String codigo) {
        super(nombre,apellido, codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return "Vendedor:"+nombre+"\nApellido:"+apellido+"\nCodigo:"+codigo;
    }
    
}
