/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPendidikan;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lyandaf
 */
public class TableModelPendBK extends AbstractTableModel{
    
    List<ModelPend> mk;
    
    public TableModelPendBK (List<ModelPend> mk){
        this.mk = mk;
    }
    
    public int getColumnCount(){
        return 8;
    }

    @Override
    public int getRowCount() {
        return mk.size();
    }

    
    public String getColumnName(int column){
    switch (column){
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
                return mk.get(row).getId();
            case 1:
                return mk.get(row).getNIP();
            case 2:
                return mk.get(row).getTingkatPendidikan();
            case 3:
                return mk.get(row).getTempatPendidikan();
            case 4:
                return mk.get(row).getJurusan();
            case 5:
                return mk.get(row).getTglIjazah();
            case 6:
                return mk.get(row).getThnMasuk();
            case 7:
                return mk.get(row).getThnLulus();  
            default:
                return null;
     }
    
}
}
