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
public interface DaoImplTampilInduk {

    public List<ModelTampilInduk> getAll();
    public List<ModelTampilInduk> getCari(String NIP);
}
