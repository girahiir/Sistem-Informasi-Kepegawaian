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
import Entities.Tbldatapengajupangkat;
import Entities.Tbldataindukpeg;
import Entities.Tbltolaknaikpangkat;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TbltolaknaikpangkatJpaController implements Serializable {

    public TbltolaknaikpangkatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbltolaknaikpangkat tbltolaknaikpangkat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapengajupangkat idPengajuPangkat = tbltolaknaikpangkat.getIdPengajuPangkat();
            if (idPengajuPangkat != null) {
                idPengajuPangkat = em.getReference(idPengajuPangkat.getClass(), idPengajuPangkat.getIdPengajuPangkat());
                tbltolaknaikpangkat.setIdPengajuPangkat(idPengajuPangkat);
            }
            Tbldataindukpeg nip = tbltolaknaikpangkat.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tbltolaknaikpangkat.setNip(nip);
            }
            em.persist(tbltolaknaikpangkat);
            if (idPengajuPangkat != null) {
                idPengajuPangkat.getTbltolaknaikpangkatList().add(tbltolaknaikpangkat);
                idPengajuPangkat = em.merge(idPengajuPangkat);
            }
            if (nip != null) {
                nip.getTbltolaknaikpangkatList().add(tbltolaknaikpangkat);
                nip = em.merge(nip);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbltolaknaikpangkat(tbltolaknaikpangkat.getIdTolak()) != null) {
                throw new PreexistingEntityException("Tbltolaknaikpangkat " + tbltolaknaikpangkat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbltolaknaikpangkat tbltolaknaikpangkat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbltolaknaikpangkat persistentTbltolaknaikpangkat = em.find(Tbltolaknaikpangkat.class, tbltolaknaikpangkat.getIdTolak());
            Tbldatapengajupangkat idPengajuPangkatOld = persistentTbltolaknaikpangkat.getIdPengajuPangkat();
            Tbldatapengajupangkat idPengajuPangkatNew = tbltolaknaikpangkat.getIdPengajuPangkat();
            Tbldataindukpeg nipOld = persistentTbltolaknaikpangkat.getNip();
            Tbldataindukpeg nipNew = tbltolaknaikpangkat.getNip();
            if (idPengajuPangkatNew != null) {
                idPengajuPangkatNew = em.getReference(idPengajuPangkatNew.getClass(), idPengajuPangkatNew.getIdPengajuPangkat());
                tbltolaknaikpangkat.setIdPengajuPangkat(idPengajuPangkatNew);
            }
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tbltolaknaikpangkat.setNip(nipNew);
            }
            tbltolaknaikpangkat = em.merge(tbltolaknaikpangkat);
            if (idPengajuPangkatOld != null && !idPengajuPangkatOld.equals(idPengajuPangkatNew)) {
                idPengajuPangkatOld.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkat);
                idPengajuPangkatOld = em.merge(idPengajuPangkatOld);
            }
            if (idPengajuPangkatNew != null && !idPengajuPangkatNew.equals(idPengajuPangkatOld)) {
                idPengajuPangkatNew.getTbltolaknaikpangkatList().add(tbltolaknaikpangkat);
                idPengajuPangkatNew = em.merge(idPengajuPangkatNew);
            }
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkat);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTbltolaknaikpangkatList().add(tbltolaknaikpangkat);
                nipNew = em.merge(nipNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbltolaknaikpangkat.getIdTolak();
                if (findTbltolaknaikpangkat(id) == null) {
                    throw new NonexistentEntityException("The tbltolaknaikpangkat with id " + id + " no longer exists.");
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
            Tbltolaknaikpangkat tbltolaknaikpangkat;
            try {
                tbltolaknaikpangkat = em.getReference(Tbltolaknaikpangkat.class, id);
                tbltolaknaikpangkat.getIdTolak();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbltolaknaikpangkat with id " + id + " no longer exists.", enfe);
            }
            Tbldatapengajupangkat idPengajuPangkat = tbltolaknaikpangkat.getIdPengajuPangkat();
            if (idPengajuPangkat != null) {
                idPengajuPangkat.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkat);
                idPengajuPangkat = em.merge(idPengajuPangkat);
            }
            Tbldataindukpeg nip = tbltolaknaikpangkat.getNip();
            if (nip != null) {
                nip.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkat);
                nip = em.merge(nip);
            }
            em.remove(tbltolaknaikpangkat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbltolaknaikpangkat> findTbltolaknaikpangkatEntities() {
        return findTbltolaknaikpangkatEntities(true, -1, -1);
    }

    public List<Tbltolaknaikpangkat> findTbltolaknaikpangkatEntities(int maxResults, int firstResult) {
        return findTbltolaknaikpangkatEntities(false, maxResults, firstResult);
    }

    private List<Tbltolaknaikpangkat> findTbltolaknaikpangkatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbltolaknaikpangkat.class));
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

    public Tbltolaknaikpangkat findTbltolaknaikpangkat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbltolaknaikpangkat.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbltolaknaikpangkatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbltolaknaikpangkat> rt = cq.from(Tbltolaknaikpangkat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
