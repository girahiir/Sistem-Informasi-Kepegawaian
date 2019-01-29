/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

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
public class DaoTampilKeluarga implements DaoImplTampilKeluarga {

    Connection connection;
    final String select = " SELECT * FROM tbldatakeluarga;";
    final String search = "SELECT * from tbldatakeluarga where NIP like ?";
    public DaoTampilKeluarga() {
        connection = Koneksi.connection();
    }

    @Override
    public List<ModelTampilKeluarga> getAll() {
        List<ModelTampilKeluarga> mtk = null;
        try {
            mtk = new ArrayList<ModelTampilKeluarga>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelTampilKeluarga mk = new ModelTampilKeluarga();
                mk.setIdKel(rs.getString("idDk"));
                mk.setNipKel(rs.getString("NIP"));
                mk.setAyah(rs.getString("namaAyah"));
                mk.setIbu(rs.getString("namaIbu"));
                mk.setSuami(rs.getString("namaIstri"));
                mk.setIstri(rs.getString("NamaSuami"));
                mk.setJmlAnak(rs.getInt("jumlahAnak"));
                mk.setKerjaSuami(rs.getString("pekerjaanSuami"));
                mk.setKerjaIstri(rs.getString("pekerjaanIstri"));
                mk.setKerjaAnak(rs.getString("pekerjaanAnak"));
                mtk.add(mk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTampilKeluarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mtk;
    }

    @Override
    public List<ModelTampilKeluarga> getCari(String NIP) {
        List<ModelTampilKeluarga> mtk = null;
        try {
            mtk = new ArrayList<ModelTampilKeluarga>();
            PreparedStatement st = connection.prepareStatement(search);
            st.setString(1, "%" + NIP + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ModelTampilKeluarga mk = new ModelTampilKeluarga();
                mk.setIdKel(rs.getString("idDk"));
                mk.setNipKel(rs.getString("NIP"));
                mk.setAyah(rs.getString("namaAyah"));
                mk.setIbu(rs.getString("namaIbu"));
                mk.setSuami(rs.getString("namaIstri"));
                mk.setIstri(rs.getString("NamaSuami"));
                mk.setJmlAnak(rs.getInt("jumlahAnak"));
                mk.setKerjaSuami(rs.getString("pekerjaanSuami"));
                mk.setKerjaIstri(rs.getString("pekerjaanIstri"));
                mk.setKerjaAnak(rs.getString("pekerjaanAnak"));
                mtk.add(mk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTampilKeluarga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mtk;
    }
}
