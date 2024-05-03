/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charquitec.Codigo;

import java.util.ArrayList;


public class GestionadorAdministrador {
    private String usuario="wonder";
    private String contrasena="123";
    ArrayList<Vendedor>arregloVendedor=new ArrayList<>();
    ArrayList<Producto>arregloProducto=new ArrayList<>();
    public GestionadorAdministrador() {
       
    }
    public boolean VerificarUsuario(String usu, String contra){
        if(usuario.equals(usu)){
            if(contra.equals(contra)){
                return true;                
            }
        }
        return false;
    }
    public void RegistrarVendedor(Vendedor unvendedor){
        arregloVendedor.add(unvendedor);
    }
    public void RegistrarProducto(Producto unproducto){
        arregloProducto.add(unproducto);
    }
    public String MostrarVendedor(){
        String datosVendedor="----LISTA VENDEDORES-----";
        for(int i=0;i<arregloVendedor.size();i++){
            datosVendedor=arregloVendedor.toString()+datosVendedor;
            
        }
        return datosVendedor;
    }
}
