/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPangkat;

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
public class DaoPengajuPangkat implements DaoImplPengajuPangkat {

    Connection connection;
    final String insert = " INSERT INTO tbldatapengajupangkat(idPengajuPangkat,NIP,pangkat_Lama,pangkat_baru,status) VALUES(?,?,?,?,?); ";
    final String select = " SELECT * FROM tbldatapengajupangkat ";

    public DaoPengajuPangkat() {
        connection = Koneksi.connection();
    }

    public void insert(ModelPengajuPangkat mpp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, mpp.getId());
            statement.setString(2, mpp.getNip());
            statement.setString(3, mpp.getPangkatLama());
            statement.setString(4, mpp.getPangkatBaru());
            statement.setString(5, mpp.getStatus());
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

    public List<ModelPengajuPangkat> getAll() {
        List<ModelPengajuPangkat> mpp = null;
        try {
            mpp = new ArrayList<ModelPengajuPangkat>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelPengajuPangkat m = new ModelPengajuPangkat();
                m.setId(rs.getString("idPengajuPangkat"));
                m.setNip(rs.getString("NIP"));
                m.setPangkatLama(rs.getString("pangkat_Lama"));
                m.setPangkatBaru(rs.getString("pangkat_baru"));
                m.setStatus(rs.getString("status"));
                mpp.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPengajuPangkat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mpp;
    }
}
