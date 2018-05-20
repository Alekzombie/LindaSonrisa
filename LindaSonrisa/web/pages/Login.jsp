<%-- 
    Document   : Login
    Created on : 08-may-2018, 10:24:56
    Author     : CETECOM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="LindaSonrisa\LindaSonrisa\web\css\login.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div class="container">                  
        <div class="card card-container">
            <h3 class="tituloini">Iniciar sesion</h3>  
            <div class="form-signin">
                <br>
                <span>Usuario</span>
                <input type="email" id="inputEmail" class="form-control" placeholder="Rut" required autofocus>
                <br>
                <span>Contraseña</span>
                <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
                <a href="#" class="forgot-password">¿Haz olvidado tu contraseña</a>
                <br>
                <div class="btns">
                <button class="btn btn-warning " type="submit">Registrate</button>
              
                <button class="btn btn-primary " type="submit">Entrar</button>               
                </div>
            </div><!-- /form -->            
        </div><!-- /card-container -->
    </div><!-- /container --> 
    </body>
</html>
