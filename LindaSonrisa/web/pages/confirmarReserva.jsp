<%-- 
    Document   : confirmarReserva
    Created on : 22-05-2018, 22:25:14
    Author     : hozonov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                
            </aside>
            <section class="content">

                <section class="reserva">
                    <form action="/LindaSonrisa/confirmarAnularReserva" method="POST">
                    
                    <h2 class="reserva-codigo">
                        <c:out value="${reservaCodigo}"/><input type="hidden" name="txtCodigoReserva" value="<c:out value="${reservaCodigo}"/>" />
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
                        <button name="action" value="confirmar" type="submit">Confirmar</button> 
                        <button name="action" value="anular" type="submit">Anular</button>
                    </article>
                    </form>
                </section>
                
            </section>
    </body>
</html>

