package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.TypeProduit;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class TypeProduitService {

    public static List<TypeProduit> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        return em.createQuery("from TypeProduit", TypeProduit.class).getResultList();
    }
}
