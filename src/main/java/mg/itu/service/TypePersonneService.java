package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.entity.TypePersonne;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class TypePersonneService {

    public static List<TypePersonne> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        return em.createQuery("SELECT t FROM TypePersonne t", TypePersonne.class).getResultList();
    }

}
