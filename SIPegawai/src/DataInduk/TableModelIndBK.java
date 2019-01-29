/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInduk;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Girah
 */
public class TableModelIndBK extends AbstractTableModel {

    List<ModelInd> mi;

    public TableModelIndBK(List<ModelInd> mi) {
        this.mi = mi;
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public int getRowCount() {
        return mi.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIP";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Status";
            case 4:
                return "Golongan Darah";
            case 5:
                return "Gelar Depan";
            case 6:
                return "Gelar Belakang";
            case 7:
                return "Agama";
            case 8:
                return "Tempat Lahir";
            case 9:
                return "Tanggal Lahir";
            case 10:
                return "No. KTP";
            case 11:
                return "Alamat";
            case 12:
                return "No. Telp";
            case 13:
                return "No. Ponsel";
            case 14:
                return "Tahun Masuk";
            case 15:
                return "ID Pangkat";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return mi.get(row).getNip();
            case 1:
                return mi.get(row).getNama();
            case 2:
                return mi.get(row).getJk();
            case 3:
                return mi.get(row).getStatus();
            case 4:
                return mi.get(row).getGolDar();
            case 5:
                return mi.get(row).getGelarDepan();
            case 6:
                return mi.get(row).getGelarBelakang();
            case 7:
                return mi.get(row).getAgama();
            case 8:
                return mi.get(row).getTempatLahir();
            case 9:
                return mi.get(row).getTglLahir();
            case 10:
                return mi.get(row).getNoKtp();
            case 11:
                return mi.get(row).getAlamat();
            case 12:
                return mi.get(row).getNoTelp();
            case 13:
                return mi.get(row).getNoPonsel();
            case 14:
                return mi.get(row).getTahunMasuk();
            case 15:
                return mi.get(row).getIdPangkat();
            default:
                return null;
        }
    }
}
