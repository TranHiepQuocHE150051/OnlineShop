package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Admin;
import entity.Bill;
import entity.Category;
import entity.Product;
import entity.Customer;
import java.util.ArrayList;

public final class adminIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <title>Admin Index</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Object admin = session.getAttribute("admin");
            if (!(admin == null)) {
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminPanner.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminMenu.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"col-md-9\">\n");
      out.write("                ");

                    String service = session.getAttribute("service").toString();
                    if (service.equals("hello")) {
      out.write("\n");
      out.write("                <h3>Hello admin</h3>     \n");
      out.write("                ");
  }
      out.write("\n");
      out.write("                ");

                    if (service.equals("customer")) {
                        ArrayList<Customer> arr = (ArrayList<Customer>) request.getAttribute("danhSach");
                
      out.write("\n");
      out.write("                <table class=\"table table-hover\" border=\"1\">\n");
      out.write("                    <caption><h1>Customer List</h1></caption>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Customer ID</th>\n");
      out.write("                            <th>Customer Name</th>\n");
      out.write("                            <th>Customer Phone</th>\n");
      out.write("                            <th>Customer Address</th>\n");
      out.write("                            <th>Username</th>\n");
      out.write("                            <th>Password</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                            <th>Update</th>\n");
      out.write("                            <th>Delete</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
for (Customer cus : arr) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(cus.getCid());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cus.getCname());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cus.getCphone());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cus.getcAddress());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cus.getUsername());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cus.getPassword());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print((cus.getStatus() == 1) ? "Enable" : "Disable");
      out.write("</td>\n");
      out.write("                            <td><a onclick =\"return confirm('Are you sure?')\" href=\"ControllerAdminIndex?service=deleteCustomer&cid=");
      out.print(cus.getCid());
      out.write("\">delete</a></td>\n");
      out.write("                            <td><a href=\"ControllerAdminIndex?service=updateCustomer&cid=");
      out.print(cus.getCid());
      out.write("\">update</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <input type=\"submit\" onclick=window.location.href=\"addCustomer.jsp\" value=\"Add new Customer\" />\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("                ");

                    if (service.equals("product")) {
                        ArrayList<Product> arr = (ArrayList<Product>) request.getAttribute("danhSach");
                        ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
                
      out.write("\n");
      out.write("                <table class=\"table table-hover\" border=\"1\">\n");
      out.write("                    <caption><h1>Product List</h1></caption>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Product ID</th>\n");
      out.write("                            <th>Product Name</th>\n");
      out.write("                            <th>Quantity</th>\n");
      out.write("                            <th>Price</th>\n");
      out.write("                            <th>Image</th>\n");
      out.write("                            <th>Description</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                            <th>Category</th>\n");
      out.write("                            <th>Delete</th>\n");
      out.write("                            <th>Update</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
for (Product pro : arr) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(pro.getPid());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pro.getPname());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pro.getQuantity());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(pro.getPrice());
      out.write("</td>\n");
      out.write("                            <td><img src=\"image/");
      out.print(pro.getImage());
      out.write("\" width=\"40\" height=\"40\"/></td>\n");
      out.write("                            <td>");
      out.print(pro.getDescription());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print((pro.getStatus() == 1) ? "Enable" : "Disable");
      out.write("</td>\n");
      out.write("                            ");
for (Category cate : cl) {
                                    if (cate.getCateID() == pro.getCateID()) {
                            
      out.write("\n");
      out.write("                            <td>");
      out.print(cate.getCateName());
      out.write("</td>\n");
      out.write("                            ");
      }
                                }
      out.write("\n");
      out.write("                            <td><a onclick =\"return confirm('Are you sure?')\" href=\"ControllerAdminIndex?service=deleteProduct&pid=");
      out.print(pro.getPid());
      out.write("\">delete</a></td>\n");
      out.write("                            <td><a href=\"ControllerAdminIndex?service=updateProduct&pid=");
      out.print(pro.getPid());
      out.write("\">update</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <input type=\"submit\" onclick=window.location.href=\"ControllerProduct?service=preAdd\" value=\"Add new Product\" />\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("                ");

                    if (service.equals("bill")) {
                        ArrayList<Bill> arr = (ArrayList<Bill>) request.getAttribute("danhSach");
                
      out.write("\n");
      out.write("                <table class=\"table table-hover\" border=\"1\">\n");
      out.write("                    <caption><h1>Bill List</h1></caption>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Order ID</th>\n");
      out.write("                            <th>Date Create</th>\n");
      out.write("                            <th>Customer Name</th>\n");
      out.write("                            <th>Customer Phone</th>\n");
      out.write("                            <th>Customer Address</th>\n");
      out.write("                            <th>Total</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                            <th>Customer ID</th>\n");
      out.write("                            <th>Bill Detail</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
for (Bill bill : arr) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(bill.getoID());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(bill.getDateCreate());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(bill.getCname());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(bill.getCphone());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(bill.getcAddress());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(bill.getTotal());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print((bill.getStatus() == 1) ? "Wait" : "Done");
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(bill.getCid());
      out.write("</td>\n");
      out.write("                            <td><a href=\"ControllerBill?service=detail&oid=");
      out.print(bill.getoID());
      out.write("\">View</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("                ");

                    if (service.equals("category")) {
                        ArrayList<Category> arr = (ArrayList<Category>) request.getAttribute("danhSach");
                
      out.write("\n");
      out.write("                <table class=\"table table-hover\" border=\"1\">\n");
      out.write("                    <caption><h1>Category List</h1></caption>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Category ID</th>\n");
      out.write("                            <th>Category Name</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                            <th>Delete</th>\n");
      out.write("                            <th>Update</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
for (Category cate : arr) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(cate.getCateID());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cate.getCateName());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print((cate.getStatus()) == 1 ? "Enable" : "Disable");
      out.write("</td>\n");
      out.write("                            <td><a onclick =\"return confirm('Are you sure?')\" href=\"ControllerAdminIndex?service=deleteCategory&id=");
      out.print(cate.getCateID());
      out.write("\">delete</a></td>\n");
      out.write("                            <td><a href=\"ControllerAdminIndex?service=updateCategory&id=");
      out.print(cate.getCateID());
      out.write("\">update</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <input type=\"submit\" onclick=window.location.href=\"addCategory.jsp\" value=\"Add new Category\" />\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("                ");

                    if (service.equals("admin")) {
                        ArrayList<Admin> arr = (ArrayList<Admin>) request.getAttribute("danhSach");
                
      out.write("\n");
      out.write("                <table class=\"table table-hover\" border=\"1\">\n");
      out.write("                    <caption><h1>Admin List</h1></caption>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Admin ID</th>\n");
      out.write("                            <th>Username</th>\n");
      out.write("                            <th>Delete</th>\n");
      out.write("                            <th>Update</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
for (Admin ad : arr) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(ad.getAdminID());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(ad.getUsername());
      out.write("</td>\n");
      out.write("                            <td><a onclick =\"return confirm('Are you sure?')\" href=\"ControllerAdminIndex?service=deleteAdmin&id=");
      out.print(ad.getAdminID());
      out.write("\">delete</a></td>\n");
      out.write("                            <td><a href=\"ControllerAdminIndex?service=updateAdmin&id=");
      out.print(ad.getAdminID());
      out.write("\">update</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <input type=\"submit\" onclick=window.location.href=\"addAdmin.jsp\" value=\"Add new Admin\" />\n");
      out.write("                ");
  }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
  } else {
      out.write("\n");
      out.write("        <h1 class=\"text-danger\">Access Denied!!! You are not Admin!!!</h1>\n");
      out.write("        ");
  }
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
