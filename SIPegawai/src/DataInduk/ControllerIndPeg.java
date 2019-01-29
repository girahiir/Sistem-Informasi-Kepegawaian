/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInduk;


import View.HalUtamaPegawai;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Girah
 */
public class ControllerIndPeg {

    HalUtamaPegawai frame;
    DaoImplIndPeg implIndPeg;
    List<ModelInd> mi;

    public ControllerIndPeg(HalUtamaPegawai frame) {
        this.frame = frame;
        implIndPeg = new DaoIndPeg();
       // mi = implIndPeg.getAll();
    }
     public void isiTable() {
        mi = implIndPeg.getAll(frame.getNIPPegawai());
        TableModelIndPeg tmi = new TableModelIndPeg(mi);
        frame.gettabelDataIndPeg().setModel(tmi);
    }

    
    public void reset() {
        frame.gettxtNipKelPeg().setText("");
        frame.gettxtNama().setText("");
        frame.gettxtAgama().setText("");
        frame.gettxtAlamat().setText("");
        frame.gettxtGelarBelakang().setText("");
        frame.gettxtGelarDepan().setText("");
        frame.gettxtGolDar().setText("");
        frame.gettxtJk().setText("");
        frame.gettxtNoKtp().setText("");
        frame.gettxtNoPonsel().setText("");
        frame.gettxtNoTelp().setText("");
        frame.gettxtStatus().setText("");
        frame.gettxtTempatLahir().setText("");
        frame.gettxtTglLahir().setText("");

    }
    public void isiField(int row) {
        frame.gettxtNipKelPeg().setText(mi.get(row).getNip());
        frame.gettxtNama().setText(mi.get(row).getNama());
        frame.gettxtJk().setText(mi.get(row).getJk());
        frame.gettxtStatus().setText(mi.get(row).getStatus());
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
      

    }

    public void update() {
        ModelInd i = new ModelInd();
        i.setNama(frame.gettxtNama().getText());
        i.setJk(frame.gettxtJk().getText());
        i.setStatus(frame.gettxtStatus().getText());
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
        i.setNip(frame.gettxtNipKelPeg().getText());
        implIndPeg.update(i);

    }
    
    
}
