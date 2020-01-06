<%-- 
    Document   : gui2
    Created on : 2020-jan-03, 18:07:22
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Smarthouse</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Options
                            </a>
                            <!-- Here's the magic. Add the .animate and .slide-in classes to your .dropdown-menu and you're all set! -->
                            <div class="dropdown-menu dropdown-menu-right animate slideIn" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="settings.jsp">Settings</a>
                                <a class="dropdown-item" href="../index.jsp">Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">

            <div class="row">

                <div class="col-md-6 text-center">
                    <h1>UPDATABLE DEVICES</h1>
                    <div class="container">
                        <div class="row">
                            <c:forEach var="item" items="${sessionScope.devicebean}">

                                <c:set var = "theString" value = "${item.deviceName}"/>
                                <c:set var = "lampString" value = 'lamp'/>


                                <c:if test = "${fn:containsIgnoreCase(theString, 'lamp')}">  
                                    <jsp:include page="component.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                                <c:if test = "${fn:containsIgnoreCase(theString, 'radiator')}">  
                                    <jsp:include page="radiator.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                                <c:if test = "${fn:containsIgnoreCase(theString, 'fan')}">  
                                    <jsp:include page="fan.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                                <c:if test = "${fn:containsIgnoreCase(theString, 'timer')}">  
                                    <jsp:include page="timer.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>

                </div>
                <div class="col-md-6 text-center">
                    <h1>ALL DEVICES IN THE HOUSE</h1>
                    <div class="container">
                        <div class="row">
                            <c:forEach var="item" items="${sessionScope.devicebean}">

                                <c:set var = "theString" value = "${item.deviceName}"/>
                                <c:set var = "lampString" value = 'lamp'/>

                                <c:if test = "${fn:containsIgnoreCase(theString, 'waterleak')}">  
                                    <jsp:include page="waterleak.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if><c:if test = "${fn:containsIgnoreCase(theString, 'sensor')}">  
                                    <jsp:include page="lightsensor.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                                <c:if test = "${fn:containsIgnoreCase(theString, 'temp')}">  
                                    <jsp:include page="temperature.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                                <c:if test = "${fn:containsIgnoreCase(theString, 'alarm')}">  
                                    <jsp:include page="alarm.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                                <c:if test = "${fn:containsIgnoreCase(theString, 'power')}">  
                                    <jsp:include page="power.jsp" >
                                        <jsp:param name="deviceStatus" value="${item.deviceStatus}" />
                                        <jsp:param name="deviceName" value="${item.deviceName}" />
                                        <jsp:param name="deviceId" value="${item.deviceId}" />
                                        <jsp:param name="roomId" value="${item.roomId}" />
                                    </jsp:include>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
