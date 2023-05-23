package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServletAdministrator", value = "/HomeServletAdministrator")
public class HomeServletAdministrator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){

        }
        if(action.equals("utenti")){
            RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/administrator/userManagement.jsp");
            ds.forward(request, response);
        }
        if(action.equals("prodotti_esauriti")){
            RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/administrator/sold-outProducts.jsp");
            ds.forward(request, response);
        }
        if(action.equals("ordini")){
            RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/administrator/orders.jsp");
            ds.forward(request, response);
        }
        if(action.equals("add_product")){
            RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/administrator/addProduct.jsp");
            ds.forward(request, response);
        }

//        HttpSession session = request.getSession();
//        session.setAttribute("filters", action);
//        ProdottoDAO pDAO = new ProdottoDAO();
//        ArrayList<Prodotto> prodottiCategoria = new ArrayList<>();
//        prodottiCategoria = (ArrayList<Prodotto>) pDAO.doRetrieveByCategory(action);
//        request.setAttribute("categoria", prodottiCategoria);
//        RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/results/prodotti.jsp");
//        ds.forward(request, response);
    }

//        ProdottoDAO pDAO = new ProdottoDAO();
//        ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
//        prodotti = (ArrayList<Prodotto>) pDAO.doRetrieveAll();
//        request.setAttribute("prodotti", prodotti);
//        RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/administrator/homeAdmin.jsp");
//        ds.forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}