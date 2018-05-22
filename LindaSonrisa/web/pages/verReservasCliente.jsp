<%-- 
    Document   : verReservasCliente
    Created on : 21-05-2018, 14:08:18
    Author     : hozonov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="reservaController" class="Controller.ReservaController"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/frame_style.css">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/verReservasClienteStyle.css">
        <title>Ver Reservas Cliente</title>
        <%--Comprobar usuario --%>
        <c:if test="${usuario==null}">
            <c:redirect url="/pages/Login.jsp" />
        </c:if>
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
                        <li class="module-option"><a class="link" href="#">Modificar Informacion Socioeconomica</a></li>
                    </ul>
                </div>
                <div class="module">
                    <div class="module-title">
                        <span>Reservas</span>
                    </div>
                    <ul class="module-content">  
                        <li class="module-option"><a class="link" href="#">Reservar Hora</a></li>                      
                        <li class="module-option"><a class="link" href="/LindaSonrisa/pages/verReservasCliente.jsp">Ver Reservas Pedidas</a></li>
                        <li class="module-option"><a class="link" href="#">Ver Boletas de Servicios</a></li>
                    </ul>
                </div>
            </aside>
            <section class="content">

                <form action="/LindaSonrisa/listarReservasCliente" method="POST" name="fetchListaReservas">
                    
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
        <c:if test="${listaReservas==null}">
            <script>
                window.onload = function(){
                    document.forms['fetchListaReservas'].submit();
                }
            </script>
        </c:if>
        
    </body>
</html>
