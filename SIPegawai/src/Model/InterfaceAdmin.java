/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Arsyadi Ahmad
 */
import java.util.List;
public interface InterfaceAdmin {
    public List<ModelAdmin> getAll();
    public void insert(ModelAdmin admin);
    public void update(ModelAdmin admin);
    public void delete(String NIP);
}
