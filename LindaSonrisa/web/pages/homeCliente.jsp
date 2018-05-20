<%-- 
    Document   : homeCliente
    Created on : 19-05-2018, 22:59:04
    Author     : hozonov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Cliente</title>
        <link rel="stylesheet" type="text/css" href="../css/normalize.css">
        <link rel="stylesheet" type="text/css" href="../css/frame_style.css">
    </head>
    <body>
        <nav class="nav">
            <figure class="logo">
                <img class="logo-img" src="../images/logo_blanco.png">
            </figure>
            <div class="user">
                <span class="user-name">Cliente</span>
                 <span ><a class="user-logout" href="#">Cerrar Sesión</a></span>                  
            </div>                
        </nav>
        <main class="main">
            <aside class="side">
                <div class="module">
                    <div class="module-title">
                        <span>Mi Perfil</span>
                    </div>
                    <ul class="module-content">  
                        <li class="module-option"><a class="link" href="#">Mi información</a></li>                      
                        <li class="module-option"><a class="link" href="#">Modificar Información personal</a></li>              
                        <li class="module-option"><a class="link" href="#">Recuperar Contraseña</a></li>
                        <li class="module-option"><a class="link" href="#">Modificar Informacion Socioeconomica</a></li>
                    </ul>
                </div>
                <div class="module">
                    <div class="module-title">
                        <span>Reservas</span>
                    </div>
                    <ul class="module-content">  
                        <li class="module-option"><a class="link" href="#">Reservar Hora</a></li>                      
                        <li class="module-option"><a class="link" href="#">Ver Reservas Pedidas</a></li>
                        <li class="module-option"><a class="link" href="#">Ver Boletas de Servicios</a></li>
                    </ul>
                </div>
            </aside>
            <section class="content">

                <!-- CONTENIDO AQUÍ -->
                <h1>Bienvenido Cliente</h1>
            </section>
        </main>
    </body>
</html>
