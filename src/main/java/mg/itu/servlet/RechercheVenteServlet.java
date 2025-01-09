package mg.itu.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.TypePersonne;
import mg.itu.entity.Usage;
import mg.itu.service.TypePersonneService;
import mg.itu.service.UsageService;

@WebServlet("/rechercheVente")
public class RechercheVenteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TypePersonne> typePers = TypePersonneService.findAll();
        List<Usage> usage = UsageService.findAll();
    }
}
