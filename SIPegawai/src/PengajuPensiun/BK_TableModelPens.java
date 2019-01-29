/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PengajuPensiun;

/**
 *
 * @author Dwi Lutfi
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BK_TableModelPens extends AbstractTableModel{
    List<ModelPensiun> tp;
public BK_TableModelPens(List<ModelPensiun> tp)
{
    this.tp=tp;
}        
public int getColumnCount(){
    return 3;
    
}
public int getRowCount(){
    return tp.size();
}
public String getColumnName(int column){
    switch(column){
        case 0:
            return "Id Pengaju Pensiun";
        case 1:
            return "NIP";
        case 2:
            return "Status Pengajuan";
        default:
            return null;
            
    }
}
public Object getValueAt(int row, int column){
    switch(column){
        case 0:
            return tp.get(row).getIdPengajuPensiun();
        case 1:
            return tp.get(row).getNIP();
        case 2:
            return tp.get(row).getStatus();
        default:
            return null;
    }
}
    
}
