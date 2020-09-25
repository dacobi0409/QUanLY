

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 10)
    
    @Column(name = "TaiKhoan")
    @NotEmpty(message = "Empty")
    private String taiKhoan;
    @Size(max = 50)
    
    @Column(name = "MatKhau")
    @NotEmpty(message = "Empty")
    private String matKhau;
    @Size(max = 50)
    @Column(name = "HoTen")
    @NotEmpty(message = "Empty")
    private String hoTen;
    @Column(name = "GioiTinh")    
    private Integer gioiTinh;
    
    @Column(name = "NgaySinh")
    @NotNull(message = "Empty")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    @NotEmpty(message = "Empty")
    private String email;
    @Size(max = 200)
    
    @Column(name = "DiaChi")
    @NotEmpty(message = "Empty")
    private String diaChi;
    @Size(max = 20)
    
    @NotEmpty(message = "Empty")
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Size(max = 200)
    @Column(name = "UrlAnhUser")
    private String urlAnhUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PhanQuyen")
    private int phanQuyen;
    @Column(name = "TrangThaiUser")
    private Integer trangThaiUser;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, int phanQuyen) {
        this.id = id;
        this.phanQuyen = phanQuyen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getUrlAnhUser() {
        return urlAnhUser;
    }

    public void setUrlAnhUser(String urlAnhUser) {
        this.urlAnhUser = urlAnhUser;
    }

    public int getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(int phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public Integer getTrangThaiUser() {
        return trangThaiUser;
    }

    public void setTrangThaiUser(Integer trangThaiUser) {
        this.trangThaiUser = trangThaiUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ id=" + id + " ]";
    }
    
}

