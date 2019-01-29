/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pesan;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lyandaf
 */
public class DaoPesan implements ImplPesan{

    Connection connection;
    final String show = "Select * from tblpesan WHERE NIP=?;";
    final String insert = "INSERT INTO tblpesan VALUES (?,?);";
    public DaoPesan() {
        this.connection = Koneksi.connection();
    }  
    
    @Override
    public void tulisPesan(ModelPesan p) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareCall(insert);
            stmt.setString(1, p.getIsiPesan());
            stmt.setString(2, p.getNIP());
            stmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }        
    }
            
    @Override
    public ModelPesan getPesan(String nip) {     
        ModelPesan p = new ModelPesan();
        PreparedStatement stmt =null;
        try{
            stmt=connection.prepareCall(show);
            stmt.setString(1, nip);
            ResultSet rs = stmt.executeQuery();
            
            while ( rs.next()){
                p.setIsiPesan(rs.getString("isiPesan"));
                p.setNIP(rs.getString("NIP"));                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return p;       
    }

    
    
    
    
}
