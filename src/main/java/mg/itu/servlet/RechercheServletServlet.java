package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Maladie;
import mg.itu.entity.Produit;
import mg.itu.entity.TypePersonne;
import mg.itu.service.MaladieService;
import mg.itu.service.ProduitService;
import mg.itu.service.TypePersonneService;

import java.io.IOException;
import java.util.List;

@WebServlet("/rechercheMaladie")
public class RechercheServletServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loadData(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer maladieId = null;
        if(req.getParameter("maladieId") != null
        && !req.getParameter("maladieId").trim().isEmpty()) maladieId = Integer.parseInt(req.getParameter("maladieId"));

        Integer typePersonneId = null;
        if(req.getParameter("typePersonneId") != null
        && !req.getParameter("typePersonneId").trim().isEmpty()) typePersonneId = Integer.parseInt(req.getParameter("typePersonneId"));

        List<Produit> produits = ProduitService.findAll(typePersonneId,maladieId);
        req.setAttribute("produits", produits);

        loadData(req, resp);
    }


    protected void loadData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Maladie> maladies = MaladieService.findAll();
        List<TypePersonne> typePersonnes = TypePersonneService.findAll();

        req.setAttribute("maladies", maladies);
        req.setAttribute("typePersonnes", typePersonnes);

        req.getRequestDispatcher("rechercheMaladie.jsp").forward(req, resp);
    }
}
