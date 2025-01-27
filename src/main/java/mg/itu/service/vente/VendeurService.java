package mg.itu.service.vente;

import jakarta.persistence.EntityManager;
import mg.itu.entity.vente.Vendeur;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class VendeurService {

    public static List<Vendeur> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        List<Vendeur> vendeurs = em.createQuery("SELECT v FROM Vendeur v", Vendeur.class).getResultList();
        em.close();
        return vendeurs;
    }

    public  static void create(Vendeur vendeur){
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(vendeur);
        em.getTransaction().commit();
        em.close();
    }
}
