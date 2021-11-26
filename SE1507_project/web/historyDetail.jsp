<%-- 
    Document   : historyDetail
    Created on : 04-07-2021, 23:47:28
    Author     : Grimmy
--%>

<%@page import="java.sql.ResultSet"%>
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
        <title>Purchase History Detail</title>
    </head>
    <body>
        <jsp:include page="Panner.jsp"></jsp:include>
        <%
            ResultSet rs1 = (ResultSet) request.getAttribute("ketQua1");
            ResultSet rs2 = (ResultSet) request.getAttribute("ketQua2");
        %>
        <div class="container">
            <h1 class="text-danger" style="text-align:center; margin: 15px;" >Bill Detail</h1>
            <table border="3" class="table-condensed table-bordered table">
                <tbody>
                    <%while (rs1.next()) {%>
                    <tr>
                        <td><h3>Order</h3></td>
                        <td>
                            <div class="row">
                                <div class="col-md-4">
                                    <p>Order ID:   <%=rs1.getString(1)%></p>
                                </div>
                                <div class="col-md-4">
                                    <p>Date Create:<%=rs1.getString(2)%></p>
                                </div>
                                <div class="col-md-4">
                                    <p>Status: <%=(rs1.getString(3).equals("1")) ? "Wait" : ((rs1.getString(3).equals("2")) ? "Delivery" :"Done")%></p>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><h3>Product</h3></td>
                        <td>
                            <table class="table-hover table text-center">
                                <thead>
                                    <tr>
                                        <th>Image</th>
                                        <th>Product Name</th>
                                        <th>Price</th>
                                        <th>Category</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%  double totalbill = 0;
                                        int quantity = 0;
                                        while (rs2.next()) {
                                            double total = 0;
                                            total = Double.parseDouble(rs2.getString(14)) * Integer.parseInt(rs2.getString(15));
                                            totalbill += total;
                                            quantity = quantity + Integer.parseInt(rs2.getString(15));
                                    %>
                                    <tr>
                                        <td><img src="image/<%=rs2.getString(18)%>" width="40" height="40"/></td>
                                        <td><%=rs2.getString(13)%></td>
                                        <td>$<%=rs2.getString(14)%></td>
                                        <td><%=rs2.getString(17)%></td>
                                        <td><%=rs2.getString(15)%></td>
                                        <td><%=total%></td>
                                    </tr>
                                    <%}%>
                                    <tr>
                                        <td style="font-weight: bold" class="text-danger">Total Bill</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td style="font-weight: bold" class="text-danger"><%=quantity%></td>
                                        <td style="font-weight: bold" class="text-danger"><%=totalbill%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><h3>Customer</h3></td>
                        <td>
                            <div class="row">
                                <div class="col-md-6">
                                    <h2>Buyer</h2>
                                    <p>Customer ID:     <%=rs1.getString(4)%></p>
                                    <p>Customer Name:   <%=rs1.getString(5)%></p>
                                    <p>Customer Phone:  <%=rs1.getString(6)%></p>
                                    <p>Customer Address:<%=rs1.getString(7)%></p>
                                    <p>Username:        <%=rs1.getString(8)%></p>
                                </div>
                                <div class="col-md-6">
                                    <h2>Receiver</h2>
                                    <p>Receiver Name:   <%=rs1.getString(9)%></p>
                                    <p>Receiver Phone:  <%=rs1.getString(10)%></p>
                                    <p>Receiver Address:<%=rs1.getString(11)%></p>
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <%break;
                }%>
        </div>
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
