package mg.itu;

import mg.itu.constante.Constante;
import mg.itu.entity.Maladie;
import mg.itu.entity.Produit;
import mg.itu.entity.TypeProduit;
import mg.itu.service.MaladieService;
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
        List<Maladie> maladies = new ArrayList<>();
        maladies = MaladieService.findAll();

        for (Maladie maladie : maladies) {
            System.out.println(maladie);
        }
        System.out.println("vitaaa");

    }
}