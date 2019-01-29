/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;


//import static Entities.Tbldataindukpeg.nip;
import static EntitiesController.TbldataindukpegJpaController.Column.NIP;
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
public class DaoTampilInduk implements DaoImplTampilInduk {

    Connection connection;
    final String select = " SELECT * FROM tbldataindukpeg";
    final String search = "SELECT * from tbldataindukpeg where NIP like ?";

    public DaoTampilInduk() {
        connection = Koneksi.connection();
    }

    
    @Override
    public List<ModelTampilInduk> getAll() {
        List<ModelTampilInduk> mti = null;
        try {
            mti = new ArrayList<ModelTampilInduk>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelTampilInduk mi = new ModelTampilInduk();
                mi.setNip(rs.getString("NIP"));
                mi.setNama(rs.getString("Nama"));
                mi.setJk(rs.getString("JenisKelamin"));
                mi.setStatus(rs.getString("status"));
                mi.setGolDar(rs.getString("golDarah"));
                mi.setGelarDepan(rs.getString("gelarDepan"));
                mi.setGelarBelakang(rs.getString("gelarBelakang"));
                mi.setAgama(rs.getString("agama"));
                mi.setTempatLahir(rs.getString("tempatLahir"));
                mi.setTglLahir(rs.getString("tglLahir"));
                mi.setNoKtp(rs.getInt("noKtp"));
                mi.setAlamat(rs.getString("alamat"));
                mi.setNoTelp(rs.getString("telRumah"));
                mi.setNoPonsel(rs.getString("noPonsel"));
                mi.setTahunMasuk(rs.getInt("tahunMasuk"));
                mi.setIdPangkat(rs.getString("idPangkat"));
                mti.add(mi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTampilInduk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mti;
    }

     @Override
    public List<ModelTampilInduk> getCari(String NIP) {
     List<ModelTampilInduk> mti = null;
        try {
            mti = new ArrayList<ModelTampilInduk>();
            PreparedStatement st = connection.prepareStatement(search);
            st.setString(1, "%" + NIP + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ModelTampilInduk mi = new ModelTampilInduk();
                mi.setNip(rs.getString("NIP"));
                mi.setNama(rs.getString("Nama"));
                mi.setJk(rs.getString("JenisKelamin"));
                mi.setStatus(rs.getString("status"));
                mi.setGolDar(rs.getString("golDarah"));
                mi.setGelarDepan(rs.getString("gelarDepan"));
                mi.setGelarBelakang(rs.getString("gelarBelakang"));
                mi.setAgama(rs.getString("agama"));
                mi.setTempatLahir(rs.getString("tempatLahir"));
                mi.setTglLahir(rs.getString("tglLahir"));
                mi.setNoKtp(rs.getInt("noKtp"));
                mi.setAlamat(rs.getString("alamat"));
                mi.setNoTelp(rs.getString("telRumah"));
                mi.setNoPonsel(rs.getString("noPonsel"));
                mi.setTahunMasuk(rs.getInt("tahunMasuk"));
                mi.setIdPangkat(rs.getString("idPangkat"));
                mti.add(mi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTampilInduk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mti;   
    }

   
    }