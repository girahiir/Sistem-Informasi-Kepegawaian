/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

import View.HalUtamaBK;
import java.util.List;
import TampilData.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lyandaf
 */
public class ControllerTampilPendidikan {

    HalUtamaBK frame;
    DaoImplTampilPendidikan implTampilPend;
    List<ModelTampilPendidikan> mtp;

    public ControllerTampilPendidikan(HalUtamaBK frame) {
        this.frame = frame;
        implTampilPend = new DaoTampilPendidikan();
        mtp = implTampilPend.getAll();
    }

    public void isiTable() {
        mtp = implTampilPend.getAll();
        TableModelTampilPendidikan tmp = new TableModelTampilPendidikan(mtp);
        frame.gettabelTampilPendidikan().setModel(tmp);

    }
     public void isiTableCari(){
       mtp = implTampilPend.getCari(frame.gettxtSearchPendidikan().getText());
       TableModelTampilPendidikan tmb = new TableModelTampilPendidikan(mtp);
       frame.gettabelTampilPendidikan().setModel(tmb);
     }
    
    public void search(){
        if(!frame.gettxtSearchPendidikan().getText().trim().isEmpty()){
            implTampilPend.getCari(frame.gettxtSearchPendidikan().getText());
            isiTableCari();
        }else {
            JOptionPane.showMessageDialog(frame, "Silahkan pilih data");
        }
    }
}
