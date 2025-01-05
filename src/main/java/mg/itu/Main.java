package mg.itu;

import mg.itu.constante.Constante;
import mg.itu.entity.Produit;
import mg.itu.entity.TypeProduit;
import mg.itu.service.ProduitService;
import org.postgresql.largeobject.LargeObject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mg.itu.entity.Laboratoire;
import mg.itu.service.LaboratoireService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String label = "Doliprane";
        double prix = 3000;
        Integer typeProduitId = Constante.MEDICAMENT_ID;
        Integer laboratoireId = 3;

        Laboratoire laboratoire = new Laboratoire(laboratoireId);
        TypeProduit typeProduit = new TypeProduit(typeProduitId.shortValue());

        Produit produit = new Produit();

        produit.setLabel(label);
        produit.setPrix(prix);
        produit.setTypeProduit(typeProduit);
        produit.setLaboratoire(laboratoire);

        produit.setEnStock(0);

        List<Integer> indicationIds = new ArrayList<>();
        indicationIds.add(2);
        indicationIds.add(3);

        List<Integer> contreIndicationIds = new ArrayList<>();
        contreIndicationIds.add(7);

        try {
//            ProduitService.create(produit, indicationIds, contreIndicationIds);

            List<Produit> produits = ProduitService.findAll();
            for (Produit p : produits) {
                System.out.println(p);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}