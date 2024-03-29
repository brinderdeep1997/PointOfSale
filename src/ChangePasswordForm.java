
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pack.DBLoader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hp
 */
public class ChangePasswordForm extends javax.swing.JFrame {

    /**
     * Creates new form ChangePasswordForm
     */
    ChangePasswordForm(String un) {
        initComponents();
        setSize(800, 600);
        setTitle("Change Password");
        getContentPane().setBackground(new java.awt.Color(204, 204, 255));
        tfusername.setText(un);
        tfusername.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        tfoldpass = new javax.swing.JTextField();
        pfnewpass = new javax.swing.JPasswordField();
        pfconpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 20, 410, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 110, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Old Passowrd");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 160, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("New Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 220, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Confirm Passord");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 270, 140, 40);
        getContentPane().add(tfusername);
        tfusername.setBounds(240, 100, 230, 40);
        getContentPane().add(tfoldpass);
        tfoldpass.setBounds(240, 150, 230, 40);
        getContentPane().add(pfnewpass);
        pfnewpass.setBounds(240, 210, 230, 40);
        getContentPane().add(pfconpass);
        pfconpass.setBounds(240, 270, 230, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 380, 220, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String un = tfusername.getText();
        String oldpass = tfoldpass.getText();
        String newpass = pfnewpass.getText();
        String conpass = pfconpass.getText();
        if (un.equals("") || oldpass.equals("") || newpass.equals("") || conpass.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are mandatory");
        } else if (!(newpass.equals(conpass))) {
            JOptionPane.showMessageDialog(this, "new and confirm password does not match");
        } else {
            try {
                ResultSet rs = DBLoader.executeStatement("select * from adminsignup where username='" + un + "' and password='" + oldpass + "'");
                if (rs.next()) {
                    rs.updateString("password", newpass);
                    rs.updateRow();
                    new Adminlogin().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Old password is wrong");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ChangePasswordForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pfconpass;
    private javax.swing.JPasswordField pfnewpass;
    private javax.swing.JTextField tfoldpass;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
