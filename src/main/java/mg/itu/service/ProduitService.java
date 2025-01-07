package mg.itu.service;

import jakarta.persistence.EntityManager;
import mg.itu.constante.Constante;
import mg.itu.entity.*;
import mg.itu.utils.JPAUtils;

import java.util.List;

public class ProduitService {

    public static Produit create(Produit produit, List<Integer> MaladieCompatibleIds, List<Integer> MaladieNonCompatibleIds) {
        EntityManager em = JPAUtils.getEntityManager();
        /*
        * validation
        * */
        try{
            em.getTransaction().begin();
            /*
                inserer le produit
             */
            em.persist(produit);
            // verifier si le typeProduit est Medicament ou accessoire
            if(produit.getTypeProduit().getId().intValue() == Constante.MEDICAMENT_ID){
                /*
                 *   Insertion des maladies efficace pour les medicaments
                 * */
                if(MaladieCompatibleIds != null || !MaladieNonCompatibleIds.isEmpty()){
                    for (Integer maladieCompabibleId : MaladieCompatibleIds) {
                        MedicamentMaladie medicamentMaladie = new MedicamentMaladie();

                        Maladie maladie = new Maladie();
                        maladie.setId(maladieCompabibleId);

                        medicamentMaladie.setProduit(produit);
                        medicamentMaladie.setMaladie(maladie);

                        em.persist(medicamentMaladie);
                    }
                }
            /*
                Insertion des maladies incompatible pour le medicament
             */
                if(MaladieNonCompatibleIds != null || !MaladieNonCompatibleIds.isEmpty()){
                    for(Integer maladieNonCompatibleId : MaladieNonCompatibleIds){
                        MedicamentMaladieNonCompatible medicamentMaladieNonCompatible = new MedicamentMaladieNonCompatible();

                        Maladie maladie = new Maladie();
                        maladie.setId(maladieNonCompatibleId);

                        medicamentMaladieNonCompatible.setProduit(produit);
                        medicamentMaladieNonCompatible.setMaladie(maladie);

                        em.persist(medicamentMaladieNonCompatible);
                    }
                }
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return produit;
    }


    public static Produit findById(Integer id) {
        EntityManager em = JPAUtils.getEntityManager();
        Produit produit = em.find(Produit.class, id);
        em.close();
        return produit;
    }


    public static List<Produit> findAll() {
        EntityManager em = JPAUtils.getEntityManager();
        List<Produit> produits = em.createQuery("SELECT p FROM Produit p",Produit.class).getResultList();
        // Charger chaque collection individuellement
        for (Produit produit : produits) {
            produit.getMedicamentMaladieNonCompatibles().size(); // Force l'initialisation
            produit.getMedicamentMaladies().size(); // Force l'initialisation
        }
        em.close();
        return produits;
    }

//    public static void update(Produit produit){
//        EntityManager em = JPAUtils.getEntityManager();
//        em.getTransaction().begin();
//        try {
//            em.merge(produit);
//            em.getTransaction().commit();
//        }
//        catch(Exception e){
//            if(em.getTransaction().isActive()) em.getTransaction().rollback();
//            e.printStackTrace();
//        }
//        finally {
//            if(em.isOpen()) em.close();
//        }
//    }

    public static void delete(Integer id){
        EntityManager em = JPAUtils.getEntityManager();
        Produit produit = em.find(Produit.class, id);
        em.getTransaction().begin();
        try {
            if(produit != null) em.remove(produit);
            em.getTransaction().commit();
        }
        catch(Exception e){
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if(em.isOpen()) em.close();
        }
    }

}
