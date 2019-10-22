<%-- 
    Document   : login
    Created on : 2019-okt-01, 16:04:17
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <script src="https://use.fontawesome.com/releases/v5.11.2/js/all.js" data-auto-replace-svg="nest"></script>
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,600&display=swap" rel="stylesheet">

        <title>Login</title>
    </head>
    <body>
                
        <img class="wave" src="img/wave.png">
        <div class="container">
            <div class="img">
                <img src="img/ipad.svg">
            </div>
            <div class="login-content">
		<form action="Loginservlet" method="post">
                    <img src="img/logo.png">
                    <h2 class="title">Smarthouse</h2>
                    <div class="input-div one">
                        <div class="i">
           		   <i class="fas fa-user"></i>
           		</div>
                        <div class="div">
                            <h5>Username</h5>
                            <input type="email" class="input" name="email" required>
           		</div>
                    </div>
                    <div class="input-div pass">
                        <div class="i"> 
           		    <i class="fas fa-lock"></i>
                        </div>
           		<div class="div">
           		    <h5>Password</h5>
           		    <input type="password" class="input" name="password" required >
                        </div>
                    </div>
                    <input type="submit" class="btn" value="Login">
                    <a href="#">Already have an account? Sign in</a>
                    <a href="#">Forgot Password?</a>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
