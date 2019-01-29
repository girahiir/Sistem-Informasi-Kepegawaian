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
public class DaoPengajuPangkatRektor implements DaoImplPengajuPangkatRektor {

    Connection connection;
    final String update = "UPDATE tbldatapengajupangkat set NIP=?,pangkat_Lama=?,pangkat_baru=?,status=? where idPengajuPangkat=?;";
    final String select = "SELECT * FROM tbldatapengajupangkat";

    public DaoPengajuPangkatRektor() {
        connection = Koneksi.connection();
    }

    public void update(ModelPengajuPangkat mpp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(5, mpp.getId());
            statement.setString(1, mpp.getNip());
            statement.setString(2, mpp.getPangkatLama());
            statement.setString(3, mpp.getPangkatBaru());
            switch(mpp.getStatus()){
                case "DITOLAK":
                    statement.setString(4, "DITOLAK");
                    break;
                case "DITERIMA":
                    statement.setString(4, "DITERIMA");
                    break;
            }
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
                m.setNip(rs.getString("NIP"));
                System.out.println("NIP yang diambil:"+rs.getString("NIP"));
                m.setPangkatLama(rs.getString("pangkat_Lama"));
                m.setPangkatBaru(rs.getString("pangkat_baru"));
                m.setStatus(rs.getString("status"));
                m.setId(rs.getString("idPengajuPangkat"));
                mpp.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPengajuPangkatRektor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mpp;
    }
}
