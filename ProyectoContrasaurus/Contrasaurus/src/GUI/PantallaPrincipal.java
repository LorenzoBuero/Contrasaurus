/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author pirulo
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName());

    int mouseX;
    int mouseY;
   
    public PantallaPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JPanel();
        lblAgregar = new javax.swing.JLabel();
        btnBuscarOcultos = new javax.swing.JPanel();
        lblBuscarOcultos = new javax.swing.JLabel();
        btnBuscarDefaults = new javax.swing.JPanel();
        lblBuscarDefaults = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        lblEliminar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JPanel();
        lblEditar = new javax.swing.JLabel();
        btnOpciones = new javax.swing.JPanel();
        lblOpciones = new javax.swing.JLabel();
        lblDebugEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        fondo.setBackground(new java.awt.Color(204, 255, 204));
        fondo.setMinimumSize(new java.awt.Dimension(80, 160));
        fondo.setPreferredSize(new java.awt.Dimension(800, 500));
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondoMousePressed(evt);
            }
        });
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblAgregar.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregar.setText("Agregar Cuenta");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarLayout.createSequentialGroup()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        fondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 760, 140));

        btnBuscarOcultos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblBuscarOcultos.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblBuscarOcultos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscarOcultos.setText("Buscar Cuentas Ocultas");

        javax.swing.GroupLayout btnBuscarOcultosLayout = new javax.swing.GroupLayout(btnBuscarOcultos);
        btnBuscarOcultos.setLayout(btnBuscarOcultosLayout);
        btnBuscarOcultosLayout.setHorizontalGroup(
            btnBuscarOcultosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarOcultosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarOcultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarOcultosLayout.setVerticalGroup(
            btnBuscarOcultosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBuscarOcultosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarOcultos, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        fondo.add(btnBuscarOcultos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 270, 140));

        btnBuscarDefaults.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblBuscarDefaults.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblBuscarDefaults.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscarDefaults.setText("Buscar Cuentas Estándar");

        javax.swing.GroupLayout btnBuscarDefaultsLayout = new javax.swing.GroupLayout(btnBuscarDefaults);
        btnBuscarDefaults.setLayout(btnBuscarDefaultsLayout);
        btnBuscarDefaultsLayout.setHorizontalGroup(
            btnBuscarDefaultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarDefaultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarDefaults, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBuscarDefaultsLayout.setVerticalGroup(
            btnBuscarDefaultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarDefaultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarDefaults, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        fondo.add(btnBuscarDefaults, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 470, 140));

        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblEliminar.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar.setText("Eliminar Cuenta");
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        fondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 220, 140));

        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblEditar.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditar.setText("Editar Cuenta");

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        fondo.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 360, 140));

        btnOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblOpciones.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lblOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOpciones.setText("Opciones");

        javax.swing.GroupLayout btnOpcionesLayout = new javax.swing.GroupLayout(btnOpciones);
        btnOpciones.setLayout(btnOpcionesLayout);
        btnOpcionesLayout.setHorizontalGroup(
            btnOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        btnOpcionesLayout.setVerticalGroup(
            btnOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        fondo.add(btnOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 140, 140));
        fondo.add(lblDebugEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed
        this.mouseX = evt.getX();
        this.mouseY = evt.getY();
    }//GEN-LAST:event_fondoMousePressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnBuscarDefaults;
    private javax.swing.JPanel btnBuscarOcultos;
    private javax.swing.JPanel btnEditar;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnOpciones;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscarDefaults;
    private javax.swing.JLabel lblBuscarOcultos;
    private javax.swing.JLabel lblDebugEstado;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblOpciones;
    // End of variables declaration//GEN-END:variables
}
