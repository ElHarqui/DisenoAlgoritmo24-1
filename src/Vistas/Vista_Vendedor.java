
package Vistas;

import charquitec.Codigo.Cliente;
import charquitec.Codigo.GestionadorCliente;
import charquitec.Codigo.GestionadorProducto;
import charquitec.Codigo.GestionadorProductoAlmacen;
import charquitec.Codigo.GestionadorProductoCarrito;
import charquitec.Codigo.GestionadorVendedor;
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
        GestionadorProducto GesProduct = new GestionadorProducto();
        GesProduct.LeerDatosXML();
        agregarModeloTablaProducto();
        llenarDatosEjemplo(GesProduct);
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
    private void llenarDatosEjemplo(GestionadorProducto GesProduct){
        //DATOS
        
        int tope = GesProduct.getnumDato();
        for(int i = 0 ; i< tope; i++){
            Object[] fila = {GesProduct.getProducto(i).getID(), GesProduct.getProducto(i).getNombre(), GesProduct.getProducto(i).getPrecio(),GesProduct.getProducto(i).getCantidad()};
            modeloReplica.addRow(fila);
        }
        /*
        Object[] fila1 = {"001", "Producto 1", 10, 10};
        Object[] fila2 = {"002", "Producto 2", 10, 10};
        Object[] fila3 = {"003", "Producto 3", 10, 10};
        Object[] fila4 = {"004", "Producto 4", 10, 10};
        modeloReplica.addRow(fila1);
        modeloReplica.addRow(fila2);
        modeloReplica.addRow(fila3);
        modeloReplica.addRow(fila4);
        */
    }
     public void llenarTablaProducto(GestionadorProductoCarrito unProducto){   
        int cantidadDatos = unProducto.cantidadProductos();       
        for( int i=0; i<cantidadDatos; i++){
            if (unProducto.unProductoCarrito[i] != null) {
            String nombre = unProducto.unProductoCarrito[i].getNombre();
            String ID = unProducto.unProductoCarrito[i].getID();
            
            String precio = String.valueOf(unProducto.unProductoCarrito[i].getPrecio());
            String cantidad = String.valueOf(unProducto.unProductoCarrito[i].getCantidad());
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
        TNombreCliente = new javax.swing.JTextField();
        TApellidoCliente = new javax.swing.JTextField();
        TDNICliente = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        VistaVendedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_RegistrarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_EliminarDelCarrito = new javax.swing.JButton();
        btn_AgregarAlCarrito = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblListaProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblProductosCarrito = new javax.swing.JTable();
        LabelIDCliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LabelMonto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TCantidadProducto = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.CardLayout());

        Vista_RegistroCliente.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setText("Datos del cliente");

        jLabel5.setText("Nombre");

        jLabel6.setText("Apellido");

        jLabel7.setText("DNI");

        TNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreClienteActionPerformed(evt);
            }
        });

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
                            .addComponent(TNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(TApellidoCliente)
                            .addComponent(TDNICliente))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Vista_RegistroClienteLayout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
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
                    .addComponent(TNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(Vista_RegistroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        add(Vista_RegistroCliente, "card3");

        VistaVendedor.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("ID Cliente");

        jLabel2.setText("Carrito del cliente");

        btn_RegistrarCliente.setText("Registrar Cliente");
        btn_RegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista de Productos");

        btn_EliminarDelCarrito.setText("Eliminar");
        btn_EliminarDelCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarDelCarritoActionPerformed(evt);
            }
        });

        btn_AgregarAlCarrito.setText("Agregar");
        btn_AgregarAlCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarAlCarritoActionPerformed(evt);
            }
        });

        TblListaProductos.setModel(modeloReplica);
        jScrollPane1.setViewportView(TblListaProductos);

        TblProductosCarrito.setModel(modeloCarritoProductos);
        jScrollPane2.setViewportView(TblProductosCarrito);

        LabelIDCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Monto");

        LabelMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Digite la cantidad del producto");

        btn_Finalizar.setText("Finalizar");

        javax.swing.GroupLayout VistaVendedorLayout = new javax.swing.GroupLayout(VistaVendedor);
        VistaVendedor.setLayout(VistaVendedorLayout);
        VistaVendedorLayout.setHorizontalGroup(
            VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVendedorLayout.createSequentialGroup()
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaVendedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VistaVendedorLayout.createSequentialGroup()
                                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(LabelIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(126, 126, 126)
                                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_RegistrarCliente)
                                    .addComponent(jLabel3)))
                            .addGroup(VistaVendedorLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(41, 41, 41)
                                .addComponent(LabelMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                                        .addComponent(btn_AgregarAlCarrito)
                                        .addGap(33, 33, 33)
                                        .addComponent(btn_EliminarDelCarrito)
                                        .addGap(49, 49, 49)
                                        .addComponent(btn_Finalizar))
                                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(23, 23, 23)
                                        .addComponent(TCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        VistaVendedorLayout.setVerticalGroup(
            VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVendedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelIDCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btn_RegistrarCliente)))
                .addGap(28, 28, 28)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(LabelMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(TCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_EliminarDelCarrito)
                        .addComponent(btn_Finalizar))
                    .addComponent(btn_AgregarAlCarrito))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        add(VistaVendedor, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // finaliza registrar cliente
        GestionadorCliente ges=new GestionadorCliente();
        //ges.LeerDatosXML();
        String nombre=TNombreCliente.getText();
        String apellido=TApellidoCliente.getText();
        String codigo=TDNICliente.getText();
        ges.Registrar(nombre, apellido, codigo);
        
        LabelIDCliente.setText(codigo);
        VistaVendedor.setVisible(true);
        Vista_RegistroCliente.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_AgregarAlCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarAlCarritoActionPerformed
        //Agregar al carrito 
        try{
            //TblListaProductos.setRowSelectionAllowed(true);
            int fila = TblListaProductos.getSelectedRow();
            System.out.println(TblListaProductos.getSelectedRow());
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }
            else{
                String codigo = TblListaProductos.getValueAt(fila, 0).toString();
                String nombre = TblListaProductos.getValueAt(fila, 1).toString();
                String Precio = TblListaProductos.getValueAt(fila, 2).toString();
                String CantidadProducto=TCantidadProducto.getText();
                
                //String Cantidad = TblListaProductos.getValueAt(fila, 3).toString();
                float precio = Float.parseFloat(Precio);
                int cantidadProducto = Integer.parseInt(CantidadProducto);   
                RestarCantidad(TblListaProductos.getSelectedRow(),3,codigo,cantidadProducto);    
                        
                GestionadorProductoCarrito ges = new GestionadorProductoCarrito();
                //ges.registroProductoCarrito(codigo, nombre, precio, cantidadProducto);
                JOptionPane.showMessageDialog(null, "Producto añadido al carrito");
                llenarTablaProducto(ges);
                
                float Monto=CalcularMonto();
                String monto=Float.toString(Monto);
                LabelMonto.setText(monto);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_AgregarAlCarritoActionPerformed
    public void RestarCantidad(int fila,int columna,String codigo,int cantidadCarrito){
        int CantidadRestanteStock=0;
        int CantidadActualStock=0;
        GestionadorProductoAlmacen stock=new GestionadorProductoAlmacen();
        CantidadActualStock =stock.ObtenerCantidad(codigo);
        System.out.println("catnidad:"+CantidadActualStock);
        CantidadRestanteStock=CantidadActualStock-cantidadCarrito;
        
        GestionadorProductoAlmacen prod=new GestionadorProductoAlmacen();
        prod.ActualizarCantidad(codigo, CantidadRestanteStock);
        
        TblListaProductos.setValueAt(CantidadRestanteStock, fila, columna);
        ((DefaultTableModel) TblListaProductos.getModel()).fireTableCellUpdated(fila, columna);
    }
    public float CalcularMonto(){
        float monto=0;
        int Cantidadfila = TblProductosCarrito.getRowCount();
        for (int i=0;i<Cantidadfila;i++){
            String Precio = TblProductosCarrito.getValueAt(i, 2).toString();
            String Cantidad = TblProductosCarrito.getValueAt(i, 3).toString();
            float precio = Float.parseFloat(Precio);
            float cantidad = Float.parseFloat(Cantidad);
            monto=monto+precio*cantidad;
        }
        return monto;
    }
    
    private void btn_RegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarClienteActionPerformed
        // registrar cliente
        
        Vista_RegistroCliente.setVisible(true);
        VistaVendedor.setVisible(false);
    }//GEN-LAST:event_btn_RegistrarClienteActionPerformed

    private void btn_EliminarDelCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarDelCarritoActionPerformed
        // Eliminar del carrito
        try{
            
            int fila = TblProductosCarrito.getSelectedRow();
            System.out.println(TblProductosCarrito.getSelectedRow());
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }else{
                String codigo = TblProductosCarrito.getValueAt(fila, 0).toString();
                modeloCarritoProductos.removeRow(TblProductosCarrito.getSelectedRow());
                GestionadorProductoCarrito ges = new GestionadorProductoCarrito();
                //ges.eliminarProductoCarrito(codigo);
                JOptionPane.showMessageDialog(null,"Producto eliminado con exito");
                float Monto=CalcularMonto();
                String monto=Float.toString(Monto);
                LabelMonto.setText(monto);
            }
        }catch(Exception e){
            System.out.println("errores");
        }
    }//GEN-LAST:event_btn_EliminarDelCarritoActionPerformed

    private void TNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNombreClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIDCliente;
    private javax.swing.JLabel LabelMonto;
    private javax.swing.JTextField TApellidoCliente;
    private javax.swing.JTextField TCantidadProducto;
    private javax.swing.JTextField TDNICliente;
    private javax.swing.JTextField TNombreCliente;
    private javax.swing.JTable TblListaProductos;
    private javax.swing.JTable TblProductosCarrito;
    private javax.swing.JPanel VistaVendedor;
    private javax.swing.JPanel Vista_RegistroCliente;
    private javax.swing.JButton btn_AgregarAlCarrito;
    private javax.swing.JButton btn_EliminarDelCarrito;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JButton btn_RegistrarCliente;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
