/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
        return 7;
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
                return "Tingkat Pendidikan";
            case 2:
                return "Tempat Pendidikan";
            case 3:
                return "Jurusan";
            case 4:
                return "Tanggal Ijazah";
            case 5:
                return "Tahun Masuk";
            case 6:
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
                return mk.get(row).getTingkat();
            case 2:
                return mk.get(row).getTempatPend();
            case 3:
                return mk.get(row).getJurusan();
            case 4:
                return mk.get(row).getTglIjazah();
            case 5:
                return mk.get(row).getThnMasuk();
            case 6:
                return mk.get(row).getThnLulus();  
            default:
                return null;
     }
    
}
}
