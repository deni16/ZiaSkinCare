/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.dao;

import java.math.BigDecimal;
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
import ziaskincare.entity.DataBarang;

/**
 *
 * @author Ai
 */
public class DataBarangDao implements BaseDao<DataBarang>{
    private Connection conn;
    private KategoriDao kategoriDao;
    private SatuanDao satuanDao;
    
    public DataBarangDao() throws ClassNotFoundException, SQLException{
        DatabaseConnection dc = new DatabaseConnection();
        conn=dc.getConnection();  
        kategoriDao = new KategoriDao();
        satuanDao = new SatuanDao();
    }
    

    @Override
    //save=method
    //save(parameter namavariabelparameter)
    public void save(DataBarang entity) {
        try {
            String query ="insert into data_barang(id, kode, nama, harga_beli, harga_jual, kategori_id, satuan_id, stok, deskripsi)values(?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getKode());
            ps.setString(3, entity.getNama());
            ps.setBigDecimal(4, entity.getHargaBeli());
            ps.setBigDecimal(5, entity.getHargaJual());
            ps.setLong(6, entity.getKategori().getId());
            ps.setLong(7, entity.getSatuan().getId());
            ps.setInt(8, entity.getStok());
            ps.setString(9, entity.getDeskripsi());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    @Override
    public void update(DataBarang entity) {
        String query = "update data_barang set kode = ?, nama = ?, harga_beli = ?, harga_jual = ?, kategori_id = ?, satuan_id = ?, stok = ?, deskripsi = ? where id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, entity.getKode());
            ps.setString(2, entity.getNama());
            ps.setBigDecimal(3, entity.getHargaBeli());
            ps.setBigDecimal(4, entity.getHargaJual());
            ps.setLong(5, entity.getKategori().getId());
            ps.setLong(6, entity.getSatuan().getId());
            ps.setInt(7, entity.getStok());
            ps.setString(8, entity.getDeskripsi());
            ps.setLong(9, entity.getId());
            ps.execute();
        }catch (SQLException ex) {
            Logger.getLogger(DataBarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(DataBarang entity) {
        String query = "delete from data_barang where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public DataBarang getEntityById(Long id) {
        DataBarang dataBarang = new DataBarang ();
        String query = "select * from data_barang where id = '" + id + "'";
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rss = stmt.executeQuery(query);
        while (rss.next()) {
            dataBarang.setId(rss.getLong(1));
            dataBarang.setKode(rss.getString(2));
            dataBarang.setNama(rss.getString(3));
            dataBarang.setHargaBeli(rss.getBigDecimal(4));
            dataBarang.setHargaJual(rss.getBigDecimal(5));
            dataBarang.setKategori(kategoriDao.getEntityById(rss.getLong(6)));
            dataBarang.setSatuan(satuanDao.getEntityById(rss.getLong(7)));
            dataBarang.setDeskripsi(rss.getString(8));
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataBarangDao.class.getName()).log(Level.SEVERE, null, ex);
        
        
        }
        return dataBarang;
         
    }
    public DataBarang getEntityByNama(String nama) throws SQLException{
        DataBarang dataBarang = new DataBarang ();
        String query = "select * from data_barang where nama = '" + nama + "'";
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rss = stmt.executeQuery(query);
        while (rss.next()) {
            dataBarang.setId(rss.getLong(1));
            dataBarang.setKode(rss.getString(2));
            dataBarang.setNama(rss.getString(3));
            dataBarang.setHargaBeli(rss.getBigDecimal(4));
            dataBarang.setHargaJual(rss.getBigDecimal(5));
            dataBarang.setKategori(kategoriDao.getEntityById(rss.getLong(6)));
            dataBarang.setSatuan(satuanDao.getEntityById(rss.getLong(7)));
            dataBarang.setDeskripsi(rss.getString(8));
        }
        
        return dataBarang;
    }
    
    public DataBarang getEntityByKode(String kode) throws SQLException{
        DataBarang dataBarang = new DataBarang ();
        String query = "select * from data_barang where kode = '" + kode + "'";
        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rss = stmt.executeQuery(query);
        while (rss.next()) {
            dataBarang.setId(rss.getLong(1));
            dataBarang.setKode(rss.getString(2));
            dataBarang.setNama(rss.getString(3));
            dataBarang.setHargaBeli(rss.getBigDecimal(4));
            dataBarang.setHargaJual(rss.getBigDecimal(5));
            dataBarang.setKategori(kategoriDao.getEntityById(rss.getLong(6)));
            dataBarang.setSatuan(satuanDao.getEntityById(rss.getLong(7)));
            dataBarang.setStok(rss.getInt(8));
            dataBarang.setDeskripsi(rss.getString(9));
        }
        
        return dataBarang;
    }
    

    @Override
    public List<DataBarang> getAllData() {
         List<DataBarang> listDataBarang = new ArrayList<>();
        String query = "select * from data_barang order by kode";
        Statement stt;
        try {
            stt = conn.createStatement();
        
        ResultSet rss = stt.executeQuery(query);
        DataBarang dataBarang;
        while (rss.next()) {
            dataBarang = new DataBarang();
            dataBarang.setId(rss.getLong(1));
            dataBarang.setKode(rss.getString(2));
            dataBarang.setNama(rss.getString(3));
            dataBarang.setHargaBeli(rss.getBigDecimal(4));
            dataBarang.setHargaJual(rss.getBigDecimal(5));
            dataBarang.setKategori(kategoriDao.getEntityById(rss.getLong(6)));
            dataBarang.setSatuan(satuanDao.getEntityById(rss.getLong(7)));
            dataBarang.setStok(rss.getInt(8));
            dataBarang.setDeskripsi(rss.getString(9));
            listDataBarang.add(dataBarang);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DataBarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDataBarang;
    }

    public DataBarang getEntityById(int noId) throws SQLException {
        DataBarang dataBarang = new DataBarang ();
        String query = "select * from data_barang where kode = '" + noId + "'";
        Statement stmt;
            stmt = conn.createStatement();
            ResultSet rss = stmt.executeQuery(query);
        while (rss.next()) {
            dataBarang.setId(rss.getLong(1));
            dataBarang.setKode(rss.getString(2));
            dataBarang.setNama(rss.getString(3));
            dataBarang.setHargaBeli(rss.getBigDecimal(4));
            dataBarang.setHargaJual(rss.getBigDecimal(5));
            dataBarang.setKategori(kategoriDao.getEntityById(rss.getLong(6)));
            dataBarang.setSatuan(satuanDao.getEntityById(rss.getLong(7)));
            dataBarang.setStok(rss.getInt(8));
            dataBarang.setDeskripsi(rss.getString(9));
        }
        
        return dataBarang;
    }

    }

