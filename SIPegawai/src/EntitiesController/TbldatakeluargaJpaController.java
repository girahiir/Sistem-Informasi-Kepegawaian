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
import Entities.Tbldatakeluarga;
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
public class TbldatakeluargaJpaController implements Serializable {

    public static enum Column {
    IDK,
    NIP,
    NAMAAYAH,
    NAMAIBU,
    NAMAISTRI,
    NAMASUAMI,
    JUMLAHANAK,
    PEKERJAANSUAMI,
    PEKERJAANISTRI,
    PEKERJAANANAK,
    }
    public TbldatakeluargaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldatakeluarga tbldatakeluarga) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg nip = tbldatakeluarga.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tbldatakeluarga.setNip(nip);
            }
            em.persist(tbldatakeluarga);
            if (nip != null) {
                nip.getTbldatakeluargaList().add(tbldatakeluarga);
                nip = em.merge(nip);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldatakeluarga(tbldatakeluarga.getIdDk()) != null) {
                throw new PreexistingEntityException("Tbldatakeluarga " + tbldatakeluarga + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldatakeluarga tbldatakeluarga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatakeluarga persistentTbldatakeluarga = em.find(Tbldatakeluarga.class, tbldatakeluarga.getIdDk());
            Tbldataindukpeg nipOld = persistentTbldatakeluarga.getNip();
            Tbldataindukpeg nipNew = tbldatakeluarga.getNip();
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tbldatakeluarga.setNip(nipNew);
            }
            tbldatakeluarga = em.merge(tbldatakeluarga);
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTbldatakeluargaList().remove(tbldatakeluarga);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTbldatakeluargaList().add(tbldatakeluarga);
                nipNew = em.merge(nipNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldatakeluarga.getIdDk();
                if (findTbldatakeluarga(id) == null) {
                    throw new NonexistentEntityException("The tbldatakeluarga with id " + id + " no longer exists.");
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
            Tbldatakeluarga tbldatakeluarga;
            try {
                tbldatakeluarga = em.getReference(Tbldatakeluarga.class, id);
                tbldatakeluarga.getIdDk();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldatakeluarga with id " + id + " no longer exists.", enfe);
            }
            Tbldataindukpeg nip = tbldatakeluarga.getNip();
            if (nip != null) {
                nip.getTbldatakeluargaList().remove(tbldatakeluarga);
                nip = em.merge(nip);
            }
            em.remove(tbldatakeluarga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldatakeluarga> findTbldatakeluargaEntities() {
        return findTbldatakeluargaEntities(true, -1, -1);
    }

    public List<Tbldatakeluarga> findTbldatakeluargaEntities(int maxResults, int firstResult) {
        return findTbldatakeluargaEntities(false, maxResults, firstResult);
    }

    private List<Tbldatakeluarga> findTbldatakeluargaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldatakeluarga.class));
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

    public Tbldatakeluarga findTbldatakeluarga(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldatakeluarga.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldatakeluargaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldatakeluarga> rt = cq.from(Tbldatakeluarga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Tbldatakeluarga> findTbldatakeluargasBy(List<Tbldatakeluarga> list, TbldatakeluargaJpaController.Column col, Object value) {
        List<Tbldatakeluarga> result = new ArrayList<>();
        list.stream().forEach((Tbldatakeluarga _item) -> {
            switch(col) {
                case IDK:
                    if(_item.getIdDk().equals(value)) result.add(_item);
                    break;
                case NIP:
                    if(_item.getNip().equals(value)) result.add(_item);
                    break;
                case NAMAAYAH:
                    if(_item.getNamaAyah().equals(value)) result.add(_item);
                    break;
                case NAMAIBU:
                    if(_item.getNamaIbu().equals(value)) result.add(_item);
                    break;
                case NAMAISTRI:
                    if(_item.getNamaIstri().equals(value)) result.add(_item);
                    break;
                case NAMASUAMI:
                    if(_item.getNamaSuami().equals(value)) result.add(_item);
                    break;
                case JUMLAHANAK:
                    if(Objects.equals(_item.getJumlahAnak(), value)) result.add(_item);
                    break;
                case PEKERJAANSUAMI:
                    if(_item.getPekerjaanSuami().equals(value)) result.add(_item);
                    break;
                case PEKERJAANISTRI:
                    if(_item.getPekerjaanIstri().equals(value)) result.add(_item);
                    break;
                case PEKERJAANANAK:
                    if(_item.getPekerjaanAnak().equals(value)) result.add(_item);
                    break;
            }
        });
        return result;
    }
}
