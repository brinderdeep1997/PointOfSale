
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import pack.DBLoader;

public class ManageCategories extends javax.swing.JFrame {

    File file;
    ArrayList<categories> alitem = new ArrayList<>();
    MyTableModel tm = new MyTableModel();

    public ManageCategories() {
        initComponents();
        setSize(1560, 900);
        setTitle("Manage Categories");
         getContentPane().setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(tm);
        getdata();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfcatname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfdes = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbpreview = new javax.swing.JLabel();
        lbfilename = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Categories");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 20, 320, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Category Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Description");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 170, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Photo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 290, 100, 30);
        getContentPane().add(tfcatname);
        tfcatname.setBounds(180, 100, 180, 40);

        tfdes.setColumns(20);
        tfdes.setRows(5);
        jScrollPane1.setViewportView(tfdes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(180, 150, 180, 110);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 330, 170, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Add Category");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 450, 230, 50);

        lbpreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbpreview);
        lbpreview.setBounds(180, 260, 170, 150);
        getContentPane().add(lbfilename);
        lbfilename.setBounds(120, 420, 280, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Already Added Categories");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(800, 10, 500, 60);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(790, 120, 560, 490);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(980, 640, 230, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser("C:\\");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpeg", "jpg", "bmp", "png");
        jfc.setFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        int returnVal = jfc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(file);
                //Image newimg = img.getScaledInstance(lbpreview.getWidth(), lbpreview.getHeight(), Image.SCALE_SMOOTH);
                BufferedImage newimg = resizephoto(img, lbpreview.getWidth(), lbpreview.getHeight());
                lbfilename.setText(file.getName());
                lbpreview.setIcon(new ImageIcon(newimg));
            } catch (Exception ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String catname = tfcatname.getText();
        String des = tfdes.getText();
        String picpath = lbfilename.getText();
        if (catname.equals("") || des.equals("") || picpath.equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are required");
        } else {
            try {
                ResultSet rs = DBLoader.executeStatement("select * from categories where catname='" + catname + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Same category already exists");
                } else {
                    String newfilename = new Date().getTime() + ".jpg";
                    new savefileinfolder(file, newfilename);
                    rs.moveToInsertRow();
                    rs.updateString("catname", catname);
                    rs.updateString("description", des);
                    rs.updateString("photo", "src/uploaded_pics/" + newfilename);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(this, "category Added");
                    getdata();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "please select a row to delete");
        } else {

            int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete row??");
            if (ans == JOptionPane.YES_OPTION) {
                try {
                    String catname = alitem.get(jTable1.getSelectedRow()).categoryname;
                    ResultSet rs = DBLoader.executeStatement("select * from categories where catname='" + catname + "'");
                    if (rs.next()) {
                        rs.deleteRow();
                    }
                    getdata();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCategories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCategories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbfilename;
    private javax.swing.JLabel lbpreview;
    private javax.swing.JTextField tfcatname;
    private javax.swing.JTextArea tfdes;
    // End of variables declaration//GEN-END:variables
class MyTableModel extends AbstractTableModel {

        String colname[];

        MyTableModel() {
            this.colname = new String[]{"Category Name", "Description", "Photo"};
        }

        @Override
        public int getColumnCount() {
            return colname.length;
        }

        @Override
        public int getRowCount() {
            return alitem.size();
        }

        @Override
        public String getColumnName(int col) {
            return colname[col];
        }

        @Override
        public Object getValueAt(int i, int j) {
            switch (j) {
                case 0:
                    return alitem.get(i).categoryname;
                case 1:
                    return alitem.get(i).description;
                case 2:
                    return alitem.get(i).path;
                default:
                    return null;
            }
        }
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        ImageIcon icon = new ImageIcon("");
        BufferedImage bufferedImage, newimage;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
//            try {
//                URL url = new URL( alitem.get(row).path);
//                System.out.println("url : " + url);
//                bufferedImage = ImageIO.read(url);
//                newimage = resizephoto(alitem.get(row).path, 100, 100);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
            icon = new ImageIcon(alitem.get(row).path);
            Image im = icon.getImage();
            Image newimg = im.getScaledInstance(80, 70, Image.SCALE_SMOOTH);

            lbl.setIcon(new ImageIcon(newimg));
//            lbl.setIcon(icon);
//            lbl.setBounds(0, 0, 100, 100);
            return lbl;
        }
    }

    BufferedImage resizephoto(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public void getdata() {
        String ans = "";
        try {
            ResultSet rs = DBLoader.executeStatement("select * from categories");
            while (rs.next()) {
                String catname = rs.getString("catname");
                String description = rs.getString("description");
                String catphoto = rs.getString("photo");
                ans = ans + catname + "~!@" + description + "~!@" + catphoto + ";";
            }

            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, ";");
            alitem.clear();
            while (st.hasMoreTokens()) {
                String row = st.nextToken();
                System.out.println(row);
                StringTokenizer stcol = new StringTokenizer(row, "~!@");
                alitem.add(new categories(stcol.nextToken(), stcol.nextToken(), stcol.nextToken()));
            }
            jTable1.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
            jTable1.setRowHeight(100);
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
