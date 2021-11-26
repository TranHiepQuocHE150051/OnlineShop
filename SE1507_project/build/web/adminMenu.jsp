<%-- 
    Document   : adminMenu
    Created on : 01-07-2021, 00:51:20
    Author     : Grimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-md-3 p-0" style="border-right: 1px solid #000">
    <table class="table table-light table-hover border-bottom-10">
        <thead>
            <tr>
                <th class="text-center navbar-brand bg-light" >Menu</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="text-center ">
                    <a class="navbar-brand text-black" href="ControllerAdminIndex?service=admin">Admin Manager</a>
                </td>
            </tr>
            <tr>
                <td class="text-center ">
                    <a class="navbar-brand text-black" href="ControllerAdminIndex?service=bill">Bill Manager</a>
                </td>
            </tr>
            <tr>
                <td class="text-center ">
                    <a class="navbar-brand text-black" href="ControllerAdminIndex?service=customer">Customer Manager</a>
                </td>
            </tr>
            <tr>
                <td class="text-center ">
                    <a class="navbar-brand text-black" href="ControllerAdminIndex?service=product">Product Manager</a>
                </td>
            </tr>
            <tr>
                <td class="text-center ">
                    <a class="navbar-brand text-black" href="ControllerAdminIndex?service=category">Category Manager</a>
                </td>
            </tr>
            
        </tbody>
    </table>
</div>
