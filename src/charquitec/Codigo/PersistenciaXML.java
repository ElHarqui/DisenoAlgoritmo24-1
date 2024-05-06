package charquitec.Codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersistenciaXML {

    private File file; // Referencia al archivo XML

    public PersistenciaXML(String filename) {
        this.file = new File(filename); // Inicializar el archivo con el nombre proporcionado
    }

    public List<String> LeerArchivoXML() {
        List<String> lines = new ArrayList<>(); // Crear una lista para almacenar las líneas del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { // Abrir el archivo para lectura
            String line;
            while ((line = br.readLine()) != null) { // Leer cada línea del archivo
                lines.add(line); // Agregar la línea a la lista
            }
        } catch (IOException e) { // Manejar excepciones de E/S
            e.printStackTrace(); // Imprimir la traza de la excepción
        }
        return lines; // Devolver la lista de líneas leídas del archivo
    }

    public void EscribirLineaXML(String line) {
        try (FileWriter writer = new FileWriter(file, file.exists())) { // Abrir el archivo para escritura (modo de anexión si existe)
            writer.write(line + "\n"); // Escribir la línea de texto seguida de un salto de línea
        } catch (IOException e) { // Manejar excepciones de E/S
            e.printStackTrace(); // Imprimir la traza de la excepción
        }
    }

    /**
     * Método principal para probar la funcionalidad de la clase.
     * @param args Argumentos de línea de comandos (no utilizados en este ejemplo).
     
    public static void main(String[] args) {
        PersistenciaXML ArchivoDATA = new PersistenciaXML("charquitec\\Data\\example.xml"); // Crear un PersistenciaXML/ example.xml cambiar por la ruta deseada
        
        
        // Si el archivo existe, leer su contenido existente
        if (ArchivoDATA.file.exists()) {
            List<String> existingLines = ArchivoDATA.LeerArchivoXML();
            for (String line : existingLines) {
                System.out.println("Contenido existente: " + line);
            }
        } else {
            System.out.println("El archivo no existe. Se creará uno nuevo.");
        }
        
        // Escribir algunas líneas en el archivo XML
        ArchivoDATA.EscribirLineaXML("<tag>Primera línea</tag>");
        ArchivoDATA.EscribirLineaXML("<tag>Segunda línea</tag>");
        ArchivoDATA.EscribirLineaXML("<tag>Tercera línea</tag>");

        // Leer y mostrar el contenido del archivo XML
        List<String> lines = ArchivoDATA.LeerArchivoXML();
        for (String line : lines) {
            System.out.println(line); // Imprimir cada línea leída del archivo
        }
    }
    */
}
