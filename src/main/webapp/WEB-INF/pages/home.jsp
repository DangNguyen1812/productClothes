<%-- 
    Document   : home
    Created on : Sep 15, 2021, 10:13:40 AM
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

        <h2><a href="<c:url value="/modelAndView"/>">ModelAndView</a></h2>
        <h2><a href="<c:url value="/products"/>">List products</a></h2>
        <h2><a href="<c:url value="/requestParam?name=Dang Nguyen&age=18&country=VN"/>">Request Param</a></h2>
        <h2><a href="<c:url value="/pathVariable/Dang Nguyen/18/VN"/>">Path Veriable</a></h2>

    </body>
</html>
