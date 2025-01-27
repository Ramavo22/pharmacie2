package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.dto.CommissionVendeurDTO;
import mg.itu.service.CommissionService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@WebServlet("/commission2")
public class CommissionServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("commission2.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate dateStart = null;
        if(!req.getParameter("start").isEmpty()) dateStart = LocalDate.parse(req.getParameter("start"));

        LocalDate dateEnd = null;
        if(!req.getParameter("end").isEmpty()) dateEnd = LocalDate.parse(req.getParameter("end"));

        List<CommissionVendeurDTO> commissionVendeurDTOS = CommissionService.getCommissionByPeriod(dateStart, dateEnd);
        HashMap<Integer,List<CommissionVendeurDTO>> filtreGenre = CommissionService.commissionParGenre(commissionVendeurDTOS);
        req.setAttribute("hommes", filtreGenre.get(1));
        req.setAttribute("femmes", filtreGenre.get(2));
        double totalHomme = CommissionService.total(filtreGenre.get(1));
        double totalFemme = CommissionService.total(filtreGenre.get(2));
        req.setAttribute("totalHomme", totalHomme);
        req.setAttribute("totalFemme", totalFemme);
        req.getRequestDispatcher("commission2.jsp").forward(req,resp);
    }
}
