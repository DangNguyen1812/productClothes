<%-- 
    Document   : details
    Created on : Sep 29, 2021, 5:54:47 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/css/detail.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    </head>
    <body>
        <div class="container pt-3 ">
            <div >
                <h4 style="text-align: center">Product details </h4>
            </div>
            <div class="">
                <p>Product Name: ${product.name}</p>
                <div class="body-detail">
                    <div class="detail__info">
                        <mvc:form action="${pageContext.request.contextPath}/check-order" method="post" modelAttribute="productDetail">
                            <input type="text" name="productEntity.id" value="${product.id}"  hidden/>
                            <div>
                                <label>Size:</label>
                                <select name="sizeEntity.id" onchange="this.form.submit()">
                                    
                                    <c:forEach items="${sizes}" var="size">
                                        <c:if test="${productDetail.sizeEntity.id == size.id}">
                                            <option value="${size.id}" selected>${size.size}</option>
                                        </c:if>
                                        <c:if test="${productDetail.sizeEntity.id != size.id}">
                                            <option value="${size.id}">${size.size}</option>
                                        </c:if>
                                        
                                        
                                    </c:forEach>                     
                                </select>
                            </div>
                            <div>
                                <label>Color:</label>
                                <select name="colorEntity.id" onchange="changeColor(this.form.submit())">
                                   
                                    <c:forEach items="${colors}" var="color">
                                        <c:if test="${productDetail.colorEntity.id == color.id}">
                                            <option value="${color.id}" selected>${color.color}</option>
                                        </c:if>
                                        <c:if test="${productDetail.colorEntity.id != color.id}">
                                            <option value="${color.id}">${color.color}</option>
                                        </c:if>
                                    </c:forEach>                     
                                </select>
                            </div>
                            <div>
                                <label>Price: ${price}</label>
                                <input type="number" name="price" value="${price}" hidden>
                                <a href="#" class="btn btn-default ">
                                    <i class="bi bi-trash"></i>  
                                </a>

                            </div>
                            <div>
                                <label>Quantity</label>
                                <div class="input-group">
                                    <span class="input-group-text btn btn-danger" onclick="this.parentNode.querySelector('input[type=number]').stepDown()"> -     </span>
                                    <input type="number" name="quantity" value="0" class="form-control text-center" >
                                    <span class="input-group-text btn btn-success" onclick="this.parentNode.querySelector('input[type=number]').stepUp()"> +    </span>
                                </div>

                            </div>
                                <div>
                                    <input type="submit" id="btn-add-to-cart" value="Add to cart"/>
                                </div>
                        </mvc:form>
                    </div>
                    <div class="detail__image">
                        <c:forEach items="${images}" var="img">
                            <img src="<c:url value="/resources/images/"/>${img.name}" height=150 width="150"/>
                        </c:forEach>
                    </div>
                </div>
                <div>${message}</div>
            </div>

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            
        </script>
    </body>
</html>
