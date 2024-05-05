/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import charquitec.Codigo.GestionadorProducto;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Vista_Vendedor extends javax.swing.JPanel {


    JPanel contenedor;
    Principal Principal;
    Vista_Admi Vista_Admi=new Vista_Admi();
    DefaultTableModel modeloReplica = new DefaultTableModel();
    DefaultTableModel modeloCarritoProductos = new DefaultTableModel();
    public Vista_Vendedor() {
        initComponents();      
        //TblListaProductos=new JTable(Vista_Admi.getModelo());
        //jScrollPane2= new JScrollPane(TablaLista);
        agregarModeloTablaProducto();
        llenarDatosEjemplo();
        agregarModeloCarritoProducto();
        
        VistaVendedor.setVisible(true);
        Vista_RegistroCliente.setVisible(false);
    }
    private void agregarModeloTablaProducto(){
        modeloReplica.addColumn("ID");
        modeloReplica.addColumn("Nombre");
        modeloReplica.addColumn("Precio");
        modeloReplica.addColumn("Cantidad"); 
        
     }
    private void agregarModeloCarritoProducto(){
        modeloCarritoProductos.addColumn("ID");
        modeloCarritoProductos.addColumn("Nombre");
        modeloCarritoProductos.addColumn("Precio");
        modeloCarritoProductos.addColumn("Cantidad"); 
        
     }
    private void llenarDatosEjemplo(){
        String[] fila1 = {"001", "Producto 1", "10.0", "10.0"};
        String[] fila2 = {"002", "Producto 2", "10.0", "10.0"};
        String[] fila3 = {"003", "Producto 3", "10.0", "10.0"};
        String[] fila4 = {"004", "Producto 4", "10.0", "10.0"};
        modeloReplica.addRow(fila1);
        modeloReplica.addRow(fila2);
        modeloReplica.addRow(fila3);
        modeloReplica.addRow(fila4);
    }
     public void llenarTablaProducto(GestionadorProducto unProducto){   
        int cantidadDatos = unProducto.cantidadProductos();       
        for( int i=0; i<cantidadDatos; i++){
            if (unProducto.unProducto[i] != null) {
            String nombre = unProducto.unProducto[i].getNombre();
            String ID = unProducto.unProducto[i].getID();
            
            String precio = String.valueOf(unProducto.unProducto[i].getPrecio());
            String cantidad = String.valueOf(unProducto.unProducto[i].getCantidad());
            String [] listaProductos = {ID,nombre,precio,cantidad};
            modeloCarritoProductos.addRow(listaProductos);
        }        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Vista_RegistroCliente = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        VistaVendedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblListaProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblProductosCarrito = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.CardLayout());

        Vista_RegistroCliente.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setText("Datos del cliente");

        jLabel5.setText("Nombre");

        jLabel6.setText("Apellido");

        jLabel7.setText("DNI");

        jButton4.setText("Registrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Vista_RegistroClienteLayout = new javax.swing.GroupLayout(Vista_RegistroCliente);
        Vista_RegistroCliente.setLayout(Vista_RegistroClienteLayout);
        Vista_RegistroClienteLayout.setHorizontalGroup(
            Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vista_RegistroClienteLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(Vista_RegistroClienteLayout.createSequentialGroup()
                        .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(53, 53, 53)
                        .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Vista_RegistroClienteLayout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(136, 136, 136))
        );
        Vista_RegistroClienteLayout.setVerticalGroup(
            Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vista_RegistroClienteLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addGap(39, 39, 39)
                .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        add(Vista_RegistroCliente, "card3");

        VistaVendedor.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("ID Cliente");

        jLabel2.setText("Reporte de Ventas");

        jButton1.setText("Registrar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista de Productos");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TblListaProductos.setModel(modeloReplica);
        jScrollPane1.setViewportView(TblListaProductos);

        TblProductosCarrito.setModel(modeloCarritoProductos);
        jScrollPane2.setViewportView(TblProductosCarrito);

        javax.swing.GroupLayout VistaVendedorLayout = new javax.swing.GroupLayout(VistaVendedor);
        VistaVendedor.setLayout(VistaVendedorLayout);
        VistaVendedorLayout.setHorizontalGroup(
            VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVendedorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jButton3)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2))
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(VistaVendedorLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(144, 144, 144)
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel3))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        VistaVendedorLayout.setVerticalGroup(
            VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVendedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaVendedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        add(VistaVendedor, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // finaliza registrar cliente
        VistaVendedor.setVisible(true);
        Vista_RegistroCliente.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Agregar al carrito
        try{
            //TblListaProductos.setRowSelectionAllowed(true);
            int fila = TblListaProductos.getSelectedRow();
            System.out.println(TblListaProductos.getSelectedRow());
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }else if(fila>=0){
                
            }
            else{
                String codigo = TblListaProductos.getValueAt(fila, 0).toString();
                String nombre = TblListaProductos.getValueAt(fila, 1).toString();
                String Precio = TblListaProductos.getValueAt(fila, 2).toString();
                String Cantidad = TblListaProductos.getValueAt(fila, 3).toString();
                float precio = Float.parseFloat(Precio);
                int cantidad = Integer.parseInt(Cantidad);
                Object[] datosFilaSeleccionada = new Object[4];
                for (int i = 0; i < 4; i++) {
                    datosFilaSeleccionada[i] = modeloReplica.getValueAt(fila, i);
                    modeloCarritoProductos.addRow(datosFilaSeleccionada);
                }
                GestionadorProducto ges = new GestionadorProducto();
                ges.registroProductoCarrito(codigo, nombre, precio, cantidad);
                Vista_Vendedor Vista_Vendedor=new Vista_Vendedor();
                Vista_Vendedor.llenarTablaProducto(ges);
                JOptionPane.showMessageDialog(null,"producto agregado con exito");
            }
        }catch(Exception e){
            System.out.println("errores");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // registrar cliente
        Vista_RegistroCliente.setVisible(true);
        VistaVendedor.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Eliminar del carrito
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblListaProductos;
    private javax.swing.JTable TblProductosCarrito;
    private javax.swing.JPanel VistaVendedor;
    private javax.swing.JPanel Vista_RegistroCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
