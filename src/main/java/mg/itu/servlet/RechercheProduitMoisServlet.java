package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.produit.ProduitMois;
import mg.itu.service.produit.ProduitMoisService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/rechercheProduitMois")
public class RechercheProduitMoisServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate date = LocalDate.now();
        Integer month = date.getMonthValue();
        Integer year = date.getYear();

        List<ProduitMois> produitMoisList = ProduitMoisService.findAllByMonth(month, year);
        req.setAttribute("produitMois", produitMoisList);
       req.getRequestDispatcher("rechercheProduitMois.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer month = Integer.parseInt(req.getParameter("month"));
        Integer year = Integer.parseInt(req.getParameter("year"));

        LocalDate date = LocalDate.now();
        month = date.getMonthValue();
        year = date.getYear();

        List<ProduitMois> produitMoisList = ProduitMoisService.findAllByMonth(month, year);
        req.setAttribute("produitMois", produitMoisList);
        doGet(req, resp);
    }
}
