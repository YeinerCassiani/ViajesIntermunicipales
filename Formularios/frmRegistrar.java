
package Formularios;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class frmRegistrar extends javax.swing.JFrame {
    
    Conexion cnx = new Conexion();
    public frmRegistrar() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbBtnInstagram = new javax.swing.JLabel();
        lbBtnFacebook = new javax.swing.JLabel();
        lbBtnTwitter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnRegistrar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbIncorrecto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtContrasena = new javax.swing.JPasswordField();
        txtContrasenaRep = new javax.swing.JPasswordField();
        txtNombreCompleto = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(50, 103, 137));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("¡SÍGUENOS!");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 300, -1));

        lbBtnInstagram.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBtnInstagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoInstagram.png"))); // NOI18N
        lbBtnInstagram.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBtnInstagram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBtnInstagramMouseClicked(evt);
            }
        });
        jPanel2.add(lbBtnInstagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 300, 90));

        lbBtnFacebook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBtnFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoFacebook.png"))); // NOI18N
        lbBtnFacebook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBtnFacebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBtnFacebookMouseClicked(evt);
            }
        });
        jPanel2.add(lbBtnFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 90));

        lbBtnTwitter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBtnTwitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoTwitter.png"))); // NOI18N
        lbBtnTwitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBtnTwitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBtnTwitterMouseClicked(evt);
            }
        });
        jPanel2.add(lbBtnTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 300, 90));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, 450));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGÍSTRATE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 496, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel2.setText("DOCUMENTO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 103, -1, -1));

        txtDocumento.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtDocumento.setForeground(new java.awt.Color(204, 204, 204));
        txtDocumento.setText("Ingrese Número de Documento");
        txtDocumento.setBorder(null);
        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusLost(evt);
            }
        });
        jPanel1.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 200, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 172, 200, 10));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel3.setText("NOMBRE Y APELLIDO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 193, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 262, 200, 10));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel4.setText("TELÉFONO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 283, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 352, 200, 10));

        btnRegistrar.setBackground(new java.awt.Color(50, 103, 137));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistrarMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGÍSTRAME");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setPreferredSize(new java.awt.Dimension(110, 40));

        javax.swing.GroupLayout btnRegistrarLayout = new javax.swing.GroupLayout(btnRegistrar);
        btnRegistrar.setLayout(btnRegistrarLayout);
        btnRegistrarLayout.setHorizontalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegistrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnRegistrarLayout.setVerticalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegistrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 384, -1, -1));

        btnVolver.setBackground(new java.awt.Color(50, 103, 137));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVolverMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VOLVER");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 40));

        javax.swing.GroupLayout btnVolverLayout = new javax.swing.GroupLayout(btnVolver);
        btnVolver.setLayout(btnVolverLayout);
        btnVolverLayout.setHorizontalGroup(
            btnVolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnVolverLayout.setVerticalGroup(
            btnVolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVolverLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 384, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SIN RETORNO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 496, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 159, 216));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("RESERVA UNA AVENTURA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 496, -1));

        lbIncorrecto.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        lbIncorrecto.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lbIncorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 418, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel10.setText("CORREO ELECTRÓNICO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 103, -1, -1));

        txtEmail.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setText("Ingrese Correo Electrónico");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 200, 40));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 172, 200, 10));

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel11.setText("CONTRASEÑA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 193, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 262, 200, 10));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel12.setText("REPETIR CONTRASEÑA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 283, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 352, 200, 10));

        txtContrasena.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(204, 204, 204));
        txtContrasena.setText("Ingrese Contraseña");
        txtContrasena.setBorder(null);
        txtContrasena.setEchoChar('\u0000');
        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusLost(evt);
            }
        });
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 200, 40));

        txtContrasenaRep.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtContrasenaRep.setForeground(new java.awt.Color(204, 204, 204));
        txtContrasenaRep.setText("Ingrese Contraseña");
        txtContrasenaRep.setBorder(null);
        txtContrasenaRep.setEchoChar('\u0000');
        txtContrasenaRep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaRepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContrasenaRepFocusLost(evt);
            }
        });
        jPanel1.add(txtContrasenaRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 200, 40));

        txtNombreCompleto.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtNombreCompleto.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreCompleto.setText("Ingrese Nombre y Apellido");
        txtNombreCompleto.setBorder(null);
        txtNombreCompleto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreCompletoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreCompletoFocusLost(evt);
            }
        });
        jPanel1.add(txtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 200, 40));

        txtTelefono.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(204, 204, 204));
        txtTelefono.setText("Ingrese Teléfono");
        txtTelefono.setBorder(null);
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frmLogin Login = new frmLogin();
        String botones[] = {"Aceptar","Cancelar"};
        int Desicion = JOptionPane.showOptionDialog (null, " ¿Estas Seguro que quieres cerrar La App?", "Seguro", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
        
        if (Desicion == 1)
        {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
        }
        else 
        {
             Login.setVisible(true);
             this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnVolverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMousePressed
        frmLogin Login = new frmLogin();
        Login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverMousePressed

    private void txtDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusGained
        if (txtDocumento.getText().equals("Ingrese Número de Documento")) {
            txtDocumento.setText("");
            txtDocumento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtDocumentoFocusGained

    private void txtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusLost
        if (txtDocumento.getText().equals("")) {
            txtDocumento.setText("Ingrese Número de Documento");
            txtDocumento.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtDocumentoFocusLost

    private void lbBtnFacebookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBtnFacebookMouseClicked
        try {
            enlace("www.facebook.com");
        } catch (IOException ex) {
            Logger.getLogger(frmRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbBtnFacebookMouseClicked

    private void lbBtnTwitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBtnTwitterMouseClicked
        try {
            enlace("www.twitter.com");
        } catch (IOException ex) {
            Logger.getLogger(frmRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbBtnTwitterMouseClicked

    private void lbBtnInstagramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBtnInstagramMouseClicked
        try {
            enlace("www.instagram.com");
        } catch (IOException ex) {
            Logger.getLogger(frmRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbBtnInstagramMouseClicked

    private void btnRegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMousePressed
        int espacios = obtenerEspacios(txtNombreCompleto.getText());        
        String valorPass = new String(txtContrasena.getPassword());
        String valorPassRep = new String(txtContrasenaRep.getPassword());
        if (!txtDocumento.getText().equals("Ingrese Número de Documento") && !txtNombreCompleto.getText().equals("Ingrese Nombre Completo") && !txtTelefono.getText().equals("Ingrese Teléfono") && !txtEmail.getText().equals("Ingrese Correo Electrónico") && !valorPass.equals("Ingrese Contraseña") && !valorPassRep.equals("Ingrese Contraseña")) {
            if (espacios > 1) {
                lbIncorrecto.setText("Introduzca máximo un nombre y un apellido.");
            }else{
                if (!valorPass.equals(valorPassRep)) {
                    lbIncorrecto.setText("Las contraseñas no coinciden.");
                }else{
                    cnx.conectar();
                    if (cnx.verificarUsuario(txtDocumento.getText())) {
                        JOptionPane.showMessageDialog(this, "El usuario ya se encuentra registrado.", "Error", 0);
                    }else{
                        lbIncorrecto.setText("");
                        System.out.println(cnx.resultadoConexion());
                        System.out.println("");
                        boolean correcto = cnx.ingresarUSuario(txtDocumento.getText(), txtNombreCompleto.getText(), valorPass, txtTelefono.getText(), txtEmail.getText(), txtDocumento.getText(), "Cliente");
                        if (correcto){
                            lbIncorrecto.setText("Usuario Registrado con éxito.");
                            lbIncorrecto.setForeground(new Color(0,159,216));
                        }
                    } 
                }
            }
        }else{
            lbIncorrecto.setText("Hay uno o más campos vacios.");
        }
        cnx.cerrarConexion();
    }//GEN-LAST:event_btnRegistrarMousePressed

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained
        if (txtContrasena.getText().equals("Ingrese Contraseña")) {
            txtContrasena.setText("");
            txtContrasena.setForeground(Color.black);
            txtContrasena.setEchoChar('\u25cf');
            txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        }
    }//GEN-LAST:event_txtContrasenaFocusGained

    private void txtContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusLost
        if (txtContrasena.getText().equals("")) {
            txtContrasena.setEchoChar('\u0000');
            txtContrasena.setFont(new Font("Roboto", Font.BOLD, 14));
            txtContrasena.setText("Ingrese Contraseña");
            txtContrasena.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtContrasenaFocusLost

    private void txtContrasenaRepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaRepFocusGained
        if (txtContrasenaRep.getText().equals("Ingrese Contraseña")) {
            txtContrasenaRep.setText("");
            txtContrasenaRep.setForeground(Color.black);
            txtContrasenaRep.setEchoChar('\u25cf');
            txtContrasenaRep.setFont(new Font("Tahoma", Font.PLAIN, 14));
        }
    }//GEN-LAST:event_txtContrasenaRepFocusGained

    private void txtContrasenaRepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaRepFocusLost
        if (txtContrasenaRep.getText().equals("")) {
            txtContrasenaRep.setEchoChar('\u0000');
            txtContrasenaRep.setFont(new Font("Roboto", Font.BOLD, 14));
            txtContrasenaRep.setText("Ingrese Contraseña");
            txtContrasenaRep.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtContrasenaRepFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().equals("Ingrese Correo Electrónico")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("Ingrese Correo Electrónico");
            txtEmail.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtNombreCompletoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreCompletoFocusGained
        if (txtNombreCompleto.getText().equals("Ingrese Nombre y Apellido")) {
            txtNombreCompleto.setText("");
            txtNombreCompleto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreCompletoFocusGained

    private void txtNombreCompletoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreCompletoFocusLost
        if (txtNombreCompleto.getText().equals("")) {
            txtNombreCompleto.setText("Ingrese Nombre y Apellido");
            txtNombreCompleto.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtNombreCompletoFocusLost

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        if (txtTelefono.getText().equals("Ingrese Teléfono")) {
            txtTelefono.setText("");
            txtTelefono.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        if (txtTelefono.getText().equals("")) {
            txtTelefono.setText("Ingrese Teléfono");
            txtTelefono.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtTelefonoFocusLost
    
    public void enlace(String enlace) throws IOException{
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            if(desktop.isSupported(Desktop.Action.BROWSE)){
                try{
                    URI uri = new URI(enlace);
                    desktop.browse(uri);
                }catch(URISyntaxException | IOException ex){
                   
                }
            }
           
        }
    }
    
    public int obtenerEspacios(String nombreCompleto) {
        int espacios = 1; // número de espacios, como mínimo 1 (NOMBRE APELLIDO)
        String[] nombre = nombreCompleto.split(" ");  // separo el string ingresado
        espacios = nombre.length-1;        // número de cadenas a la que le restamos 1 pues tu quieres el número de espacios
        return espacios;      // devuelve el número de espacios de la cadena introducida
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnRegistrar;
    private javax.swing.JPanel btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbBtnFacebook;
    private javax.swing.JLabel lbBtnInstagram;
    private javax.swing.JLabel lbBtnTwitter;
    private javax.swing.JLabel lbIncorrecto;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JPasswordField txtContrasenaRep;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
