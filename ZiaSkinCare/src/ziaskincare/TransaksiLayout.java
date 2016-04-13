/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ziaskincare.config.RandomNumberUtil;
import ziaskincare.dao.DataBarangDao;
import ziaskincare.dao.DataPelangganDao;
import ziaskincare.dao.DataPetugasDao;
import ziaskincare.dao.TransaksiDao;
import ziaskincare.dao.TransaksiDetailDao;
import ziaskincare.entity.DataBarang;
import ziaskincare.entity.DataPelanggan;
import ziaskincare.entity.Transaksi;
import ziaskincare.entity.TransaksiDetail;
import ziaskincare.komponen.Center;

/**
 *
 * @author Ai
 */
public class TransaksiLayout extends javax.swing.JFrame {

    private DataBarangDao dataBarangDao;
    private DataBarangDao selectedDataBarangDao;
    private DataPetugasDao dataPetugasDao;
    private DataPetugasDao selectedDataPetugasDao;
    private TransaksiDao transaksiDao;
    private TransaksiDetailDao transaksiDetailDao;
    private DataPelangganDao dataPelangganDao;
    private DataPelanggan selectedDataPelanggan;
    private BigDecimal total;
    List<Transaksi> listTransaksi = new ArrayList<Transaksi>();

    /**
     * Creates new form Transaksi
     */
    public TransaksiLayout() throws ClassNotFoundException, SQLException {
        initComponents();
        total = new BigDecimal(0);
        Center Center = new Center(this);
        transaksiDao = new TransaksiDao();
        transaksiDetailDao = new TransaksiDetailDao();
        dataPelangganDao = new DataPelangganDao();
        dataBarangDao = new DataBarangDao();
        List<DataPelanggan> listDataPelanggan = dataPelangganDao.getAllData();
        for (DataPelanggan dataPelanggan : listDataPelanggan) {
            cmbNamaPelanggan.addItem(dataPelanggan.getNamaPelanggan());
        }

        List<DataBarang> listDataBarang = dataBarangDao.getAllData();
        for (DataBarang dataBarang : listDataBarang) {
            cmbKodeBarang.addItem(dataBarang.getKode());
        }
        listTransaksi = new ArrayList<Transaksi>();
        getListTransaksi();
    }

    private void warning() {
        if (lblStock.getText().equals("2")) {
            JOptionPane.showMessageDialog(null, "Perhatikan Stok !!");
        }
    }

    public void getListTransaksi() {
        // set header table
        String[] judul = {"Tanggal", "No Transaski", "Nama Pelanggan", "Kode Barang", "Nama Barang", "Qty", "Diskon", "Sub Total"};
        DefaultTableModel data = new DefaultTableModel(null, judul);
        tabTrans.setModel(data);
        if (!listTransaksi.isEmpty()) {
            for (Transaksi transaksi : listTransaksi) {
                data.addRow(new Object[]{transaksi.getTanggal(), transaksi.getNoTransaksi(), transaksi.getDataPelanggan().getNamaPelanggan(),
                    transaksi.getDataBarang().getKode(), transaksi.getDataBarang().getNama(), transaksi.getQty(), transaksi.getDiskon(), transaksi.getTotalHarga()});
            }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNamaBarang = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtDisc = new javax.swing.JTextField();
        btnInput = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTrans = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        txtJumlahBayar = new javax.swing.JTextField();
        txtKembali = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        txtSubTot = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNoTrans = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTanggalBeli = new com.toedter.calendar.JDateChooser();
        cmbNamaPelanggan = new javax.swing.JComboBox();
        cmbKodeBarang = new javax.swing.JComboBox();
        btnHitung = new javax.swing.JButton();
        btnHitungKembali = new javax.swing.JButton();
        btnSimpanTransaksi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Form Transaksi");

        jLabel2.setText("No Transaksi");

        jLabel3.setText("Nama Pelanggan");

        jLabel4.setText("Kode Barang");

        jLabel5.setText("Nama Barang");

        jLabel6.setText("Harga");

        jLabel7.setText("Qty");

        jLabel8.setText("Stok");

        jLabel9.setText("Diskon %");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNamaBarang.setEnabled(false);

        btnInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/Gread.jpg"))); // NOI18N
        btnInput.setText("Input");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GClear.jpg"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GPrint.jpg"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ziaskincare/picture/GMenu.jpg"))); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        tabTrans.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabTrans);

        jLabel12.setText("Total Harga");

        jLabel13.setText("Jumlah Bayar");

        jLabel14.setText("Kembali");

        jLabel15.setText("Petugas");

        lblStock.setText(" ");

        txtSubTot.setEnabled(false);

        jLabel11.setText("SubTotal");

        jLabel17.setText("Tanggal Pembelian");

        txtTanggalBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTanggalBeliMouseClicked(evt);
            }
        });

        cmbNamaPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Silahkan Pilih--" }));

        cmbKodeBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Silahkan Pilih--" }));
        cmbKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKodeBarangActionPerformed(evt);
            }
        });

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnHitungKembali.setText("Hitung Kembalian");
        btnHitungKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungKembaliActionPerformed(evt);
            }
        });

        btnSimpanTransaksi.setText("Simpan Transaksi");
        btnSimpanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(298, 298, 298))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(txtTanggalBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNamaBarang)
                                    .addComponent(txtQty)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel17))
                                .addGap(169, 169, 169)))
                        .addGap(74, 74, 74)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(31, 31, 31)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(cmbNamaPelanggan, 0, 1, Short.MAX_VALUE)
                                .addGap(201, 201, 201))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSubTot, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDisc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(txtNoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnInput)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(30, 30, 30)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btnPrint)
                        .addGap(18, 18, 18)
                        .addComponent(btnMenu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(54, 54, 54))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(82, 82, 82)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnHitungKembali)
                                .addGap(18, 18, 18)
                                .addComponent(btnSimpanTransaksi))
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtJumlahBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(txtTotalHarga)))))
                .addGap(62, 62, 62))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtTanggalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel2)
                            .addComponent(txtNoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmbKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(lblStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(btnHitung)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInput)
                    .addComponent(btnClear)
                    .addComponent(btnPrint)
                    .addComponent(btnMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtJumlahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHitungKembali)
                    .addComponent(btnSimpanTransaksi))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void kurang_stok() {
        int nilai1 = Integer.valueOf(lblStock.getText());
        int nilai2 = Integer.valueOf(txtQty.getText());
        int nilai3;
        String Hasil;
        nilai3 = nilai1 - nilai2;
        Hasil = String.valueOf(nilai3);
        lblStock.setText(Hasil);
    }

    private void sub_total() {
        int nilai1 = Integer.valueOf(txtQty.getText());
        int nilai2 = Integer.valueOf(txtSubTot.getText());
        int nilai3;
        String Hasil;
        nilai3 = nilai1 * nilai2;
        Hasil = String.valueOf(nilai3);
        txtSubTot.setText(Hasil);
    }

    private void jumlah_bayar() {
        int nilai1 = Integer.valueOf(txtTotalHarga.getText());
        int nilai2 = Integer.valueOf(txtJumlahBayar.getText());
        int nilai3;
        String Hasil;
        nilai3 = nilai1 - nilai2;
        Hasil = String.valueOf(nilai3);
        txtKembali.setText(Hasil);
    }

    private void clear() {
        txtTanggalBeli.setDate(null);
        txtNoTrans.setText(null);
        cmbNamaPelanggan.setSelectedItem(null);
        cmbKodeBarang.setSelectedItem(null);
        txtNamaBarang.setText(null);
        txtHarga.setText(null);
        txtQty.setText(null);
        txtDisc.setText(null);
        txtSubTot.setText(null);
        txtTotalHarga.setText(null);
        txtJumlahBayar.setText(null);
        txtKembali.setText(null);

    }

    private void tidak_bisa_simpan() {
        txtNoTrans.setEnabled(false);
        txtQty.setEnabled(false);
        txtSubTot.setEnabled(false);
        txtJumlahBayar.setEnabled(false);
    }

    private void block() {
        if (lblStock.getText().equals("-1")) {
            JOptionPane.showMessageDialog(null, "Perhatikan Stok !!");
            tidak_bisa_simpan();
        }

    }
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        MenuLayout menuLayout = new MenuLayout();
        menuLayout.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtTanggalBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTanggalBeliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalBeliMouseClicked

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        // TODO add your handling code here:
//        warning();
//        block();
        try {
            
            Transaksi transaksi = new Transaksi();
            transaksi.setDataBarang(dataBarangDao.getEntityByKode(cmbKodeBarang.getSelectedItem().toString()));
            transaksi.setDataPelanggan(dataPelangganDao.getEntityByNama(cmbNamaPelanggan.getSelectedItem().toString()));
            transaksi.setNoTransaksi(Integer.valueOf(txtNoTrans.getText()));
            transaksi.setQty(Integer.valueOf(txtQty.getText()));
            transaksi.setTanggal(txtTanggalBeli.getDate());
            transaksi.setDiskon(Integer.valueOf(txtDisc.getText()));
            transaksi.setTotalHarga(new BigDecimal(txtSubTot.getText()));
            listTransaksi.add(transaksi);
            total = total.add(new BigDecimal(txtSubTot.getText()));
            txtTotalHarga.setText(String.valueOf(total));
            getListTransaksi();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiLayout.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnInputActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtNoTrans.setText(String.valueOf(RandomNumberUtil.getRandomNumber(5)));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKodeBarangActionPerformed
        try {
            // TODO add your handling code here:
            DataBarang dataBarang = dataBarangDao.getEntityByKode(cmbKodeBarang.getSelectedItem().toString());
            txtNamaBarang.setText(dataBarang.getNama());
            txtHarga.setText(String.valueOf(dataBarang.getHargaJual()));
            lblStock.setText(String.valueOf(dataBarang.getStok()));
            System.out.println(dataBarang.getStok());
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbKodeBarangActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        BigDecimal subTotal = new BigDecimal(0);
        BigDecimal diskon = new BigDecimal(0);
        subTotal = new BigDecimal(txtHarga.getText()).multiply(new BigDecimal(txtQty.getText()));
        if (!txtDisc.getText().equals("0")) {
            diskon = (subTotal.divide(new BigDecimal(100))).multiply(new BigDecimal(txtDisc.getText()));
            subTotal = subTotal.subtract(diskon);
        }
        txtSubTot.setText(String.valueOf(subTotal));
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnSimpanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanTransaksiActionPerformed
        // TODO add your handling code here:
        for (Transaksi transaksi : listTransaksi) {
            //save transaksi
            transaksi.setDataPelanggan(dataPelangganDao.getEntityById(transaksi.getDataPelanggan().getId()));
            transaksi.setDataBarang(dataBarangDao.getEntityById(transaksi.getDataBarang().getId()));
            transaksiDao.save(transaksi);
        }
        
        //save detail transaksi
        TransaksiDetail detailTransaksi = new TransaksiDetail();
        detailTransaksi.setNoTransaksi(Integer.valueOf(txtNoTrans.getText()));
        detailTransaksi.setBayar(new BigDecimal(txtJumlahBayar.getText()));
        detailTransaksi.setTotal(new BigDecimal(txtTotalHarga.getText()));
        detailTransaksi.setKembali(new BigDecimal(txtKembali.getText()));
        transaksiDetailDao.save(detailTransaksi);
    }//GEN-LAST:event_btnSimpanTransaksiActionPerformed

    private void btnHitungKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungKembaliActionPerformed
        // TODO add your handling code here:
        BigDecimal bayar = new BigDecimal(txtJumlahBayar.getText());
        BigDecimal total = new BigDecimal(txtTotalHarga.getText());
        txtKembali.setText(String.valueOf(bayar.subtract(total)));
    }//GEN-LAST:event_btnHitungKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TransaksiLayout().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TransaksiLayout.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnHitungKembali;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSimpanTransaksi;
    private javax.swing.JComboBox cmbKodeBarang;
    private javax.swing.JComboBox cmbNamaPelanggan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStock;
    private ziaskincare.komponen.Panel panel1;
    private javax.swing.JTable tabTrans;
    private javax.swing.JTextField txtDisc;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlahBayar;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNoTrans;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSubTot;
    private com.toedter.calendar.JDateChooser txtTanggalBeli;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}