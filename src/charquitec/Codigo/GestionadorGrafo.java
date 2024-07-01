
package charquitec.Codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionadorGrafo extends JFrame {
    private Grafo grafo;
    private JTextField nodoField;
    private JComboBox<String> rolComboBox;
    private JTextArea outputArea;
    private GrafoPanel grafoPanel;

    public GestionadorGrafo(Grafo grafo) {
        this.grafo = grafo;
        this.grafoPanel = new GrafoPanel(grafo, null);
        setTitle("Configurar roles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.CYAN);
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        // Nodo input
        inputPanel.add(new JLabel("Nombre del Nodo:"));
        nodoField = new JTextField();
        inputPanel.add(nodoField);

        // Rol input
        inputPanel.add(new JLabel("Es Rol:"));
        rolComboBox = new JComboBox<>(new String[] { "Sí", "No" });
        inputPanel.add(rolComboBox);

        // Add node button
        JButton addButton = new JButton("Agregar Nodo");
        inputPanel.add(addButton);
        addButton.addActionListener(new AddNodeActionListener());

        // Add input panel to the frame
        add(inputPanel, BorderLayout.NORTH);

        // Output area to display graph elements
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Buttons panel for adding edges and refreshing view
        JPanel buttonsPanel = new JPanel();

        // Add edge button
        JButton addEdgeButton = new JButton("Agregar Arista");
        addEdgeButton.addActionListener(new AddEdgeActionListener());
        buttonsPanel.add(addEdgeButton);

        // Refresh button
        JButton refreshButton = new JButton("Actualizar Vista");
        refreshButton.addActionListener(new RefreshActionListener());
        buttonsPanel.add(refreshButton);

        // Refresh button
        JButton displayButton = new JButton("Graficar");
        displayButton.addActionListener(new displayActionListener());
        buttonsPanel.add(displayButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        updateOutput();
        setVisible(true);
    }

    private class AddNodeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        String nombre = nodoField.getText();
        boolean esRol = rolComboBox.getSelectedItem().equals("Sí");
        grafo.agregarNodo(nombre, esRol);
        if (esRol) {
            grafoPanel.agregarRol(nombre);
        }
        grafoPanel.repaint();
        nodoField.setText("");
        updateOutput();
        
        }
    }

    private class AddEdgeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String desde = JOptionPane.showInputDialog("Ingrese el nodo origen (Vendedor):");
            String hasta = JOptionPane.showInputDialog("Ingrese el nodo destino (cliente):");
            if (desde != null && hasta != null) {
                grafo.agregarArista(desde, hasta);
                updateOutput();
            }
        }
    }

    private class RefreshActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateOutput();
        }
    }
    
    private class displayActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            grafo.crearYMostrarVentana();
        }
    }

    private void updateOutput() {
        StringBuilder sb = new StringBuilder();
        for (Nodo nodo : grafo.getAdyacencias().keySet()) {
            if (nodo.esRol) {
                sb.append(nodo.nombre).append(" -> ");
                List<Nodo> adyacentes = grafo.getAdyacencias().get(nodo);
                for (Nodo adyacente : adyacentes) {
                    sb.append(adyacente.nombre).append(", ");
                }
                if (!adyacentes.isEmpty()) {
                    sb.setLength(sb.length() - 2); // Remove trailing comma and space
                }
                sb.append("\n");
            }
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        GestionadorGrafo gestG = new GestionadorGrafo(grafo);
        gestG.setVisible(true);
    }
}
