<%-- 
    Document   : register
    Created on : 12-06-2021, 11:19:37
    Author     : Grimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Register</title>
    </head>
    <body style="background-image: url(image/back.jpg); background-size: cover;">
        <div class="form-body">
            <div class="row">
                <div class="form-holder">
                    <div class="form-content">
                        <div class="form-items" style="background-color: #ffedcba1;">
                            <h3 style="color: #dc3545;" class="text-center">Register</h3>
                            <form action="ControllerLogin" method="POST">
                                <div class="row">
                                    <div class="col-md-12">
                                        <p>Your name:</p>
                                        <input type="text" name="cname" value="" placeholder="Name" required/>
                                    </div>
                                    <div class="col-md-12">
                                        <p>Phone number:</p>
                                        <input type="text" name="cphone" value="" placeholder="Phone" required/>
                                    </div>
                                    <div class="col-md-12">
                                        <p>Address:</p>
                                        <input type="text" name="cAddress" value="" placeholder="Address" required/>
                                    </div>
                                    <div class="col-md-12">
                                        <p>Username:</p>
                                        <input type="text" name="username" value="" placeholder="Username" required/>
                                    </div>
                                    <div>
                                        <p>Password: </p>
                                        <input type="password" id="password" name="password" value="" placeholder="Password must have 8 characters or more" required/>
                                    </div>
                                </div>
                                <div>
                                    <input style="margin: 20px 0px" type="checkbox" onclick="myFunction()"/> Show Password
                                </div>
                                <p style="color: #dc3545;">${alert}</p>
                                <div class="form-button mt-3">
                                    <input class="btn btn-primary" type="submit" value="Register" name="submit"/> 
                                    <input type="reset" value="Reset" class="btn btn-primary"/>
                                </div>
                                <p><input type="hidden" value="registeredCustomer" name="service"/></p>
                            </form>
                            If you had an account <a href="ControllerLogin"> <button class="btn btn-primary">Login</button></a>
                        </div> 
                    </div>
                    <a href="ControllerProduct">Continue Shopping</a>    
                </div>         
            </div>
        </div>
    </body>
    <script>
        function myFunction() {
            var x = document.getElementById("password");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>
</html>
