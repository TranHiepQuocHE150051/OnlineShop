<%-- 
    Document   : changePassword
    Created on : 14-06-2021, 16:27:07
    Author     : Grimmy
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Change Password</title>
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
                            <h3 style="color: #dc3545;" class="text-center">Change Password</h3>
                            <form action="ControllerCustomer" method="POST">
                                <div>
                                    <p>Username:</p>
                                    <input type="text" name="username" value="<%=cus.getCname()%>" readonly/>
                                </div>
                                <div>
                                    <p>Old Password:</p>
                                    <input type="password" name="oldpassword" id="oldpassword" placeholder="Enter your old password" value="" required/>
                                </div>
                                <div>
                                    <p>New Password:</p>
                                    <input type="password" name="newpassword" id="newpassword" placeholder="Enter your new password (> 8 letters)" value="" required/>
                                </div>
                                <div>
                                    <p>Confirm New Password:</p>
                                    <input type="password" name="renewpassword" id="rewnewpassword" placeholder="Enter your new password again" value="" required/>
                                </div>
                                <div>
                                    <input style="margin: 20px 0px" type="checkbox" onclick="myFunction()"/> Show Password
                                </div>
                                <p style="color: #dc3545;">${alert}</p>
                                <div class="form-button mt-3">
                                    <button id="submit" type="submit" value="Update" name="submit" class="btn btn-primary">Update</button>
                                    <button type="reset" value="Reset" class="btn btn-primary">Reset</button>
                                </div>
                                <p><input type="hidden" value="changedPassword" name="service"/></p>
                            </form>
                        </div> 
                    </div>
                    <a href="ControllerProduct">Continue Shopping</a>    
                </div>         
            </div>
        </div>    
    </body>
    <script>
        function myFunction() {
            var x = document.getElementById("oldpassword");
            var y = document.getElementById("newpassword");
            var z = document.getElementById("rewnewpassword");
            if (x.type === "password") {
                x.type = "text";
                y.type = "text";
                z.type = "text";
            } else {
                x.type = "password";
                y.type = "password";
                z.type = "password";
            }
        }
    </script>
</html>
