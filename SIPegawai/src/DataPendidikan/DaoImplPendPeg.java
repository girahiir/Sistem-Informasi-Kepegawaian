/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPendidikan;


import java.util.List;

/**
 *
 * @author lyandaf
 */
public interface DaoImplPendPeg {
    


    public void update(ModelPend mk);

    public List<ModelPend> getAll(String nip);
}
