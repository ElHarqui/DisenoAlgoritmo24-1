
package charquitec.Codigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.CardLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Grafo {
    private Map<Nodo, List<Nodo>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarNodo(String nombre, boolean esRol) {
        adyacencias.putIfAbsent(new Nodo(nombre, esRol), new ArrayList<>());
    }

    public void agregarArista(String desde, String hasta) {
        Nodo nodoDesde = new Nodo(desde, true); // Asumiendo que 'desde' es siempre un rol
        Nodo nodoHasta = new Nodo(hasta, false); // Asumiendo que 'hasta' es siempre un recurso
        adyacencias.putIfAbsent(nodoDesde, new ArrayList<>());
        adyacencias.putIfAbsent(nodoHasta, new ArrayList<>());
        adyacencias.get(nodoDesde).add(nodoHasta);
    }

    public boolean tieneArista(String desde, String hasta) {
        Nodo nodoDesde = new Nodo(desde, true);
        Nodo nodoHasta = new Nodo(hasta, false);
        return adyacencias.containsKey(nodoDesde) && adyacencias.get(nodoDesde).contains(nodoHasta);
    }

    public Map<Nodo, List<Nodo>> getAdyacencias() {
        return adyacencias;
    }

    public List<Nodo> obtenerRecursosParaRol(String rol) {
        Nodo nodoRol = new Nodo(rol, true);
        return adyacencias.getOrDefault(nodoRol, new ArrayList<>());
    }

   public void crearYMostrarVentana() {
        JFrame frame = new JFrame("Gestión Vendedor- Clientes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);

        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel buttonPanel = new JPanel();
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        // Añadir opción para mostrar todos
        GrafoPanel allNodesPanel = new GrafoPanel(this, null); // null para indicar mostrar todos
        cardPanel.add(allNodesPanel, "Todos");
        JButton allButton = new JButton("Todos");
        allButton.addActionListener(e -> cardLayout.show(cardPanel, "Todos"));
        buttonPanel.add(allButton);

        // Añadir un panel para cada rol
        for (Nodo nodo : adyacencias.keySet()) {
            if (nodo.esRol) {
                // Crear un nuevo Grafo que solo contenga este rol y sus recursos
                Grafo grafoRol = new Grafo();
                grafoRol.agregarNodo(nodo.nombre, true);
                for (Nodo recurso : adyacencias.get(nodo)) {
                    grafoRol.agregarNodo(recurso.nombre, false);
                    grafoRol.agregarArista(nodo.nombre, recurso.nombre);
                }

                GrafoPanel panel = new GrafoPanel(grafoRol, nodo.nombre);
                cardPanel.add(panel, nodo.nombre);
                JButton button = new JButton(nodo.nombre);
                button.addActionListener(e -> cardLayout.show(cardPanel, nodo.nombre));
                buttonPanel.add(button);
            }
     }

    frame.add(buttonPanel, BorderLayout.NORTH);
    frame.add(cardPanel, BorderLayout.CENTER);
    frame.setVisible(true);
}

    public void imprimirGrafo() {
        for (Map.Entry<Nodo, List<Nodo>> entrada : adyacencias.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}

class Arista {
    Nodo desde;
    Nodo hasta;

    public Arista(Nodo desde, Nodo hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public String toString() {
        return desde + " -> " + hasta;
    }
}