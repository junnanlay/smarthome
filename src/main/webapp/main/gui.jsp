<%-- 
    Document   : gui
    Created on : Oct 16, 2019, 5:16:20 PM
    Author     : jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>light GUI</title>
    <link rel="stylesheet" href="../css/gui.css">
    
</head>
<body>
    <c:forEach var="current" items="${sessionScope.bean.device}" >
        <div>
            <jsp:include page="component.jsp" >
                <jsp:param name="deviceStatus" value="${current.deviceStatus}" />
                <jsp:param name="deviceName" value="${current.deviceName}" />
                <jsp:param name="deviceId" value="${current.deviceId}" />
            </jsp:include>
        </div>
    </c:forEach>
    
</body>
</html>