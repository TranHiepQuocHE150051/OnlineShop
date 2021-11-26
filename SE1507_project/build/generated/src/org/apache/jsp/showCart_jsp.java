package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import entity.Product;

public final class showCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css\" integrity=\"sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/styles_1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/footer.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/loginform.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Panner.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"container pt-5 pb-3\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <form action=\"ControllerProduct\" method=\"POST\">\n");
      out.write("                            <h1 class=\"text-danger\" style=\"text-align:center; margin: 15px\">Shopping Cart</h1>\n");
      out.write("                            <table style=\"text-align:center;\" border=\"3\" class=\"table table-hover\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td style=\"font-weight: bold\">Image</td>\n");
      out.write("                                    <td style=\"font-weight: bold\">Product Name</td>\n");
      out.write("                                    <td style=\"font-weight: bold\">Quantity in Cart</td>\n");
      out.write("                                    <td style=\"font-weight: bold\">In Stock</td>\n");
      out.write("                                    <td style=\"font-weight: bold\">Price</td>\n");
      out.write("                                    <td style=\"font-weight: bold\">Total</td>\n");
      out.write("                                    <td style=\"font-weight: bold\">Remove</td>\n");
      out.write("                                </tr>\n");
      out.write("                            ");

                                ArrayList<Product> arr = (ArrayList<Product>) request.getAttribute("arr");
                                java.util.Enumeration em = session.getAttributeNames();
                                //getkeys()
                                //for(;em.hasMoreElements();){
                                int itemInCart = 0;
                                double totalCart = 0;
                                while (em.hasMoreElements()) {
                                    Product pro = null;
                                    String count = "";
                                    String id = em.nextElement().toString(); //get key
                                    if (!id.equals("username")) {
                                        //Product pro=(Product)em.nextElement();
                                        //get value from session object (see HttpSession)
                                        count = session.getAttribute(id).toString(); //get value
                                        for (Product pro1 : arr) {
                                            if (pro1.getPid().equals(id)) {
                                                pro = pro1;
                                            }
                                        }
                                        double total = Integer.parseInt(count) * pro.getPrice();
                                        totalCart += total;
                                        itemInCart += Integer.parseInt(count);
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><img src=\"image/");
      out.print(pro.getImage());
      out.write("\" width=\"40\" height=\"40\"/></td>\n");
      out.write("                                <td  class=\"text-danger\">");
      out.print(pro.getPname());
      out.write("</td>\n");
      out.write("                                <td><input type=\"text\" name=\"");
      out.print(pro.getPid());
      out.write("\" value=\"");
      out.print(count);
      out.write("\" onchange=\"ControllerProduct?service = updateCart & pid =");
      out.print(pro.getPid());
      out.write("\"/> </td>\n");
      out.write("                                <td>");
      out.print(pro.getQuantity());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(pro.getPrice());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(Integer.parseInt(count) * pro.getPrice());
      out.write("</td>\n");
      out.write("                                <td><a onclick =\"return confirm('Are you sure?')\" href=\"ControllerProduct?service=removeFromCart&pid=");
      out.print(pro.getPid());
      out.write("\">Remove</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
      }
                                }
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td class=\"text-danger\" style=\"font-weight: bold\">Product In Cart:</td>\n");
      out.write("                                <td class=\"text-danger\" style=\"font-weight: bold\">");
      out.print(itemInCart);
      out.write("</td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td class=\"text-danger\" style=\"font-weight: bold\">Total Price All Cart:</td>\n");
      out.write("                                <td class=\"text-danger\" style=\"font-weight: bold\">");
      out.print(totalCart);
      out.write("</td>\n");
      out.write("                                <td><a onclick =\"return confirm('Are you sure?')\" href=\"ControllerProduct?service=removeAllFromCart\">remove all</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${notenoughproduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                        <button id=\"submit\" type=\"submit\" value=\"Update\" name=\"submit\" class=\"btn btn-primary\">Update Cart</button>\n");
      out.write("                        <input type=\"hidden\" value=\"updateCart\" name=\"service\"/>\n");
      out.write("                    </form>\n");
      out.write("                    Or <a class=\"text-danger\" href=\"ControllerProduct\">Continue Shopping</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"form-content\">\n");
      out.write("                        <div class=\"form-items\">\n");
      out.write("                            <h3 class=\"text-center\">Check out</h3>\n");
      out.write("                            <form action=\"ControllerProduct\" method=\"POST\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <p style=\"margin: 7px auto;\">Receiver Name:</p>\n");
      out.write("                                    <input style=\"margin: 7px auto;\" type=\"text\" name=\"cname\" value=\"\" placeholder=\"Name\" required/>\n");
      out.write("                                </div>\n");
      out.write("                                <div>\n");
      out.write("                                    <p style=\"margin: 7px auto;\">Receiver Phone:</p>\n");
      out.write("                                    <input style=\"margin: 7px auto;\" type=\"text\" name=\"cphone\" value=\"\" placeholder=\"Phone\" required/>\n");
      out.write("                                </div>\n");
      out.write("                                <div>\n");
      out.write("                                    <p style=\"margin: 7px auto;\">Receiver Address:</p>\n");
      out.write("                                    <input style=\"margin: 7px auto;\" type=\"text\" name=\"caddress\" value=\"\" placeholder=\"Address\" required/>\n");
      out.write("                                </div>\n");
      out.write("                                <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartisempty}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                <div class=\"form-button mt-3\">\n");
      out.write("                                    <button id=\"submit\" type=\"submit\" value=\"Check out\" name=\"submit\" class=\"btn btn-primary\">Check out</button>\n");
      out.write("                                    <button id=\"submit\" type=\"reset\" value=\"Reset\" class=\"btn btn-primary\">Reset</button>\n");
      out.write("                                </div>\n");
      out.write("                                <p style=\"margin-top: 7px\">(Check your cart before check out)<p>\n");
      out.write("                                <p><input type=\"hidden\" value=\"checkOut\" name=\"service\"/>\n");
      out.write("                                    <input type=\"hidden\" value=\"");
      out.print(totalCart);
      out.write("\" name=\"total\"/>\n");
      out.write("                                    <input type=\"hidden\" value=\"");
      out.print(itemInCart);
      out.write("\" name=\"itemInCart\"/></p>\n");
      out.write("                            </form>\n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
