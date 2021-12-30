<%-- 
    Document   : products
    Created on : Sep 15, 2021, 12:00:03 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <link href="<c:url value="/resources/fonts/icons/fontawesome-free-5.15.4-web/css/all.min.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/homefix.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>


        <div class="container  ">
            <div class="text-center">
                <h1>List products</h1>
            </div>
            <div class="row">
                <div class="col-sm-6 col-lg-6 margin-left-0">
                    <button onclick="location.href = '<c:url value="/addProduct"/>'" class="btn btn-info">Add Product</button><br>
                </div>
                <div class="col-sm-6 col-lg-6 margin-left-0 ">
                    <form action="${pageContext.request.contextPath}/search" method="GET" class="form-inline float-sm-right" >
                        <div class="form-group"> 
                            <input type="text" name="strSearch" placeholder="Search product..." class="form-control mr-sm-2"/>
                            <button type="submit" class="btn btn-outline-success my-2 my-sm-0">Search</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class=" row table-responsive pt-2">
                <table class="table table-bordered table-sm table-re">
                    <thead class="thead-light text-center">
                        <tr>
                            <th>Id</th>
                            <th id="name">Name</th>
                            <th id="description">Description</th>
                            <th id="createDate">Create Date</th>
                            <th >Category</th>
                            <th id="image">Image</th>
                            <th>Detail</th>
                            <th colspan="3">Action</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${products!=null && fn:length(products)>0}">
                            <c:forEach items="${products}" var="p">
                                <tr class="row-product" >
                                    <td>${p.id}</td>
                                    <td>${p.name}</td>
                                    <td>${p.description}</td>
                                    <td>${p.createDate}</td>                                    
                                    <td>${p.categoryEntity.name}</td>
                                    <td >
                                        <c:forEach items="${images}" var="img">
                                            <c:if test="${img.productEntity.id==p.id}">
                                                <img src="<c:url value="/resources/images/"/>${img.name}" height=50 width="50"/>
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    
                                    
                                    <td class="btn-action">
                                        <buttion onclick="location.href = '<c:url value="/showDetail/${p.id}"/>'"class="btn-action-2">
                                            <i class="fas fa-cart-plus add-cart-icon"></i>
                                        </buttion>
                                    </td>
                                    <td>
                                        <buttion onclick="location.href = '<c:url value="/update/${p.id}"/>'"class="btn btn-success btn-action">Update</buttion>
                                    </td>
                                    <td>
                                        <buttion onclick="location.href = '<c:url value="/delete/${p.id}"/>'"class="btn btn-danger btn-action">Delete</buttion>
                                    </td>
                                    
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${products==null || fn:length(products)==0}">
                        <tr >
                            <td colspan="7" style="color: red;text-align: center">There are no product found!</td>
                        </tr>
                    </c:if>
                    <tbody>
                </table>
            </div>
        </div>
    </body>
</html>
