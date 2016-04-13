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
import ziaskincare.entity.Kategori;

/**
 *
 * @author Ai
 */
public class KategoriDao implements BaseDao<Kategori>{
    private Connection conn;
    
    public KategoriDao() throws ClassNotFoundException, SQLException{
        DatabaseConnection dc = new DatabaseConnection();
        conn=dc.getConnection();
    }

    @Override
    public void save(Kategori entity) {
        String query = "insert into kategori(nama, kode)values(?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCode());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Kategori entity) {
        String query = "update kategori set nama = ?, kode = ? where id = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCode());
            ps.setLong(3, entity.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Kategori entity) {
        String query = "delete from kategori where id = ?;";
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
    public Kategori getEntityById(Long id) {
        Kategori kategori = new Kategori();
        String query = "select * from kategori where id = '" + id + "'";
        Statement stt;
        try {
            stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
            kategori.setId(rss.getLong(1));
            kategori.setName(rss.getString(2));
            kategori.setCode(rss.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        
        
        }
        return kategori;
    }

    @Override
    public List<Kategori> getAllData() {
        List<Kategori> listKategori = new ArrayList<>();
        String query = "select * from kategori";
        Statement stt;
        try {
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        Kategori kategori;
        while (rss.next()) {
            kategori = new Kategori();
            kategori.setId(rss.getLong(1));
            kategori.setName(rss.getString(2));
            kategori.setCode(rss.getString(3));
            listKategori.add(kategori);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKategori;
    }

    public Kategori getEntityByKode(String kode) throws SQLException {
        Kategori kategori = new Kategori();;
        String query = "select * from kategori where kode = '" + kode + "'";
        Statement stt;
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
            kategori.setId(rss.getLong(1));
            kategori.setCode(rss.getString(2));
            kategori.setName(rss.getString(3));
        }
        return kategori;
    }

    public Kategori getEntityByName(String name) throws SQLException {
        Kategori kategori = new Kategori();;
        String query = "select * from kategori where kode = '" + name + "'";
        Statement stt;
        stt = conn.createStatement();
        ResultSet rss = stt.executeQuery(query);
        while (rss.next()) {
            kategori.setId(rss.getLong(1));
            kategori.setName(rss.getString(2));
            kategori.setCode(rss.getString(3));
        }

        return kategori;
    }
    
}
