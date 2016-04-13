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
import ziaskincare.entity.TransaksiDetail;

/**
 *
 * @author NFI-ACER
 */
public class TransaksiDetailDao implements BaseDao<TransaksiDetail> {
private Connection conn;

    public TransaksiDetailDao() throws ClassNotFoundException, SQLException {
        DatabaseConnection dc = new DatabaseConnection();
        conn = dc.getConnection();
    }
    
    @Override
    public void save(TransaksiDetail entity) {
        String query = "insert into transaksi_detil "
                + "(no_transaksi, total, bayar, kembali) values (?,?,?,?);";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, entity.getNoTransaksi());
            ps.setBigDecimal(2, entity.getTotal());
            ps.setBigDecimal(3, entity.getBayar());
            ps.setBigDecimal(4, entity.getKembali());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TransaksiDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TransaksiDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TransaksiDetail getEntityById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TransaksiDetail> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
