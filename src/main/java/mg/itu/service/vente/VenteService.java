package mg.itu.service.vente;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mg.itu.entity.commission.Commission;
import mg.itu.entity.vente.Vente;
import mg.itu.exception.EntityNotFoundException;
import mg.itu.utils.JPAUtils;

public class VenteService {

    public static void create(Vente vente){
        EntityManager em = JPAUtils.getEntityManager();
        try{
            /*
                Inserer la vente
             */
            em.getTransaction().begin();
            em.persist(vente);
            Commission commission = new Commission();
            commission.setVente(vente);
            double commissionValue = vente.getPrixUnitaire() * vente.getQuantite();
            commission.setCommission(commissionValue * 5/100);
            commission.setDate(vente.getDateVente());
            em.persist(commission);

            em.getTransaction().commit();
           
        }
        catch (EntityNotFoundException produitNotFoundException){
            throw produitNotFoundException;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Vente> findByTypePersAndUsage(Integer typePersonneId, Integer usageId) {
        EntityManager em = JPAUtils.getEntityManager();
        
        String jpql = "SELECT v FROM Vente v WHERE 1=1";
        if (typePersonneId != null) {
            jpql += " AND v.produit.typePersonne.id = :typePersonneId";
        }
        if (usageId != null) {
            jpql += " AND v.produit.usage.id = :usageId";
        }
        TypedQuery<Vente> query = em.createQuery(jpql, Vente.class);
        if (typePersonneId != null) {
            query.setParameter("typePersonneId", typePersonneId);
        }
        if (usageId != null) {
            query.setParameter("usageId", usageId);
        }
        return query.getResultList();
    }


    public static List<Vente> findByDateAndClient(Integer clientId, LocalDate date) {
        EntityManager em = JPAUtils.getEntityManager();

        String jpql = "SELECT v FROM Vente v WHERE 1=1";
        if (clientId != null) {
            jpql += " AND v.client.id = :clientId";
        }
        if (date != null) {
            jpql += " AND FUNCTION('date', v.dateVente) = :date";
        }
        TypedQuery<Vente> query = em.createQuery(jpql, Vente.class);
        if (clientId != null) {
            query.setParameter("clientId", clientId);
        }
        if (date != null) {
            query.setParameter("date", date);
        }
        return query.getResultList();
    }

}
