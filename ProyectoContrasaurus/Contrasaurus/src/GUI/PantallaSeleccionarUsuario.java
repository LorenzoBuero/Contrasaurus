package GUI;

import app.Usuario;
import ManejadoresApp.ControladorApp;


import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Lorenzo Buero
 */
public class PantallaSeleccionarUsuario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaSeleccionarUsuario.class.getName());

    private ControladorApp controlador;

    public PantallaSeleccionarUsuario() {
        initComponents();
        this.setVisible(true);
        this.controlador = new ControladorApp("10");
        
        ArrayList<Usuario> usuarios = controlador.obtenerTodosLosUsuarios();
        ArrayList<String> nombresUsuarios;
        for(Usuario usuario : usuarios){
            cboxUsuario.addItem(usuario.getNombreUsuario()); 
        }
        
        
    }
    PantallaSeleccionarUsuario(ControladorApp control, Point posicion){
        this();
        this.controlador = control;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        cboxUsuario = new javax.swing.JComboBox<>();
        btnContinuar = new javax.swing.JPanel();
        lblContinuar = new javax.swing.JLabel();
        lblDebugEstado = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnNuevaCuenta = new javax.swing.JPanel();
        lblNuevaCuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblTitulo.setText("Bienvenido/a");
        fondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        cboxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fondo.add(cboxUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 120, 30));

        btnContinuar.setBackground(new java.awt.Color(0, 102, 0));
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContinuarMouseClicked(evt);
            }
        });

        lblContinuar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblContinuar.setForeground(new java.awt.Color(204, 204, 204));
        lblContinuar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContinuar.setText("Continuar");

        javax.swing.GroupLayout btnContinuarLayout = new javax.swing.GroupLayout(btnContinuar);
        btnContinuar.setLayout(btnContinuarLayout);
        btnContinuarLayout.setHorizontalGroup(
            btnContinuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnContinuarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnContinuarLayout.setVerticalGroup(
            btnContinuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        fondo.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 140, 40));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 20, 20));

        lblError.setForeground(new java.awt.Color(204, 0, 0));
        fondo.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        btnNuevaCuenta.setBackground(new java.awt.Color(0, 0, 204));
        btnNuevaCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaCuentaMouseClicked(evt);
            }
        });

        lblNuevaCuenta.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblNuevaCuenta.setForeground(new java.awt.Color(204, 204, 204));
        lblNuevaCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevaCuenta.setText("Nueva cuenta");

        javax.swing.GroupLayout btnNuevaCuentaLayout = new javax.swing.GroupLayout(btnNuevaCuenta);
        btnNuevaCuenta.setLayout(btnNuevaCuentaLayout);
        btnNuevaCuentaLayout.setHorizontalGroup(
            btnNuevaCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevaCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnNuevaCuentaLayout.setVerticalGroup(
            btnNuevaCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevaCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        fondo.add(btnNuevaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 210, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseClicked
        this.controlador.setEstado("11");
        if(cboxUsuario.getSelectedIndex()!=0){
            String estaCuenta = cboxUsuario.getSelectedItem().toString();
            PantallaIngresarContrasenia pantalla = new PantallaIngresarContrasenia(this.controlador, this.getLocation(), estaCuenta);
        }else{
            lblError.setText("ERROR, seleccione un usuario");
        }
        
        
        this.dispose();
    }//GEN-LAST:event_btnContinuarMouseClicked

    private void btnNuevaCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaCuentaMouseClicked
        this.controlador.setEstado("02");
        
        PantallaCrearUsuario pantalla = new PantallaCrearUsuario(this.controlador, this.getLocation(), false);
        this.dispose();
    }//GEN-LAST:event_btnNuevaCuentaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnContinuar;
    private javax.swing.JPanel btnNuevaCuenta;
    private javax.swing.JComboBox<String> cboxUsuario;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblContinuar;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNuevaCuenta;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
