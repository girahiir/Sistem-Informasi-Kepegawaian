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
import Entities.Tbldatariwayatpend;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TbldatariwayatpendJpaController implements Serializable {

    public static enum Column {
        IDRP,
        NIP,
        TINGKATPENDIDIKAN,
        TEMPATPENDIDIKAN,
        JURUSAN,
        TGLIJAZAH,
        THNMASUK,
        THNLULUS,
    }
    public TbldatariwayatpendJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldatariwayatpend tbldatariwayatpend) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg nip = tbldatariwayatpend.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tbldatariwayatpend.setNip(nip);
            }
            em.persist(tbldatariwayatpend);
            if (nip != null) {
                nip.getTbldatariwayatpendList().add(tbldatariwayatpend);
                nip = em.merge(nip);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldatariwayatpend(tbldatariwayatpend.getIdRp()) != null) {
                throw new PreexistingEntityException("Tbldatariwayatpend " + tbldatariwayatpend + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldatariwayatpend tbldatariwayatpend) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatariwayatpend persistentTbldatariwayatpend = em.find(Tbldatariwayatpend.class, tbldatariwayatpend.getIdRp());
            Tbldataindukpeg nipOld = persistentTbldatariwayatpend.getNip();
            Tbldataindukpeg nipNew = tbldatariwayatpend.getNip();
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tbldatariwayatpend.setNip(nipNew);
            }
            tbldatariwayatpend = em.merge(tbldatariwayatpend);
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTbldatariwayatpendList().remove(tbldatariwayatpend);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTbldatariwayatpendList().add(tbldatariwayatpend);
                nipNew = em.merge(nipNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldatariwayatpend.getIdRp();
                if (findTbldatariwayatpend(id) == null) {
                    throw new NonexistentEntityException("The tbldatariwayatpend with id " + id + " no longer exists.");
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
            Tbldatariwayatpend tbldatariwayatpend;
            try {
                tbldatariwayatpend = em.getReference(Tbldatariwayatpend.class, id);
                tbldatariwayatpend.getIdRp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldatariwayatpend with id " + id + " no longer exists.", enfe);
            }
            Tbldataindukpeg nip = tbldatariwayatpend.getNip();
            if (nip != null) {
                nip.getTbldatariwayatpendList().remove(tbldatariwayatpend);
                nip = em.merge(nip);
            }
            em.remove(tbldatariwayatpend);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldatariwayatpend> findTbldatariwayatpendEntities() {
        return findTbldatariwayatpendEntities(true, -1, -1);
    }

    public List<Tbldatariwayatpend> findTbldatariwayatpendEntities(int maxResults, int firstResult) {
        return findTbldatariwayatpendEntities(false, maxResults, firstResult);
    }

    private List<Tbldatariwayatpend> findTbldatariwayatpendEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldatariwayatpend.class));
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

    public Tbldatariwayatpend findTbldatariwayatpend(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldatariwayatpend.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldatariwayatpendCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldatariwayatpend> rt = cq.from(Tbldatariwayatpend.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Tbldatariwayatpend> findTbldatariwayatpendBy(List<Tbldatariwayatpend> list, TbldatariwayatpendJpaController.Column col, Object value) {
        List<Tbldatariwayatpend> result = new ArrayList<>();
        list.stream().forEach((Tbldatariwayatpend _item) -> {
            switch(col) {
                case IDRP:
                    if(_item.getIdRp().equals(value)) result.add(_item);
                    break;
                case NIP:
                    if(_item.getNip().equals(value)) result.add(_item);
                    break;
                case TINGKATPENDIDIKAN:
                    if(_item.getTingkatPendidikan().equals(value)) result.add(_item);
                    break;
                case TEMPATPENDIDIKAN:
                    if(_item.getTempatPendidikan().equals(value)) result.add(_item);
                    break;
                case JURUSAN:
                    if(_item.getJurusan().equals(value)) result.add(_item);
                    break;
                case TGLIJAZAH:
                    if(_item.getTglIjazah().equals(value)) result.add(_item);
                    break;
                case THNMASUK:
                    if(Objects.equals(_item.getThnMasuk(), value)) result.add(_item);
                    break;
                case THNLULUS:
                    if(Objects.equals(_item.getThnLulus(), value)) result.add(_item);
                    break;
            }
        });
        return result;
    }
    
    public List<Entities.Tbldataindukpeg> getTbldataindukpeg(List<Entities.Tbldatariwayatpend> list) {
        List<Entities.Tbldataindukpeg> result = new ArrayList<>();
        list.stream().forEach((Tbldatariwayatpend _item) -> {
            result.add(_item.getNip());
        });
        return result;
    }
    
}
