/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesController;

import Entities.Tbldataindukpeg;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Tbldatapangkat;
import Entities.Tbldatapengajupangkat;
import java.util.ArrayList;
import java.util.List;
import Entities.Tblpengajupensiun;
import Entities.Tblterimanaikpangkat;
import Entities.Tbldatauser;
import Entities.Tbltolaknaikpangkat;
import Entities.Tbldatakeluarga;
import Entities.Tbldatapensiun;
import Entities.Tbldatariwayatpend;
import EntitiesController.exceptions.IllegalOrphanException;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.Iterator;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TbldataindukpegJpaController implements Serializable {

    public static enum Column {
        NIP,
        NAMA,
        JENISKELAMIN,
        STATUS,
        GOLDARAH,
        GELARDEPAN,
        GELARBELAKANG,
        AGAMA,
        TEMPATLAHIR,
        TGLLAHIR,
        NOKTP,
        ALAMAT,
        TELRUMAH,
        NOPONSEL,
        TAHUNMASUK,
        IDPANGKAT,
    }
    
    public TbldataindukpegJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldataindukpeg tbldataindukpeg) throws PreexistingEntityException, Exception {
        if (tbldataindukpeg.getTbldatapengajupangkatList() == null) {
            tbldataindukpeg.setTbldatapengajupangkatList(new ArrayList<Tbldatapengajupangkat>());
        }
        if (tbldataindukpeg.getTblpengajupensiunList() == null) {
            tbldataindukpeg.setTblpengajupensiunList(new ArrayList<Tblpengajupensiun>());
        }
        if (tbldataindukpeg.getTblterimanaikpangkatList() == null) {
            tbldataindukpeg.setTblterimanaikpangkatList(new ArrayList<Tblterimanaikpangkat>());
        }
        if (tbldataindukpeg.getTblterimanaikpangkatList1() == null) {
            tbldataindukpeg.setTblterimanaikpangkatList1(new ArrayList<Tblterimanaikpangkat>());
        }
        if (tbldataindukpeg.getTbldatauserList() == null) {
            tbldataindukpeg.setTbldatauserList(new ArrayList<Tbldatauser>());
        }
        if (tbldataindukpeg.getTbltolaknaikpangkatList() == null) {
            tbldataindukpeg.setTbltolaknaikpangkatList(new ArrayList<Tbltolaknaikpangkat>());
        }
        if (tbldataindukpeg.getTbldatakeluargaList() == null) {
            tbldataindukpeg.setTbldatakeluargaList(new ArrayList<Tbldatakeluarga>());
        }
        if (tbldataindukpeg.getTbldatapensiunList() == null) {
            tbldataindukpeg.setTbldatapensiunList(new ArrayList<Tbldatapensiun>());
        }
        if (tbldataindukpeg.getTbldatariwayatpendList() == null) {
            tbldataindukpeg.setTbldatariwayatpendList(new ArrayList<Tbldatariwayatpend>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapangkat idPangkat = tbldataindukpeg.getIdPangkat();
            if (idPangkat != null) {
                idPangkat = em.getReference(idPangkat.getClass(), idPangkat.getIdPangkat());
                tbldataindukpeg.setIdPangkat(idPangkat);
            }
            List<Tbldatapengajupangkat> attachedTbldatapengajupangkatList = new ArrayList<Tbldatapengajupangkat>();
            for (Tbldatapengajupangkat tbldatapengajupangkatListTbldatapengajupangkatToAttach : tbldataindukpeg.getTbldatapengajupangkatList()) {
                tbldatapengajupangkatListTbldatapengajupangkatToAttach = em.getReference(tbldatapengajupangkatListTbldatapengajupangkatToAttach.getClass(), tbldatapengajupangkatListTbldatapengajupangkatToAttach.getIdPengajuPangkat());
                attachedTbldatapengajupangkatList.add(tbldatapengajupangkatListTbldatapengajupangkatToAttach);
            }
            tbldataindukpeg.setTbldatapengajupangkatList(attachedTbldatapengajupangkatList);
            List<Tblpengajupensiun> attachedTblpengajupensiunList = new ArrayList<Tblpengajupensiun>();
            for (Tblpengajupensiun tblpengajupensiunListTblpengajupensiunToAttach : tbldataindukpeg.getTblpengajupensiunList()) {
                tblpengajupensiunListTblpengajupensiunToAttach = em.getReference(tblpengajupensiunListTblpengajupensiunToAttach.getClass(), tblpengajupensiunListTblpengajupensiunToAttach.getIdPengajuPensiun());
                attachedTblpengajupensiunList.add(tblpengajupensiunListTblpengajupensiunToAttach);
            }
            tbldataindukpeg.setTblpengajupensiunList(attachedTblpengajupensiunList);
            List<Tblterimanaikpangkat> attachedTblterimanaikpangkatList = new ArrayList<Tblterimanaikpangkat>();
            for (Tblterimanaikpangkat tblterimanaikpangkatListTblterimanaikpangkatToAttach : tbldataindukpeg.getTblterimanaikpangkatList()) {
                tblterimanaikpangkatListTblterimanaikpangkatToAttach = em.getReference(tblterimanaikpangkatListTblterimanaikpangkatToAttach.getClass(), tblterimanaikpangkatListTblterimanaikpangkatToAttach.getIdTerima());
                attachedTblterimanaikpangkatList.add(tblterimanaikpangkatListTblterimanaikpangkatToAttach);
            }
            tbldataindukpeg.setTblterimanaikpangkatList(attachedTblterimanaikpangkatList);
            List<Tblterimanaikpangkat> attachedTblterimanaikpangkatList1 = new ArrayList<Tblterimanaikpangkat>();
            for (Tblterimanaikpangkat tblterimanaikpangkatList1TblterimanaikpangkatToAttach : tbldataindukpeg.getTblterimanaikpangkatList1()) {
                tblterimanaikpangkatList1TblterimanaikpangkatToAttach = em.getReference(tblterimanaikpangkatList1TblterimanaikpangkatToAttach.getClass(), tblterimanaikpangkatList1TblterimanaikpangkatToAttach.getIdTerima());
                attachedTblterimanaikpangkatList1.add(tblterimanaikpangkatList1TblterimanaikpangkatToAttach);
            }
            tbldataindukpeg.setTblterimanaikpangkatList1(attachedTblterimanaikpangkatList1);
            List<Tbldatauser> attachedTbldatauserList = new ArrayList<Tbldatauser>();
            for (Tbldatauser tbldatauserListTbldatauserToAttach : tbldataindukpeg.getTbldatauserList()) {
                tbldatauserListTbldatauserToAttach = em.getReference(tbldatauserListTbldatauserToAttach.getClass(), tbldatauserListTbldatauserToAttach.getIdUser());
                attachedTbldatauserList.add(tbldatauserListTbldatauserToAttach);
            }
            tbldataindukpeg.setTbldatauserList(attachedTbldatauserList);
            List<Tbltolaknaikpangkat> attachedTbltolaknaikpangkatList = new ArrayList<Tbltolaknaikpangkat>();
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListTbltolaknaikpangkatToAttach : tbldataindukpeg.getTbltolaknaikpangkatList()) {
                tbltolaknaikpangkatListTbltolaknaikpangkatToAttach = em.getReference(tbltolaknaikpangkatListTbltolaknaikpangkatToAttach.getClass(), tbltolaknaikpangkatListTbltolaknaikpangkatToAttach.getIdTolak());
                attachedTbltolaknaikpangkatList.add(tbltolaknaikpangkatListTbltolaknaikpangkatToAttach);
            }
            tbldataindukpeg.setTbltolaknaikpangkatList(attachedTbltolaknaikpangkatList);
            List<Tbldatakeluarga> attachedTbldatakeluargaList = new ArrayList<Tbldatakeluarga>();
            for (Tbldatakeluarga tbldatakeluargaListTbldatakeluargaToAttach : tbldataindukpeg.getTbldatakeluargaList()) {
                tbldatakeluargaListTbldatakeluargaToAttach = em.getReference(tbldatakeluargaListTbldatakeluargaToAttach.getClass(), tbldatakeluargaListTbldatakeluargaToAttach.getIdDk());
                attachedTbldatakeluargaList.add(tbldatakeluargaListTbldatakeluargaToAttach);
            }
            tbldataindukpeg.setTbldatakeluargaList(attachedTbldatakeluargaList);
            List<Tbldatapensiun> attachedTbldatapensiunList = new ArrayList<Tbldatapensiun>();
            for (Tbldatapensiun tbldatapensiunListTbldatapensiunToAttach : tbldataindukpeg.getTbldatapensiunList()) {
                tbldatapensiunListTbldatapensiunToAttach = em.getReference(tbldatapensiunListTbldatapensiunToAttach.getClass(), tbldatapensiunListTbldatapensiunToAttach.getIdDataPensiun());
                attachedTbldatapensiunList.add(tbldatapensiunListTbldatapensiunToAttach);
            }
            tbldataindukpeg.setTbldatapensiunList(attachedTbldatapensiunList);
            List<Tbldatariwayatpend> attachedTbldatariwayatpendList = new ArrayList<Tbldatariwayatpend>();
            for (Tbldatariwayatpend tbldatariwayatpendListTbldatariwayatpendToAttach : tbldataindukpeg.getTbldatariwayatpendList()) {
                tbldatariwayatpendListTbldatariwayatpendToAttach = em.getReference(tbldatariwayatpendListTbldatariwayatpendToAttach.getClass(), tbldatariwayatpendListTbldatariwayatpendToAttach.getIdRp());
                attachedTbldatariwayatpendList.add(tbldatariwayatpendListTbldatariwayatpendToAttach);
            }
            tbldataindukpeg.setTbldatariwayatpendList(attachedTbldatariwayatpendList);
            em.persist(tbldataindukpeg);
            if (idPangkat != null) {
                idPangkat.getTbldataindukpegList().add(tbldataindukpeg);
                idPangkat = em.merge(idPangkat);
            }
            for (Tbldatapengajupangkat tbldatapengajupangkatListTbldatapengajupangkat : tbldataindukpeg.getTbldatapengajupangkatList()) {
                Tbldataindukpeg oldNipOfTbldatapengajupangkatListTbldatapengajupangkat = tbldatapengajupangkatListTbldatapengajupangkat.getNip();
                tbldatapengajupangkatListTbldatapengajupangkat.setNip(tbldataindukpeg);
                tbldatapengajupangkatListTbldatapengajupangkat = em.merge(tbldatapengajupangkatListTbldatapengajupangkat);
                if (oldNipOfTbldatapengajupangkatListTbldatapengajupangkat != null) {
                    oldNipOfTbldatapengajupangkatListTbldatapengajupangkat.getTbldatapengajupangkatList().remove(tbldatapengajupangkatListTbldatapengajupangkat);
                    oldNipOfTbldatapengajupangkatListTbldatapengajupangkat = em.merge(oldNipOfTbldatapengajupangkatListTbldatapengajupangkat);
                }
            }
            for (Tblpengajupensiun tblpengajupensiunListTblpengajupensiun : tbldataindukpeg.getTblpengajupensiunList()) {
                Tbldataindukpeg oldNipOfTblpengajupensiunListTblpengajupensiun = tblpengajupensiunListTblpengajupensiun.getNip();
                tblpengajupensiunListTblpengajupensiun.setNip(tbldataindukpeg);
                tblpengajupensiunListTblpengajupensiun = em.merge(tblpengajupensiunListTblpengajupensiun);
                if (oldNipOfTblpengajupensiunListTblpengajupensiun != null) {
                    oldNipOfTblpengajupensiunListTblpengajupensiun.getTblpengajupensiunList().remove(tblpengajupensiunListTblpengajupensiun);
                    oldNipOfTblpengajupensiunListTblpengajupensiun = em.merge(oldNipOfTblpengajupensiunListTblpengajupensiun);
                }
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatListTblterimanaikpangkat : tbldataindukpeg.getTblterimanaikpangkatList()) {
                Tbldataindukpeg oldNipOfTblterimanaikpangkatListTblterimanaikpangkat = tblterimanaikpangkatListTblterimanaikpangkat.getNip();
                tblterimanaikpangkatListTblterimanaikpangkat.setNip(tbldataindukpeg);
                tblterimanaikpangkatListTblterimanaikpangkat = em.merge(tblterimanaikpangkatListTblterimanaikpangkat);
                if (oldNipOfTblterimanaikpangkatListTblterimanaikpangkat != null) {
                    oldNipOfTblterimanaikpangkatListTblterimanaikpangkat.getTblterimanaikpangkatList().remove(tblterimanaikpangkatListTblterimanaikpangkat);
                    oldNipOfTblterimanaikpangkatListTblterimanaikpangkat = em.merge(oldNipOfTblterimanaikpangkatListTblterimanaikpangkat);
                }
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatList1Tblterimanaikpangkat : tbldataindukpeg.getTblterimanaikpangkatList1()) {
                Tbldataindukpeg oldIdPangkatbaruOfTblterimanaikpangkatList1Tblterimanaikpangkat = tblterimanaikpangkatList1Tblterimanaikpangkat.getIdPangkatbaru();
                tblterimanaikpangkatList1Tblterimanaikpangkat.setIdPangkatbaru(tbldataindukpeg);
                tblterimanaikpangkatList1Tblterimanaikpangkat = em.merge(tblterimanaikpangkatList1Tblterimanaikpangkat);
                if (oldIdPangkatbaruOfTblterimanaikpangkatList1Tblterimanaikpangkat != null) {
                    oldIdPangkatbaruOfTblterimanaikpangkatList1Tblterimanaikpangkat.getTblterimanaikpangkatList1().remove(tblterimanaikpangkatList1Tblterimanaikpangkat);
                    oldIdPangkatbaruOfTblterimanaikpangkatList1Tblterimanaikpangkat = em.merge(oldIdPangkatbaruOfTblterimanaikpangkatList1Tblterimanaikpangkat);
                }
            }
            for (Tbldatauser tbldatauserListTbldatauser : tbldataindukpeg.getTbldatauserList()) {
                Tbldataindukpeg oldNipOfTbldatauserListTbldatauser = tbldatauserListTbldatauser.getNip();
                tbldatauserListTbldatauser.setNip(tbldataindukpeg);
                tbldatauserListTbldatauser = em.merge(tbldatauserListTbldatauser);
                if (oldNipOfTbldatauserListTbldatauser != null) {
                    oldNipOfTbldatauserListTbldatauser.getTbldatauserList().remove(tbldatauserListTbldatauser);
                    oldNipOfTbldatauserListTbldatauser = em.merge(oldNipOfTbldatauserListTbldatauser);
                }
            }
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListTbltolaknaikpangkat : tbldataindukpeg.getTbltolaknaikpangkatList()) {
                Tbldataindukpeg oldNipOfTbltolaknaikpangkatListTbltolaknaikpangkat = tbltolaknaikpangkatListTbltolaknaikpangkat.getNip();
                tbltolaknaikpangkatListTbltolaknaikpangkat.setNip(tbldataindukpeg);
                tbltolaknaikpangkatListTbltolaknaikpangkat = em.merge(tbltolaknaikpangkatListTbltolaknaikpangkat);
                if (oldNipOfTbltolaknaikpangkatListTbltolaknaikpangkat != null) {
                    oldNipOfTbltolaknaikpangkatListTbltolaknaikpangkat.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkatListTbltolaknaikpangkat);
                    oldNipOfTbltolaknaikpangkatListTbltolaknaikpangkat = em.merge(oldNipOfTbltolaknaikpangkatListTbltolaknaikpangkat);
                }
            }
            for (Tbldatakeluarga tbldatakeluargaListTbldatakeluarga : tbldataindukpeg.getTbldatakeluargaList()) {
                Tbldataindukpeg oldNipOfTbldatakeluargaListTbldatakeluarga = tbldatakeluargaListTbldatakeluarga.getNip();
                tbldatakeluargaListTbldatakeluarga.setNip(tbldataindukpeg);
                tbldatakeluargaListTbldatakeluarga = em.merge(tbldatakeluargaListTbldatakeluarga);
                if (oldNipOfTbldatakeluargaListTbldatakeluarga != null) {
                    oldNipOfTbldatakeluargaListTbldatakeluarga.getTbldatakeluargaList().remove(tbldatakeluargaListTbldatakeluarga);
                    oldNipOfTbldatakeluargaListTbldatakeluarga = em.merge(oldNipOfTbldatakeluargaListTbldatakeluarga);
                }
            }
            for (Tbldatapensiun tbldatapensiunListTbldatapensiun : tbldataindukpeg.getTbldatapensiunList()) {
                Tbldataindukpeg oldNipOfTbldatapensiunListTbldatapensiun = tbldatapensiunListTbldatapensiun.getNip();
                tbldatapensiunListTbldatapensiun.setNip(tbldataindukpeg);
                tbldatapensiunListTbldatapensiun = em.merge(tbldatapensiunListTbldatapensiun);
                if (oldNipOfTbldatapensiunListTbldatapensiun != null) {
                    oldNipOfTbldatapensiunListTbldatapensiun.getTbldatapensiunList().remove(tbldatapensiunListTbldatapensiun);
                    oldNipOfTbldatapensiunListTbldatapensiun = em.merge(oldNipOfTbldatapensiunListTbldatapensiun);
                }
            }
            for (Tbldatariwayatpend tbldatariwayatpendListTbldatariwayatpend : tbldataindukpeg.getTbldatariwayatpendList()) {
                Tbldataindukpeg oldNipOfTbldatariwayatpendListTbldatariwayatpend = tbldatariwayatpendListTbldatariwayatpend.getNip();
                tbldatariwayatpendListTbldatariwayatpend.setNip(tbldataindukpeg);
                tbldatariwayatpendListTbldatariwayatpend = em.merge(tbldatariwayatpendListTbldatariwayatpend);
                if (oldNipOfTbldatariwayatpendListTbldatariwayatpend != null) {
                    oldNipOfTbldatariwayatpendListTbldatariwayatpend.getTbldatariwayatpendList().remove(tbldatariwayatpendListTbldatariwayatpend);
                    oldNipOfTbldatariwayatpendListTbldatariwayatpend = em.merge(oldNipOfTbldatariwayatpendListTbldatariwayatpend);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldataindukpeg(tbldataindukpeg.getNip()) != null) {
                throw new PreexistingEntityException("Tbldataindukpeg " + tbldataindukpeg + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldataindukpeg tbldataindukpeg) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg persistentTbldataindukpeg = em.find(Tbldataindukpeg.class, tbldataindukpeg.getNip());
            Tbldatapangkat idPangkatOld = persistentTbldataindukpeg.getIdPangkat();
            Tbldatapangkat idPangkatNew = tbldataindukpeg.getIdPangkat();
            List<Tbldatapengajupangkat> tbldatapengajupangkatListOld = persistentTbldataindukpeg.getTbldatapengajupangkatList();
            List<Tbldatapengajupangkat> tbldatapengajupangkatListNew = tbldataindukpeg.getTbldatapengajupangkatList();
            List<Tblpengajupensiun> tblpengajupensiunListOld = persistentTbldataindukpeg.getTblpengajupensiunList();
            List<Tblpengajupensiun> tblpengajupensiunListNew = tbldataindukpeg.getTblpengajupensiunList();
            List<Tblterimanaikpangkat> tblterimanaikpangkatListOld = persistentTbldataindukpeg.getTblterimanaikpangkatList();
            List<Tblterimanaikpangkat> tblterimanaikpangkatListNew = tbldataindukpeg.getTblterimanaikpangkatList();
            List<Tblterimanaikpangkat> tblterimanaikpangkatList1Old = persistentTbldataindukpeg.getTblterimanaikpangkatList1();
            List<Tblterimanaikpangkat> tblterimanaikpangkatList1New = tbldataindukpeg.getTblterimanaikpangkatList1();
            List<Tbldatauser> tbldatauserListOld = persistentTbldataindukpeg.getTbldatauserList();
            List<Tbldatauser> tbldatauserListNew = tbldataindukpeg.getTbldatauserList();
            List<Tbltolaknaikpangkat> tbltolaknaikpangkatListOld = persistentTbldataindukpeg.getTbltolaknaikpangkatList();
            List<Tbltolaknaikpangkat> tbltolaknaikpangkatListNew = tbldataindukpeg.getTbltolaknaikpangkatList();
            List<Tbldatakeluarga> tbldatakeluargaListOld = persistentTbldataindukpeg.getTbldatakeluargaList();
            List<Tbldatakeluarga> tbldatakeluargaListNew = tbldataindukpeg.getTbldatakeluargaList();
            List<Tbldatapensiun> tbldatapensiunListOld = persistentTbldataindukpeg.getTbldatapensiunList();
            List<Tbldatapensiun> tbldatapensiunListNew = tbldataindukpeg.getTbldatapensiunList();
            List<Tbldatariwayatpend> tbldatariwayatpendListOld = persistentTbldataindukpeg.getTbldatariwayatpendList();
            List<Tbldatariwayatpend> tbldatariwayatpendListNew = tbldataindukpeg.getTbldatariwayatpendList();
            List<String> illegalOrphanMessages = null;
            for (Tbldatakeluarga tbldatakeluargaListOldTbldatakeluarga : tbldatakeluargaListOld) {
                if (!tbldatakeluargaListNew.contains(tbldatakeluargaListOldTbldatakeluarga)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tbldatakeluarga " + tbldatakeluargaListOldTbldatakeluarga + " since its nip field is not nullable.");
                }
            }
            for (Tbldatariwayatpend tbldatariwayatpendListOldTbldatariwayatpend : tbldatariwayatpendListOld) {
                if (!tbldatariwayatpendListNew.contains(tbldatariwayatpendListOldTbldatariwayatpend)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tbldatariwayatpend " + tbldatariwayatpendListOldTbldatariwayatpend + " since its nip field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPangkatNew != null) {
                idPangkatNew = em.getReference(idPangkatNew.getClass(), idPangkatNew.getIdPangkat());
                tbldataindukpeg.setIdPangkat(idPangkatNew);
            }
            List<Tbldatapengajupangkat> attachedTbldatapengajupangkatListNew = new ArrayList<Tbldatapengajupangkat>();
            for (Tbldatapengajupangkat tbldatapengajupangkatListNewTbldatapengajupangkatToAttach : tbldatapengajupangkatListNew) {
                tbldatapengajupangkatListNewTbldatapengajupangkatToAttach = em.getReference(tbldatapengajupangkatListNewTbldatapengajupangkatToAttach.getClass(), tbldatapengajupangkatListNewTbldatapengajupangkatToAttach.getIdPengajuPangkat());
                attachedTbldatapengajupangkatListNew.add(tbldatapengajupangkatListNewTbldatapengajupangkatToAttach);
            }
            tbldatapengajupangkatListNew = attachedTbldatapengajupangkatListNew;
            tbldataindukpeg.setTbldatapengajupangkatList(tbldatapengajupangkatListNew);
            List<Tblpengajupensiun> attachedTblpengajupensiunListNew = new ArrayList<Tblpengajupensiun>();
            for (Tblpengajupensiun tblpengajupensiunListNewTblpengajupensiunToAttach : tblpengajupensiunListNew) {
                tblpengajupensiunListNewTblpengajupensiunToAttach = em.getReference(tblpengajupensiunListNewTblpengajupensiunToAttach.getClass(), tblpengajupensiunListNewTblpengajupensiunToAttach.getIdPengajuPensiun());
                attachedTblpengajupensiunListNew.add(tblpengajupensiunListNewTblpengajupensiunToAttach);
            }
            tblpengajupensiunListNew = attachedTblpengajupensiunListNew;
            tbldataindukpeg.setTblpengajupensiunList(tblpengajupensiunListNew);
            List<Tblterimanaikpangkat> attachedTblterimanaikpangkatListNew = new ArrayList<Tblterimanaikpangkat>();
            for (Tblterimanaikpangkat tblterimanaikpangkatListNewTblterimanaikpangkatToAttach : tblterimanaikpangkatListNew) {
                tblterimanaikpangkatListNewTblterimanaikpangkatToAttach = em.getReference(tblterimanaikpangkatListNewTblterimanaikpangkatToAttach.getClass(), tblterimanaikpangkatListNewTblterimanaikpangkatToAttach.getIdTerima());
                attachedTblterimanaikpangkatListNew.add(tblterimanaikpangkatListNewTblterimanaikpangkatToAttach);
            }
            tblterimanaikpangkatListNew = attachedTblterimanaikpangkatListNew;
            tbldataindukpeg.setTblterimanaikpangkatList(tblterimanaikpangkatListNew);
            List<Tblterimanaikpangkat> attachedTblterimanaikpangkatList1New = new ArrayList<Tblterimanaikpangkat>();
            for (Tblterimanaikpangkat tblterimanaikpangkatList1NewTblterimanaikpangkatToAttach : tblterimanaikpangkatList1New) {
                tblterimanaikpangkatList1NewTblterimanaikpangkatToAttach = em.getReference(tblterimanaikpangkatList1NewTblterimanaikpangkatToAttach.getClass(), tblterimanaikpangkatList1NewTblterimanaikpangkatToAttach.getIdTerima());
                attachedTblterimanaikpangkatList1New.add(tblterimanaikpangkatList1NewTblterimanaikpangkatToAttach);
            }
            tblterimanaikpangkatList1New = attachedTblterimanaikpangkatList1New;
            tbldataindukpeg.setTblterimanaikpangkatList1(tblterimanaikpangkatList1New);
            List<Tbldatauser> attachedTbldatauserListNew = new ArrayList<Tbldatauser>();
            for (Tbldatauser tbldatauserListNewTbldatauserToAttach : tbldatauserListNew) {
                tbldatauserListNewTbldatauserToAttach = em.getReference(tbldatauserListNewTbldatauserToAttach.getClass(), tbldatauserListNewTbldatauserToAttach.getIdUser());
                attachedTbldatauserListNew.add(tbldatauserListNewTbldatauserToAttach);
            }
            tbldatauserListNew = attachedTbldatauserListNew;
            tbldataindukpeg.setTbldatauserList(tbldatauserListNew);
            List<Tbltolaknaikpangkat> attachedTbltolaknaikpangkatListNew = new ArrayList<Tbltolaknaikpangkat>();
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach : tbltolaknaikpangkatListNew) {
                tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach = em.getReference(tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach.getClass(), tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach.getIdTolak());
                attachedTbltolaknaikpangkatListNew.add(tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach);
            }
            tbltolaknaikpangkatListNew = attachedTbltolaknaikpangkatListNew;
            tbldataindukpeg.setTbltolaknaikpangkatList(tbltolaknaikpangkatListNew);
            List<Tbldatakeluarga> attachedTbldatakeluargaListNew = new ArrayList<Tbldatakeluarga>();
            for (Tbldatakeluarga tbldatakeluargaListNewTbldatakeluargaToAttach : tbldatakeluargaListNew) {
                tbldatakeluargaListNewTbldatakeluargaToAttach = em.getReference(tbldatakeluargaListNewTbldatakeluargaToAttach.getClass(), tbldatakeluargaListNewTbldatakeluargaToAttach.getIdDk());
                attachedTbldatakeluargaListNew.add(tbldatakeluargaListNewTbldatakeluargaToAttach);
            }
            tbldatakeluargaListNew = attachedTbldatakeluargaListNew;
            tbldataindukpeg.setTbldatakeluargaList(tbldatakeluargaListNew);
            List<Tbldatapensiun> attachedTbldatapensiunListNew = new ArrayList<Tbldatapensiun>();
            for (Tbldatapensiun tbldatapensiunListNewTbldatapensiunToAttach : tbldatapensiunListNew) {
                tbldatapensiunListNewTbldatapensiunToAttach = em.getReference(tbldatapensiunListNewTbldatapensiunToAttach.getClass(), tbldatapensiunListNewTbldatapensiunToAttach.getIdDataPensiun());
                attachedTbldatapensiunListNew.add(tbldatapensiunListNewTbldatapensiunToAttach);
            }
            tbldatapensiunListNew = attachedTbldatapensiunListNew;
            tbldataindukpeg.setTbldatapensiunList(tbldatapensiunListNew);
            List<Tbldatariwayatpend> attachedTbldatariwayatpendListNew = new ArrayList<Tbldatariwayatpend>();
            for (Tbldatariwayatpend tbldatariwayatpendListNewTbldatariwayatpendToAttach : tbldatariwayatpendListNew) {
                tbldatariwayatpendListNewTbldatariwayatpendToAttach = em.getReference(tbldatariwayatpendListNewTbldatariwayatpendToAttach.getClass(), tbldatariwayatpendListNewTbldatariwayatpendToAttach.getIdRp());
                attachedTbldatariwayatpendListNew.add(tbldatariwayatpendListNewTbldatariwayatpendToAttach);
            }
            tbldatariwayatpendListNew = attachedTbldatariwayatpendListNew;
            tbldataindukpeg.setTbldatariwayatpendList(tbldatariwayatpendListNew);
            tbldataindukpeg = em.merge(tbldataindukpeg);
            if (idPangkatOld != null && !idPangkatOld.equals(idPangkatNew)) {
                idPangkatOld.getTbldataindukpegList().remove(tbldataindukpeg);
                idPangkatOld = em.merge(idPangkatOld);
            }
            if (idPangkatNew != null && !idPangkatNew.equals(idPangkatOld)) {
                idPangkatNew.getTbldataindukpegList().add(tbldataindukpeg);
                idPangkatNew = em.merge(idPangkatNew);
            }
            for (Tbldatapengajupangkat tbldatapengajupangkatListOldTbldatapengajupangkat : tbldatapengajupangkatListOld) {
                if (!tbldatapengajupangkatListNew.contains(tbldatapengajupangkatListOldTbldatapengajupangkat)) {
                    tbldatapengajupangkatListOldTbldatapengajupangkat.setNip(null);
                    tbldatapengajupangkatListOldTbldatapengajupangkat = em.merge(tbldatapengajupangkatListOldTbldatapengajupangkat);
                }
            }
            for (Tbldatapengajupangkat tbldatapengajupangkatListNewTbldatapengajupangkat : tbldatapengajupangkatListNew) {
                if (!tbldatapengajupangkatListOld.contains(tbldatapengajupangkatListNewTbldatapengajupangkat)) {
                    Tbldataindukpeg oldNipOfTbldatapengajupangkatListNewTbldatapengajupangkat = tbldatapengajupangkatListNewTbldatapengajupangkat.getNip();
                    tbldatapengajupangkatListNewTbldatapengajupangkat.setNip(tbldataindukpeg);
                    tbldatapengajupangkatListNewTbldatapengajupangkat = em.merge(tbldatapengajupangkatListNewTbldatapengajupangkat);
                    if (oldNipOfTbldatapengajupangkatListNewTbldatapengajupangkat != null && !oldNipOfTbldatapengajupangkatListNewTbldatapengajupangkat.equals(tbldataindukpeg)) {
                        oldNipOfTbldatapengajupangkatListNewTbldatapengajupangkat.getTbldatapengajupangkatList().remove(tbldatapengajupangkatListNewTbldatapengajupangkat);
                        oldNipOfTbldatapengajupangkatListNewTbldatapengajupangkat = em.merge(oldNipOfTbldatapengajupangkatListNewTbldatapengajupangkat);
                    }
                }
            }
            for (Tblpengajupensiun tblpengajupensiunListOldTblpengajupensiun : tblpengajupensiunListOld) {
                if (!tblpengajupensiunListNew.contains(tblpengajupensiunListOldTblpengajupensiun)) {
                    tblpengajupensiunListOldTblpengajupensiun.setNip(null);
                    tblpengajupensiunListOldTblpengajupensiun = em.merge(tblpengajupensiunListOldTblpengajupensiun);
                }
            }
            for (Tblpengajupensiun tblpengajupensiunListNewTblpengajupensiun : tblpengajupensiunListNew) {
                if (!tblpengajupensiunListOld.contains(tblpengajupensiunListNewTblpengajupensiun)) {
                    Tbldataindukpeg oldNipOfTblpengajupensiunListNewTblpengajupensiun = tblpengajupensiunListNewTblpengajupensiun.getNip();
                    tblpengajupensiunListNewTblpengajupensiun.setNip(tbldataindukpeg);
                    tblpengajupensiunListNewTblpengajupensiun = em.merge(tblpengajupensiunListNewTblpengajupensiun);
                    if (oldNipOfTblpengajupensiunListNewTblpengajupensiun != null && !oldNipOfTblpengajupensiunListNewTblpengajupensiun.equals(tbldataindukpeg)) {
                        oldNipOfTblpengajupensiunListNewTblpengajupensiun.getTblpengajupensiunList().remove(tblpengajupensiunListNewTblpengajupensiun);
                        oldNipOfTblpengajupensiunListNewTblpengajupensiun = em.merge(oldNipOfTblpengajupensiunListNewTblpengajupensiun);
                    }
                }
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatListOldTblterimanaikpangkat : tblterimanaikpangkatListOld) {
                if (!tblterimanaikpangkatListNew.contains(tblterimanaikpangkatListOldTblterimanaikpangkat)) {
                    tblterimanaikpangkatListOldTblterimanaikpangkat.setNip(null);
                    tblterimanaikpangkatListOldTblterimanaikpangkat = em.merge(tblterimanaikpangkatListOldTblterimanaikpangkat);
                }
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatListNewTblterimanaikpangkat : tblterimanaikpangkatListNew) {
                if (!tblterimanaikpangkatListOld.contains(tblterimanaikpangkatListNewTblterimanaikpangkat)) {
                    Tbldataindukpeg oldNipOfTblterimanaikpangkatListNewTblterimanaikpangkat = tblterimanaikpangkatListNewTblterimanaikpangkat.getNip();
                    tblterimanaikpangkatListNewTblterimanaikpangkat.setNip(tbldataindukpeg);
                    tblterimanaikpangkatListNewTblterimanaikpangkat = em.merge(tblterimanaikpangkatListNewTblterimanaikpangkat);
                    if (oldNipOfTblterimanaikpangkatListNewTblterimanaikpangkat != null && !oldNipOfTblterimanaikpangkatListNewTblterimanaikpangkat.equals(tbldataindukpeg)) {
                        oldNipOfTblterimanaikpangkatListNewTblterimanaikpangkat.getTblterimanaikpangkatList().remove(tblterimanaikpangkatListNewTblterimanaikpangkat);
                        oldNipOfTblterimanaikpangkatListNewTblterimanaikpangkat = em.merge(oldNipOfTblterimanaikpangkatListNewTblterimanaikpangkat);
                    }
                }
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatList1OldTblterimanaikpangkat : tblterimanaikpangkatList1Old) {
                if (!tblterimanaikpangkatList1New.contains(tblterimanaikpangkatList1OldTblterimanaikpangkat)) {
                    tblterimanaikpangkatList1OldTblterimanaikpangkat.setIdPangkatbaru(null);
                    tblterimanaikpangkatList1OldTblterimanaikpangkat = em.merge(tblterimanaikpangkatList1OldTblterimanaikpangkat);
                }
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatList1NewTblterimanaikpangkat : tblterimanaikpangkatList1New) {
                if (!tblterimanaikpangkatList1Old.contains(tblterimanaikpangkatList1NewTblterimanaikpangkat)) {
                    Tbldataindukpeg oldIdPangkatbaruOfTblterimanaikpangkatList1NewTblterimanaikpangkat = tblterimanaikpangkatList1NewTblterimanaikpangkat.getIdPangkatbaru();
                    tblterimanaikpangkatList1NewTblterimanaikpangkat.setIdPangkatbaru(tbldataindukpeg);
                    tblterimanaikpangkatList1NewTblterimanaikpangkat = em.merge(tblterimanaikpangkatList1NewTblterimanaikpangkat);
                    if (oldIdPangkatbaruOfTblterimanaikpangkatList1NewTblterimanaikpangkat != null && !oldIdPangkatbaruOfTblterimanaikpangkatList1NewTblterimanaikpangkat.equals(tbldataindukpeg)) {
                        oldIdPangkatbaruOfTblterimanaikpangkatList1NewTblterimanaikpangkat.getTblterimanaikpangkatList1().remove(tblterimanaikpangkatList1NewTblterimanaikpangkat);
                        oldIdPangkatbaruOfTblterimanaikpangkatList1NewTblterimanaikpangkat = em.merge(oldIdPangkatbaruOfTblterimanaikpangkatList1NewTblterimanaikpangkat);
                    }
                }
            }
            for (Tbldatauser tbldatauserListOldTbldatauser : tbldatauserListOld) {
                if (!tbldatauserListNew.contains(tbldatauserListOldTbldatauser)) {
                    tbldatauserListOldTbldatauser.setNip(null);
                    tbldatauserListOldTbldatauser = em.merge(tbldatauserListOldTbldatauser);
                }
            }
            for (Tbldatauser tbldatauserListNewTbldatauser : tbldatauserListNew) {
                if (!tbldatauserListOld.contains(tbldatauserListNewTbldatauser)) {
                    Tbldataindukpeg oldNipOfTbldatauserListNewTbldatauser = tbldatauserListNewTbldatauser.getNip();
                    tbldatauserListNewTbldatauser.setNip(tbldataindukpeg);
                    tbldatauserListNewTbldatauser = em.merge(tbldatauserListNewTbldatauser);
                    if (oldNipOfTbldatauserListNewTbldatauser != null && !oldNipOfTbldatauserListNewTbldatauser.equals(tbldataindukpeg)) {
                        oldNipOfTbldatauserListNewTbldatauser.getTbldatauserList().remove(tbldatauserListNewTbldatauser);
                        oldNipOfTbldatauserListNewTbldatauser = em.merge(oldNipOfTbldatauserListNewTbldatauser);
                    }
                }
            }
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListOldTbltolaknaikpangkat : tbltolaknaikpangkatListOld) {
                if (!tbltolaknaikpangkatListNew.contains(tbltolaknaikpangkatListOldTbltolaknaikpangkat)) {
                    tbltolaknaikpangkatListOldTbltolaknaikpangkat.setNip(null);
                    tbltolaknaikpangkatListOldTbltolaknaikpangkat = em.merge(tbltolaknaikpangkatListOldTbltolaknaikpangkat);
                }
            }
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListNewTbltolaknaikpangkat : tbltolaknaikpangkatListNew) {
                if (!tbltolaknaikpangkatListOld.contains(tbltolaknaikpangkatListNewTbltolaknaikpangkat)) {
                    Tbldataindukpeg oldNipOfTbltolaknaikpangkatListNewTbltolaknaikpangkat = tbltolaknaikpangkatListNewTbltolaknaikpangkat.getNip();
                    tbltolaknaikpangkatListNewTbltolaknaikpangkat.setNip(tbldataindukpeg);
                    tbltolaknaikpangkatListNewTbltolaknaikpangkat = em.merge(tbltolaknaikpangkatListNewTbltolaknaikpangkat);
                    if (oldNipOfTbltolaknaikpangkatListNewTbltolaknaikpangkat != null && !oldNipOfTbltolaknaikpangkatListNewTbltolaknaikpangkat.equals(tbldataindukpeg)) {
                        oldNipOfTbltolaknaikpangkatListNewTbltolaknaikpangkat.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkatListNewTbltolaknaikpangkat);
                        oldNipOfTbltolaknaikpangkatListNewTbltolaknaikpangkat = em.merge(oldNipOfTbltolaknaikpangkatListNewTbltolaknaikpangkat);
                    }
                }
            }
            for (Tbldatakeluarga tbldatakeluargaListNewTbldatakeluarga : tbldatakeluargaListNew) {
                if (!tbldatakeluargaListOld.contains(tbldatakeluargaListNewTbldatakeluarga)) {
                    Tbldataindukpeg oldNipOfTbldatakeluargaListNewTbldatakeluarga = tbldatakeluargaListNewTbldatakeluarga.getNip();
                    tbldatakeluargaListNewTbldatakeluarga.setNip(tbldataindukpeg);
                    tbldatakeluargaListNewTbldatakeluarga = em.merge(tbldatakeluargaListNewTbldatakeluarga);
                    if (oldNipOfTbldatakeluargaListNewTbldatakeluarga != null && !oldNipOfTbldatakeluargaListNewTbldatakeluarga.equals(tbldataindukpeg)) {
                        oldNipOfTbldatakeluargaListNewTbldatakeluarga.getTbldatakeluargaList().remove(tbldatakeluargaListNewTbldatakeluarga);
                        oldNipOfTbldatakeluargaListNewTbldatakeluarga = em.merge(oldNipOfTbldatakeluargaListNewTbldatakeluarga);
                    }
                }
            }
            for (Tbldatapensiun tbldatapensiunListOldTbldatapensiun : tbldatapensiunListOld) {
                if (!tbldatapensiunListNew.contains(tbldatapensiunListOldTbldatapensiun)) {
                    tbldatapensiunListOldTbldatapensiun.setNip(null);
                    tbldatapensiunListOldTbldatapensiun = em.merge(tbldatapensiunListOldTbldatapensiun);
                }
            }
            for (Tbldatapensiun tbldatapensiunListNewTbldatapensiun : tbldatapensiunListNew) {
                if (!tbldatapensiunListOld.contains(tbldatapensiunListNewTbldatapensiun)) {
                    Tbldataindukpeg oldNipOfTbldatapensiunListNewTbldatapensiun = tbldatapensiunListNewTbldatapensiun.getNip();
                    tbldatapensiunListNewTbldatapensiun.setNip(tbldataindukpeg);
                    tbldatapensiunListNewTbldatapensiun = em.merge(tbldatapensiunListNewTbldatapensiun);
                    if (oldNipOfTbldatapensiunListNewTbldatapensiun != null && !oldNipOfTbldatapensiunListNewTbldatapensiun.equals(tbldataindukpeg)) {
                        oldNipOfTbldatapensiunListNewTbldatapensiun.getTbldatapensiunList().remove(tbldatapensiunListNewTbldatapensiun);
                        oldNipOfTbldatapensiunListNewTbldatapensiun = em.merge(oldNipOfTbldatapensiunListNewTbldatapensiun);
                    }
                }
            }
            for (Tbldatariwayatpend tbldatariwayatpendListNewTbldatariwayatpend : tbldatariwayatpendListNew) {
                if (!tbldatariwayatpendListOld.contains(tbldatariwayatpendListNewTbldatariwayatpend)) {
                    Tbldataindukpeg oldNipOfTbldatariwayatpendListNewTbldatariwayatpend = tbldatariwayatpendListNewTbldatariwayatpend.getNip();
                    tbldatariwayatpendListNewTbldatariwayatpend.setNip(tbldataindukpeg);
                    tbldatariwayatpendListNewTbldatariwayatpend = em.merge(tbldatariwayatpendListNewTbldatariwayatpend);
                    if (oldNipOfTbldatariwayatpendListNewTbldatariwayatpend != null && !oldNipOfTbldatariwayatpendListNewTbldatariwayatpend.equals(tbldataindukpeg)) {
                        oldNipOfTbldatariwayatpendListNewTbldatariwayatpend.getTbldatariwayatpendList().remove(tbldatariwayatpendListNewTbldatariwayatpend);
                        oldNipOfTbldatariwayatpendListNewTbldatariwayatpend = em.merge(oldNipOfTbldatariwayatpendListNewTbldatariwayatpend);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldataindukpeg.getNip();
                if (findTbldataindukpeg(id) == null) {
                    throw new NonexistentEntityException("The tbldataindukpeg with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg tbldataindukpeg;
            try {
                tbldataindukpeg = em.getReference(Tbldataindukpeg.class, id);
                tbldataindukpeg.getNip();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldataindukpeg with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Tbldatakeluarga> tbldatakeluargaListOrphanCheck = tbldataindukpeg.getTbldatakeluargaList();
            for (Tbldatakeluarga tbldatakeluargaListOrphanCheckTbldatakeluarga : tbldatakeluargaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tbldataindukpeg (" + tbldataindukpeg + ") cannot be destroyed since the Tbldatakeluarga " + tbldatakeluargaListOrphanCheckTbldatakeluarga + " in its tbldatakeluargaList field has a non-nullable nip field.");
            }
            List<Tbldatariwayatpend> tbldatariwayatpendListOrphanCheck = tbldataindukpeg.getTbldatariwayatpendList();
            for (Tbldatariwayatpend tbldatariwayatpendListOrphanCheckTbldatariwayatpend : tbldatariwayatpendListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tbldataindukpeg (" + tbldataindukpeg + ") cannot be destroyed since the Tbldatariwayatpend " + tbldatariwayatpendListOrphanCheckTbldatariwayatpend + " in its tbldatariwayatpendList field has a non-nullable nip field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Tbldatapangkat idPangkat = tbldataindukpeg.getIdPangkat();
            if (idPangkat != null) {
                idPangkat.getTbldataindukpegList().remove(tbldataindukpeg);
                idPangkat = em.merge(idPangkat);
            }
            List<Tbldatapengajupangkat> tbldatapengajupangkatList = tbldataindukpeg.getTbldatapengajupangkatList();
            for (Tbldatapengajupangkat tbldatapengajupangkatListTbldatapengajupangkat : tbldatapengajupangkatList) {
                tbldatapengajupangkatListTbldatapengajupangkat.setNip(null);
                tbldatapengajupangkatListTbldatapengajupangkat = em.merge(tbldatapengajupangkatListTbldatapengajupangkat);
            }
            List<Tblpengajupensiun> tblpengajupensiunList = tbldataindukpeg.getTblpengajupensiunList();
            for (Tblpengajupensiun tblpengajupensiunListTblpengajupensiun : tblpengajupensiunList) {
                tblpengajupensiunListTblpengajupensiun.setNip(null);
                tblpengajupensiunListTblpengajupensiun = em.merge(tblpengajupensiunListTblpengajupensiun);
            }
            List<Tblterimanaikpangkat> tblterimanaikpangkatList = tbldataindukpeg.getTblterimanaikpangkatList();
            for (Tblterimanaikpangkat tblterimanaikpangkatListTblterimanaikpangkat : tblterimanaikpangkatList) {
                tblterimanaikpangkatListTblterimanaikpangkat.setNip(null);
                tblterimanaikpangkatListTblterimanaikpangkat = em.merge(tblterimanaikpangkatListTblterimanaikpangkat);
            }
            List<Tblterimanaikpangkat> tblterimanaikpangkatList1 = tbldataindukpeg.getTblterimanaikpangkatList1();
            for (Tblterimanaikpangkat tblterimanaikpangkatList1Tblterimanaikpangkat : tblterimanaikpangkatList1) {
                tblterimanaikpangkatList1Tblterimanaikpangkat.setIdPangkatbaru(null);
                tblterimanaikpangkatList1Tblterimanaikpangkat = em.merge(tblterimanaikpangkatList1Tblterimanaikpangkat);
            }
            List<Tbldatauser> tbldatauserList = tbldataindukpeg.getTbldatauserList();
            for (Tbldatauser tbldatauserListTbldatauser : tbldatauserList) {
                tbldatauserListTbldatauser.setNip(null);
                tbldatauserListTbldatauser = em.merge(tbldatauserListTbldatauser);
            }
            List<Tbltolaknaikpangkat> tbltolaknaikpangkatList = tbldataindukpeg.getTbltolaknaikpangkatList();
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListTbltolaknaikpangkat : tbltolaknaikpangkatList) {
                tbltolaknaikpangkatListTbltolaknaikpangkat.setNip(null);
                tbltolaknaikpangkatListTbltolaknaikpangkat = em.merge(tbltolaknaikpangkatListTbltolaknaikpangkat);
            }
            List<Tbldatapensiun> tbldatapensiunList = tbldataindukpeg.getTbldatapensiunList();
            for (Tbldatapensiun tbldatapensiunListTbldatapensiun : tbldatapensiunList) {
                tbldatapensiunListTbldatapensiun.setNip(null);
                tbldatapensiunListTbldatapensiun = em.merge(tbldatapensiunListTbldatapensiun);
            }
            em.remove(tbldataindukpeg);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldataindukpeg> findTbldataindukpegEntities() {
        return findTbldataindukpegEntities(true, -1, -1);
    }

    public List<Tbldataindukpeg> findTbldataindukpegEntities(int maxResults, int firstResult) {
        return findTbldataindukpegEntities(false, maxResults, firstResult);
    }

    private List<Tbldataindukpeg> findTbldataindukpegEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldataindukpeg.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tbldataindukpeg findTbldataindukpeg(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldataindukpeg.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldataindukpegCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldataindukpeg> rt = cq.from(Tbldataindukpeg.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Tbldataindukpeg> findTbldataindukpegBy(List<Tbldataindukpeg> list, Column col, Object value) {
        List<Tbldataindukpeg> result = new ArrayList<>();
        list.stream().forEach((Tbldataindukpeg _item) -> {
            switch(col) {
                case NIP:
                    if(_item.getNip().equals(value)) result.add(_item);
                    break;
                case NAMA:
                    if(_item.getNama().equals(value))result.add(_item);
                    break;
                
                case JENISKELAMIN:
                    if(_item.getJenisKelamin().equals(value))result.add(_item);
                    break;
                case STATUS:
                    if(_item.getStatus().equals(value))result.add(_item);
                    break;
                case GOLDARAH:
                    if(_item.getGolDarah().equals(value))result.add(_item);
                    break;
                case GELARDEPAN:
                    if(_item.getGelarDepan().equals(value))result.add(_item);
                    break;
                case GELARBELAKANG:
                    if(_item.getGelarBelakang().equals(value))result.add(_item);
                    break;
                case AGAMA:
                    if(_item.getAgama().equals(value))result.add(_item);
                    break;
                case TEMPATLAHIR:
                    if(_item.getTempatLahir().equals(value))result.add(_item);
                    break;
                case TGLLAHIR:
                    if(_item.getTglLahir().equals(value))result.add(_item);
                    break;
                case NOKTP:
                    if(Objects.equals(_item.getNoKtp(), value)) result.add(_item);
                    break;
                case ALAMAT:
                    if(_item.getAlamat().equals(value))result.add(_item);
                    break;
                case TELRUMAH:
                    if(_item.getTelRumah().equals(value))result.add(_item);
                    break;
                case NOPONSEL:
                    if(_item.getNoPonsel().equals(value))result.add(_item);
                    break;
                case TAHUNMASUK:
                    if(Objects.equals(_item.getTahunmasuk(), value)) result.add(_item);
                    break;
                case IDPANGKAT:
                    if(_item.getIdPangkat().equals(value))result.add(_item);
                    break;
            }
        });
        return result;
    }
    
}
