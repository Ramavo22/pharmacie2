package mg.itu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mg.itu.entity.Laboratoire;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pharmaciePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setLabel("Laboratoire 1");

        em.persist(laboratoire);

        em.getTransaction().commit();

        System.out.println("Laboratoire ajouté avec succès");

        em.close();
        emf.close();
    }
}