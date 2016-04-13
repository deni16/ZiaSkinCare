/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ziaskincare.config.MessageUtil;
import ziaskincare.dao.DataBarangDao;
import ziaskincare.dao.KategoriDao;
import ziaskincare.dao.SatuanDao;
import ziaskincare.entity.DataBarang;
import ziaskincare.entity.Kategori;
import ziaskincare.entity.Satuan;
import ziaskincare.komponen.Center;


/**
 *
 * @author Ai
 */
public class DataBarangLayout extends javax.swing.JFrame {
    private KategoriDao kategoriDao;
    private SatuanDao satuanDao;
    private DataBarangDao dataBarangDao;
    private DataBarang selectedDataBarang;
    
    public DataBarangLayout() throws ClassNotFoundException, SQLException {
        initComponents();
        kategoriDao = new KategoriDao();
        satuanDao = new SatuanDao();
        dataBarangDao = new DataBarangDao();
        Center Center = new Center(this);
        
        //set combo kategori
        List<Kategori> listKategori = kategoriDao.getAllData();
        for (Kategori kategori : listKategori) {
            cmbKategori.addItem(kategori.getName());
        }
        //set combo satuan
        List<Satuan> listSatuan = satuanDao.getAllData();
        for (Satuan satuan : listSatuan) {
            cmbSatuan.addItem(satuan.getNama());
        }
        
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        getListBarang();
    }
    public void getListBarang(){
        //set header tabel
        String[] judul = {"Kode Barang","Nama Barang","Harga Beli","Harga Jual","Kategori","Satuan","Stok","Deskripsi"};
        DefaultTableModel data = new DefaultTableModel(null, judul);
        tblDataBarang.setModel(data);
        //set isi table dari semua data barang
        List<DataBarang> listDataBarang = dataBarangDao.getAllData();
        for (DataBarang dataBarang : listDataBarang){
            data.addRow(new Object[]{dataBarang.getKode(),dataBarang.getNama(), dataBarang.getHargaBeli(), dataBarang.getHargaJual(), dataBarang.getKategori().getName(), dataBarang.getSatuan().getNama(), dataBarang.getStok(), dataBarang.getDeskripsi()});
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

        panel1 = new ziaskincare.komponen.Panel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        cmbSatuan = new javax.swing.JComboBox();
        txtHargaJual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataBarang = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtHargaBeli = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GSave.jpg"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/Gedit.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel4.setText("Satuan *");

        jLabel3.setText("Kategori *");

        jLabel2.setText("Nama Barang *");

        jLabel1.setText("Kode Barang *");

        cmbSatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "= Silahkan Pilih =" }));

        jLabel7.setText("Deskripsi ");

        jLabel5.setText("Harga Jual *");

        jLabel6.setText("Stok *");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("Formulir Data Barang");

        tblDataBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataBarang);

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GClear.jpg"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GDelete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GMenu.jpg"))); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        name.setText("jLabel9");

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        jScrollPane2.setViewportView(txtDeskripsi);

        jLabel9.setText("Harga Beli *");

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "= Silahkan Pilih =" }));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addGap(45, 45, 45)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHargaJual, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txtHargaBeli)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txtKode))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenu)
                .addGap(83, 83, 83))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(name)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(cmbSatuan, 0, 155, Short.MAX_VALUE)
                                    .addComponent(txtStok)
                                    .addComponent(cmbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(58, 58, 58))))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMenu)
                            .addComponent(btnDelete)
                            .addComponent(btnClear)
                            .addComponent(btnUpdate)
                            .addComponent(btnSave))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public void clear() {
        txtKode.setText(null);
        txtNama.setText(null);
        txtHargaBeli.setText(null);
        txtHargaJual.setText(null);
        cmbKategori.setSelectedItem(null);
        cmbSatuan.setSelectedItem(null);
        txtStok.setText(null);
        txtDeskripsi.setText(null);
     }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        //get kategori and satuan
        Kategori selectedKategori;
        try {
            selectedKategori = kategoriDao.getEntityByName(cmbKategori.getSelectedItem().toString());
            Satuan selectedSatuan = satuanDao.getEntityByNama(cmbSatuan.getSelectedItem().toString());
          // save data barang
            DataBarang dataBarang = new DataBarang();
            dataBarang.setKode(txtKode.getText());
            dataBarang.setNama(txtNama.getText());
            dataBarang.setHargaBeli(new BigDecimal(txtHargaBeli.getText()));
            dataBarang.setHargaJual(new BigDecimal(txtHargaJual.getText()));
            dataBarang.setKategori(selectedKategori);
            dataBarang.setSatuan(selectedSatuan);
            dataBarang.setStok(Integer.valueOf(txtStok.getText()));
            dataBarang.setDeskripsi(txtDeskripsi.getText());
            dataBarangDao.save(dataBarang);
            JOptionPane.showMessageDialog(null, MessageUtil.successSaveMessage());
            getListBarang();
            clear();
            } catch (SQLException ex) {
            Logger.getLogger(DataBarangLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        MenuLayout menuLayout = new MenuLayout();
        menuLayout.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         try {
            // get selected kategori and satuan
            Kategori selectedKategori = kategoriDao.getEntityByName(cmbKategori.getSelectedItem().toString());
            Satuan selectedSatuan = satuanDao.getEntityByNama(cmbSatuan.getSelectedItem().toString());
            // save data barang
            selectedDataBarang.setKode(txtKode.getText());
            selectedDataBarang.setNama(txtNama.getText());
            selectedDataBarang.setHargaBeli(new BigDecimal(txtHargaBeli.getText()));
            selectedDataBarang.setHargaJual(new BigDecimal(txtHargaJual.getText()));
            selectedDataBarang.setKategori(selectedKategori);
            selectedDataBarang.setSatuan(selectedSatuan);
            selectedDataBarang.setStok(Integer.valueOf(txtStok.getText()));
            selectedDataBarang.setDeskripsi(txtDeskripsi.getText());
            dataBarangDao.update(selectedDataBarang);
            JOptionPane.showMessageDialog(null, MessageUtil.successUpdateMessage());
            getListBarang();
            clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, MessageUtil.failureMessage());
            Logger.getLogger(DataBarangLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataBarangMouseClicked
        // TODO add your handling code here:
        int baris = tblDataBarang.getSelectedRow();
        int noId = Integer.valueOf(tblDataBarang.getValueAt(baris, 0).toString()); 
        try {
            selectedDataBarang = dataBarangDao.getEntityById(noId);
            txtKode.setText(selectedDataBarang.getKode());
            txtNama.setText(String.valueOf(selectedDataBarang.getNama()));
            txtHargaBeli.setText(String.valueOf(selectedDataBarang.getHargaBeli()));
            txtHargaJual.setText(String.valueOf(selectedDataBarang.getHargaBeli()));
            cmbKategori.setSelectedItem(selectedDataBarang.getKategori().getName());
            cmbSatuan.setSelectedItem(selectedDataBarang.getSatuan().getNama());
            txtStok.setText(String.valueOf(selectedDataBarang.getStok()));
            txtDeskripsi.setText(String.valueOf(selectedDataBarang.getDeskripsi()));
        } catch (SQLException ex) {
            Logger.getLogger(DataBarangLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tblDataBarangMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        dataBarangDao.delete(selectedDataBarang);
        btnSave.setEnabled(true);
        getListBarang();
        clear();
    }//GEN-LAST:event_btnDeleteActionPerformed
    
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
            java.util.logging.Logger.getLogger(DataBarangLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBarangLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBarangLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBarangLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DataBarangLayout().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DataBarangLayout.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DataBarangLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JComboBox cmbSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private ziaskincare.komponen.Panel panel1;
    private javax.swing.JTable tblDataBarang;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
