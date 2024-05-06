package charquitec.Codigo;

public class Cliente extends Persona {

    public Cliente(String nombre,String apellido, String codigo) {
        super(nombre,apellido, codigo);
    }
    @Override
    public String toString() {
        return "Cliente:"+getNombre()+"\nApellido:"+getApellido()+"\nCodigo:"+getCodigo();
    }
    
}
