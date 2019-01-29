/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKeluarga;

import java.util.List;

/**
 *
 * @author Girah
 */
public interface DaoImplKelPeg {

    public void update(ModelKel mk);

    
    public List<ModelKel> getAll(String nip);
}
