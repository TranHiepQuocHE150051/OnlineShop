<%-- 
    Document   : Panner
    Created on : 28-06-2021, 13:43:07
    Author     : Grimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="ControllerAdminIndex">HE150051-Trần Hiệp Quốc</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <%
                    java.util.Enumeration em = session.getAttributeNames();
                    if (em.hasMoreElements()) {
                        String username = "";
                        while (em.hasMoreElements()) {
                            String key = em.nextElement().toString();
                            if (key.equals("admin")) {
                                username = session.getAttribute("admin").toString();%>
                <li class="nav-item navbar-brand" style="margin-top: 7px">Welcome: <%=username%></li>
                <a class="nav-link" href="ControllerLogin?service=logout">
                    <button class="btn btn-outline-danger text-light">
                        Logout
                    </button>
                </a>
                <%          }
                        }
                    }
                %>
            </ul>
        </div>
    </div>
</nav>