<%-- 
    Document   : component
    Created on : 2019-okt-28, 14:34:45
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/component.css">
    </head>
    <body>
        <div class="col-md-6 text-center lamp-content col-md-offset-2">
            <h3>${param.deviceName}</h3>
            <c:set var = "status" scope = "session" value = "${param.deviceStatus}"/>
            <c:if test = "${status > 0}">
                <img class="lamp-image" src="../img/lampis2.png" />
                <p><b>Status: <span style="color:green">On</span></b></p>

            </c:if>
            <c:if test = "${status < 1}">
                <img class="lamp-image" src="../img/lampis.png" />
                <p><b>Status: <span style="color:red">Off</span></b></p>
            </c:if>
            <form action="../Deviceservlet" method="POST">
                <input type="hidden" name="deviceName" value="${param.deviceName}">
                <input type="hidden" name="deviceStatus" value="${param.deviceStatus}">
                <input type="hidden" name="deviceId" value="${param.deviceId}">
                <input type="hidden" name="roomId" value="${param.roomId}">
                <input type="submit" class="btn btn-secondary" value="On/Off">
            </form>
        </div>
    </body>
</html>
