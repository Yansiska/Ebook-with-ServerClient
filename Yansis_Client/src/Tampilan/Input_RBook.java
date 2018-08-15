/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import object.iAutoG;
import object.iReading_Book;

/**
 *
 * @author user
 */
public class Input_RBook extends javax.swing.JFrame {
iReading_Book obj5;
iAutoG obj3;
    /**
     * Creates new form Input_RBook
     */
    public Input_RBook() {
        initComponents();
        setLocationRelativeTo(this);
          try
            {
               Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1",1597);
               obj5 = (iReading_Book) myRegistry.lookup("log5");
               obj3 = (iAutoG)myRegistry.lookup("log3");
            }
          catch (Exception e)
            {
               JOptionPane.showMessageDialog(null,"error 1 :"+ e);
            }
          
            autoGenerateID();
    }
    private void clear()
    {
        txt_idrbuku.setText("");
        txt_nama.setText("");
        txt_namabuku.setText("");
        //txt_stock.setText("");
        txt_date.setText("");
    }
    
     private void add(){
        try{
            obj5.setIdBacaBuku(txt_idrbuku.getText());
            obj5.setNama(txt_nama.getText());
            obj5.setNameBuku(txt_namabuku.getText());
            //obj5.setStock(Integer.parseInt(txt_stock.getText()));
            obj5.setQty(Integer.parseInt(txtQty.getText()));
            obj5.setDate(txt_date.getText());
            
            if(obj5.getIdBacaBuku().equals("") && obj5.getNama().equals("") && obj5.getNameBuku().equals("") && String.valueOf(obj5.getQty()).equals("") && obj5.getDate().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Data cant be empty");
            }
            else
            {
                int i = obj5.doInsert();
                if(i > 0){
                    JOptionPane.showMessageDialog(null, "Data has been successed");
                    this.clear();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Data cant be added");
                }
            }
        }
        catch (Exception e)
            {
               JOptionPane.showMessageDialog(null,"error 1 :"+ e);
            }
    }
            
    private void getRecord(String id)
    {
        try{
            obj5.setIdBacaBuku(id);
            ArrayList data = obj5.getRecord();
            txt_idrbuku.setText((String)data.get(0));
            txt_nama.setText((String)data.get(1));
            txt_namabuku.setText((String)data.get(2));
            //txt_stock.setText(String.valueOf(data.get(3)));
            txt_date.setText((String)data.get(3));
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Data cant be displayed");
        }
    }
    
    public void autoGenerateID()
    {
        try
        {
            String ID_RBook = obj3.autoidBacaBuku();
            txt_idrbuku.setText(ID_RBook);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan" + ex.getMessage());
   
        }
    }
    
    public Input_RBook(String id) {
        initComponents();
        setLocationRelativeTo(this);
          try
            {
               Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1",1597);
               obj5 = (iReading_Book) myRegistry.lookup("log5");
            }
          catch (Exception e)
            {
               JOptionPane.showMessageDialog(null,"error 1 :"+ e);
            }
          this.getRecord(id);
    }
    
    private void update() {
        try {
            obj5.setIdBacaBuku(txt_idrbuku.getText().trim());
            obj5.setNama(txt_nama.getText().trim());
            obj5.setNameBuku(txt_namabuku.getText().trim());
            //obj5.setStock(Integer.parseInt(txt_stock.getText().trim()));
            obj5.setDate(txt_date.getText().trim());
            int i = obj5.doUpdate();
            if(i > 0) {
                JOptionPane.showMessageDialog(null, "Data has been successfully updated");
                this.clear();
            }
            else {
                JOptionPane.showMessageDialog(null, "Data cant be updated");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
    }
      
       private void delete() {
        try {
            obj5.setIdBacaBuku(txt_idrbuku.getText());            
            int i = obj5.doDelete();
            if(i > 0) {
                JOptionPane.showMessageDialog(null, "Data has been successfully deleted");
                this.clear();
            }
            else {
                JOptionPane.showMessageDialog(null, "Data cant be deleted");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel_IdEm = new javax.swing.JLabel();
        txt_idrbuku = new javax.swing.JTextField();
        jLabel_name = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel_position = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jRadioButton_p = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel_position2 = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        txt_namabuku = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(566, 575));

        jLabel_IdEm.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel_IdEm.setText("ID Reading Book         :");

        txt_idrbuku.setEditable(false);
        txt_idrbuku.setEnabled(false);
        txt_idrbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idrbukuActionPerformed(evt);
            }
        });

        jLabel_name.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel_name.setText("Name                      :");

        jLabel_position.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel_position.setText("Book_Name               :");

        txtQty.setBackground(new java.awt.Color(0, 153, 204));
        txtQty.setForeground(new java.awt.Color(0, 153, 204));
        txtQty.setText("1");
        txtQty.setBorder(null);
        txtQty.setCaretColor(new java.awt.Color(0, 153, 204));
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        jRadioButton_p.setText("Women");
        jRadioButton_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_pActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 51, 153));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setText("Reading Books");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        btn_add.setBackground(new java.awt.Color(204, 204, 204));
        btn_add.setFont(new java.awt.Font("OCR A Extended", 1, 11)); // NOI18N
        btn_add.setText("SAVE");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("OCR A Extended", 1, 11)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("OCR A Extended", 1, 11)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel_position2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel_position2.setText("Date                       :");

        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });

        txt_namabuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_IdEm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_position, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_position2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(txt_idrbuku, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_date)
                    .addComponent(txt_namabuku, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_add)
                        .addGap(29, 29, 29)
                        .addComponent(btn_update)
                        .addGap(27, 27, 27)
                        .addComponent(btn_delete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(412, 412, 412)
                        .addComponent(jRadioButton_p, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_IdEm)
                    .addComponent(txt_idrbuku, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_position, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namabuku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_position2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_update)
                            .addComponent(btn_delete))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jRadioButton_p, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idrbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idrbukuActionPerformed
        // TODO add your handling code here:
        this.autoGenerateID();
    }//GEN-LAST:event_txt_idrbukuActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtQtyActionPerformed

    private void jRadioButton_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_pActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        this.add();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        this.update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        this.delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        //List_User employee = new List_User();
        //employee.show();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void txt_namabukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabukuActionPerformed

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
            java.util.logging.Logger.getLogger(Input_RBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_RBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_RBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_RBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_RBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_IdEm;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_position;
    private javax.swing.JLabel jLabel_position2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton_p;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_idrbuku;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_namabuku;
    // End of variables declaration//GEN-END:variables
}
