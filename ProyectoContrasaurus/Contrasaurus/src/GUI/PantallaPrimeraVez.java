package GUI;

/**
 *
 * @author Lorenzo Buero
 */
import ManejadoresApp.ControladorApp;

public class PantallaPrimeraVez extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrimeraVez.class.getName());

    private ControladorApp controlador;
    
    
    public PantallaPrimeraVez() {
        initComponents();
        this.setVisible(true);
        this.controlador = new ControladorApp("00");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scrollpBienvenidaExplicacion = new javax.swing.JScrollPane();
        taBienvenidaExplicacion = new javax.swing.JTextArea();
        btnContinuar = new javax.swing.JPanel();
        lblContinuar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setText("Bienvenida/o");
        fondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, -1, 60));

        scrollpBienvenidaExplicacion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        taBienvenidaExplicacion.setColumns(20);
        taBienvenidaExplicacion.setRows(5);
        taBienvenidaExplicacion.setText("Bienvenida/o a Contrasaurus, el \nadministrador de contraseñas de \nLorenzo Buero.\nDesarrollado para un final de la facu");
        scrollpBienvenidaExplicacion.setViewportView(taBienvenidaExplicacion);

        fondo.add(scrollpBienvenidaExplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnContinuar.setBackground(new java.awt.Color(51, 102, 0));
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
            .addComponent(lblContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnContinuarLayout.setVerticalGroup(
            btnContinuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        fondo.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseClicked
        this.controlador.setEstado("01");
        
        PantallaCrearUsuario pantalla = new PantallaCrearUsuario(this.controlador, this.getLocation(), true);
        this.dispose();
    }//GEN-LAST:event_btnContinuarMouseClicked

    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnContinuar;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblContinuar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollpBienvenidaExplicacion;
    private javax.swing.JTextArea taBienvenidaExplicacion;
    // End of variables declaration//GEN-END:variables
}
