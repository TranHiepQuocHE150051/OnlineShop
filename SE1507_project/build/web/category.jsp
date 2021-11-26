<%-- 
    Document   : category
    Created on : 10-06-2021, 22:15:33
    Author     : Grimmy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Category"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
%>
<div class="col-md-3 p-0">
    <form action="ControllerProduct" method="POST">
        <div class="input-group">
            <input type="text" name="search" class="form-control rounded" placeholder="Enter product name" aria-label="Search"
                   aria-describedby="search-addon" value=""/>
            <button type="submit" value="Search" name="submit" class="btn btn-outline-primary">Search</button>
            <input type="hidden" value="searchProduct" name="service"/>
        </div>
    </form>
    <table class="table table-light table-hover border-bottom-10">
        <thead>
            <tr>
                <th class="text-center navbar-brand bg-light" >Category</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="text-center bg-light">
                    <a class="navbar-brand text-warning" href="ControllerProduct">All Products</a>
                </td>
            </tr>
            <%for (Category cate : cl) {%>
            <tr>
                <td class="text-center text-black bg-light ">
                    <a class="navbar-brand text-warning" href="ControllerProduct?service=displayFollowCate&cateID=<%=cate.getCateID()%>"><%=cate.getCateName()%></a>
                </td>
            </tr>
            <%}%>
            <tr>
                <td class="text-center bg-light">
                    <a class="navbar-brand text-warning" href="ControllerProduct?service=showCart">Show Cart</a>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="left-cms left-sidebar-widget mb_50">
<!--        <ul style="list-style: none">
            <li>
                <div class="feature-i-left ptb_40">
                    <img style="margin: 20px" src="image/shipping.png" alt=""/>
                    <h6 style="display: inline; align-content: right; ">Cheap shipping fee</h6>
                    <p>Free ship inside Ha Noi</p>
                </div>
            </li>
            <li>
                <div class="feature-i-left ptb_40">
                    <img style="margin: 20px" src="image/order.png" alt=""/>
                    <h6 style="display: inline;">Order 24/7</h6>
                    <p>Order online any time, any where</p>
                </div>
            </li>
            <li>
                <div class="feature-i-left ptb_40">
                    <img style="margin: 20px" src="image/save.png" alt=""/>
                    <h6 style="display: inline;">Shop And Save</h6>
                    <p>Lowest Price in Town</p>
                </div>
            </li>
        </ul>-->
    </div>        
</div>