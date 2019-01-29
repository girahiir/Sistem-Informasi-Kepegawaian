/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbjos;

import Entities.Tbldataindukpeg;
import Entities.Tbldatariwayatpend;
import EntitiesController.TbldataindukpegJpaController;
import EntitiesController.TbldatariwayatpendJpaController;
import java.util.List;
import java.util.Map;
import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author Arsyadi Ahmad
 */
public class Kbjos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("kbjosPU");
        TbldataindukpegJpaController tdi = new TbldataindukpegJpaController(emf);
        TbldatariwayatpendJpaController tdrp = new TbldatariwayatpendJpaController(emf);
        
        Tbldataindukpeg datainduk;
        datainduk = tdi.findTbldataindukpeg("admin");
        System.out.println("Jumlah Pegawai: " + tdi.getTbldataindukpegCount());
        System.out.println("");
        
        //agama
        System.out.println("Statistik Agama");
        List<Entities.Tbldataindukpeg> islam = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Islam");
        System.out.println("Pegawai yang beragama Islam >>" + islam.size());
        List<Entities.Tbldataindukpeg> islamPria = tdi.findTbldataindukpegBy(islam, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang beragama Islam - Pria >>" + islamPria.size());
        List<Entities.Tbldataindukpeg> islamWanita = tdi.findTbldataindukpegBy(islam, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang beragama Islam - Wanita >>" + islamWanita.size());
        
        List<Entities.Tbldataindukpeg> Kristen = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Kristen");
        System.out.println("Pegawai yang beragama Kristen >>" + Kristen.size());
        List<Entities.Tbldataindukpeg> kristenPria = tdi.findTbldataindukpegBy(Kristen, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang beragama Kristen - Pria >>" + kristenPria.size());
        List<Entities.Tbldataindukpeg> kristenWanita = tdi.findTbldataindukpegBy(Kristen, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang beragama Kristen - Wanita >>" + kristenWanita.size());
        
        List<Entities.Tbldataindukpeg> Katolik = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Katolik");
        System.out.println("Pegawai yang beragama Katolik >>" + Katolik.size());
        List<Entities.Tbldataindukpeg> katolikPria = tdi.findTbldataindukpegBy(Katolik, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang beragama Katolik - Pria >>" + katolikPria.size());
        List<Entities.Tbldataindukpeg> katolikWanita = tdi.findTbldataindukpegBy(Katolik, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang beragama Katolik - Wanita >>" + katolikWanita.size());
        
        List<Entities.Tbldataindukpeg> Hindu = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Hindu");
        System.out.println("Pegawai yang beragama Hindu >>" + Hindu.size());
        List<Entities.Tbldataindukpeg> hinduPria = tdi.findTbldataindukpegBy(Hindu, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang beragama Hindu - Pria >>" + hinduPria.size());
        List<Entities.Tbldataindukpeg> hinduWanita = tdi.findTbldataindukpegBy(Hindu, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang beragama Hindu - Wanita >>" + hinduWanita.size());
        
        List<Entities.Tbldataindukpeg> Budha = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.AGAMA, "Budha");
        System.out.println("Pegawai yang beragama Budha >>" + Budha.size());
        List<Entities.Tbldataindukpeg> budhaPria = tdi.findTbldataindukpegBy(Budha, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang beragama Budha - Pria >>" + budhaPria.size());
        List<Entities.Tbldataindukpeg> budhaWanita = tdi.findTbldataindukpegBy(Budha, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang beragama Budha - Wanita >>" + budhaWanita.size());
        System.out.println("");
        
        //golongan darah
        System.out.println("Statistik Golongan Darah");
        List<Entities.Tbldataindukpeg> golA = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "A");
        System.out.println("Pegawai yang memiliki golongan darah A >>" + golA.size());
        List<Entities.Tbldataindukpeg> golAPria = tdi.findTbldataindukpegBy(golA, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang memiliki golongan darah A - Pria >>" + golAPria.size());
        List<Entities.Tbldataindukpeg> golAWanita = tdi.findTbldataindukpegBy(golA, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang memiliki golongan darah A - Wanita >>" + golAWanita.size());
        List<Entities.Tbldataindukpeg> golB = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "B");
        System.out.println("Pegawai yang memiliki golongan dara B >>" + golB.size());
        List<Entities.Tbldataindukpeg> golBPria = tdi.findTbldataindukpegBy(golB, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang memiliki golongan dara B - Pria >>" + golBPria.size());
        List<Entities.Tbldataindukpeg> golBWanita = tdi.findTbldataindukpegBy(golB, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang memiliki golongan dara B - Wanita >>" + golBWanita.size());
        List<Entities.Tbldataindukpeg> golO = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "O");
        System.out.println("Pegawai yang memiliki golongan dara O >>" + golO.size());
        List<Entities.Tbldataindukpeg> golOPria = tdi.findTbldataindukpegBy(golO, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang memiliki golongan dara O - Pria >>" + golOPria.size());
        List<Entities.Tbldataindukpeg> golOWanita = tdi.findTbldataindukpegBy(golO, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang memiliki golongan dara O - Wanita >>" + golOWanita.size());
        List<Entities.Tbldataindukpeg> golAB = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.GOLDARAH, "AB");
        System.out.println("Pegawai yang memiliki golongan dara AB >>" + golAB.size());
        List<Entities.Tbldataindukpeg> golABPria = tdi.findTbldataindukpegBy(golAB, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai yang memiliki golongan dara AB - Pria >>" + golABPria.size());
        List<Entities.Tbldataindukpeg> golABWanita = tdi.findTbldataindukpegBy(golAB, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai yang memiliki golongan dara AB - Wanita >>" + golABWanita.size());
        System.out.println("");
        
        //golongan pangkat - belum sepenuhnya
        List<Entities.Tbldataindukpeg> golIA = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "p01");
        List<Entities.Tbldataindukpeg> golIB = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "p01");
        List<Entities.Tbldataindukpeg> golIC = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "p01");
        List<Entities.Tbldataindukpeg> golID = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "p01");
        int golI =  golIA.size() + golIB.size() + golIC.size() + golID.size() ;
        System.out.println("Pegawai Golongan I >>" + golIA.size());
        List<Entities.Tbldataindukpeg> golII = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "B");
        System.out.println("Pegawai Golongan II >>" + golB.size());
        List<Entities.Tbldataindukpeg> golIII = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "O");
        System.out.println("Pegawai Golongan III >>" + golO.size());
        List<Entities.Tbldataindukpeg> golIV = tdi.findTbldataindukpegBy(tdi.findTbldataindukpegEntities(), TbldataindukpegJpaController.Column.IDPANGKAT, "AB");
        System.out.println("Pegawai Golongan IV >>" + golAB.size());
        System.out.println("");
        
        //tingkat pendidikan
        System.out.println("Statistik Pendidikan");
        List<Entities.Tbldatariwayatpend> golSD = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "SD");
        System.out.println("Pegawai dengan pendidikan terakhir SD >>" + golSD.size());
        List<Entities.Tbldataindukpeg> golSD_dataInduk = tdrp.getTbldataindukpeg(golSD);
        List<Tbldataindukpeg> golSDPria = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai dengan pendidikan terakhir SD - Pria >>" + golSDPria.size());
        List<Tbldataindukpeg> golSDWanita = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai dengan pendidikan terakhir SD - Wanita >>" + golSDWanita.size());
        
        List<Entities.Tbldatariwayatpend> golSMP = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "SMP");
        System.out.println("Pegawai dengan pendidikan terakhir SMP >>" + golSMP.size());
        List<Entities.Tbldataindukpeg> golSMP_dataInduk = tdrp.getTbldataindukpeg(golSMP);
        List<Tbldataindukpeg> golSMPPria = tdi.findTbldataindukpegBy(golSMP_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai dengan pendidikan terakhir SMP - Pria >>" + golSDPria.size());
        List<Tbldataindukpeg> golSMPWanita = tdi.findTbldataindukpegBy(golSMP_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai dengan pendidikan terakhir SMP - Wanita >>" + golSDWanita.size());
        
        List<Entities.Tbldatariwayatpend> golSMA = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "SMA");
        System.out.println("Pegawai dengan pendidikan terakhir SMA >>" + golSMA.size());
        List<Entities.Tbldataindukpeg> golSMA_dataInduk = tdrp.getTbldataindukpeg(golSMA);
        List<Tbldataindukpeg> golSMAPria = tdi.findTbldataindukpegBy(golSMA_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai dengan pendidikan terakhir SMA - Pria >>" + golSDPria.size());
        List<Tbldataindukpeg> golSMAWanita = tdi.findTbldataindukpegBy(golSMA_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai dengan pendidikan terakhir SMA - Wanita >>" + golSDWanita.size());
        
        List<Entities.Tbldatariwayatpend> golS1 = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "S1");
        System.out.println("Pegawai dengan pendidikan terakhir S1 >>" + golS1.size());
        List<Entities.Tbldataindukpeg> golS1_dataInduk = tdrp.getTbldataindukpeg(golS1);
        List<Tbldataindukpeg> golS1Pria = tdi.findTbldataindukpegBy(golS1_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai dengan pendidikan terakhir S1 - Pria >>" + golS1Pria.size());
        List<Tbldataindukpeg> golS1Wanita = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai dengan pendidikan terakhir S1 - Wanita >>" + golS1Wanita.size());
        
        List<Entities.Tbldatariwayatpend> golS2 = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "S2");
        System.out.println("Pegawai dengan pendidikan terakhir S2 >>" + golS2.size());
        List<Entities.Tbldataindukpeg> golS2_dataInduk = tdrp.getTbldataindukpeg(golS2);
        List<Tbldataindukpeg> golS2Pria = tdi.findTbldataindukpegBy(golS2_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai dengan pendidikan terakhir S2 - Pria >>" + golS2Pria.size());
        List<Tbldataindukpeg> golS2Wanita = tdi.findTbldataindukpegBy(golS2_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai dengan pendidikan terakhir S2 - Wanita >>" + golS2Wanita.size());
        
        List<Entities.Tbldatariwayatpend> golS3 = tdrp.findTbldatariwayatpendBy(tdrp.findTbldatariwayatpendEntities(), TbldatariwayatpendJpaController.Column.TINGKATPENDIDIKAN, "S3");
        System.out.println("Pegawai dengan pendidikan terakhir S3 >>" + golS3.size());
        List<Entities.Tbldataindukpeg> golS3_dataInduk = tdrp.getTbldataindukpeg(golS3);
        List<Tbldataindukpeg> golS3Pria = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "P");
        System.out.println("-Pegawai dengan pendidikan terakhir S3 - Pria >>" + golS3Pria.size());
        List<Tbldataindukpeg> golS3Wanita = tdi.findTbldataindukpegBy(golSD_dataInduk, TbldataindukpegJpaController.Column.JENISKELAMIN, "W");
        System.out.println("-Pegawai dengan pendidikan terakhir S3 - Wanita >>" + golS3Wanita.size());        
        System.out.println("");
        
        //umur
        System.out.println("");
        
        
    }
    
}
