package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Client;
import mg.itu.entity.vente.Vente;
import mg.itu.service.ClientService;
import mg.itu.service.vente.VenteService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/rechercheVente2")
public class RechercheVenteClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clients = ClientService.findAll();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("rechercheVente2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer clientId = null;
        //if(!req.getParameter("clientId").isEmpty()) clientId = Integer.valueOf(req.getParameter("clientId"));

        LocalDate date = null;
        if(!req.getParameter("date").isEmpty()) date = LocalDate.parse(req.getParameter("date"));

        List<Vente> ventes = VenteService.findByDateAndClient(clientId, date);

        Set<Client> clients = new HashSet<>();
        for(Vente vente : ventes){
            clients.add(vente.getClient());
        }
        req.setAttribute("ventes", ventes);
        req.setAttribute("today",clients);
        doGet(req, resp);
    }
}
