/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Arsyadi Ahmad
 */
public class ModelPegawaiInduk {
    private String NIP;
    private String idDip;
    private String idDk;
    private String idRp;
    private String idPangkat;
    private String idProfesi;
    
    private String nama;
    private String jenisKelamin;
    private String status;
    private String golDarah;
    private String gelarDepan;
    private String gelarBelakang;
    private String agama;
    private Date tglLahir;
    private String noKtp;
    private String alamat;
    private String telRumah;
    private String noPonsel;

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getIdDip() {
        return idDip;
    }

    public void setIdDip(String idDip) {
        this.idDip = idDip;
    }

    public String getIdDk() {
        return idDk;
    }

    public void setIdDk(String idDk) {
        this.idDk = idDk;
    }

    public String getIdRp() {
        return idRp;
    }

    public void setIdRp(String idRp) {
        this.idRp = idRp;
    }

    public String getIdPangkat() {
        return idPangkat;
    }

    public void setIdPangkat(String idPangkat) {
        this.idPangkat = idPangkat;
    }

    public String getIdProfesi() {
        return idProfesi;
    }

    public void setIdProfesi(String idProfesi) {
        this.idProfesi = idProfesi;
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

    public void setJenisKelamin(String JenisKelamin) {
        this.jenisKelamin = JenisKelamin;
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

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
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
}
