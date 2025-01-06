package mg.itu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.itu.entity.Laboratoire;
import mg.itu.exception.EntityNotFoundException;
import mg.itu.service.LaboratoireService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/laboratoire")
public class LaboratoireServlet extends HttpServlet {

    // liste et management
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            loadData(req,resp,"save");
        }
        // Initier un update
        if(action.compareToIgnoreCase("toUpdate") == 0){
            Integer id = Integer.parseInt(req.getParameter("id"));
            Laboratoire laboratoire = null;
            try{
                laboratoire = LaboratoireService.findById(id);
            }
            catch(EntityNotFoundException e){
                req.setAttribute("error", e.getMessage());
            }
            catch(Exception e){
                e.printStackTrace();
            }
            req.setAttribute("modifLab", laboratoire);
            loadData(req,resp,"update");
        }
        if(action.compareToIgnoreCase("delete") == 0){
            doDelete(req, resp);
        }
    }

    // insertion et management put
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            loadData(req,resp,"save");
        }
        if(action.compareToIgnoreCase("save") == 0){
            String label = req.getParameter("label");
            Laboratoire laboratoire = new Laboratoire();
            laboratoire.setLabel(label);
            LaboratoireService.create(laboratoire);
            loadData(req,resp,"save");
        }
        if(action.compareToIgnoreCase("update") == 0){
            doPut(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try{
            Laboratoire laboratoire = LaboratoireService.findById(id);
            String label = req.getParameter("label");
            laboratoire.setLabel(label);
            LaboratoireService.update(laboratoire);
        }
        catch (EntityNotFoundException e) {
            req.setAttribute("error", e.getMessage());
        }
        loadData(req,resp,"save");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try{
            LaboratoireService.delete(id);
        }
        catch (EntityNotFoundException e){
            String error = e.getMessage();
            req.setAttribute("error", error);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        loadData(req,resp,"save");
    }


    private void loadData(HttpServletRequest req, HttpServletResponse resp,String action)throws ServletException, IOException {
        req.setAttribute("action", action);
        List<Laboratoire> laboratoires = LaboratoireService.findAll();
        req.setAttribute("laboratoires", laboratoires);
        req.getRequestDispatcher("laboratoire.jsp").forward(req, resp);
    }
}
