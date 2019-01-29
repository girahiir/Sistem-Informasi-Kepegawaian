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
@Table(name = "tbldatapensiun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldatapensiun.findAll", query = "SELECT t FROM Tbldatapensiun t"),
    @NamedQuery(name = "Tbldatapensiun.findByIdDataPensiun", query = "SELECT t FROM Tbldatapensiun t WHERE t.idDataPensiun = :idDataPensiun"),
    @NamedQuery(name = "Tbldatapensiun.findByNama", query = "SELECT t FROM Tbldatapensiun t WHERE t.nama = :nama"),
    @NamedQuery(name = "Tbldatapensiun.findByTglPengajuan", query = "SELECT t FROM Tbldatapensiun t WHERE t.tglPengajuan = :tglPengajuan"),
    @NamedQuery(name = "Tbldatapensiun.findByTglBerlaku", query = "SELECT t FROM Tbldatapensiun t WHERE t.tglBerlaku = :tglBerlaku")})
public class Tbldatapensiun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDataPensiun")
    private String idDataPensiun;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tglPengajuan")
    @Temporal(TemporalType.DATE)
    private Date tglPengajuan;
    @Column(name = "tglBerlaku")
    @Temporal(TemporalType.DATE)
    private Date tglBerlaku;
    @JoinColumn(name = "idPengajuPensiun", referencedColumnName = "idPengajuPensiun")
    @ManyToOne(optional = false)
    private Tblpengajupensiun idPengajuPensiun;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Tbldataindukpeg nip;

    public Tbldatapensiun() {
    }

    public Tbldatapensiun(String idDataPensiun) {
        this.idDataPensiun = idDataPensiun;
    }

    public String getIdDataPensiun() {
        return idDataPensiun;
    }

    public void setIdDataPensiun(String idDataPensiun) {
        this.idDataPensiun = idDataPensiun;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTglPengajuan() {
        return tglPengajuan;
    }

    public void setTglPengajuan(Date tglPengajuan) {
        this.tglPengajuan = tglPengajuan;
    }

    public Date getTglBerlaku() {
        return tglBerlaku;
    }

    public void setTglBerlaku(Date tglBerlaku) {
        this.tglBerlaku = tglBerlaku;
    }

    public Tblpengajupensiun getIdPengajuPensiun() {
        return idPengajuPensiun;
    }

    public void setIdPengajuPensiun(Tblpengajupensiun idPengajuPensiun) {
        this.idPengajuPensiun = idPengajuPensiun;
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
        hash += (idDataPensiun != null ? idDataPensiun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldatapensiun)) {
            return false;
        }
        Tbldatapensiun other = (Tbldatapensiun) object;
        if ((this.idDataPensiun == null && other.idDataPensiun != null) || (this.idDataPensiun != null && !this.idDataPensiun.equals(other.idDataPensiun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldatapensiun[ idDataPensiun=" + idDataPensiun + " ]";
    }
    
}
