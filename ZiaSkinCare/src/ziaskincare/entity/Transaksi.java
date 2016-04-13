/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.entity;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Ai
 */
public class Transaksi {
    private Long id;
    private Integer noTransaksi;
    private DataPetugas dataPetugas;
    private DataPelanggan dataPelanggan;
    private DataBarang dataBarang;
    private BigDecimal totalHarga;
    private Integer qty;
    private Date tanggal;
    private Integer diskon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(Integer noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public DataPetugas getDataPetugas() {
        return dataPetugas;
    }

    public void setDataPetugas(DataPetugas dataPetugas) {
        this.dataPetugas = dataPetugas;
    }

    public DataBarang getDataBarang() {
        return dataBarang;
    }

    public void setDataBarang(DataBarang dataBarang) {
        this.dataBarang = dataBarang;
    }

    public BigDecimal getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigDecimal totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public DataPelanggan getDataPelanggan() {
        return dataPelanggan;
    }

    public void setDataPelanggan(DataPelanggan dataPelanggan) {
        this.dataPelanggan = dataPelanggan;
    }

    public Integer getDiskon() {
        return diskon;
    }

    public void setDiskon(Integer diskon) {
        this.diskon = diskon;
    }

    
}
