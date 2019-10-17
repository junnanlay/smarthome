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
    <link rel="stylesheet" href="css/gui.css">
</head>
<body>
    <div class="box">
        <center>
            <div id="value"></div>
        </center>
    </div>
    <div onclick="clickis()" class="container">
        <input type="range" min="0" max="100" value="50" class="slider" id="slider">
    </div>

    
    <img id="myImage" src="img/lampis.png">
    <c:out value="${sessionScope.Content}" />
    
    <script type="text/javascript">
        var slider = document.getElementById("slider");
        var val = document.getElementById("value");
        val.innerHTML=slider.value;
        slider.oninput=function(){
            val.innerHTML=this.value;
        }
        
    function clickis(){
        if(val.innerHTML==100){
            document.getElementById("myImage").src="img/lampis2.png";
        }
        else if(val.innerHTML==0){
            document.getElementById("myImage").src="img/lampis.png";
        }
       
    }
    </script>



    

    
</body>
</html>