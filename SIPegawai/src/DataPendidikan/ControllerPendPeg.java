/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPendidikan;


import View.HalUtamaPegawai;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lyandaf
 */
public class ControllerPendPeg {
   HalUtamaPegawai frame;
   DaoImplPendPeg implPendPeg;
   List<ModelPend> mk;
   String NIPPegawai;
   
   public ControllerPendPeg(HalUtamaPegawai frame){
     this.frame = frame;
     implPendPeg = new DaoPendPeg();
     NIPPegawai = frame.getNIPPegawai();
  //     System.out.println("Controller : "+NIPPegawai);
//     mk = implPendPeg.getAll(NIPPegawai);
   }
   
   public void isiTable(){
      mk = implPendPeg.getAll(NIPPegawai);
      TableModelPendPeg tmb = new TableModelPendPeg(mk);
      frame.getTabelData().setModel(tmb);
      
   }
   public void isiField(int row){
       frame.gettxtID().setText(mk.get(row).getId());
       frame.gettxtNIPPendidikan().setText(mk.get(row).getNIP());
       frame.gettxtTingkatPendidikanPeg().setText(mk.get(row).getTingkatPendidikan());
       frame.gettxtTempatPendidikanPeg().setText(mk.get(row).getTempatPendidikan());
       frame.gettxtJurusan().setText(mk.get(row).getJurusan());
       frame.gettxtTanggalIjazah().setText(mk.get(row).getTglIjazah());
       frame.gettxtTahunMasuk().setText(String.valueOf(mk.get(row).getThnMasuk()));
       frame.gettxtTahunLulus().setText(String.valueOf(mk.get(row).getThnLulus()));
      
}
   
   
   public void update(){
       ModelPend m= new ModelPend();
       
       m.setNIP((frame.gettxtNIPPendidikan().getText()));
       m.setTingkatPendidikan(frame.gettxtTingkatPendidikanPeg().getText());
       m.setTempatPendidikan(frame.gettxtTempatPendidikanPeg().getText());
       m.setJurusan(frame.gettxtJurusan().getText());
       m.setTglIjazah(frame.gettxtTanggalIjazah().getText());
       m.setThnMasuk(Integer.parseInt(frame.gettxtTahunMasuk().getText()));
       m.setThnLulus(Integer.parseInt(frame.gettxtTahunLulus().getText()));
       m.setId((frame.gettxtID().getText()));
       implPendPeg.update(m);
   }
}
