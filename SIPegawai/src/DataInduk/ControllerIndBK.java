/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInduk;


import View.HalUtamaBK;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Girah
 */
public class ControllerIndBK {

    HalUtamaBK frame;
    DaoImplIndBK implIndBK;
    List<ModelInd> mi;

    public ControllerIndBK(HalUtamaBK frame) {
        this.frame = frame;
        implIndBK = new DaoIndBK();
        mi = implIndBK.getAll();
    }

    public void isiTable() {
        mi = implIndBK.getAll();
        TableModelIndBK tmi = new TableModelIndBK(mi);
        frame.getTabelDataIndukBK().setModel(tmi);
    }

    public void reset() {
        frame.gettxtNipIndukBK().setText("");
        frame.gettxtNamaIndukBK().setText("");
        frame.gettxtJk().setText("");
        frame.gettxtStatusDiri().setText("");
        frame.gettxtGolDar().setText("");
        frame.gettxtGelarDepan().setText("");
        frame.gettxtGelarBelakang().setText("");
        frame.gettxtAgama().setText("");
        frame.gettxtTempatLahir().setText("");
        frame.gettxtTglLahir().setText("");
        frame.gettxtNoKtp().setText("");
        frame.gettxtAlamat().setText("");
        frame.gettxtNoTelp().setText("");
        frame.gettxtNoPonsel().setText("");
        frame.gettxtTahunMasukIndukBK().setText("");
        frame.gettxtIdPangkat().setText("");


    }

    public void isiField(int row) {
        frame.gettxtNipIndukBK().setText(mi.get(row).getNip());
        frame.gettxtNamaIndukBK().setText(mi.get(row).getNama());
        frame.gettxtJk().setText(mi.get(row).getJk());
        frame.gettxtStatusDiri().setText(mi.get(row).getStatus());
        frame.gettxtGolDar().setText(mi.get(row).getGolDar());
        frame.gettxtGelarDepan().setText(mi.get(row).getGelarDepan());
        frame.gettxtGelarBelakang().setText(mi.get(row).getGelarBelakang());
        frame.gettxtAgama().setText(mi.get(row).getAgama());
        frame.gettxtTempatLahir().setText(mi.get(row).getTempatLahir());
        frame.gettxtTglLahir().setText(mi.get(row).getTglLahir());
        frame.gettxtNoKtp().setText(Integer.toString(mi.get(row).getNoKtp()));
        frame.gettxtAlamat().setText(mi.get(row).getAlamat());
        frame.gettxtNoTelp().setText(mi.get(row).getNoTelp());
        frame.gettxtNoPonsel().setText(mi.get(row).getNoPonsel());
        frame.gettxtTahunMasukIndukBK().setText(Integer.toString(mi.get(row).getNoKtp()));
        frame.gettxtIdPangkat().setText(mi.get(row).getIdPangkat());



    }

    public void insert() {
        if (!frame.gettxtNipIndukBK().getText().trim().isEmpty()) {
            ModelInd i = new ModelInd();
            i.setNip(frame.gettxtNipIndukBK().getText());
            i.setNama(frame.gettxtNamaIndukBK().getText());
            i.setJk(frame.gettxtJk().getText());
            i.setStatus(frame.gettxtStatusDiri().getText());
            i.setGolDar(frame.gettxtGolDar().getText());
            i.setGelarDepan(frame.gettxtGelarDepan().getText());
            i.setGelarBelakang(frame.gettxtGelarBelakang().getText());
            i.setAgama(frame.gettxtAgama().getText());
            i.setTempatLahir(frame.gettxtTempatLahir().getText());
            i.setTglLahir(frame.gettxtTglLahir().getText());
            i.setNoKtp(Integer.parseInt(frame.gettxtNoKtp().getText()));
            i.setAlamat(frame.gettxtAlamat().getText());
            i.setNoTelp(frame.gettxtNoTelp().getText());
            i.setNoPonsel(frame.gettxtNoPonsel().getText());
            i.setTahunMasuk(Integer.parseInt(frame.gettxtTahunMasukIndukBK().getText()));
            i.setIdPangkat(frame.gettxtIdPangkat().getText());
            implIndBK.insert(i);
        } else {
            JOptionPane.showMessageDialog(frame, "isi data terlebih dahulu");
        }
    }

    public void update() {
        ModelInd i = new ModelInd();
        
        i.setNama(frame.gettxtNamaIndukBK().getText());
        i.setJk(frame.gettxtJk().getText());
        i.setStatus(frame.gettxtStatusDiri().getText());
        i.setGolDar(frame.gettxtGolDar().getText());
        i.setGelarDepan(frame.gettxtGelarDepan().getText());
        i.setGelarBelakang(frame.gettxtGelarBelakang().getText());
        i.setAgama(frame.gettxtAgama().getText());
        i.setTempatLahir(frame.gettxtTempatLahir().getText());
        i.setTglLahir(frame.gettxtTglLahir().getText());
        i.setNoKtp(Integer.parseInt(frame.gettxtNoKtp().getText()));
        i.setAlamat(frame.gettxtAlamat().getText());
        i.setNoTelp(frame.gettxtNoTelp().getText());
        i.setNoPonsel(frame.gettxtNoPonsel().getText());
        i.setTahunMasuk(Integer.parseInt(frame.gettxtTahunMasukIndukBK().getText()));
        i.setIdPangkat(frame.gettxtIdPangkat().getText());
        i.setNip(frame.gettxtNipIndukBK().getText());
        implIndBK.update(i);

    }
}
