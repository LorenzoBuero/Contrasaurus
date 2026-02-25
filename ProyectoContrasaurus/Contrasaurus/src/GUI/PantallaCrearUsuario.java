package GUI;


import ManejadoresApp.ControladorApp;
import java.awt.Point;
/**
 *
 * @author pirulo
 */
public class PantallaCrearUsuario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaCrearUsuario.class.getName());

    private ControladorApp controlador;
    boolean primeraVez;
    
    public PantallaCrearUsuario() {
        initComponents();
        this.setVisible(true);
    }
    
    public PantallaCrearUsuario(ControladorApp control, Point lugar, boolean primeraVez){
        this();
        this.controlador = control;
        this.setLocation(lugar);
        this.primeraVez = primeraVez;
    }


    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        lblSubtituloUsuario = new javax.swing.JLabel();
        lblSubtituloContrasenia = new javax.swing.JLabel();
        pfContrasenia = new javax.swing.JPasswordField();
        lblTitulo = new javax.swing.JLabel();
        lblErrorUsuario = new javax.swing.JLabel();
        lblErrorContrasenia = new javax.swing.JLabel();
        btnListo = new javax.swing.JPanel();
        lblListo = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        lblDebugEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(400, 400));

        fondo.setPreferredSize(new java.awt.Dimension(400, 400));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubtituloUsuario.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblSubtituloUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtituloUsuario.setText("Ingrese el nombre para su Usuario");
        fondo.add(lblSubtituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 401, -1));

        lblSubtituloContrasenia.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblSubtituloContrasenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtituloContrasenia.setText("Ingrese su Contraseña");
        fondo.add(lblSubtituloContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 395, -1));
        fondo.add(pfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 229, -1));

        lblTitulo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Crear usuario");
        fondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 401, -1));

        lblErrorUsuario.setForeground(new java.awt.Color(204, 0, 0));
        fondo.add(lblErrorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 20, 10));

        lblErrorContrasenia.setForeground(new java.awt.Color(204, 0, 0));
        fondo.add(lblErrorContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 30, 10));

        btnListo.setBackground(new java.awt.Color(0, 102, 0));
        btnListo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListoMouseClicked(evt);
            }
        });

        lblListo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblListo.setForeground(new java.awt.Color(204, 204, 204));
        lblListo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListo.setText("Listo");
        lblListo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnListoLayout = new javax.swing.GroupLayout(btnListo);
        btnListo.setLayout(btnListoLayout);
        btnListoLayout.setHorizontalGroup(
            btnListoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblListo, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );
        btnListoLayout.setVerticalGroup(
            btnListoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblListo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        fondo.add(btnListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, 30));
        fondo.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 220, -1));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListoMouseClicked
        String usuario = tfUsuario.getText();
        String contrasenia = String.valueOf(pfContrasenia.getPassword());
        if(this.primeraVez){
            controlador.registrarPrimerUsuario(usuario, contrasenia);
        }else{
            controlador.registrarUsuario(usuario, contrasenia);
        }
        
        controlador.setEstado("20");
        controlador.login();
        PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());
        this.dispose();
        
    }//GEN-LAST:event_btnListoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnListo;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JLabel lblErrorContrasenia;
    private javax.swing.JLabel lblErrorUsuario;
    private javax.swing.JLabel lblListo;
    private javax.swing.JLabel lblSubtituloContrasenia;
    private javax.swing.JLabel lblSubtituloUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField pfContrasenia;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
