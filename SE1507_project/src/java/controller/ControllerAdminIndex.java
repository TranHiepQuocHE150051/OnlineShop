/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Admin;
import entity.Bill;
import entity.Category;
import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import model.DAOBill;
import model.DAOBillDetail;
import model.DAOCategory;
import model.DAOCustomer;
import model.DAOProduct;
import model.DBConnect;

/**
 *
 * @author Grimmy
 */
public class ControllerAdminIndex extends HttpServlet {

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
        Connection conn = null;
        DBConnect dbconn = new DBConnect();
        DAOCustomer daoCus = new DAOCustomer(dbconn);
        DAOBill daoBill = new DAOBill(dbconn);
        DAOBillDetail daoBD = new DAOBillDetail(dbconn);
        DAOProduct daoPro = new DAOProduct(dbconn);
        DAOCategory daoCate = new DAOCategory(dbconn);
        DAOAdmin daoAd = new DAOAdmin(dbconn);
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "hello";
            }
            if (service.equals("hello")) {
                session.setAttribute("service", "hello");
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("customer")) {
                session.setAttribute("service", "customer");
                ArrayList<Customer> arr = daoCus.getAllCustomer();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("deleteCustomer")) {
                String cid = request.getParameter("cid");
                daoCus.deleteCustomer(cid);
                session.setAttribute("service", "customer");
                ArrayList<Customer> arr = daoCus.getAllCustomer();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("updatedCustomer")) {
                int count = 0;
                String cusID = request.getParameter("cid");
                String name = request.getParameter("cname");
                String phone = request.getParameter("cphone");
                String adress = request.getParameter("cAddress");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String status = request.getParameter("status");
                int cid = Integer.parseInt(cusID);
                int sta = Integer.parseInt(status);
                ArrayList<Customer> arr1 = daoCus.getAllCustomer();
                ArrayList<Admin> arr2 = daoAd.getAllAdmin();
                if (password.length() < 8) {
                    count++;
                    request.setAttribute("alert", "password is too short!");
                    service = "updateCustomer";
                }
                if (count == 0) {
                    Customer cus = new Customer(cid, name, phone, adress, username, password, sta);
                    daoCus.updateCustomer(cus);
                    session.setAttribute("service", "customer");
                    ArrayList<Customer> arr = daoCus.getAllCustomer();
                    request.setAttribute("danhSach", arr);
                    dispatch(request, response, "/adminIndex.jsp");
                }
            }

            if (service.equals("updateCustomer")) {
                session.setAttribute("service", "customer");
                int id = Integer.parseInt(request.getParameter("cid"));
                String sql = "select * from Customer where cid=" + id;
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    request.setAttribute("cus", cus);
                    dispatch(request, response, "/updateCustomer.jsp");
                }
            }
            if (service.equals("addCustomer")) {
                int count = 0;
                String name = request.getParameter("cname");
                String phone = request.getParameter("cphone");
                String adress = request.getParameter("cAddress");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                ArrayList<Customer> arr1 = daoCus.getAllCustomer();
                ArrayList<Admin> arr2 = daoAd.getAllAdmin();
                for (Customer cus : arr1) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        count++;
                        request.setAttribute("alert", "username is existed!");
                        dispatch(request, response, "/addCustomer.jsp");
                    }
                }
                for (Admin ad : arr2) {
                    if (ad.getUsername().equalsIgnoreCase(username)) {
                        count++;
                        request.setAttribute("alert", "username is existed!");
                        dispatch(request, response, "/addCustomer.jsp");
                    }
                }
                if (password.length() < 8) {
                    count++;
                    request.setAttribute("alert", "password is too short!");
                    dispatch(request, response, "/addCustomer.jsp");
                }
                if (count == 0) {
                    Customer cus = new Customer(name, phone, adress, username, password, 1);
                    daoCus.addCustomer(cus);
                    session.setAttribute("service", "customer");
                    ArrayList<Customer> arr = daoCus.getAllCustomer();
                    request.setAttribute("danhSach", arr);
                    dispatch(request, response, "/adminIndex.jsp");
                }
            }
//            ---------------------------------------------------------
            if (service.equals("product")) {
                session.setAttribute("service", "product");
                ArrayList<Product> arr = daoPro.getAllProduct();
                ArrayList<Category> catelist = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                request.setAttribute("catelist", catelist);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("deleteProduct")) {
                String pid = request.getParameter("pid");
                daoPro.deleteProduct(pid);
                session.setAttribute("service", "product");
                ArrayList<Product> arr = daoPro.getAllProduct();
                ArrayList<Category> catelist = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                request.setAttribute("catelist", catelist);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("updatedProduct")) {
                ArrayList<Product> prolist = daoPro.getAllProduct();
                String pid = request.getParameter("pid");
                String pname = request.getParameter("pname");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                String image = request.getParameter("image");
                String description = request.getParameter("description");
                int status = Integer.parseInt(request.getParameter("status"));
                int cateID = Integer.parseInt(request.getParameter("Cate"));
                if (image.equals("")) {
                    for (Product product : prolist) {
                        if (product.getPid().equals(pid)) {
                            image = product.getImage();
                        }
                    }
                }
                Product pro = new Product(pid, pname, quantity, price, image, description, status, cateID);
                daoPro.updateProduct(pro);
                session.setAttribute("service", "product");
                ArrayList<Product> arr = daoPro.getAllProduct();
                ArrayList<Category> catelist = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                request.setAttribute("catelist", catelist);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("updateProduct")) {
                ArrayList<Category> catelist1 = daoCate.getAllCategory();
                request.setAttribute("catelist", catelist1);
                int id = Integer.parseInt(request.getParameter("pid"));
                String sql = "select * from Product where pid=" + id;
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    Product pro = new Product(rs.getString(1), rs.getString(2), rs.getInt(3),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                    request.setAttribute("pro", pro);
                    dispatch(request, response, "/updateProduct.jsp");
                }
            }
            if (service.equals("preAddProduct")) {
                ArrayList<Category> catelist = daoCate.getAllCategory();
                request.setAttribute("catelist", catelist);
                dispatch(request, response, "/addProduct.jsp");
            }
            if (service.equals("addProduct")) {
                int count = 0;
                ArrayList<Product> prolist = daoPro.getAllProduct();
                for (Product product : prolist) {
                    if (count <= Integer.parseInt(product.getPid())) {
                        count = Integer.parseInt(product.getPid());
                    }
                }
                count++;
                String pid = "" + count;
                String pname = request.getParameter("pname");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                String image = request.getParameter("image");
                String description = request.getParameter("description");
                int cateID = Integer.parseInt(request.getParameter("Cate"));
                String sql = "Select * from Product where pid =" + pid;
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    request.setAttribute("alert", "product is existed!");
                    dispatch(request, response, "/addProduct.jsp");
                }
                Product pro = new Product(pid, pname, quantity, price, image, description, 1, cateID);
                daoPro.addProduct(pro);
                session.setAttribute("service", "product");
                ArrayList<Product> arr = daoPro.getAllProduct();
                ArrayList<Category> catelist = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                request.setAttribute("catelist", catelist);
                dispatch(request, response, "/adminIndex.jsp");
            }
//            ----------------------------------------------------
            if (service.equals("bill")) {
                session.setAttribute("service", "bill");
                ArrayList<Bill> arr = daoBill.getAllBill();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("updatedBill")) {
                String status = request.getParameter("status");
                String oid = request.getParameter("oid");
                String preSql = "update Bill set status = ? where oID = ?";
                daoBill.updateBill(status, oid);
                session.setAttribute("service", "bill");
                ArrayList<Bill> arr = daoBill.getAllBill();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("deleteBill")) {
                String oid = request.getParameter("oid");
                daoBD.deleteBillDetail(Integer.parseInt(oid));
                daoBill.deleteBill(Integer.parseInt(oid));
                session.setAttribute("service", "bill");
                ArrayList<Bill> arr = daoBill.getAllBill();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
//            ---------------------------------------------------------
            if (service.equals("category")) {
                session.setAttribute("service", "category");
                ArrayList<Category> arr = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("deleteCategory")) {
                String id = request.getParameter("id");
                daoCate.deleteCategory(Integer.parseInt(id));
                session.setAttribute("service", "category");
                ArrayList<Category> arr = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("updateCategory")) {
                session.setAttribute("service", "category");
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "select * from Category where cateID=" + id;
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    Category cate = new Category(rs.getInt(1), rs.getString(2), rs.getInt(3));
                    request.setAttribute("cate", cate);
                    dispatch(request, response, "/updateCategory.jsp");
                }
            }
            if (service.equals("updatedCategory")) {
                String cate = request.getParameter("cateName");
                int status = Integer.parseInt(request.getParameter("status"));
                int cateID = Integer.parseInt(request.getParameter("cateID"));
                Category cat = new Category(cateID, cate, status);
                daoCate.updateCategory(cat);
                session.setAttribute("service", "category");
                ArrayList<Category> arr = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("addCategory")) {
                int count = 0;
                String cate = request.getParameter("cateName");
                String sql = "Select * from category where cateName ='" + cate + "'";
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    count++;
                    request.setAttribute("alert", "category is existed!");
                    dispatch(request, response, "/addCategory.jsp");

                }
                Category cat = new Category(cate, 1);
                daoCate.addCategory(cat);
                session.setAttribute("service", "category");
                ArrayList<Category> arr = daoCate.getAllCategory();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
//            ---------------------------------------------------------
            if (service.equals("admin")) {
                session.setAttribute("service", "admin");
                ArrayList<Admin> arr = daoAd.getAllAdmin();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }
            if (service.equals("deleteAdmin")) {
                String adminID = request.getParameter("id");
                daoAd.deleteAdmin(Integer.parseInt(adminID));
                session.setAttribute("service", "admin");
                ArrayList<Admin> arr = daoAd.getAllAdmin();
                request.setAttribute("danhSach", arr);
                dispatch(request, response, "/adminIndex.jsp");
            }

            if (service.equals("updatedAdmin")) {
                int count = 0;
                int adminID = Integer.parseInt(request.getParameter("adminID"));
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (password.length() < 8) {
                    count++;
                    request.setAttribute("alert", "password is too short!");
                    service = "updateAdmin";
                }
                if (count == 0) {
                    Admin ad = new Admin(adminID, username, password);
                    int n = daoAd.updateAdmin(ad);
                    session.setAttribute("service", "admin");
                    ArrayList<Admin> arr = daoAd.getAllAdmin();
                    request.setAttribute("danhSach", arr);
                    dispatch(request, response, "/adminIndex.jsp");
                }
            }
            if (service.equals("updateAdmin")) {
                session.setAttribute("service", "admin");
                int id = Integer.parseInt(request.getParameter("adminID"));
                String sql = "select * from Admin where adminID=" + id;
                ResultSet rs = dbconn.getData(sql);
                if (rs.next()) {
                    Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
                    request.setAttribute("admin", admin);
                    dispatch(request, response, "/updateAdmin.jsp");
                }
            }

            if (service.equals("addAdmin")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                ArrayList<Customer> arr1 = daoCus.getAllCustomer();
                ArrayList<Admin> arr2 = daoAd.getAllAdmin();
                int count = 0;
                for (Customer cus : arr1) {
                    if (cus.getUsername().equalsIgnoreCase(username)) {
                        count++;
                        request.setAttribute("alert", "username is existed!");
                        dispatch(request, response, "/addAdmin.jsp");
                    }
                }
                for (Admin ad : arr2) {
                    if (ad.getUsername().equalsIgnoreCase(username)) {
                        count++;
                        request.setAttribute("alert", "username is existed!");
                        dispatch(request, response, "/addAdmin.jsp");
                    }
                }
                if (password.length() < 8) {
                    count++;
                    request.setAttribute("alert", "password is too short!");
                    dispatch(request, response, "/addAdmin.jsp");
                }
                if (count == 0) {
                    Admin ad = new Admin(username, password);
                    daoAd.addAdmin(ad);
                    session.setAttribute("service", "admin");
                    ArrayList<Admin> arr = daoAd.getAllAdmin();
                    request.setAttribute("danhSach", arr);
                    dispatch(request, response, "/adminIndex.jsp");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdminIndex.class.getName()).log(Level.SEVERE, null, ex);
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
