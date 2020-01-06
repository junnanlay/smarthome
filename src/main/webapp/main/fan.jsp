<%-- 
    Document   : fan
    Created on : Jan 2, 2020, 10:24:26 PM
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
        <link rel="stylesheet" href="../css/fan.css">
    </head>
    <body>
        <div class="col-md-6 text-center fan-content col-md-offset-2">
            <h3>${param.deviceName}</h3>
            <img class="fan-image" src="../img/fan.png" />
            <c:set var = "status" scope = "session" value = "${param.deviceStatus}"/>
            <c:if test = "${status > 0}">
                <p><b>Status: <span style="color:green">On</span></b></p>
            </c:if>
            <c:if test = "${status < 1}">
                <p><b>Status: <span style="color:red">Off</span></b></p>
            </c:if>
            <form action="../Fanservlet" method="POST">
                <input type="hidden" name="deviceName" value="${param.deviceName}">
                <input type="hidden" name="deviceStatus" value="${param.deviceStatus}">
                <input type="hidden" name="deviceId" value="${param.deviceId}">
                <input type="hidden" name="roomId" value="${param.roomId}">
                <input type="range" name="fanInputName" id="fanInputId" value="${param.deviceStatus}" min="0" max="255" oninput="fanOutputId.value = fanInputId.value">
                <output name="fanOutputName" id="fanOutputId">${param.deviceStatus}</output>
                <br />
                <input type="submit" class="btn btn-secondary" value="Update">
            </form>
        </div>
    </body>
</html>