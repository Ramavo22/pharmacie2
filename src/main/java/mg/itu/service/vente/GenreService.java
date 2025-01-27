package mg.itu.service.vente;

import jakarta.persistence.EntityManager;
import mg.itu.entity.Genre;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class GenreService {

    public static List<Genre> findAll(){
        EntityManager em = JPAUtils.getEntityManager();
        List<Genre> genres = em.createQuery("SELECT g FROM Genre g",Genre.class).getResultList();
        em.close();
        return genres;
    }
}
