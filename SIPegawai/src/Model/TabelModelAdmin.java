/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Arsyadi Ahmad
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class TabelModelAdmin extends AbstractTableModel{
    List<ModelAdmin> model;
    public TabelModelAdmin(List<ModelAdmin> model){
        this.model = model;
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public int getRowCount(){
        return model.size();
    }
    
    public String getCoumnName (int column){
        switch(column){
            case 0 :
                return "idUser";
            case 1 :
                return "NIP";
            case 2 :
                return "Password";
            case 3 :
                return "Type";
            case 4 :
                return "Status";
            default :
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column){
        switch(column){
            case 0 :
                return model.get(row).getIdUser();
            case 1 :
                return model.get(row).getNIP();
            case 2 :
                return model.get(row).getPassword();
            case 3 :
                return model.get(row).getType();
            case 4 :
                return model.get(row).getStatus();
            default :
                return null;
        }
    }
}