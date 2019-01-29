/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ModelKel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Girah
 */
public class TableModelKelBK extends AbstractTableModel {

    List<ModelKel> mk;

    public TableModelKelBK(List<ModelKel> mk) {
        this.mk = mk;
    }

    public int getColumnCount() {
        return 9;
    }

    public int getRowCount() {
        return mk.size();
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Ayah";
            case 2:
                return "Nama Ibu";
            case 3:
                return "Nama Suami";
            case 4:
                return "Nama Istri";
            case 5:
                return "Jumlah Anak";
            case 6:
                return "Pekerjaan Suami";
            case 7:
                return "Pekerjaan Istri";
            case 8:
                return "Pekerjaan Anak";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return mk.get(row).getId();
            case 1:
                return mk.get(row).getAyah();
            case 2:
                return mk.get(row).getIbu();
            case 3:
                return mk.get(row).getSuami();
            case 4:
                return mk.get(row).getIstri();
            case 5:
                return mk.get(row).getAnak();
            case 6:
                return mk.get(row).getKerjaSuami();
            case 7:
                return mk.get(row).getKerjaIstri();
            case 8:
                return mk.get(row).getKerjaAnak();
            default:
                return null;
        }
    }
}
