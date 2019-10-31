<%-- 
    Document   : component
    Created on : 2019-okt-28, 14:34:45
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/component.css">
         </head>
    <body>
        <div class="container">
            <div id="card" class="card" onclick="glow()">
            <div class="card-block">
                <div class="outer">
                    <img src="../img/lampis3.png" height="120px" width="120px">
                </div>
                <div class="card-title"><h3>${param.deviceName}</h3></div>
                <div class="card-text">${param.deviceStatus} </div>
                
            </div>
            </div>
            
            
            
            
            <form action="../Deviceservlet" method="POST">
                <input type="hidden" name="deviceName" value="${param.deviceName}">
                <input type="hidden" name="deviceStatus" value="${param.deviceStatus}">
                <input type="hidden" name="deviceId" value="${param.deviceId}">
                <input type="submit" name="deviceBtn" value="off">
                <input type="submit" name="deviceBtn" value="on">
            </form>
                
        </div>
             
         
    </body>
</html>
