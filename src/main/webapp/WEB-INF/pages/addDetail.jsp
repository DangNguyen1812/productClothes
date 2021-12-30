<%-- 
    Document   : addDetail
    Created on : Sep 24, 2021, 2:19:33 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add detail</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            *{
                padding: 0;
                margin: 0;
                position: relative;
            }
            .form-detail{
                padding: 3em;
                padding-top: 0;
                border: 1px solid rgba(255, 0, 0, .3);
                border-radius: 5px;

            }
            .vertical-center {
                margin: auto;
                padding: auto;
                text-align: center;
            }
            .btn1 {
                width: 20%;
            }
        </style>
    </head>
    <body>
        <a href="<c:url value="/home"/>">Home</a>
        <div class="container">
            <div class="text-center">
                <h2>Add product detail</h2>
            </div>
            <div class="row">
                <div class="col-sm-4 form-detail pt-2" >
                    <mvc:form action="${pageContext.request.contextPath}/detail" method="POST" modelAttribute="productDetail" >
                        <input type="text" name="productEntity.id" value="${product.id}"  hidden/>
                        <input type="text" name="action" value="${action}"  hidden/>
                        <div class="form-group">
                            <label for="quantity">Quantity: </label>
                            <input type="number" name="quantity" id="quantity" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price: </label>
                            <input type="number" name="price" id="price" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="color">Color: </label>
                            <select name="colorEntity.id">
                                <c:forEach items="${color}" var="c">
                                    <option value="${c.id}">${c.color}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="size">Size: </label>
                            <select name="sizeEntity.id">
                                <c:forEach items="${size}" var="z">
                                    <option value="${z.id}">${z.size}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <p style="color: red">${message}</p>
                        </div>
                        <button type="submit" class="btn btn-info ">Add</button>
                    </mvc:form>
                </div>
                <div class="col-sm-8 table-responsive pt-2">
                    <table class="table table-bordered table-sm table-re">
                        <thead class="thead-light text-center">
                            <tr>  
                                <th>Name</th>
                                <th>Quantity</th>
                                <th style="width: 10em">Price</th>
                                <th>Color</th>
                                <th>Size</th>
                                <th style="width: 6em">Action</th>
                            </tr>
                        </thead>
                        <tbody class="text-center">
                            <c:forEach items="${sessionDetail}" var="detail">                                
                                <tr>
                                    <td>${detail.productEntity.name}</td>
                                    <td>${detail.quantity}</td>
                                    <td>${detail.price}</td>
                                    <td>${detail.colorEntity.color}</td>
                                    <td>${detail.sizeEntity.size}</td>
                                    <td><buttion onclick="location.href = '<c:url value="/removeDetail/${detail.id}/${product.id}"/>'"class="btn btn-danger">Remove</buttion></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${message1 != null}">
                            <tr>
                                <td colspan="6" style="opacity: 0.5;text-align: center">${message1}</td>

                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    <div class="vertical-center">
                        <buttion onclick="location.href = '<c:url value="/saveDetail"/>'" class="btn btn-success btn1">Save</buttion>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
