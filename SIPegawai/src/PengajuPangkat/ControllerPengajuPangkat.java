/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPangkat;

import View.HalUtamaBK;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Girah
 */
public class ControllerPengajuPangkat {

    HalUtamaBK frame;
    DaoImplPengajuPangkat implPengajuPangkat;
    List<ModelPengajuPangkat> mpp;

    public ControllerPengajuPangkat(HalUtamaBK frame) {
        this.frame = frame;
        implPengajuPangkat = new DaoPengajuPangkat();
        mpp = implPengajuPangkat.getAll();
    }

    public void isiTable() {
        mpp = implPengajuPangkat.getAll();
        TableModelPengajuPangkat tpp = new TableModelPengajuPangkat(mpp);
        frame.getTabelDataPengajuPangkat().setModel(tpp);
    }

//    public void isiField(int row) {
//        frame.gettxtIdNaikPangkat().setText(mpp.get(row).getId());
//        frame.gettxtNipNaikPangkat().setText(mpp.get(row).getNip());
//        frame.gettxtPangkatLama().setText(mpp.get(row).getPangkatLama());
//        frame.gettxtPangkatBaru().setText(mpp.get(row).getPangkatBaru());
//        frame.gettxtStatusPangkat().setText(mpp.get(row).getStatus());
//    }

    public void insert() {
        if (!frame.gettxtIdNaikPangkat().getText().trim().isEmpty()) {
            ModelPengajuPangkat m = new ModelPengajuPangkat();
            m.setId(frame.gettxtIdNaikPangkat().getText());
            m.setNip(frame.gettxtNipNaikPangkat().getText());
            m.setPangkatLama(frame.gettxtPangkatLama().getText());
            m.setPangkatBaru(frame.gettxtPangkatBaru().getText());
            m.setStatus((String) frame.getCmbStatusBK().getSelectedItem());
           
            implPengajuPangkat.insert(m);
        } else {
            JOptionPane.showMessageDialog(frame, "isi data terlebih dahulu");
        }
    }
    
}
