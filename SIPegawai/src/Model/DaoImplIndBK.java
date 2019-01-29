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
public interface DaoImplIndBK {

    public void insert(ModelInd mi);

    public void update(ModelInd mi);

    public List<ModelInd> getAll();
}
