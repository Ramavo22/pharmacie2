package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.Maladie;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class MaladieService {

    public static Maladie create(Maladie newMaladie){
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newMaladie);
            em.getTransaction().commit();
        }
        catch(Exception e){
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        return newMaladie;
    }

    public static List<Maladie> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        List<Maladie> maladies = em.createQuery("SELECT m FROM Maladie m",Maladie.class).getResultList();
        em.close();
        return maladies;
    }

    public static Maladie findById(Integer id){
        EntityManager em = JPAUtils.getEntityManager();
        Maladie maladie = em.find(Maladie.class, id);
        em.close();
        return maladie;
    }

    public static void update(Maladie maladie) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(maladie);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em.getTransaction().isActive()) em.getTransaction().commit();
        }
    }

    public static void delete(Integer id){
        EntityManager em = JPAUtils.getEntityManager();
        Maladie maladie = em.find(Maladie.class, id);
        em.getTransaction().begin();
        try {
            if(maladie != null) em.remove(maladie);
            em.getTransaction().commit();
        }
        catch(Exception e){
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (em.getTransaction().isActive()) em.getTransaction().commit();
        }
    }

}
