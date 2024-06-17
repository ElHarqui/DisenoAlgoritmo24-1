/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;



public class Principal extends javax.swing.JFrame {

    Vista_Inicial Vista_Inicial = new Vista_Inicial();
    Vista_Vendedor VistaVendedor = new Vista_Vendedor();
    Vista_Admi VistaAdmi= new Vista_Admi();   
    public Principal() {
        initComponents();
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        contenedor.add(VistaVendedor);
        contenedor.add(VistaAdmi);
        contenedor.add(Vista_Inicial);
        VistaAdmi.setVistaVendedor(VistaVendedor);
        VistaVendedor.setVisible(false);
        VistaAdmi.setVisible(false);
        Vista_Inicial.setVisible(true);
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        Panel_inferior = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setMinimumSize(new java.awt.Dimension(1280, 720));
        contenedor.setPreferredSize(new java.awt.Dimension(1280, 720));
        contenedor.setLayout(new java.awt.BorderLayout());

        Panel_inferior.setBackground(new java.awt.Color(204, 204, 255));

        B1.setText("Administrador");
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        Panel_inferior.add(B1);

        B2.setText("Vendedor");
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        Panel_inferior.add(B2);

        contenedor.add(Panel_inferior, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        //admin
        VistaAdmi.setVisible(true);
        VistaVendedor.setVisible(false);
        Vista_Inicial.setVisible(false);
        contenedor.add(VistaAdmi);
        contenedor.validate();
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        //vendedor
        VistaVendedor.setVisible(true);
        Vista_Inicial.setVisible(false);
        VistaAdmi.setVisible(false);
        contenedor.add(VistaVendedor);
        contenedor.validate();
    }//GEN-LAST:event_B2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }
//Sadasd
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JPanel Panel_inferior;
    private javax.swing.JPanel contenedor;
    // End of variables declaration//GEN-END:variables

}
