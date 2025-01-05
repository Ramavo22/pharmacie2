package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.MedicamentMaladieNonCompatible;
import mg.itu.utils.JPAUtils;

public class MedicamentMaladieNonCompatibleService {


    public static MedicamentMaladieNonCompatible create(MedicamentMaladieNonCompatible newMedicamentMaladieNonCompatible) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(newMedicamentMaladieNonCompatible);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
        return newMedicamentMaladieNonCompatible;
    }

    public static void delete(Integer id) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            MedicamentMaladieNonCompatible medicamentMaladieNonCompatible = em.find(MedicamentMaladieNonCompatible.class, id);
            if(medicamentMaladieNonCompatible != null) em.remove(medicamentMaladieNonCompatible);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
    }
}
