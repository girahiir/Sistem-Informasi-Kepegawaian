/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
 * @author Girah
 */
public class DaoKelPeg implements DaoImplKelPeg{
    final String update = " UPDATE tbldatakeluarga set namaAyah =?,namaIbu=?,namaIstri=?,namaSuami=?,jumlahAnak=?,pekerjaanSuami=?,pekerjaanIstri=?,pekerjaanAnak =? where idDk=?;";
    final String select = " SELECT * FROM tbldatakeluarga";
    private final Connection connection;
    public DaoKelPeg() {
        connection = Koneksi.connection();
    }
    public void update(ModelKel mk) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mk.getAyah());
            statement.setString(2, mk.getIbu());
            statement.setString(3, mk.getSuami());
            statement.setString(4, mk.getIstri());
            statement.setString(5, mk.getAnak());
            statement.setString(6, mk.getKerjaSuami());
            statement.setString(7, mk.getKerjaIstri());
            statement.setString(8, mk.getKerjaAnak());
            statement.setString(9, mk.getId());
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

    public List<ModelKel> getAll() {
        List<ModelKel> mk = null;
        try {
            mk = new ArrayList<ModelKel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelKel m = new ModelKel();
                m.setId(rs.getString("idDk"));
                m.setAyah(rs.getString("namaAyah"));
                m.setIbu(rs.getString("namaIbu"));
                m.setSuami(rs.getString("namaIstri"));
                m.setIstri(rs.getString("NamaSuami"));
                m.setAnak(rs.getString("jumlahAnak"));
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
