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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbldatapengajupangkat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldatapengajupangkat.findAll", query = "SELECT t FROM Tbldatapengajupangkat t"),
    @NamedQuery(name = "Tbldatapengajupangkat.findByIdPengajuPangkat", query = "SELECT t FROM Tbldatapengajupangkat t WHERE t.idPengajuPangkat = :idPengajuPangkat"),
    @NamedQuery(name = "Tbldatapengajupangkat.findByIdPangkatLama", query = "SELECT t FROM Tbldatapengajupangkat t WHERE t.idPangkatLama = :idPangkatLama"),
    @NamedQuery(name = "Tbldatapengajupangkat.findByIdPangkatBaru", query = "SELECT t FROM Tbldatapengajupangkat t WHERE t.idPangkatBaru = :idPangkatBaru"),
    @NamedQuery(name = "Tbldatapengajupangkat.findByStatus", query = "SELECT t FROM Tbldatapengajupangkat t WHERE t.status = :status")})
public class Tbldatapengajupangkat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPengajuPangkat")
    private String idPengajuPangkat;
    @Column(name = "idPangkatLama")
    private String idPangkatLama;
    @Column(name = "idPangkatBaru")
    private String idPangkatBaru;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Tbldataindukpeg nip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPengajuPangkat")
    private List<Tblterimanaikpangkat> tblterimanaikpangkatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPengajuPangkat")
    private List<Tbltolaknaikpangkat> tbltolaknaikpangkatList;

    public Tbldatapengajupangkat() {
    }

    public Tbldatapengajupangkat(String idPengajuPangkat) {
        this.idPengajuPangkat = idPengajuPangkat;
    }

    public String getIdPengajuPangkat() {
        return idPengajuPangkat;
    }

    public void setIdPengajuPangkat(String idPengajuPangkat) {
        this.idPengajuPangkat = idPengajuPangkat;
    }

    public String getIdPangkatLama() {
        return idPangkatLama;
    }

    public void setIdPangkatLama(String idPangkatLama) {
        this.idPangkatLama = idPangkatLama;
    }

    public String getIdPangkatBaru() {
        return idPangkatBaru;
    }

    public void setIdPangkatBaru(String idPangkatBaru) {
        this.idPangkatBaru = idPangkatBaru;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tbldataindukpeg getNip() {
        return nip;
    }

    public void setNip(Tbldataindukpeg nip) {
        this.nip = nip;
    }

    @XmlTransient
    public List<Tblterimanaikpangkat> getTblterimanaikpangkatList() {
        return tblterimanaikpangkatList;
    }

    public void setTblterimanaikpangkatList(List<Tblterimanaikpangkat> tblterimanaikpangkatList) {
        this.tblterimanaikpangkatList = tblterimanaikpangkatList;
    }

    @XmlTransient
    public List<Tbltolaknaikpangkat> getTbltolaknaikpangkatList() {
        return tbltolaknaikpangkatList;
    }

    public void setTbltolaknaikpangkatList(List<Tbltolaknaikpangkat> tbltolaknaikpangkatList) {
        this.tbltolaknaikpangkatList = tbltolaknaikpangkatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPengajuPangkat != null ? idPengajuPangkat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldatapengajupangkat)) {
            return false;
        }
        Tbldatapengajupangkat other = (Tbldatapengajupangkat) object;
        if ((this.idPengajuPangkat == null && other.idPengajuPangkat != null) || (this.idPengajuPangkat != null && !this.idPengajuPangkat.equals(other.idPengajuPangkat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldatapengajupangkat[ idPengajuPangkat=" + idPengajuPangkat + " ]";
    }
    
}
