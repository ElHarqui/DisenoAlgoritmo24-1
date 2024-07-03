
package Vistas;


import charquitec.Codigo.GestionadorCliente;
import charquitec.Codigo.GestionadorProducto;
import charquitec.Codigo.GestionadorProductoCarrito;
import charquitec.Codigo.GestionadorVendedor;
import charquitec.Codigo.GestionadorVenta;
import charquitec.Codigo.PersistenciaXML;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import charquitec.Codigo.GestionadorInventario;
import charquitec.Codigo.ListaEnlazada;
import charquitec.Codigo.Vendedor;
/**
 *
 * @author Usuario
 */
public class Vista_Vendedor extends javax.swing.JPanel {
DefaultTableModel modeloCliente = new DefaultTableModel();
    DefaultTableModel modeloProducto = new DefaultTableModel(){
            

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas de la tabla serán de solo lectura
        }
    };
    
    DefaultTableModel modeloCarritoProductos = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas de la tabla serán de solo lectura
        }
    };
    GestionadorProducto GesProduct = new GestionadorProducto();
    GestionadorVendedor GesVendedor=new GestionadorVendedor();
    GestionadorInventario Gestor = new GestionadorInventario("DataProductos.xml");
    GestionadorProductoCarrito GesProductCarrito = new GestionadorProductoCarrito();
    PersistenciaXML dataProducto=new PersistenciaXML("DataProductos.xml");
         GestionadorCliente GesCliente =new GestionadorCliente();

    GestionadorVenta GesVenta = new GestionadorVenta();
        DefaultTableModel modeloVentas = new DefaultTableModel();
    ListaEnlazada lista=new ListaEnlazada();
    Vista_Admi vistaAdmin=new Vista_Admi();
    public Vista_Vendedor() {
        initComponents();      
        GesProduct.LeerDatosXML();
        GesVendedor.LeerDatosXML();
        GesCliente.LeerDatosXML();
        agregarModeloTablaProducto();
        agregarModeloCarritoProducto();
        agregarModeloTablaVentas();
        agregarModeloTablaCliente();
        llenarTablaProductos(GesProduct);
        
        llenarTablaCliente(GesCliente);

        llenarTablaVentas(GesVenta);
        agregarClienteComboBox();
        LoginVendedor.setVisible(true);
        Vista_RegistroCliente1.setVisible(false);
        VistaVentas.setVisible(false);
        VistaVendedor.setVisible(false);
    }
    

    private void agregarModeloTablaProducto(){
        modeloProducto.addColumn("ID");
        modeloProducto.addColumn("Nombre");
        modeloProducto.addColumn("Precio");
        modeloProducto.addColumn("Cantidad"); 
        
     }
    private void agregarModeloCarritoProducto(){
        modeloCarritoProductos.addColumn("ID");
        modeloCarritoProductos.addColumn("Nombre");
        modeloCarritoProductos.addColumn("Precio");
        modeloCarritoProductos.addColumn("Cantidad"); 
        
     }
    private void agregarModeloTablaVentas(){
        modeloVentas.addColumn("Cliente");
        modeloVentas.addColumn("IDProd");
        modeloVentas.addColumn("Nombre");
        modeloVentas.addColumn("Precio");
        modeloVentas.addColumn("Cantidad");
        modeloVentas.addColumn("Total");


                
        
        
        
    }
    private void agregarModeloTablaCliente(){
        modeloCliente.addColumn("Codigo");
        modeloCliente.addColumn("Nombre");
        modeloCliente.addColumn("Apellido");
        
        
        
    }
    public void setVistaAdmin(Vista_Admi vistaAdmin) {
        this.vistaAdmin = vistaAdmin;
    }
    public void llenarTablaVentas(GestionadorVenta GesVenta){
            
            int tope = GesVenta.cantidadVentas();
        for(int i = 0 ; i< tope; i++){
            Object[] fila = {GesVenta.unVenta[i].getNomCliente(), GesVenta.unVenta[i].getIDproducto(),GesVenta.unVenta[i].getNombreProducto(),GesVenta.unVenta[i].getPrecioProducto(),GesVenta.unVenta[i].getCantidadProducto(),GesVenta.unVenta[i].getPrecioTotal()};
            modeloVentas.addRow(fila);
        }
            
        }
        
        public void agregarClienteComboBox(){
            
        
        int cantidad = GesCliente.cantidadClientes();
        
        String cliente[] = new String  [cantidad];
        
        for ( int i=0; i<cantidad; i++){
            
            
            comboClienteBox.addItem(GesCliente.unPersona[i].getNombre());
        }
        
        
    }
    public void actualizarTablaProductos(GestionadorProducto GesProduct) {
        modeloProducto.setRowCount(0); // Limpiar la tabla
        llenarTablaProductos(GesProduct); // Llenar la tabla con los datos actualizados
    }

    public void llenarTablaProductos(GestionadorProducto GesProduct){

        int tope = GesProduct.getnumDato();
        for(int i = 0 ; i< tope; i++){
            Object[] fila = {GesProduct.getProducto(i).getID(), GesProduct.getProducto(i).getNombre(), GesProduct.getProducto(i).getPrecio(),GesProduct.getProducto(i).getCantidad()};
            modeloProducto.addRow(fila);
        }
    }
    public void llenarTablaCliente(GestionadorCliente GesCliente){
            
        int tope = GesCliente.cantidadPersona();
        for(int i = 0 ; i< tope; i++){
            Object[] fila = {GesCliente.getPersona(i).getCodigo(), GesCliente.getPersona(i).getNombre(),GesCliente.getPersona(i).getApellido()};
            modeloCliente.addRow(fila);
        }
            
        }

    public void AgregarProductoCarrito(GestionadorProductoCarrito GesProduct){

        int i = GesProduct.getnumDatoCarrito()-1;
        System.out.println("el valor de i es " +i);
        Object[] fila = {GesProduct.getProducto(i).getID(), GesProduct.getProducto(i).getNombre(), GesProduct.getProducto(i).getPrecio(),GesProduct.getProducto(i).getCantidad()};
        modeloCarritoProductos.addRow(fila);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Vista_RegistroCliente1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TNombreCliente = new javax.swing.JTextField();
        TApellidoCliente = new javax.swing.JTextField();
        TDNICliente = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboClienteBox = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        A1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        product_code = new javax.swing.JTextField();
        VistaVentas = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        LoginVendedor = new javax.swing.JPanel();
        panelRound1 = new Vistas.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        T_usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        T_contra = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.CardLayout());

        Vista_RegistroCliente1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Codigo");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre");

        TNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreClienteActionPerformed(evt);
            }
        });

        jButton6.setText("Registrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Apellido");

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Complete la informacion de sus clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cliente");

        jButton8.setText("Volver");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tblClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblClientes.setForeground(new java.awt.Color(0, 153, 255));
        tblClientes.setModel(modeloCliente);
        jScrollPane6.setViewportView(tblClientes);

        javax.swing.GroupLayout Vista_RegistroCliente1Layout = new javax.swing.GroupLayout(Vista_RegistroCliente1);
        Vista_RegistroCliente1.setLayout(Vista_RegistroCliente1Layout);
        Vista_RegistroCliente1Layout.setHorizontalGroup(
            Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(39, 39, 39)
                        .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TApellidoCliente)
                            .addComponent(TNombreCliente)
                            .addComponent(TDNICliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButton8))
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Vista_RegistroCliente1Layout.setVerticalGroup(
            Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(32, 32, 32)
                        .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(23, 23, 23)
                        .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Vista_RegistroCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton3)
                            .addComponent(jButton7)))
                    .addGroup(Vista_RegistroCliente1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        add(Vista_RegistroCliente1, "card3");

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

        TblListaProductos.setModel(modeloProducto);
        jScrollPane1.setViewportView(TblListaProductos);

        TblProductosCarrito.setModel(modeloCarritoProductos);
        jScrollPane2.setViewportView(TblProductosCarrito);

        LabelIDCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Monto");

        LabelMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Digite la cantidad del producto");

        btn_Finalizar.setText("Finalizar");
        btn_Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FinalizarActionPerformed(evt);
            }
        });

        jButton1.setText("Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Realizar Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboClienteBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClienteBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClienteBoxActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        A1.setColumns(20);
        A1.setRows(5);

        jScrollPane4.setViewportView(product_code);

        javax.swing.GroupLayout VistaVendedorLayout = new javax.swing.GroupLayout(VistaVendedor);
        VistaVendedor.setLayout(VistaVendedorLayout);
        VistaVendedorLayout.setHorizontalGroup(
            VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaVendedorLayout.createSequentialGroup()
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboClienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(LabelIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(VistaVendedorLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)
                                .addGap(47, 47, 47)
                                .addComponent(LabelMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(122, 122, 122)
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VistaVendedorLayout.createSequentialGroup()
                                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_AgregarAlCarrito)
                                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                                        .addComponent(btn_RegistrarCliente)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btn_buscar)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(VistaVendedorLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(VistaVendedorLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(VistaVendedorLayout.createSequentialGroup()
                                    .addGap(128, 128, 128)
                                    .addComponent(btn_EliminarDelCarrito))
                                .addGroup(VistaVendedorLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(VistaVendedorLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(138, 138, 138))))
                                .addGroup(VistaVendedorLayout.createSequentialGroup()
                                    .addGap(121, 121, 121)
                                    .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaVendedorLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(VistaVendedorLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Finalizar))))
                .addGap(305, 305, 305))
        );
        VistaVendedorLayout.setVerticalGroup(
            VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVendedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelIDCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btn_RegistrarCliente)
                        .addComponent(jButton1)))
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboClienteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_buscar))
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(LabelMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaVendedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVendedorLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VistaVendedorLayout.createSequentialGroup()
                        .addGroup(VistaVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Finalizar)
                            .addComponent(btn_AgregarAlCarrito)
                            .addComponent(btn_EliminarDelCarrito))
                        .addGap(164, 164, 164))))
        );

        add(VistaVendedor, "card2");

        VistaVentas.setBackground(new java.awt.Color(0, 153, 255));

        jTable1.setModel(modeloVentas
        );
        jScrollPane7.setViewportView(jTable1);

        jButton5.setText("Generar Reporte");

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VistaVentasLayout = new javax.swing.GroupLayout(VistaVentas);
        VistaVentas.setLayout(VistaVentasLayout);
        VistaVentasLayout.setHorizontalGroup(
            VistaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVentasLayout.createSequentialGroup()
                .addGroup(VistaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VistaVentasLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VistaVentasLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton5)
                        .addGap(128, 128, 128)
                        .addComponent(jButton4)))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        VistaVentasLayout.setVerticalGroup(
            VistaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaVentasLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(VistaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addContainerGap(251, Short.MAX_VALUE))
        );

        add(VistaVentas, "card5");

        LoginVendedor.setBackground(new java.awt.Color(102, 153, 255));

        jLabel4.setText("Iniciar Sesion");

        jLabel5.setText("Usuario");

        T_usuario.setText(" ");
        T_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_usuarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Contraseña");

        jButton9.setText("Iniciar Sesion");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(T_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(T_contra)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButton9)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(T_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(T_contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton9)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoginVendedorLayout = new javax.swing.GroupLayout(LoginVendedor);
        LoginVendedor.setLayout(LoginVendedorLayout);
        LoginVendedorLayout.setHorizontalGroup(
            LoginVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginVendedorLayout.createSequentialGroup()
                .addContainerGap(454, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        LoginVendedorLayout.setVerticalGroup(
            LoginVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginVendedorLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        add(LoginVendedor, "card5");
    }// </editor-fold>//GEN-END:initComponents

    
    private void btn_AgregarAlCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarAlCarritoActionPerformed
        //Agregar al carrito
    try {
        // Verificar si se ha seleccionado una fila
        int fila = TblListaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            System.out.println("Número de fila: " + fila);
            // Obtener los valores de la fila seleccionada
            String codigo = TblListaProductos.getValueAt(fila, 0).toString();
            String nombre = TblListaProductos.getValueAt(fila, 1).toString();
            String Precio = TblListaProductos.getValueAt(fila, 2).toString();
            String CantidadProducto = TCantidadProducto.getText();
            float precio = Float.parseFloat(Precio);
            if (CantidadProducto.equals("") || CantidadProducto.equals("0")) {
                JOptionPane.showMessageDialog(null, "Digite una cantidad");
            } 

            else {
                int cantidadProducto = Integer.parseInt(CantidadProducto);
                int cantidadDisponible = GesProduct.ObtenerCantidad(codigo);
                // Verificar si la cantidad solicitada está disponible
                if (cantidadDisponible >= cantidadProducto) {
                    int cantidadResultante = cantidadDisponible - cantidadProducto;
                    String cantidad = String.valueOf(cantidadResultante);
                    dataProducto.ActualizarPorID(codigo, nombre, Precio, cantidad);
                    GesProduct.LeerDatosXML();
                    // Actualizando tabla de productos almacen
                    actualizarTablaProductos(GesProduct);

                    // Agregando el producto al carrito
                    GesProductCarrito.AgregarAlCarrito(codigo, nombre, precio, cantidadProducto);

                    // Llenando la tabla con el carrito
                    AgregarProductoCarrito(GesProductCarrito);
                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Producto añadido al carrito");

                    // Calcular y mostrar el monto total
                    float monto = CalcularMonto();
                    String montoStr = Float.toString(monto);
                    LabelMonto.setText(montoStr);
                } else {
                    JOptionPane.showMessageDialog(null, "Cantidad no disponible");
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }

    }//GEN-LAST:event_btn_AgregarAlCarritoActionPerformed
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
        
        Vista_RegistroCliente1.setVisible(true);
        VistaVendedor.setVisible(false);
    }//GEN-LAST:event_btn_RegistrarClienteActionPerformed

    private void btn_EliminarDelCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarDelCarritoActionPerformed
        // Eliminar del carrito
        try{
            
            int fila = TblProductosCarrito.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }else{
                String codigo = TblProductosCarrito.getValueAt(fila, 0).toString();
                modeloCarritoProductos.removeRow(TblProductosCarrito.getSelectedRow());
                JOptionPane.showMessageDialog(null,"Producto eliminado con exito");
                float Monto=CalcularMonto();
                String monto=Float.toString(Monto);
                LabelMonto.setText(monto);
            }
        }catch(Exception e){
            System.out.println("errores");
        }
    }//GEN-LAST:event_btn_EliminarDelCarritoActionPerformed

    private void btn_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FinalizarActionPerformed
        //finaliza compra
    }//GEN-LAST:event_btn_FinalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
VistaVentas.setVisible(true); 
VistaVendedor.setVisible(false);
       // VistaInventario.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try{
            int fila = TblProductosCarrito.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }else{
            String cliente = comboClienteBox.getSelectedItem().toString();
            String ID = TblProductosCarrito.getValueAt(fila, 0).toString();
            String Nombre = TblProductosCarrito.getValueAt(fila, 1).toString();
            String Precio = TblProductosCarrito.getValueAt(fila, 2).toString();
            
             String Cantidad = TblProductosCarrito.getValueAt(fila, 3).toString();
             String Total = LabelMonto.getText();
            
            GesVenta.registroVenta(cliente, ID, Nombre, Precio, Cantidad,Total);
                    JOptionPane.showMessageDialog(null, "venta realizada ");
          llenarTablaVentas(GesVenta);
                String vendedor=T_contra.getText();
                String monto=LabelMonto.getText();
                lista.insertarFinal(vendedor, cliente, monto);
                
                vistaAdmin.actualizarTablaReporte(lista);
        
            }
        }catch(Exception e){
            System.out.println("errores");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Vista_RegistroCliente1.setVisible(false);
        VistaVendedor.setVisible(true);
        VistaVentas.setVisible(false);
        //VistaInventario.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try{
            int fila = tblClientes.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");

            }else{
                String codigo = tblClientes.getValueAt(fila, 0).toString();

                modeloCliente.removeRow(tblClientes.getSelectedRow());
                GesCliente.Eliminar(codigo);

                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
            }
        }catch(Exception e){
            System.out.println("errores");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // finaliza registrar cliente
        GestionadorCliente ges=new GestionadorCliente();
        //ges.LeerDatosXML();
        String nombre=TNombreCliente.getText();
        String apellido=TApellidoCliente.getText();
        String codigo=TDNICliente.getText();
        ges.Registrar(nombre, apellido, codigo);
        JOptionPane.showMessageDialog(null, "Cliente registrado");

        llenarTablaCliente(ges);

        LabelIDCliente.setText(codigo);
        
        
        //VistaVendedor.setVisible(true);
        // Vista_RegistroCliente.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNombreClienteActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
// Buscar con divide y venceras
      String code = product_code.getText();
      
      List<String> productosEncontrados = Gestor.buscarProductosPorID(code);
      A1.setText(Gestor.mostrarProductosEncontrados(productosEncontrados));
      
      product_code.setText("");
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void comboClienteBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClienteBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClienteBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        VistaVentas.setVisible(false);
        VistaVendedor.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void T_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_usuarioActionPerformed
        
    }//GEN-LAST:event_T_usuarioActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String usuario=T_usuario.getText();
        String contra=T_contra.getText();
        if(GesVendedor.existeVendedor(contra)){
            LoginVendedor.setVisible(false);
            VistaVendedor.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Contraseña no valida");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea A1;
    private javax.swing.JLabel LabelIDCliente;
    private javax.swing.JLabel LabelMonto;
    private javax.swing.JPanel LoginVendedor;
    private javax.swing.JTextField TApellidoCliente;
    private javax.swing.JTextField TCantidadProducto;
    private javax.swing.JTextField TDNICliente;
    private javax.swing.JTextField TNombreCliente;
    private javax.swing.JTextField T_contra;
    private javax.swing.JTextField T_usuario;
    private javax.swing.JTable TblListaProductos;
    private javax.swing.JTable TblProductosCarrito;
    private javax.swing.JPanel VistaVendedor;
    private javax.swing.JPanel VistaVentas;
    private javax.swing.JPanel Vista_RegistroCliente1;
    private javax.swing.JButton btn_AgregarAlCarrito;
    private javax.swing.JButton btn_EliminarDelCarrito;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JButton btn_RegistrarCliente;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox<String> comboClienteBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private Vistas.PanelRound panelRound1;
    private javax.swing.JTextField product_code;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
    }
                  
