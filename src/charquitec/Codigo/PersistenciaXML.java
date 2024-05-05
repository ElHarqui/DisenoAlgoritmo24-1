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

    /**
     * Constructor de la clase XMLFileManager.
     * @param filename Nombre del archivo XML a manejar.
     */
    public XMLFileManager(String filename) {
        this.file = new File(filename); // Inicializar el archivo con el nombre proporcionado
    }

    /**
     * Lee el contenido del archivo XML y lo devuelve como una lista de cadenas de texto.
     * @return Lista de cadenas de texto representando las líneas del archivo XML.
     */
    public List<String> readXMLFile() {
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

    /**
     * Escribe una línea de texto en el archivo XML.
     * @param line Línea de texto a escribir en el archivo.
     */
    public void writeLineToXML(String line) {
        try (FileWriter writer = new FileWriter(file, true)) { // Abrir el archivo para escritura (modo de anexión)
            writer.write(line + "\n"); // Escribir la línea de texto seguida de un salto de línea
        } catch (IOException e) { // Manejar excepciones de E/S
            e.printStackTrace(); // Imprimir la traza de la excepción
        }
    }

    /**
     * Método principal para probar la funcionalidad de la clase.
     * @param args Argumentos de línea de comandos (no utilizados en este ejemplo).
     */
    public static void main(String[] args) {
        XMLFileManager manager = new XMLFileManager("example.xml"); // Crear un objeto XMLFileManager

        // Escribir algunas líneas en el archivo XML
        manager.writeLineToXML("<tag>Primera línea</tag>");
        manager.writeLineToXML("<tag>Segunda línea</tag>");
        manager.writeLineToXML("<tag>Tercera línea</tag>");

        // Leer y mostrar el contenido del archivo XML
        List<String> lines = manager.readXMLFile();
        for (String line : lines) {
            System.out.println(line); // Imprimir cada línea leída del archivo
        }
    }
}
