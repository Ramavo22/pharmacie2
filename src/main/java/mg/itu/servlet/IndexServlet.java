package mg.itu.servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.utils.JPAUtils;

import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Initialize EntityManager to start JPA Hibernate
        EntityManager em = JPAUtils.getEntityManager();
        em.close();

        // Forward the request to index.jsp
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
