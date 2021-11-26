<%-- 
    Document   : billDetail
    Created on : 14-06-2021, 13:53:04
    Author     : Grimmy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="entity.Category"%>
<%@page import="entity.Product"%>
<%@page import="entity.Customer"%>
<%@page import="entity.Bill"%>
<%@page import="entity.BillDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni" crossorigin="anonymous">
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles_1.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Bill Detail</title>
    </head>
    <body>
        <%
            String title = request.getAttribute("tieuDe").toString();
            ResultSet rs1 = (ResultSet) request.getAttribute("ketQua1");
            ResultSet rs2 = (ResultSet) request.getAttribute("ketQua2");
        %>
        <jsp:include page="adminPanner.jsp"></jsp:include>
            <div class="row">
            <jsp:include page="adminMenu.jsp"></jsp:include>
                <div class="col-md-9">
                    <form action="ControllerAdminIndex" method="POST">
                        <table class="table-condensed table-striped table">
                            <caption><h1><%=title%></h1></caption>
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
                                            <p>Status: <input type="radio" name="status" value="1" <%=(rs1.getString(3).equals("1") ? "checked" : "")%>/>Wait    
                                                <input type="radio" name="status" value="2" <%=(rs1.getString(3).equals("2") ? "checked" : "")%>/>Delivery
                                                <input type="radio" name="status" value="0" <%=(rs1.getString(3).equals("0") ? "checked" : "")%>/>Done 
                                            </p>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><h3>Product</h3></td>
                                <td>
                                    <table class="table-condensed table-striped table-hover table">
                                        <thead>
                                            <tr>
                                                <th>Product ID</th>
                                                <th>Product Name</th>
                                                <th>Price</th>
                                                <th>Category</th>
                                                <th>Quantity</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%  double totalbill = 0;
                                                while (rs2.next()) {
                                                    double total = 0;
                                                    total = Double.parseDouble(rs2.getString(14)) * Integer.parseInt(rs2.getString(15));
                                                    totalbill += total;
                                            %>
                                            <tr>
                                                <td><%=rs2.getString(12)%></td>
                                                <td><%=rs2.getString(13)%></td>
                                                <td>$<%=rs2.getString(14)%></td>
                                                <td><%=rs2.getString(17)%></td>
                                                <td><%=rs2.getString(15)%></td>
                                                <td>$<%=total%></td>
                                            </tr>
                                            <%}%>
                                            <tr>
                                                <td style="font-weight: bold" class="text-danger">Total Bill</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td style="font-weight: bold" class="text-danger">$<%=totalbill%></td>
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
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <%break;
                        }%>        
                    <p><input type="submit" value="Update" name="submit"/>  
                        <input type="reset" value="Reset"/></p>
                    <input type="hidden" value="updatedBill" name="service"/>
                    <input type="hidden" value="<%=rs1.getString(1)%>" name="oid"/>
                </form>

                <input type="submit" onclick=window.location.href="ControllerAdminIndex?service=bill" value="Back to bill list" />
            </div>
        </div>
        <jsp:include page="footerAdmin.jsp"></jsp:include>
    </body>
</html>
