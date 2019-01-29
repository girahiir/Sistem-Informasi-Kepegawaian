/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PengajuPensiun;

/**
 *
 * @author Dwi Lutfi
 */
import java.util.List;
public interface Rektor_DaoImpPens {
    public void update(ModelPensiun tp);
    public List<ModelPensiun> getAll();
}
