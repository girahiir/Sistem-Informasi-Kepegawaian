/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPendidikan;


import DataKeluarga.ModelKel;
import View.HalUtamaBK;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lyandaf
 */
public class ControllerPendBK {
   HalUtamaBK frame;
   DaoImplPendBK implPendBK;
   List<ModelPend> mk;
   
   public ControllerPendBK(HalUtamaBK frame){
     this.frame = frame;
     implPendBK = new DaoPendBK();
     mk = implPendBK.getAll();
   }
   
   public void isiTable(){
      mk = implPendBK.getAll();
      TableModelPendBK tmb = new TableModelPendBK(mk);
      frame.getTabelDataPendidikan().setModel(tmb);
      
   }
   public void isiField(int row){
       frame.gettxtID().setText(mk.get(row).getId());
       frame.gettxtNIP().setText(mk.get(row).getNIP());
       frame.gettxtTingkat().setText(mk.get(row).getTingkatPendidikan());
       frame.gettxtTempatPend().setText(mk.get(row).getTempatPendidikan());
       frame.gettxtJurusan().setText(mk.get(row).getJurusan());
       frame.gettxtTanggalIjazah().setText(mk.get(row).getTglIjazah());
       frame.gettxtTahunMasukPendidikan().setText(String.valueOf(mk.get(row).getThnMasuk()));
       frame.gettxtTahunLulus().setText(String.valueOf(mk.get(row).getThnLulus()));
      
}
   public void insert()   {
      if (!frame.gettxtTingkat().getText().trim().isEmpty()) {
            ModelPend m = new ModelPend(); 
            
            m.setId((frame.gettxtID().getText()));
            m.setNIP((frame.gettxtNIP().getText()));
            m.setTingkatPendidikan(frame.gettxtTingkat().getText());
            m.setTempatPendidikan(frame.gettxtTempatPend().getText());
            m.setJurusan(frame.gettxtJurusan().getText());
            m.setTglIjazah(frame.gettxtTanggalIjazah().getText());
            m.setThnMasuk(Integer.parseInt(frame.gettxtTahunMasukPendidikan().getText()));
            m.setThnLulus(Integer.parseInt(frame.gettxtTahunLulus().getText()));
           implPendBK.insert(m);
   }else {
            JOptionPane.showMessageDialog(frame, "isi data terlebih dahulu");
      }
   }
   
   public void update(){
       ModelPend m= new ModelPend();
       
       m.setNIP((frame.gettxtNIP().getText()));
       m.setTingkatPendidikan(frame.gettxtTingkat().getText());
       m.setTempatPendidikan(frame.gettxtTempatPend().getText());
       m.setJurusan(frame.gettxtJurusan().getText());
       m.setTglIjazah(frame.gettxtTanggalIjazah().getText());
       m.setThnMasuk(Integer.parseInt(frame.gettxtTahunMasukPendidikan().getText()));
       m.setThnLulus(Integer.parseInt(frame.gettxtTahunLulus().getText()));
       m.setId((frame.gettxtID().getText()));
       implPendBK.update(m);
   }
}
