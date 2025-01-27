package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.produit.Produit;
import mg.itu.entity.produit.ProduitMois;
import mg.itu.service.produit.ProduitMoisService;
import mg.itu.service.produit.ProduitService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/produitMois")
public class ProduitMoisServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       loadData(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer produitId = Integer.parseInt(req.getParameter("produitId"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        ProduitMois produitMois = new ProduitMois();

        try{
            Produit produit = new Produit();
            produit.setId(produitId);

            produitMois.setProduit(produit);
            produitMois.setDate(date);
            ProduitMoisService.create(produitMois);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        loadData(req, resp);

    }

    protected void loadData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produit> produits = ProduitService.findAll();
        List<ProduitMois> produitMois = ProduitMoisService.findAll();
        req.setAttribute("produits", produits);
        req.setAttribute("produitMois", produitMois);
        req.getRequestDispatcher("produitMois.jsp").forward(req, resp);
    }
}
