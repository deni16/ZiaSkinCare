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
import ziaskincare.entity.DataPetugas;

/**
 *
 * @author Ai
 */
public class DataPetugasDao implements BaseDao<DataPetugas> {

    private Connection conn;

    public DataPetugasDao() throws ClassNotFoundException, SQLException {
        DatabaseConnection dc = new DatabaseConnection();
        conn = dc.getConnection();

    }

    public DataPetugas getDataPetugasByNamaAndPassword(String user, String password) {
        DataPetugas dataPetugas = new DataPetugas();
        String query = "select * from data_petugas where user = '" + user + "' AND password = '" + password + "'";
        Statement stt;
        try {
            stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(query);
           if (rss.next()) {
                dataPetugas.setId(rss.getLong(1));
                dataPetugas.setLevel(rss.getInt(2));
                dataPetugas.setUser(rss.getString(3));
                dataPetugas.setNama(rss.getString(4));
                dataPetugas.setAlamat(rss.getString(5));
                dataPetugas.setNoTelp(rss.getString(6));
                dataPetugas.setPassword(rss.getString(7));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataPetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataPetugas;
    }

    @Override
    public void save(DataPetugas entity) {
        String query = "insert into data_petugas(nama, level, user, no_telp, alamat, password)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(query);
//            ps.setLong(1, entity.getId());
            ps.setString(1, entity.getNama());
            ps.setInt(2, entity.getLevel());
            ps.setString(3, entity.getUser());
            ps.setString(4, entity.getNoTelp());
            ps.setString(5, entity.getAlamat());
            ps.setString(6, entity.getPassword());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataPetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DataPetugas entity) {
        String query = "update data_petugas set level = ?, user = ?, nama = ?, alamat = ?, no_telp = ?, password = ? where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, entity.getNama());
            ps.setString(2, entity.getAlamat());
            ps.setLong(3, entity.getId());
            ps.setString(4, entity.getUser());
            ps.setInt(5, entity.getLevel());
            ps.setString(6, entity.getNoTelp());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(DataPetugas entity) {
        String query = "delete from data_petugas where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getId());
        ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DataPetugas getEntityById(Long id) {
        DataPetugas dataPetugas = new DataPetugas();
        String query = "select * from data_petugas where id = '" + id + "'";
        Statement stt;
        try {
            stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
            dataPetugas.setId(rss.getLong(1));
            dataPetugas.setNama(rss.getString(3));
            dataPetugas.setLevel(rss.getInt(2));
            dataPetugas.setUser(rss.getString(4));
            dataPetugas.setNoTelp(rss.getString(5));
            dataPetugas.setAlamat(rss.getString(6));
            dataPetugas.setPassword(rss.getString(7));
        }
    }   catch (SQLException ex) {
            Logger.getLogger(DataPetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataPetugas;
    }

    @Override
    public List<DataPetugas> getAllData() {
       List<DataPetugas>listDataPetugas = new ArrayList<>();
       String query = "select * from data_petugas";
       Statement stt;
        try {
            stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(query);
            DataPetugas dataPetugas;
            while (rss.next()){
                dataPetugas = new DataPetugas ();
                dataPetugas.setId(rss.getLong(1));
                dataPetugas.setNama(rss.getString(2));
                dataPetugas.setUser(rss.getString(3));
                dataPetugas.setLevel(rss.getInt(4));
                dataPetugas.setNoTelp(rss.getString(5));
                dataPetugas.setAlamat(rss.getString(6));
                dataPetugas.setPassword(rss.getString(7));
                listDataPetugas.add(dataPetugas);
            }
            } catch (SQLException ex) {
            Logger.getLogger(DataPetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDataPetugas;
    }

    public DataPetugas getEntityByNama(String nama) throws SQLException {
        DataPetugas dataPetugas = new DataPetugas();
        String query = "select * from data_petugas where nama = '" + nama + "'";
        Statement stt;
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
            dataPetugas.setId(rss.getLong(1));
            dataPetugas.setNama(rss.getString(2));
            dataPetugas.setUser(rss.getString(3));
            dataPetugas.setLevel(rss.getInt(4));
            dataPetugas.setNoTelp(rss.getString(5));
            dataPetugas.setAlamat(rss.getString(6));
                    
    }   return dataPetugas;
    }
}

