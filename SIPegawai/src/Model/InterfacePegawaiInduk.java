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
public interface InterfacePegawaiInduk {
    public List<ModelPegawaiInduk> getAll();
    public void insert (ModelPegawaiInduk pegawai);
    public void update (ModelPegawaiInduk pegawai);
    public void delete (String NIP);
}
