<%-- 
    Document   : cart
    Created on : Oct 15, 2021, 10:11:01 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="col-sm-8 table-responsive pt-2">
                    <table class="table table-bordered table-sm table-re">
                        <thead class="thead-light text-center">
                            <tr>  
                                <th>Name</th>
                                
                                <th>Price</th>
                                <th >Color</th>
                                <th>Size</th>
                                <th>Quantity</th>
                                <th >Unit price</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody class="text-center">
                            <c:forEach items="${cart}" var="c">                                
                                <tr>
                                    <td>${c.productEntity.name}</td>
                                    <td>${c.colorEntity.color}</td>
                                    <td>${c.sizeEntity.size}</td>
                                    <td>${c.price*c.quantity}</td>
                                    
                                    
                            </tr>
                        </c:forEach>
                        
                        </tbody>
                    </table>
                    
    </body>
</html>
