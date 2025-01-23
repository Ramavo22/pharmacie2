package mg.itu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mg.itu.dto.CommissionVendeurDTO;
import mg.itu.entity.commission.Commission;
import mg.itu.utils.JPAUtils;

import java.time.LocalDate;
import java.util.List;

public class CommissionService {

    public static void create(Commission commission, EntityManager em) {
        em.persist(commission);
    }


    public static List<CommissionVendeurDTO> getCommissionByPeriod(LocalDate start, LocalDate end){
        EntityManager em = JPAUtils.getEntityManager();
        String sql = """
        SELECT new mg.itu.dto.CommissionVendeurDTO(c.vente.vendeur,SUM(c.commission))
        FROM Commission c
        WHERE 1 = 1
        """;
        if(start != null){
            sql += " AND FUNCTION('date', c.date) >= :start";
        }
        if(end != null){
            sql += " AND FUNCTION('date', c.date) <= :end";
        }
        sql += " GROUP BY c.vente.vendeur";
        TypedQuery<CommissionVendeurDTO> query = em.createQuery(sql, CommissionVendeurDTO.class);
        if(start != null) query.setParameter("start", start);
        if(end != null) query.setParameter("end", end);
        List<CommissionVendeurDTO> list = query.getResultList();
        em.close();
        return list;
    }


}
