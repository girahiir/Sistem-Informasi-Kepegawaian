/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilData;

import java.util.List;

/**
 *
 * @author lyandaf
 */
public interface DaoImplTampilPendidikan {

    public List<ModelTampilPendidikan> getAll();
     public List<ModelTampilPendidikan> getCari(String NIP);
}
