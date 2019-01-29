/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author lyandaf
 */
public class ModelPend {
   
    private String id;
    private String tingkat;
    private String tempatPend;
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
    
    public String getTingkat(){
        return tingkat;
    }
    
   public void setTingkat(String Tingkat){
       this.tingkat= Tingkat;
   }
    public String getTempatPend(){
        return tempatPend;
    }
    
   public void setTempatPend(String TempatPend){
       this.tempatPend= TempatPend;
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
