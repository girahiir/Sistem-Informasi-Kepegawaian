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
@Table(name = "tbltolaknaikpangkat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbltolaknaikpangkat.findAll", query = "SELECT t FROM Tbltolaknaikpangkat t"),
    @NamedQuery(name = "Tbltolaknaikpangkat.findByIdTolak", query = "SELECT t FROM Tbltolaknaikpangkat t WHERE t.idTolak = :idTolak"),
    @NamedQuery(name = "Tbltolaknaikpangkat.findByKet", query = "SELECT t FROM Tbltolaknaikpangkat t WHERE t.ket = :ket"),
    @NamedQuery(name = "Tbltolaknaikpangkat.findByTglPengajuan", query = "SELECT t FROM Tbltolaknaikpangkat t WHERE t.tglPengajuan = :tglPengajuan")})
public class Tbltolaknaikpangkat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTolak")
    private String idTolak;
    @Column(name = "Ket")
    private String ket;
    @Column(name = "tgl_Pengajuan")
    @Temporal(TemporalType.DATE)
    private Date tglPengajuan;
    @JoinColumn(name = "idPengajuPangkat", referencedColumnName = "idPengajuPangkat")
    @ManyToOne(optional = false)
    private Tbldatapengajupangkat idPengajuPangkat;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Tbldataindukpeg nip;

    public Tbltolaknaikpangkat() {
    }

    public Tbltolaknaikpangkat(String idTolak) {
        this.idTolak = idTolak;
    }

    public String getIdTolak() {
        return idTolak;
    }

    public void setIdTolak(String idTolak) {
        this.idTolak = idTolak;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Date getTglPengajuan() {
        return tglPengajuan;
    }

    public void setTglPengajuan(Date tglPengajuan) {
        this.tglPengajuan = tglPengajuan;
    }

    public Tbldatapengajupangkat getIdPengajuPangkat() {
        return idPengajuPangkat;
    }

    public void setIdPengajuPangkat(Tbldatapengajupangkat idPengajuPangkat) {
        this.idPengajuPangkat = idPengajuPangkat;
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
        hash += (idTolak != null ? idTolak.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbltolaknaikpangkat)) {
            return false;
        }
        Tbltolaknaikpangkat other = (Tbltolaknaikpangkat) object;
        if ((this.idTolak == null && other.idTolak != null) || (this.idTolak != null && !this.idTolak.equals(other.idTolak))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbltolaknaikpangkat[ idTolak=" + idTolak + " ]";
    }
    
}
