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
import java.util.List;

@WebServlet("/commission")
public class CommissionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("commission.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate dateStart = null;
        if(!req.getParameter("start").isEmpty()) dateStart = LocalDate.parse(req.getParameter("start"));

        LocalDate dateEnd = null;
        if(!req.getParameter("end").isEmpty()) dateEnd = LocalDate.parse(req.getParameter("end"));

        List<CommissionVendeurDTO> commissionVendeurDTOS = CommissionService.getCommissionByPeriod(dateStart, dateEnd);
        req.setAttribute("commissions", commissionVendeurDTOS);
        doGet(req, resp);
    }
}
