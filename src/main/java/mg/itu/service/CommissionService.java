package mg.itu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mg.itu.dto.CommissionVendeurDTO;
import mg.itu.entity.commission.Commission;
import mg.itu.utils.JPAUtils;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommissionService {

    public static double total(List<CommissionVendeurDTO> commissionVendeurDTOS){
        double total = 0;
        if(commissionVendeurDTOS == null) return total;
        for (CommissionVendeurDTO commissionVendeurDTO : commissionVendeurDTOS){
            total += commissionVendeurDTO.getCommission();
        }
        return total;
    }



    public static HashMap<Integer, List<CommissionVendeurDTO>> commissionParGenre(List<CommissionVendeurDTO> commissionVendeurDTOS) {
        HashMap<Integer, List<CommissionVendeurDTO>> result = new HashMap<>();
        for (CommissionVendeurDTO dto : commissionVendeurDTOS) {
            Integer genreId = dto.getVente().getVendeur().getGenre().getId();
            result.computeIfAbsent(genreId, k -> new ArrayList<>()).add(dto);
        }
        return result;
    }

    public static List<CommissionVendeurDTO> getCommissionByPeriod(LocalDate start, LocalDate end){
        EntityManager em = JPAUtils.getEntityManager();
        String sql = """
        SELECT new mg.itu.dto.CommissionVendeurDTO(c.vente,c.commission)
        FROM Commission c
        WHERE 1 = 1
        """;
        if(start != null){
            sql += " AND FUNCTION('date', c.date) >= :start";
        }
        if(end != null){
            sql += " AND FUNCTION('date', c.date) <= :end";
        }
        TypedQuery<CommissionVendeurDTO> query = em.createQuery(sql, CommissionVendeurDTO.class);
        if(start != null) query.setParameter("start", start);
        if(end != null) query.setParameter("end", end);
        List<CommissionVendeurDTO> list = query.getResultList();
        em.close();
        return list;
    }


    public static List<CommissionVendeurDTO> getCommissionByPeriodByGenre(LocalDate start, LocalDate end,Integer genreId){
        EntityManager em = JPAUtils.getEntityManager();
        String sql = """
        SELECT new mg.itu.dto.CommissionVendeurDTO(c.vente,c.commission)
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
