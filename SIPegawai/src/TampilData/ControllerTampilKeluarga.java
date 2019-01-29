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
public class ControllerTampilKeluarga {

    HalUtamaBK frame;
    DaoImplTampilKeluarga implTampilKeluarga;
    List<ModelTampilKeluarga> mtk;

    public ControllerTampilKeluarga(HalUtamaBK frame) {
        this.frame = frame;
        implTampilKeluarga = new DaoTampilKeluarga();
        mtk = implTampilKeluarga.getAll();
    }

    public void isiTable() {
        mtk = implTampilKeluarga.getAll();
        TableModelTampilKeluarga tmk = new TableModelTampilKeluarga(mtk);
        frame.gettabelTampilKeluarga().setModel(tmk);

    }
     public void isiTableCari(){
       mtk = implTampilKeluarga.getCari(frame.gettxtSearchKeluarga().getText());
       TableModelTampilKeluarga tmb = new TableModelTampilKeluarga(mtk);
       frame.gettabelTampilKeluarga().setModel(tmb);
     }
    
    public void search(){
        if(!frame.gettxtSearchKeluarga().getText().trim().isEmpty()){
            implTampilKeluarga.getCari(frame.gettxtSearchKeluarga().getText());
            isiTableCari();
        }else {
            JOptionPane.showMessageDialog(frame, "Silahkan pilih data");
        }
    }
}
