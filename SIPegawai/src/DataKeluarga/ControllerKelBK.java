/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKeluarga;


import View.HalUtamaBK;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Girah
 */
public class ControllerKelBK {

    HalUtamaBK frame;
    DaoImplKelBK implKelBK;
    List<ModelKel> mk;

    public ControllerKelBK(HalUtamaBK frame) {
        this.frame = frame;
        implKelBK = new DaoKelBK();
        mk = implKelBK.getAll();
    }

    public void isiTable() {
        mk = implKelBK.getAll();
        TableModelKelBK tmb = new TableModelKelBK(mk);
        frame.getTabelDataKeluarga().setModel(tmb);
    }

    public void isiField(int row) {
        frame.gettxtIdKelBK().setText(mk.get(row).getIdKel().toString());
        frame.gettxtNipKelBK().setText(mk.get(row).getNipKel());
        frame.gettxtAyah().setText(mk.get(row).getAyah());
        frame.gettxtIbu().setText(mk.get(row).getIbu());
        frame.gettxtIstri().setText(mk.get(row).getIstri());
        frame.gettxtSuami().setText(mk.get(row).getSuami());
        frame.gettxtJmlAnak().setText(mk.get(row).getJmlAnak().toString());
        frame.gettxtKerjaSuami().setText(mk.get(row).getKerjaSuami());
        frame.gettxtKerjaIstri().setText(mk.get(row).getKerjaIstri());
        frame.gettxtKerjaAnak().setText(mk.get(row).getKerjaAnak());

    }

    public void insert() {
        if (!frame.gettxtAyah().getText().trim().isEmpty()) {
            ModelKel m = new ModelKel();
            m.setIdKel(frame.gettxtIdKelBK().getText());
            m.setNipKel(frame.gettxtNipKelBK().getText());
            m.setAyah(frame.gettxtAyah().getText());
            m.setIbu(frame.gettxtIbu().getText());
            m.setIstri(frame.gettxtIstri().getText());
            m.setSuami(frame.gettxtSuami().getText());
            m.setJmlAnak(Integer.parseInt(frame.gettxtJmlAnak().getText()));
            m.setKerjaSuami(frame.gettxtKerjaSuami().getText());
            m.setKerjaIstri(frame.gettxtKerjaIstri().getText());
            m.setKerjaAnak(frame.gettxtKerjaAnak().getText());
            implKelBK.insert(m);
        } else {
            JOptionPane.showMessageDialog(frame, "isi data terlebih dahulu");
        }
    }

    public void update() {
        ModelKel m = new ModelKel();
        m.setNipKel(frame.gettxtNipKelBK().getText());
        m.setAyah(frame.gettxtAyah().getText());
        m.setIbu(frame.gettxtIbu().getText());
        m.setIstri(frame.gettxtIstri().getText());
        m.setSuami(frame.gettxtSuami().getText());
        m.setJmlAnak(Integer.parseInt(frame.gettxtJmlAnak().getText()));
        m.setKerjaSuami(frame.gettxtKerjaSuami().getText());
        m.setKerjaIstri(frame.gettxtKerjaIstri().getText());
        m.setKerjaAnak(frame.gettxtKerjaAnak().getText());
        m.setIdKel(frame.gettxtIdKelBK().getText());
        implKelBK.update(m);
    }
}
