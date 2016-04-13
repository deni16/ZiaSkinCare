/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author NFI-ACER
 */
public class TransaksiDetail {
    private Long id;
    private Integer noTransaksi;
    private BigDecimal total;
    private BigDecimal bayar;
    private BigDecimal kembali;
    private List<Transaksi> listTransaksi;

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getBayar() {
        return bayar;
    }

    public void setBayar(BigDecimal bayar) {
        this.bayar = bayar;
    }

    public BigDecimal getKembali() {
        return kembali;
    }

    public void setKembali(BigDecimal kembali) {
        this.kembali = kembali;
    }

    public List<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    
    
}
