/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesController;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Tbldataindukpeg;
import Entities.Tbldatapensiun;
import Entities.Tblpengajupensiun;
import EntitiesController.exceptions.IllegalOrphanException;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TblpengajupensiunJpaController implements Serializable {

    public TblpengajupensiunJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tblpengajupensiun tblpengajupensiun) throws PreexistingEntityException, Exception {
        if (tblpengajupensiun.getTbldatapensiunList() == null) {
            tblpengajupensiun.setTbldatapensiunList(new ArrayList<Tbldatapensiun>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg nip = tblpengajupensiun.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tblpengajupensiun.setNip(nip);
            }
            List<Tbldatapensiun> attachedTbldatapensiunList = new ArrayList<Tbldatapensiun>();
            for (Tbldatapensiun tbldatapensiunListTbldatapensiunToAttach : tblpengajupensiun.getTbldatapensiunList()) {
                tbldatapensiunListTbldatapensiunToAttach = em.getReference(tbldatapensiunListTbldatapensiunToAttach.getClass(), tbldatapensiunListTbldatapensiunToAttach.getIdDataPensiun());
                attachedTbldatapensiunList.add(tbldatapensiunListTbldatapensiunToAttach);
            }
            tblpengajupensiun.setTbldatapensiunList(attachedTbldatapensiunList);
            em.persist(tblpengajupensiun);
            if (nip != null) {
                nip.getTblpengajupensiunList().add(tblpengajupensiun);
                nip = em.merge(nip);
            }
            for (Tbldatapensiun tbldatapensiunListTbldatapensiun : tblpengajupensiun.getTbldatapensiunList()) {
                Tblpengajupensiun oldIdPengajuPensiunOfTbldatapensiunListTbldatapensiun = tbldatapensiunListTbldatapensiun.getIdPengajuPensiun();
                tbldatapensiunListTbldatapensiun.setIdPengajuPensiun(tblpengajupensiun);
                tbldatapensiunListTbldatapensiun = em.merge(tbldatapensiunListTbldatapensiun);
                if (oldIdPengajuPensiunOfTbldatapensiunListTbldatapensiun != null) {
                    oldIdPengajuPensiunOfTbldatapensiunListTbldatapensiun.getTbldatapensiunList().remove(tbldatapensiunListTbldatapensiun);
                    oldIdPengajuPensiunOfTbldatapensiunListTbldatapensiun = em.merge(oldIdPengajuPensiunOfTbldatapensiunListTbldatapensiun);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTblpengajupensiun(tblpengajupensiun.getIdPengajuPensiun()) != null) {
                throw new PreexistingEntityException("Tblpengajupensiun " + tblpengajupensiun + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tblpengajupensiun tblpengajupensiun) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tblpengajupensiun persistentTblpengajupensiun = em.find(Tblpengajupensiun.class, tblpengajupensiun.getIdPengajuPensiun());
            Tbldataindukpeg nipOld = persistentTblpengajupensiun.getNip();
            Tbldataindukpeg nipNew = tblpengajupensiun.getNip();
            List<Tbldatapensiun> tbldatapensiunListOld = persistentTblpengajupensiun.getTbldatapensiunList();
            List<Tbldatapensiun> tbldatapensiunListNew = tblpengajupensiun.getTbldatapensiunList();
            List<String> illegalOrphanMessages = null;
            for (Tbldatapensiun tbldatapensiunListOldTbldatapensiun : tbldatapensiunListOld) {
                if (!tbldatapensiunListNew.contains(tbldatapensiunListOldTbldatapensiun)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tbldatapensiun " + tbldatapensiunListOldTbldatapensiun + " since its idPengajuPensiun field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tblpengajupensiun.setNip(nipNew);
            }
            List<Tbldatapensiun> attachedTbldatapensiunListNew = new ArrayList<Tbldatapensiun>();
            for (Tbldatapensiun tbldatapensiunListNewTbldatapensiunToAttach : tbldatapensiunListNew) {
                tbldatapensiunListNewTbldatapensiunToAttach = em.getReference(tbldatapensiunListNewTbldatapensiunToAttach.getClass(), tbldatapensiunListNewTbldatapensiunToAttach.getIdDataPensiun());
                attachedTbldatapensiunListNew.add(tbldatapensiunListNewTbldatapensiunToAttach);
            }
            tbldatapensiunListNew = attachedTbldatapensiunListNew;
            tblpengajupensiun.setTbldatapensiunList(tbldatapensiunListNew);
            tblpengajupensiun = em.merge(tblpengajupensiun);
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTblpengajupensiunList().remove(tblpengajupensiun);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTblpengajupensiunList().add(tblpengajupensiun);
                nipNew = em.merge(nipNew);
            }
            for (Tbldatapensiun tbldatapensiunListNewTbldatapensiun : tbldatapensiunListNew) {
                if (!tbldatapensiunListOld.contains(tbldatapensiunListNewTbldatapensiun)) {
                    Tblpengajupensiun oldIdPengajuPensiunOfTbldatapensiunListNewTbldatapensiun = tbldatapensiunListNewTbldatapensiun.getIdPengajuPensiun();
                    tbldatapensiunListNewTbldatapensiun.setIdPengajuPensiun(tblpengajupensiun);
                    tbldatapensiunListNewTbldatapensiun = em.merge(tbldatapensiunListNewTbldatapensiun);
                    if (oldIdPengajuPensiunOfTbldatapensiunListNewTbldatapensiun != null && !oldIdPengajuPensiunOfTbldatapensiunListNewTbldatapensiun.equals(tblpengajupensiun)) {
                        oldIdPengajuPensiunOfTbldatapensiunListNewTbldatapensiun.getTbldatapensiunList().remove(tbldatapensiunListNewTbldatapensiun);
                        oldIdPengajuPensiunOfTbldatapensiunListNewTbldatapensiun = em.merge(oldIdPengajuPensiunOfTbldatapensiunListNewTbldatapensiun);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tblpengajupensiun.getIdPengajuPensiun();
                if (findTblpengajupensiun(id) == null) {
                    throw new NonexistentEntityException("The tblpengajupensiun with id " + id + " no longer exists.");
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
            Tblpengajupensiun tblpengajupensiun;
            try {
                tblpengajupensiun = em.getReference(Tblpengajupensiun.class, id);
                tblpengajupensiun.getIdPengajuPensiun();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tblpengajupensiun with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Tbldatapensiun> tbldatapensiunListOrphanCheck = tblpengajupensiun.getTbldatapensiunList();
            for (Tbldatapensiun tbldatapensiunListOrphanCheckTbldatapensiun : tbldatapensiunListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tblpengajupensiun (" + tblpengajupensiun + ") cannot be destroyed since the Tbldatapensiun " + tbldatapensiunListOrphanCheckTbldatapensiun + " in its tbldatapensiunList field has a non-nullable idPengajuPensiun field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Tbldataindukpeg nip = tblpengajupensiun.getNip();
            if (nip != null) {
                nip.getTblpengajupensiunList().remove(tblpengajupensiun);
                nip = em.merge(nip);
            }
            em.remove(tblpengajupensiun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tblpengajupensiun> findTblpengajupensiunEntities() {
        return findTblpengajupensiunEntities(true, -1, -1);
    }

    public List<Tblpengajupensiun> findTblpengajupensiunEntities(int maxResults, int firstResult) {
        return findTblpengajupensiunEntities(false, maxResults, firstResult);
    }

    private List<Tblpengajupensiun> findTblpengajupensiunEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tblpengajupensiun.class));
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

    public Tblpengajupensiun findTblpengajupensiun(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tblpengajupensiun.class, id);
        } finally {
            em.close();
        }
    }

    public int getTblpengajupensiunCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tblpengajupensiun> rt = cq.from(Tblpengajupensiun.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
