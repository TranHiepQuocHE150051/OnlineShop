<%-- 
    Document   : Panner2
    Created on : 01-07-2021, 18:22:53
    Author     : Grimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
    <div class="container px-5">
        <a class="navbar-brand" href="ControllerProduct">HE150051-Trần Hiệp Quốc</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <%
                    java.util.Enumeration em = session.getAttributeNames();
                    java.util.Enumeration em1 = session.getAttributeNames();
                    int count = 0;
                    while (em1.hasMoreElements()) {
                        String key1 = em1.nextElement().toString();
                        if (!key1.equals("username") && !key1.equals("admin") && !key1.equals("service")) {
                            int value = Integer.parseInt(session.getAttribute(key1).toString());
                            count = count + value;
                        }
                    }
                    if (em.hasMoreElements()) {
                        String username = "";
                        while (em.hasMoreElements()) {
                            String key = em.nextElement().toString();
                            if (key.equals("username")) {
                                username = session.getAttribute("username").toString();%>
                <li class="text-danger" style="margin-top: 15px">${added}</li>
                <a class="nav-link" href="ControllerProduct?service=showCart">
                    <button class="btn btn-outline-danger text-light">
                        <i class="bi-cart-fill me-1"></i>
                        Cart
                        <span class="badge bg-danger text-light ms-1 rounded-pill"><%=count%></span>
                    </button>
                </a>
                <div class="dropdown">
                    <li class="nav-item navbar-brand dropdown-toggle" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin-top: 7px">Welcome: <%=username.toLowerCase()%></li>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="ControllerBill?service=history">Purchase history</a></li>
                        <li><a class="dropdown-item" href="ControllerCustomer?service=updateInformation">Update Information</a></li>
                        <li><a class="dropdown-item" href="ControllerCustomer?service=changePassword">Change Password</a></li>
                        <li><a class="dropdown-item" href="ControllerLogin?service=logout">Logout</a></li>
                    </ul>
                </div>
                <%          }
                    }
                    if (username.equals("")) {%>
                <li class="text-danger" style="margin-top: 15px">${added}</li>
                <a class="nav-link" href="ControllerProduct?service=showCart">
                    <button class="btn btn-outline-danger text-light">
                        <i class="bi-cart-fill me-1"></i>
                        Cart
                        <span class="badge bg-danger text-light ms-1 rounded-pill"><%=count%></span>
                    </button>
                </a>
                <a class="nav-link" href="ControllerLogin">
                    <button class="btn btn-outline-danger text-light">
                        Login
                    </button>
                </a>
                <%      }
                } else {%>
                <li class="text-danger" style="margin-top: 15px">${added}</li>
                <a class="nav-link" href="ControllerProduct?service=showCart">
                    <button class="btn btn-outline-danger text-light">
                        <i class="bi-cart-fill me-1"></i>
                        Cart
                        <span class="badge bg-danger text-light ms-1 rounded-pill"><%=count%></span>
                    </button>
                </a>
                <a class="nav-link" href="ControllerLogin">
                    <button class="btn btn-outline-danger text-light">
                        Login
                    </button>
                </a>
                <%  }
                %>
            </ul>
        </div>
    </div>
</nav>
