package mg.itu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.*;
import mg.itu.entity.produit.Produit;
import mg.itu.service.*;
import mg.itu.service.produit.ProduitService;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loadData(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            Données du formulaire
         */
        // nom
        String nom = req.getParameter("label");

        // prix
        Double prix = Double.parseDouble(req.getParameter("prix"));

        // usage
        Integer usageId = Integer.parseInt(req.getParameter("usageId"));
        Usage usage = new Usage();
        usage.setId(usageId);

        // laboratoire
        Integer laboratoireId = null;
        if(!req.getParameter("laboratoireId").isEmpty()) laboratoireId = Integer.parseInt(req.getParameter("laboratoireId"));

        // type Produits
        Integer typeProduitId = Integer.parseInt(req.getParameter("typeProduitId"));

        // type de personne
        Integer typePersonneId = null;
        if( !req.getParameter("typePersonneId").isEmpty()) typePersonneId = Integer.parseInt(req.getParameter("typePersonneId"));

        // les maladies compatibles
        String[] compatiblesStr = req.getParameterValues("compatibles[]");
        List<Integer> compatibles = new ArrayList<>();
        int i = 0;
        while(i<compatiblesStr.length){
            if(!compatiblesStr[i].trim().isEmpty()) compatibles.add(Integer.parseInt(compatiblesStr[i]));
            i++;
        }

        // les maladies imcompatibles
        String[] nonCompatiblesStr = req.getParameterValues("nonCompatibles[]");
        List<Integer> nonCompatibles = new ArrayList<>();
        i = 0;
        while(i<nonCompatiblesStr.length){
            if(!nonCompatiblesStr[i].trim().isEmpty()) nonCompatibles.add(Integer.parseInt(nonCompatiblesStr[i]));
            i++;
        }

        try {
            // creation de la classe produits
            Produit produit = new Produit();
            produit.setLabel(nom);
            produit.setPrix(prix);
            produit.setEnStock(0);
            produit.setUsage(usage);

            if(laboratoireId != null){
                Laboratoire laboratoire = new Laboratoire();
                laboratoire.setId(laboratoireId);
                produit.setLaboratoire(laboratoire);
            }

            if(typePersonneId != null){
                TypePersonne typePersonne = new TypePersonne();
                typePersonne.setId(typePersonneId);
                produit.setTypePersonne(typePersonne);
            }

            TypeProduit typeProduit = new TypeProduit();
            typeProduit.setId(typeProduitId.shortValue());
            produit.setTypeProduit(typeProduit);

            ProduitService.create(produit,compatibles,nonCompatibles);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        loadData(req,resp);


     }


    private void loadData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Laboratoire> laboratoires = LaboratoireService.findAll();
        List<TypeProduit> typeProduits = TypeProduitService.findAll();
        List<Maladie> maladies = MaladieService.findAll();
        List<TypePersonne> personnes = TypePersonneService.findAll();
        List<Usage> usages = UsageService.findAll();
        List<Produit> produits = ProduitService.findAll();

        req.setAttribute("laboratoires", laboratoires);
        req.setAttribute("typeProduits", typeProduits);
        req.setAttribute("maladies",maladies);
        req.setAttribute("produits",produits);
        req.setAttribute("personnes",personnes);
        req.setAttribute("usages",usages);

        req.getRequestDispatcher("produit.jsp").forward(req, resp);
    }
}
