



<%-- 
    Document   : bill
    Created on : 14-06-2021, 13:38:18
    Author     : Grimmy
--%>

<%@page import="entity.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni" crossorigin="anonymous">
        <link href="css/styles_1.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/loginform.css" rel="stylesheet" type="text/css"/>
        <title>Purchase History</title>
    </head>
    <body>
        <jsp:include page="Panner.jsp"></jsp:include>
        <%
            ArrayList<Bill> arr = (ArrayList<Bill>) request.getAttribute("danhSach");
        %>
        <div style="min-height: 335px" class="container">
            <h1 class="text-danger" style="text-align:center; margin: 15px;" >Puschase History</h1>
            <table style="text-align:center;" border="3" class="table table-hover">
                <tr class="table-dark">
                    <td style="font-weight: bold">Date</td>
                    <td style="font-weight: bold">Receiver Name</td>
                    <td style="font-weight: bold">Receiver Phone</td>
                    <td style="font-weight: bold">Receiver Address</td>
                    <td style="font-weight: bold">Total</td>
                    <td style="font-weight: bold">Status</td>
                    <td style="font-weight: bold">Detail</td>
                </tr>
                <%for (Bill bill : arr) {%>
                <tr>
                    <td><%=bill.getDateCreate()%></td>
                    <td><%=bill.getCname()%></td>
                    <td><%=bill.getCphone()%></td>
                    <td><%=bill.getcAddress()%></td>
                    <td><%=bill.getTotal()%></td>
                    <td><%=(bill.getStatus() == 1) ? "Wait" : ((bill.getStatus() == 2) ? "Delivery" :"Done")%></td>
                    <td><a href="ControllerBill?service=historyDetail&oid=<%=bill.getoID()%>">View</a></td>
                </tr>
                <%}%>
            </table>
        </div>
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
