/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PengajuPensiun;

import View.HalUtamaRektor;
import java.util.List;

public class Rektor_ControllerPengPens {
    HalUtamaRektor frame;
    Rektor_DaoImpPens implPensR;
    List<ModelPensiun> tp;

    public Rektor_ControllerPengPens(HalUtamaRektor frame) {
         this.frame=frame;
         implPensR= new Rektor_DaoPens();
         tp = implPensR.getAll();
        }
    
    public void isiTable() {
         tp = implPensR.getAll();
         Rektor_TableModelPens rmp = new Rektor_TableModelPens(tp);
         frame.getTblDataPensR().setModel(rmp);
        }
 
    public void update(){
        ModelPensiun p = new ModelPensiun();
        p.setNIP(frame.getTxtNipPensR().getText());
        p.setStatus(frame.getCmbAksi().getSelectedItem().toString());

        p.setIdPengajuPensiun(frame.getTxtIDPensR().getText());

        implPensR.update(p);

    }
     public void isiField(int row) {
         
         frame.getTxtIDPensR().setText(tp.get(row).getIdPengajuPensiun());
         frame.getTxtNipPensR().setText(tp.get(row).getNIP());
         if(tp.get(row).getStatus().equalsIgnoreCase("Tunggu")){
            frame.getCmbAksi().setSelectedItem(0);
         } else {
             frame.getCmbAksi().setSelectedItem(1);
         }
    }

   }

