
import escpos.EscPos;
import escpos.EscPosConst;
import escpos.Style;
import escpos.barcode.BarCode;
import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import output.PrinterOutputStream;
import pack.DBLoader;

public class AddToCart extends javax.swing.JFrame {

    ArrayList<MyCart> alcart = new ArrayList<>();
    String pid, name, category, photo, billid;
    int sno = 1, quantity, price, totalprice, sum = 0;
    MyTableModel tm = new MyTableModel();

    public AddToCart() {
        initComponents();
        setSize(900, 1000);
        setTitle("Add To Cart");
        getContentPane().setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(tm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        tfbarcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbpreview = new javax.swing.JLabel();
        tfname = new javax.swing.JLabel();
        tfprice = new javax.swing.JLabel();
        tfcategory = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfquantity = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tfgrandtotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfmobile = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Product Code");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 160, 30);

        tfbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfbarcodeActionPerformed(evt);
            }
        });
        getContentPane().add(tfbarcode);
        tfbarcode.setBounds(190, 90, 220, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 90, 90, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        lbpreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbpreview);
        lbpreview.setBounds(15, 16, 180, 130);
        jPanel1.add(tfname);
        tfname.setBounds(259, 39, 446, 51);
        jPanel1.add(tfprice);
        tfprice.setBounds(259, 99, 460, 40);
        jPanel1.add(tfcategory);
        tfcategory.setBounds(259, 148, 472, 43);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 170, 780, 160);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Enter Quantity");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 350, 220, 40);
        getContentPane().add(tfquantity);
        tfquantity.setBounds(220, 360, 280, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("Add To Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(550, 360, 180, 40);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 410, 780, 100);

        tfgrandtotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        getContentPane().add(tfgrandtotal);
        tfgrandtotal.setBounds(400, 790, 410, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton3.setText("CheckOut");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(580, 530, 220, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add Items To Cart");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 10, 450, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mobile");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 520, 140, 40);
        getContentPane().add(tfmobile);
        tfmobile.setBounds(90, 520, 200, 50);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton4.setText("Delete from cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(340, 530, 190, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String barcode = tfbarcode.getText();
            ResultSet rs = DBLoader.executeStatement("select * from products where barcode='" + barcode + "'");
            if (rs.next()) {
                pid = rs.getString("pid");
                name = rs.getString("pname");
                tfname.setText("Name : " + name);
                price = Integer.parseInt(rs.getString("price"));
                tfprice.setText("Price : " + price + "");
                category = rs.getString("category");
                tfcategory.setText("Category : " + category);
                photo = rs.getString("photo");
                ImageIcon icon = new ImageIcon(photo);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(lbpreview.getWidth(), lbpreview.getHeight(), img.SCALE_SMOOTH);
                lbpreview.setIcon((new ImageIcon(newimg)));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid ProductCode");
            }
        } catch (Exception ex) {
            Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        quantity = Integer.parseInt(tfquantity.getText());
        if (tfquantity.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "all fields are required");
        }
        LoadData();
        tfbarcode.setText("");
        tfcategory.setText("");
        tfname.setText("");
        tfprice.setText("");
        lbpreview.setIcon(new ImageIcon());
        tfquantity.setText("");
        tfbarcode.requestFocus();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfbarcodeActionPerformed
        try {
            String barcode = tfbarcode.getText();
            ResultSet rs = DBLoader.executeStatement("select * from products where barcode='" + barcode + "'");
            if (rs.next()) {
                pid = rs.getString("pid");
                name = rs.getString("pname");
                tfname.setText("Name : " + name);
                price = Integer.parseInt(rs.getString("price"));
                tfprice.setText("Price : " + price + "");
                category = rs.getString("category");
                tfcategory.setText("Category : " + category);
                photo = rs.getString("photo");
                ImageIcon icon = new ImageIcon(photo);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(lbpreview.getWidth(), lbpreview.getHeight(), img.SCALE_SMOOTH);
                lbpreview.setIcon((new ImageIcon(newimg)));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid ProductCode");
            }
        } catch (Exception ex) {
            Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfbarcodeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String mobile = tfmobile.getText();
        if (mobile.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number");
        } else if (mobile.length() != 10) {
            JOptionPane.showMessageDialog(this, "Inavlid mobile number");
        } else {
            try {
                ResultSet rs = DBLoader.executeStatement("select *  from bill");
                rs.next();
                rs.moveToInsertRow();
                rs.updateString("dateofbill", new Date() + "");
                rs.updateString("mobilenumber", mobile);
                rs.updateString("grandtotal", sum + "");
                rs.insertRow();
                ResultSet rs1 = DBLoader.executeStatement("select max(billid) as billid from bill");
                if (rs1.next()) {
                    billid = rs1.getString("billid");
                    for (int i = 0; i < alcart.size(); i++) {
                        ResultSet rs2 = DBLoader.executeStatement("select * from billdetails");
                        rs2.next();
                        rs2.moveToInsertRow();
                        rs2.updateString("billid", billid);
                        rs2.updateString("pid", alcart.get(i).pid);
                        rs2.updateString("name", alcart.get(i).name);
                        rs2.updateString("price", alcart.get(i).price + "");
                        rs2.updateString("quantity", alcart.get(i).quantity + "");
                        rs2.updateString("totalprice", alcart.get(i).totalprice + "");
                        rs2.insertRow();
                    }
                    //getbillprited();
                    JOptionPane.showMessageDialog(this, "Bill Generated");
                    String msg = "<html>Bill<br>Product"+"    "+"Quantity" +"    "+"Price";
                    for (MyCart alcart1 : alcart) {
                        msg = msg + "<br>" + alcart1.name + "    " + alcart1.price + "    " + alcart1.quantity + "    " + alcart1.totalprice;
                    }
                    msg = msg + "<br>" + "ToTal Price:" + sum;
            JOptionPane.showMessageDialog(this, msg);
                }
            } catch (Exception ex) {
                Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
        } else {
            int ans = JOptionPane.showConfirmDialog(this, "Do you really want to delete?");
            if (ans == JOptionPane.YES_OPTION) {
                try {
                    sum = sum - alcart.get(jTable1.getSelectedRow()).totalprice;
                    alcart.remove(alcart.get(jTable1.getSelectedRow()));
                    tm.fireTableDataChanged();
                    tfgrandtotal.setText("GrandTotal: " + sum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddToCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddToCart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbpreview;
    private javax.swing.JTextField tfbarcode;
    private javax.swing.JLabel tfcategory;
    private javax.swing.JLabel tfgrandtotal;
    private javax.swing.JTextField tfmobile;
    private javax.swing.JLabel tfname;
    private javax.swing.JLabel tfprice;
    private javax.swing.JTextField tfquantity;
    // End of variables declaration//GEN-END:variables
  class MyTableModel extends AbstractTableModel {

        String colname[];

        MyTableModel() {
            this.colname = new String[]{"Sno", "Product id", "Name", "Price", "Quantity", "Total Price"};
        }

        @Override
        public int getRowCount() {
            return alcart.size();
        }

        @Override
        public int getColumnCount() {
            return colname.length;
        }

        @Override
        public String getColumnName(int col) {
            return colname[col];
        }

        @Override
        public Object getValueAt(int i, int j) {
            switch (j) {
                case 0:
                    return i + 1;
                case 1:
                    return alcart.get(i).pid;
                case 2:
                    return alcart.get(i).name;
                case 3:
                    return alcart.get(i).price;
                case 4:
                    return alcart.get(i).quantity;
                case 5:
                    return alcart.get(i).totalprice;
                default:
                    return null;
            }
        }
    }

    void LoadData() {
        for (int i = 0; i < alcart.size(); i++) {
            System.out.println("previous:" + alcart.get(i).pid);
            System.out.println("new:" + pid);
            if (alcart.get(i).pid.equals(pid)) {
                quantity = alcart.get(i).quantity + quantity;
                sum = sum - alcart.get(i).totalprice;
                alcart.remove(i);
            }
        }
        totalprice = quantity * price;
        alcart.add(new MyCart(pid, name, price, quantity, totalprice));
        sno++;
        for (int i = 0; i < alcart.size(); i++) {
            sum += alcart.get(i).totalprice;
        }
        tfgrandtotal.setText("Grand Total: " + sum);
        tm.fireTableDataChanged();
    }

    void getbillprited() {

        try {

            PrintService printService = PrinterOutputStream.getPrintServiceByName("THERMAL Receipt Printer");
            PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
            EscPos escpos = new EscPos(printerOutputStream);
            Style header = new Style()
                    .setFontSize(Style.FontSize._2, Style.FontSize._2)
                    .setJustification(EscPosConst.Justification.Center)
                    .setBold(true)
                    .setColorMode(Style.ColorMode.WhiteOnBlack);

            Style address = new Style()
                    .setFontName(Style.FontName.Font_A_Default)
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);
            escpos.writeLF(header, "Point of Sale");
            escpos.writeLF(address, "SCO-108, Ranjeet Avenue");
//            escpos.writeLF(address, "+918725983606");
//            escpos.writeLF(address, "GSTIN : 23AADGS334SDZDT");
//            escpos.writeLF(address, "Vat No : 94832848349");
            escpos.writeLF(address, new Date() + "");
//            escpos.writeLF(address, "Table No. 120");
            escpos.writeLF(address, "    ");
            escpos.writeLF(address, "    ");

//            QRCode qrCode = new QRCode()
//                    .setSize(5)
//                    .setModel(QRCode.QRModel._2)
//                    .setJustification(EscPosConst.Justification.Center);
//
//            escpos.write(qrCode, "QR Code");
//
//            escpos.writeLF(address, "    ");
//            BarCode barcode = new BarCode();
//            barcode.setJustification(EscPosConst.Justification.Center);
//            barcode.setHRIPosition(BarCode.BarCodeHRIPosition.BelowBarCode);
//            escpos.write(barcode, tfbarcode.getText());
//            GraphicsImageWrapper imageWrapper = new GraphicsImageWrapper();
//            imageWrapper.setJustification(EscPosConst.Justification.Center);
//            
//            BitonalThreshold bod = new BitonalThreshold();
//            BufferedImage bimg = ImageIO.read(new File("src/images/goku.png"));
//            EscPosImage escPos = new EscPosImage(bimg, bod);
//            escpos.write(imageWrapper, escPos);
//
////            BitonalThreshold bt = new BitonalThreshold();
            Style lineStyle = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);

            escpos.writeLF(lineStyle, "----------------------------------------");

            Style rightText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Right);

            Style leftText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Left_Default);
            Style justifiedText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);

            escpos.writeLF(rightText, "Bill No : " + billid);
            escpos.write(leftText, "Cashier: casher1");
            escpos.write(rightText, "TYPE : DINE IN");
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.writeLF(rightText, "Food Items");
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.writeLF("Item            Rate    Qty    Price");
            System.out.println("Item            Rate    Qty    Price");
            escpos.writeLF(lineStyle, "----------------------------------------");
            for (int i = 0; i < alcart.size(); i++) {
                escpos.write(leftText, alcart.get(i).name);
                escpos.write(rightText, alcart.get(i).price + "    " + alcart.get(i).quantity + "    " + alcart.get(i).totalprice);
                escpos.writeLF("");

                System.out.print(alcart.get(i).name);
                System.out.print(alcart.get(i).price + "    " + alcart.get(i).quantity + "    " + alcart.get(i).totalprice);
                System.out.println("");
            }
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.write(justifiedText, "Net Payable");
            escpos.write(rightText, sum + "");

//            Style justifiedText = new Style()
//                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
//                    .setJustification(EscPosConst.Justification.Left_Default);
            escpos.feed(5);
            escpos.cut(EscPos.CutMode.PART);
            escpos.close();

            
           
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
