/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arsyadi Ahmad
 */
@Entity
@Table(name = "tbldatauser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldatauser.findAll", query = "SELECT t FROM Tbldatauser t"),
    @NamedQuery(name = "Tbldatauser.findByIdUser", query = "SELECT t FROM Tbldatauser t WHERE t.idUser = :idUser"),
    @NamedQuery(name = "Tbldatauser.findByPassword", query = "SELECT t FROM Tbldatauser t WHERE t.password = :password"),
    @NamedQuery(name = "Tbldatauser.findByType", query = "SELECT t FROM Tbldatauser t WHERE t.type = :type"),
    @NamedQuery(name = "Tbldatauser.findByStatus", query = "SELECT t FROM Tbldatauser t WHERE t.status = :status")})
public class Tbldatauser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUser")
    private String idUser;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Tbldataindukpeg nip;

    public Tbldatauser() {
    }

    public Tbldatauser(String idUser) {
        this.idUser = idUser;
    }

    public Tbldatauser(String idUser, String status) {
        this.idUser = idUser;
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldatauser)) {
            return false;
        }
        Tbldatauser other = (Tbldatauser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldatauser[ idUser=" + idUser + " ]";
    }
    
}
