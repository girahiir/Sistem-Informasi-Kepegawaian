/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author lyandaf
 */
public class DaoTampilPendidikan implements DaoImplTampilPendidikan {

    Connection connection;
    final String select = " SELECT * FROM tbldatariwayatpend";
    final String search = "SELECT * from tbldatariwayatpend where NIP like ?";
    
    public DaoTampilPendidikan() {
        connection = Koneksi.connection();
    }

    @Override
    public List<ModelTampilPendidikan> getAll() {
        List<ModelTampilPendidikan> mtp = null;
        try {
            mtp = new ArrayList<ModelTampilPendidikan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelTampilPendidikan m = new ModelTampilPendidikan();
                m.setId(rs.getString("idRp"));
                m.setNIP(rs.getString("NIP"));
                m.setTingkatPendidikan(rs.getString("tingkatPendidikan"));
                m.setTempatPendidikan(rs.getString("tempatPendidikan"));
                m.setJurusan(rs.getString("jurusan"));
                m.setTglIjazah(rs.getString("tglIjazah"));
                m.setThnMasuk(rs.getInt("thnMasuk"));
                m.setThnLulus(rs.getInt("thnLulus"));
                mtp.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTampilPendidikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mtp;
    }

    /**
     *
     * @param NIP
     * @return
     */
    @Override
    public List<ModelTampilPendidikan> getCari(String NIP) {
      List<ModelTampilPendidikan> mtp = null;
        try {
            mtp = new ArrayList<ModelTampilPendidikan>();
            PreparedStatement st = connection.prepareStatement(search);
            st.setString(1, "%" + NIP + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ModelTampilPendidikan m = new ModelTampilPendidikan();
                m.setId(rs.getString("idRp"));
                m.setNIP(rs.getString("NIP"));
                m.setTingkatPendidikan(rs.getString("tingkatPendidikan"));
                m.setTempatPendidikan(rs.getString("tempatPendidikan"));
                m.setJurusan(rs.getString("jurusan"));
                m.setTglIjazah(rs.getString("tglIjazah"));
                m.setThnMasuk(rs.getInt("thnMasuk"));
                m.setThnLulus(rs.getInt("thnLulus"));
                mtp.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTampilPendidikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mtp;   
    }
}
