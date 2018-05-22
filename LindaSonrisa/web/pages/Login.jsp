<%-- 
    Document   : Login
    Created on : 08-may-2018, 10:24:56
    Author     : CETECOM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>        
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">        
        <link rel="stylesheet" href="/LindaSonrisa/css/login.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div class="container">                  
        <div class="card card-container">
            <h3 class="tituloini">Iniciar sesion</h3>  
            <div class="form-signin">
                <form action="/LindaSonrisa/login" method="POST">
                
                <br>
                <span>Usuario</span>
                <input type="text" id="inputEmail" class="form-control" name="txtUsuario" placeholder="Ingrese su Nombre de Usuario" autofocus>
                <br>
                <span>Contraseña</span>
                <input type="password" id="inputPassword" class="form-control" name="txtContrasena" placeholder="Ingrese su Contraseña">
                <a href="#" class="forgot-password">¿Haz olvidado tu contraseña</a>
                <br>              
              
                <button class="btn btn-primary " name="action" value="login" type="submit">Entrar</button> 
                
                <button class="btn btn-warning " name="action" value="signin" type="submit">Registrate</button>
                </form>
            </div><!-- /form -->            
        </div><!-- /card-container -->
    </div><!-- /container --> 
    <c:if test="${mensaje!=null}">
        <script>alert("${mensaje}");</script>
    </c:if>
    <c:if test="${usuario!=null}">
        <c:redirect url="${home}"/>
    </c:if>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </body>
</html>
