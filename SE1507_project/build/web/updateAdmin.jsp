<%-- 
    Document   : updateAdmin
    Created on : 11-06-2021, 22:38:42
    Author     : Grimmy
--%>

<%@page import="entity.Admin"%>
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
        <title>Update Admin</title>
    </head>
    <body>
        <%
            Admin admin = (Admin) request.getAttribute("admin");
        %>
        <jsp:include page="adminPanner.jsp"></jsp:include>
            <div class="row">
            <jsp:include page="adminMenu.jsp"></jsp:include>
                <div class="col-md-9">
                    <form action="ControllerAdminIndex" method="POST">
                        <table class="table-condensed table-striped table">
                            <caption><h1>Update Admin</h1></caption>
                            <tbody>
                                <tr>
                                    <td>Admin ID</td>
                                    <td><input type="text" name="adminID" value="<%=admin.getAdminID()%>" readonly /></td>
                            </tr>
                            <tr>
                                <td>Username</td>
                                <td><input type="text" name="username" value="<%=admin.getUsername()%>" readonly/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="text" name="password" value="<%=admin.getPassword()%>" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <p class="text-danger">${alert}</p>
                    <p><input type="submit" value="Update" name="submit"/>  
                        <input type="reset" value="Reset"/></p>
                    <input type="hidden" value="updatedAdmin" name="service"/>
                </form>
            </div>
        </div>
        <jsp:include page="footerAdmin.jsp"></jsp:include>
    </body>
</html>
