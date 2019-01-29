/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lyandaf
 */
public class TableModelTampilPendidikan extends AbstractTableModel {

    List<ModelTampilPendidikan> mtp;

    public TableModelTampilPendidikan(List<ModelTampilPendidikan> mtp) {
        this.mtp = mtp;
    }

    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return mtp.size();
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NIP";
            case 2:
                return "Tingkat Pendidikan";
            case 3:
                return "Tempat Pendidikan";
            case 4:
                return "Jurusan";
            case 5:
                return "Tanggal Ijazah";
            case 6:
                return "Tahun Masuk";
            case 7:
                return "Tahun Lulus";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return mtp.get(row).getId();
            case 1:
                return mtp.get(row).getNIP();
            case 2:
                return mtp.get(row).getTingkatPendidikan();
            case 3:
                return mtp.get(row).getTempatPendidikan();
            case 4:
                return mtp.get(row).getJurusan();
            case 5:
                return mtp.get(row).getTglIjazah();
            case 6:
                return mtp.get(row).getThnMasuk();
            case 7:
                return mtp.get(row).getThnLulus();
            default:
                return null;
        }

    }
}
