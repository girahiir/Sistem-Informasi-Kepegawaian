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
import Entities.Tbldatauser;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TbldatauserJpaController implements Serializable {

    public TbldatauserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldatauser tbldatauser) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg nip = tbldatauser.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tbldatauser.setNip(nip);
            }
            em.persist(tbldatauser);
            if (nip != null) {
                nip.getTbldatauserList().add(tbldatauser);
                nip = em.merge(nip);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldatauser(tbldatauser.getIdUser()) != null) {
                throw new PreexistingEntityException("Tbldatauser " + tbldatauser + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldatauser tbldatauser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatauser persistentTbldatauser = em.find(Tbldatauser.class, tbldatauser.getIdUser());
            Tbldataindukpeg nipOld = persistentTbldatauser.getNip();
            Tbldataindukpeg nipNew = tbldatauser.getNip();
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tbldatauser.setNip(nipNew);
            }
            tbldatauser = em.merge(tbldatauser);
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTbldatauserList().remove(tbldatauser);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTbldatauserList().add(tbldatauser);
                nipNew = em.merge(nipNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldatauser.getIdUser();
                if (findTbldatauser(id) == null) {
                    throw new NonexistentEntityException("The tbldatauser with id " + id + " no longer exists.");
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
            Tbldatauser tbldatauser;
            try {
                tbldatauser = em.getReference(Tbldatauser.class, id);
                tbldatauser.getIdUser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldatauser with id " + id + " no longer exists.", enfe);
            }
            Tbldataindukpeg nip = tbldatauser.getNip();
            if (nip != null) {
                nip.getTbldatauserList().remove(tbldatauser);
                nip = em.merge(nip);
            }
            em.remove(tbldatauser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldatauser> findTbldatauserEntities() {
        return findTbldatauserEntities(true, -1, -1);
    }

    public List<Tbldatauser> findTbldatauserEntities(int maxResults, int firstResult) {
        return findTbldatauserEntities(false, maxResults, firstResult);
    }

    private List<Tbldatauser> findTbldatauserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldatauser.class));
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

    public Tbldatauser findTbldatauser(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldatauser.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldatauserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldatauser> rt = cq.from(Tbldatauser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
