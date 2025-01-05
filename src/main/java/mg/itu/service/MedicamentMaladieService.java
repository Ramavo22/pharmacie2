package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.MedicamentMaladie;
import mg.itu.utils.JPAUtils;


public class MedicamentMaladieService {

    public static MedicamentMaladie create(MedicamentMaladie newMedicamentMaladie) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newMedicamentMaladie);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
        return newMedicamentMaladie;
    }

    public static void delete(Integer id) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
           MedicamentMaladie maladie = em.find(MedicamentMaladie.class, id);
           if(maladie != null) em.remove(maladie);
           em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
        }
    }
}
