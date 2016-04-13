/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ziaskincare.config.DatabaseConnection;
import ziaskincare.entity.Satuan;

/**
 *
 * @author Ai
 */
public class SatuanDao implements BaseDao<Satuan>{
    private Connection conn;
    public SatuanDao() throws ClassNotFoundException, SQLException{
        DatabaseConnection dc = new DatabaseConnection();
        conn = dc.getConnection();
    }

    @Override
    public void save(Satuan entity) {
        String query = "insert into satuan(nama)values(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,entity.getNama());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Satuan entity) {
        String query = "update satuan set nama = ? where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, entity.getNama());
            ps.setLong(2, entity.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         }

    @Override
    public void delete(Satuan entity) {
        String query = "delete from satuan where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public List<Satuan> getAllData() {
        List<Satuan> listSatuan = new ArrayList<>();
        String query = "select * from satuan";
        Statement stt;
        try {
            stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(query);
            Satuan satuan;
            while (rss.next()) {
            satuan = new Satuan();
            satuan.setId(rss.getLong(1));
            satuan.setNama(rss.getString(2));
            listSatuan.add(satuan);
        }
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listSatuan;
}
   @Override
    public Satuan getEntityById(Long id)  {
        Satuan satuan = new Satuan();
        String query = "select * from satuan where id = '" + id + "'";
        Statement stt;
        try {
            stt = conn.createStatement(); 
            ResultSet rss = stt.executeQuery(query);
            while (rss.next()) {
            satuan.setId(rss.getLong(1));
            satuan.setNama(rss.getString(2));
    }
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satuan;
    }
     
    public Satuan getEntityByNama(String nama) {
        Satuan satuan = new Satuan();
        String query = "select * from satuan where nama = '" + nama + "'";
        Statement stt;
        try {
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
            satuan.setId(rss.getLong(1));
            satuan.setNama(rss.getString(2));
    }
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return satuan;
    }
}

        
    
