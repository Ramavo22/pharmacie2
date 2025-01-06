package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Maladie;
import mg.itu.exception.EntityNotFoundException;
import mg.itu.service.MaladieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/maladie")
public class MaladieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            loadData(req,resp,"save");
        }
        else{
            if(action.compareToIgnoreCase("toUpdate") == 0) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                Maladie maladie = MaladieService.findById(id);
                req.setAttribute("modifMaladie", maladie);
                loadData(req,resp,"update");
            }
            if(action.compareToIgnoreCase("delete") == 0) {
                doDelete(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            loadData(req,resp,"save");
        }
        if(action.compareToIgnoreCase("save") == 0) {
            String label = req.getParameter("label");
            Maladie maladie = new Maladie();
            maladie.setLabel(label);
            MaladieService.create(maladie);
            loadData(req,resp,"save");
        }
        if(action.compareToIgnoreCase("update") == 0) {
            doPut(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            Maladie maladie = MaladieService.findById(id);
            maladie.setLabel(req.getParameter("label"));
            MaladieService.update(maladie);

        }
        catch (EntityNotFoundException notFoundException) {
            req.setAttribute("error", "Maladie à modifier non trouvé");
            loadData(req,resp,"save");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        loadData(req,resp,"save");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            Maladie maladie = MaladieService.findById(id);
            if(maladie != null) {
                MaladieService.delete(maladie.getId());
            }

        }
        catch (EntityNotFoundException notFoundException) {
            req.setAttribute("error", "Maladie à supprimer non trouvé");
            loadData(req,resp,"save");
        }
        loadData(req,resp,"save");
    }


    private void loadData(HttpServletRequest req, HttpServletResponse resp, String action) throws ServletException, IOException {
        try{
            req.setAttribute("action", action);
            List<Maladie> maladies = new ArrayList<>();
            maladies = MaladieService.findAll();
            req.setAttribute("maladies", maladies);
            System.out.println("forward now");
            req.getRequestDispatcher("maladie.jsp").forward(req, resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
