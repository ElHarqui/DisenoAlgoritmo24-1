
package charquitec.Codigo;

import javax.swing.*;
import java.awt.*;
import java.util.*;

class GrafoPanel extends JPanel {
    
    private Grafo grafo;
    private String rol;
    private Map<String, Point> posiciones;
    private Color defaultRoleColor = Color.YELLOW; // Color para los nodos de roles
    private Color recursoColor = Color.BLUE;  
    private Set<String> roles;
    
    public GrafoPanel(Grafo grafo, String rol) {
        this.grafo = grafo;
        this.rol = rol;
        this.posiciones = new HashMap<>();
        this.roles = new HashSet<>();
        this.roles.add("Vendedor"); // Añadimos el rol inicial
        establecerPosiciones();
        this.setBackground(Color.CYAN);
    }
    
    private void establecerPosiciones() {
        Random rand = new Random();
        int width = 900;
        int height = 600;

        for (Nodo nodo : grafo.getAdyacencias().keySet()) {
            int x = rand.nextInt(width - 100) + 50;
            int y = rand.nextInt(height - 100) + 50;
            posiciones.put(nodo.nombre, new Point(x, y));
            if (nodo.esRol) {
                roles.add(nodo.nombre);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Dibujar aristas
        for (Nodo nodo : grafo.getAdyacencias().keySet()) {
            Point p1 = posiciones.get(nodo.nombre);
            for (Nodo adyacente : grafo.getAdyacencias().get(nodo)) {
                Point p2 = posiciones.get(adyacente.nombre);
                g.setColor(Color.BLACK);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
      
        // Dibujar nodos
        for (Nodo nodo : grafo.getAdyacencias().keySet()) {
            Point posicion = posiciones.get(nodo.nombre);
            Color nodeColor = nodo.esRol ? defaultRoleColor : recursoColor;

            g.setColor(nodeColor);
            g.fillOval(posicion.x - 15, posicion.y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(posicion.x - 15, posicion.y - 15, 30, 30);
            g.drawString(nodo.nombre, posicion.x - 15, posicion.y - 20);
        }
    }
    
    public void agregarRol(String nuevoRol) {
        roles.add(nuevoRol);
        establecerPosiciones(); // Actualizar posiciones para incluir el nuevo nodo
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }
}