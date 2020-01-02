<%-- 
    Document   : fan
    Created on : Jan 2, 2020, 10:24:26 PM
    Author     : jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/fan.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </head>
    <body>
        
       
        <div class="container2">
            
            <div id="card" class="card" >
                
                <form id="deviceForm" class="formis" action="../Deviceservlet" method="POST">
                <input type="hidden" name="deviceName" value="${param.deviceName}">
                <input type="hidden" name="deviceStatus" value="${param.deviceStatus}">
                <input type="hidden" name="deviceId" value="${param.deviceId}">
                 <input type="hidden" name="roomId" value="${param.roomId}">
                <input type="submit" class="btn btn-secondary" value="On/Off">
               
            </form>
                
                <div class="card-block">
                    <div class="outer">
                        <img src="../img/fan.png" height="120px" width="120px">
                    </div>
                    <div class="card-title"><h3>${param.deviceName}</h3></div>
                    <div class="card-text">${param.deviceStatus} </div>

                </div>
            </div>




           

        </div>

      


    </body>
</html>