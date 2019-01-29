/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arsyadi Ahmad
 */
@Entity
@Table(name = "tbldatariwayatpend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldatariwayatpend.findAll", query = "SELECT t FROM Tbldatariwayatpend t"),
    @NamedQuery(name = "Tbldatariwayatpend.findByIdRp", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.idRp = :idRp"),
    @NamedQuery(name = "Tbldatariwayatpend.findByTingkatPendidikan", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.tingkatPendidikan = :tingkatPendidikan"),
    @NamedQuery(name = "Tbldatariwayatpend.findByTempatPendidikan", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.tempatPendidikan = :tempatPendidikan"),
    @NamedQuery(name = "Tbldatariwayatpend.findByJurusan", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.jurusan = :jurusan"),
    @NamedQuery(name = "Tbldatariwayatpend.findByTglIjazah", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.tglIjazah = :tglIjazah"),
    @NamedQuery(name = "Tbldatariwayatpend.findByThnMasuk", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.thnMasuk = :thnMasuk"),
    @NamedQuery(name = "Tbldatariwayatpend.findByThnLulus", query = "SELECT t FROM Tbldatariwayatpend t WHERE t.thnLulus = :thnLulus")})
public class Tbldatariwayatpend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRp")
    private String idRp;
    @Column(name = "tingkatPendidikan")
    private String tingkatPendidikan;
    @Column(name = "tempatPendidikan")
    private String tempatPendidikan;
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "tglIjazah")
    @Temporal(TemporalType.DATE)
    private Date tglIjazah;
    @Column(name = "thnMasuk")
    private Integer thnMasuk;
    @Column(name = "thnLulus")
    private Integer thnLulus;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Tbldataindukpeg nip;

    public Tbldatariwayatpend() {
    }

    public Tbldatariwayatpend(String idRp) {
        this.idRp = idRp;
    }

    public String getIdRp() {
        return idRp;
    }

    public void setIdRp(String idRp) {
        this.idRp = idRp;
    }

    public String getTingkatPendidikan() {
        return tingkatPendidikan;
    }

    public void setTingkatPendidikan(String tingkatPendidikan) {
        this.tingkatPendidikan = tingkatPendidikan;
    }

    public String getTempatPendidikan() {
        return tempatPendidikan;
    }

    public void setTempatPendidikan(String tempatPendidikan) {
        this.tempatPendidikan = tempatPendidikan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Date getTglIjazah() {
        return tglIjazah;
    }

    public void setTglIjazah(Date tglIjazah) {
        this.tglIjazah = tglIjazah;
    }

    public Integer getThnMasuk() {
        return thnMasuk;
    }

    public void setThnMasuk(Integer thnMasuk) {
        this.thnMasuk = thnMasuk;
    }

    public Integer getThnLulus() {
        return thnLulus;
    }

    public void setThnLulus(Integer thnLulus) {
        this.thnLulus = thnLulus;
    }

    public Tbldataindukpeg getNip() {
        return nip;
    }

    public void setNip(Tbldataindukpeg nip) {
        this.nip = nip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRp != null ? idRp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldatariwayatpend)) {
            return false;
        }
        Tbldatariwayatpend other = (Tbldatariwayatpend) object;
        if ((this.idRp == null && other.idRp != null) || (this.idRp != null && !this.idRp.equals(other.idRp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldatariwayatpend[ idRp=" + idRp + " ]";
    }
    
}
