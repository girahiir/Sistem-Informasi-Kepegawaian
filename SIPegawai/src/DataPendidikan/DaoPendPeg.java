/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPendidikan;


import Koneksi.Koneksi;
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
    
    final String update = " UPDATE tbldatariwayatpend set NIP=? ,tingkatPendidikan =?, tempatPendidikan=?, jurusan=?, tglIjazah=?, thnMasuk=?, thnLulus=? where idRp=?;";
    final String select = " SELECT * FROM tbldatariwayatpend WHERE NIP =?;";
    
    
    public DaoPendPeg(){
        connection = Koneksi.connection();
    }
    
    

    @Override
    public void update(ModelPend mk) {
      PreparedStatement statement = null;
      try {
            statement = connection.prepareStatement(update);
            
            statement.setString(1, mk.getNIP());
            statement.setString(2, mk.getTingkatPendidikan());
            statement.setString(3, mk.getTempatPendidikan());
            statement.setString(4, mk.getJurusan());
            statement.setString(5, mk.getTglIjazah());
            statement.setInt(6, mk.getThnMasuk());
            statement.setInt(7, mk.getThnLulus());
            statement.setString(8, mk.getId());
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
    public List<ModelPend> getAll(String nip) {
      List<ModelPend> mk = null;
      try{
          mk = new ArrayList<ModelPend>();
          PreparedStatement st = connection.prepareStatement(select);
          st.setString(1, nip);
          System.out.println(nip);
          ResultSet rs = st.executeQuery();
          while (rs.next()){
           ModelPend m = new ModelPend();
           m.setId(rs.getString("idRp"));
           m.setNIP(rs.getString("NIP"));
           m.setTingkatPendidikan(rs.getString("tingkatPendidikan"));
           m.setTempatPendidikan(rs.getString("tempatPendidikan"));
           m.setJurusan(rs.getString("jurusan"));
           m.setTglIjazah(rs.getString("tglIjazah"));
           m.setThnMasuk(rs.getInt("thnMasuk"));
           m.setThnLulus(rs.getInt("thnLulus"));
           mk.add(m);
          }
      }catch (SQLException ex) {
          System.out.println(nip+"coba");
            Logger.getLogger(DaoPendPeg.class.getName()).log(Level.SEVERE, null, ex);
    }
      return mk;
    }
    
}
