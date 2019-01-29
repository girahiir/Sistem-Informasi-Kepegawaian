/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import DataInduk.ControllerIndBK;
import DataKeluarga.ControllerKelBK;
import DataPendidikan.ControllerPendBK;
import Entities.Tbldataindukpeg;
import EntitiesController.TbldataindukpegJpaController;
import EntitiesController.TbldatariwayatpendJpaController;
import PengajuPangkat.ControllerPengajuPangkat;
import PengajuPensiun.BK_ControllerPengPens;
import Pesan.ControllerPesan;
import TampilData.ControllerTampilInduk;
import TampilData.ControllerTampilKeluarga;
import TampilData.ControllerTampilPendidikan;
import java.awt.BorderLayout;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Girah Ihtama
 */
public class HalUtamaBK extends javax.swing.JFrame {

    /**
     * Creates new form HalUtamaBK
    
    */
    
    ControllerPendBK ckb;
    ControllerKelBK controllerKelBK;
    ControllerIndBK controllerIndBK;
    ControllerPesan controllerPesan;
    ControllerTampilInduk controllerTampilInduk;
    ControllerTampilPendidikan controllerTampilPendidikan;
    ControllerTampilKeluarga controllerTampilKeluarga;
    ControllerPengajuPangkat controllerPengajuPangkat;
    BK_ControllerPengPens controllerPengajuPensiun;
    
    
    public HalUtamaBK() {
        initComponents();
        
        ckb = new ControllerPendBK(this);
        controllerKelBK = new ControllerKelBK(this);
        controllerIndBK = new ControllerIndBK((this));
        controllerPesan = new ControllerPesan(this);
        controllerTampilInduk = new ControllerTampilInduk(this);
        controllerTampilPendidikan = new ControllerTampilPendidikan(this);
        controllerTampilKeluarga = new ControllerTampilKeluarga(this);
        controllerPengajuPangkat = new ControllerPengajuPangkat(this);
        controllerPengajuPensiun = new BK_ControllerPengPens(this);
        
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
    
   //////////////////////////////// DATA INDUK BK /////////////////////////
    
     public JTextField gettxtNipIndukBK() {
        return txtNipIndukBK;
    }

    public JTextField gettxtNamaIndukBK() {
        return txtNama;
    }

    public JTextField gettxtJk() {
        return txtJk;
    }

    public JTextField gettxtStatusDiri() {
        return txtStatusDiri;
    }

    public JTextField gettxtGolDar() {
        return txtGolDar;
    }

    public JTextField gettxtGelarDepan() {
        return txtGelarDepan;
    }

    public JTextField gettxtGelarBelakang() {
        return txtGelarBelakang;
    }

    public JTextField gettxtAgama() {
        return txtAgama;
    }

    public JTextField gettxtTempatLahir() {
        return txtTempatLahir;
    }

    public JTextField gettxtTglLahir() {
        return txtTglLahir;
    }

    public JTextField gettxtNoKtp() {
        return txtNoKtp;
    }

    public JTextField gettxtAlamat() {
        return txtAlamat;
    }

    public JTextField gettxtNoTelp() {
        return txtNoTelp;
    }

    public JTextField gettxtNoPonsel() {
        return txtNoPonsel;
    }

    public JTextField gettxtTahunMasukIndukBK() {
        return txtTahunMasukIndukBK;
    }

    public JTextField gettxtIdPangkat() {
        return txtIdPangkat;
    }

    public JTable getTabelDataIndukBK() {
        return tabelDataIndukBK;
    }

    public JButton getBtnInsertIndukBK() {
        return btnInsertIndukBK;
    }

    public JButton getBtnUpdateIndukBK() {
        return btnUpdateIndukBK;
    }
    
   // DATA PENDIDIKAN BK
    
    public JTextField gettxtID() {
        return txtID;
    }
     
     public JTextField gettxtNIP() {
        return txtNIPPendidikanBK;
    }
     
     public JTextField gettxtTingkat(){
         return txttingkatPend;
     }
     
    public JTextField gettxtTempatPend(){
         return txtTempatPend;
     }
     
    public JTextField gettxtJurusan(){
         return txtJurusan;
     }
    
    public JTextField gettxtTanggalIjazah(){
         return txtTanggalIjazah;
     }
    
    public JTextField gettxtTahunMasukPendidikan(){
         return txtTahunMasukPendidikan;
     }
    
     public JTextField gettxtTahunLulus(){
         return txtTahunLulus;
     }

     public JTable getTabelDataPendidikan() {
        return tabelDataPendidikanBK;
    }
      public JButton getBtnInsert() {
        return btnInsertPendidikanBk;
    }
        public JButton getBtnUpdate() {
        return btnUpdatePendidikanBK;
    }
    
        
        //DATA KELUARGA BK
    public JTextField gettxtIdKelBK() {
        return txtIdKelBK;
    }

    public JTextField gettxtNipKelBK() {
        return txtNipKelBK;
    }

    public JTextField gettxtAyah() {
        return txtAyah;
    }

    public JTextField gettxtIbu() {
        return txtIbu;
    }

    public JTextField gettxtIstri() {
        return txtIstri;
    }

    public JTextField gettxtSuami() {
        return txtSuami;
    }

    public JTextField gettxtJmlAnak() {
        return txtJmlAnak;
    }

    public JTextField gettxtKerjaSuami() {
        return txtKerjaSuami;
    }

    public JTextField gettxtKerjaIstri() {
        return txtKerjaIstri;
    }

    public JTextField gettxtKerjaAnak() {
        return txtKerjaAnak;
    }

    public JTable getTabelDataKeluarga() {
        return tabelDataKeluarga;
    }

    public JButton getBtnInsertKeluarga() {
        return btnInsertKeluarga;
    }
    
    public JButton getBtnUpdateKeluarga() {
        return btnUpdateKeluarga;
    }
    
    /** PANEL PESAN BK **/
    public JTextField gettxtNipTujuanBK(){
        return tfNipTujuanBK;
    }
    
    public JTextArea gettxtIsiPesanBK(){
        return taIsiPesanBK;
    }
    
    //////////////////////////////// TAMPILKAN DATA //////////////////////////////////
    
     public JTable gettabelTampilInduk() {
        return tabelTampilInduk;
    }
     
     public JTextField gettxtSearchDataInduk(){
         return txtSearchDataInduk;
     }
     
      public JButton getbtnSearchDataInduk(){
         return btnSearchDataInduk;
     }
     
    ////////////////////////////////////////
      
      public JTable gettabelTampilPendidikan() {
        return tabelTampilPendidikan;
    }
      public JTextField gettxtSearchPendidikan(){
         return txtSearchPendidikan;
     }
     
      public JButton getbtnSearchPendidikan(){
         return btnSearchPendidikan;
     }
      
     ///////////////////////////////////////  
      public JTable gettabelTampilKeluarga() {
        return tabelTampilKeluarga;
    }
      public JTextField gettxtSearchKeluarga(){
         return txtSearchKeluarga;
     }
     
      public JButton getbtnSearchKeluarga(){
         return btnSearchKeluarga;
     }
    

      //////////////////////////////// PENGAJU ////////////////////////////////////////
      
      //////////////PANGKAT////////////////////
      public JTextField gettxtIdNaikPangkat() {
        return txtIdNaikPangkat;
    }
    
    public JTextField gettxtNipNaikPangkat() {
        return txtNipNaikPangkat;
    }
    
    public JTextField gettxtPangkatLama() {
        return txtPangkatLama;
    }
    
    public JTextField gettxtPangkatBaru() {
        return txtPangkatBaru;
    }

    public JComboBox getCmbStatusBK() {
        return cmbStatusBK;
    }
    
//    public JTextField gettxtStatusPangkat() {
//        return txtStatusNaikPangkat;
//    }
//    
    public JTable getTabelDataPengajuPangkat() {
        return tabelDataPengajuPangkat;
    }
    
    public JButton getbtnTungguPangkat(){
        return btnTungguPangkat;
    
}
    
    ///////////PENSIUN///////////////
      public JTable gettblPengPensBk() {
        return tblPengPensBk;
    }

    public JTextField getTxtIdPengPensiBK() {
        return txtIdPengPensiBK;
    }

    public JComboBox getcmbStatusBK() {
        return CmbStatusBk;
    }

    public JTextField getTxtnipPengPensBk() {
        return txtnipPengPensBk;
    }

    public JButton getBtnpensBK() {
        return btnpensBK;
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
        panelGlass1HomeBk = new usu.widget.glass.PanelGlass();
        panelGlass7 = new usu.widget.glass.PanelGlass();
        jLabel20 = new javax.swing.JLabel();
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
        panelGlass8 = new usu.widget.glass.PanelGlass();
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
        panelGlass8DataUmum = new usu.widget.glass.PanelGlass();
        btnDataInduk = new javax.swing.JButton();
        btnTampilDataPendidikan = new javax.swing.JButton();
        btnDataKeluarga = new javax.swing.JButton();
        jButtonTambahDataPend = new javax.swing.JButton();
        btnTambahDataInduk = new javax.swing.JButton();
        btnTambahDataKel = new javax.swing.JToggleButton();
        panelGlass9DataInduk = new usu.widget.glass.PanelGlass();
        jScrollPane5 = new javax.swing.JScrollPane();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel9 = new javax.swing.JLabel();
        btnInsertIndukBK = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNipIndukBK = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJk = new javax.swing.JTextField();
        txtStatusDiri = new javax.swing.JTextField();
        txtGolDar = new javax.swing.JTextField();
        txtGelarDepan = new javax.swing.JTextField();
        txtGelarBelakang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAgama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTempatLahir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTglLahir = new javax.swing.JTextField();
        txtNoKtp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNoPonsel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnUpdateIndukBK = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelDataIndukBK = new javax.swing.JTable();
        jLabel185 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        txtTahunMasukIndukBK = new javax.swing.JTextField();
        txtIdPangkat = new javax.swing.JTextField();
        panelGlass10Pendidikan = new usu.widget.glass.PanelGlass();
        jLabel16 = new javax.swing.JLabel();
        txtTahunLulus = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        btnUpdatePendidikanBK = new javax.swing.JButton();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        txttingkatPend = new javax.swing.JTextField();
        txtTempatPend = new javax.swing.JTextField();
        txtJurusan = new javax.swing.JTextField();
        txtTanggalIjazah = new javax.swing.JTextField();
        jLabel193 = new javax.swing.JLabel();
        txtTahunMasukPendidikan = new javax.swing.JTextField();
        btnInsertPendidikanBk = new javax.swing.JButton();
        jLabel194 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelDataPendidikanBK = new javax.swing.JTable();
        txtNIPPendidikanBK = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        panelGlass11Keluarga = new usu.widget.glass.PanelGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        txtAyah = new javax.swing.JTextField();
        txtIbu = new javax.swing.JTextField();
        txtIstri = new javax.swing.JTextField();
        txtSuami = new javax.swing.JTextField();
        txtJmlAnak = new javax.swing.JTextField();
        txtKerjaSuami = new javax.swing.JTextField();
        txtKerjaIstri = new javax.swing.JTextField();
        txtKerjaAnak = new javax.swing.JTextField();
        btnUpdateKeluarga = new javax.swing.JButton();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        btnInsertKeluarga = new javax.swing.JButton();
        jLabel198 = new javax.swing.JLabel();
        txtIdKelBK = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        txtNipKelBK = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelDataKeluarga = new javax.swing.JTable();
        panelGlass12PengajuNaik = new usu.widget.glass.PanelGlass();
        jScrollPane18 = new javax.swing.JScrollPane();
        panelGlass5 = new usu.widget.glass.PanelGlass();
        jLabel186 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        txtIdNaikPangkat = new javax.swing.JTextField();
        txtNipNaikPangkat = new javax.swing.JTextField();
        txtPangkatLama = new javax.swing.JTextField();
        txtPangkatBaru = new javax.swing.JTextField();
        btnTungguPangkat = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabelDataPengajuPangkat = new javax.swing.JTable();
        cmbStatusBK = new javax.swing.JComboBox();
        panelGlass13PengajuPensiun = new usu.widget.glass.PanelGlass();
        jScrollPane19 = new javax.swing.JScrollPane();
        panelGlass6 = new usu.widget.glass.PanelGlass();
        jLabel200 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        txtIdPengPensiBK = new javax.swing.JTextField();
        txtnipPengPensBk = new javax.swing.JTextField();
        btnpensBK = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblPengPensBk = new javax.swing.JTable();
        CmbStatusBk = new javax.swing.JComboBox();
        panelGlass15Pesan = new usu.widget.glass.PanelGlass();
        jPanel3 = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        tfNipTujuanBK = new javax.swing.JTextField();
        jLabel175 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taIsiPesanBK = new javax.swing.JTextArea();
        jLabel176 = new javax.swing.JLabel();
        btnKirimPesan = new javax.swing.JButton();
        panelGlass16TampilInduk = new usu.widget.glass.PanelGlass();
        jScrollPane14 = new javax.swing.JScrollPane();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabelTampilInduk = new javax.swing.JTable();
        jLabel214 = new javax.swing.JLabel();
        txtSearchDataInduk = new javax.swing.JTextField();
        btnSearchDataInduk = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        panelGlass17TampilPend = new usu.widget.glass.PanelGlass();
        jScrollPane16 = new javax.swing.JScrollPane();
        panelGlass3 = new usu.widget.glass.PanelGlass();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelTampilPendidikan = new javax.swing.JTable();
        jLabel187 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSearchPendidikan = new javax.swing.JTextField();
        btnSearchPendidikan = new javax.swing.JButton();
        panelGlass18TampilKel = new usu.widget.glass.PanelGlass();
        jScrollPane17 = new javax.swing.JScrollPane();
        panelGlass4 = new usu.widget.glass.PanelGlass();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelTampilKeluarga = new javax.swing.JTable();
        jLabel202 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSearchKeluarga = new javax.swing.JTextField();
        btnSearchKeluarga = new javax.swing.JButton();
        jLabel184 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnStatistikAgama = new javax.swing.JMenuItem();
        btnStatistikGoldar = new javax.swing.JMenuItem();
        btnStatistikPendidikan = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuPengajuPangkat = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Halaman Bagian Kepegawaian");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGlass1HomeBk.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/resources/back1.jpg"))); // NOI18N
        panelGlass1HomeBk.setOpaqueImage(false);

        panelGlass7.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/resources/back1.jpg"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel20.setText("BAGIAN KEPEGAWAIAN");

        javax.swing.GroupLayout panelGlass7Layout = new javax.swing.GroupLayout(panelGlass7);
        panelGlass7.setLayout(panelGlass7Layout);
        panelGlass7Layout.setHorizontalGroup(
            panelGlass7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass7Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(233, 233, 233))
        );
        panelGlass7Layout.setVerticalGroup(
            panelGlass7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass7Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel20)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGlass1HomeBkLayout = new javax.swing.GroupLayout(panelGlass1HomeBk);
        panelGlass1HomeBk.setLayout(panelGlass1HomeBkLayout);
        panelGlass1HomeBkLayout.setHorizontalGroup(
            panelGlass1HomeBkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlass7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGlass1HomeBkLayout.setVerticalGroup(
            panelGlass1HomeBkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1HomeBkLayout.createSequentialGroup()
                .addComponent(panelGlass7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider1.add(panelGlass1HomeBk, "card17");

        panelGlass2StatistikNaik.setOpaqueImage(false);

        javax.swing.GroupLayout panelGlass2StatistikNaikLayout = new javax.swing.GroupLayout(panelGlass2StatistikNaik);
        panelGlass2StatistikNaik.setLayout(panelGlass2StatistikNaikLayout);
        panelGlass2StatistikNaikLayout.setHorizontalGroup(
            panelGlass2StatistikNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        panelGlass2StatistikNaikLayout.setVerticalGroup(
            panelGlass2StatistikNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
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
                .addContainerGap(211, Short.MAX_VALUE))
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
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
                .addContainerGap(271, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass4StatistikGolongan, "card20");

        panelGlass5StatistikUmur.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/resources/picBack.jpg"))); // NOI18N
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

        javax.swing.GroupLayout panelGlass8Layout = new javax.swing.GroupLayout(panelGlass8);
        panelGlass8.setLayout(panelGlass8Layout);
        panelGlass8Layout.setHorizontalGroup(
            panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGlass8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGlass8Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel97)
                                .addComponent(jLabel76)
                                .addComponent(jLabel80)
                                .addComponent(jLabel88)
                                .addComponent(jLabel104)
                                .addGroup(panelGlass8Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel78)
                                        .addComponent(jLabel82)
                                        .addComponent(jLabel84)
                                        .addComponent(jLabel86)
                                        .addComponent(jLabel90)
                                        .addComponent(jLabel103)
                                        .addComponent(jLabel85)
                                        .addComponent(jLabel87)
                                        .addComponent(jLabel99)
                                        .addComponent(jLabel101))
                                    .addGap(181, 181, 181)
                                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel96)
                                        .addComponent(jLabel94)
                                        .addComponent(jLabel93)
                                        .addComponent(jLabel92)
                                        .addComponent(jLabel91)
                                        .addComponent(jLabel89)
                                        .addComponent(jLabel95)
                                        .addComponent(jLabel81)
                                        .addGroup(panelGlass8Layout.createSequentialGroup()
                                            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel106)
                                                .addComponent(jLabel105))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                                            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel98)
                                                .addComponent(jLabel100)
                                                .addComponent(jLabel102))
                                            .addGap(100, 100, 100)
                                            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbltotalPria2)
                                                .addComponent(lbltotalWanita2)
                                                .addComponent(lbltotal2)))))))
                        .addGroup(panelGlass8Layout.createSequentialGroup()
                            .addComponent(jLabel83)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        panelGlass8Layout.setVerticalGroup(
            panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGlass8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel83)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelGlass8Layout.createSequentialGroup()
                            .addComponent(jLabel97)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel99)
                                .addComponent(jLabel105))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel101)
                                .addComponent(jLabel106)))
                        .addGroup(panelGlass8Layout.createSequentialGroup()
                            .addComponent(jLabel98)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel100)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel102))
                        .addGroup(panelGlass8Layout.createSequentialGroup()
                            .addComponent(lbltotal2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbltotalPria2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbltotalWanita2)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel76)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel78)
                        .addComponent(jLabel81))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel82)
                        .addComponent(jLabel95))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel80)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel84)
                        .addComponent(jLabel89))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel86)
                        .addComponent(jLabel91))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel88)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel90)
                        .addComponent(jLabel92))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel103)
                        .addComponent(jLabel93))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel104)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel85)
                        .addComponent(jLabel94))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelGlass8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel87)
                        .addComponent(jLabel96))
                    .addContainerGap(211, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelGlass5StatistikUmurLayout = new javax.swing.GroupLayout(panelGlass5StatistikUmur);
        panelGlass5StatistikUmur.setLayout(panelGlass5StatistikUmurLayout);
        panelGlass5StatistikUmurLayout.setHorizontalGroup(
            panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5StatistikUmurLayout.createSequentialGroup()
                .addComponent(panelGlass8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelGlass5StatistikUmurLayout.setVerticalGroup(
            panelGlass5StatistikUmurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlass8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
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
                .addContainerGap(271, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
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
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass7StatistikPendidikan, "card23");

        panelGlass8DataUmum.setOpaqueImage(false);

        btnDataInduk.setText("Tampilkan Data Induk");
        btnDataInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataIndukActionPerformed(evt);
            }
        });

        btnTampilDataPendidikan.setText("Tampilkan Data Pendidikan");
        btnTampilDataPendidikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilDataPendidikanActionPerformed(evt);
            }
        });

        btnDataKeluarga.setText("TampilkanData Keluarga");
        btnDataKeluarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKeluargaActionPerformed(evt);
            }
        });

        jButtonTambahDataPend.setText("Tambah Data Pendidikan");
        jButtonTambahDataPend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahDataPendActionPerformed(evt);
            }
        });

        btnTambahDataInduk.setText("Tambah Data Induk");
        btnTambahDataInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataIndukActionPerformed(evt);
            }
        });

        btnTambahDataKel.setText("Tambah Data Keluarga");
        btnTambahDataKel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataKelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass8DataUmumLayout = new javax.swing.GroupLayout(panelGlass8DataUmum);
        panelGlass8DataUmum.setLayout(panelGlass8DataUmumLayout);
        panelGlass8DataUmumLayout.setHorizontalGroup(
            panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass8DataUmumLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTambahDataInduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataInduk, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonTambahDataPend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTampilDataPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDataKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahDataKel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        panelGlass8DataUmumLayout.setVerticalGroup(
            panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass8DataUmumLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTampilDataPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDataKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDataInduk, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(panelGlass8DataUmumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTambahDataKel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahDataInduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTambahDataPend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass8DataUmum, "card24");

        panelGlass1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Agama");
        panelGlass1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        btnInsertIndukBK.setText("Insert");
        btnInsertIndukBK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertIndukBKActionPerformed(evt);
            }
        });
        panelGlass1.add(btnInsertIndukBK, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, -1, -1));

        jLabel10.setText("Tempat Lahir");
        panelGlass1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel11.setText("Tanggal Lahir");
        panelGlass1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel12.setText("No. KTP");
        panelGlass1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel13.setText("Alamat");
        panelGlass1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel14.setText("No. Telp");
        panelGlass1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        jLabel15.setText("No. Ponsel");
        panelGlass1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));
        panelGlass1.add(txtNipIndukBK, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 346, -1));

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        panelGlass1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 346, -1));
        panelGlass1.add(txtJk, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 346, -1));

        txtStatusDiri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusDiriActionPerformed(evt);
            }
        });
        panelGlass1.add(txtStatusDiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 346, -1));
        panelGlass1.add(txtGolDar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 346, -1));
        panelGlass1.add(txtGelarDepan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 346, -1));
        panelGlass1.add(txtGelarBelakang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 346, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("DATA INDUK PEGAWAI");
        panelGlass1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));
        panelGlass1.add(txtAgama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 346, -1));

        jLabel2.setText("NIP");
        panelGlass1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));
        panelGlass1.add(txtTempatLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 346, -1));

        jLabel3.setText("Nama");
        panelGlass1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel4.setText("Jenis Kelamin");
        panelGlass1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txtTglLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglLahirActionPerformed(evt);
            }
        });
        panelGlass1.add(txtTglLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 346, -1));

        txtNoKtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoKtpActionPerformed(evt);
            }
        });
        panelGlass1.add(txtNoKtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 346, -1));

        jLabel5.setText("Status");
        panelGlass1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });
        panelGlass1.add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 346, -1));

        jLabel6.setText("Golongan Darah");
        panelGlass1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));
        panelGlass1.add(txtNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 346, -1));

        jLabel7.setText("Gelar Depan");
        panelGlass1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));
        panelGlass1.add(txtNoPonsel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 346, -1));

        jLabel8.setText("Gelar Belakang");
        panelGlass1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        btnUpdateIndukBK.setText("Update");
        btnUpdateIndukBK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateIndukBKActionPerformed(evt);
            }
        });
        panelGlass1.add(btnUpdateIndukBK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, -1, -1));

        tabelDataIndukBK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIP", "Nama", "Jenis Kelamin", "Status", "Golongan Darah", "Gelar Depan", "Gelar Belakang", "Agama", "Tempat Lahir", "Tanggal Lahir", "No. KTP", "Alamat", "No. Telp", "No. Ponsel", "Tahun Masuk", "ID Pangkat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelDataIndukBK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataIndukBKMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelDataIndukBK);

        panelGlass1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 1220, 100));

        jLabel185.setText("Tahun Masuk");
        panelGlass1.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        jLabel201.setText("ID Pangkat");
        panelGlass1.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));
        panelGlass1.add(txtTahunMasukIndukBK, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 350, -1));
        panelGlass1.add(txtIdPangkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 350, -1));

        jScrollPane5.setViewportView(panelGlass1);

        javax.swing.GroupLayout panelGlass9DataIndukLayout = new javax.swing.GroupLayout(panelGlass9DataInduk);
        panelGlass9DataInduk.setLayout(panelGlass9DataIndukLayout);
        panelGlass9DataIndukLayout.setHorizontalGroup(
            panelGlass9DataIndukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        panelGlass9DataIndukLayout.setVerticalGroup(
            panelGlass9DataIndukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass9DataIndukLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelSlider1.add(panelGlass9DataInduk, "card25");

        panelGlass10Pendidikan.setOpaqueImage(false);

        jLabel16.setText("Tingkat Pendidikan");

        jLabel188.setText("Tempat Pendidikan");

        btnUpdatePendidikanBK.setText("Update");
        btnUpdatePendidikanBK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePendidikanBKActionPerformed(evt);
            }
        });

        jLabel189.setText("Jurusan");

        jLabel190.setText("Tanggal Ijazah");

        jLabel191.setText("Tahun Masuk");

        jLabel192.setText("Tahun Lulus");

        jLabel193.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel193.setText("DATA RIWAYAT PENDIDIKAN");

        btnInsertPendidikanBk.setText("Insert");
        btnInsertPendidikanBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertPendidikanBkActionPerformed(evt);
            }
        });

        jLabel194.setText("ID");

        tabelDataPendidikanBK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NIP", "Tingkat Pendidikan", "Tempat Pendidikan", "Jurusan", "Tanggal Ijazah", "Tahun Masuk", "Tahun Lulus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelDataPendidikanBK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataPendidikanBKMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelDataPendidikanBK);

        jLabel195.setText("NIP");

        javax.swing.GroupLayout panelGlass10PendidikanLayout = new javax.swing.GroupLayout(panelGlass10Pendidikan);
        panelGlass10Pendidikan.setLayout(panelGlass10PendidikanLayout);
        panelGlass10PendidikanLayout.setHorizontalGroup(
            panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass10PendidikanLayout.createSequentialGroup()
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass10PendidikanLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelGlass10PendidikanLayout.createSequentialGroup()
                                .addComponent(btnInsertPendidikanBk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdatePendidikanBK))
                            .addComponent(jLabel193)
                            .addGroup(panelGlass10PendidikanLayout.createSequentialGroup()
                                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel188)
                                    .addComponent(jLabel189)
                                    .addComponent(jLabel190)
                                    .addComponent(jLabel191)
                                    .addComponent(jLabel192)
                                    .addComponent(jLabel194)
                                    .addComponent(jLabel195))
                                .addGap(43, 43, 43)
                                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNIPPendidikanBK)
                                    .addComponent(txttingkatPend)
                                    .addComponent(txtTempatPend)
                                    .addComponent(txtJurusan)
                                    .addComponent(txtTanggalIjazah)
                                    .addComponent(txtTahunMasukPendidikan)
                                    .addComponent(txtTahunLulus, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(panelGlass10PendidikanLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelGlass10PendidikanLayout.setVerticalGroup(
            panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass10PendidikanLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel193)
                .addGap(11, 11, 11)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel194)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNIPPendidikanBK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel195))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txttingkatPend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel188)
                    .addComponent(txtTempatPend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel189)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel190)
                    .addComponent(txtTanggalIjazah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel191)
                    .addComponent(txtTahunMasukPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel192)
                    .addComponent(txtTahunLulus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelGlass10PendidikanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdatePendidikanBK)
                    .addComponent(btnInsertPendidikanBk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass10Pendidikan, "card26");

        panelGlass11Keluarga.setOpaqueImage(false);
        panelGlass11Keluarga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtAyah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 222, -1));
        jPanel2.add(txtIbu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 222, -1));
        jPanel2.add(txtIstri, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 222, -1));
        jPanel2.add(txtSuami, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 222, -1));
        jPanel2.add(txtJmlAnak, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 222, -1));
        jPanel2.add(txtKerjaSuami, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 222, -1));
        jPanel2.add(txtKerjaIstri, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 222, -1));

        txtKerjaAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKerjaAnakActionPerformed(evt);
            }
        });
        jPanel2.add(txtKerjaAnak, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 222, -1));

        btnUpdateKeluarga.setText("Update");
        btnUpdateKeluarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateKeluargaMouseClicked(evt);
            }
        });
        btnUpdateKeluarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKeluargaActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdateKeluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        jLabel167.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel167.setText("DATA KELUARGA");
        jPanel2.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 31, -1, -1));

        jLabel168.setText("Nama Ayah");
        jPanel2.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel169.setText("Nama Ibu");
        jPanel2.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel170.setText("Nama Istri");
        jPanel2.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel171.setText("Nama Suami");
        jPanel2.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jLabel172.setText("Jumlah Anak");
        jPanel2.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel173.setText("Pekerjaan Suami");
        jPanel2.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jLabel196.setText("Pekerjaan Istri");
        jPanel2.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel197.setText("Pekerjaan Anak");
        jPanel2.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        btnInsertKeluarga.setText("Insert");
        btnInsertKeluarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertKeluargaActionPerformed(evt);
            }
        });
        jPanel2.add(btnInsertKeluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        jLabel198.setText("ID ");
        jPanel2.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 78, -1, -1));
        jPanel2.add(txtIdKelBK, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 222, -1));

        jLabel199.setText("NIP");
        jPanel2.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));
        jPanel2.add(txtNipKelBK, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 220, -1));

        jScrollPane1.setViewportView(jPanel2);

        panelGlass11Keluarga.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 810, 430));

        tabelDataKeluarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Ayah", "Nama Ibu", "Nama Suami", "Nama Istri", "Jumlah Anak", "Pekerjaan Suami", "Pekerjaan Istri", "Pekerjaan Anak"
            }
        ));
        tabelDataKeluarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataKeluargaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelDataKeluargaMouseEntered(evt);
            }
        });
        jScrollPane9.setViewportView(tabelDataKeluarga);

        panelGlass11Keluarga.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 804, 163));

        jPanelSlider1.add(panelGlass11Keluarga, "card27");

        panelGlass12PengajuNaik.setOpaqueImage(false);

        jLabel186.setText("Daftar Pegawai Pengaju Naik Pangkat");

        jLabel177.setText("ID");

        jLabel178.setText("NIP");

        jLabel179.setText("Pangkat Lama");

        jLabel180.setText("Pangkat Baru");

        jLabel181.setText("Status");

        btnTungguPangkat.setText("Tunggu Persetujuan");
        btnTungguPangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTungguPangkatActionPerformed(evt);
            }
        });

        tabelDataPengajuPangkat.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDataPengajuPangkat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataPengajuPangkatMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tabelDataPengajuPangkat);

        cmbStatusBK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TUNGGU", "DITOLAK", "DITERIMA" }));

        javax.swing.GroupLayout panelGlass5Layout = new javax.swing.GroupLayout(panelGlass5);
        panelGlass5.setLayout(panelGlass5Layout);
        panelGlass5Layout.setHorizontalGroup(
            panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5Layout.createSequentialGroup()
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel186))
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTungguPangkat)
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel179)
                                    .addComponent(jLabel177, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel178, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel180, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel181, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(40, 40, 40)
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdNaikPangkat, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(txtNipNaikPangkat)
                                    .addComponent(txtPangkatLama)
                                    .addComponent(txtPangkatBaru)
                                    .addComponent(cmbStatusBK, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelGlass5Layout.setVerticalGroup(
            panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel186)
                .addGap(28, 28, 28)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177)
                    .addComponent(txtIdNaikPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel178)
                    .addComponent(txtNipNaikPangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel179)
                    .addComponent(txtPangkatLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180)
                    .addComponent(txtPangkatBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel181)
                    .addComponent(cmbStatusBK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTungguPangkat)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane18.setViewportView(panelGlass5);

        javax.swing.GroupLayout panelGlass12PengajuNaikLayout = new javax.swing.GroupLayout(panelGlass12PengajuNaik);
        panelGlass12PengajuNaik.setLayout(panelGlass12PengajuNaikLayout);
        panelGlass12PengajuNaikLayout.setHorizontalGroup(
            panelGlass12PengajuNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        panelGlass12PengajuNaikLayout.setVerticalGroup(
            panelGlass12PengajuNaikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panelGlass12PengajuNaik, "card28");

        panelGlass13PengajuPensiun.setOpaqueImage(false);

        jLabel200.setText("Daftar Pegawai Pengaju Pensiun");

        jLabel182.setText("ID");

        jLabel183.setText("NIP");

        jLabel203.setText("Status");

        btnpensBK.setText("Tunggu Prsetujuan");
        btnpensBK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpensBKActionPerformed(evt);
            }
        });

        tblPengPensBk.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPengPensBk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengPensBkMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblPengPensBk);

        CmbStatusBk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TUNGGU", "DISETUJUI" }));
        CmbStatusBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbStatusBkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass6Layout = new javax.swing.GroupLayout(panelGlass6);
        panelGlass6.setLayout(panelGlass6Layout);
        panelGlass6Layout.setHorizontalGroup(
            panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6Layout.createSequentialGroup()
                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass6Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel200))
                    .addGroup(panelGlass6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGlass6Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnpensBK)
                            .addGroup(panelGlass6Layout.createSequentialGroup()
                                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel182, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel183, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel203, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(76, 76, 76)
                                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdPengPensiBK, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(txtnipPengPensBk)
                                    .addComponent(CmbStatusBk, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelGlass6Layout.setVerticalGroup(
            panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel200)
                .addGap(28, 28, 28)
                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel182)
                    .addComponent(txtIdPengPensiBK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel183)
                    .addComponent(txtnipPengPensBk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel203)
                    .addComponent(CmbStatusBk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnpensBK)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jScrollPane19.setViewportView(panelGlass6);

        javax.swing.GroupLayout panelGlass13PengajuPensiunLayout = new javax.swing.GroupLayout(panelGlass13PengajuPensiun);
        panelGlass13PengajuPensiun.setLayout(panelGlass13PengajuPensiunLayout);
        panelGlass13PengajuPensiunLayout.setHorizontalGroup(
            panelGlass13PengajuPensiunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        panelGlass13PengajuPensiunLayout.setVerticalGroup(
            panelGlass13PengajuPensiunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panelGlass13PengajuPensiun, "card29");

        panelGlass15Pesan.setOpaqueImage(false);

        jLabel174.setText("NIP Tujuan");

        jLabel175.setText("Isi Pesan");

        taIsiPesanBK.setColumns(20);
        taIsiPesanBK.setRows(5);
        jScrollPane2.setViewportView(taIsiPesanBK);

        jLabel176.setText("PESAN");

        btnKirimPesan.setText("Kirim");
        btnKirimPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimPesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel174)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNipTujuanBK))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel175)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel176)
                        .addGap(226, 226, 226))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnKirimPesan)
                        .addGap(213, 213, 213))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel176)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel174)
                    .addComponent(tfNipTujuanBK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel175)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKirimPesan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGlass15PesanLayout = new javax.swing.GroupLayout(panelGlass15Pesan);
        panelGlass15Pesan.setLayout(panelGlass15PesanLayout);
        panelGlass15PesanLayout.setHorizontalGroup(
            panelGlass15PesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass15PesanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
        );
        panelGlass15PesanLayout.setVerticalGroup(
            panelGlass15PesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass15PesanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jPanelSlider1.add(panelGlass15Pesan, "card31");

        panelGlass16TampilInduk.setOpaqueImage(false);

        tabelTampilInduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIP", "Nama", "Jenis Kelamin", "Status", "Golongan Darah", "Gelar Depan", "Gelar Belakang", "Agama", "Tempat Lahir", "Tanggal Lahir", "No KTP", "Alamat", "No Telp", "No Ponsel", "Tahun Masuk", "ID"
            }
        ));
        jScrollPane15.setViewportView(tabelTampilInduk);

        jLabel214.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel214.setText("DATA INDUK PEGAWAI");

        btnSearchDataInduk.setText("Search");
        btnSearchDataInduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDataIndukActionPerformed(evt);
            }
        });

        jLabel17.setText("NIP  :");

        javax.swing.GroupLayout panelGlass2Layout = new javax.swing.GroupLayout(panelGlass2);
        panelGlass2.setLayout(panelGlass2Layout);
        panelGlass2Layout.setHorizontalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane15))
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jLabel214))
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSearchDataInduk)
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSearchDataInduk, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 806, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass2Layout.setVerticalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel214)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSearchDataInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchDataInduk)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(panelGlass2);

        javax.swing.GroupLayout panelGlass16TampilIndukLayout = new javax.swing.GroupLayout(panelGlass16TampilInduk);
        panelGlass16TampilInduk.setLayout(panelGlass16TampilIndukLayout);
        panelGlass16TampilIndukLayout.setHorizontalGroup(
            panelGlass16TampilIndukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        panelGlass16TampilIndukLayout.setVerticalGroup(
            panelGlass16TampilIndukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panelGlass16TampilInduk, "card31");

        panelGlass17TampilPend.setOpaqueImage(false);

        tabelTampilPendidikan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NIP", "Tingkat Pendidikan", "Tempat Pendidikan", "Jurusan", "Tanggal Ijazah", "Tahun Masuk", "Tahun Lulus"
            }
        ));
        tabelTampilPendidikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTampilPendidikanMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelTampilPendidikan);

        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel187.setText("DATA PENDIDIKAN PEGAWAI");

        jLabel18.setText("NIP    :");

        btnSearchPendidikan.setText("Search");
        btnSearchPendidikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPendidikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass3Layout = new javax.swing.GroupLayout(panelGlass3);
        panelGlass3.setLayout(panelGlass3Layout);
        panelGlass3Layout.setHorizontalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6))
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass3Layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jLabel187))
                            .addGroup(panelGlass3Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSearchPendidikan)
                                    .addGroup(panelGlass3Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSearchPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 283, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass3Layout.setVerticalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel187)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSearchPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchPendidikan)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jScrollPane16.setViewportView(panelGlass3);

        javax.swing.GroupLayout panelGlass17TampilPendLayout = new javax.swing.GroupLayout(panelGlass17TampilPend);
        panelGlass17TampilPend.setLayout(panelGlass17TampilPendLayout);
        panelGlass17TampilPendLayout.setHorizontalGroup(
            panelGlass17TampilPendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        panelGlass17TampilPendLayout.setVerticalGroup(
            panelGlass17TampilPendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panelGlass17TampilPend, "card31");

        panelGlass18TampilKel.setOpaqueImage(false);

        tabelTampilKeluarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NIP", "Nama Ayah", "Nama Ibu", "Nama Istri", "Nama Suami", "Jumlah Anak", "Pekerjaan Suami", "Pekerjaan Istri", "Pekerjaan Anak"
            }
        ));
        jScrollPane7.setViewportView(tabelTampilKeluarga);

        jLabel202.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel202.setText("DATA KELUARGA PEGAWAI");

        jLabel19.setText("NIP       :");

        btnSearchKeluarga.setText("Search");
        btnSearchKeluarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchKeluargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass4Layout = new javax.swing.GroupLayout(panelGlass4);
        panelGlass4.setLayout(panelGlass4Layout);
        panelGlass4Layout.setHorizontalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE))
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addGap(343, 343, 343)
                                .addComponent(jLabel202))
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSearchKeluarga)
                                    .addGroup(panelGlass4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSearchKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGlass4Layout.setVerticalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel202)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtSearchKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchKeluarga)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jScrollPane17.setViewportView(panelGlass4);

        javax.swing.GroupLayout panelGlass18TampilKelLayout = new javax.swing.GroupLayout(panelGlass18TampilKel);
        panelGlass18TampilKel.setLayout(panelGlass18TampilKelLayout);
        panelGlass18TampilKelLayout.setHorizontalGroup(
            panelGlass18TampilKelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        panelGlass18TampilKelLayout.setVerticalGroup(
            panelGlass18TampilKelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        jPanelSlider1.add(panelGlass18TampilKel, "card31");

        getContentPane().add(jPanelSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 550));

        jLabel184.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/picBack.jpg"))); // NOI18N
        getContentPane().add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 480));

        jMenu1.setText("Statistik Pegawai");

        btnStatistikAgama.setText("Agama");
        btnStatistikAgama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikAgamaActionPerformed(evt);
            }
        });
        jMenu1.add(btnStatistikAgama);

        btnStatistikGoldar.setText("Golongan Darah");
        btnStatistikGoldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikGoldarActionPerformed(evt);
            }
        });
        jMenu1.add(btnStatistikGoldar);

        btnStatistikPendidikan.setText("Pendidikan");
        btnStatistikPendidikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatistikPendidikanActionPerformed(evt);
            }
        });
        jMenu1.add(btnStatistikPendidikan);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data Pegawai");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenuPengajuPangkat.setText("Pengaju Naik Pangkat");
        jMenuPengajuPangkat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuPengajuPangkatMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuPengajuPangkat);

        jMenu4.setText("Pengaju Pensiun");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu6.setText("Pesan");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Logout");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

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

    private void jMenuPengajuPangkatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuPengajuPangkatMouseClicked
        jPanelSlider1.nextPanel(8,panelGlass12PengajuNaik,jPanelSlider1.left);
        controllerPengajuPangkat.isiTable();
    }//GEN-LAST:event_jMenuPengajuPangkatMouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        jPanelSlider1.nextPanel(8,panelGlass13PengajuPensiun,jPanelSlider1.left);
        controllerPengajuPensiun.isiTable();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        jPanelSlider1.nextPanel(8,panelGlass15Pesan,jPanelSlider1.left);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void btnDataKeluargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKeluargaActionPerformed
        jPanelSlider1.nextPanel(8,panelGlass18TampilKel,jPanelSlider1.left);
        controllerTampilKeluarga.isiTable();
    }//GEN-LAST:event_btnDataKeluargaActionPerformed

    private void btnTampilDataPendidikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilDataPendidikanActionPerformed

        jPanelSlider1.nextPanel(8,panelGlass17TampilPend,jPanelSlider1.left);
        controllerTampilPendidikan.isiTable();
    }//GEN-LAST:event_btnTampilDataPendidikanActionPerformed

    private void btnDataIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataIndukActionPerformed

          jPanelSlider1.nextPanel(8,panelGlass16TampilInduk,jPanelSlider1.left);
          controllerTampilInduk.isiTable();
    }//GEN-LAST:event_btnDataIndukActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        jPanelSlider1.nextPanel(8,panelGlass8DataUmum,jPanelSlider1.left);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Home home = new Home();
        home.setLayout(new BorderLayout());
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jButtonTambahDataPendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahDataPendActionPerformed
        // TODO add your handling code here:
         jPanelSlider1.nextPanel(9,panelGlass10Pendidikan,jPanelSlider1.left);
         ckb.isiTable();
    }//GEN-LAST:event_jButtonTambahDataPendActionPerformed

    private void btnTambahDataIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataIndukActionPerformed
    jPanelSlider1.nextPanel(9,panelGlass9DataInduk,jPanelSlider1.left);
        controllerIndBK.isiTable();
        
//       DataIndukPeg pendBK = new DataIndukPeg();  
//       pendBK.setOpaque(true);
//       pendBK.setVisible(true);
//       setContentPane(pendBK); 
    }//GEN-LAST:event_btnTambahDataIndukActionPerformed

    private void btnUpdatePendidikanBKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePendidikanBKActionPerformed
        // TODO add your handling code here:
        ckb.update();
        ckb.isiTable();
    }//GEN-LAST:event_btnUpdatePendidikanBKActionPerformed

    private void btnInsertPendidikanBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertPendidikanBkActionPerformed
        // TODO add your handling code here:
        ckb.insert();
        ckb.isiTable();

    }//GEN-LAST:event_btnInsertPendidikanBkActionPerformed

    private void tabelDataPendidikanBKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataPendidikanBKMouseClicked
        // TODO add your handling code here:
        ckb.isiField(tabelDataPendidikanBK.getSelectedRow());
    }//GEN-LAST:event_tabelDataPendidikanBKMouseClicked

    private void btnTambahDataKelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataKelActionPerformed
        // TODO add your handling code here:
        jPanelSlider1.nextPanel(10,panelGlass11Keluarga,jPanelSlider1.left);
        controllerKelBK.isiTable();
         
    }//GEN-LAST:event_btnTambahDataKelActionPerformed

    private void txtKerjaAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKerjaAnakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKerjaAnakActionPerformed

    private void btnUpdateKeluargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateKeluargaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateKeluargaMouseClicked

    private void btnUpdateKeluargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKeluargaActionPerformed
        controllerKelBK.update();
        controllerKelBK.isiTable();// TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateKeluargaActionPerformed

    private void btnInsertKeluargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertKeluargaActionPerformed
        controllerKelBK.insert();
        controllerKelBK.isiTable();// TODO add your handling code here:
    }//GEN-LAST:event_btnInsertKeluargaActionPerformed

    private void tabelDataKeluargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataKeluargaMouseClicked
        controllerKelBK.isiField(tabelDataKeluarga.getSelectedRow());       // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataKeluargaMouseClicked

    private void tabelDataKeluargaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataKeluargaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataKeluargaMouseEntered

    private void btnKirimPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimPesanActionPerformed
        System.out.println("nip tujuan: "+tfNipTujuanBK.getText()+"\nisi pesan:"+taIsiPesanBK.getText());
        controllerPesan.tulisPesan();
        tfNipTujuanBK.setText("");
        taIsiPesanBK.setText("");
    }//GEN-LAST:event_btnKirimPesanActionPerformed

    private void btnUpdateIndukBKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateIndukBKActionPerformed
        // TODO add your handling code here:
        controllerIndBK.update();
        controllerIndBK.isiTable();
        //        cib.update();
        //        cib.isiTable();
    }//GEN-LAST:event_btnUpdateIndukBKActionPerformed

    private void tabelDataIndukBKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataIndukBKMouseClicked
        // TODO add your handling code here:
        //cib.isiField(tabelDataIndukBK.getSelectedRow());
        controllerIndBK.isiField(tabelDataIndukBK.getSelectedRow());
    }//GEN-LAST:event_tabelDataIndukBKMouseClicked

    private void btnInsertIndukBKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertIndukBKActionPerformed
        // TODO add your handling code here:
        controllerIndBK.insert();
        controllerIndBK.isiTable();
        controllerIndBK.reset();
        //        cib.insert();
        //        cib.isiTable();
        //        cib.reset();
    }//GEN-LAST:event_btnInsertIndukBKActionPerformed

    private void txtNoKtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoKtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoKtpActionPerformed

    private void txtTglLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglLahirActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void tabelTampilPendidikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTampilPendidikanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelTampilPendidikanMouseClicked

    private void btnTungguPangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTungguPangkatActionPerformed
        
        controllerPengajuPangkat.insert();
        controllerPengajuPangkat.isiTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTungguPangkatActionPerformed

    private void tabelDataPengajuPangkatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataPengajuPangkatMouseClicked
//        controllerPengajuPangkat.isiField(tabelDataPengajuPangkat.getSelectedRow());

        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataPengajuPangkatMouseClicked

    private void txtStatusDiriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusDiriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusDiriActionPerformed

    private void btnpensBKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpensBKActionPerformed
        controllerPengajuPensiun.insert();
        controllerPengajuPensiun.isiTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpensBKActionPerformed

    private void tblPengPensBkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengPensBkMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_tblPengPensBkMouseClicked

    private void CmbStatusBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbStatusBkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbStatusBkActionPerformed

    private void btnSearchDataIndukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDataIndukActionPerformed
        // TODO add your handling code here:
        controllerTampilInduk.search();
        controllerTampilInduk.isiTableCari();
    }//GEN-LAST:event_btnSearchDataIndukActionPerformed

    private void btnSearchKeluargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchKeluargaActionPerformed
        // TODO add your handling code here:
        controllerTampilKeluarga.search();
        controllerTampilKeluarga.isiTableCari();
    }//GEN-LAST:event_btnSearchKeluargaActionPerformed

    private void btnSearchPendidikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPendidikanActionPerformed
        // TODO add your handling code here:
        controllerTampilPendidikan.search();
        controllerTampilPendidikan.isiTableCari();
    }//GEN-LAST:event_btnSearchPendidikanActionPerformed

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
            java.util.logging.Logger.getLogger(HalUtamaBK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalUtamaBK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalUtamaBK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalUtamaBK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new HalUtamaBK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbStatusBk;
    private javax.swing.JLabel S2;
    private javax.swing.JLabel S3;
    private javax.swing.JButton btnDataInduk;
    private javax.swing.JButton btnDataKeluarga;
    private javax.swing.JButton btnInsertIndukBK;
    private javax.swing.JButton btnInsertKeluarga;
    private javax.swing.JButton btnInsertPendidikanBk;
    private javax.swing.JButton btnKirimPesan;
    private javax.swing.JButton btnSearchDataInduk;
    private javax.swing.JButton btnSearchKeluarga;
    private javax.swing.JButton btnSearchPendidikan;
    private javax.swing.JMenuItem btnStatistikAgama;
    private javax.swing.JMenuItem btnStatistikGoldar;
    private javax.swing.JMenuItem btnStatistikPendidikan;
    private javax.swing.JButton btnTambahDataInduk;
    private javax.swing.JToggleButton btnTambahDataKel;
    private javax.swing.JButton btnTampilDataPendidikan;
    private javax.swing.JButton btnTungguPangkat;
    private javax.swing.JButton btnUpdateIndukBK;
    private javax.swing.JButton btnUpdateKeluarga;
    private javax.swing.JButton btnUpdatePendidikanBK;
    private javax.swing.JButton btnpensBK;
    private javax.swing.JComboBox cmbStatusBK;
    private javax.swing.JButton jButtonTambahDataPend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuPengajuPangkat;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSlider1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
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
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelGlass10Pendidikan;
    private usu.widget.glass.PanelGlass panelGlass11Keluarga;
    private usu.widget.glass.PanelGlass panelGlass12PengajuNaik;
    private usu.widget.glass.PanelGlass panelGlass13PengajuPensiun;
    private usu.widget.glass.PanelGlass panelGlass15Pesan;
    private usu.widget.glass.PanelGlass panelGlass16TampilInduk;
    private usu.widget.glass.PanelGlass panelGlass17TampilPend;
    private usu.widget.glass.PanelGlass panelGlass18TampilKel;
    private usu.widget.glass.PanelGlass panelGlass1HomeBk;
    private usu.widget.glass.PanelGlass panelGlass2;
    private usu.widget.glass.PanelGlass panelGlass2StatistikNaik;
    private usu.widget.glass.PanelGlass panelGlass3;
    private usu.widget.glass.PanelGlass panelGlass3StatistikAgama;
    private usu.widget.glass.PanelGlass panelGlass4;
    private usu.widget.glass.PanelGlass panelGlass4StatistikGolongan;
    private usu.widget.glass.PanelGlass panelGlass5;
    private usu.widget.glass.PanelGlass panelGlass5StatistikUmur;
    private usu.widget.glass.PanelGlass panelGlass6;
    private usu.widget.glass.PanelGlass panelGlass6StatistikGoldar;
    private usu.widget.glass.PanelGlass panelGlass7;
    private usu.widget.glass.PanelGlass panelGlass7StatistikPendidikan;
    private usu.widget.glass.PanelGlass panelGlass8;
    private usu.widget.glass.PanelGlass panelGlass8DataUmum;
    private usu.widget.glass.PanelGlass panelGlass9DataInduk;
    private javax.swing.JTextArea taIsiPesanBK;
    private javax.swing.JTable tabelDataIndukBK;
    private javax.swing.JTable tabelDataKeluarga;
    private javax.swing.JTable tabelDataPendidikanBK;
    private javax.swing.JTable tabelDataPengajuPangkat;
    private javax.swing.JTable tabelTampilInduk;
    private javax.swing.JTable tabelTampilKeluarga;
    private javax.swing.JTable tabelTampilPendidikan;
    private javax.swing.JTable tblPengPensBk;
    private javax.swing.JTextField tfNipTujuanBK;
    private javax.swing.JTextField txtAgama;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtAyah;
    private javax.swing.JTextField txtGelarBelakang;
    private javax.swing.JTextField txtGelarDepan;
    private javax.swing.JTextField txtGolDar;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIbu;
    private javax.swing.JTextField txtIdKelBK;
    private javax.swing.JTextField txtIdNaikPangkat;
    private javax.swing.JTextField txtIdPangkat;
    private javax.swing.JTextField txtIdPengPensiBK;
    private javax.swing.JTextField txtIstri;
    private javax.swing.JTextField txtJk;
    private javax.swing.JTextField txtJmlAnak;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtKerjaAnak;
    private javax.swing.JTextField txtKerjaIstri;
    private javax.swing.JTextField txtKerjaSuami;
    private javax.swing.JTextField txtNIPPendidikanBK;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNipIndukBK;
    private javax.swing.JTextField txtNipKelBK;
    private javax.swing.JTextField txtNipNaikPangkat;
    private javax.swing.JTextField txtNoKtp;
    private javax.swing.JTextField txtNoPonsel;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JTextField txtPangkatBaru;
    private javax.swing.JTextField txtPangkatLama;
    private javax.swing.JTextField txtSearchDataInduk;
    private javax.swing.JTextField txtSearchKeluarga;
    private javax.swing.JTextField txtSearchPendidikan;
    private javax.swing.JTextField txtStatusDiri;
    private javax.swing.JTextField txtSuami;
    private javax.swing.JTextField txtTahunLulus;
    private javax.swing.JTextField txtTahunMasukIndukBK;
    private javax.swing.JTextField txtTahunMasukPendidikan;
    private javax.swing.JTextField txtTanggalIjazah;
    private javax.swing.JTextField txtTempatLahir;
    private javax.swing.JTextField txtTempatPend;
    private javax.swing.JTextField txtTglLahir;
    private javax.swing.JTextField txtnipPengPensBk;
    private javax.swing.JTextField txttingkatPend;
    // End of variables declaration//GEN-END:variables
 
}

