/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Tbldataindukpeg;
import EntitiesController.TbldataindukpegJpaController;
import EntitiesController.TbldatariwayatpendJpaController;
import PengajuPangkat.ControllerPengajuPangkatRektor;
import PengajuPensiun.Rektor_ControllerPengPens;
import PengajuPensiun.Rektor_PengajuPensiunRektor;
import java.awt.BorderLayout;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Girah Ihtama
 */

 
public class HalUtamaRektor extends javax.swing.JFrame {

    /**
     * Creates new form HalUtamaRektor

*/
    ControllerPengajuPangkatRektor controllerPengajuPangkatRektor;
    Rektor_ControllerPengPens controllerPengajuPensiunRektor;
    
    public HalUtamaRektor() {
        initComponents();
        controllerPengajuPensiunRektor = new Rektor_ControllerPengPens(this);
        controllerPengajuPangkatRektor = new ControllerPengajuPangkatRektor(this);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("kbjosPU");
        TbldataindukpegJpaController tdi = new TbldataindukpegJpaController(emf);
        TbldatariwayatpendJpaController tdrp = new TbldatariwayatpendJpaController(emf);
        
        System.out.println("Jumlah Pegawai: " + tdi.getTbldataindukpegCount());
        lbltotal.setText(Integer.toString(tdi.getTbldataindukpegCount()));
        lbltotal1.setText(Integer.toString(tdi.getTbldataindukpegCount()));
        lbltotal2.setText(Integer.toString(tdi.getTbldataindukpegCount()));
        lbltotal3.setText(Integer.toString(tdi.getTbldataindukpegCount()));
        lbltotal4.setText(Integer.toString(tdi.getTbldataindukpegCount()));
        List<Entities.Tbldataindukpeg> totalPria = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        lbltotalPria.setText(Integer.toString(totalPria.size()));
        lbltotalPria1.setText(Integer.toString(totalPria.size()));
        lbltotalPria2.setText(Integer.toString(totalPria.size()));
        lbltotalPria3.setText(Integer.toString(totalPria.size()));
        lbltotalPria4.setText(Integer.toString(totalPria.size()));
        List<Entities.Tbldataindukpeg> totalWanita = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        lbltotalWanita.setText(Integer.toString(totalWanita.size()));
        lbltotalWanita1.setText(Integer.toString(totalWanita.size()));
        lbltotalWanita2.setText(Integer.toString(totalWanita.size()));
        lbltotalWanita3.setText(Integer.toString(totalWanita.size()));
        lbltotalWanita4.setText(Integer.toString(totalWanita.size()));
        //agama
        //System.out.println("Statistik Agama");
        List<Entities.Tbldataindukpeg> islam = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Islam");
        //System.out.println("Pegawai yang beragama Islam >>" + islam.size());
        
        List<Entities.Tbldataindukpeg> islamPria = tdi.findTbldataindukpegBy(islam, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang beragama Islam - Pria >>" + islamPria.size());
        lblislamPria.setText(Integer.toString(islamPria.size()));
        List<Entities.Tbldataindukpeg> islamWanita = tdi.findTbldataindukpegBy(islam, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang beragama Islam - Wanita >>" + islamWanita.size());
        lblislamWanita.setText(Integer.toString(islamWanita.size()));
        
        List<Entities.Tbldataindukpeg> Kristen = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Kristen");
        //System.out.println("Pegawai yang beragama Kristen >>" + Kristen.size());
        List<Entities.Tbldataindukpeg> kristenPria = tdi.findTbldataindukpegBy(Kristen, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang beragama Kristen - Pria >>" + kristenPria.size());
        lblkristenPria.setText(Integer.toString(kristenPria.size()));
        List<Entities.Tbldataindukpeg> kristenWanita = tdi.findTbldataindukpegBy(Kristen, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang beragama Kristen - Wanita >>" + kristenWanita.size());
        lblkristenWanita.setText(Integer.toString(kristenWanita.size()));
        
        List<Entities.Tbldataindukpeg> Katolik = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Katolik");
        //System.out.println("Pegawai yang beragama Katolik >>" + Katolik.size());
        List<Entities.Tbldataindukpeg> katolikPria = tdi.findTbldataindukpegBy(Katolik, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang beragama Katolik - Pria >>" + katolikPria.size());
        lblkatolikPria.setText(Integer.toString(katolikPria.size()));
        List<Entities.Tbldataindukpeg> katolikWanita = tdi.findTbldataindukpegBy(Katolik, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang beragama Katolik - Wanita >>" + katolikWanita.size());
        lblkatolikWanita.setText(Integer.toString(katolikWanita.size()));
        
        List<Entities.Tbldataindukpeg> Hindu = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Hindu");
        //System.out.println("Pegawai yang beragama Hindu >>" + Hindu.size());
        List<Entities.Tbldataindukpeg> hinduPria = tdi.findTbldataindukpegBy(Hindu, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang beragama Hindu - Pria >>" + hinduPria.size());
        lblhinduPria.setText(Integer.toString(hinduPria.size()));
        List<Entities.Tbldataindukpeg> hinduWanita = tdi.findTbldataindukpegBy(Hindu, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang beragama Hindu - Wanita >>" + hinduWanita.size());
        lblhinduWanita.setText(Integer.toString(hinduWanita.size()));
        
        List<Entities.Tbldataindukpeg> Budha = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Budha");
        //System.out.println("Pegawai yang beragama Budha >>" + Budha.size());
        List<Entities.Tbldataindukpeg> budhaPria = tdi.findTbldataindukpegBy(Budha, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang beragama Budha - Pria >>" + budhaPria.size());
        lblbudhaPria.setText(Integer.toString(budhaPria.size()));
        List<Entities.Tbldataindukpeg> budhaWanita = tdi.findTbldataindukpegBy(Budha, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang beragama Budha - Wanita >>" + budhaWanita.size());
        lblbudhaWanita.setText(Integer.toString(budhaWanita.size()));
        System.out.println("");
        
        //golongan darah
        //System.out.println("Statistik Golongan Darah");
        List<Entities.Tbldataindukpeg> golA = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "A");
        //System.out.println("Pegawai yang memiliki golongan darah A >>" + golA.size());
        List<Entities.Tbldataindukpeg> golAPria = tdi.findTbldataindukpegBy(golA, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang memiliki golongan darah A - Pria >>" + golAPria.size());
        lblAPria.setText(Integer.toString(golAPria.size()));
        List<Entities.Tbldataindukpeg> golAWanita = tdi.findTbldataindukpegBy(golA, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang memiliki golongan darah A - Wanita >>" + golAWanita.size());
        lblAWanita.setText(Integer.toString(golAWanita.size()));
        
        List<Entities.Tbldataindukpeg> golB = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "B");
        //System.out.println("Pegawai yang memiliki golongan dara B >>" + golB.size());
        List<Entities.Tbldataindukpeg> golBPria = tdi.findTbldataindukpegBy(golB, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang memiliki golongan dara B - Pria >>" + golBPria.size());
        lblBPria.setText(Integer.toString(golBPria.size()));
        List<Entities.Tbldataindukpeg> golBWanita = tdi.findTbldataindukpegBy(golB, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang memiliki golongan dara B - Wanita >>" + golBWanita.size());
        lblBWanita.setText(Integer.toString(golBWanita.size()));
        
        List<Entities.Tbldataindukpeg> golO = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "O");
        //System.out.println("Pegawai yang memiliki golongan dara O >>" + golO.size());
        List<Entities.Tbldataindukpeg> golOPria = tdi.findTbldataindukpegBy(golO, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang memiliki golongan dara O - Pria >>" + golOPria.size());
        lblOPria.setText(Integer.toString(golOPria.size()));
        List<Entities.Tbldataindukpeg> golOWanita = tdi.findTbldataindukpegBy(golO, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang memiliki golongan dara O - Wanita >>" + golOWanita.size());
        lblOWanita.setText(Integer.toString(golOWanita.size()));
        
        List<Entities.Tbldataindukpeg> golAB = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "AB");System.out.println("Pegawai yang memiliki golongan dara AB >>" + golAB.size());
        List<Entities.Tbldataindukpeg> golABPria = tdi.findTbldataindukpegBy(golAB, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai yang memiliki golongan dara AB - Pria >>" + golABPria.size());
        lblABPria.setText(Integer.toString(golABPria.size()));
        List<Entities.Tbldataindukpeg> golABWanita = tdi.findTbldataindukpegBy(golAB, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai yang memiliki golongan dara AB - Wanita >>" + golABWanita.size());
        lblABWanita.setText(Integer.toString(golABWanita.size()));
        System.out.println("");
        
        //golongan pangkat - belum sepenuhnya
//        List<Entities.Tbldataindukpeg> golIA = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "P01");
//        List<Entities.Tbldataindukpeg> golIB = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "P01");
//        List<Entities.Tbldataindukpeg> golIC = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "P01");
//        List<Entities.Tbldataindukpeg> golID = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "P01");
//        int golI =  golIA.size() + golIB.size() + golIC.size() + golID.size() ;
//        System.out.println("Pegawai Golongan I >>" + golIA.size());
//        List<Entities.Tbldataindukpeg> golII = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "B");
//        System.out.println("Pegawai Golongan II >>" + golII.size());
//        List<Entities.Tbldataindukpeg> golIII = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "O");
//        System.out.println("Pegawai Golongan III >>" + golIII.size());
//        List<Entities.Tbldataindukpeg> golIV = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "AB");
//        System.out.println("Pegawai Golongan IV >>" + golIV.size());
//        System.out.println("");
        
        //tingkat pendidikan
        System.out.println("Statistik Pendidikan");
        List<Entities.Tbldatariwayatpend> golSD = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "SD");
        //System.out.println("Pegawai dengan pendidikan terakhir SD >>" + golSD.size());
        List<Entities.Tbldataindukpeg> golSD_dataInduk = tdrp.getTbldataindukpeg(golSD);
        List<Tbldataindukpeg> golSDPria = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai dengan pendidikan terakhir SD - Pria >>" + golSDPria.size());
        lblSdPria.setText(Integer.toString(golSDPria.size()));
        List<Tbldataindukpeg> golSDWanita = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai dengan pendidikan terakhir SD - Wanita >>" + golSDWanita.size());
        lblSdWanita.setText(Integer.toString(golSDWanita.size()));
        
        List<Entities.Tbldatariwayatpend> golSMP = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "SMP");
        //System.out.println("Pegawai dengan pendidikan terakhir SMP >>" + golSMP.size());
        List<Entities.Tbldataindukpeg> golSMP_dataInduk = tdrp.getTbldataindukpeg(golSMP);
        List<Tbldataindukpeg> golSMPPria = tdi.findTbldataindukpegBy(golSMP_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai dengan pendidikan terakhir SMP - Pria >>" + golSDPria.size());
        lblSmpPria.setText(Integer.toString(golSMPPria.size()));
        List<Tbldataindukpeg> golSMPWanita = tdi.findTbldataindukpegBy(golSMP_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai dengan pendidikan terakhir SMP - Wanita >>" + golSDWanita.size());
        lblSmpWanita.setText(Integer.toString(golSMPWanita.size()));
        
        List<Entities.Tbldatariwayatpend> golSMA = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "SMA");
        //System.out.println("Pegawai dengan pendidikan terakhir SMA >>" + golSMA.size());
        List<Entities.Tbldataindukpeg> golSMA_dataInduk = tdrp.getTbldataindukpeg(golSMA);
        List<Tbldataindukpeg> golSMAPria = tdi.findTbldataindukpegBy(golSMA_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai dengan pendidikan terakhir SMA - Pria >>" + golSDPria.size());
        lblSmaPria.setText(Integer.toString(golSMAPria.size()));
        List<Tbldataindukpeg> golSMAWanita = tdi.findTbldataindukpegBy(golSMA_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai dengan pendidikan terakhir SMA - Wanita >>" + golSDWanita.size());
        lblSmaWanita.setText(Integer.toString(golSMAWanita.size()));
        
        List<Entities.Tbldatariwayatpend> golS1 = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "S1");
        //System.out.println("Pegawai dengan pendidikan terakhir S1 >>" + golS1.size());
        List<Entities.Tbldataindukpeg> golS1_dataInduk = tdrp.getTbldataindukpeg(golS1);
        List<Tbldataindukpeg> golS1Pria = tdi.findTbldataindukpegBy(golS1_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai dengan pendidikan terakhir S1 - Pria >>" + golS1Pria.size());
        lblS1Pria.setText(Integer.toString(golS1Pria.size()));
        List<Tbldataindukpeg> golS1Wanita = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai dengan pendidikan terakhir S1 - Wanita >>" + golS1Wanita.size());
        lblS1Wanita.setText(Integer.toString(golS1Wanita.size()));
        
        List<Entities.Tbldatariwayatpend> golS2 = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "S2");
        //System.out.println("Pegawai dengan pendidikan terakhir S2 >>" + golS2.size());
        List<Entities.Tbldataindukpeg> golS2_dataInduk = tdrp.getTbldataindukpeg(golS2);
        List<Tbldataindukpeg> golS2Pria = tdi.findTbldataindukpegBy(golS2_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai dengan pendidikan terakhir S2 - Pria >>" + golS2Pria.size());
        lblS2Pria.setText(Integer.toString(golS2Pria.size()));
        List<Tbldataindukpeg> golS2Wanita = tdi.findTbldataindukpegBy(golS2_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai dengan pendidikan terakhir S2 - Wanita >>" + golS2Wanita.size());
        lblS2Wanita.setText(Integer.toString(golS2Wanita.size()));
        
        List<Entities.Tbldatariwayatpend> golS3 = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "S3");
        //System.out.println("Pegawai dengan pendidikan terakhir S3 >>" + golS3.size());
        List<Entities.Tbldataindukpeg> golS3_dataInduk = tdrp.getTbldataindukpeg(golS3);
        List<Tbldataindukpeg> golS3Pria = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        //System.out.println("-Pegawai dengan pendidikan terakhir S3 - Pria >>" + golS3Pria.size());
        lblS3Pria.setText(Integer.toString(golS3Pria.size()));
        List<Tbldataindukpeg> golS3Wanita = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        //System.out.println("-Pegawai dengan pendidikan terakhir S3 - Wanita >>" + golS3Wanita.size());        
        lblS3Wanita.setText(Integer.toString(golS3Wanita.size()));
        System.out.println("");
        
        //umur
        System.out.println("");
    }
    
    
    /////// NAIK PANGKAT ////////
    public JTextField gettxtIdPangkatRektor(){
        return txtIdPangkatRektor;
    }
    public JTextField gettxtNipPangkatRektor(){
        return txtNipPangkatRektor;
    }
     public JTextField gettxtPangkatLama(){
        return txtPangkatLama;
    }
     public JTextField gettxttxtPangkatBaru(){
        return txtPangkatBaru;
    }
     public JComboBox getcmbStatus(){
        return cmbStatus;
    }
     public JButton getbtnUpdatePangkatRektor(){
        return btnUpdatePangkatRektor;
    }
      public JTable gettabelDataPengajuPangkatRek(){
        return tabelDataPengajuPangkatRek;
    }
      
      ///// PENSIUN ///
      public JComboBox getCmbAksi() {
        return cmbAksi;
    }

    public JButton getCmdVerifikasi() {
        return cmdVerifikasi;
    }

    public JTable getTblDataPensR() {
        return tblDataPensR;
    }

    public JTextField getTxtIDPensR() {
        return txtIDPensR;
    }

    public JTextField getTxtNipPensR() {
        return txtNipPensR;
    }

    public JTable tblDataPensR(){
        return tblDataPensR;
    }
     
     
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSlider1 = new diu.swe.habib.JPanelSlider.JPanelSlider();
        panel1HomeRektor = new usu.widget.glass.PanelGlass();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelGlass2StatistikNaik = new usu.widget.glass.PanelGlass();
        panelGlass3StatistikAgama = new usu.widget.glass.PanelGlass();
        lblislamPria = new javax.swing.JLabel();
        lblislamWanita = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        lblkristenPria = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblkristenWanita = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbltotalPria = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbltotalWanita = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lblkatolikPria = new javax.swing.JLabel();
        lblkatolikWanita = new javax.swing.JLabel();
        lblhinduPria = new javax.swing.JLabel();
        lblhinduWanita = new javax.swing.JLabel();
        lblbudhaPria = new javax.swing.JLabel();
        lblbudhaWanita = new javax.swing.JLabel();
        panelGlass4StatistikGolongan = new usu.widget.glass.PanelGlass();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        lbltotalWanita1 = new javax.swing.JLabel();
        lbltotalPria1 = new javax.swing.JLabel();
        lbltotal1 = new javax.swing.JLabel();
        panelGlass5StatistikUmur = new usu.widget.glass.PanelGlass();
        jLabel76 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        lbltotalWanita2 = new javax.swing.JLabel();
        lbltotalPria2 = new javax.swing.JLabel();
        lbltotal2 = new javax.swing.JLabel();
        panelGlass6StatistikGoldar = new usu.widget.glass.PanelGlass();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        lblBPria = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        lblAPria = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        lblAWanita = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        lblABPria = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        lblABWanita = new javax.swing.JLabel();
        lblOPria = new javax.swing.JLabel();
        lblOWanita = new javax.swing.JLabel();
        lblBWanita = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        lbltotalWanita3 = new javax.swing.JLabel();
        lbltotalPria3 = new javax.swing.JLabel();
        lbltotal3 = new javax.swing.JLabel();
        panelGlass7StatistikPendidikan = new usu.widget.glass.PanelGlass();
        jLabel135 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        lblS2Pria = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        lblS1Pria = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        lblS1Wanita = new javax.swing.JLabel();
        lblSmaPria = new javax.swing.JLabel();
        lblSmaWanita = new javax.swing.JLabel();
        lblSmpPria = new javax.swing.JLabel();
        lblS2Wanita = new javax.swing.JLabel();
        lblSmpWanita = new javax.swing.JLabel();
        S2 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        lblS3Pria = new javax.swing.JLabel();
        lblS3Wanita = new javax.swing.JLabel();
        lbltotalWanita4 = new javax.swing.JLabel();
        lbltotalPria4 = new javax.swing.JLabel();
        lbltotal4 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        lblSdWanita = new javax.swing.JLabel();
        lblSdPria = new javax.swing.JLabel();
        S3 = new javax.swing.JLabel();
        panel8PengajuNaik = new usu.widget.glass.PanelGlass();
        jScrollPane14 = new javax.swing.JScrollPane();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        jLabel177 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        txtIdPangkatRektor = new javax.swing.JTextField();
        txtNipPangkatRektor = new javax.swing.JTextField();
        txtPangkatLama = new javax.swing.JTextField();
        txtPangkatBaru = new javax.swing.JTextField();
        btnUpdatePangkatRektor = new javax.swing.JButton();
        jLabel179 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabelDataPengajuPangkatRek = new javax.swing.JTable();
        cmbStatus = new javax.swing.JComboBox();
        panel9PengajuPensiun = new usu.widget.glass.PanelGlass();
        jScrollPane15 = new javax.swing.JScrollPane();
        panelGlass3 = new usu.widget.glass.PanelGlass();
        jLabel200 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        txtIDPensR = new javax.swing.JTextField();
        txtNipPensR = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDataPensR = new javax.swing.JTable();
        cmbAksi = new javax.swing.JComboBox();
        cmdVerifikasi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuStatistik = new javax.swing.JMenu();
        btnStatistikAgama = new javax.swing.JMenuItem();
        btnStatistikGoldar = new javax.swing.JMenuItem();
        btnStatistikPendidikan = new javax.swing.JMenuItem();
        btnPengajuNaik = new javax.swing.JMenu();
        btnPengajuPensiun = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Halaman Rektor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSlider1.setBorder(null);
        jPanelSlider1.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel7.setText("SISTEM INFORMASI REKTOR");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel8.setText("SELAMAT DATANG");

        javax.swing.GroupLayout panel1HomeRektorLayout = new javax.swing.GroupLayout(panel1HomeRektor);
        panel1HomeRektor.setLayout(panel1HomeRektorLayout);
        panel1HomeRektorLayout.setHorizontalGroup(
            panel1HomeRektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1HomeRektorLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(105, 105, 105))
            .addGroup(panel1HomeRektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1HomeRektorLayout.createSequentialGroup()
                    .addContainerGap(236, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(180, 180, 180)))
        );
        panel1HomeRektorLayout.setVerticalGroup(
            panel1HomeRektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1HomeRektorLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel7)
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(panel1HomeRektorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1HomeRektorLayout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jLabel8)
                    .addContainerGap(232, Short.MAX_VALUE)))
        );

        jPanelSlider1.add(panel1HomeRektor, "card2");

        panelGlass2StatistikNaik.setOpaqueImage(false);

        javax.swing.GroupLayout panelGlass2StatistikNaikLayout = new javax.swing.GroupLayout(panelGlass2StatistikNaik);
        panelGlass2StatistikNaik.setLayout(panelGlass2StatistikNaikLayout);
        panelGlass2StatistikNaikLayout.setHorizontalGroup(
            panelGlass2StatistikNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        panelGlass2StatistikNaikLayout.setVerticalGroup(
            panelGlass2StatistikNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panelGlass2StatistikNaik, "card18");

        panelGlass3StatistikAgama.setOpaqueImage(false);

        lblislamPria.setText("LakiIslam");

        lblislamWanita.setText("PerempuanIslam");

        lbltotal.setText("angka total");

        lblkristenPria.setText("LakiKristen");

        jLabel21.setText("Statistik Data Pegawai");

        lblkristenWanita.setText("PerempuanKristen");

        jLabel23.setText("Islam");

        jLabel24.setText("Total");

        jLabel25.setText("a. Laki-Laki");

        jLabel26.setText("Laki-Laki");

        jLabel27.setText("b. Perempuan");

        jLabel28.setText("Perempuan");

        jLabel29.setText("Kristen");

        lbltotalPria.setText("angka total laki");

        jLabel31.setText("a. Laki-Laki");

        lbltotalWanita.setText("angka total perempuan");

        jLabel33.setText("b. Perempuan");

        jLabel34.setText("Katolik");

        jLabel35.setText("a. Laki-Laki");

        jLabel36.setText("b. Perempuan");

        jLabel37.setText("Hindu");

        jLabel38.setText("a. Laki-Laki");

        jLabel39.setText("b. Perempuan");

        jLabel40.setText("Budha");

        jLabel41.setText("a. Laki-Laki");

        jLabel42.setText("b. Perempuan");

        lblkatolikPria.setText("LakiKatolik");

        lblkatolikWanita.setText("PerempuanKatolik");

        lblhinduPria.setText("LakiHindu");

        lblhinduWanita.setText("PerempuanHindu");

        lblbudhaPria.setText("LakiBudha");

        lblbudhaWanita.setText("PerempuanBudha");

        javax.swing.GroupLayout panelGlass3StatistikAgamaLayout = new javax.swing.GroupLayout(panelGlass3StatistikAgama);
        panelGlass3StatistikAgama.setLayout(panelGlass3StatistikAgamaLayout);
        panelGlass3StatistikAgamaLayout.setHorizontalGroup(
            panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel29)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37)
                            .addComponent(jLabel40)
                            .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42))
                                .addGap(77, 77, 77)
                                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblbudhaWanita)
                                    .addComponent(lblbudhaPria)
                                    .addComponent(lblhinduWanita)
                                    .addComponent(lblhinduPria)
                                    .addComponent(lblkatolikWanita)
                                    .addComponent(lblkatolikPria)
                                    .addComponent(lblkristenWanita)
                                    .addComponent(lblkristenPria)
                                    .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblislamWanita)
                                            .addComponent(lblislamPria))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                                                .addGap(164, 164, 164)
                                                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbltotalPria)
                                                    .addComponent(lbltotalWanita)
                                                    .addComponent(lbltotal)))
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel28)))))))
                    .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass3StatistikAgamaLayout.setVerticalGroup(
            panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(lblislamPria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(lblislamWanita)))
                    .addGroup(panelGlass3StatistikAgamaLayout.createSequentialGroup()
                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(lbltotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lbltotalPria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(lbltotalWanita))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblkristenPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblkristenWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblkatolikPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lblkatolikWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lblhinduPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lblhinduWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lblbudhaPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3StatistikAgamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(lblbudhaWanita))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass3StatistikAgama, "card19");

        panelGlass4StatistikGolongan.setOpaqueImage(false);

        jLabel49.setText("LakiII");

        jLabel50.setText("Statistik Data Pegawai");

        jLabel51.setText("LakiIII");

        jLabel52.setText("PerempuanIII");

        jLabel53.setText("LakiIV");

        jLabel54.setText("PerempuanIV");

        jLabel55.setText("PerempuanKII");

        jLabel56.setText("Golongan I");

        jLabel57.setText("Total");

        jLabel58.setText("a. Laki-Laki");

        jLabel59.setText("Laki-Laki");

        jLabel60.setText("b. Perempuan");

        jLabel61.setText("Perempuan");

        jLabel62.setText("Golongan II");

        jLabel64.setText("a. Laki-Laki");

        jLabel66.setText("Golongan III");

        jLabel67.setText("b. Perempuan");

        jLabel68.setText("a. Laki-Laki");

        jLabel69.setText("b. Perempuan");

        jLabel70.setText("Golongan IV");

        jLabel71.setText("a. Laki-Laki");

        jLabel72.setText("b. Perempuan");

        jLabel73.setText("LakiI");

        jLabel74.setText("PerempuanI");

        lbltotalWanita1.setText("angka total perempuan");

        lbltotalPria1.setText("angka total laki");

        lbltotal1.setText("angka total");

        javax.swing.GroupLayout panelGlass4StatistikGolonganLayout = new javax.swing.GroupLayout(panelGlass4StatistikGolongan);
        panelGlass4StatistikGolongan.setLayout(panelGlass4StatistikGolonganLayout);
        panelGlass4StatistikGolonganLayout.setHorizontalGroup(
            panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel62)
                            .addComponent(jLabel66)
                            .addComponent(jLabel70)
                            .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel72))
                                .addGap(77, 77, 77)
                                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel49)
                                    .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                                        .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel74)
                                            .addComponent(jLabel73))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                        .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel57)
                                            .addComponent(jLabel59)
                                            .addComponent(jLabel61))
                                        .addGap(100, 100, 100)
                                        .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbltotalPria1)
                                            .addComponent(lbltotalWanita1)
                                            .addComponent(lbltotal1)))))))
                    .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass4StatistikGolonganLayout.setVerticalGroup(
            panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jLabel73))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jLabel74)))
                    .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61))
                    .addGroup(panelGlass4StatistikGolonganLayout.createSequentialGroup()
                        .addComponent(lbltotal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalPria1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalWanita1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4StatistikGolonganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel54))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass4StatistikGolongan, "card20");

        panelGlass5StatistikUmur.setOpaqueImage(false);

        jLabel76.setText("25 - 35");

        jLabel78.setText("a. Laki-Laki");

        jLabel80.setText("35 - 45");

        jLabel81.setText("LakiII");

        jLabel82.setText("b. Perempuan");

        jLabel83.setText("Statistik Data Pegawai");

        jLabel84.setText("a. Laki-Laki");

        jLabel85.setText("a. Laki-Laki");

        jLabel86.setText("b. Perempuan");

        jLabel87.setText("b. Perempuan");

        jLabel88.setText("45 - 55");

        jLabel89.setText("LakiIII");

        jLabel90.setText("a. Laki-Laki");

        jLabel91.setText("PerempuanIII");

        jLabel92.setText("LakiIV");

        jLabel93.setText("PerempuanIV");

        jLabel94.setText("LakiV");

        jLabel95.setText("PerempuanKII");

        jLabel96.setText("PerempuanV");

        jLabel97.setText("<25");

        jLabel98.setText("Total");

        jLabel99.setText("a. Laki-Laki");

        jLabel100.setText("Laki-Laki");

        jLabel101.setText("b. Perempuan");

        jLabel102.setText("Perempuan");

        jLabel103.setText("b. Perempuan");

        jLabel104.setText("55 - 65");

        jLabel105.setText("LakiI");

        jLabel106.setText("PerempuanI");

        lbltotalWanita2.setText("angka total perempuan");

        lbltotalPria2.setText("angka total laki");

        lbltotal2.setText("angka total");

        javax.swing.GroupLayout panelGlass5StatistikUmurLayout = new javax.swing.GroupLayout(panelGlass5StatistikUmur);
        panelGlass5StatistikUmur.setLayout(panelGlass5StatistikUmurLayout);
        panelGlass5StatistikUmurLayout.setHorizontalGroup(
            panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97)
                            .addComponent(jLabel76)
                            .addComponent(jLabel80)
                            .addComponent(jLabel88)
                            .addComponent(jLabel104)
                            .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel99)
                                    .addComponent(jLabel101)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel82)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel86)
                                    .addComponent(jLabel90)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel85)
                                    .addComponent(jLabel87))
                                .addGap(77, 77, 77)
                                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel96)
                                    .addComponent(jLabel94)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel92)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel89)
                                    .addComponent(jLabel95)
                                    .addComponent(jLabel81)
                                    .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                                        .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel106)
                                            .addComponent(jLabel105))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                        .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel98)
                                            .addComponent(jLabel100)
                                            .addComponent(jLabel102))
                                        .addGap(100, 100, 100)
                                        .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbltotalPria2)
                                            .addComponent(lbltotalWanita2)
                                            .addComponent(lbltotal2)))))))
                    .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass5StatistikUmurLayout.setVerticalGroup(
            panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jLabel105))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel101)
                            .addComponent(jLabel106)))
                    .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel102))
                    .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                        .addComponent(lbltotal2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalPria2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalWanita2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel81))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jLabel89))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel91))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jLabel92))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel104)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jLabel94))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel96))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass5StatistikUmur, "card21");

        panelGlass6StatistikGoldar.setOpaqueImage(false);

        jLabel108.setText("Laki-Laki");

        jLabel109.setText("b. Perempuan");

        jLabel110.setText("AB");

        jLabel111.setText("Perempuan");

        lblBPria.setText("LakiII");

        jLabel113.setText("b. Perempuan");

        jLabel114.setText("b. Perempuan");

        jLabel115.setText("Statistik Data Pegawai");

        lblAPria.setText("LakiI");

        jLabel117.setText("a. Laki-Laki");

        lblAWanita.setText("PerempuanI");

        jLabel120.setText("b. Perempuan");

        jLabel121.setText("O");

        lblABPria.setText("LakiIII");

        jLabel123.setText("a. Laki-Laki");

        lblABWanita.setText("PerempuanIII");

        lblOPria.setText("LakiIV");

        lblOWanita.setText("PerempuanIV");

        lblBWanita.setText("PerempuanKII");

        jLabel128.setText("A");

        jLabel129.setText("B");

        jLabel130.setText("Total");

        jLabel132.setText("a. Laki-Laki");

        jLabel133.setText("a. Laki-Laki");

        lbltotalWanita3.setText("angka total perempuan");

        lbltotalPria3.setText("angka total laki");

        lbltotal3.setText("angka total");

        javax.swing.GroupLayout panelGlass6StatistikGoldarLayout = new javax.swing.GroupLayout(panelGlass6StatistikGoldar);
        panelGlass6StatistikGoldar.setLayout(panelGlass6StatistikGoldarLayout);
        panelGlass6StatistikGoldarLayout.setHorizontalGroup(
            panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel128)
                            .addComponent(jLabel129)
                            .addComponent(jLabel110)
                            .addComponent(jLabel121)
                            .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel132)
                                    .addComponent(jLabel109)
                                    .addComponent(jLabel133)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel117)
                                    .addComponent(jLabel120)
                                    .addComponent(jLabel123)
                                    .addComponent(jLabel113))
                                .addGap(77, 77, 77)
                                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOWanita)
                                    .addComponent(lblOPria)
                                    .addComponent(lblABWanita)
                                    .addComponent(lblABPria)
                                    .addComponent(lblBWanita)
                                    .addComponent(lblBPria)
                                    .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                                        .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAWanita)
                                            .addComponent(lblAPria))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                        .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel130)
                                            .addComponent(jLabel108)
                                            .addComponent(jLabel111))
                                        .addGap(100, 100, 100)
                                        .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbltotalPria3)
                                            .addComponent(lbltotalWanita3)
                                            .addComponent(lbltotal3)))))))
                    .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                        .addComponent(jLabel115)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass6StatistikGoldarLayout.setVerticalGroup(
            panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel115)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132)
                            .addComponent(lblAPria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109)
                            .addComponent(lblAWanita)))
                    .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111))
                    .addGroup(panelGlass6StatistikGoldarLayout.createSequentialGroup()
                        .addComponent(lbltotal3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalPria3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalWanita3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(lblBPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(lblBWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel110)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(lblABPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(lblABWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel121)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(lblOPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass6StatistikGoldarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(lblOWanita))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass6StatistikGoldar, "card22");

        panelGlass7StatistikPendidikan.setOpaqueImage(false);

        jLabel135.setText("S1/D4");

        jLabel137.setText("a. Laki-Laki");

        jLabel139.setText("SMA/sederajat");

        lblS2Pria.setText("LakiII");

        jLabel141.setText("b. Perempuan");

        jLabel142.setText("Statistik Data Pegawai");

        jLabel143.setText("a. Laki-Laki");

        jLabel144.setText("a. Laki-Laki");

        jLabel145.setText("b. Perempuan");

        jLabel146.setText("b. Perempuan");

        jLabel147.setText("SMP/sederajat");

        lblS1Pria.setText("LakiIII");

        jLabel149.setText("a. Laki-Laki");

        lblS1Wanita.setText("PerempuanIII");

        lblSmaPria.setText("LakiIV");

        lblSmaWanita.setText("PerempuanIV");

        lblSmpPria.setText("LakiV");

        lblS2Wanita.setText("PerempuanKII");

        lblSmpWanita.setText("PerempuanV");

        S2.setText("S2");

        jLabel157.setText("Total");

        jLabel158.setText("a. Laki-Laki");

        jLabel159.setText("Laki-Laki");

        jLabel160.setText("b. Perempuan");

        jLabel161.setText("Perempuan");

        jLabel162.setText("b. Perempuan");

        lblS3Pria.setText("LakiI");

        lblS3Wanita.setText("PerempuanI");

        lbltotalWanita4.setText("angka total perempuan");

        lbltotalPria4.setText("angka total laki");

        lbltotal4.setText("angka total");

        jLabel166.setText("SD/sederajat");

        jLabel148.setText("a. Laki-Laki");

        jLabel150.setText("b. Perempuan");

        lblSdWanita.setText("PerempuanV");

        lblSdPria.setText("LakiV");

        S3.setText("S3");

        javax.swing.GroupLayout panelGlass7StatistikPendidikanLayout = new javax.swing.GroupLayout(panelGlass7StatistikPendidikan);
        panelGlass7StatistikPendidikan.setLayout(panelGlass7StatistikPendidikanLayout);
        panelGlass7StatistikPendidikanLayout.setHorizontalGroup(
            panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(S3)
                                    .addComponent(S2)
                                    .addComponent(jLabel135)
                                    .addComponent(jLabel139)
                                    .addComponent(jLabel147)
                                    .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel158)
                                                    .addComponent(jLabel160))
                                                .addGap(77, 77, 77)
                                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblS3Wanita)
                                                    .addComponent(lblS3Pria)))
                                            .addComponent(jLabel144)
                                            .addComponent(jLabel146)
                                            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel137)
                                                    .addComponent(jLabel141)
                                                    .addComponent(jLabel143)
                                                    .addComponent(jLabel145)
                                                    .addComponent(jLabel149)
                                                    .addComponent(jLabel162))
                                                .addGap(77, 77, 77)
                                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblSmaWanita)
                                                    .addComponent(lblSmaPria)
                                                    .addComponent(lblS1Wanita)
                                                    .addComponent(lblS1Pria)
                                                    .addComponent(lblS2Wanita)
                                                    .addComponent(lblS2Pria)))))
                                    .addComponent(jLabel166))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel157)
                                    .addComponent(jLabel159)
                                    .addComponent(jLabel161))
                                .addGap(100, 100, 100)
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltotalPria4)
                                    .addComponent(lbltotalWanita4)
                                    .addComponent(lbltotal4)))
                            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel148)
                                    .addComponent(jLabel150))
                                .addGap(77, 77, 77)
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSdWanita)
                                    .addComponent(lblSdPria)
                                    .addComponent(lblSmpWanita)
                                    .addComponent(lblSmpPria))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                        .addComponent(jLabel142)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass7StatistikPendidikanLayout.setVerticalGroup(
            panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                        .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel157)
                            .addComponent(S3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                .addComponent(jLabel159)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel161))
                            .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel158)
                                    .addComponent(lblS3Pria))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel160)
                                    .addComponent(lblS3Wanita)))))
                    .addGroup(panelGlass7StatistikPendidikanLayout.createSequentialGroup()
                        .addComponent(lbltotal4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalPria4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalWanita4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(S2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(lblS2Pria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(lblS2Wanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(lblS1Pria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(lblS1Wanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel139)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(lblSmaPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(lblSmaWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel147)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144)
                    .addComponent(lblSmpPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(lblSmpWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel166)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(lblSdPria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass7StatistikPendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(lblSdWanita))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass7StatistikPendidikan, "card23");

        jLabel177.setText("ID");

        jLabel180.setText("Pangkat Baru");

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel186.setText("Daftar Pegawai Pengaju Naik Pangkat");

        jLabel181.setText("Status");

        txtNipPangkatRektor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNipPangkatRektorActionPerformed(evt);
            }
        });

        btnUpdatePangkatRektor.setText("Update");
        btnUpdatePangkatRektor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePangkatRektorActionPerformed(evt);
            }
        });

        jLabel179.setText("Pangkat Lama");

        jLabel178.setText("NIP");

        tabelDataPengajuPangkatRek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NIP", "Pangkat lama", "Pangkat Baru", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelDataPengajuPangkatRek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataPengajuPangkatRekMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tabelDataPengajuPangkatRek);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DITOLAK", "DITERIMA", " " }));

        javax.swing.GroupLayout panelGlass2Layout = new javax.swing.GroupLayout(panelGlass2);
        panelGlass2.setLayout(panelGlass2Layout);
        panelGlass2Layout.setHorizontalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel186)
                .addGap(227, 227, 227))
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel179)
                            .addComponent(jLabel177, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel178, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel180, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel181, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(40, 40, 40)
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPangkatBaru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addComponent(txtPangkatLama, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNipPangkatRektor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdPangkatRektor, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btnUpdatePangkatRektor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGlass2Layout.setVerticalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel186)
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177)
                    .addComponent(txtIdPangkatRektor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel178)
                    .addComponent(txtNipPangkatRektor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel179)
                    .addComponent(txtPangkatLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180)
                    .addComponent(txtPangkatBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel181)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpdatePangkatRektor)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(panelGlass2);

        javax.swing.GroupLayout panel8PengajuNaikLayout = new javax.swing.GroupLayout(panel8PengajuNaik);
        panel8PengajuNaik.setLayout(panel8PengajuNaikLayout);
        panel8PengajuNaikLayout.setHorizontalGroup(
            panel8PengajuNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        panel8PengajuNaikLayout.setVerticalGroup(
            panel8PengajuNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panel8PengajuNaik, "card9");

        jLabel200.setText("Daftar Pegawai Pengaju Pensiun");

        jLabel182.setText("ID");

        jLabel183.setText("NIP");

        jLabel203.setText("Status");

        txtIDPensR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPensRActionPerformed(evt);
            }
        });

        tblDataPensR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NIP", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDataPensR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataPensRMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDataPensR);

        cmbAksi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TUNGGU", "DISETUJUI" }));
        cmbAksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAksiActionPerformed(evt);
            }
        });

        cmdVerifikasi.setText("Verifikasi Data");
        cmdVerifikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerifikasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass3Layout = new javax.swing.GroupLayout(panelGlass3);
        panelGlass3.setLayout(panelGlass3Layout);
        panelGlass3Layout.setHorizontalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel200))
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel182, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel203, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(76, 76, 76)
                        .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelGlass3Layout.createSequentialGroup()
                                .addComponent(cmbAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdVerifikasi))
                            .addComponent(txtIDPensR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(txtNipPensR, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelGlass3Layout.setVerticalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel200)
                .addGap(28, 28, 28)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel182)
                    .addComponent(txtIDPensR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel183)
                    .addComponent(txtNipPensR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel203)
                    .addComponent(cmbAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(cmdVerifikasi)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jScrollPane15.setViewportView(panelGlass3);

        javax.swing.GroupLayout panel9PengajuPensiunLayout = new javax.swing.GroupLayout(panel9PengajuPensiun);
        panel9PengajuPensiun.setLayout(panel9PengajuPensiunLayout);
        panel9PengajuPensiunLayout.setHorizontalGroup(
            panel9PengajuPensiunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        panel9PengajuPensiunLayout.setVerticalGroup(
            panel9PengajuPensiunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panel9PengajuPensiun, "card10");

        getContentPane().add(jPanelSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 680, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/picBack.jpg"))); // NOI18N
        jLabel1.setText("User Rektorat");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 480));

        MenuStatistik.setText("Statistik Pegawai");

        btnStatistikAgama.setText("Agama");
        btnStatistikAgama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikAgamaActionPerformed(evt);
            }
        });
        MenuStatistik.add(btnStatistikAgama);

        btnStatistikGoldar.setText("Golongan Darah");
        btnStatistikGoldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikGoldarActionPerformed(evt);
            }
        });
        MenuStatistik.add(btnStatistikGoldar);

        btnStatistikPendidikan.setText("Pendidikan");
        btnStatistikPendidikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikPendidikanActionPerformed(evt);
            }
        });
        MenuStatistik.add(btnStatistikPendidikan);

        jMenuBar1.add(MenuStatistik);

        btnPengajuNaik.setText("Pengaju Naik Pangkat");
        btnPengajuNaik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengajuNaikMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnPengajuNaik);

        btnPengajuPensiun.setText("Pengaju Pensiun");
        btnPengajuPensiun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengajuPensiunMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnPengajuPensiun);

        jMenu1.setText("Keluar");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatistikAgamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatistikAgamaActionPerformed
        jPanelSlider1.nextPanel(8,panelGlass3StatistikAgama,jPanelSlider1.left);
    }//GEN-LAST:event_btnStatistikAgamaActionPerformed

    private void btnStatistikGoldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatistikGoldarActionPerformed
        jPanelSlider1.nextPanel(8,panelGlass6StatistikGoldar,jPanelSlider1.left);
    }//GEN-LAST:event_btnStatistikGoldarActionPerformed

    private void btnStatistikPendidikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatistikPendidikanActionPerformed
        jPanelSlider1.nextPanel(8,panelGlass7StatistikPendidikan,jPanelSlider1.left);
    }//GEN-LAST:event_btnStatistikPendidikanActionPerformed

    private void btnPengajuNaikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengajuNaikMouseClicked
        
        jPanelSlider1.nextPanel(8,panel8PengajuNaik,jPanelSlider1.left);
        controllerPengajuPangkatRektor.isiTable();
    }//GEN-LAST:event_btnPengajuNaikMouseClicked

    private void btnPengajuPensiunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengajuPensiunMouseClicked
        jPanelSlider1.nextPanel(8,panel9PengajuPensiun,jPanelSlider1.left);
        controllerPengajuPensiunRektor.isiTable();
        
    }//GEN-LAST:event_btnPengajuPensiunMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Home home = new Home();
        home.setLayout(new BorderLayout());
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnUpdatePangkatRektorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePangkatRektorActionPerformed
        controllerPengajuPangkatRektor.update();
        controllerPengajuPangkatRektor.isiTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdatePangkatRektorActionPerformed

    private void tabelDataPengajuPangkatRekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataPengajuPangkatRekMouseClicked
    controllerPengajuPangkatRektor.isiField(tabelDataPengajuPangkatRek.getSelectedRow());
    txtIdPangkatRektor.setEditable(false);
    txtNipPangkatRektor.setEditable(false);
    txtPangkatLama.setEditable(false);
    txtPangkatBaru.setEditable(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataPengajuPangkatRekMouseClicked

    private void tblDataPensRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataPensRMouseClicked
        // TODO add your handling code here:
        controllerPengajuPensiunRektor.isiField(tblDataPensR.getSelectedRow());
        txtIDPensR.setEditable(false);
        txtNipPensR.setEditable(false);
    }//GEN-LAST:event_tblDataPensRMouseClicked

    private void cmbAksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAksiActionPerformed

    private void cmdVerifikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerifikasiActionPerformed
        controllerPengajuPensiunRektor.update();
        controllerPengajuPensiunRektor.isiTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdVerifikasiActionPerformed

    private void txtNipPangkatRektorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNipPangkatRektorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNipPangkatRektorActionPerformed

    private void txtIDPensRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPensRActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtIDPensRActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HalUtamaRektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalUtamaRektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalUtamaRektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalUtamaRektor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalUtamaRektor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuStatistik;
    private javax.swing.JLabel S2;
    private javax.swing.JLabel S3;
    private javax.swing.JMenu btnPengajuNaik;
    private javax.swing.JMenu btnPengajuPensiun;
    private javax.swing.JMenuItem btnStatistikAgama;
    private javax.swing.JMenuItem btnStatistikGoldar;
    private javax.swing.JMenuItem btnStatistikPendidikan;
    private javax.swing.JButton btnUpdatePangkatRektor;
    private javax.swing.JComboBox cmbAksi;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JButton cmdVerifikasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JLabel lblABPria;
    private javax.swing.JLabel lblABWanita;
    private javax.swing.JLabel lblAPria;
    private javax.swing.JLabel lblAWanita;
    private javax.swing.JLabel lblBPria;
    private javax.swing.JLabel lblBWanita;
    private javax.swing.JLabel lblOPria;
    private javax.swing.JLabel lblOWanita;
    private javax.swing.JLabel lblS1Pria;
    private javax.swing.JLabel lblS1Wanita;
    private javax.swing.JLabel lblS2Pria;
    private javax.swing.JLabel lblS2Wanita;
    private javax.swing.JLabel lblS3Pria;
    private javax.swing.JLabel lblS3Wanita;
    private javax.swing.JLabel lblSdPria;
    private javax.swing.JLabel lblSdWanita;
    private javax.swing.JLabel lblSmaPria;
    private javax.swing.JLabel lblSmaWanita;
    private javax.swing.JLabel lblSmpPria;
    private javax.swing.JLabel lblSmpWanita;
    private javax.swing.JLabel lblbudhaPria;
    private javax.swing.JLabel lblbudhaWanita;
    private javax.swing.JLabel lblhinduPria;
    private javax.swing.JLabel lblhinduWanita;
    private javax.swing.JLabel lblislamPria;
    private javax.swing.JLabel lblislamWanita;
    private javax.swing.JLabel lblkatolikPria;
    private javax.swing.JLabel lblkatolikWanita;
    private javax.swing.JLabel lblkristenPria;
    private javax.swing.JLabel lblkristenWanita;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lbltotal1;
    private javax.swing.JLabel lbltotal2;
    private javax.swing.JLabel lbltotal3;
    private javax.swing.JLabel lbltotal4;
    private javax.swing.JLabel lbltotalPria;
    private javax.swing.JLabel lbltotalPria1;
    private javax.swing.JLabel lbltotalPria2;
    private javax.swing.JLabel lbltotalPria3;
    private javax.swing.JLabel lbltotalPria4;
    private javax.swing.JLabel lbltotalWanita;
    private javax.swing.JLabel lbltotalWanita1;
    private javax.swing.JLabel lbltotalWanita2;
    private javax.swing.JLabel lbltotalWanita3;
    private javax.swing.JLabel lbltotalWanita4;
    private usu.widget.glass.PanelGlass panel1HomeRektor;
    private usu.widget.glass.PanelGlass panel8PengajuNaik;
    private usu.widget.glass.PanelGlass panel9PengajuPensiun;
    private usu.widget.glass.PanelGlass panelGlass2;
    private usu.widget.glass.PanelGlass panelGlass2StatistikNaik;
    private usu.widget.glass.PanelGlass panelGlass3;
    private usu.widget.glass.PanelGlass panelGlass3StatistikAgama;
    private usu.widget.glass.PanelGlass panelGlass4StatistikGolongan;
    private usu.widget.glass.PanelGlass panelGlass5StatistikUmur;
    private usu.widget.glass.PanelGlass panelGlass6StatistikGoldar;
    private usu.widget.glass.PanelGlass panelGlass7StatistikPendidikan;
    private javax.swing.JTable tabelDataPengajuPangkatRek;
    private javax.swing.JTable tblDataPensR;
    private javax.swing.JTextField txtIDPensR;
    private javax.swing.JTextField txtIdPangkatRektor;
    private javax.swing.JTextField txtNipPangkatRektor;
    private javax.swing.JTextField txtNipPensR;
    private javax.swing.JTextField txtPangkatBaru;
    private javax.swing.JTextField txtPangkatLama;
    // End of variables declaration//GEN-END:variables
}
