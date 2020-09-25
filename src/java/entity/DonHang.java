/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "DonHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonHang.findAll", query = "SELECT d FROM DonHang d")
    , @NamedQuery(name = "DonHang.findByMaDonHang", query = "SELECT d FROM DonHang d WHERE d.maDonHang = :maDonHang")
    , @NamedQuery(name = "DonHang.findByNgayDatHang", query = "SELECT d FROM DonHang d WHERE d.ngayDatHang = :ngayDatHang")})
public class DonHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDonHang")
    private Integer maDonHang;
    @Column(name = "NgayDatHang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDatHang;
    
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private KhachHang maKH;
    @OneToMany(mappedBy = "maDonHang")
    private Collection<DonHangChitiet> donHangChitietCollection;

    public DonHang() {
    }

    public DonHang(Integer maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Integer getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Integer maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public KhachHang getMaKH() {
        return maKH;
    }

    public void setMaKH(KhachHang maKH) {
        this.maKH = maKH;
    }

    @XmlTransient
    public Collection<DonHangChitiet> getDonHangChitietCollection() {
        return donHangChitietCollection;
    }

    public void setDonHangChitietCollection(Collection<DonHangChitiet> donHangChitietCollection) {
        this.donHangChitietCollection = donHangChitietCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDonHang != null ? maDonHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonHang)) {
            return false;
        }
        DonHang other = (DonHang) object;
        if ((this.maDonHang == null && other.maDonHang != null) || (this.maDonHang != null && !this.maDonHang.equals(other.maDonHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DonHang[ maDonHang=" + maDonHang + " ]";
    }

    public void setMaKHa(Integer makh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
