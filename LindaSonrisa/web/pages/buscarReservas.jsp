<%-- 
    Document   : buscarReservas
    Created on : 22-05-2018, 21:41:52
    Author     : hozonov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Reservas</title>
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/frame_style.css">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
                
                <!-- MODULOS AQUÍ -->
                
            </aside>
            <section class="content">

                <form action="/LindaSonrisa/listarReservasSecretaria" method="POST" name="fetchListaReservas">
                    <table border="0">
                        <tbody>
                            <tr>
                                <td>Ingrese Rut del Cliente</td>
                                <td><input type="text" name="txtRutCliente" value="" /></td>
                                <td><input type="submit" value="Buscar Reservas" name="btnBuscar" /></td>
                            </tr>
                        </tbody>
                    </table>

                </form>
                <c:if test="${listaReservas!=null}">
                    <ul class="lista">
                        <c:forEach var="reserva" items="${listaReservas}">
                            <form action="/LindaSonrisa/detalleReserva" method="POST">
                                <li class="lista-item">
                                    <span class="codigo">Reserva N°<c:out value="${reserva.getId()}"/></span>
                                    <input type="hidden" name="txtCodigoReserva" value="<c:out value="${reserva.getId()}"/>" />
                                    <input class="btnVer" type="submit" value="Ver" />
                                </li>    
                            </form>
                        </c:forEach>
                    </ul>
                </c:if>
                
            </section>
        </main>
    </body>
</html>
