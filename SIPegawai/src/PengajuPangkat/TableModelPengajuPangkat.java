/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPangkat;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Girah
 */
public class TableModelPengajuPangkat extends AbstractTableModel {

    List<ModelPengajuPangkat> mpp;

    public TableModelPengajuPangkat(List<ModelPengajuPangkat> mpp) {
        this.mpp = mpp;
    }

    public int getColumnCount() {
        return 5;
    }

    public int getRowCount() {
        return mpp.size();
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NIP";
            case 2:
                return "Pangkat Lama";
            case 3:
                return "Pangkat Baru";
            case 4:
                return "Status";
            default:
                return null;
        }
    }

    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return mpp.get(row).getId();
            case 1:
                return mpp.get(row).getNip();
            case 2:
                return mpp.get(row).getPangkatLama();
            case 3:
                return mpp.get(row).getPangkatBaru();
            case 4:
                return mpp.get(row).getStatus();
            default:
                return null;
        }
    }
}
