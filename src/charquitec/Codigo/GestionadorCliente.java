/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package charquitec.Codigo;

/**
 *
 * @author CARLOS
 */
public class GestionadorCliente {
    int MAX = 10; 
    int numDato=0;
    public  Cliente [] unCliente = new Cliente[MAX];
    
    public void registroCliente(String nombre,String apellido, String codigo){
        if(numDato>=MAX){

        }
        else{
            Cliente ObjDato = new Cliente(nombre  ,apellido,codigo);
            this.unCliente[numDato]=ObjDato;
            numDato = numDato+1;
        }
    }
    //comentario
    public int cantidadCliente(){   
        return numDato;
    }
    public void eliminarCliente(String codigo){
        for(int i = 0; i < numDato; i++) {
            if (unCliente[i].getCodigo().equals(codigo)) {
                // Mover los elementos restantes una posición hacia atrás
                for(int j = i; j < numDato - 1; j++) {
                    unCliente[j] = unCliente[j + 1];
                }
                unCliente[numDato - 1] = null; // Asignar null al último elemento para evitar duplicados
                numDato--;
            }
        }
    }  
}
