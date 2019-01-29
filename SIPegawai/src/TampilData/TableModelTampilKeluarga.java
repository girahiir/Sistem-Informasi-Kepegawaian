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
public class TableModelTampilKeluarga extends AbstractTableModel {

    List<ModelTampilKeluarga> mtk;

    public TableModelTampilKeluarga(List<ModelTampilKeluarga> mtk) {
        this.mtk = mtk;
    }

    public int getColumnCount() {
        return 10;
    }

    public int getRowCount() {
        return mtk.size();
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NIP";
            case 2:
                return "Nama Ayah";
            case 3:
                return "Nama Ibu";
            case 4:
                return "Nama Istri";
            case 5:
                return "Nama Suami";
            case 6:
                return "Jumlah Anak";
            case 7:
                return "Pekerjaan Suami";
            case 8:
                return "Pekerjaan Istri";
            case 9:
                return "Pekerjaan Anak";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return mtk.get(row).getIdKel();
            case 1:
                return mtk.get(row).getNipKel();
            case 2:
                return mtk.get(row).getAyah();
            case 3:
                return mtk.get(row).getIbu();
            case 4:
                return mtk.get(row).getIstri();
            case 5:
                return mtk.get(row).getSuami();
            case 6:
                return mtk.get(row).getJmlAnak();
            case 7:
                return mtk.get(row).getKerjaSuami();
            case 8:
                return mtk.get(row).getKerjaIstri();
            case 9:
                return mtk.get(row).getKerjaAnak();
            default:
                return null;
        }
    }
}
