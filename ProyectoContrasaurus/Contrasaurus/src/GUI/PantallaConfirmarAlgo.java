package GUI;

import ManejadoresApp.ControladorApp;
import app.CredencialAlmacenada;
import java.awt.Point;

/**
 *
 * @author Lorenzo Buero
 */
public class PantallaConfirmarAlgo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaConfirmarAlgo.class.getName());

    private ControladorApp controlador;
    private CredencialAlmacenada credencial;
    public PantallaConfirmarAlgo() {
        initComponents();
    }
    public PantallaConfirmarAlgo(ControladorApp controlador, Point posicion, CredencialAlmacenada cred){
        this.controlador = controlador;
        this.setLocation(posicion);
        this.credencial = cred;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        btnEleccionSi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEleccionNo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        taPadrePreguntas = new javax.swing.JScrollPane();
        taPregunta = new javax.swing.JTextArea();
        lblDebugEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEleccionSi.setBackground(new java.awt.Color(0, 102, 0));
        btnEleccionSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEleccionSiMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SI");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnEleccionSiLayout = new javax.swing.GroupLayout(btnEleccionSi);
        btnEleccionSi.setLayout(btnEleccionSiLayout);
        btnEleccionSiLayout.setHorizontalGroup(
            btnEleccionSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );
        btnEleccionSiLayout.setVerticalGroup(
            btnEleccionSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        fondo.add(btnEleccionSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, 40));

        btnEleccionNo.setBackground(new java.awt.Color(153, 0, 0));
        btnEleccionNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEleccionNoMouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NO");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnEleccionNoLayout = new javax.swing.GroupLayout(btnEleccionNo);
        btnEleccionNo.setLayout(btnEleccionNoLayout);
        btnEleccionNoLayout.setHorizontalGroup(
            btnEleccionNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEleccionNoLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnEleccionNoLayout.setVerticalGroup(
            btnEleccionNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        fondo.add(btnEleccionNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, 40));

        taPregunta.setColumns(20);
        taPregunta.setRows(5);
        taPadrePreguntas.setViewportView(taPregunta);

        fondo.add(taPadrePreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 420, 70));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEleccionSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEleccionSiMouseClicked
        if(this.controlador.getEstado().equals("73"))//editar
        {
            this.controlador.editarCredencial(this.credencial);
            
        }else if (this.controlador.getEstado().equals("62")){//eliminar
            
            this.controlador.eliminarCredencial(credencial);
            
        }
        this.controlador.setEstado("20");
        PantallaPrincipal pantalla = new PantallaPrincipal(this.controlador, this.getLocation());
        this.dispose();
    }//GEN-LAST:event_btnEleccionSiMouseClicked

    private void btnEleccionNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEleccionNoMouseClicked
        if(this.controlador.getEstado().equals("73"))//editar
        {
            this.controlador.setEstado("72");
            PantallaAgregarEditarCuenta pantalla = new PantallaAgregarEditarCuenta(this.controlador, this.getLocation(), this.credencial);
        
            
        }else if (this.controlador.getEstado().equals("62")){//eliminar
            this.controlador.setEstado("61");
            PantallaBuscarContrasenia pantalla = new PantallaBuscarContrasenia(this.controlador, this.getLocation(), true);
            
        }
        this.dispose();
    }//GEN-LAST:event_btnEleccionNoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEleccionNo;
    private javax.swing.JPanel btnEleccionSi;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JScrollPane taPadrePreguntas;
    private javax.swing.JTextArea taPregunta;
    // End of variables declaration//GEN-END:variables
}
