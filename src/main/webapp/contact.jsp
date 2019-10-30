<%-- 
    Document   : contact
    Created on : 2019-okt-29, 14:27:46
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="navbar.jsp" ></jsp:include>
        <div class="row justify-content-md-center">
            <div class="card" style="width: 18rem;">
                <img src="img/avatar2.svg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h2>Jun Erik Lay</h2>
                    <p>Webmaster</p>
                    <p>Contact: <a href="mailto:@jun@smarthouse.com">jun@smarthouse.com</a></p>
                </div>
            </div>
            
            <div class="card" style="width: 18rem;">
                <img src="img/avatar2.svg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h2>Jonny Lay</h2>
                    <p>Lead designer</p>
                    <p>Contact: <a href="mailto:@jonny@smarthouse.com">jonny@smarthouse.com</a></p>
                </div>
            </div>
        </div>
    </body>
</html>
