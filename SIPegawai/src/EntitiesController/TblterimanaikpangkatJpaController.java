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
import Entities.Tblterimanaikpangkat;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TblterimanaikpangkatJpaController implements Serializable {

    public TblterimanaikpangkatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tblterimanaikpangkat tblterimanaikpangkat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapengajupangkat idPengajuPangkat = tblterimanaikpangkat.getIdPengajuPangkat();
            if (idPengajuPangkat != null) {
                idPengajuPangkat = em.getReference(idPengajuPangkat.getClass(), idPengajuPangkat.getIdPengajuPangkat());
                tblterimanaikpangkat.setIdPengajuPangkat(idPengajuPangkat);
            }
            Tbldataindukpeg nip = tblterimanaikpangkat.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tblterimanaikpangkat.setNip(nip);
            }
            Tbldataindukpeg idPangkatbaru = tblterimanaikpangkat.getIdPangkatbaru();
            if (idPangkatbaru != null) {
                idPangkatbaru = em.getReference(idPangkatbaru.getClass(), idPangkatbaru.getNip());
                tblterimanaikpangkat.setIdPangkatbaru(idPangkatbaru);
            }
            em.persist(tblterimanaikpangkat);
            if (idPengajuPangkat != null) {
                idPengajuPangkat.getTblterimanaikpangkatList().add(tblterimanaikpangkat);
                idPengajuPangkat = em.merge(idPengajuPangkat);
            }
            if (nip != null) {
                nip.getTblterimanaikpangkatList().add(tblterimanaikpangkat);
                nip = em.merge(nip);
            }
            if (idPangkatbaru != null) {
                idPangkatbaru.getTblterimanaikpangkatList().add(tblterimanaikpangkat);
                idPangkatbaru = em.merge(idPangkatbaru);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTblterimanaikpangkat(tblterimanaikpangkat.getIdTerima()) != null) {
                throw new PreexistingEntityException("Tblterimanaikpangkat " + tblterimanaikpangkat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tblterimanaikpangkat tblterimanaikpangkat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tblterimanaikpangkat persistentTblterimanaikpangkat = em.find(Tblterimanaikpangkat.class, tblterimanaikpangkat.getIdTerima());
            Tbldatapengajupangkat idPengajuPangkatOld = persistentTblterimanaikpangkat.getIdPengajuPangkat();
            Tbldatapengajupangkat idPengajuPangkatNew = tblterimanaikpangkat.getIdPengajuPangkat();
            Tbldataindukpeg nipOld = persistentTblterimanaikpangkat.getNip();
            Tbldataindukpeg nipNew = tblterimanaikpangkat.getNip();
            Tbldataindukpeg idPangkatbaruOld = persistentTblterimanaikpangkat.getIdPangkatbaru();
            Tbldataindukpeg idPangkatbaruNew = tblterimanaikpangkat.getIdPangkatbaru();
            if (idPengajuPangkatNew != null) {
                idPengajuPangkatNew = em.getReference(idPengajuPangkatNew.getClass(), idPengajuPangkatNew.getIdPengajuPangkat());
                tblterimanaikpangkat.setIdPengajuPangkat(idPengajuPangkatNew);
            }
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tblterimanaikpangkat.setNip(nipNew);
            }
            if (idPangkatbaruNew != null) {
                idPangkatbaruNew = em.getReference(idPangkatbaruNew.getClass(), idPangkatbaruNew.getNip());
                tblterimanaikpangkat.setIdPangkatbaru(idPangkatbaruNew);
            }
            tblterimanaikpangkat = em.merge(tblterimanaikpangkat);
            if (idPengajuPangkatOld != null && !idPengajuPangkatOld.equals(idPengajuPangkatNew)) {
                idPengajuPangkatOld.getTblterimanaikpangkatList().remove(tblterimanaikpangkat);
                idPengajuPangkatOld = em.merge(idPengajuPangkatOld);
            }
            if (idPengajuPangkatNew != null && !idPengajuPangkatNew.equals(idPengajuPangkatOld)) {
                idPengajuPangkatNew.getTblterimanaikpangkatList().add(tblterimanaikpangkat);
                idPengajuPangkatNew = em.merge(idPengajuPangkatNew);
            }
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTblterimanaikpangkatList().remove(tblterimanaikpangkat);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTblterimanaikpangkatList().add(tblterimanaikpangkat);
                nipNew = em.merge(nipNew);
            }
            if (idPangkatbaruOld != null && !idPangkatbaruOld.equals(idPangkatbaruNew)) {
                idPangkatbaruOld.getTblterimanaikpangkatList().remove(tblterimanaikpangkat);
                idPangkatbaruOld = em.merge(idPangkatbaruOld);
            }
            if (idPangkatbaruNew != null && !idPangkatbaruNew.equals(idPangkatbaruOld)) {
                idPangkatbaruNew.getTblterimanaikpangkatList().add(tblterimanaikpangkat);
                idPangkatbaruNew = em.merge(idPangkatbaruNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tblterimanaikpangkat.getIdTerima();
                if (findTblterimanaikpangkat(id) == null) {
                    throw new NonexistentEntityException("The tblterimanaikpangkat with id " + id + " no longer exists.");
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
            Tblterimanaikpangkat tblterimanaikpangkat;
            try {
                tblterimanaikpangkat = em.getReference(Tblterimanaikpangkat.class, id);
                tblterimanaikpangkat.getIdTerima();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tblterimanaikpangkat with id " + id + " no longer exists.", enfe);
            }
            Tbldatapengajupangkat idPengajuPangkat = tblterimanaikpangkat.getIdPengajuPangkat();
            if (idPengajuPangkat != null) {
                idPengajuPangkat.getTblterimanaikpangkatList().remove(tblterimanaikpangkat);
                idPengajuPangkat = em.merge(idPengajuPangkat);
            }
            Tbldataindukpeg nip = tblterimanaikpangkat.getNip();
            if (nip != null) {
                nip.getTblterimanaikpangkatList().remove(tblterimanaikpangkat);
                nip = em.merge(nip);
            }
            Tbldataindukpeg idPangkatbaru = tblterimanaikpangkat.getIdPangkatbaru();
            if (idPangkatbaru != null) {
                idPangkatbaru.getTblterimanaikpangkatList().remove(tblterimanaikpangkat);
                idPangkatbaru = em.merge(idPangkatbaru);
            }
            em.remove(tblterimanaikpangkat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tblterimanaikpangkat> findTblterimanaikpangkatEntities() {
        return findTblterimanaikpangkatEntities(true, -1, -1);
    }

    public List<Tblterimanaikpangkat> findTblterimanaikpangkatEntities(int maxResults, int firstResult) {
        return findTblterimanaikpangkatEntities(false, maxResults, firstResult);
    }

    private List<Tblterimanaikpangkat> findTblterimanaikpangkatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tblterimanaikpangkat.class));
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

    public Tblterimanaikpangkat findTblterimanaikpangkat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tblterimanaikpangkat.class, id);
        } finally {
            em.close();
        }
    }

    public int getTblterimanaikpangkatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tblterimanaikpangkat> rt = cq.from(Tblterimanaikpangkat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
