package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Genre;
import mg.itu.entity.vente.Vendeur;
import mg.itu.service.vente.GenreService;
import mg.itu.service.vente.VendeurService;

import java.io.IOException;
import java.util.List;

@WebServlet("/vendeur")
public class VendeurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vendeur> vendeurs = VendeurService.findAll();
        List<Genre> genres = GenreService.findAll();
        req.setAttribute("vendeurs", vendeurs);
        req.setAttribute("genres", genres);
        req.getRequestDispatcher("vendeur.jsp").forward(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        Integer genreId = Integer.parseInt(req.getParameter("genreId"));
        Vendeur vendeur = new Vendeur();
        vendeur.setName(nom);

        Genre genre = new Genre();
        genre.setId(genreId);
        vendeur.setGenre(genre);
        VendeurService.create(vendeur);
        doGet(req, resp);
    }
}
