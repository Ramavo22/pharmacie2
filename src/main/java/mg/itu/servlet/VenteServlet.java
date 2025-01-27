package mg.itu.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Client;
import mg.itu.entity.produit.Produit;
import mg.itu.entity.vente.Vendeur;
import mg.itu.entity.vente.Vente;
import mg.itu.service.ClientService;
import mg.itu.service.produit.ProduitService;
import mg.itu.service.vente.VendeurService;
import mg.itu.service.vente.VenteService;

@WebServlet("/vente")
public class VenteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Produit> produit = ProduitService.findAll();
       List<Vente> ventes = VenteService.findByTypePersAndUsage(null,null);
       List<Client> clients = ClientService.findAll();
       List<Vendeur> vendeurs = VendeurService.findAll();
       req.setAttribute("clients", clients);
       req.setAttribute("vente", ventes);
       req.setAttribute("produits", produit);
       req.setAttribute("vendeurs", vendeurs);

       req.getRequestDispatcher("vente.jsp").forward(req, resp);
    }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String idProduit = req.getParameter("produitId");
       String quantitestr = req.getParameter("quantite");
       String date = req.getParameter("date");
       Integer clientId = Integer.parseInt(req.getParameter("clientId"));
       Integer vendeurId = Integer.parseInt(req.getParameter("vendeurId"));

       Integer produitId = Integer.parseInt(idProduit);
       Integer quantite = Integer.parseInt(quantitestr);
       LocalDateTime  dateV = LocalDateTime.parse(date);

       Vente vente = new Vente();
       Produit produit = ProduitService.findById(produitId);

       vente.setProduit(produit);
       vente.setQuantite(quantite);
       vente.setDateVente(dateV);
       vente.setPrixUnitaire(produit.getPrix());

       Client client = new Client();
       client.setId(clientId);
       vente.setClient(client);

       Vendeur vendeur = new Vendeur();
       vendeur.setId(vendeurId);
       vente.setVendeur(vendeur);


       VenteService.create(vente);

       doGet(req, resp);

   }

   
}
