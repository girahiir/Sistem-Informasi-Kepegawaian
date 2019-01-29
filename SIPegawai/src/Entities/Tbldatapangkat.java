/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arsyadi Ahmad
 */
@Entity
@Table(name = "tbldatapangkat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldatapangkat.findAll", query = "SELECT t FROM Tbldatapangkat t"),
    @NamedQuery(name = "Tbldatapangkat.findByIdPangkat", query = "SELECT t FROM Tbldatapangkat t WHERE t.idPangkat = :idPangkat"),
    @NamedQuery(name = "Tbldatapangkat.findByNamaPangkat", query = "SELECT t FROM Tbldatapangkat t WHERE t.namaPangkat = :namaPangkat"),
    @NamedQuery(name = "Tbldatapangkat.findByGolongan", query = "SELECT t FROM Tbldatapangkat t WHERE t.golongan = :golongan"),
    @NamedQuery(name = "Tbldatapangkat.findByRuang", query = "SELECT t FROM Tbldatapangkat t WHERE t.ruang = :ruang")})
public class Tbldatapangkat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPangkat")
    private String idPangkat;
    @Column(name = "namaPangkat")
    private String namaPangkat;
    @Column(name = "golongan")
    private String golongan;
    @Column(name = "ruang")
    private String ruang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPangkat")
    private List<Tbldataindukpeg> tbldataindukpegList;

    public Tbldatapangkat() {
    }

    public Tbldatapangkat(String idPangkat) {
        this.idPangkat = idPangkat;
    }

    public String getIdPangkat() {
        return idPangkat;
    }

    public void setIdPangkat(String idPangkat) {
        this.idPangkat = idPangkat;
    }

    public String getNamaPangkat() {
        return namaPangkat;
    }

    public void setNamaPangkat(String namaPangkat) {
        this.namaPangkat = namaPangkat;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    @XmlTransient
    public List<Tbldataindukpeg> getTbldataindukpegList() {
        return tbldataindukpegList;
    }

    public void setTbldataindukpegList(List<Tbldataindukpeg> tbldataindukpegList) {
        this.tbldataindukpegList = tbldataindukpegList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPangkat != null ? idPangkat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldatapangkat)) {
            return false;
        }
        Tbldatapangkat other = (Tbldatapangkat) object;
        if ((this.idPangkat == null && other.idPangkat != null) || (this.idPangkat != null && !this.idPangkat.equals(other.idPangkat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldatapangkat[ idPangkat=" + idPangkat + " ]";
    }
    
}
