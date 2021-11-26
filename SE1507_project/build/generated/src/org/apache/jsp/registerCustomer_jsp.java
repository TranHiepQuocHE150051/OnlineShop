package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html >\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Register for customer</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"form-body\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"form-holder\">\n");
      out.write("                    <div class=\"form-content\">\n");
      out.write("                        <div class=\"form-items\">\n");
      out.write("                            <h3 class=\"text-center\">Register</h3>\n");
      out.write("                            <form action=\"ControllerLogin\" method=\"POST\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <p>Your name:</p>\n");
      out.write("                                        <input type=\"text\" name=\"cname\" value=\"\" placeholder=\"Name\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <p>Phone number:</p>\n");
      out.write("                                        <input type=\"text\" name=\"cphone\" value=\"\" placeholder=\"Phone\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <p>Address:</p>\n");
      out.write("                                        <input type=\"text\" name=\"cAddress\" value=\"\" placeholder=\"Address\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <p>Username:</p>\n");
      out.write("                                        <input type=\"text\" name=\"username\" value=\"\" placeholder=\"username\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div>\n");
      out.write("                                        <p>Password: </p>\n");
      out.write("                                        <input type=\"password\" name=\"password\" value=\"\" placeholder=\"password\" required/>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alert}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                <div class=\"form-button mt-3\">\n");
      out.write("                                    <input class=\"btn btn-primary\" type=\"submit\" value=\"Register\" name=\"submit\"/> \n");
      out.write("                                    <input type=\"reset\" value=\"Reset\" class=\"btn btn-primary\"/>\n");
      out.write("                                </div>\n");
      out.write("                                <p><input type=\"hidden\" value=\"registeredCustomer\" name=\"service\"/></p>\n");
      out.write("                            </form>\n");
      out.write("                            If you had an account <a href=\"ControllerLogin\"> <button class=\"btn btn-primary\">Login</button></a>\n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                    <a href=\"ControllerProduct\">Continue Shopping</a>    \n");
      out.write("                </div>         \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
