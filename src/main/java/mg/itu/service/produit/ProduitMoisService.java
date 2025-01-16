package mg.itu.service.produit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mg.itu.entity.produit.ProduitMois;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class ProduitMoisService {

    public static ProduitMois create(ProduitMois produitMois) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produitMois);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
        finally {
            if(em.isOpen()) em.close();
        }
        return produitMois;
    }


    public static List<ProduitMois> findAllByMonth(Integer month, Integer year) {
        EntityManager em = JPAUtils.getEntityManager();
        String jpql = """
            SELECT pm FROM ProduitMois pm
            WHERE EXTRACT(MONTH FROM pm.date) = :month
              AND EXTRACT(YEAR FROM pm.date) = :year
            """;
        TypedQuery<ProduitMois> query = em.createQuery(jpql, ProduitMois.class);
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public static List<ProduitMois> findAll() {
        EntityManager em = JPAUtils.getEntityManager();
        return em.createQuery("SELECT pm FROM ProduitMois pm", ProduitMois.class).getResultList();
    }
}
