/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

import java.util.List;

/**
 *
 * @author Girah
 */
public interface DaoImplTampilKeluarga {

    public List<ModelTampilKeluarga> getAll();
     public List<ModelTampilKeluarga> getCari(String NIP);
}
