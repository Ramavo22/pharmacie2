package mg.itu.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Produit;
import mg.itu.entity.vente.Vente;
import mg.itu.service.ProduitService;
import mg.itu.service.vente.VenteService;

@WebServlet("/vente")
public class VenteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Produit> produit = ProduitService.findAll();
       req.setAttribute("produits", produit);
       req.getRequestDispatcher("vente.jsp").forward(req, resp);
    }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String idProduit = req.getParameter("produitId");
       String quantitestr = req.getParameter("quantite");
       String date = req.getParameter("date");

       Integer produitId = Integer.parseInt(idProduit);
       Integer quantite = Integer.parseInt(quantitestr);
       LocalDateTime  dateV = LocalDateTime.parse(date);

       Vente vente = new Vente();
       Produit produit = new Produit();

       produit.setId(produitId);
       vente.setQuantite(quantite);
       vente.setDateVente(dateV);

       VenteService.create(vente);

       doGet(req, resp);

   }

   
}
