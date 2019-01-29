/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Girah
 */
public interface DaoImplKelBK {

    public void insert(ModelKel mk);

    public void update(ModelKel mk);

    public List<ModelKel> getAll();
}
