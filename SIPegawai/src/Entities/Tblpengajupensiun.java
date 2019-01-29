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
@Table(name = "tblpengajupensiun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblpengajupensiun.findAll", query = "SELECT t FROM Tblpengajupensiun t"),
    @NamedQuery(name = "Tblpengajupensiun.findByIdPengajuPensiun", query = "SELECT t FROM Tblpengajupensiun t WHERE t.idPengajuPensiun = :idPengajuPensiun"),
    @NamedQuery(name = "Tblpengajupensiun.findByStatus", query = "SELECT t FROM Tblpengajupensiun t WHERE t.status = :status")})
public class Tblpengajupensiun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPengajuPensiun")
    private String idPengajuPensiun;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Tbldataindukpeg nip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPengajuPensiun")
    private List<Tbldatapensiun> tbldatapensiunList;

    public Tblpengajupensiun() {
    }

    public Tblpengajupensiun(String idPengajuPensiun) {
        this.idPengajuPensiun = idPengajuPensiun;
    }

    public String getIdPengajuPensiun() {
        return idPengajuPensiun;
    }

    public void setIdPengajuPensiun(String idPengajuPensiun) {
        this.idPengajuPensiun = idPengajuPensiun;
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
    public List<Tbldatapensiun> getTbldatapensiunList() {
        return tbldatapensiunList;
    }

    public void setTbldatapensiunList(List<Tbldatapensiun> tbldatapensiunList) {
        this.tbldatapensiunList = tbldatapensiunList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPengajuPensiun != null ? idPengajuPensiun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblpengajupensiun)) {
            return false;
        }
        Tblpengajupensiun other = (Tblpengajupensiun) object;
        if ((this.idPengajuPensiun == null && other.idPengajuPensiun != null) || (this.idPengajuPensiun != null && !this.idPengajuPensiun.equals(other.idPengajuPensiun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tblpengajupensiun[ idPengajuPensiun=" + idPengajuPensiun + " ]";
    }
    
}
