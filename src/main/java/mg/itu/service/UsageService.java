package mg.itu.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import mg.itu.entity.Usage;
import mg.itu.utils.JPAUtils;

public class UsageService {
    
    public static List<Usage> findAll () {
        EntityManager em = JPAUtils.getEntityManager();

        return em.createQuery("select u from Usage u", Usage.class).getResultList();
    }
}
