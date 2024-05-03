
package charquitec.Codigo;


public class Persona {
    public String nombre;
    public String apellido;
    public String codigo;

    public Persona(String nombre,String apellido, String codigo) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
