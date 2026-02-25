package GUI;

import ManejadoresApp.ControladorApp;
import java.awt.Point;
import app.CredencialAlmacenada;
import app.DatosCredencial;
import app.ConfigCredencial;
/**
 *
 * @author Lorenzo Buero
 */
public class PantallaAgregarEditarCuenta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaAgregarEditarCuenta.class.getName());

    private ControladorApp controlador;
    
    private CredencialAlmacenada credencialEditada;
    
    public PantallaAgregarEditarCuenta() {
        initComponents();
    }
    
    public PantallaAgregarEditarCuenta(ControladorApp control, Point posicion){
        this();
        this.controlador = control;
        this.getLocation(posicion);
    }
    
    public PantallaAgregarEditarCuenta(ControladorApp control, Point posicion, CredencialAlmacenada credEditada){
        this(control, posicion);
        this.credencialEditada = credEditada;
        this.llenarCampos();
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        btnVolverAtras = new javax.swing.JPanel();
        lblVolverAtras = new javax.swing.JLabel();
        tfSitio = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblSitioIngresado = new javax.swing.JLabel();
        cboxSitioOculto = new javax.swing.JCheckBox();
        lblErrorSitio = new javax.swing.JLabel();
        tfNombreCuenta = new javax.swing.JTextField();
        lblNombreCuentaIngresado = new javax.swing.JLabel();
        cboxNombreCuentaOculto = new javax.swing.JCheckBox();
        lblErrorNombreCuenta = new javax.swing.JLabel();
        tfContrasenia = new javax.swing.JTextField();
        lblContrasenia = new javax.swing.JLabel();
        cboxContraseniaOculto = new javax.swing.JCheckBox();
        lblErrorContrasenia = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JPanel();
        lblConfirmar = new javax.swing.JLabel();
        lblDebugEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolverAtras.setBackground(new java.awt.Color(102, 0, 0));
        btnVolverAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverAtrasMouseClicked(evt);
            }
        });

        lblVolverAtras.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblVolverAtras.setForeground(new java.awt.Color(204, 204, 204));
        lblVolverAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVolverAtras.setText("<== Volver Atras");

        javax.swing.GroupLayout btnVolverAtrasLayout = new javax.swing.GroupLayout(btnVolverAtras);
        btnVolverAtras.setLayout(btnVolverAtrasLayout);
        btnVolverAtrasLayout.setHorizontalGroup(
            btnVolverAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVolverAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        btnVolverAtrasLayout.setVerticalGroup(
            btnVolverAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVolverAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        fondo.add(btnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 70));
        fondo.add(tfSitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 290, 40));

        lblTitulo.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lblTitulo.setText("Agregar Contrasenia");
        fondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        lblSitioIngresado.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblSitioIngresado.setText("Sitio:");
        fondo.add(lblSitioIngresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        cboxSitioOculto.setText("Ocultar Sitio");
        fondo.add(cboxSitioOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        lblErrorSitio.setForeground(new java.awt.Color(255, 51, 51));
        fondo.add(lblErrorSitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        fondo.add(tfNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 290, 40));

        lblNombreCuentaIngresado.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblNombreCuentaIngresado.setText("Nombre de la Cuenta:");
        fondo.add(lblNombreCuentaIngresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        cboxNombreCuentaOculto.setText("Ocultar nombre de la cuenta");
        fondo.add(cboxNombreCuentaOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        lblErrorNombreCuenta.setForeground(new java.awt.Color(255, 51, 51));
        fondo.add(lblErrorNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));
        fondo.add(tfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 290, 40));

        lblContrasenia.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblContrasenia.setText("Contraseña:");
        fondo.add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        cboxContraseniaOculto.setText("Ocultar Sitio");
        fondo.add(cboxContraseniaOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        lblErrorContrasenia.setForeground(new java.awt.Color(255, 51, 51));
        fondo.add(lblErrorContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        btnConfirmar.setBackground(new java.awt.Color(0, 102, 0));
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        lblConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        lblConfirmar.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(204, 204, 204));
        lblConfirmar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmar.setText("Agregar nueva contraseña");
        lblConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnConfirmarLayout = new javax.swing.GroupLayout(btnConfirmar);
        btnConfirmar.setLayout(btnConfirmarLayout);
        btnConfirmarLayout.setHorizontalGroup(
            btnConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnConfirmarLayout.setVerticalGroup(
            btnConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        fondo.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 400, 60));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnVolverAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverAtrasMouseClicked
        if(this.controlador.getEstado().equals("30")){
            this.controlador.setEstado("20");
            PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());
        }else if(this.controlador.getEstado().equals("72")){
            this.controlador.setEstado("71");
            PantallaBuscarContrasenia pantalla = new PantallaBuscarContrasenia(this.controlador, this.getLocation(), true);
        }
        
        this.dispose();
        
    }//GEN-LAST:event_btnVolverAtrasMouseClicked

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        if(!this.camposLlenos()){
            if(this.controlador.getEstado().equals("30")){

                this.controlador.setEstado("20");
                PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());

                CredencialAlmacenada cred = generarCredencialConCampos();
                this.controlador.agregarCredencial(cred);


            }else if(this.controlador.getEstado().equals("72")){
                this.controlador.setEstado("73");
                CredencialAlmacenada cred = generarCredencialConCampos();
                PantallaConfirmarAlgo pantalla = new PantallaConfirmarAlgo(this.controlador, this.getLocation(), cred);

            }

            this.dispose();
        }
        
    }//GEN-LAST:event_btnConfirmarMouseClicked
    private void llenarCampos(){
        this.tfContrasenia.setText(this.credencialEditada.getDatosCredencial().getContra());
        this.tfSitio.setText(this.credencialEditada.getDatosCredencial().getSitio());
        this.tfNombreCuenta.setText(this.credencialEditada.getDatosCredencial().getNombreCuenta());
        
        this.cboxContraseniaOculto.setSelected(this.credencialEditada.getConfig().contraseniaOculta());
        this.cboxNombreCuentaOculto.setSelected(this.credencialEditada.getConfig().nombreCuentaOculto());
        this.cboxSitioOculto.setSelected(this.credencialEditada.getConfig().sitioOculto());
    
    }
    
    private CredencialAlmacenada generarCredencialConCampos(){
    
        String sitio = tfSitio.getText();        
        String nombreCuenta = tfNombreCuenta.getText();
        String contrasenia = tfContrasenia.getText();
    
        boolean cifSitio = cboxSitioOculto.isSelected();
        boolean cifNCuenta = cboxNombreCuentaOculto.isSelected();
        boolean cifContra = cboxContraseniaOculto.isSelected();
        
        DatosCredencial datos = new DatosCredencial(sitio, nombreCuenta, contrasenia);
        ConfigCredencial conf = new ConfigCredencial(cifSitio, cifNCuenta, cifContra);
        
        CredencialAlmacenada cred;
        if(this.controlador.getEstado().equals("72")){
            cred = new CredencialAlmacenada(this.credencialEditada.getId(), datos, conf, this.credencialEditada.getParametros());
        }else{
            cred = new CredencialAlmacenada(datos, conf);
        }
        return cred;
    }
    
    private boolean camposLlenos(){
        boolean sitioVacio = tfSitio.getText().isBlank();
        
        boolean nombreCuentaVacio = tfNombreCuenta.getText().isBlank();
        
        boolean contraseniaVacio = tfContrasenia.getText().isBlank();
        
        boolean retorno = true;
        if(sitioVacio){
            retorno = false;
            this.lblErrorSitio.setText("Ingrese un sitio");
        
        }if(nombreCuentaVacio){
            retorno = false;
            this.lblErrorNombreCuenta.setText("Ingrese un nombre para la cuenta");
            
        }if(contraseniaVacio){
            this.lblErrorContrasenia.setText("Ingrese una contrasenia");
            retorno = false;
            
        }
        
        return retorno;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnConfirmar;
    private javax.swing.JPanel btnVolverAtras;
    private javax.swing.JCheckBox cboxContraseniaOculto;
    private javax.swing.JCheckBox cboxNombreCuentaOculto;
    private javax.swing.JCheckBox cboxSitioOculto;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JLabel lblErrorContrasenia;
    private javax.swing.JLabel lblErrorNombreCuenta;
    private javax.swing.JLabel lblErrorSitio;
    private javax.swing.JLabel lblNombreCuentaIngresado;
    private javax.swing.JLabel lblSitioIngresado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVolverAtras;
    private javax.swing.JTextField tfContrasenia;
    private javax.swing.JTextField tfNombreCuenta;
    private javax.swing.JTextField tfSitio;
    // End of variables declaration//GEN-END:variables
}
