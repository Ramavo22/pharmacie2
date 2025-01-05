package mg.itu.service.stock;


import jakarta.persistence.EntityManager;
import mg.itu.entity.Produit;
import mg.itu.entity.stock.Stock;
import mg.itu.utils.JPAUtils;

public class StockService {
    public static void addStock(Stock stock) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stock);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
    }

    public static void updateStock(Stock stock) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(stock);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
    }

    public static void deleteStock(Integer id) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            Stock stock = em.find(Stock.class, id);
            if(stock != null) em.remove(stock);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
    }
}
