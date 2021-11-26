<%-- 
    Document   : index
    Created on : 28-06-2021, 13:08:39
    Author     : Grimmy
--%>

<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Index</title>
    </head>
    <body>
        <jsp:include page="Panner.jsp"></jsp:include>
            <div class="bg-light">
            <jsp:include page="Header.jsp"></jsp:include>
            <%
                ArrayList<Category> cl = (ArrayList<Category>) request.getAttribute("catelist");
                ArrayList<Product> arr = (ArrayList<Product>) request.getAttribute("danhSach");
                String lastPage = request.getAttribute("lastPage").toString();
                String service = request.getAttribute("service").toString();
            %>
            <div class="row" >
                
                    <div class="col-md-9" style="border-left: 2px solid #212529" id="product">
                        <h1 class="text-center text-dark pt-3">Product</h1>
                        <hr>
                        <div class="border-10 container px-4 px-lg-5 mt-5">
                            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                            <%for (Product pro : arr) {%>
                            <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Product image-->
                                    <img class="card-img-top" src="image/<%=pro.getImage()%>"/>
                                    <hr>
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><%=pro.getPname()%></h5>
                                            <h6>(In stock: <%=pro.getQuantity()%>)</h6>
                                            <!-- Product price-->
                                            Price: $<%=pro.getPrice()%>                                            
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <%if (pro.getQuantity() > 0) {%>
                                            <a class="btn btn-outline-dark mt-auto" href=ControllerProduct?service=addToCart&pid=<%=pro.getPid()%>>
                                                <i class="bi-cart-fill me-1"></i>
                                                Add to cart
                                            </a>
                                            <%} else {%>
                                            <button disabled class="btn btn-outline-dark text-dark">
                                                <i class="bi-cart-fill me-1"></i>
                                                Out of stock
                                            </button>
                                            <%}%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                        <div style="text-align: center; background: grey;">
                            Pages: 
                            <%for (int i = 1; i <= Integer.parseInt(lastPage); i++) {%>
                            <a href="ControllerProduct?service=<%=service%>&pageNumber=<%=i%>${cateID}${search}">
                                <button class="btn btn-danger text-light">
                                    <%=i%>
                                </button>
                            </a>
                            <%}%>
                        </div>
                    </div>
                </div>
                        <jsp:include page="category.jsp"></jsp:include>
            </div>
        </div>
                        
        <hr>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
