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
@Table(name = "tbldatakeluarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldatakeluarga.findAll", query = "SELECT t FROM Tbldatakeluarga t"),
    @NamedQuery(name = "Tbldatakeluarga.findByIdDk", query = "SELECT t FROM Tbldatakeluarga t WHERE t.idDk = :idDk"),
    @NamedQuery(name = "Tbldatakeluarga.findByNamaAyah", query = "SELECT t FROM Tbldatakeluarga t WHERE t.namaAyah = :namaAyah"),
    @NamedQuery(name = "Tbldatakeluarga.findByNamaIbu", query = "SELECT t FROM Tbldatakeluarga t WHERE t.namaIbu = :namaIbu"),
    @NamedQuery(name = "Tbldatakeluarga.findByNamaIstri", query = "SELECT t FROM Tbldatakeluarga t WHERE t.namaIstri = :namaIstri"),
    @NamedQuery(name = "Tbldatakeluarga.findByNamaSuami", query = "SELECT t FROM Tbldatakeluarga t WHERE t.namaSuami = :namaSuami"),
    @NamedQuery(name = "Tbldatakeluarga.findByJumlahAnak", query = "SELECT t FROM Tbldatakeluarga t WHERE t.jumlahAnak = :jumlahAnak"),
    @NamedQuery(name = "Tbldatakeluarga.findByPekerjaanSuami", query = "SELECT t FROM Tbldatakeluarga t WHERE t.pekerjaanSuami = :pekerjaanSuami"),
    @NamedQuery(name = "Tbldatakeluarga.findByPekerjaanIstri", query = "SELECT t FROM Tbldatakeluarga t WHERE t.pekerjaanIstri = :pekerjaanIstri"),
    @NamedQuery(name = "Tbldatakeluarga.findByPekerjaanAnak", query = "SELECT t FROM Tbldatakeluarga t WHERE t.pekerjaanAnak = :pekerjaanAnak")})
public class Tbldatakeluarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDk")
    private String idDk;
    @Column(name = "namaAyah")
    private String namaAyah;
    @Column(name = "namaIbu")
    private String namaIbu;
    @Column(name = "namaIstri")
    private String namaIstri;
    @Column(name = "namaSuami")
    private String namaSuami;
    @Column(name = "jumlahAnak")
    private Integer jumlahAnak;
    @Column(name = "pekerjaanSuami")
    private String pekerjaanSuami;
    @Column(name = "pekerjaanIstri")
    private String pekerjaanIstri;
    @Column(name = "pekerjaanAnak")
    private String pekerjaanAnak;
    @JoinColumn(name = "NIP", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Tbldataindukpeg nip;

    public Tbldatakeluarga() {
    }

    public Tbldatakeluarga(String idDk) {
        this.idDk = idDk;
    }

    public String getIdDk() {
        return idDk;
    }

    public void setIdDk(String idDk) {
        this.idDk = idDk;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getNamaIstri() {
        return namaIstri;
    }

    public void setNamaIstri(String namaIstri) {
        this.namaIstri = namaIstri;
    }

    public String getNamaSuami() {
        return namaSuami;
    }

    public void setNamaSuami(String namaSuami) {
        this.namaSuami = namaSuami;
    }

    public Integer getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(Integer jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public String getPekerjaanSuami() {
        return pekerjaanSuami;
    }

    public void setPekerjaanSuami(String pekerjaanSuami) {
        this.pekerjaanSuami = pekerjaanSuami;
    }

    public String getPekerjaanIstri() {
        return pekerjaanIstri;
    }

    public void setPekerjaanIstri(String pekerjaanIstri) {
        this.pekerjaanIstri = pekerjaanIstri;
    }

    public String getPekerjaanAnak() {
        return pekerjaanAnak;
    }

    public void setPekerjaanAnak(String pekerjaanAnak) {
        this.pekerjaanAnak = pekerjaanAnak;
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
        hash += (idDk != null ? idDk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldatakeluarga)) {
            return false;
        }
        Tbldatakeluarga other = (Tbldatakeluarga) object;
        if ((this.idDk == null && other.idDk != null) || (this.idDk != null && !this.idDk.equals(other.idDk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldatakeluarga[ idDk=" + idDk + " ]";
    }
    
}
