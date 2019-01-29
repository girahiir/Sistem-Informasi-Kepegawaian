/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pesan;

import View.HalUtamaPegawai;
import View.HalUtamaBK;
/**
 *
 * @author lyandaf
 */
public class ControllerPesan {
    HalUtamaPegawai framePegawai;
    HalUtamaBK frameBK; 
    ImplPesan implPesan;
    ModelPesan modelPesan;

    public ControllerPesan(HalUtamaPegawai framePegawai) {
        this.framePegawai = framePegawai;
        implPesan = new DaoPesan();
        
//        modelPesan = implPesan.getAll()
    }
    
    public ControllerPesan(HalUtamaBK frameBK) {
        this.frameBK = frameBK;
        implPesan = new DaoPesan();
        
//        modelPesan = implPesan.getAll()
    }
    
    public void getPesan(){
        modelPesan = implPesan.getPesan(framePegawai.getNIPPegawai());
        framePegawai.gettxtPesanPegawai().setText(modelPesan.getIsiPesan());
    }
    
    public void tulisPesan(){
        modelPesan = new ModelPesan();
        modelPesan.setIsiPesan(frameBK.gettxtIsiPesanBK().getText());
        modelPesan.setNIP(frameBK.gettxtNipTujuanBK().getText());
        implPesan.tulisPesan(modelPesan);
        System.out.println("mencoba insert pesan");
    }
    
}
