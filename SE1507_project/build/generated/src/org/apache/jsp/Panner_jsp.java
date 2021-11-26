package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Panner_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("    <div class=\"container px-5\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"ControllerProduct\">HE150044-Lê Trung Thành</a>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav ms-auto mb-2 mb-lg-0\">\n");
      out.write("                ");

                    java.util.Enumeration em = session.getAttributeNames();
                    java.util.Enumeration em1 = session.getAttributeNames();
                    int count = 0;
                    while (em1.hasMoreElements()) {
                        String key1 = em1.nextElement().toString();
                        if (!key1.equals("username") && !key1.equals("admin") && !key1.equals("service")) {
                            int value = Integer.parseInt(session.getAttribute(key1).toString());
                            count = count + value;
                        }
                    }
                    if (em.hasMoreElements()) {
                        String username = "";
                        while (em.hasMoreElements()) {
                            String key = em.nextElement().toString();
                            if (key.equals("username")) {
                                username = session.getAttribute("username").toString();
      out.write("\n");
      out.write("                <li class=\"text-danger\" style=\"margin-top: 15px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${added}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                <a class=\"nav-link\" href=\"ControllerProduct?service=showCart\">\n");
      out.write("                    <button class=\"btn btn-outline-danger text-light\">\n");
      out.write("                        <i class=\"bi-cart-fill me-1\"></i>\n");
      out.write("                        Cart\n");
      out.write("                        <span class=\"badge bg-danger text-light ms-1 rounded-pill\">");
      out.print(count);
      out.write("</span>\n");
      out.write("                    </button>\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <li class=\"nav-item navbar-brand dropdown-toggle\" id=\"dropdownMenuButton1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\" style=\"margin-top: 7px\">Welcome: ");
      out.print(username.toLowerCase());
      out.write("</li>\n");
      out.write("                    <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton1\">\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"ControllerBill?service=history\">Purchase history</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"ControllerCustomer?service=updateInformation\">Update Information</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"ControllerCustomer?service=changePassword\">Change Password</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"ControllerLogin?service=logout\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                ");
          }
                    }
                    if (username.equals("")) {
      out.write("\n");
      out.write("                <li class=\"text-danger\" style=\"margin-top: 15px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${added}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                <a class=\"nav-link\" href=\"ControllerProduct?service=showCart\">\n");
      out.write("                    <button class=\"btn btn-outline-danger text-light\">\n");
      out.write("                        <i class=\"bi-cart-fill me-1\"></i>\n");
      out.write("                        Cart\n");
      out.write("                        <span class=\"badge bg-danger text-light ms-1 rounded-pill\">");
      out.print(count);
      out.write("</span>\n");
      out.write("                    </button>\n");
      out.write("                </a>\n");
      out.write("                <a class=\"nav-link\" href=\"ControllerLogin\">\n");
      out.write("                    <button class=\"btn btn-outline-danger text-light\">\n");
      out.write("                        Login\n");
      out.write("                    </button>\n");
      out.write("                </a>\n");
      out.write("                ");
      }
                } else {
      out.write("\n");
      out.write("                <li class=\"text-danger\" style=\"margin-top: 15px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${added}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                <a class=\"nav-link\" href=\"ControllerProduct?service=showCart\">\n");
      out.write("                    <button class=\"btn btn-outline-danger text-light\">\n");
      out.write("                        <i class=\"bi-cart-fill me-1\"></i>\n");
      out.write("                        Cart\n");
      out.write("                        <span class=\"badge bg-danger text-light ms-1 rounded-pill\">");
      out.print(count);
      out.write("</span>\n");
      out.write("                    </button>\n");
      out.write("                </a>\n");
      out.write("                <a class=\"nav-link\" href=\"ControllerLogin\">\n");
      out.write("                    <button class=\"btn btn-outline-danger text-light\">\n");
      out.write("                        Login\n");
      out.write("                    </button>\n");
      out.write("                </a>\n");
      out.write("                ");
  }
                
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
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
