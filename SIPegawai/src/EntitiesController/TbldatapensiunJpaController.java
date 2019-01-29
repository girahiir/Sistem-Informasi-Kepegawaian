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
import Entities.Tblpengajupensiun;
import Entities.Tbldataindukpeg;
import Entities.Tbldatapensiun;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TbldatapensiunJpaController implements Serializable {

    public TbldatapensiunJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldatapensiun tbldatapensiun) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tblpengajupensiun idPengajuPensiun = tbldatapensiun.getIdPengajuPensiun();
            if (idPengajuPensiun != null) {
                idPengajuPensiun = em.getReference(idPengajuPensiun.getClass(), idPengajuPensiun.getIdPengajuPensiun());
                tbldatapensiun.setIdPengajuPensiun(idPengajuPensiun);
            }
            Tbldataindukpeg nip = tbldatapensiun.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tbldatapensiun.setNip(nip);
            }
            em.persist(tbldatapensiun);
            if (idPengajuPensiun != null) {
                idPengajuPensiun.getTbldatapensiunList().add(tbldatapensiun);
                idPengajuPensiun = em.merge(idPengajuPensiun);
            }
            if (nip != null) {
                nip.getTbldatapensiunList().add(tbldatapensiun);
                nip = em.merge(nip);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldatapensiun(tbldatapensiun.getIdDataPensiun()) != null) {
                throw new PreexistingEntityException("Tbldatapensiun " + tbldatapensiun + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldatapensiun tbldatapensiun) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapensiun persistentTbldatapensiun = em.find(Tbldatapensiun.class, tbldatapensiun.getIdDataPensiun());
            Tblpengajupensiun idPengajuPensiunOld = persistentTbldatapensiun.getIdPengajuPensiun();
            Tblpengajupensiun idPengajuPensiunNew = tbldatapensiun.getIdPengajuPensiun();
            Tbldataindukpeg nipOld = persistentTbldatapensiun.getNip();
            Tbldataindukpeg nipNew = tbldatapensiun.getNip();
            if (idPengajuPensiunNew != null) {
                idPengajuPensiunNew = em.getReference(idPengajuPensiunNew.getClass(), idPengajuPensiunNew.getIdPengajuPensiun());
                tbldatapensiun.setIdPengajuPensiun(idPengajuPensiunNew);
            }
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tbldatapensiun.setNip(nipNew);
            }
            tbldatapensiun = em.merge(tbldatapensiun);
            if (idPengajuPensiunOld != null && !idPengajuPensiunOld.equals(idPengajuPensiunNew)) {
                idPengajuPensiunOld.getTbldatapensiunList().remove(tbldatapensiun);
                idPengajuPensiunOld = em.merge(idPengajuPensiunOld);
            }
            if (idPengajuPensiunNew != null && !idPengajuPensiunNew.equals(idPengajuPensiunOld)) {
                idPengajuPensiunNew.getTbldatapensiunList().add(tbldatapensiun);
                idPengajuPensiunNew = em.merge(idPengajuPensiunNew);
            }
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTbldatapensiunList().remove(tbldatapensiun);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTbldatapensiunList().add(tbldatapensiun);
                nipNew = em.merge(nipNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldatapensiun.getIdDataPensiun();
                if (findTbldatapensiun(id) == null) {
                    throw new NonexistentEntityException("The tbldatapensiun with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapensiun tbldatapensiun;
            try {
                tbldatapensiun = em.getReference(Tbldatapensiun.class, id);
                tbldatapensiun.getIdDataPensiun();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldatapensiun with id " + id + " no longer exists.", enfe);
            }
            Tblpengajupensiun idPengajuPensiun = tbldatapensiun.getIdPengajuPensiun();
            if (idPengajuPensiun != null) {
                idPengajuPensiun.getTbldatapensiunList().remove(tbldatapensiun);
                idPengajuPensiun = em.merge(idPengajuPensiun);
            }
            Tbldataindukpeg nip = tbldatapensiun.getNip();
            if (nip != null) {
                nip.getTbldatapensiunList().remove(tbldatapensiun);
                nip = em.merge(nip);
            }
            em.remove(tbldatapensiun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldatapensiun> findTbldatapensiunEntities() {
        return findTbldatapensiunEntities(true, -1, -1);
    }

    public List<Tbldatapensiun> findTbldatapensiunEntities(int maxResults, int firstResult) {
        return findTbldatapensiunEntities(false, maxResults, firstResult);
    }

    private List<Tbldatapensiun> findTbldatapensiunEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldatapensiun.class));
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

    public Tbldatapensiun findTbldatapensiun(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldatapensiun.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldatapensiunCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldatapensiun> rt = cq.from(Tbldatapensiun.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
