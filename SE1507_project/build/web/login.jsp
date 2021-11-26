<%-- 
    Document   : login.jsp
    Created on : 12-06-2021, 04:06:34
    Author     : Grimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body class="text-center align-items-center" style="background-image: url(image/back.jpg); background-size: cover;">
        <div class="form-body">
            <div class="row">
                <div class="form-holder">
                    <div class="form-content">
                        <div class="form-items" style="background-color: #ffedcba1;">
                            <h3 style="color: black;" class="text-center">Login</h3>
                            <form action="ControllerLogin" method="POST">
                                <div>
                                    <p>Username:</p>
                                    <input type="text" name="username" value="" placeholder="username" required/>
                                </div>
                                <div>
                                    <p>Password: </p>
                                    <input type="password" id="password" name="password" value="" placeholder="password" required/>
                                </div>
                                <p style="color: #dc3545;">${alert}</p>
<!--                                <div>
                                    <input style="margin: 20px 0px" type="checkbox" onclick="myFunction()"/> Show Password
                                </div>-->
                                <div class="form-button mt-3">
                                    <button id="submit" type="submit" value="Login" name="submit" class="btn btn-primary">Login</button>
                                </div>
                                <p><input type="hidden" value="login" name="service"/></p>
                            </form>
                            If you don't have account <a href="ControllerLogin?service=Register"> <button class="btn btn-primary">Register</button></a>
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
