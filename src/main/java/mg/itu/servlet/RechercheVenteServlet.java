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
import mg.itu.entity.vente.Vente;
import mg.itu.service.TypePersonneService;
import mg.itu.service.UsageService;
import mg.itu.service.vente.VenteService;

@WebServlet("/rechercheVente")
public class RechercheVenteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loadData(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer usageId = null;
        Integer typePersId = null;

        String usageIdStr = req.getParameter("usageId");
        String typePersIdStr = req.getParameter("typePersId");

        if(usageIdStr != null && !usageIdStr.trim().isEmpty()){
            usageId = Integer.parseInt(usageIdStr);
        }
        if(typePersIdStr != null && !typePersIdStr.trim().isEmpty()){
            typePersId = Integer.parseInt(typePersIdStr);
        }
        List<Vente> ventes = VenteService.findByTypePersAndUsage(typePersId,usageId);
        req.setAttribute("ventes", ventes);
        loadData(req, resp);
    }

    protected void loadData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<TypePersonne> typePers = TypePersonneService.findAll();
        List<Usage> usage = UsageService.findAll();

        req.setAttribute("typePers", typePers);
        req.setAttribute("usages", usage);

        req.getRequestDispatcher("rechercheVente.jsp").forward(req,resp);

    }
}
