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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LongLD
 */
@Entity
@Table(name = "LienHe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LienHe.findAll", query = "SELECT l FROM LienHe l")
    , @NamedQuery(name = "LienHe.findByMaLienHe", query = "SELECT l FROM LienHe l WHERE l.maLienHe = :maLienHe")
    , @NamedQuery(name = "LienHe.findByNoiDung", query = "SELECT l FROM LienHe l WHERE l.noiDung = :noiDung")})
public class LienHe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaLienHe")
    private Integer maLienHe;
    @Size(max = 1073741823)
    @Column(name = "NoiDung")
    private String noiDung;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private KhachHang maKH;

    public LienHe() {
    }

    public LienHe(Integer maLienHe) {
        this.maLienHe = maLienHe;
    }

    public Integer getMaLienHe() {
        return maLienHe;
    }

    public void setMaLienHe(Integer maLienHe) {
        this.maLienHe = maLienHe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public KhachHang getMaKH() {
        return maKH;
    }

    public void setMaKH(KhachHang maKH) {
        this.maKH = maKH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLienHe != null ? maLienHe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LienHe)) {
            return false;
        }
        LienHe other = (LienHe) object;
        if ((this.maLienHe == null && other.maLienHe != null) || (this.maLienHe != null && !this.maLienHe.equals(other.maLienHe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LienHe[ maLienHe=" + maLienHe + " ]";
    }
    
}
