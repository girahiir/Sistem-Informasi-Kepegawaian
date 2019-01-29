/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPendidikan;

import java.sql.Date;

/**
 *
 * @author lyandaf
 */
public class ModelPend {
   
    private String id;
    private String NIP;
    private String tingakatPendidikan;
    private String tempatPendidikan;
    private String jurusan;
    private String tglIjazah;
    private int thnMasuk;
    private int thnLulus;
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
     public String getNIP(){
        return NIP;
    }
    public void setNIP(String NIP){
        this.NIP = NIP;
    }
    
    public String getTingkatPendidikan(){
        return tingakatPendidikan;
    }
    
   public void setTingkatPendidikan(String Tingkat){
       this.tingakatPendidikan= Tingkat;
   }
    public String getTempatPendidikan(){
        return tempatPendidikan;
    }
    
   public void setTempatPendidikan(String TempatPend){
       this.tempatPendidikan= TempatPend;
   }
   
   public String getJurusan(){
        return jurusan;
    }
    
   public void setJurusan(String Jurusan){
       this.jurusan= Jurusan;
   }
   
    public String getTglIjazah() {
        return tglIjazah;
    }

    public void setTglIjazah(String TglIjazah) {
        this.tglIjazah = TglIjazah;
    }
 
     public int getThnMasuk() {
        return thnMasuk;
    }

    public void setThnMasuk(int ThnMasuk) {
        this.thnMasuk = ThnMasuk;
    }
    
    public int getThnLulus() {
        return thnLulus;
    }

    public void setThnLulus(int ThnLulus) {
        this.thnLulus = ThnLulus;
    }
    
    
    
}
