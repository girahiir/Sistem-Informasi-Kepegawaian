    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPangkat;

import View.HalUtamaRektor;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Girah
 */
public class ControllerPengajuPangkatRektor {

    HalUtamaRektor frame;
    DaoImplPengajuPangkatRektor implPengajuPangkat;
    List<ModelPengajuPangkat> mpp;

    public ControllerPengajuPangkatRektor(HalUtamaRektor frame) {
        this.frame = frame;
        implPengajuPangkat = new DaoPengajuPangkatRektor();
        mpp = implPengajuPangkat.getAll();
    }

    public void isiTable() {
        mpp = implPengajuPangkat.getAll();
        TableModelPengajuPangkatRektor tpr = new TableModelPengajuPangkatRektor(mpp);
        frame.gettabelDataPengajuPangkatRek().setModel(tpr);
        System.out.println("isitable");
    }

    public void isiField(int row) {
        frame.gettxtIdPangkatRektor().setText(mpp.get(row).getId());
        frame.gettxtNipPangkatRektor().setText(mpp.get(row).getNip());
        frame.gettxtPangkatLama().setText(mpp.get(row).getPangkatLama());
        frame.gettxttxtPangkatBaru().setText(mpp.get(row).getPangkatBaru());
        if(mpp.get(row).getStatus().equalsIgnoreCase("DITOLAK")){
            frame.getcmbStatus().setSelectedItem(0);
        }else{
            frame.getcmbStatus().setSelectedItem(1);
        }
    }

    public void update() {
        ModelPengajuPangkat m = new ModelPengajuPangkat();
        m.setId(frame.gettxtIdPangkatRektor().getText());
        m.setNip(frame.gettxtNipPangkatRektor().getText());
        m.setPangkatLama(frame.gettxtPangkatLama().getText());
        m.setPangkatBaru(frame.gettxttxtPangkatBaru().getText());
        m.setStatus(frame.getcmbStatus().getSelectedItem().toString());
        implPengajuPangkat.update(m);
    }
}
