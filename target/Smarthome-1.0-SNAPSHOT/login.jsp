<%-- 
    Document   : login
    Created on : 2019-okt-01, 16:04:17
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <script src="https://use.fontawesome.com/releases/v5.11.2/js/all.js" data-auto-replace-svg="nest"></script>
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
                
       <div class="login-dark h-100">
            <form action="Loginservlet" method="post">
                <h2>Smarthouse</h2>
                <div class="illustration">
                    <img src="img/logo_1.png">
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="Email" > 
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="Password"> 
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">Log In </button>
                </div>
                <a class="forgot" href="#"> Forgot your password?</a>
            </form>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
