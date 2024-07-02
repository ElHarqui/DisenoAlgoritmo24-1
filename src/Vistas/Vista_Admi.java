/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import charquitec.Codigo.GestionadorAdministrador;
import charquitec.Codigo.GestionadorProducto;
import charquitec.Codigo.GestionadorVendedor;
import charquitec.Codigo.PersistenciaXML;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import charquitec.Codigo.GestionadorGrafo;
import charquitec.Codigo.Grafo;
import charquitec.Codigo.ListaEnlazada;
import charquitec.Codigo.Nodo;
/**
 *
 * @author csosa
 */
public class Vista_Admi extends javax.swing.JPanel {
    DefaultTableModel modeloEmpleado = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas de la tabla serán de solo lectura
        }
    };  
    DefaultTableModel modeloReporte = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas de la tabla serán de solo lectura
        }
    };   
    DefaultTableModel modeloProducto= new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas de la tabla serán de solo lectura
        }
    };
    GestionadorAdministrador GestionadorAdministrador = new GestionadorAdministrador();
    GestionadorProducto GesProduct = new GestionadorProducto();
    GestionadorVendedor GesVendedor = new GestionadorVendedor();  
    private Vista_Vendedor vistaVendedor;
    private Vista_Admi vistaAdmi;
    ListaEnlazada lista=new ListaEnlazada();
    PersistenciaXML data=new PersistenciaXML("DataProductos.xml");
    private Grafo grafo;
    private GestionadorGrafo gestionadorGrafo;
    public Vista_Admi() {
        initComponents();
        Login.setVisible(true);
        VistaAdmin.setVisible(false);
        agregarModeloTablaProducto();
        agregarModeloTablaEmpleado();
        agregarModeloTablaReporte();
        GesProduct.LeerDatosXML();
        GesVendedor.LeerDatosXML();
        lista.LeerDatosXML();
        
        llenarDatosProducto(GesProduct);   
        llenarDatosEmpleado(GesVendedor);
        llenarDatosReporte(lista);
        this.grafo = new Grafo();
    }
    public void setVistaVendedor(Vista_Vendedor vistaVendedor) {
        this.vistaVendedor = vistaVendedor;
    }
    private void agregarModeloTablaProducto(){
        modeloProducto.addColumn("ID");
        modeloProducto.addColumn("Nombre");
        modeloProducto.addColumn("Precio");
        modeloProducto.addColumn("Cantidad");          
     }
    private void agregarModeloTablaEmpleado(){
        modeloEmpleado.addColumn("Codigo"); 
        modeloEmpleado.addColumn("Nombre");
        modeloEmpleado.addColumn("Apellido");         
     }
    private void agregarModeloTablaReporte(){
        modeloReporte.addColumn("Empleado"); 
        modeloReporte.addColumn("Cliente");
        modeloReporte.addColumn("Monto");         
     }
    public void actualizarTablaProductos(GestionadorProducto GesProduct) {
        modeloProducto.setRowCount(0); // Limpiar la tabla
        llenarDatosProducto(GesProduct); // Llenar la tabla con los datos actualizados
    }
    
    public void actualizarTablaVendedor(GestionadorVendedor GesVendedor) {
        modeloEmpleado.setRowCount(0); // Limpiar la tabla
        llenarDatosEmpleado(GesVendedor); // Llenar la tabla con los datos actualizados
    }
    public void actualizarTablaReporte(ListaEnlazada listaReportes) {
        modeloReporte.setRowCount(0); // Limpiar la tabla
        llenarDatosReporte(listaReportes); // Llenar la tabla con los datos actualizados
    }
    
    private void llenarDatosProducto(GestionadorProducto GesProduct){
        //DATOS
        
        int tope = GesProduct.getnumDato();
        for(int i = 0 ; i< tope; i++){
            Object[] fila = {GesProduct.getProducto(i).getID(), GesProduct.getProducto(i).getNombre(), GesProduct.getProducto(i).getPrecio(),GesProduct.getProducto(i).getCantidad()};
            modeloProducto.addRow(fila);
        }
    }
    private void llenarDatosEmpleado(GestionadorVendedor GesVendedor){
        //DATOS
        
        int tope = GesVendedor.getnumDato();
        for(int i = 0 ; i< tope; i++){
            Object[] fila = {GesVendedor.getPersona(i).getCodigo(), GesVendedor.getPersona(i).getNombre(),GesVendedor.getPersona(i).getApellido()};
            modeloEmpleado.addRow(fila);
        }
    }
    private void llenarDatosReporte(ListaEnlazada listaReportes) {
        Nodo actual = listaReportes.cabeza;
        while (actual != null) {
            Object[] fila = {actual.getVendedor(), actual.getCliente(), actual.getMonto()};
            modeloReporte.addRow(fila);
            actual = actual.getSiguiente();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VistaAdmin = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        Tablas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendedor = new javax.swing.JTable();
        Registrar_Vende = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TNombreVendedor = new javax.swing.JTextField();
        TApellidoVendedor = new javax.swing.JTextField();
        TCodigoVendedor = new javax.swing.JTextField();
        btn_RegistrarVendedor = new javax.swing.JButton();
        Registrar_Prod = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nomProducto = new javax.swing.JTextField();
        precioProducto = new javax.swing.JTextField();
        btn_RegistrarProducto = new javax.swing.JButton();
        codProducto = new javax.swing.JTextField();
        cantProducto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Reporte = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        BarraNavegacion = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Login = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelRound1 = new Vistas.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        T1 = new javax.swing.JTextField();
        T2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        VistaAdmin.setLayout(new java.awt.BorderLayout());

        contenedor.setLayout(new java.awt.CardLayout());

        Tablas.setBackground(new java.awt.Color(0, 204, 255));

        tblProductos.setModel(modeloProducto
        );
        jScrollPane3.setViewportView(tblProductos);

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Eliminar producto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tabla productos");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tabla empleados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addGap(216, 216, 216)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jButton6.setText("Eliminar Vendedor");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tblVendedor.setModel(modeloEmpleado);
        jScrollPane2.setViewportView(tblVendedor);

        javax.swing.GroupLayout TablasLayout = new javax.swing.GroupLayout(Tablas);
        Tablas.setLayout(TablasLayout);
        TablasLayout.setHorizontalGroup(
            TablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablasLayout.createSequentialGroup()
                .addGroup(TablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TablasLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 324, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablasLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(139, 139, 139))
        );
        TablasLayout.setVerticalGroup(
            TablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(TablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addGroup(TablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablasLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablasLayout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(70, 70, 70))))
        );

        contenedor.add(Tablas, "card2");

        Registrar_Vende.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setText("Datos del vendedor");

        jLabel9.setText("Nombre");

        jLabel10.setText("Apellido");

        jLabel11.setText("Codigo");

        TNombreVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreVendedorActionPerformed(evt);
            }
        });

        btn_RegistrarVendedor.setText("Registrar Vendedor");
        btn_RegistrarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Registrar_VendeLayout = new javax.swing.GroupLayout(Registrar_Vende);
        Registrar_Vende.setLayout(Registrar_VendeLayout);
        Registrar_VendeLayout.setHorizontalGroup(
            Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrar_VendeLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(Registrar_VendeLayout.createSequentialGroup()
                        .addGroup(Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(53, 53, 53)
                        .addGroup(Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TNombreVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(TApellidoVendedor)
                            .addComponent(TCodigoVendedor))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Registrar_VendeLayout.createSequentialGroup()
                .addContainerGap(799, Short.MAX_VALUE)
                .addComponent(btn_RegistrarVendedor)
                .addGap(96, 96, 96))
        );
        Registrar_VendeLayout.setVerticalGroup(
            Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrar_VendeLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addGroup(Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TApellidoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(Registrar_VendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(TCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btn_RegistrarVendedor)
                .addContainerGap(377, Short.MAX_VALUE))
        );

        contenedor.add(Registrar_Vende, "card3");

        Registrar_Prod.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setText("Datos del producto");

        jLabel12.setText("Nombre");

        jLabel13.setText("Codigo");

        nomProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomProductoActionPerformed(evt);
            }
        });

        btn_RegistrarProducto.setText("Registrar Producto");
        btn_RegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarProductoActionPerformed(evt);
            }
        });

        jLabel14.setText("Precio");

        jLabel15.setText("Cantidad");

        javax.swing.GroupLayout Registrar_ProdLayout = new javax.swing.GroupLayout(Registrar_Prod);
        Registrar_Prod.setLayout(Registrar_ProdLayout);
        Registrar_ProdLayout.setHorizontalGroup(
            Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrar_ProdLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Registrar_ProdLayout.createSequentialGroup()
                        .addGap(0, 577, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(278, 278, 278))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Registrar_ProdLayout.createSequentialGroup()
                        .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addGroup(Registrar_ProdLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))))
                        .addGap(43, 43, 43)
                        .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cantProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(nomProducto)
                            .addComponent(codProducto)
                            .addComponent(precioProducto))
                        .addContainerGap(685, Short.MAX_VALUE))))
            .addGroup(Registrar_ProdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_RegistrarProducto)
                .addGap(116, 116, 116))
        );
        Registrar_ProdLayout.setVerticalGroup(
            Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrar_ProdLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Registrar_ProdLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btn_RegistrarProducto))
                    .addGroup(Registrar_ProdLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(Registrar_ProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addContainerGap(426, Short.MAX_VALUE))
        );

        contenedor.add(Registrar_Prod, "card4");

        Reporte.setBackground(new java.awt.Color(204, 255, 204));

        jTable1.setModel(modeloReporte);
        jScrollPane1.setViewportView(jTable1);

        jButton9.setText("Regresar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReporteLayout = new javax.swing.GroupLayout(Reporte);
        Reporte.setLayout(ReporteLayout);
        ReporteLayout.setHorizontalGroup(
            ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReporteLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jButton9)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        ReporteLayout.setVerticalGroup(
            ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReporteLayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReporteLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReporteLayout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(86, 86, 86))))
        );

        contenedor.add(Reporte, "card5");

        VistaAdmin.add(contenedor, java.awt.BorderLayout.CENTER);

        BarraNavegacion.setBackground(new java.awt.Color(255, 204, 204));

        jButton1.setText("Tablas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        BarraNavegacion.add(jButton1);

        jButton2.setText("Registrar Vendedor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        BarraNavegacion.add(jButton2);

        jButton3.setText("Registrar Producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        BarraNavegacion.add(jButton3);

        jButton7.setText("Cliente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        BarraNavegacion.add(jButton7);

        jButton8.setText("Reporte de ventas");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        BarraNavegacion.add(jButton8);

        VistaAdmin.add(BarraNavegacion, java.awt.BorderLayout.PAGE_START);

        add(VistaAdmin, "card3");

        Login.setBackground(new java.awt.Color(153, 204, 255));

        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel1.setText("Iniciar sesion");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 2, 14)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 2, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        jButton4.setText("Iniciar Sesion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        T1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T1ActionPerformed(evt);
            }
        });

        T2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton4)
                            .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton4)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/charquitec/Imagenes/admin.png"))); // NOI18N

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                        .addGap(0, 107, Short.MAX_VALUE)
                        .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))))))
        );

        add(Login, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Registrar Vendedor
        Registrar_Vende.setVisible(true);
        Tablas.setVisible(false);
        Registrar_Prod.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Iniciar sesion

        String usuario = T1.getText();
        String contra = T2.getText();

        if (GestionadorAdministrador.VerificarUsuario(usuario, contra)) {
            Login.setVisible(false);
            VistaAdmin.setVisible(true);
        } else {
            jLabel6.setText("Usuario o contrasena incorrectos");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Mostrar tablas
        Tablas.setVisible(true);
        Registrar_Prod.setVisible(false);
        Registrar_Vende.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Registrar_Prod.setVisible(true);
        Tablas.setVisible(false);
        Registrar_Vende.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nomProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProductoActionPerformed

    private void btn_RegistrarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarVendedorActionPerformed
        //registrar vendedor
        String nombre = TNombreVendedor.getText();
        String apellido = TApellidoVendedor.getText();
        String codigo = TCodigoVendedor.getText();

        if (GesVendedor.existeVendedor(codigo)) {
            JOptionPane.showMessageDialog(null, "Ya existe un vendedor registrado con ese código", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            boolean registroExitoso = GesVendedor.Registrar(nombre, apellido, codigo);

            if (registroExitoso) {
                JOptionPane.showMessageDialog(null, "Vendedor registrado con éxito");
                GesVendedor.LeerDatosXML();
                actualizarTablaVendedor(GesVendedor);
                vistaAdmi.actualizarTablaVendedor(GesVendedor);

                TNombreVendedor.setText("");
                TApellidoVendedor.setText("");
                TCodigoVendedor.setText("");
                
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el vendedor. Se ha alcanzado el límite de vendedores.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos para nombre y apellido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_RegistrarVendedorActionPerformed

    private void TNombreVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombreVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNombreVendedorActionPerformed

    private void btn_RegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarProductoActionPerformed
        //registrar producto
        String nombre = nomProducto.getText();
        String ID = codProducto.getText();

        if (GesProduct.existeProducto(ID)) {
            JOptionPane.showMessageDialog(null, "Ya existe un producto registrado con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            float precio = Float.parseFloat(precioProducto.getText());
            int cantidad = Integer.parseInt(cantProducto.getText());

            boolean registroExitoso = GesProduct.registroProducto(ID,nombre, precio, cantidad);

            if (registroExitoso) {
                JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
                GesProduct.LeerDatosXML();
                actualizarTablaProductos(GesProduct);
                vistaVendedor.actualizarTablaProductos(GesProduct);
                
                nomProducto.setText("");
                codProducto.setText("");
                precioProducto.setText("");
                cantProducto.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el producto. Se ha alcanzado el límite de productos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para precio y cantidad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_RegistrarProductoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //eliminar producto
        try{
            
            int fila = tblProductos.getSelectedRow();
            System.out.println(tblProductos.getSelectedRow());
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }else{
            String codigo = tblProductos.getValueAt(fila, 0).toString();
                modeloProducto.removeRow(tblProductos.getSelectedRow());
                GesProduct.eliminarProducto(codigo);
                data.EliminarPorID(codigo);
                GesProduct.LeerDatosXML();
                vistaVendedor.actualizarTablaProductos(GesProduct);
                
                JOptionPane.showMessageDialog(null,"producto eliminado con exito");
            }
        }catch(Exception e){
            System.out.println("errores");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //eliminar Vendedor
        try{
            int fila = tblVendedor.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "seleecione una fila ");
                
            }else{
                String codigo = tblVendedor.getValueAt(fila, 0).toString();                
                modeloEmpleado.removeRow(tblVendedor.getSelectedRow());
                GestionadorVendedor ges = new GestionadorVendedor();
                ges.Eliminar(codigo);
                JOptionPane.showMessageDialog(null,"Vendedor eliminado con exito");
            }
        }catch(Exception e){
            System.out.println("errores");
        }   
    }//GEN-LAST:event_jButton6ActionPerformed

    private void T1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T1ActionPerformed

    private void T2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    this.gestionadorGrafo = new GestionadorGrafo(this.grafo);
            this.gestionadorGrafo.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Reporte.setVisible(true);
        Tablas.setVisible(false);
        Registrar_Vende.setVisible(false);
        Registrar_Prod.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Reporte.setVisible(false);
        Tablas.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraNavegacion;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Registrar_Prod;
    private javax.swing.JPanel Registrar_Vende;
    private javax.swing.JPanel Reporte;
    private javax.swing.JTextField T1;
    private javax.swing.JTextField T2;
    private javax.swing.JTextField TApellidoVendedor;
    private javax.swing.JTextField TCodigoVendedor;
    private javax.swing.JTextField TNombreVendedor;
    private javax.swing.JPanel Tablas;
    private javax.swing.JPanel VistaAdmin;
    private javax.swing.JButton btn_RegistrarProducto;
    private javax.swing.JButton btn_RegistrarVendedor;
    private javax.swing.JTextField cantProducto;
    private javax.swing.JTextField codProducto;
    private javax.swing.JPanel contenedor;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nomProducto;
    private Vistas.PanelRound panelRound1;
    private javax.swing.JTextField precioProducto;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblVendedor;
    // End of variables declaration//GEN-END:variables

}
