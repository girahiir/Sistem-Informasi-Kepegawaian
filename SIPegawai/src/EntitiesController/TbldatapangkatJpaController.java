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
import Entities.Tbldatapangkat;
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
public class TbldatapangkatJpaController implements Serializable {

    public TbldatapangkatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldatapangkat tbldatapangkat) throws PreexistingEntityException, Exception {
        if (tbldatapangkat.getTbldataindukpegList() == null) {
            tbldatapangkat.setTbldataindukpegList(new ArrayList<Tbldataindukpeg>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Tbldataindukpeg> attachedTbldataindukpegList = new ArrayList<Tbldataindukpeg>();
            for (Tbldataindukpeg tbldataindukpegListTbldataindukpegToAttach : tbldatapangkat.getTbldataindukpegList()) {
                tbldataindukpegListTbldataindukpegToAttach = em.getReference(tbldataindukpegListTbldataindukpegToAttach.getClass(), tbldataindukpegListTbldataindukpegToAttach.getNip());
                attachedTbldataindukpegList.add(tbldataindukpegListTbldataindukpegToAttach);
            }
            tbldatapangkat.setTbldataindukpegList(attachedTbldataindukpegList);
            em.persist(tbldatapangkat);
            for (Tbldataindukpeg tbldataindukpegListTbldataindukpeg : tbldatapangkat.getTbldataindukpegList()) {
                Tbldatapangkat oldIdPangkatOfTbldataindukpegListTbldataindukpeg = tbldataindukpegListTbldataindukpeg.getIdPangkat();
                tbldataindukpegListTbldataindukpeg.setIdPangkat(tbldatapangkat);
                tbldataindukpegListTbldataindukpeg = em.merge(tbldataindukpegListTbldataindukpeg);
                if (oldIdPangkatOfTbldataindukpegListTbldataindukpeg != null) {
                    oldIdPangkatOfTbldataindukpegListTbldataindukpeg.getTbldataindukpegList().remove(tbldataindukpegListTbldataindukpeg);
                    oldIdPangkatOfTbldataindukpegListTbldataindukpeg = em.merge(oldIdPangkatOfTbldataindukpegListTbldataindukpeg);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldatapangkat(tbldatapangkat.getIdPangkat()) != null) {
                throw new PreexistingEntityException("Tbldatapangkat " + tbldatapangkat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldatapangkat tbldatapangkat) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapangkat persistentTbldatapangkat = em.find(Tbldatapangkat.class, tbldatapangkat.getIdPangkat());
            List<Tbldataindukpeg> tbldataindukpegListOld = persistentTbldatapangkat.getTbldataindukpegList();
            List<Tbldataindukpeg> tbldataindukpegListNew = tbldatapangkat.getTbldataindukpegList();
            List<String> illegalOrphanMessages = null;
            for (Tbldataindukpeg tbldataindukpegListOldTbldataindukpeg : tbldataindukpegListOld) {
                if (!tbldataindukpegListNew.contains(tbldataindukpegListOldTbldataindukpeg)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tbldataindukpeg " + tbldataindukpegListOldTbldataindukpeg + " since its idPangkat field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Tbldataindukpeg> attachedTbldataindukpegListNew = new ArrayList<Tbldataindukpeg>();
            for (Tbldataindukpeg tbldataindukpegListNewTbldataindukpegToAttach : tbldataindukpegListNew) {
                tbldataindukpegListNewTbldataindukpegToAttach = em.getReference(tbldataindukpegListNewTbldataindukpegToAttach.getClass(), tbldataindukpegListNewTbldataindukpegToAttach.getNip());
                attachedTbldataindukpegListNew.add(tbldataindukpegListNewTbldataindukpegToAttach);
            }
            tbldataindukpegListNew = attachedTbldataindukpegListNew;
            tbldatapangkat.setTbldataindukpegList(tbldataindukpegListNew);
            tbldatapangkat = em.merge(tbldatapangkat);
            for (Tbldataindukpeg tbldataindukpegListNewTbldataindukpeg : tbldataindukpegListNew) {
                if (!tbldataindukpegListOld.contains(tbldataindukpegListNewTbldataindukpeg)) {
                    Tbldatapangkat oldIdPangkatOfTbldataindukpegListNewTbldataindukpeg = tbldataindukpegListNewTbldataindukpeg.getIdPangkat();
                    tbldataindukpegListNewTbldataindukpeg.setIdPangkat(tbldatapangkat);
                    tbldataindukpegListNewTbldataindukpeg = em.merge(tbldataindukpegListNewTbldataindukpeg);
                    if (oldIdPangkatOfTbldataindukpegListNewTbldataindukpeg != null && !oldIdPangkatOfTbldataindukpegListNewTbldataindukpeg.equals(tbldatapangkat)) {
                        oldIdPangkatOfTbldataindukpegListNewTbldataindukpeg.getTbldataindukpegList().remove(tbldataindukpegListNewTbldataindukpeg);
                        oldIdPangkatOfTbldataindukpegListNewTbldataindukpeg = em.merge(oldIdPangkatOfTbldataindukpegListNewTbldataindukpeg);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldatapangkat.getIdPangkat();
                if (findTbldatapangkat(id) == null) {
                    throw new NonexistentEntityException("The tbldatapangkat with id " + id + " no longer exists.");
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
            Tbldatapangkat tbldatapangkat;
            try {
                tbldatapangkat = em.getReference(Tbldatapangkat.class, id);
                tbldatapangkat.getIdPangkat();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldatapangkat with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Tbldataindukpeg> tbldataindukpegListOrphanCheck = tbldatapangkat.getTbldataindukpegList();
            for (Tbldataindukpeg tbldataindukpegListOrphanCheckTbldataindukpeg : tbldataindukpegListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tbldatapangkat (" + tbldatapangkat + ") cannot be destroyed since the Tbldataindukpeg " + tbldataindukpegListOrphanCheckTbldataindukpeg + " in its tbldataindukpegList field has a non-nullable idPangkat field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tbldatapangkat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldatapangkat> findTbldatapangkatEntities() {
        return findTbldatapangkatEntities(true, -1, -1);
    }

    public List<Tbldatapangkat> findTbldatapangkatEntities(int maxResults, int firstResult) {
        return findTbldatapangkatEntities(false, maxResults, firstResult);
    }

    private List<Tbldatapangkat> findTbldatapangkatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldatapangkat.class));
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

    public Tbldatapangkat findTbldatapangkat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldatapangkat.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldatapangkatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldatapangkat> rt = cq.from(Tbldatapangkat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
