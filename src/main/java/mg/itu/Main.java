package mg.itu;

import org.postgresql.largeobject.LargeObject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mg.itu.entity.Laboratoire;
import mg.itu.service.LaboratoireService;

public class Main {
    public static void main(String[] args) {
         LaboratoireService laboratoireService = new LaboratoireService();

         Laboratoire laboratoire = new Laboratoire();
        laboratoire.setLabel("Homeopharma");

         try {
             laboratoireService.create(laboratoire);
             System.out.println("Laboratoire créé avec succès, l'id est : " + laboratoire.getId());
         } catch (Exception e) {
            e.printStackTrace();
         }
         finally {
             laboratoireService.close();
        }
    }
}