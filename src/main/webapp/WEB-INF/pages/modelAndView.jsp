<%-- 
    Document   : modelAndView
    Created on : Sep 15, 2021, 10:55:50 AM
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
        <h1>${infor}</h1>
        <h2><a href="<c:url value="/home"/>">Home</a></h2>
    </body>
</html>
