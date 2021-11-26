<%-- 
    Document   : addProduct
    Created on : 11-06-2021, 23:38:03
    Author     : Grimmy
--%>

<%@page import="entity.Category"%>
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
        <title>Add Product</title>
    </head>
    <body>
        <%
            ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
        %>
        <jsp:include page="adminPanner.jsp"></jsp:include>
            <div class="row">
            <jsp:include page="adminMenu.jsp"></jsp:include>
                <div class="col-md-9">
                    <form action="ControllerAdminIndex" method="POST">
                        <table class="table-condensed table-striped table">
                            <caption><h1>Add Product</h1></caption>
                            <tbody>
                                <tr>
                                    <td>Product Name</td>
                                    <td><input type="text" name="pname" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Quantity</td>
                                    <td><input type="text" name="quantity" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td><input type="text" name="price" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Image</td>
                                    <td><input type="file" name="image" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Description</td>
                                    <td><input type="text" name="description" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td><input type="radio" name="status" value="1" checked/>Enable
                                        <input type="radio" name="status" value="0"/>Disable</td>
                                </tr>
                                <tr>
                                    <td>Category</td>
                                    <td><select name="Cate">
                                        <%for (Category cate : cl) {%> 
                                        <option value="<%=cate.getCateID()%>"> <%=cate.getCateName()%> </option>
                                        <%}%>
                                    </select>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <p class="text-danger">${alert}</p>
                    <p><input type="submit" value="Add" name="submit"/>  
                        <input type="reset" value="Reset"/></p>
                    <input type="hidden" value="addProduct" name="service"/>
                </form>
            </div>
        </div>
        <jsp:include page="footerAdmin.jsp"></jsp:include>                            
    </body>
</html>
