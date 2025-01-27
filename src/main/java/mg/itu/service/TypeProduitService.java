package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.TypeProduit;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class TypeProduitService {

    public static List<TypeProduit> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        List<TypeProduit> typeProduits = em.createQuery("SELECT t FROM TypeProduit t", TypeProduit.class).getResultList();
        em.close();
        return typeProduits;
    }
}
