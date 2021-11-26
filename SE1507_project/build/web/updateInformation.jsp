<%-- 
    Document   : updateInformation
    Created on : 05-07-2021, 01:27:13
    Author     : Grimmy
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Update Information</title>
    </head>

    <body class="text-center align-items-center" style="background-image: url(image/208598.gif); background-size: cover;">
        <%
            Customer cus = (Customer) request.getAttribute("cus");
        %>
        <div class="form-body">
            <div class="row">
                <div class="form-holder">
                    <div class="form-content">
                        <div class="form-items" style="background-color: #ffedcba1;">
                            <h3 style="color: #dc3545;" class="text-center">Update Information</h3>
                            <form action="ControllerCustomer" method="POST">
                                <div>
                                    <p>Customer Name:</p>
                                    <input type="text" name="cname" value="<%=cus.getCname()%>" required/>
                                </div>
                                <div>
                                    <p>Customer Phone:</p>
                                    <input type="text" name="cphone" value="<%=cus.getCphone()%>" required/>
                                </div>
                                <div>
                                    <p>Customer Address:</p>
                                    <input type="text" name="cAddress" value="<%=cus.getcAddress()%>" required/>
                                </div>
                                <div>
                                    <p>Enter Password:</p>
                                    <input type="password" name="password" value="" placeholder="password" required/>
                                </div>
                                <p style="color: #dc3545;">${alert}</p>
                                <div class="form-button mt-3">
                                    <button id="submit" type="submit" value="Update" name="submit" class="btn btn-primary">Update</button>
                                    <button type="reset" value="Reset" class="btn btn-primary">Reset</button>
                                </div>
                                <p><input type="hidden" value="updated" name="service"/></p>
                            </form>
                        </div> 
                    </div>
                    <a href="ControllerProduct">Continue Shopping</a>    
                </div>         
            </div>
        </div>
    </body>
</html>
