/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInduk;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelIndPeg extends AbstractTableModel{
     List<ModelInd> mi;

    public TableModelIndPeg(List<ModelInd> mi) {
        this.mi = mi;
    }

    @Override
    public int getColumnCount() {
        return 14;
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
            default:
                return null;
        }
    }
    
}
