package mg.itu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mg.itu.entity.Laboratoire;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class LaboratoireService {

    public static Laboratoire create(Laboratoire laboratoire){
        // Créer un EntityManager
        EntityManager em = JPAUtils.getEntityManager();

        // Démarrer une transaction
        em.getTransaction().begin();

        // Persister l'objet laboratoire
        em.persist(laboratoire);

        // Valider la transaction
        em.getTransaction().commit();

        // Fermer l'EntityManager
        em.close();

        return laboratoire;
    }

    public static List<Laboratoire> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        List<Laboratoire> laboratoires = em.createQuery("SELECT l FROM Laboratoire l",Laboratoire.class).getResultList();
        em.close();
        return laboratoires;
    }

    public static Laboratoire findById(Integer id){
        EntityManager em = JPAUtils.getEntityManager();
        Laboratoire laboratoire = em.find(Laboratoire.class, id);
        em.close();
        return laboratoire;
    }

    public static void update(Laboratoire laboratoire){
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();

        em.merge(laboratoire);
        em.getTransaction().commit();
        // rollback management
        em.close();
    }

    public static void delete(Integer id){
        EntityManager em = JPAUtils.getEntityManager();
        Laboratoire laboratoire = em.find(Laboratoire.class, id);
        em.getTransaction().begin();
        if(laboratoire != null){
            em.remove(laboratoire);
        }
        em.getTransaction().commit();
        em.close();
    }




}
