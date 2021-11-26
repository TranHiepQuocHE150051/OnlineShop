package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Product;
import entity.Category;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Index</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Panner.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"bg-light\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("            ");

                ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
                ArrayList<Product> arr = (ArrayList<Product>) request.getAttribute("danhSach");
                String lastPage = request.getAttribute("lastPage").toString();
                String service = request.getAttribute("service").toString();
            
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "category.jsp", out, false);
      out.write("\n");
      out.write("                    <div class=\"col-md-9\" style=\"border-left: 2px solid #212529\" id=\"product\">\n");
      out.write("                        <h1 class=\"text-center text-dark pt-3\">Product</h1>\n");
      out.write("                        <hr>\n");
      out.write("                        <div class=\"border-10 container px-4 px-lg-5 mt-5\">\n");
      out.write("                            <div class=\"row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center\">\n");
      out.write("                            ");
for (Product pro : arr) {
      out.write("\n");
      out.write("                            <div class=\"col mb-5\">\n");
      out.write("                                <div class=\"card h-100\">\n");
      out.write("                                    <!-- Product image-->\n");
      out.write("                                    <img class=\"card-img-top\" src=\"image/");
      out.print(pro.getImage());
      out.write("\"/>\n");
      out.write("                                    <hr>\n");
      out.write("                                    <!-- Product details-->\n");
      out.write("                                    <div class=\"card-body p-4\">\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("                                            <!-- Product name-->\n");
      out.write("                                            <h5 class=\"fw-bolder\">");
      out.print(pro.getPname());
      out.write("</h5>\n");
      out.write("                                            <h6>(In stock: ");
      out.print(pro.getQuantity());
      out.write(")</h6>\n");
      out.write("                                            <!-- Product price-->\n");
      out.write("                                            Price: $");
      out.print(pro.getPrice());
      out.write("                                            \n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Product actions-->\n");
      out.write("                                    <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("                                            ");
if (pro.getQuantity() > 0) {
      out.write("\n");
      out.write("                                            <a class=\"btn btn-outline-dark mt-auto\" href=ControllerProduct?service=addToCart&pid=");
      out.print(pro.getPid());
      out.write(">\n");
      out.write("                                                <i class=\"bi-cart-fill me-1\"></i>\n");
      out.write("                                                Add to cart\n");
      out.write("                                            </a>\n");
      out.write("                                            ");
} else {
      out.write("\n");
      out.write("                                            <button disabled class=\"btn btn-outline-dark text-dark\">\n");
      out.write("                                                <i class=\"bi-cart-fill me-1\"></i>\n");
      out.write("                                                Out of stock\n");
      out.write("                                            </button>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div style=\"text-align: center; background: grey;\">\n");
      out.write("                            Pages: \n");
      out.write("                            ");
for (int i = 1; i <= Integer.parseInt(lastPage); i++) {
      out.write("\n");
      out.write("                            <a href=\"ControllerProduct?service=");
      out.print(service);
      out.write("&pageNumber=");
      out.print(i);
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cateID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${search}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                <button class=\"btn btn-danger text-light\">\n");
      out.write("                                    ");
      out.print(i);
      out.write("\n");
      out.write("                                </button>\n");
      out.write("                            </a>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
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
