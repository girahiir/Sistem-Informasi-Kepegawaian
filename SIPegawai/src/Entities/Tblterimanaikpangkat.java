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
@Table(name = "tblterimanaikpangkat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblterimanaikpangkat.findAll", query = "SELECT t FROM Tblterimanaikpangkat t"),
    @NamedQuery(name = "Tblterimanaikpangkat.findByIdTerima", query = "SELECT t FROM Tblterimanaikpangkat t WHERE t.idTerima = :idTerima"),
    @NamedQuery(name = "Tblterimanaikpangkat.findByTglPengajuan", query = "SELECT t FROM Tblterimanaikpangkat t WHERE t.tglPengajuan = :tglPengajuan")})
public class Tblterimanaikpangkat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTerima")
    private String idTerima;
    @Column(name = "tgl_pengajuan")
    @Temporal(TemporalType.DATE)
    private Date tglPengajuan;
    @JoinColumn(name = "idPengajuPangkat", referencedColumnName = "idPengajuPangkat")
    @ManyToOne(optional = false)
    private Tbldatapengajupangkat idPengajuPangkat;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Tbldataindukpeg nip;
    @JoinColumn(name = "id_pangkatbaru", referencedColumnName = "idPangkat")
    @ManyToOne
    private Tbldataindukpeg idPangkatbaru;

    public Tblterimanaikpangkat() {
    }

    public Tblterimanaikpangkat(String idTerima) {
        this.idTerima = idTerima;
    }

    public String getIdTerima() {
        return idTerima;
    }

    public void setIdTerima(String idTerima) {
        this.idTerima = idTerima;
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

    public Tbldataindukpeg getIdPangkatbaru() {
        return idPangkatbaru;
    }

    public void setIdPangkatbaru(Tbldataindukpeg idPangkatbaru) {
        this.idPangkatbaru = idPangkatbaru;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerima != null ? idTerima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblterimanaikpangkat)) {
            return false;
        }
        Tblterimanaikpangkat other = (Tblterimanaikpangkat) object;
        if ((this.idTerima == null && other.idTerima != null) || (this.idTerima != null && !this.idTerima.equals(other.idTerima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tblterimanaikpangkat[ idTerima=" + idTerima + " ]";
    }
    
}
