package GUI;

import ManejadoresApp.ControladorApp;
import java.awt.Point;
/**
 *
 * @author Lorenzo Buero
 */
public class PantallaIngresarContrasenia extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaIngresarContrasenia.class.getName());
    
    private String nombreUsuario;
    private ControladorApp controlador;
    
    public PantallaIngresarContrasenia(){
        initComponents();
    }
    public PantallaIngresarContrasenia(ControladorApp control, Point posicion){
        this();
        this.controlador = control;
        this.getLocation(posicion);
    }
    public PantallaIngresarContrasenia(ControladorApp control, Point posicion, String nombreUsuario){
        this(control, posicion);
        this.nombreUsuario = nombreUsuario;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pfContrasenia = new javax.swing.JPasswordField();
        btnVerificar = new javax.swing.JPanel();
        lblVerificar = new javax.swing.JLabel();
        btnVolver = new javax.swing.JPanel();
        lblVolver = new javax.swing.JLabel();
        lblDebugEstado = new javax.swing.JLabel();
        lblMalaContrasenia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 150));
        setResizable(false);

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblTitulo.setText("Ingrese su contrasenia");
        fondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 6, -1, -1));

        pfContrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondo.add(pfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 308, -1));

        btnVerificar.setBackground(new java.awt.Color(0, 102, 0));
        btnVerificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerificarMouseClicked(evt);
            }
        });

        lblVerificar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblVerificar.setForeground(new java.awt.Color(204, 204, 204));
        lblVerificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerificar.setText("Verificar");

        javax.swing.GroupLayout btnVerificarLayout = new javax.swing.GroupLayout(btnVerificar);
        btnVerificar.setLayout(btnVerificarLayout);
        btnVerificarLayout.setHorizontalGroup(
            btnVerificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        btnVerificarLayout.setVerticalGroup(
            btnVerificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        fondo.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        btnVolver.setBackground(new java.awt.Color(153, 0, 0));
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        lblVolver.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblVolver.setForeground(new java.awt.Color(204, 204, 204));
        lblVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVolver.setText("Volver");

        javax.swing.GroupLayout btnVolverLayout = new javax.swing.GroupLayout(btnVolver);
        btnVolver.setLayout(btnVolverLayout);
        btnVolverLayout.setHorizontalGroup(
            btnVolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        btnVolverLayout.setVerticalGroup(
            btnVolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        fondo.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 10, 10));

        lblMalaContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        fondo.add(lblMalaContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        if(this.controlador.getEstado().equals("11")){
            this.controlador.setEstado("10");
            PantallaSeleccionarUsuario pantalla = new PantallaSeleccionarUsuario(this.controlador, this.getLocation());
            
            this.dispose();
        }else if(this.controlador.getEstado().equals("50") || this.controlador.getEstado().equals("60") || this.controlador.getEstado().equals("70")){
            this.controlador.setEstado("20");
            PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());
            
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnVerificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerificarMouseClicked
        String Contrasenia = String.valueOf(pfContrasenia.getPassword());
        
        if(this.controlador.verificarContrasenia(this.controlador.getUsuarioActivo().getNombreUsuario(), Contrasenia)){
            if(this.controlador.getEstado().equals("11")){
                this.controlador.setEstado("20");
                PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());

                this.dispose();
            }else if(this.controlador.getEstado().equals("50")){//Ocultos
                this.controlador.setEstado("51");
                PantallaBuscarContrasenia pantalla = new PantallaBuscarContrasenia(this.controlador, this.getLocation(), true);

                this.dispose();
            }else if(this.controlador.getEstado().equals("60")){//Eliminar
                this.controlador.setEstado("61");
                PantallaBuscarContrasenia pantalla = new PantallaBuscarContrasenia(this.controlador, this.getLocation(), true);

                this.dispose();
            }else if(this.controlador.getEstado().equals("70")){//Editar
                this.controlador.setEstado("71");
                PantallaBuscarContrasenia pantalla = new PantallaBuscarContrasenia(this.controlador, this.getLocation(), true);

                this.dispose();
            }
        }else{
            lblMalaContrasenia.setText("Contrasenia incorrecta");
        
        }
    }//GEN-LAST:event_btnVerificarMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnVerificar;
    private javax.swing.JPanel btnVolver;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JLabel lblMalaContrasenia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVerificar;
    private javax.swing.JLabel lblVolver;
    private javax.swing.JPasswordField pfContrasenia;
    // End of variables declaration//GEN-END:variables
}
