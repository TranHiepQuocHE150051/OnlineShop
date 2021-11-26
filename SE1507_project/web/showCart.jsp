<%-- 
    Document   : showCart
    Created on : 23-06-2021, 13:43:55
    Author     : Grimmy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni" crossorigin="anonymous">
        <link href="css/styles_1.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Cart</title>
    </head>
    <body>
        <jsp:include page="Panner.jsp"></jsp:include>
            <div class="container pt-5 pb-3">
                <div class="row">
                    <div class="col-md-8">
                        <form action="ControllerProduct" method="POST">
                            <h1 class="text-black" style="text-align:center; margin: 15px">Shopping Cart</h1>
                            <table style="text-align:center;" border="3" class="table table-hover">
                                <tr>
                                    <td style="font-weight: bold">Image</td>
                                    <td style="font-weight: bold">Product Name</td>
                                    <td style="font-weight: bold">Quantity</td>
                                    <td style="font-weight: bold">In Stock</td>
                                    <td style="font-weight: bold">Price</td>
                                    <td style="font-weight: bold">Total</td>
                                    <td style="font-weight: bold">Remove</td>
                                </tr>
                            <%
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
                            %>
                            <tr>
                                <td><img src="image/<%=pro.getImage()%>" width="40" height="40"/></td>
                                <td  class="text-danger"><%=pro.getPname()%></td>
                                <td><input type="text" name="<%=pro.getPid()%>" value="<%=count%>" onchange="ControllerProduct?service = updateCart & pid =<%=pro.getPid()%>"/> </td>
                                <td><%=pro.getQuantity()%></td>
                                <td><%=pro.getPrice()%></td>
                                <td><%=Integer.parseInt(count) * pro.getPrice()%></td>
                                <td><a onclick ="return confirm('Are you sure?')" href="ControllerProduct?service=removeFromCart&pid=<%=pro.getPid()%>">Remove</a></td>
                            </tr>
                            <%      }
                                }%>
                            <tr>
                                <td></td>
                                <td class="text-black" style="font-weight: bold">Product In Cart:</td>
                                <td class="text-black" style="font-weight: bold"><%=itemInCart%></td>
                                <td></td>
                                <td class="text-black" style="font-weight: bold">Total Price All Cart:</td>
                                <td class="text-black" style="font-weight: bold"><%=totalCart%></td>
                                <td><a onclick ="return confirm('Are you sure?')" href="ControllerProduct?service=removeAllFromCart">remove all</a></td>
                            </tr>
                        </table>
                        <p class="text-danger">${notenoughproduct}</p>
                        <button id="submit" type="submit" value="Update" name="submit" class="btn btn-primary">Update Cart</button>
                        <input type="hidden" value="updateCart" name="service"/>
                    </form>
                    Or <a class="text-black" href="ControllerProduct">Shopping</a>
                </div>
                <div class="col-md-4">
                    <div class="form-content">
                        <div class="form-items">
                            <h3 class="text-center">Check out</h3>
                            <form action="ControllerProduct" method="POST">
                                <div class="col-md-12">
                                    <p style="margin: 7px auto;">Receiver Name:</p>
                                    <input style="margin: 7px auto;" type="text" name="cname" value=""  required/>
                                </div>
                                <div>
                                    <p style="margin: 7px auto;">Receiver Phone:</p>
                                    <input style="margin: 7px auto;" type="text" name="cphone" value=""  required/>
                                </div>
                                <div>
                                    <p style="margin: 7px auto;">Receiver Address:</p>
                                    <input style="margin: 7px auto;" type="text" name="caddress" value="" required/>
                                </div>
                                <p class="text-danger">${cartisempty}</p>
                                <div class="form-button mt-3">
                                    <button id="submit" type="submit" value="Check out" name="submit" class="btn btn-primary">Check out</button>
                                    <button id="submit" type="reset" value="Reset" class="btn btn-primary">Reset</button>
                                </div>
                                <p style="margin-top: 7px">(Please check your cart before checkout)<p>
                                <p><input type="hidden" value="checkOut" name="service"/>
                                    <input type="hidden" value="<%=totalCart%>" name="total"/>
                                    <input type="hidden" value="<%=itemInCart%>" name="itemInCart"/></p>
                            </form>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>