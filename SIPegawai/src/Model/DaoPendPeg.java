/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.*;
import Model.DaoKelBK;
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
/**
 *
 * @author lyandaf
 */
public class DaoPendPeg implements DaoImplPendPeg{

   Connection connection;
    final String update = " UPDATE tblriwayatpend set tingkatPendidikan =?,tempatPendidikan=?,jurusan=?,tglIjazah=?,thnMasuk=?,thnLulus=? where idRp=?;";
    final String select = " SELECT * FROM tblriwayatpend";  
   
    
    @Override
    public void update(ModelPend mk) {
     PreparedStatement statement = null;
      try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mk.getId());
            statement.setString(2, mk.getTingkat());
            statement.setString(3, mk.getTempatPend());
            statement.setString(4, mk.getJurusan());
            statement.setString(5, mk.getTglIjazah());
            statement.setInt(6, mk.getThnMasuk());
            statement.setInt(7, mk.getThnLulus());
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
    public List<ModelPend> getAll() {
      List<ModelPend> mk = null;
      try{
          mk = new ArrayList<ModelPend>();
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery(select);
          while (rs.next()){
           ModelPend m = new ModelPend();
           m.setId(rs.getString("idRp"));
           m.setTingkat(rs.getString("tingkatPendidikan"));
           m.setTempatPend(rs.getString("tempatPendidikan"));
           m.setJurusan(rs.getString("jurusan"));
           m.setTglIjazah(rs.getString("tglIjazah"));
           m.setThnMasuk(rs.getInt("thnMasuk"));
           m.setThnLulus(rs.getInt("thnLulus"));
           mk.add(m);
          }
      }catch (SQLException ex) {
            Logger.getLogger(DaoPendBK.class.getName()).log(Level.SEVERE, null, ex);
    }
      return mk;
    }  
    }
    
