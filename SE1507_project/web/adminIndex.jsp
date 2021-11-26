<%-- 
    Document   : adminIndex
    Created on : 29-06-2021, 00:46:01
    Author     : Grimmy
--%>

<%@page import="entity.Admin"%>
<%@page import="entity.Bill"%>
<%@page import="entity.Category"%>
<%@page import="entity.Product"%>
<%@page import="entity.Customer"%>
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
        <title>Admin Index</title>
    </head>
    <body>
        <%
            Object admin = session.getAttribute("admin");
            if (!(admin == null)) {
        %>
        <jsp:include page="adminPanner.jsp"></jsp:include>
            <div class="row">
            
                <div class="col-md-9">
                <%
                    String service = session.getAttribute("service").toString();
                    if (service.equals("hello")) {%>
                    <h1 class="text-danger" style="text-align: center; margin-top: 100px;">Welcome</h1>     
                <%  }%>
                <%
                    if (service.equals("customer")) {
                        ArrayList<Customer> arr = (ArrayList<Customer>) request.getAttribute("danhSach");
                %>
                <h1 class="text-black-50" style="text-align:center; margin: 15px">Customer </h1>
                <table class="table table-dark" border="2">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Customer Name</th>
                            <th>Customer Phone</th>
                            <th>Customer Address</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Status</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Customer cus : arr) {%>
                        <tr>
                            <td><%=cus.getCid()%></td>
                            <td><%=cus.getCname()%></td>
                            <td><%=cus.getCphone()%></td>
                            <td><%=cus.getcAddress()%></td>
                            <td><%=cus.getUsername().toLowerCase()%></td>
                            <td><%=cus.getPassword()%></td>
                            <td><%=(cus.getStatus() == 1) ? "Enable" : "Disable"%></td>
                            <td><a onclick ="return confirm('Are you sure?')" href="ControllerAdminIndex?service=deleteCustomer&cid=<%=cus.getCid()%>">delete</a></td>
                            <td><a href="ControllerAdminIndex?service=updateCustomer&cid=<%=cus.getCid()%>">update</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <input type="submit" onclick=window.location.href="addCustomer.jsp" value="Add new Customer" />
                <%  }%>
                <%
                    if (service.equals("product")) {
                        ArrayList<Product> arr = (ArrayList<Product>) request.getAttribute("danhSach");
                        ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
                %>
                <h1 class="text-black-50" style="text-align:center; margin: 15px">Product </h1>
                <table class="table table-dark" border="1">
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Category</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Product pro : arr) {%>
                        <tr>
                            <td><%=pro.getPid()%></td>
                            <td><%=pro.getPname()%></td>
                            <td><%=pro.getQuantity()%></td>
                            <td>$<%=pro.getPrice()%></td>
                            <td><img src="image/<%=pro.getImage()%>" width="40" height="40"/></td>
                            <td><%=pro.getDescription()%></td>
                            <td><%=(pro.getStatus() == 1) ? "Enable" : "Disable"%></td>
                            <%for (Category cate : cl) {
                                    if (cate.getCateID() == pro.getCateID()) {
                            %>
                            <td><%=cate.getCateName()%></td>
                            <%      }
                                }%>
                            <td><a onclick ="return confirm('Are you sure?')" href="ControllerAdminIndex?service=deleteProduct&pid=<%=pro.getPid()%>">delete</a></td>
                            <td><a href="ControllerAdminIndex?service=updateProduct&pid=<%=pro.getPid()%>">update</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <input type="submit" onclick=window.location.href="ControllerAdminIndex?service=preAddProduct" value="Add new Product" />
                <%  }%>
                <%
                    if (service.equals("bill")) {
                        ArrayList<Bill> arr = (ArrayList<Bill>) request.getAttribute("danhSach");
                %>
                <h1 class="text-black-50" style="text-align:center; margin: 15px">Bill </h1>
                <table class="table table-dark" border="1">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Date Create</th>
                            <th>Receiver Name</th>
                            <th>Receiver Phone</th>
                            <th>Receiver Address</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>Customer ID</th>
                            <th>Bill Detail</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Bill bill : arr) {%>
                        <tr>
                            <td><%=bill.getoID()%></td>
                            <td><%=bill.getDateCreate()%></td>
                            <td><%=bill.getCname()%></td>
                            <td><%=bill.getCphone()%></td>
                            <td><%=bill.getcAddress()%></td>
                            <td><%=bill.getTotal()%></td>
                            <td><%=(bill.getStatus() == 1) ? "Wait" : ((bill.getStatus() == 2) ? "Delivery" :"Done")%></td>
                            <td><%=bill.getCid()%></td>
                            <td><a href="ControllerBill?service=detail&oid=<%=bill.getoID()%>">View</a></td>
                            <%if(bill.getStatus() == 1 || bill.getStatus() == 2){%>
                            <td><a href="ControllerAdminIndex?service=deleteBill&oid=<%=bill.getoID()%>">Delete</a></td>
                            <%}%>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <%  }%>
                <%
                    if (service.equals("category")) {
                        ArrayList<Category> arr = (ArrayList<Category>) request.getAttribute("danhSach");
                %>
                <h1 class="text-black-50" style="text-align:center; margin: 15px">Category </h1>
                <table class="table table-dark" border="1">
                    <thead>
                        <tr>
                            <th>Category ID</th>
                            <th>Category Name</th>
                            <th>Status</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Category cate : arr) {%>
                        <tr>
                            <td><%=cate.getCateID()%></td>
                            <td><%=cate.getCateName()%></td>
                            <td><%=(cate.getStatus()) == 1 ? "Enable" : "Disable"%></td>
                            <td><a onclick ="return confirm('Are you sure?')" href="ControllerAdminIndex?service=deleteCategory&id=<%=cate.getCateID()%>">delete</a></td>
                            <td><a href="ControllerAdminIndex?service=updateCategory&id=<%=cate.getCateID()%>">update</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <input type="submit" onclick=window.location.href="addCategory.jsp" value="Add new Category" />
                <%  }%>
                <%
                    if (service.equals("admin")) {
                        ArrayList<Admin> arr = (ArrayList<Admin>) request.getAttribute("danhSach");
                %>
                <h1 class="text-black-50" style="text-align:center; margin: 15px">Admin </h1>
                <table class="table table-dark" border="1">
                    <thead>
                        <tr>
                            <th>Admin ID</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Admin ad : arr) {%>
                        <tr>
                            <td><%=ad.getAdminID()%></td>
                            <td><%=ad.getUsername().toLowerCase()%></td>
                            <td><%=ad.getPassword()%></td>
                            <td><a onclick ="return confirm('Are you sure?')" href="ControllerAdminIndex?service=deleteAdmin&id=<%=ad.getAdminID()%>">delete</a></td>
                            <td><a href="ControllerAdminIndex?service=updateAdmin&adminID=<%=ad.getAdminID()%>">update</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <input type="submit" onclick=window.location.href="addAdmin.jsp" value="Add new Admin" />
                <%  }%>
            </div>
            <jsp:include page="adminMenu.jsp"></jsp:include>
        </div>
        <jsp:include page="footerAdmin.jsp"></jsp:include>
        <%  } else {%>
        <h1 class="text-danger">Access Denied!!! You are not Admin!!!</h1>
        <%  }%>
    </body>
    
</html>
