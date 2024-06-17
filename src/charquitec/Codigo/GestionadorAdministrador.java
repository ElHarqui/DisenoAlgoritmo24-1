/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charquitec.Codigo;

public class GestionadorAdministrador {
    private final String usuario = "wonder";
    private final String contrasena = "123";
    public GestionadorAdministrador() {
       
    }
    public boolean VerificarUsuario(String usu, String contra){
        boolean vertificar = false;
        if(this.usuario.equals(usu)){
            if(this.contrasena.equals(contra)){
                vertificar = true;                
            }
        }
        return vertificar;
    }


}
