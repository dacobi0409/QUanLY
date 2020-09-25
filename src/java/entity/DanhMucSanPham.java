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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "DanhMucSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhMucSanPham.findAll", query = "SELECT d FROM DanhMucSanPham d")
    , @NamedQuery(name = "DanhMucSanPham.findByMaDM", query = "SELECT d FROM DanhMucSanPham d WHERE d.maDM = :maDM")
    , @NamedQuery(name = "DanhMucSanPham.findByTenDM", query = "SELECT d FROM DanhMucSanPham d WHERE d.tenDM = :tenDM")})
public class DanhMucSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDM")
    private Integer maDM;
    @Size(max = 50)
    @Column(name = "TenDM")
    private String tenDM;
    @OneToMany(mappedBy = "maDM")
    private Collection<SanPham> sanPhamCollection;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(Integer maDM) {
        this.maDM = maDM;
    }

    public Integer getMaDM() {
        return maDM;
    }

    public void setMaDM(Integer maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    @XmlTransient
    public Collection<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Collection<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDM != null ? maDM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhMucSanPham)) {
            return false;
        }
        DanhMucSanPham other = (DanhMucSanPham) object;
        if ((this.maDM == null && other.maDM != null) || (this.maDM != null && !this.maDM.equals(other.maDM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DanhMucSanPham[ maDM=" + maDM + " ]";
    }
    
}
