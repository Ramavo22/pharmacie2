package mg.itu.service.vente;

import jakarta.persistence.EntityManager;
import mg.itu.entity.Produit;
import mg.itu.entity.vente.Vente;
import mg.itu.entity.vente.VenteDetails;
import mg.itu.exception.ProduitNotFoundException;
import mg.itu.utils.JPAUtils;

public class VenteService {

    public static void create(Vente vente, Integer[] produitsIds, Integer[] quantites){
        EntityManager em = JPAUtils.getEntityManager();
        try{
            /*
                Inserer la vente
             */
            em.getTransaction().begin();
            em.persist(vente);
            /*
            *   Inserer les details de la ventes
            * */
            for(int i = 0; i<produitsIds.length; i++){
                VenteDetails venteDetails = new VenteDetails();

                Produit produit = em.find(Produit.class, produitsIds[i]);

                venteDetails.setVente(vente);
                venteDetails.setProduit(produit);
                venteDetails.setQuantite(quantites[i]);
                venteDetails.setPrixUnitaire(produit.getPrix());
                venteDetails.setPrixTotal(venteDetails.getPrixUnitaire()*venteDetails.getQuantite());

                em.persist(venteDetails);
            }
        }
        catch (ProduitNotFoundException produitNotFoundException){
            throw produitNotFoundException;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
