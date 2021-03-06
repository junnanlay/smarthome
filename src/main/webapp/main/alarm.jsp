<%-- 
    Document   : alarm
    Created on : Jan 2, 2020, 10:31:34 PM
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
        <link rel="stylesheet" href="../css/alarm.css">

    </head>
    <body>
        <div class="col-md-6 text-center alarm-content col-md-offset-2">
            <h3>${param.deviceName}</h3>
            <img class="alarm-image" src="../img/alarm.png" />
            <c:set var = "status" scope = "session" value = "${param.deviceStatus}"/>
            <c:if test = "${status > 0}">
                <p><b>Status: <span style="color:green">On</span></b></p>
            </c:if>
            <c:if test = "${status < 1}">
                <p><b>Status: <span style="color:#FF0000">Off</span></b></p>
            </c:if>
        </div>
    </body>
</html>
