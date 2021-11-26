/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
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
import model.DAOCustomer;
import model.DBConnect;

/**
 *
 * @author Grimmy
 */
public class ControllerCustomer extends HttpServlet {

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
        DAOCustomer dao = new DAOCustomer(dbconn);
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            if (service.equals("updateInformation")) {
                ArrayList<Customer> arr = dao.getAllCustomer();
                Customer customer = null;
                String username = session.getAttribute("username").toString();
                for (Customer cus : arr) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        customer = cus;
                    }
                }
                request.setAttribute("cus", customer);
                dispatch(request, response, "/updateInformation.jsp");
            }

            if (service.equals("updated")) {
                ArrayList<Customer> arr = dao.getAllCustomer();
                String pass = null;
                Customer customer = null;
                String username = username = session.getAttribute("username").toString();
                int cid = 0;
                for (Customer cus : arr) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        pass = cus.getPassword();
                        cid = cus.getCid();
                        customer = cus;
                    }
                }
                String name = request.getParameter("cname");
                String phone = request.getParameter("cphone");
                String address = request.getParameter("cAddress");
                String password = request.getParameter("password");
                if (password.equals(pass)) {
                    dao.updateInformation(name, phone, address, cid);
                    request.setAttribute("added", "Information updated!");
                    dispatch(request, response, "/ControllerProduct?service=displayAll");
                } else {
                    request.setAttribute("alert", "Password incorrect");
                    request.setAttribute("cus", customer);
                    dispatch(request, response, "/updateInformation.jsp");
                }
            }

            if (service.equals("changedPassword")) {
                ArrayList<Customer> arr = dao.getAllCustomer();
                String username = session.getAttribute("username").toString();
                String oldpass = request.getParameter("oldpassword");
                String newpass = request.getParameter("newpassword");
                String renewpass = request.getParameter("renewpassword");
                String pass = "";
                int cid = 0;
                for (Customer cus : arr) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        pass = cus.getPassword();
                        cid = cus.getCid();
                    }
                }
                if (!oldpass.equals(pass)) {
                    request.setAttribute("alert", "Your old password isn't correct!");
                    service = "changePassword";
                } else {
                    if (newpass.length() < 8) {
                        request.setAttribute("alert", "Your new password is too short");
                        service = "changePassword";
                    } else {
                        if (!newpass.equals(renewpass)) {
                            request.setAttribute("alert", "Your confirm password doesn't match");
                            service = "changePassword";
                        } else {
                            dao.updatePassword(newpass, cid);
                            request.setAttribute("added", "Password changed!");
                            dispatch(request, response, "/ControllerProduct?service=displayAll");
                        }
                    }
                }
            }
            if (service.equals("changePassword")) {
                ArrayList<Customer> arr = dao.getAllCustomer();
                Customer customer = null;
                String username = session.getAttribute("username").toString();
                for (Customer cus : arr) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        customer = cus;
                    }
                }
                request.setAttribute("cus", customer);
                dispatch(request, response, "/changePassword.jsp");
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
