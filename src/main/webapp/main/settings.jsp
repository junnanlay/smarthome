<%-- 
    Document   : settings
    Created on : Nov 21, 2019, 5:15:09 PM
    Author     : jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/settings.css">
        <script src="https://use.fontawesome.com/releases/v5.11.2/js/all.js" data-auto-replace-svg="nest"></script>
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
                                <a class="dropdown-item" href="#">Settings</a>
                                <a class="dropdown-item" href="#">Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container text-center">
            <h1 class="mt-5 text-white font-weight-light">Welcome to settings page my friend</h1>
            <p class="lead text-white-50">In here you can update your password and add new users to your house :)</p>       
        </div>
        <br>
        <br>
        <br>
        <div class="container text-center">
            <div class="row">
                <div class="col-md-6">
                    <p class="lead text-white-50"> Enter old password and choose a new one to update it :) </p>
                    <form method="post" action="../Passwordservlet">
                        <div class="form-group">
                            <input class="form-control" type="password" name="old_password" placeholder="Old password" > 
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" name="new_password" placeholder="New password"> 
                        </div>
                        <div class="form-group">
                            <button class="btn btn-dark btn-block" type="submit">Change password</button>
                        </div>
                    </form>
                </div>

                <div class="col-md-6">
                    <p class="lead text-white-50"> Enter the information of user to add to the house :) </p>
                    <form method="post" action="../AddUserServlet">
                        <div class="form-group">
                            <input class="form-control" type="email" name="email" placeholder="Email" > 
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="firstname" placeholder="Firstname" > 
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="lastname" placeholder="Lastname" > 
                        </div>
                        <div class="form-group">
                            <button class="btn btn-dark btn-block" type="submit">Add user</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

