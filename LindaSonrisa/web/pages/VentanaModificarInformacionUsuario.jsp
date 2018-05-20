<%-- 
    Document   : VentanaModificarInformacionUsuario
    Created on : 17-05-2018, 11:23:35
    Author     : lmerino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <jsp:useBean id="comunaController" class="Controller.ComunaController"/>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Información</title>
        <link rel="stylesheet" type="text/css" href="../css/normalize.css">
        <link rel="stylesheet" type="text/css" href="../css/frame_style.css">
        
      
    </head>
    <body>
        <h1>MODIFICAR INFORMACION USUARIO</h1>
        <form action="../modificarInfoUsuario" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>CANTIDAD CARGAS</td>
                        <td><input type="text" name="txtCargas" value="" /></td>
                    </tr>
                    <tr>
                        <td>CORREO</td>
                        <td><input type="text" name="txtCorreo" value="" /></td>
                    </tr>
                    <tr>
                        <td>TELEFONO FIJO</td>
                        <td><input type="text" name="txtTelefonoFijo" value="" /></td>
                    </tr>
                    <tr>
                        <td>TELEFONO MOVIL</td>
                        <td><input type="text" name="txtTelefonoMovil" value="" /></td>
                    </tr>
                    <tr>
                        <td>NOMBRE CALLE</td>
                        <td><input type="text" name="txtNombreCalle" value="" /></td>
                    </tr>
                    <tr>
                        <td>NRO CALLE</td>
                        <td><input type="text" name="txtNroCalle" value="" /></td>
                    </tr>
                    <tr>
                        <td>TIPO VIVIENDA</td>
                        <td>Casa<input type="radio" name="rdTipoVivienda" value="0" checked="checked" />
                            Departamento<input type="radio" name="rdTipoVivienda" value="1" /></td>
                    </tr>
                    <tr>
                        <td>NRO DEPARTAMENTO</td>
                        <td><input type="text" name="txtNroDepto" value="" /></td>
                    </tr>
                    <tr>
                        <td>COMUNA</td>
                        <td><select name="cmbComuna">
                                <c:forEach var="comuna" items="${comunaController.listarComunas()}">
                                    <option><c:out value="${comuna}"/></option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td>RUT</td>
                        <td><input type="text" name="txtRut" value="" /></td>
                    </tr>
                </tbody>
            </table>

            <input type="submit" value="GRABAR" name="btnGrabar" />
        </form>
    </body>
</html>
