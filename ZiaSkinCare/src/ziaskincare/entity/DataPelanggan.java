/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.entity;

import java.util.Date;

/**
 *
 * @author Ai
 */
public class DataPelanggan {
    private Long id;
    private int noMember;
    private String namaPelanggan;
    private Date tanggalMember;
    private String noTelp;
    private String alamat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoMember() {
        return noMember;
    }

    public void setNoMember(int noMember) {
        this.noMember = noMember;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Date getTanggalMember() {
        return tanggalMember;
    }

    public void setTanggalMember(Date tanggalMember) {
        this.tanggalMember = tanggalMember;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    

}