/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arsyadi Ahmad
 */
@Entity
@Table(name = "tbldataindukpeg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldataindukpeg.findAll", query = "SELECT t FROM Tbldataindukpeg t"),
    @NamedQuery(name = "Tbldataindukpeg.findByNip", query = "SELECT t FROM Tbldataindukpeg t WHERE t.nip = :nip"),
    @NamedQuery(name = "Tbldataindukpeg.findByNama", query = "SELECT t FROM Tbldataindukpeg t WHERE t.nama = :nama"),
    @NamedQuery(name = "Tbldataindukpeg.findByJenisKelamin", query = "SELECT t FROM Tbldataindukpeg t WHERE t.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Tbldataindukpeg.findByStatus", query = "SELECT t FROM Tbldataindukpeg t WHERE t.status = :status"),
    @NamedQuery(name = "Tbldataindukpeg.findByGolDarah", query = "SELECT t FROM Tbldataindukpeg t WHERE t.golDarah = :golDarah"),
    @NamedQuery(name = "Tbldataindukpeg.findByGelarDepan", query = "SELECT t FROM Tbldataindukpeg t WHERE t.gelarDepan = :gelarDepan"),
    @NamedQuery(name = "Tbldataindukpeg.findByGelarBelakang", query = "SELECT t FROM Tbldataindukpeg t WHERE t.gelarBelakang = :gelarBelakang"),
    @NamedQuery(name = "Tbldataindukpeg.findByAgama", query = "SELECT t FROM Tbldataindukpeg t WHERE t.agama = :agama"),
    @NamedQuery(name = "Tbldataindukpeg.findByTempatLahir", query = "SELECT t FROM Tbldataindukpeg t WHERE t.tempatLahir = :tempatLahir"),
    @NamedQuery(name = "Tbldataindukpeg.findByTglLahir", query = "SELECT t FROM Tbldataindukpeg t WHERE t.tglLahir = :tglLahir"),
    @NamedQuery(name = "Tbldataindukpeg.findByNoKtp", query = "SELECT t FROM Tbldataindukpeg t WHERE t.noKtp = :noKtp"),
    @NamedQuery(name = "Tbldataindukpeg.findByAlamat", query = "SELECT t FROM Tbldataindukpeg t WHERE t.alamat = :alamat"),
    @NamedQuery(name = "Tbldataindukpeg.findByTelRumah", query = "SELECT t FROM Tbldataindukpeg t WHERE t.telRumah = :telRumah"),
    @NamedQuery(name = "Tbldataindukpeg.findByNoPonsel", query = "SELECT t FROM Tbldataindukpeg t WHERE t.noPonsel = :noPonsel"),
    @NamedQuery(name = "Tbldataindukpeg.findByTahunmasuk", query = "SELECT t FROM Tbldataindukpeg t WHERE t.tahunmasuk = :tahunmasuk")})
public class Tbldataindukpeg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIP")
    private String nip;
    @Column(name = "Nama")
    private String nama;
    @Column(name = "JenisKelamin")
    private String jenisKelamin;
    @Column(name = "status")
    private String status;
    @Column(name = "golDarah")
    private String golDarah;
    @Column(name = "gelarDepan")
    private String gelarDepan;
    @Column(name = "gelarBelakang")
    private String gelarBelakang;
    @Column(name = "agama")
    private String agama;
    @Basic(optional = false)
    @Column(name = "tempatLahir")
    private String tempatLahir;
    @Column(name = "tglLahir")
    @Temporal(TemporalType.DATE)
    private Date tglLahir;
    @Column(name = "noKtp")
    private Integer noKtp;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "telRumah")
    private String telRumah;
    @Column(name = "noPonsel")
    private String noPonsel;
    @Basic(optional = false)
    @Column(name = "tahunmasuk")
    private int tahunmasuk;
    @OneToMany(mappedBy = "nip")
    private List<Tbldatapengajupangkat> tbldatapengajupangkatList;
    @OneToMany(mappedBy = "nip")
    private List<Tblpengajupensiun> tblpengajupensiunList;
    @JoinColumn(name = "idPangkat", referencedColumnName = "idPangkat")
    @ManyToOne(optional = false)
    private Tbldatapangkat idPangkat;
    @OneToMany(mappedBy = "nip")
    private List<Tblterimanaikpangkat> tblterimanaikpangkatList;
    @OneToMany(mappedBy = "idPangkatbaru")
    private List<Tblterimanaikpangkat> tblterimanaikpangkatList1;
    @OneToMany(mappedBy = "nip")
    private List<Tbldatauser> tbldatauserList;
    @OneToMany(mappedBy = "nip")
    private List<Tbltolaknaikpangkat> tbltolaknaikpangkatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nip")
    private List<Tbldatakeluarga> tbldatakeluargaList;
    @OneToMany(mappedBy = "nip")
    private List<Tbldatapensiun> tbldatapensiunList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nip")
    private List<Tbldatariwayatpend> tbldatariwayatpendList;

    public Tbldataindukpeg() {
    }

    public Tbldataindukpeg(String nip) {
        this.nip = nip;
    }

    public Tbldataindukpeg(String nip, String tempatLahir, int tahunmasuk) {
        this.nip = nip;
        this.tempatLahir = tempatLahir;
        this.tahunmasuk = tahunmasuk;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }

    public String getGelarDepan() {
        return gelarDepan;
    }

    public void setGelarDepan(String gelarDepan) {
        this.gelarDepan = gelarDepan;
    }

    public String getGelarBelakang() {
        return gelarBelakang;
    }

    public void setGelarBelakang(String gelarBelakang) {
        this.gelarBelakang = gelarBelakang;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Integer getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(Integer noKtp) {
        this.noKtp = noKtp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelRumah() {
        return telRumah;
    }

    public void setTelRumah(String telRumah) {
        this.telRumah = telRumah;
    }

    public String getNoPonsel() {
        return noPonsel;
    }

    public void setNoPonsel(String noPonsel) {
        this.noPonsel = noPonsel;
    }

    public int getTahunmasuk() {
        return tahunmasuk;
    }

    public void setTahunmasuk(int tahunmasuk) {
        this.tahunmasuk = tahunmasuk;
    }

    @XmlTransient
    public List<Tbldatapengajupangkat> getTbldatapengajupangkatList() {
        return tbldatapengajupangkatList;
    }

    public void setTbldatapengajupangkatList(List<Tbldatapengajupangkat> tbldatapengajupangkatList) {
        this.tbldatapengajupangkatList = tbldatapengajupangkatList;
    }

    @XmlTransient
    public List<Tblpengajupensiun> getTblpengajupensiunList() {
        return tblpengajupensiunList;
    }

    public void setTblpengajupensiunList(List<Tblpengajupensiun> tblpengajupensiunList) {
        this.tblpengajupensiunList = tblpengajupensiunList;
    }

    public Tbldatapangkat getIdPangkat() {
        return idPangkat;
    }

    public void setIdPangkat(Tbldatapangkat idPangkat) {
        this.idPangkat = idPangkat;
    }

    @XmlTransient
    public List<Tblterimanaikpangkat> getTblterimanaikpangkatList() {
        return tblterimanaikpangkatList;
    }

    public void setTblterimanaikpangkatList(List<Tblterimanaikpangkat> tblterimanaikpangkatList) {
        this.tblterimanaikpangkatList = tblterimanaikpangkatList;
    }

    @XmlTransient
    public List<Tblterimanaikpangkat> getTblterimanaikpangkatList1() {
        return tblterimanaikpangkatList1;
    }

    public void setTblterimanaikpangkatList1(List<Tblterimanaikpangkat> tblterimanaikpangkatList1) {
        this.tblterimanaikpangkatList1 = tblterimanaikpangkatList1;
    }

    @XmlTransient
    public List<Tbldatauser> getTbldatauserList() {
        return tbldatauserList;
    }

    public void setTbldatauserList(List<Tbldatauser> tbldatauserList) {
        this.tbldatauserList = tbldatauserList;
    }

    @XmlTransient
    public List<Tbltolaknaikpangkat> getTbltolaknaikpangkatList() {
        return tbltolaknaikpangkatList;
    }

    public void setTbltolaknaikpangkatList(List<Tbltolaknaikpangkat> tbltolaknaikpangkatList) {
        this.tbltolaknaikpangkatList = tbltolaknaikpangkatList;
    }

    @XmlTransient
    public List<Tbldatakeluarga> getTbldatakeluargaList() {
        return tbldatakeluargaList;
    }

    public void setTbldatakeluargaList(List<Tbldatakeluarga> tbldatakeluargaList) {
        this.tbldatakeluargaList = tbldatakeluargaList;
    }

    @XmlTransient
    public List<Tbldatapensiun> getTbldatapensiunList() {
        return tbldatapensiunList;
    }

    public void setTbldatapensiunList(List<Tbldatapensiun> tbldatapensiunList) {
        this.tbldatapensiunList = tbldatapensiunList;
    }

    @XmlTransient
    public List<Tbldatariwayatpend> getTbldatariwayatpendList() {
        return tbldatariwayatpendList;
    }

    public void setTbldatariwayatpendList(List<Tbldatariwayatpend> tbldatariwayatpendList) {
        this.tbldatariwayatpendList = tbldatariwayatpendList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nip != null ? nip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldataindukpeg)) {
            return false;
        }
        Tbldataindukpeg other = (Tbldataindukpeg) object;
        if ((this.nip == null && other.nip != null) || (this.nip != null && !this.nip.equals(other.nip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tbldataindukpeg[ nip=" + nip + " ]";
    }
    
}
