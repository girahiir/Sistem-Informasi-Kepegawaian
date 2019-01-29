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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ImplPegawaiInduk implements InterfacePegawaiInduk{
    Connection connection;
    final String insert = "INSERT INTO tbldataindukpeg (idDip, NIP, nama, jenisKelamin, status, golDarah, gelarDepan, gelarBelakang, agama, tglLahir, noKtp, alamat, telRumah, noPonsel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String update = "UPDATE tbldataindukpeg set idDip = ?, nama = ?, jenisKelamin= ? , status = ?, golDarah = ?, gelarDepan = ?, gelarBelakang = ?, agama = ?, tglLahir = ?, noKtp = ?, alamat = ?, telRumah = ?, noPonsel = ?, where NIP = ?";
    final String delete = "DELETE FROM tbldataindukpeg where NIP = ?";
    final String select = " SELECT * FROM tbldataindukpeg";
    private Date tglLahir;

    @Override
    public List<ModelPegawaiInduk> getAll() {
        List<ModelPegawaiInduk> model = null;
        try{
            model = new ArrayList<ModelPegawaiInduk>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModelPegawaiInduk pegawaiInduk = new ModelPegawaiInduk();
                pegawaiInduk.setAgama(rs.getString("agama"));
                pegawaiInduk.setAlamat(rs.getString("alamat"));
                pegawaiInduk.setGelarBelakang(rs.getString("gelarBelakang"));
                pegawaiInduk.setGelarDepan(rs.getString("gelarDepan"));
                pegawaiInduk.setGolDarah(rs.getString("golDarah"));
                pegawaiInduk.setIdDip(rs.getString("idDip"));
                pegawaiInduk.setIdDk(rs.getString("idDk"));
                pegawaiInduk.setIdPangkat(rs.getString("idPangkat"));
                pegawaiInduk.setIdProfesi(rs.getString("idProfesi"));
                pegawaiInduk.setIdRp(rs.getString("idRp"));
                pegawaiInduk.setJenisKelamin(rs.getString("jenisKelamin"));
                pegawaiInduk.setNIP(rs.getString("NIP"));
                pegawaiInduk.setNama(rs.getString("nama"));
                pegawaiInduk.setNoKtp(rs.getString("noKtp"));
                pegawaiInduk.setNoPonsel(rs.getString("noPonsel"));
                pegawaiInduk.setStatus(rs.getString("status"));
                pegawaiInduk.setTelRumah(rs.getString("telRumah"));
                pegawaiInduk.setTglLahir(tglLahir);
                model.add(pegawaiInduk);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(InterfacePegawaiInduk.class.getName()).log(Level.SEVERE,null,ex);
        }
        return model;
    }

    @Override
    public void insert(ModelPegawaiInduk pegawai) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, pegawai.getIdDip());
            statement.setString(2, pegawai.getNIP());
            statement.setString(3, pegawai.getNama());
            statement.setString(4, pegawai.getJenisKelamin());
            statement.setString(5, pegawai.getStatus());
            statement.setString(6, pegawai.getGolDarah());
            statement.setString(7, pegawai.getGelarDepan());
            statement.setString(8, pegawai.getGelarBelakang());
            statement.setString(9, pegawai.getAgama());
            statement.setDate(10, tglLahir);
            statement.setString(11, pegawai.getNoKtp());
            statement.setString(12, pegawai.getAlamat());
            statement.setString(13, pegawai.getTelRumah());
            statement.setString(14, pegawai.getNoPonsel());
            statement.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                statement.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(ModelPegawaiInduk pegawai) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, pegawai.getIdDip());
            statement.setString(2, pegawai.getNama());
            statement.setString(3, pegawai.getJenisKelamin());
            statement.setString(4, pegawai.getStatus());
            statement.setString(5, pegawai.getGolDarah());
            statement.setString(6, pegawai.getGelarDepan());
            statement.setString(7, pegawai.getGelarBelakang());
            statement.setString(8, pegawai.getAgama());
            statement.setDate(9, tglLahir);
            statement.setString(10, pegawai.getNoKtp());
            statement.setString(11, pegawai.getAlamat());
            statement.setString(12, pegawai.getTelRumah());
            statement.setString(13, pegawai.getNoPonsel());
            statement.setString(14, pegawai.getNIP());
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String NIP) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, NIP);
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
