/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Admin;
import entity.Category;
import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOAdmin;
import model.DAOCategory;
import model.DAOCustomer;
import model.DAOProduct;
import model.DBConnect;

/**
 *
 * @author Grimmy
 */
public class ControllerLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DBConnect dbconn = new DBConnect();
        DAOAdmin dao = new DAOAdmin(dbconn);
        DAOCustomer dao1 = new DAOCustomer(dbconn);
        DAOProduct daoProduct = new DAOProduct(dbconn);
        DAOCategory daoCate = new DAOCategory(dbconn);
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            HttpSession session = request.getSession();
            if (service == null) {
                dispatch(request, response, "/login.jsp");
            }

            if (service.equals("login")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                ArrayList<Customer> arr1 = dao1.getAllCustomer();
                ArrayList<Admin> arr = dao.getAllAdmin();
                for (Customer cus : arr1) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        if (cus.getPassword().equals(password)) {
                            session.setAttribute("username", username);
                            ArrayList<Product> prolist = daoProduct.paggingPro(1);
                            ArrayList<Category> catelist = daoCate.getAllCategory();
                            request.setAttribute("catelist", catelist);
                            request.setAttribute("danhSach", prolist);
                            request.setAttribute("service", "displayAll");
                            int lastPage = daoProduct.getPages();
                            request.setAttribute("lastPage", lastPage);
                            dispatch(request, response, "/index.jsp");
                        } else {
                            request.setAttribute("alert", "Wrong Password!");
                            dispatch(request, response, "/login.jsp");
                        }
                    }
                }
                for (Admin ad : arr) {
                    if (ad.getUsername().equalsIgnoreCase(username)) {
                        if (ad.getPassword().equals(password)) {
                            session.setAttribute("admin", username);
                            session.setAttribute("service", "hello");
                            dispatch(request, response, "/adminIndex.jsp");
                        } else {
                            request.setAttribute("alert", "Wrong Password!");
                            dispatch(request, response, "/login.jsp");
                        }
                    }
                }
                request.setAttribute("alert", "Your username doesn't exist!");
                dispatch(request, response, "/login.jsp");

            }

            if (service.equals("Register")) {
                dispatch(request, response, "/registerCustomer.jsp");
            }

            if (service.equals("logout")) {
                session.invalidate();
                response.sendRedirect("ControllerProduct");
            }

            if (service.equals("registeredCustomer")) {
                String name = request.getParameter("cname");
                String phone = request.getParameter("cphone");
                String address = request.getParameter("cAddress");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                ArrayList<Customer> arr1 = dao1.getAllCustomer();
                ArrayList<Admin> arr = dao.getAllAdmin();
                int count = 0;
                for (Customer cus : arr1) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        count++;
                        request.setAttribute("alert", "username is existed!");
                        dispatch(request, response, "/registerCustomer.jsp");
                    }
                }
                for (Admin ad : arr) {
                    if (ad.getUsername().equalsIgnoreCase(username)) {
                        count++;
                        request.setAttribute("alert", "username is existed!");
                        dispatch(request, response, "/registerCustomer.jsp");
                    }
                }
                if (password.length() < 8) {
                    count++;
                    request.setAttribute("alert", "password is too short!");
                    dispatch(request, response, "/registerCustomer.jsp");
                }
                if (count == 0) {
                    Customer cus = new Customer(name, phone, address, username, password, 1);
                    dao1.addCustomer(cus);
                    request.setAttribute("alert", "Register Success!!!");
                    dispatch(request, response, "/login.jsp");
                }
            }
        }

    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String URL) {
        RequestDispatcher dis = request.getRequestDispatcher(URL);
        try {
            dis.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControllerCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
