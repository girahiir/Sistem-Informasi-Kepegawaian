package DataInduk;

import DataInduk.DaoImplIndBK;
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Girah
 */
public class DaoIndBK implements DaoImplIndBK {

    Connection connection;
    final String insert = "INSERT INTO tbldataindukpeg (NIP,Nama,JenisKelamin,status,golDarah,gelarDepan,gelarBelakang,agama,tempatLahir,tglLahir,noKtp,alamat,telRumah,noPonsel,tahunMasuk,idPangkat) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    final String update = "UPDATE tbldataindukpeg set Nama=?,JenisKelamin=?,status=?,golDarah=?,gelarDepan=?,gelarBelakang=?,agama=?,tempatLahir=?,tglLahir=?,noKtp=?,alamat=?,telRumah=?,noPonsel=?,tahunMasuk=?,idPangkat=? where NIP=?;";
    final String select = "SELECT * FROM tbldataindukpeg";

    public DaoIndBK() {
        connection = Koneksi.connection();
    }

    public void insert(ModelInd mi) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, mi.getNip());
            statement.setString(2, mi.getNama());
            statement.setString(3, mi.getJk());
            statement.setString(4, mi.getStatus());
            statement.setString(5, mi.getGolDar());
            statement.setString(6, mi.getGelarDepan());
            statement.setString(7, mi.getGelarBelakang());
            statement.setString(8, mi.getAgama());
            statement.setString(9, mi.getTempatLahir());
            statement.setString(10, mi.getTglLahir());
            statement.setInt(11, mi.getNoKtp());
            statement.setString(12, mi.getAlamat());
            statement.setString(13, mi.getNoTelp());
            statement.setString(14, mi.getNoPonsel());
            statement.setInt(15, mi.getTahunMasuk());
            statement.setString(16, mi.getIdPangkat());
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

    public void update(ModelInd mi) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            
            statement.setString(1, mi.getNama());
            statement.setString(2, mi.getJk());
            statement.setString(3, mi.getStatus());
            statement.setString(4, mi.getGolDar());
            statement.setString(5, mi.getGelarDepan());
            statement.setString(6, mi.getGelarBelakang());
            statement.setString(7, mi.getAgama());
            statement.setString(8, mi.getTempatLahir());
            statement.setString(9, mi.getTglLahir());
            statement.setInt(10, mi.getNoKtp());
            statement.setString(11, mi.getAlamat());
            statement.setString(12, mi.getNoTelp());
            statement.setString(13, mi.getNoPonsel());
            statement.setInt(14, mi.getTahunMasuk());
            statement.setString(15, mi.getIdPangkat());
            statement.setString(16, mi.getNip());
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
    public List<ModelInd> getAll() {
        List<ModelInd> mi = null;
        try {
            mi = new ArrayList<ModelInd>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelInd m = new ModelInd();
                m.setNip(rs.getString("NIP"));
                m.setNama(rs.getString("Nama"));
                m.setJk(rs.getString("JenisKelamin"));
                m.setStatus(rs.getString("status"));
                m.setGolDar(rs.getString("golDarah"));
                m.setGelarDepan(rs.getString("gelarDepan"));
                m.setGelarBelakang(rs.getString("gelarBelakang"));
                m.setAgama(rs.getString("agama"));
                m.setTempatLahir(rs.getString("tempatLahir"));
                m.setTglLahir(rs.getString("tglLahir"));
                m.setNoKtp(rs.getInt("noKtp"));
                m.setAlamat(rs.getString("alamat"));
                m.setNoTelp(rs.getString("telRumah"));
                m.setNoPonsel(rs.getString("noPonsel"));
                m.setTahunMasuk(rs.getInt("tahunMasuk"));
                m.setIdPangkat(rs.getString("idPangkat"));
                mi.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoIndBK.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mi;

    }
}