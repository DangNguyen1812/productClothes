<%-- 
    Document   : addProduct
    Created on : Sep 15, 2021, 2:01:29 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <body>
        <a href="<c:url value="/home"/>">Home</a>
        <div class="container pt-3">

            <div class="text-center">
                <c:if test="${action=='add'}">
                    <h2>Add Product</h2>
                </c:if>
                <c:if test="${action=='update'}">
                    <h2>Update product</h2>
                </c:if>
            </div>

            <div class="row">
                <div class="col-sm-4">

                </div>
                <div class="col-sm-4" >
                    <mvc:form action="${pageContext.request.contextPath}/result" method="POST" modelAttribute="product" enctype="multipart/form-data">
                        <c:if test="${action=='update'}">
                            <input name="id" type="text" value="${product.id}" hidden/>
                        </c:if>
                            <input name="action" type="text" value="${action}" hidden/>
                        <div class="form-group">
                            <label>Category:</label>                           
                            <select   name="categoryEntity.id" class="form-control">
                                <c:forEach items="${categorys}" var="category">
                                    <c:if test="${product.categoryEntity.id==category.id}">
                                        <option value="${category.id}" selected>${category.name}</option> 
                                    </c:if>
                                    <c:if test="${product.categoryEntity.id!=category.id}">
                                        <option value="${category.id}" >${category.name}</option> 
                                    </c:if>
                                </c:forEach>                                                                                             
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input name="name" class="form-control" id="name" value="${product.name}"/>
                        </div>

                        <div class="form-group">
                            <label for="description">Description:</label>
                            <textarea name="description" class="form-control" id="description" >${product.description}</textarea>
                        </div>

                        <div class="form-group">
                            <label for="createDate">Create Date:</label>
                            <c:if test="${action=='add'}">
                                <input type="date" name="createDate" class="form-control" id="createDate" value="${date}" readonly/>
                            </c:if>
                            <c:if test="${action=='update'}">
                                <input type="date" name="createDate" class="form-control" id="createDate" value="${product.createDate}" readonly/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label >Product Images</label>
                            <input type="file" name="files" multiple/>

                        </div>
                        <button type="submit" class="btn btn-info">Submit</button>


                    </mvc:form>
                </div>
                <div class="col-sm-4">
                </div>
            </div>


        </div>
    </body>
</html>
