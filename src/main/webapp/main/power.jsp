<%-- 
    Document   : power
    Created on : Jan 2, 2020, 11:08:44 PM
    Author     : jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/power.css">
        
    </head>
    <body>
        <div class="col-md-6 text-center power-content col-md-offset-2">
            <h3>${param.deviceName}</h3>
            <img class="power-image" src="../img/power.png" />
            <c:set var = "status" scope = "session" value = "${param.deviceStatus}"/>
            <c:if test = "${status > 0}">
                <p><b>Status: <span style="color:green">On</span></b></p>
            </c:if>
            <c:if test = "${status < 1}">
                <p><b>Status: <span style="color:green">Off</span></b></p>
            </c:if>
        </div>

    </body>
</html>
