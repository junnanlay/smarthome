<%-- 
    Document   : temperature
    Created on : Jan 2, 2020, 10:31:44 PM
    Author     : jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/temperature.css">
    </head>
    <body>
        <div class="col-md-6 text-center temp-content col-md-offset-2">
            <h3>${param.deviceName}</h3>
            <img class="temp-image" src="../img/temp.png" />
            <p><b>Temperature: ${param.deviceStatus}</b></p>
        </div>
    </body>
</html>
