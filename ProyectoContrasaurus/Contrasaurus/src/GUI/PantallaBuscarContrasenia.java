package GUI;

import ManejadoresApp.ControladorApp;
import java.awt.Point;
import java.util.ArrayList;
import app.CredencialAlmacenada;
import javax.swing.DefaultListModel;
/**
 *
 * @author Lorenzo Buero
 */
public class PantallaBuscarContrasenia extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaBuscarContrasenia.class.getName());

    private ControladorApp controlador;
    private boolean modoOculto;
    private DefaultListModel modelo;
    private ArrayList<CredencialAlmacenada> getTodos(){
        return this.controlador.obtenerCredenciales(modoOculto);
    }
    //private ArrayList<CredencialAlmacenada> credencialesMostradas;
    private ArrayList<String> mostrados;
    
    public PantallaBuscarContrasenia() {
        initComponents();
    }
    public PantallaBuscarContrasenia(ControladorApp control, Point posicion, boolean modoOculto){
        this();
        this.controlador = control;
        this.setLocation(posicion);
        this.modoOculto = modoOculto;
        this.actualizarMostrados();
        for(String credencial : mostrados){
            modelo.addElement(credencial);
        }
        this.modelo = new DefaultListModel();
        this.listaContrasenias.setModel(modelo);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        scrollerListaContrasenias = new javax.swing.JScrollPane();
        listaContrasenias = new javax.swing.JList<>();
        btnVolverAtras = new javax.swing.JPanel();
        lblVolverAtras = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblIndicaciones = new javax.swing.JLabel();
        lblAclaraciones = new javax.swing.JLabel();
        tfBuscador = new javax.swing.JTextField();
        lblDebugEstado = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JPanel();
        lblConfirmar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollerListaContrasenias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 8));
        scrollerListaContrasenias.setAutoscrolls(true);

        listaContrasenias.setBackground(new java.awt.Color(255, 255, 204));
        listaContrasenias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseñas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14))); // NOI18N
        listaContrasenias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Sitio                            ||                           Nombre de la Cuenta                          ||                   Contraseña", "Item 2", "Item 3", "Item 4s", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4s", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4s", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4s", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4s", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4s", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4s", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaContrasenias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaContrasenias.setToolTipText("buen día");
        listaContrasenias.setAutoscrolls(false);
        listaContrasenias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scrollerListaContrasenias.setViewportView(listaContrasenias);

        fondo.add(scrollerListaContrasenias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 755, 280));

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
        lblVolverAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        lblTitulo.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        lblTitulo.setText("Buscar Contraseñas");
        fondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        lblIndicaciones.setText("Utilize la barra de búsqueda para buscar contraseñas por su sitio. ");
        fondo.add(lblIndicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        lblAclaraciones.setText("Los datos ocultos se van a ver como x-x-x-x-x, para verlos entre en el modo de contraseñas ocultas");
        fondo.add(lblAclaraciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        tfBuscador.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tfBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscadorKeyTyped(evt);
            }
        });
        fondo.add(tfBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 40));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 10, 10));

        btnConfirmar.setBackground(new java.awt.Color(51, 102, 0));
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        lblConfirmar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(204, 204, 204));
        lblConfirmar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmar.setText("Confirmar");

        javax.swing.GroupLayout btnConfirmarLayout = new javax.swing.GroupLayout(btnConfirmar);
        btnConfirmar.setLayout(btnConfirmarLayout);
        btnConfirmarLayout.setHorizontalGroup(
            btnConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        btnConfirmarLayout.setVerticalGroup(
            btnConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        fondo.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscadorKeyTyped
        //this.actualizarMostrados();
        
    }//GEN-LAST:event_tfBuscadorKeyTyped

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        if(this.listaContrasenias.getSelectedIndex() != -1){
            CredencialAlmacenada credSeleccionada = this.getTodos().get(this.listaContrasenias.getSelectedIndex());
            if(this.controlador.getEstado().equals("61")){

                this.controlador.setEstado("62");
                PantallaConfirmarAlgo pantalla = new PantallaConfirmarAlgo(this.controlador, this.getLocation(), credSeleccionada);
                this.dispose();
            }else if(this.controlador.getEstado().equals("72")){
                this.controlador.setEstado("62");
                PantallaAgregarEditarCuenta pantalla = new PantallaAgregarEditarCuenta(this.controlador, this.getLocation(), credSeleccionada);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnVolverAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverAtrasMouseClicked
        this.controlador.setEstado("20");
        PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());
        
        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasMouseClicked
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void actualizarMostrados(){
        for(CredencialAlmacenada cred : this.getTodos()){
            this.mostrados.add(cred.getDatosCredencial().toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnConfirmar;
    private javax.swing.JPanel btnVolverAtras;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblAclaraciones;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JLabel lblIndicaciones;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVolverAtras;
    private javax.swing.JList<String> listaContrasenias;
    private javax.swing.JScrollPane scrollerListaContrasenias;
    private javax.swing.JTextField tfBuscador;
    // End of variables declaration//GEN-END:variables
}
