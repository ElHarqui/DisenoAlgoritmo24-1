
package charquitec.Codigo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Esta clase maneja una tabla hash y proporciona métodos para guardarla en un archivo XML y cargarla desde un archivo XML.
 */
public class GestionadorTablaHash {
    private Map<String, String> hashTable;

    /**
     * Constructor que inicializa la tabla hash.
     */
    public GestionadorTablaHash() {
        this.hashTable = new HashMap<>();
    }

    /**
     * Añade una entrada a la tabla hash.
     *
     * @param key   La clave de la entrada.
     * @param value El valor de la entrada.
     */
    public void put(String key, String value) {
        hashTable.put(key, value);
    }

    /**
     * Obtiene el valor asociado a una clave en la tabla hash.
     *
     * @param key La clave de la entrada.
     * @return El valor asociado a la clave, o null si la clave no está en la tabla.
     */
    public String get(String key) {
        return hashTable.get(key);
    }

    /**
     * Guarda la tabla hash en un archivo XML.
     *
     * @param filename El nombre del archivo XML.
     */
    public void saveToXML(String filename) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Crear el elemento raíz
            Element rootElement = doc.createElement("HashTable");
            doc.appendChild(rootElement);

            // Añadir los elementos de la tabla hash
            for (Map.Entry<String, String> entry : hashTable.entrySet()) {
                Element entryElement = doc.createElement("Entry");

                Element keyElement = doc.createElement("Key");
                keyElement.appendChild(doc.createTextNode(entry.getKey()));
                entryElement.appendChild(keyElement);

                Element valueElement = doc.createElement("Value");
                valueElement.appendChild(doc.createTextNode(entry.getValue()));
                entryElement.appendChild(valueElement);

                rootElement.appendChild(entryElement);
            }

            // Escribir el contenido en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));

            transformer.transform(source, result);

            System.out.println("Archivo XML guardado exitosamente.");

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }

    /**
     * Carga la tabla hash desde un archivo XML.
     *
     * @param filename El nombre del archivo XML.
     */
    public void loadFromXML(String filename) {
        try {
            File xmlFile = new File(".\\src\\charquitec\\Data\\"+filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            hashTable.clear();

            NodeList nList = doc.getElementsByTagName("Entry");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String key = eElement.getElementsByTagName("Key").item(0).getTextContent();
                    String value = eElement.getElementsByTagName("Value").item(0).getTextContent();

                    hashTable.put(key, value);
                }
            }

            System.out.println("Archivo XML cargado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime la tabla hash.
     */
    public void printHashTable() {
        for (Map.Entry<String, String> entry : hashTable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        GestionadorTablaHash TablaHash = new GestionadorTablaHash();

        // Añadir elementos a la tabla hash
        TablaHash.put("clave1", "valor1");
        TablaHash.put("clave2", "valor2");
        TablaHash.put("clave3", "valor3");

        // Guardar la tabla hash en un archivo XML
        TablaHash.saveToXML("hashTable.xml");

        // Imprimir la tabla hash actual
        System.out.println("Tabla hash actual:");
        TablaHash.printHashTable();

        // Cargar la tabla hash desde el archivo XML
        TablaHash.loadFromXML("hashTable.xml");

        // Imprimir la tabla hash cargada
        System.out.println("Tabla hash cargada desde el archivo XML:");
        TablaHash.printHashTable();
    }
}
