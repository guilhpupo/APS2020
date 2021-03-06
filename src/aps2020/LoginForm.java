/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps2020;

import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class LoginForm extends javax.swing.JFrame {

    public static final String DIGITAL = "digital 1";
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPrincipal = new javax.swing.JLabel();
        lblAps = new javax.swing.JLabel();
        lblSecundaria = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APS 2020 Login");
        setResizable(false);

        lblPrincipal.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrincipal.setText("Acesse com a sua digital");

        lblAps.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lblAps.setText("APS 2020");

        lblSecundaria.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSecundaria.setText("Toque no sensor e confirme sua digital para acessar a sua conta");

        lblImagem.setText("");
        lblImagem.setPreferredSize(new java.awt.Dimension(50, 50));
        lblImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblImagemMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lblPrincipal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAps)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSecundaria)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblSecundaria)
                .addGap(26, 26, 26)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblAps)
                .addContainerGap())
        );

        ImageIcon img = new ImageIcon(getClass().getResource("digital.png"));

        //dando um tamanho
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);

        //exibir img no label
        lblImagem.setIcon(new ImageIcon(newimg));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblImagemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagemMouseReleased
        
        try {
            Connection con = ConexaoMySQL.abrirConexao();
            UsuarioDAO ud = new UsuarioDAO(con);
            Usuario usuario = ud.getUsuario(DIGITAL);
            if(usuario == null){
                JOptionPane.showMessageDialog(this, "Erro na leitura, tente novamente.");
                return;
            }
            InfoForm novaTela = new InfoForm(usuario);
            novaTela.setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblImagemMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAps;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblPrincipal;
    private javax.swing.JLabel lblSecundaria;
    // End of variables declaration//GEN-END:variables
}
