/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPangkat;

/**
 *
 * @author Girah
 */
public class ModelPengajuPangkat {

    private String id;
    private String nip;
    private String pangkatLama;
    private String pangkatBaru;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPangkatLama() {
        return pangkatLama;
    }

    public void setPangkatLama(String pangkatLama) {
        this.pangkatLama = pangkatLama;
    }

    public String getPangkatBaru() {
        return pangkatBaru;
    }

    public void setPangkatBaru(String pangkatBaru) {
        this.pangkatBaru = pangkatBaru;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
