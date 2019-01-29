/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PengajuPangkat;

import java.util.List;

/**
 *
 * @author Girah
 */
public interface DaoImplPengajuPangkat {

    public void insert(ModelPengajuPangkat mpp);

    public List<ModelPengajuPangkat> getAll();
}
