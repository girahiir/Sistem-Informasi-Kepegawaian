/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKeluarga;

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
public class DaoKelPeg implements DaoImplKelPeg {

    final String update = " UPDATE tbldatakeluarga set NIP=?,namaAyah =?,namaIbu=?,namaIstri=?,namaSuami=?,jumlahAnak=?,pekerjaanSuami=?,pekerjaanIstri=?,pekerjaanAnak =? where idDk=?;";
    final String select = " SELECT * FROM tbldatakeluarga WHERE NIP=?;";
    private final Connection connection;

    public DaoKelPeg() {
        connection = Koneksi.connection();
    }

    public void update(ModelKel mk) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mk.getNipKel());
            statement.setString(2, mk.getAyah());
            statement.setString(3, mk.getIbu());
            statement.setString(4, mk.getIstri());
            statement.setString(5, mk.getSuami());
            statement.setInt(6, mk.getJmlAnak());
            statement.setString(7, mk.getKerjaSuami());
            statement.setString(8, mk.getKerjaIstri());
            statement.setString(9, mk.getKerjaAnak());
            statement.setString(10, mk.getIdKel());
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

    public List<ModelKel> getAll(String nip) {
        List<ModelKel> mk = null;
        try {
            mk = new ArrayList<ModelKel>();
            PreparedStatement st = connection.prepareStatement(select);
            st.setString(1, nip);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ModelKel m = new ModelKel();
                m.setIdKel(rs.getString("idDk"));
                m.setNipKel(rs.getString("NIP"));
                m.setAyah(rs.getString("namaAyah"));
                m.setIbu(rs.getString("namaIbu"));
                m.setIstri(rs.getString("NamaIstri"));
                m.setSuami(rs.getString("namaSuami"));
                m.setJmlAnak(rs.getInt("jumlahAnak"));
                m.setKerjaSuami(rs.getString("pekerjaanSuami"));
                m.setKerjaIstri(rs.getString("pekerjaanIstri"));
                m.setKerjaAnak(rs.getString("pekerjaanAnak"));
                mk.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoKelBK.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mk;

    }
}
