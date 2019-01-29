/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKeluarga;

import View.HalUtamaPegawai;
import java.util.List;

/**
 *
 * @author Girah
 */
public class ControllerKelPeg {

    HalUtamaPegawai frame;
    DaoImplKelPeg implKelPeg;
    List<ModelKel> mk;

    public ControllerKelPeg(HalUtamaPegawai frame) {
        this.frame = frame;
        implKelPeg = new DaoKelPeg();
//        mk = implKelPeg.getAll(frame.getNIPPegawai());
    }

    public void isiTable() {
        mk = implKelPeg.getAll(frame.getNIPPegawai());
        TableModelKelPeg tmb = new TableModelKelPeg(mk);
        frame.getTabelDataKeluarga().setModel(tmb);
    }

    public void reset() {
        frame.gettxtIdKelPeg().setText("");
        frame.gettxtNipKelPeg().setText("");
        frame.gettxtAyah().setText("");
        frame.gettxtIbu().setText("");
        frame.gettxtIstri().setText("");
        frame.gettxtSuami().setText("");
        frame.gettxtJmlAnak().setText("");
        frame.gettxtKerjaSuami().setText("");
        frame.gettxtKerjaIstri().setText("");
        frame.gettxtKerjaAnak().setText("");
    }

    public void isiField(int row) {
        frame.gettxtIdKelPeg().setText(mk.get(row).getIdKel().toString());
        frame.gettxtNipKelPeg().setText(mk.get(row).getNipKel());
        frame.gettxtAyah().setText(mk.get(row).getAyah());
        frame.gettxtIbu().setText(mk.get(row).getIbu());
        frame.gettxtIstri().setText(mk.get(row).getIstri());
        frame.gettxtSuami().setText(mk.get(row).getSuami());
        frame.gettxtJmlAnak().setText(mk.get(row).getJmlAnak().toString());
        frame.gettxtKerjaSuami().setText(mk.get(row).getKerjaSuami());
        frame.gettxtKerjaIstri().setText(mk.get(row).getKerjaIstri());
        frame.gettxtKerjaAnak().setText(mk.get(row).getKerjaAnak());
    }

    public void update() {
        ModelKel m = new ModelKel();
        m.setNipKel(frame.gettxtNipKelPeg().getText());
        m.setAyah(frame.gettxtAyah().getText());
        m.setIbu(frame.gettxtIbu().getText());
        m.setIstri(frame.gettxtIstri().getText());
        m.setSuami(frame.gettxtSuami().getText());
        m.setJmlAnak(Integer.parseInt(frame.gettxtJmlAnak().getText()));
        m.setKerjaSuami(frame.gettxtKerjaSuami().getText());
        m.setKerjaIstri(frame.gettxtKerjaIstri().getText());
        m.setKerjaAnak(frame.gettxtKerjaAnak().getText());
        m.setIdKel(frame.gettxtIdKelPeg().getText());
        implKelPeg.update(m);
    }
}
