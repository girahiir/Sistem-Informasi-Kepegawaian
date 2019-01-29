/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PengajuPensiun;

/**
 *
 * @author Dwi Lutfi
 */
import PengajuPensiun.BK_PengajuPensiun;
import View.HalUtamaBK;
import java.util.List;
import javax.swing.JOptionPane;

public class BK_ControllerPengPens {
    
    HalUtamaBK frame;
    BK_DaoImpPeng implPensBK;
    List<ModelPensiun> imp;
    
 public BK_ControllerPengPens(HalUtamaBK frame){
     this.frame=frame;
     implPensBK= new BK_DaoPeng();
     imp = implPensBK.getAll();
 }
 public void isiTable() {
        imp = implPensBK.getAll();
        BK_TableModelPens tmp = new BK_TableModelPens(imp);
        frame.gettblPengPensBk().setModel(tmp);
    }
 
 public void insert(){
     if(!frame.getTxtIdPengPensiBK().getText().trim().isEmpty()){
     ModelPensiun p = new ModelPensiun();
     p.setIdPengajuPensiun(frame.getTxtIdPengPensiBK().getText());
     p.setNIP(frame.getTxtnipPengPensBk().getText());
     p.setStatus(frame.getCmbStatusBK().getSelectedItem().toString());
     implPensBK.insert(p);
     }else{
         JOptionPane.showMessageDialog(frame, "Isi terlebih dahulu");
     }
     
 }
}
