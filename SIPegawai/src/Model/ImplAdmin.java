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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplAdmin implements InterfaceAdmin{
    
    Connection connection;
    final String insert = "INSERT INTO tbldatauser (idUser, NIP, password, type, status) VALUES (?,?,?,?,?)";
    final String update = "UPDATE tbldatauser set idUser = ?, password = ? , type = ?, status = ? where NIP = ?";
    final String delete = "DELETE FROM tbldatauser where NIP = ?";
    final String select = " SELECT * FROM tbldatauser";
    
    public ImplAdmin(){
        connection = Koneksi.con;
    }

    @Override
    public List<ModelAdmin> getAll() {
        List<ModelAdmin> model = null;
        try{
            model = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelAdmin m = new ModelAdmin();
                m.setIdUser(rs.getString("idUser"));
                m.setNIP(rs.getString("NIP"));
                m.setPassword(rs.getString("password"));
                m.setType(rs.getString("type"));
                m.setStatus(rs.getString("status"));
                model.add(m);
                
            }
        } catch (SQLException ex){
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    @Override
    public void insert(ModelAdmin admin) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, admin.getIdUser());
            statement.setString(2, admin.getNIP());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getType());
            statement.setString(5, admin.getStatus());
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(ModelAdmin admin) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, admin.getIdUser());
            statement.setString(2, admin.getPassword());
            statement.setString(3, admin.getType());
            statement.setString(4, admin.getStatus());
            statement.setString(5, admin.getNIP());
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally{
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String NIP) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, NIP);
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally{
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}

