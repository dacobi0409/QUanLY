/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "KhachHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k")
    , @NamedQuery(name = "KhachHang.findByMaKH", query = "SELECT k FROM KhachHang k WHERE k.maKH = :maKH")
    , @NamedQuery(name = "KhachHang.findByHoTenKH", query = "SELECT k FROM KhachHang k WHERE k.hoTenKH = :hoTenKH")
    , @NamedQuery(name = "KhachHang.findBySoDienThoaiKH", query = "SELECT k FROM KhachHang k WHERE k.soDienThoaiKH = :soDienThoaiKH")
    , @NamedQuery(name = "KhachHang.findByDiaChiKH", query = "SELECT k FROM KhachHang k WHERE k.diaChiKH = :diaChiKH")
    , @NamedQuery(name = "KhachHang.findByTaiKhoanKH", query = "SELECT k FROM KhachHang k WHERE k.taiKhoanKH = :taiKhoanKH")
    , @NamedQuery(name = "KhachHang.findByMatKhauKH", query = "SELECT k FROM KhachHang k WHERE k.matKhauKH = :matKhauKH")
    , @NamedQuery(name = "KhachHang.findBySoTienMua", query = "SELECT k FROM KhachHang k WHERE k.soTienMua = :soTienMua")
    , @NamedQuery(name = "KhachHang.findByTrangThaiKH", query = "SELECT k FROM KhachHang k WHERE k.trangThaiKH = :trangThaiKH")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Integer maKH;
    @Size(max = 50)
    @Column(name = "HoTenKH")
    @NotEmpty(message = "Nhập họ và tên!")
    private String hoTenKH;
    
    @Column(name = "SoDienThoaiKH")
    @NotNull(message = "Nhập số điện thoại")
    private Integer soDienThoaiKH;
    @Size(max = 200)
    
    @Column(name = "DiaChiKH")
    private String diaChiKH;
    @Size(max = 50)
    @Column(name = "TaiKhoanKH")
    @NotEmpty(message = "Nhập tên tài khoản")
    private String taiKhoanKH;
    @Size(max = 50)
    @Column(name = "MatKhauKH")
    @NotEmpty(message = "Nhập mật khẩu")
    private String matKhauKH;
    @Column(name = "SoTienMua")
    private Integer soTienMua;
    @Column(name = "TrangThaiKH")
    private Integer trangThaiKH;
    @OneToMany(mappedBy = "maKH")
    private Collection<DonHang> donHangCollection;
    @OneToMany(mappedBy = "maKH")
    private Collection<LienHe> lienHeCollection;

    public KhachHang() {
    }

    public KhachHang(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public Integer getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(Integer soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getTaiKhoanKH() {
        return taiKhoanKH;
    }

    public void setTaiKhoanKH(String taiKhoanKH) {
        this.taiKhoanKH = taiKhoanKH;
    }

    public String getMatKhauKH() {
        return matKhauKH;
    }

    public void setMatKhauKH(String matKhauKH) {
        this.matKhauKH = matKhauKH;
    }

    public Integer getSoTienMua() {
        return soTienMua;
    }

    public void setSoTienMua(Integer soTienMua) {
        this.soTienMua = soTienMua;
    }

    public Integer getTrangThaiKH() {
        return trangThaiKH;
    }

    public void setTrangThaiKH(Integer trangThaiKH) {
        this.trangThaiKH = trangThaiKH;
    }

    @XmlTransient
    public Collection<DonHang> getDonHangCollection() {
        return donHangCollection;
    }

    public void setDonHangCollection(Collection<DonHang> donHangCollection) {
        this.donHangCollection = donHangCollection;
    }

    @XmlTransient
    public Collection<LienHe> getLienHeCollection() {
        return lienHeCollection;
    }

    public void setLienHeCollection(Collection<LienHe> lienHeCollection) {
        this.lienHeCollection = lienHeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KhachHang[ maKH=" + maKH + " ]";
    }
    
}
