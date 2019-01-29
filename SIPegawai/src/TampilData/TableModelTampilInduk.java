/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Girah
 */
public class TableModelTampilInduk extends AbstractTableModel {

    List<ModelTampilInduk> mti;

    public TableModelTampilInduk(List<ModelTampilInduk> mti) {
        this.mti = mti;
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public int getRowCount() {
        return mti.size();
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
                return mti.get(row).getNip();
            case 1:
                return mti.get(row).getNama();
            case 2:
                return mti.get(row).getJk();
            case 3:
                return mti.get(row).getStatus();
            case 4:
                return mti.get(row).getGolDar();
            case 5:
                return mti.get(row).getGelarDepan();
            case 6:
                return mti.get(row).getGelarBelakang();
            case 7:
                return mti.get(row).getAgama();
            case 8:
                return mti.get(row).getTempatLahir();
            case 9:
                return mti.get(row).getTglLahir();
            case 10:
                return mti.get(row).getNoKtp();
            case 11:
                return mti.get(row).getAlamat();
            case 12:
                return mti.get(row).getNoTelp();
            case 13:
                return mti.get(row).getNoPonsel();
            case 14:
                return mti.get(row).getTahunMasuk();
            case 15:
                return mti.get(row).getIdPangkat();
            default:
                return null;
        }
    }
}
