<%-- 
    Document   : ModificarServicio
    Created on : 20-05-2018, 16:33:46
    Author     : lmerino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <jsp:useBean id="servicioController" class="Controller.ServicioController"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <main>
            <h1>MODIFICAR SERVICIO</h1>
            <form action="/LindaSonrisa/modificarServicio" method="POST">
                <section class="content">
                    <table border="0">
                <tbody>                   
                    <tr>
                        <td>NOMBRE SERVICIO</td>
                        <td><select name="cmbServicio">
                                <c:forEach var="servicio" items="${servicioController.listarServicios()}">
                                    <option><c:out value="${servicio}"/></option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="txtPrecio" placeholder="$0" value="" required="" /></td>
                    </tr>
                    <tr>
                        <td>Modulos</td>
                        <td><select name="cmbModulo">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Disponible</td>
                        <td>Sí<input type="radio" name="rdDisponible" value="1" checked="" />No<input type="radio" name="rdDisponible" value="0" /></td>                   
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Modificar" name="btnModificar" />
        </section>
        </form>
         
    </main>
    </body>
</html>
