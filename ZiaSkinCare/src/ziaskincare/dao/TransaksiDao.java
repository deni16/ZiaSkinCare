/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ziaskincare.config.DatabaseConnection;
import ziaskincare.entity.Transaksi;

/**
 *
 * @author Ai
 */
public class TransaksiDao implements BaseDao<Transaksi> {
    private Connection conn;

    public TransaksiDao() throws ClassNotFoundException, SQLException {
        DatabaseConnection dc = new DatabaseConnection();
        conn = dc.getConnection();
    }

    @Override
    public void save(Transaksi entity) {
        String query = "insert into transaksi "
                + "(no_transaksi, id_pelanggan, tanggal, id_barang, qty, total_harga) values (?,?,?,?,?,?);";
        PreparedStatement ps;
        try {
            java.sql.Date date = new Date(entity.getTanggal().getTime());
            ps = conn.prepareStatement(query);
            ps.setInt(1, entity.getNoTransaksi());
            ps.setLong(2, entity.getDataPelanggan().getId());
            ps.setDate(3, date);
            ps.setLong(4, entity.getDataBarang().getId());
            ps.setInt(5, entity.getQty());
            ps.setBigDecimal(6, entity.getTotalHarga());  
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Transaksi entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Transaksi entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transaksi getEntityById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaksi> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
