/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInduk;

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
 * @author Girah
 */
public class DaoIndPeg implements DaoImplIndPeg {

    Connection connection;
    final String update = " UPDATE tbldataindukpeg set Nama=?,JenisKelamin=?,status=?,golDarah=?,gelarDepan=?,gelarBelakang=?,agama=?,tempatLahir=?,tglLahir=?,noKtp=?,alamat=?,telRumah=?,noPonsel=? where NIP=?;";
    final String select = " SELECT * FROM tbldataindukpeg WHERE NIP = ?";

    public DaoIndPeg() {
        connection = Koneksi.connection();
    }
    

    @Override
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
            statement.setString(14, mi.getNip());
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
    public List<ModelInd> getAll(String nip) {
        List<ModelInd> mi = null;
        try {
            mi = new ArrayList<ModelInd>();
            PreparedStatement st = connection.prepareStatement(select);
            st.setString(1, nip);
            System.out.println(nip);
            ResultSet rs = st.executeQuery();
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

                mi.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoIndBK.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mi;

    }
}
