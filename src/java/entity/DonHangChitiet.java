/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "DonHangChitiet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonHangChitiet.findAll", query = "SELECT d FROM DonHangChitiet d")
    , @NamedQuery(name = "DonHangChitiet.findByMaDHCT", query = "SELECT d FROM DonHangChitiet d WHERE d.maDHCT = :maDHCT")
    , @NamedQuery(name = "DonHangChitiet.findBySoluong", query = "SELECT d FROM DonHangChitiet d WHERE d.soluong = :soluong")
    , @NamedQuery(name = "DonHangChitiet.findByKhuyenMai", query = "SELECT d FROM DonHangChitiet d WHERE d.khuyenMai = :khuyenMai")})
public class DonHangChitiet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDHCT")
    private Integer maDHCT;
    @Column(name = "Soluong")
    private Integer soluong;
    @Column(name = "KhuyenMai")
    private Integer khuyenMai;
    @JoinColumn(name = "MaDonHang", referencedColumnName = "MaDonHang")
    @ManyToOne
    private DonHang maDonHang;
    @JoinColumn(name = "MaSanPham", referencedColumnName = "MaSanPham")
    @ManyToOne
    private SanPham maSanPham;

    public DonHangChitiet() {
    }

    public DonHangChitiet(Integer maDHCT) {
        this.maDHCT = maDHCT;
    }

    public Integer getMaDHCT() {
        return maDHCT;
    }

    public void setMaDHCT(Integer maDHCT) {
        this.maDHCT = maDHCT;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(Integer khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public DonHang getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(DonHang maDonHang) {
        this.maDonHang = maDonHang;
    }

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDHCT != null ? maDHCT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonHangChitiet)) {
            return false;
        }
        DonHangChitiet other = (DonHangChitiet) object;
        if ((this.maDHCT == null && other.maDHCT != null) || (this.maDHCT != null && !this.maDHCT.equals(other.maDHCT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DonHangChitiet[ maDHCT=" + maDHCT + " ]";
    }
    
}
