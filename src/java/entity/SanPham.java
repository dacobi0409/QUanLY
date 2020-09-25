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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "SanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
    , @NamedQuery(name = "SanPham.findByMaSanPham", query = "SELECT s FROM SanPham s WHERE s.maSanPham = :maSanPham")
    , @NamedQuery(name = "SanPham.findByUrlAnh", query = "SELECT s FROM SanPham s WHERE s.urlAnh = :urlAnh")
    , @NamedQuery(name = "SanPham.findByTenSanPham", query = "SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham")
    , @NamedQuery(name = "SanPham.findByGiaGoc", query = "SELECT s FROM SanPham s WHERE s.giaGoc = :giaGoc")
    , @NamedQuery(name = "SanPham.findByKhuyenMai", query = "SELECT s FROM SanPham s WHERE s.khuyenMai = :khuyenMai")
    , @NamedQuery(name = "SanPham.findByMoTaNgan", query = "SELECT s FROM SanPham s WHERE s.moTaNgan = :moTaNgan")
    , @NamedQuery(name = "SanPham.findByMoTaChiTiet", query = "SELECT s FROM SanPham s WHERE s.moTaChiTiet = :moTaChiTiet")
    , @NamedQuery(name = "SanPham.findByNgayThem", query = "SELECT s FROM SanPham s WHERE s.ngayThem = :ngayThem")
    , @NamedQuery(name = "SanPham.findBySoLuong", query = "SELECT s FROM SanPham s WHERE s.soLuong = :soLuong")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSanPham")
    private Integer maSanPham;
    @Size(max = 200)
    @Column(name = "UrlAnh")
    private String urlAnh;
    @Size(max = 100)
    @Column(name = "TenSanPham")
    @NotEmpty(message = "Nhập tên sản phẩm")
    private String tenSanPham;
    @Column(name = "GiaGoc")
    @NotNull(message = "Nhập giá gốc")
    private Integer giaGoc;
    @Column(name = "KhuyenMai")
    @NotNull(message = "Nhập khuyến  mại")
    private Integer khuyenMai;
    @Size(max = 200)
    @Column(name = "MoTaNgan")
    @NotEmpty(message = "Nhập mô tả ngắn")
    private String moTaNgan;
    @Size(max = 1073741823)
    @Column(name = "MoTaChiTiet")
    private String moTaChiTiet;
    @Column(name = "NgayThem")
    @NotNull(message = "Nhập ngày thêm")
    @Temporal(TemporalType.DATE)
    private Date ngayThem;
    @Column(name = "SoLuong")
    @NotNull(message = "Nhập số lượng")
    private Integer soLuong;
    @JoinColumn(name = "MaDM", referencedColumnName = "MaDM")
    @ManyToOne
    private DanhMucSanPham maDM;
    @OneToMany(mappedBy = "maSanPham")
    private Collection<DonHangChitiet> donHangChitietCollection;

    public SanPham() {
    }

    public SanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(Integer giaGoc) {
        this.giaGoc = giaGoc;
    }

    public Integer getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(Integer khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public String getMoTaNgan() {
        return moTaNgan;
    }

    public void setMoTaNgan(String moTaNgan) {
        this.moTaNgan = moTaNgan;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public DanhMucSanPham getMaDM() {
        return maDM;
    }

    public void setMaDM(DanhMucSanPham maDM) {
        this.maDM = maDM;
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
        hash += (maSanPham != null ? maSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSanPham == null && other.maSanPham != null) || (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SanPham[ maSanPham=" + maSanPham + " ]";
    }
    
}
