package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<footer class=\"footer-14398\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row mb-2\">\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <p class=\"footer-site-logo\"> Bé Mèo Shop</p>\n");
      out.write("                <p>Định giá mọi loại điện thoại</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3 ml-auto\">\n");
      out.write("                <h3>About Shop</h3>\n");
      out.write("                <ul class=\"list-unstyled links\">\n");
      out.write("                    <li><a href=\"https://www.facebook.com/\">Facebook</a></li>\n");
      out.write("                    <li><a href=\"https://www.instagram.com/\">Instagram</a></li>\n");
      out.write("                    <li><a>Phone: 1900 2001</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2 ml-auto\">\n");
      out.write("                <h3>Menu</h3>\n");
      out.write("                <ul class=\"list-unstyled links\">\n");
      out.write("                    <li><a href=\"ControllerProduct\">Home</a></li>\n");
      out.write("                    <li><a href=\"ControllerProduct?service=showCart\">Cart</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3 ml-auto\">\n");
      out.write("                <img class=\"img-thumbnail\" src=\"image/208598.gif\" style=\"width: 230px\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row mb-4\">\n");
      out.write("            <div class=\"col-12 pb-4\">\n");
      out.write("                <div class=\"line\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6 text-md-left\">\n");
      out.write("                <ul class=\"list-unstyled link-menu nav-left\">\n");
      out.write("                    <li>Made by Grimmy in 2021</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</footer>\n");
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
