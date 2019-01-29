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
import Model.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import PengajuPensiun.Rektor_DaoImpPens;
public class Rektor_DaoPens implements Rektor_DaoImpPens {
    Connection connection;
    final String update = "update tblpengajupensiun set NIP = ?, status = ? where idPengajuPensiun = ?";
    final String select = "SELECT * FROM tblpengajupensiun";
 
    public Rektor_DaoPens() {
       connection = Koneksi.connection();
    }

//   
//    @Override
//        public void insert(ModelPensiun mp) {
//         PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(insert);
//            statement.setString(1, mp.getIdPengajuPensiun());
//            statement.setString(2, mp.getNIP());
//            statement.setString(3, mp.getStatus());
//            statement.executeUpdate();
//        } catch (SQLException ex){
//            ex.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch(SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

   
////    public void delete(ModelPensiun mp) {
////     PreparedStatement statement = null;
////        try {
////            statement = connection.prepareStatement(delete);
////            statement.setString(1, mp.getIdPengajuPensiun());
////            statement.executeUpdate();
////        } catch (SQLException ex){
////            ex.printStackTrace();
////        } finally {
////            try {
////                statement.close();
////            } catch(SQLException ex) {
////                ex.printStackTrace();
////            }
////        }
//
//    }

   public void update(ModelPensiun mp) {
        PreparedStatement statement = null;
//        
//        Rektor_PengajuPensiunRektor view = new Rektor_PengajuPensiunRektor();
//        int v = view.tblDataPensR().getSelectedRow();
        
        try {
            statement = connection.prepareStatement(update);
            statement.setString(3, mp.getIdPengajuPensiun());
            statement.setString(1, mp.getNIP());
            switch(mp.getStatus()){
                case "TUNGGU":
                    statement.setString(2, "TUNGGU");
                break;
                case "DISETUJUI":
                    statement.setString(2, "DISETUJUI");
                break; 
            }  
////         
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
   }
    @Override
    public List<ModelPensiun> getAll() {
    List<ModelPensiun> lp = null;
        try {
            lp = new ArrayList<ModelPensiun>();
            Statement bt = connection.createStatement();
            ResultSet rs = bt.executeQuery(select);
            while (rs.next()){
                ModelPensiun mp = new ModelPensiun();
                mp.setIdPengajuPensiun(rs.getString("idPengajuPensiun"));
                mp.setNIP(rs.getString("NIP"));
                mp.setStatus(rs.getString("status"));
                lp.add(mp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BK_DaoPeng.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
}
