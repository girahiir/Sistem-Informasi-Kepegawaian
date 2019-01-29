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
import Entities.Tbldatapengajupangkat;
import Entities.Tblterimanaikpangkat;
import java.util.ArrayList;
import java.util.List;
import Entities.Tbltolaknaikpangkat;
import EntitiesController.exceptions.IllegalOrphanException;
import EntitiesController.exceptions.NonexistentEntityException;
import EntitiesController.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Arsyadi Ahmad
 */
public class TbldatapengajupangkatJpaController implements Serializable {

    public TbldatapengajupangkatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbldatapengajupangkat tbldatapengajupangkat) throws PreexistingEntityException, Exception {
        if (tbldatapengajupangkat.getTblterimanaikpangkatList() == null) {
            tbldatapengajupangkat.setTblterimanaikpangkatList(new ArrayList<Tblterimanaikpangkat>());
        }
        if (tbldatapengajupangkat.getTbltolaknaikpangkatList() == null) {
            tbldatapengajupangkat.setTbltolaknaikpangkatList(new ArrayList<Tbltolaknaikpangkat>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldataindukpeg nip = tbldatapengajupangkat.getNip();
            if (nip != null) {
                nip = em.getReference(nip.getClass(), nip.getNip());
                tbldatapengajupangkat.setNip(nip);
            }
            List<Tblterimanaikpangkat> attachedTblterimanaikpangkatList = new ArrayList<Tblterimanaikpangkat>();
            for (Tblterimanaikpangkat tblterimanaikpangkatListTblterimanaikpangkatToAttach : tbldatapengajupangkat.getTblterimanaikpangkatList()) {
                tblterimanaikpangkatListTblterimanaikpangkatToAttach = em.getReference(tblterimanaikpangkatListTblterimanaikpangkatToAttach.getClass(), tblterimanaikpangkatListTblterimanaikpangkatToAttach.getIdTerima());
                attachedTblterimanaikpangkatList.add(tblterimanaikpangkatListTblterimanaikpangkatToAttach);
            }
            tbldatapengajupangkat.setTblterimanaikpangkatList(attachedTblterimanaikpangkatList);
            List<Tbltolaknaikpangkat> attachedTbltolaknaikpangkatList = new ArrayList<Tbltolaknaikpangkat>();
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListTbltolaknaikpangkatToAttach : tbldatapengajupangkat.getTbltolaknaikpangkatList()) {
                tbltolaknaikpangkatListTbltolaknaikpangkatToAttach = em.getReference(tbltolaknaikpangkatListTbltolaknaikpangkatToAttach.getClass(), tbltolaknaikpangkatListTbltolaknaikpangkatToAttach.getIdTolak());
                attachedTbltolaknaikpangkatList.add(tbltolaknaikpangkatListTbltolaknaikpangkatToAttach);
            }
            tbldatapengajupangkat.setTbltolaknaikpangkatList(attachedTbltolaknaikpangkatList);
            em.persist(tbldatapengajupangkat);
            if (nip != null) {
                nip.getTbldatapengajupangkatList().add(tbldatapengajupangkat);
                nip = em.merge(nip);
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatListTblterimanaikpangkat : tbldatapengajupangkat.getTblterimanaikpangkatList()) {
                Tbldatapengajupangkat oldIdPengajuPangkatOfTblterimanaikpangkatListTblterimanaikpangkat = tblterimanaikpangkatListTblterimanaikpangkat.getIdPengajuPangkat();
                tblterimanaikpangkatListTblterimanaikpangkat.setIdPengajuPangkat(tbldatapengajupangkat);
                tblterimanaikpangkatListTblterimanaikpangkat = em.merge(tblterimanaikpangkatListTblterimanaikpangkat);
                if (oldIdPengajuPangkatOfTblterimanaikpangkatListTblterimanaikpangkat != null) {
                    oldIdPengajuPangkatOfTblterimanaikpangkatListTblterimanaikpangkat.getTblterimanaikpangkatList().remove(tblterimanaikpangkatListTblterimanaikpangkat);
                    oldIdPengajuPangkatOfTblterimanaikpangkatListTblterimanaikpangkat = em.merge(oldIdPengajuPangkatOfTblterimanaikpangkatListTblterimanaikpangkat);
                }
            }
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListTbltolaknaikpangkat : tbldatapengajupangkat.getTbltolaknaikpangkatList()) {
                Tbldatapengajupangkat oldIdPengajuPangkatOfTbltolaknaikpangkatListTbltolaknaikpangkat = tbltolaknaikpangkatListTbltolaknaikpangkat.getIdPengajuPangkat();
                tbltolaknaikpangkatListTbltolaknaikpangkat.setIdPengajuPangkat(tbldatapengajupangkat);
                tbltolaknaikpangkatListTbltolaknaikpangkat = em.merge(tbltolaknaikpangkatListTbltolaknaikpangkat);
                if (oldIdPengajuPangkatOfTbltolaknaikpangkatListTbltolaknaikpangkat != null) {
                    oldIdPengajuPangkatOfTbltolaknaikpangkatListTbltolaknaikpangkat.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkatListTbltolaknaikpangkat);
                    oldIdPengajuPangkatOfTbltolaknaikpangkatListTbltolaknaikpangkat = em.merge(oldIdPengajuPangkatOfTbltolaknaikpangkatListTbltolaknaikpangkat);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTbldatapengajupangkat(tbldatapengajupangkat.getIdPengajuPangkat()) != null) {
                throw new PreexistingEntityException("Tbldatapengajupangkat " + tbldatapengajupangkat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbldatapengajupangkat tbldatapengajupangkat) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbldatapengajupangkat persistentTbldatapengajupangkat = em.find(Tbldatapengajupangkat.class, tbldatapengajupangkat.getIdPengajuPangkat());
            Tbldataindukpeg nipOld = persistentTbldatapengajupangkat.getNip();
            Tbldataindukpeg nipNew = tbldatapengajupangkat.getNip();
            List<Tblterimanaikpangkat> tblterimanaikpangkatListOld = persistentTbldatapengajupangkat.getTblterimanaikpangkatList();
            List<Tblterimanaikpangkat> tblterimanaikpangkatListNew = tbldatapengajupangkat.getTblterimanaikpangkatList();
            List<Tbltolaknaikpangkat> tbltolaknaikpangkatListOld = persistentTbldatapengajupangkat.getTbltolaknaikpangkatList();
            List<Tbltolaknaikpangkat> tbltolaknaikpangkatListNew = tbldatapengajupangkat.getTbltolaknaikpangkatList();
            List<String> illegalOrphanMessages = null;
            for (Tblterimanaikpangkat tblterimanaikpangkatListOldTblterimanaikpangkat : tblterimanaikpangkatListOld) {
                if (!tblterimanaikpangkatListNew.contains(tblterimanaikpangkatListOldTblterimanaikpangkat)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tblterimanaikpangkat " + tblterimanaikpangkatListOldTblterimanaikpangkat + " since its idPengajuPangkat field is not nullable.");
                }
            }
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListOldTbltolaknaikpangkat : tbltolaknaikpangkatListOld) {
                if (!tbltolaknaikpangkatListNew.contains(tbltolaknaikpangkatListOldTbltolaknaikpangkat)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tbltolaknaikpangkat " + tbltolaknaikpangkatListOldTbltolaknaikpangkat + " since its idPengajuPangkat field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (nipNew != null) {
                nipNew = em.getReference(nipNew.getClass(), nipNew.getNip());
                tbldatapengajupangkat.setNip(nipNew);
            }
            List<Tblterimanaikpangkat> attachedTblterimanaikpangkatListNew = new ArrayList<Tblterimanaikpangkat>();
            for (Tblterimanaikpangkat tblterimanaikpangkatListNewTblterimanaikpangkatToAttach : tblterimanaikpangkatListNew) {
                tblterimanaikpangkatListNewTblterimanaikpangkatToAttach = em.getReference(tblterimanaikpangkatListNewTblterimanaikpangkatToAttach.getClass(), tblterimanaikpangkatListNewTblterimanaikpangkatToAttach.getIdTerima());
                attachedTblterimanaikpangkatListNew.add(tblterimanaikpangkatListNewTblterimanaikpangkatToAttach);
            }
            tblterimanaikpangkatListNew = attachedTblterimanaikpangkatListNew;
            tbldatapengajupangkat.setTblterimanaikpangkatList(tblterimanaikpangkatListNew);
            List<Tbltolaknaikpangkat> attachedTbltolaknaikpangkatListNew = new ArrayList<Tbltolaknaikpangkat>();
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach : tbltolaknaikpangkatListNew) {
                tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach = em.getReference(tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach.getClass(), tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach.getIdTolak());
                attachedTbltolaknaikpangkatListNew.add(tbltolaknaikpangkatListNewTbltolaknaikpangkatToAttach);
            }
            tbltolaknaikpangkatListNew = attachedTbltolaknaikpangkatListNew;
            tbldatapengajupangkat.setTbltolaknaikpangkatList(tbltolaknaikpangkatListNew);
            tbldatapengajupangkat = em.merge(tbldatapengajupangkat);
            if (nipOld != null && !nipOld.equals(nipNew)) {
                nipOld.getTbldatapengajupangkatList().remove(tbldatapengajupangkat);
                nipOld = em.merge(nipOld);
            }
            if (nipNew != null && !nipNew.equals(nipOld)) {
                nipNew.getTbldatapengajupangkatList().add(tbldatapengajupangkat);
                nipNew = em.merge(nipNew);
            }
            for (Tblterimanaikpangkat tblterimanaikpangkatListNewTblterimanaikpangkat : tblterimanaikpangkatListNew) {
                if (!tblterimanaikpangkatListOld.contains(tblterimanaikpangkatListNewTblterimanaikpangkat)) {
                    Tbldatapengajupangkat oldIdPengajuPangkatOfTblterimanaikpangkatListNewTblterimanaikpangkat = tblterimanaikpangkatListNewTblterimanaikpangkat.getIdPengajuPangkat();
                    tblterimanaikpangkatListNewTblterimanaikpangkat.setIdPengajuPangkat(tbldatapengajupangkat);
                    tblterimanaikpangkatListNewTblterimanaikpangkat = em.merge(tblterimanaikpangkatListNewTblterimanaikpangkat);
                    if (oldIdPengajuPangkatOfTblterimanaikpangkatListNewTblterimanaikpangkat != null && !oldIdPengajuPangkatOfTblterimanaikpangkatListNewTblterimanaikpangkat.equals(tbldatapengajupangkat)) {
                        oldIdPengajuPangkatOfTblterimanaikpangkatListNewTblterimanaikpangkat.getTblterimanaikpangkatList().remove(tblterimanaikpangkatListNewTblterimanaikpangkat);
                        oldIdPengajuPangkatOfTblterimanaikpangkatListNewTblterimanaikpangkat = em.merge(oldIdPengajuPangkatOfTblterimanaikpangkatListNewTblterimanaikpangkat);
                    }
                }
            }
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListNewTbltolaknaikpangkat : tbltolaknaikpangkatListNew) {
                if (!tbltolaknaikpangkatListOld.contains(tbltolaknaikpangkatListNewTbltolaknaikpangkat)) {
                    Tbldatapengajupangkat oldIdPengajuPangkatOfTbltolaknaikpangkatListNewTbltolaknaikpangkat = tbltolaknaikpangkatListNewTbltolaknaikpangkat.getIdPengajuPangkat();
                    tbltolaknaikpangkatListNewTbltolaknaikpangkat.setIdPengajuPangkat(tbldatapengajupangkat);
                    tbltolaknaikpangkatListNewTbltolaknaikpangkat = em.merge(tbltolaknaikpangkatListNewTbltolaknaikpangkat);
                    if (oldIdPengajuPangkatOfTbltolaknaikpangkatListNewTbltolaknaikpangkat != null && !oldIdPengajuPangkatOfTbltolaknaikpangkatListNewTbltolaknaikpangkat.equals(tbldatapengajupangkat)) {
                        oldIdPengajuPangkatOfTbltolaknaikpangkatListNewTbltolaknaikpangkat.getTbltolaknaikpangkatList().remove(tbltolaknaikpangkatListNewTbltolaknaikpangkat);
                        oldIdPengajuPangkatOfTbltolaknaikpangkatListNewTbltolaknaikpangkat = em.merge(oldIdPengajuPangkatOfTbltolaknaikpangkatListNewTbltolaknaikpangkat);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tbldatapengajupangkat.getIdPengajuPangkat();
                if (findTbldatapengajupangkat(id) == null) {
                    throw new NonexistentEntityException("The tbldatapengajupangkat with id " + id + " no longer exists.");
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
            Tbldatapengajupangkat tbldatapengajupangkat;
            try {
                tbldatapengajupangkat = em.getReference(Tbldatapengajupangkat.class, id);
                tbldatapengajupangkat.getIdPengajuPangkat();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbldatapengajupangkat with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Tblterimanaikpangkat> tblterimanaikpangkatListOrphanCheck = tbldatapengajupangkat.getTblterimanaikpangkatList();
            for (Tblterimanaikpangkat tblterimanaikpangkatListOrphanCheckTblterimanaikpangkat : tblterimanaikpangkatListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tbldatapengajupangkat (" + tbldatapengajupangkat + ") cannot be destroyed since the Tblterimanaikpangkat " + tblterimanaikpangkatListOrphanCheckTblterimanaikpangkat + " in its tblterimanaikpangkatList field has a non-nullable idPengajuPangkat field.");
            }
            List<Tbltolaknaikpangkat> tbltolaknaikpangkatListOrphanCheck = tbldatapengajupangkat.getTbltolaknaikpangkatList();
            for (Tbltolaknaikpangkat tbltolaknaikpangkatListOrphanCheckTbltolaknaikpangkat : tbltolaknaikpangkatListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tbldatapengajupangkat (" + tbldatapengajupangkat + ") cannot be destroyed since the Tbltolaknaikpangkat " + tbltolaknaikpangkatListOrphanCheckTbltolaknaikpangkat + " in its tbltolaknaikpangkatList field has a non-nullable idPengajuPangkat field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Tbldataindukpeg nip = tbldatapengajupangkat.getNip();
            if (nip != null) {
                nip.getTbldatapengajupangkatList().remove(tbldatapengajupangkat);
                nip = em.merge(nip);
            }
            em.remove(tbldatapengajupangkat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbldatapengajupangkat> findTbldatapengajupangkatEntities() {
        return findTbldatapengajupangkatEntities(true, -1, -1);
    }

    public List<Tbldatapengajupangkat> findTbldatapengajupangkatEntities(int maxResults, int firstResult) {
        return findTbldatapengajupangkatEntities(false, maxResults, firstResult);
    }

    private List<Tbldatapengajupangkat> findTbldatapengajupangkatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbldatapengajupangkat.class));
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

    public Tbldatapengajupangkat findTbldatapengajupangkat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbldatapengajupangkat.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbldatapengajupangkatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbldatapengajupangkat> rt = cq.from(Tbldatapengajupangkat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
