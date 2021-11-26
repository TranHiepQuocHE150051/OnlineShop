package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import entity.Category;
import entity.Product;

public final class updateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css\" integrity=\"sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/styles_1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/footer.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/loginform.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Update Product</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Product pro = (Product) request.getAttribute("pro");
            ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminPanner.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminMenu.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"col-md-9\">\n");
      out.write("                    <form action=\"ControllerAdminIndex\" method=\"POST\">\n");
      out.write("                        <table class=\"table-condensed table-striped table\">\n");
      out.write("                            <caption><h1>Update Product</h1></caption>\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Product ID</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"pid\" value=\"");
      out.print(pro.getPid());
      out.write("\" readonly /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Product Name</td>\n");
      out.write("                                <td><input type=\"text\" name=\"pname\" value=\"");
      out.print(pro.getPname());
      out.write("\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Quantity</td>\n");
      out.write("                                <td><input type=\"text\" name=\"quantity\" value=\"");
      out.print(pro.getQuantity());
      out.write("\"  pattern=\"[0-9]{1,9}\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Price</td>\n");
      out.write("                                <td><input type=\"text\" name=\"price\" value=\"");
      out.print(pro.getPrice());
      out.write("\" pattern=\"[0-9]+(\\.[0-9]{1,2})?%?\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Image</td>\n");
      out.write("                                <td><input type=\"file\" name=\"image\" value=\"");
      out.print(pro.getImage());
      out.write("\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Description</td>\n");
      out.write("                                <td><input type=\"text\" name=\"description\" value=\"");
      out.print(pro.getDescription());
      out.write("\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Status</td>\n");
      out.write("                                <td><input type=\"radio\" name=\"status\" value=\"1\" ");
      out.print((pro.getStatus() == 1 ? "checked" : ""));
      out.write("/>Enable\n");
      out.write("                                    <input type=\"radio\" name=\"status\" value=\"0\" ");
      out.print((pro.getStatus() == 0 ? "checked" : ""));
      out.write("/>Disable</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Category</td>\n");
      out.write("                                <td><select name=\"Cate\">\n");
      out.write("                                        ");
for (Category cate : cl) {
                                        if (pro.getCateID() == cate.getCateID()) {
      out.write(" \n");
      out.write("                                        <option value=\"");
      out.print(cate.getCateID());
      out.write("\"  selected> ");
      out.print(cate.getCateName());
      out.write(" </option>\n");
      out.write("                                        ");
} else {
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(cate.getCateID());
      out.write("\"> ");
      out.print(cate.getCateName());
      out.write(" </option>\n");
      out.write("                                        ");
}
                                    }
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alert}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>                \n");
      out.write("                    <p><input type=\"submit\" value=\"Update\" name=\"submit\"/>  \n");
      out.write("                        <input type=\"reset\" value=\"Reset\"/></p>\n");
      out.write("                    <input type=\"hidden\" value=\"updatedProduct\" name=\"service\"/>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footerAdmin.jsp", out, false);
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
