package mg.itu;

import mg.itu.entity.Maladie;
import mg.itu.entity.produit.Produit;
import mg.itu.entity.produit.ProduitMois;
import mg.itu.service.MaladieService;
import mg.itu.service.produit.ProduitMoisService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer id = 1;
        LocalDate date = LocalDate.now();

        Integer id2 = 2;
        LocalDate date2 = LocalDate.parse("2025-02-01");

        Produit p1 = new Produit();
        p1.setId(id);


        Produit p2 = new Produit();
        p2.setId(id2);

        ProduitMois pm = new ProduitMois();
        pm.setProduit(p1);
        pm.setDate(date);

        ProduitMois pm2 = new ProduitMois();
        pm2.setProduit(p2);
        pm2.setDate(date2);

        try {
//            ProduitMoisService.create(pm);
//            ProduitMoisService.create(pm2);
            List<ProduitMois> produitMois = ProduitMoisService.findAllByMonth(2,2025);
            for (ProduitMois produitMois1 : produitMois) {
                System.out.println(produitMois1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}