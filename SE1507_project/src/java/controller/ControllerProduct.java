/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import entity.BillDetail;
import entity.Category;
import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOBill;
import model.DAOBillDetail;
import model.DAOCategory;
import model.DAOCustomer;
import model.DBConnect;
import model.DAOProduct;

/**
 *
 * @author Grimmy
 */
public class ControllerProduct extends HttpServlet {

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
        DAOProduct dao = new DAOProduct(dbconn);
        DAOCategory dao1 = new DAOCategory(dbconn);
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");
            HttpSession session = request.getSession();

            String pageNumber = request.getParameter("pageNumber");
            if (pageNumber == null) {
                pageNumber = "1";
            }

            if (service == null) {
                service = "displayAll";
            }

            if (service.equals("addToCart")) {
                String pid = request.getParameter("pid");
                Product pro = null;
                String sql = "Select * from Product where pid =" + pid;
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    pro = new Product(rs.getString(1), rs.getString(2),
                            rs.getInt(3), rs.getDouble(4), rs.getString(5),
                            rs.getString(6), rs.getInt(7), rs.getInt(8));
                }
                String id = pro.getPid();
                Object value = session.getAttribute(id);
                if (value == null) {
                    session.setAttribute(id, "1"); // put(key,value)
                } else {
                    int count = Integer.parseInt(value.toString()) + 1;
                    session.setAttribute(pro.getPid(), count);
                }
                service = "displayAll";
                request.setAttribute("added", "Added to Cart");
            }

            if (service.equals("displayAll")) {
                ArrayList<Category> catelist = dao1.getAllCategory();
                request.setAttribute("service", service);
                int page = Integer.parseInt(pageNumber);
                ArrayList<Product> arr = dao.paggingPro(page);
                int lastPage = dao.getPages();
                request.setAttribute("lastPage", lastPage);
                request.setAttribute("catelist", catelist);
                request.setAttribute("danhSach", arr);
                RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
                dis.forward(request, response);
            }

            if (service.equals("displayFollowCate")) {
                String cateID = request.getParameter("cateID");
                request.setAttribute("service", service);
                int page = Integer.parseInt(pageNumber);
                ArrayList<Product> arr = dao.paggingProFollowCate(page, cateID);
                int lastPage = dao.getPagesFollowCate(cateID);
                request.setAttribute("lastPage", lastPage);
                ArrayList<Category> catelist = dao1.getAllCategory();
                request.setAttribute("catelist", catelist);
                request.setAttribute("cateID", "&cateID="+cateID);
                request.setAttribute("danhSach", arr);
                RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
                dis.forward(request, response);
            }

            if (service.equals("searchProduct")) {
                request.setAttribute("service", service);
                String search = request.getParameter("search").replaceAll("\\s+", "").toLowerCase();
                int page = Integer.parseInt(pageNumber);
                ArrayList<Product> arr = dao.paggingSearch(page, search);
                int lastPage = dao.getPagesSearch(search);
                request.setAttribute("lastPage", lastPage);
                ArrayList<Category> catelist = dao1.getAllCategory();
                request.setAttribute("catelist", catelist);
                request.setAttribute("danhSach", arr);
                request.setAttribute("search", "&search="+search);
                RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
                dis.forward(request, response);
            }

            if (service.equals("removeFromCart")) {
                String pid = request.getParameter("pid");
                session.removeAttribute(pid);
                service = "showCart";
            }

            if (service.equals("removeAllFromCart")) {
                Enumeration em = session.getAttributeNames();
                //getkeys()
                //for(;em.hasMoreElements();){
                while (em.hasMoreElements()) {
                    String id = em.nextElement().toString();
                    if (!id.equals("username")) {
                        session.removeAttribute(id);
                    }
                }
                service = "showCart";
            }

            if (service.equals("updateCart")) {
                Product pro = null;
                Enumeration pidList = request.getParameterNames();
                while (pidList.hasMoreElements()) {
                    String pid = (String) pidList.nextElement();
                    String quantity = request.getParameter(pid);
                    if (!pid.equals("submit") && !pid.equals("service")) {
                        pro = dao.getProductFollowId(pid);
                        if(Integer.parseInt(quantity)<=pro.getQuantity()){
                            session.setAttribute(pid, quantity);
                        }
                        else{
                            request.setAttribute("notenoughproduct", "Not enough products in stock!!");
                        }
                    }
                }
                service = "showCart";
            }

            if (service.equals("showCart")) {
                ArrayList<Product> arr = dao.getAllProduct();
                request.setAttribute("arr", arr);
                dispatch(request, response, "/showCart.jsp");
            }

            if (service.equals("checkOut")) {
                String total = request.getParameter("total");
                String cname = request.getParameter("cname");
                String cphone = request.getParameter("cphone");
                String caddress = request.getParameter("caddress");
                request.setAttribute("total", total);
                int itemInCart = Integer.parseInt(request.getParameter("itemInCart"));
                if (itemInCart == 0) {
                    request.setAttribute("cartisempty", "Your Cart is empty!! Buy Something");
                    dispatch(request, response, "showCart.jsp");
                } else {
                    java.util.Enumeration em = session.getAttributeNames();
                    if (em.hasMoreElements()) {
                        String username = "";
                        while (em.hasMoreElements()) {
                            String key = em.nextElement().toString();
                            if (key.equals("username")) {
                                username = session.getAttribute("username").toString();
                                addBillToDataBase(username, total, cname, cphone, caddress, request, response);
                            }
                        }
                        if (username.equals("")) {
                            request.setAttribute("alert", "You need login as a customer to checkout");
                            dispatch(request, response, "/login.jsp");
                        }
                    } else {
                        request.setAttribute("alert", "You need login as a customer to checkout");
                        dispatch(request, response, "/login.jsp");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addBillToDataBase(String username, String total, String cname, String cphone,
            String caddress, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        DBConnect dbconn = new DBConnect();
        DAOCustomer daoc = new DAOCustomer(dbconn);
        DAOBill daobill = new DAOBill(dbconn);
        DAOBillDetail daobd = new DAOBillDetail(dbconn);
        DAOProduct dao = new DAOProduct(dbconn);
        HttpSession session = request.getSession();
        ArrayList<Customer> cuslist = daoc.getAllCustomer();
        Customer customer = null;
        for (Customer cus : cuslist) {
            if (cus.getUsername().equalsIgnoreCase(username)) {
                customer = cus;
            }
        }
        int max = 0;
        ArrayList<Bill> billlist = daobill.getAllBill();
        for (Bill bill : billlist) {
            if (Integer.parseInt(bill.getoID()) > max) {
                max = Integer.parseInt(bill.getoID());
            }
        }
        max = max + 1;
        double totalbill = Double.parseDouble(total);
        daobill.addBill(new Bill(Integer.toString(max), cname,
                cphone, caddress, totalbill, customer.getCid()));
        java.util.Enumeration em = session.getAttributeNames();
        ArrayList<Product> arr = dao.getAllProduct();
        session.removeAttribute(username);
        Product pro = null;
        while (em.hasMoreElements()) {
            int count = 0;
            double totalp = 0;
            String id = em.nextElement().toString();
            if (!id.equals("username")) {
                count = Integer.parseInt(session.getAttribute(id).toString());
                for (Product pro1 : arr) {
                    if (pro1.getPid().equals(id)) {
                        pro = pro1;
                    }
                }
            }
            totalp = count * pro.getPrice();
            daobd.addBillDetail(new BillDetail(pro.getPid(), String.valueOf(max),
                    count, pro.getPrice(), totalp));
        }
        Enumeration e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String id = e.nextElement().toString();
            if (!id.equals("username")) {
                session.removeAttribute(id);
            }
        }
        request.setAttribute("added", "Check out success!!");
        dispatch(request, response, "ControllerProduct?service=displayAll");
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
