package mg.itu.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mg.itu.constante.Constante;
import mg.itu.entity.*;
import mg.itu.utils.JPAUtils;

import java.util.ArrayList;
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

    public static List<Produit> findAll(Integer typePersonneId, Integer maladieId) {
        EntityManager em = JPAUtils.getEntityManager();

        // Début de la requête de base
        StringBuilder jpql = new StringBuilder("SELECT p FROM Produit p ");

        // Jointure pour la table MedicamentMaladies
        jpql.append("JOIN p.medicamentMaladies mm ");

        // Liste pour les conditions
        List<String> conditions = new ArrayList<>();

        // Ajout de la condition pour le typePersonneId si spécifié
        if (typePersonneId != null) {
            conditions.add("p.typePersonne.id = :typePersonneId");
        }

        // Ajout de la condition pour le maladieId si spécifié
        if (maladieId != null) {
            conditions.add("mm.maladie.id = :maladieId");
        }

        // Ajouter les conditions à la requête
        if (!conditions.isEmpty()) {
            jpql.append("WHERE ");
            jpql.append(String.join(" AND ", conditions));
        }

        // Création de la requête
        TypedQuery<Produit> query = em.createQuery(jpql.toString(), Produit.class);

        // Définir les paramètres si nécessaires
        if (typePersonneId != null) {
            query.setParameter("typePersonneId", typePersonneId);
        }
        if (maladieId != null) {
            query.setParameter("maladieId", maladieId);
        }

        return query.getResultList();
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
