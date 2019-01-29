/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

import View.HalUtamaBK;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Girah
 */
public class ControllerTampilInduk {

    HalUtamaBK frame;
    DaoImplTampilInduk implTampilInduk;
    List<ModelTampilInduk> mti;

    public ControllerTampilInduk(HalUtamaBK frame) {
        this.frame = frame;
        implTampilInduk = new DaoTampilInduk();
        mti = implTampilInduk.getAll();
    }

    public void isiTable() {
        mti = implTampilInduk.getAll();
        TableModelTampilInduk tmi = new TableModelTampilInduk(mti);
        frame.gettabelTampilInduk().setModel(tmi);
    }
    
     public void isiTableCari(){
       mti = implTampilInduk.getCari(frame.gettxtSearchDataInduk().getText());
       TableModelTampilInduk tmb = new TableModelTampilInduk(mti);
       frame.gettabelTampilInduk().setModel(tmb);
     }
    
    public void search(){
        if(!frame.gettxtSearchDataInduk().getText().trim().isEmpty()){
            implTampilInduk.getCari(frame.gettxtSearchDataInduk().getText());
            isiTableCari();
        }else {
            JOptionPane.showMessageDialog(frame, "Silahkan pilih data");
        }
    }
}
