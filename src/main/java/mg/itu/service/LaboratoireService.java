package mg.itu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mg.itu.entity.Laboratoire;

public class LaboratoireService {
    
    private final EntityManagerFactory emf;

    public LaboratoireService() {
        // Initialiser l'EntityManagerFactory à partir de l'unité de persistance
        this.emf = Persistence.createEntityManagerFactory("pharmaciePU");
    }

    public void create(Laboratoire laboratoire){
        // Créer un EntityManager
        EntityManager em = this.emf.createEntityManager();

        // Démarrer une transaction
        em.getTransaction().begin();

        // Persister l'objet laboratoire
        em.persist(laboratoire);

        // Valider la transaction
        em.getTransaction().commit();

        // Fermer l'EntityManager
        em.close();
    }


    public void close() {
        // Fermer l'EntityManagerFactory
        this.emf.close();
    }

}
