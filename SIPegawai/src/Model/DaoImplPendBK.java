/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ModelKel;
import java.util.List;
import View.*;

/**
 *
 * @author lyandaf
 */
public interface DaoImplPendBK {
    
    public void insert(ModelPend mk);

    public void update(ModelPend mk);

    public List<ModelPend> getAll();
}
