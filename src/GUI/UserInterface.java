
package GUI;

import javax.swing.JOptionPane;
import POO.*;
import Piezas.*;

public class UserInterface extends javax.swing.JFrame {
    private AlmacenLogin listaUsuarios;
    private AlmacenProblemas listaProblemas;
   
    public UserInterface() {
        initComponents();
        listaUsuarios = new AlmacenLogin();
        listaProblemas = new AlmacenProblemas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameMenu = new javax.swing.JFrame();
        jCerrarSesionButton = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jNombreTextField = new javax.swing.JTextField();
        jAccederButton = new javax.swing.JButton();
        jRadioRegistro = new javax.swing.JRadioButton();
        jRadioLogin = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ioButton = new javax.swing.JButton();

        jCerrarSesionButton.setText("Cerrar Sesión");
        jCerrarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCerrarSesionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameMenuLayout = new javax.swing.GroupLayout(jFrameMenu.getContentPane());
        jFrameMenu.getContentPane().setLayout(jFrameMenuLayout);
        jFrameMenuLayout.setHorizontalGroup(
            jFrameMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jFrameMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrameMenuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jCerrarSesionButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jFrameMenuLayout.setVerticalGroup(
            jFrameMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jFrameMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrameMenuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jCerrarSesionButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pantalla de acceso");
        setAlwaysOnTop(true);

        jPasswordField.setText("jPasswordField1");

        jNombreTextField.setText("...");

        jAccederButton.setText("Acceder");
        jAccederButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAccederButtonActionPerformed(evt);
            }
        });

        jRadioRegistro.setText("Registro");
        jRadioRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioRegistroActionPerformed(evt);
            }
        });

        jRadioLogin.setText("Login");

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        ioButton.setText("Importar/Exportar");
        ioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jRadioRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioLogin))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ioButton)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jAccederButton)
                        .addGap(30, 30, 30)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioRegistro)
                    .addComponent(jRadioLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAccederButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ioButton)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioRegistroActionPerformed

    }//GEN-LAST:event_jRadioRegistroActionPerformed

    private void jAccederButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAccederButtonActionPerformed

        if (jNombreTextField.getText().isEmpty() || jPasswordField.getPassword()==null)
            JOptionPane.showMessageDialog(this,"Compruebe que ningún campo esté vacío","ERROR",JOptionPane.ERROR_MESSAGE);
        else if (jRadioRegistro.isSelected()){
            if(!(listaUsuarios.anadirUsuario(new Usuario(jNombreTextField.getText(),jPasswordField.getPassword().toString()))))
                JOptionPane.showMessageDialog(this,"Ya existe una cuenta con ese nombre","ERROR",JOptionPane.ERROR_MESSAGE);
            else
                //Iniciar sesión
                throw new RuntimeException("Not implemented yet");
        } else if (jRadioLogin.isSelected()){
            if(!(listaUsuarios.existeUsuario(jNombreTextField.getText())))
                JOptionPane.showMessageDialog(this,"No existe cuenta con ese nombre","ERROR",JOptionPane.ERROR_MESSAGE);
            else if (!(listaUsuarios.getUsuario(jNombreTextField.getText()).getPwd().equals(jPasswordField.getPassword().toString())))
                JOptionPane.showMessageDialog(this,"Contraseña incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
            else 
                //Iniciar sesión
                throw new RuntimeException("Not implemented yet");
        }
    }//GEN-LAST:event_jAccederButtonActionPerformed

    private void ioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ioButtonActionPerformed

    private void jCerrarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCerrarSesionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCerrarSesionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ioButton;
    private javax.swing.JButton jAccederButton;
    private javax.swing.JButton jCerrarSesionButton;
    private javax.swing.JFrame jFrameMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jNombreTextField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRadioLogin;
    private javax.swing.JRadioButton jRadioRegistro;
    // End of variables declaration//GEN-END:variables
}
