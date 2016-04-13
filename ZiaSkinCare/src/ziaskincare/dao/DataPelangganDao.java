/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ziaskincare.config.DatabaseConnection;
import ziaskincare.entity.DataPelanggan;

/**
 *
 * @author Ai
 */
public class DataPelangganDao implements BaseDao<DataPelanggan> {
    private Connection conn;
    
    public DataPelangganDao() throws ClassNotFoundException, SQLException{
        DatabaseConnection dc = new DatabaseConnection();
        conn = dc.getConnection();
    
    }

    @Override
    public void save(DataPelanggan entity) {
        String query = "insert into data_pelanggan (id, no_member, nama_pelanggan, tgl_member, no_telp,  alamat) values (?,?,?,?,?,?);";
        PreparedStatement ps;
        try {
            java.sql.Date date = new Date(entity.getTanggalMember().getTime());
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getId());
            ps.setInt(2, entity.getNoMember());
            ps.setString(3, entity.getNamaPelanggan());
            ps.setDate(4, date);
            ps.setString(5, entity.getNoTelp());
            ps.setString(6, entity.getAlamat());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataPelangganDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(DataPelanggan entity) {
        String query = "update data_pelanggan set no_member = ?, nama_pelanggan = ?, tgl_member = ?, no_telp = ?, alamat = ? where id = ?;";
        PreparedStatement ps;
        java.sql.Date date = new Date(entity.getTanggalMember().getTime());
        try {
            ps = conn.prepareStatement(query);
            ps.setInt (1, entity.getNoMember());
            ps.setString(2, entity.getNamaPelanggan());
            ps.setDate(3, (date) ); 
            ps.setString (4, entity.getNoTelp());
            ps.setString (5, entity.getAlamat());
            ps.setLong(6, entity.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SatuanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(DataPelanggan entity) {
        String query = "delete from data_pelanggan where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataPelangganDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public DataPelanggan getEntityById(Long id) {
        DataPelanggan datapelanggan = new DataPelanggan();
        String query = "select * from data_pelanggan where id = " + id ;
        Statement stt;
        try {
            stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
//            datapelanggan.setId(rss.getLong(1));
//            datapelanggan.setNamaPelanggan(rss.getString(2));
//            datapelanggan.setAlamat(rss.getString(3));
//            datapelanggan.setNoMember(rss.getInt(4));
//            datapelanggan.setNoTelp(rss.getString(5));
//            datapelanggan.setTanggalMember(rss.getDate(6)); 
            
                        datapelanggan.setId(rss.getLong(1));
            datapelanggan.setNoMember(rss.getInt(2));
            datapelanggan.setNamaPelanggan(rss.getString(3));
            datapelanggan.setTanggalMember(rss.getDate(4));
            datapelanggan.setNoTelp(rss.getString(5));
            datapelanggan.setAlamat(rss.getString(6));
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataPelangganDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datapelanggan;  
    }

    public DataPelanggan getEntityByNama(String nama) throws SQLException{
        DataPelanggan datapelanggan = new DataPelanggan();
        String query = "select * from data_pelanggan where nama_pelanggan = '" + nama +"'";
        Statement stt;
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        while (rss.next()){
            datapelanggan = new DataPelanggan();
//            datapelanggan.setId(rss.getLong(1));
//            datapelanggan.setNamaPelanggan(rss.getString(2));
//            datapelanggan.setNoMember(rss.getInt(3));
//            datapelanggan.setNoTelp(rss.getString(4));
//            datapelanggan.setAlamat(rss.getString(5));
//            datapelanggan.setTanggalMember(rss.getDate(6));
            
            datapelanggan.setId(rss.getLong(1));
            datapelanggan.setNoMember(rss.getInt(2));
            datapelanggan.setNamaPelanggan(rss.getString(3));
            datapelanggan.setTanggalMember(rss.getDate(4));
            datapelanggan.setNoTelp(rss.getString(5));
            datapelanggan.setAlamat(rss.getString(6));
        }
        return datapelanggan;
    }
    
    public DataPelanggan getEntityByNoMember(int noMember) throws SQLException{
        DataPelanggan datapelanggan = new DataPelanggan();
        String query = "select * from data_pelanggan where no_member = '" + noMember +"'";
        Statement stt;
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        while (rss.next()){
            datapelanggan = new DataPelanggan();
//            datapelanggan.setId(rss.getLong(1));
//            datapelanggan.setNoMember(rss.getInt(2));
//            datapelanggan.setNamaPelanggan(rss.getString(3));
//            datapelanggan.setTanggalMember(rss.getDate(4));
//            datapelanggan.setNoTelp(rss.getString(5));
//            datapelanggan.setAlamat(rss.getString(6));
//          Sesuaikan aja
            
            datapelanggan.setId(rss.getLong(1));
            datapelanggan.setNoMember(rss.getInt(2));
            datapelanggan.setNamaPelanggan(rss.getString(3));
            datapelanggan.setTanggalMember(rss.getDate(4));
            datapelanggan.setNoTelp(rss.getString(5));
            datapelanggan.setAlamat(rss.getString(6));
            
            
        }
        return datapelanggan;
    
    }
    @Override
    public List<DataPelanggan> getAllData(){
        List<DataPelanggan> listDataPelanggan = new ArrayList<>();
        String query = "select * from data_pelanggan order by nama_pelanggan";
        Statement stt;
        try {
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        DataPelanggan datapelanggan;
        while (rss.next()) {
            datapelanggan = new DataPelanggan();
            datapelanggan.setId(rss.getLong(1));
            datapelanggan.setNoMember(rss.getInt(2));
            datapelanggan.setNamaPelanggan(rss.getString(3));
            datapelanggan.setTanggalMember(rss.getDate(4));
            datapelanggan.setNoTelp(rss.getString(5));
            datapelanggan.setAlamat(rss.getString(6));
            listDataPelanggan.add(datapelanggan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDataPelanggan;
    }
}
