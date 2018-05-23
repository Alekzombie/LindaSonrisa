<%-- 
    Document   : detalleReservaSec
    Created on : 22-05-2018, 22:07:00
    Author     : hozonov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle Reserva</title>
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/frame_style.css">
    </head>
    <body>
        <nav class="nav">
            <figure class="logo">
                <img class="logo-img" src="/LindaSonrisa/images/logo_blanco.png">
            </figure>
            <div class="user">
                <span class="user-name"></span>
                <form action="/LindaSonrisa/logout" method="POST">
                    <input type="submit" class="user-logout" value="Cerrar Sesión"/>
                </form>                
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
                    </ul>
                </div>
                <div class="module">
                    <div class="module-title">
                        <span>Reservas</span>
                    </div>
                    <ul class="module-content">                        
                        <li class="module-option"><a class="link" ref="#">Reservar Hora Cliente</a></li>
                        <li class="module-option"><a class="link" href="#">Confirmar o Anular Reservas</a></li>
                        <li class="module-option"><a class="link" href="#">Registrar Pago de Consulta</a></li>
                        <li class="module-option"><a class="link" href="#">Ver Boletas de Servicios</a></li>
                    </ul>
                </div>
                <div class="module">
                    <div class="module-title">
                        <span>Pedidos</span>
                    </div>
                    <ul class="module-content">                        
                        <li class="module-option"><a class="link" href="#">Realizar Pedido</a></li>
                        <li class="module-option"><a class="link" href="#">Recepcionar Pedido</a></li>
                        <li class="module-option"><a class="link" href="#">Cambiar Estado de Pedido</a></li>
                        <li class="module-option"><a class="link" href="#">Registrar Producto</a></li>
                    </ul>
                </div>
            </aside>
            <section class="content">

                <section class="reserva">
                    <h2 class="reserva-codigo">
                        <c:out value="${reservaCodigo}"/>
                    </h2>
                    <article class="reserva-detalles">
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>Nombre Paciente</td>
                                    <td><c:out value="${reservaNombreCliente}"/></td>
                                </tr>
                                <tr>
                                    <td>Rut Paciente</td>
                                    <td><c:out value="${reservaRutCliente}"/></td>
                                </tr>
                                <tr>
                                    <td>Fecha Reservada</td>
                                    <td><c:out value="${reservaFecha}"/></td>
                                </tr>
                                <tr>
                                    <td>Hora Inicio</td>
                                    <td><c:out value="${reservaHora}"/></td>
                                </tr>
                                <tr>
                                    <td>Médico</td>
                                    <td><c:out value="${reservaEmpleado}"/></td>
                                </tr>
                                <tr>
                                    <td>Dirección Consulta</td>
                                    <td>Av. Las Palmas #125</td>
                                </tr>
                            </tbody>
                        </table>

                    </article>
                </section>
                
            </section>
    </body>
</html>
