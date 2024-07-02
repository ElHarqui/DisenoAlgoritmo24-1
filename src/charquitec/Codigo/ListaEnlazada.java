/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package charquitec.Codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class ListaEnlazada {
    public Nodo cabeza;
    PersistenciaXML dataReporte=new PersistenciaXML("DataReporte.xml");
    
    public void insertarFinal(String vendedor,String cliente,String monto){
        Nodo nuevoReporte = new Nodo(vendedor, cliente, monto);
        if (cabeza == null) {
            cabeza = nuevoReporte;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente=nuevoReporte;
        }
        dataReporte.EscribirLineaXML(vendedor+";"+cliente+";"+monto);
    }
    public Nodo getCabeza() {
        return cabeza;
    }
    public void LeerDatosXML(){     //Lee el archivo xml y lo guarda en clases como el metodo registroProducto() pero solo al iniciar el programa
        List<String> ReportesLeidos = dataReporte.LeerArchivoXML();
        int tamano = ReportesLeidos.size();     //Obtener el largo del List<String>
        String linea;
        if (tamano <50){                               //Solo si no sobrepasa el maximo  se procede a crear los objetos tipo Producto y agregarlos al Lista de objetos
            for (int i = 0; i < tamano; i++){   
               linea=ReportesLeidos.get(i);
               String[] datos = linea.split(";");
                if (datos.length == 3) {
                    Nodo nuevoReporte = new Nodo(datos[0], datos[1], datos[2]);
                    if (cabeza == null) {
                        cabeza = nuevoReporte;
                    } else {
                        Nodo temp = cabeza;
                        while (temp.siguiente != null) {
                            temp = temp.siguiente;
                        }
                        temp.siguiente=nuevoReporte;
                    }
                }
           }           
        }else{
            System.out.println("Limite de ");
        }
    }
}
