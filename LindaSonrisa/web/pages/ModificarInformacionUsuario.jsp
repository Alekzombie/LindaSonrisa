<%-- 
    Document   : ModificarInformacionUsuario
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
        <link rel="stylesheet" type="text/css" href="css/style_plantilla.css">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            table, td, th {    
                text-align: left;
                font-size: 12px;
            }

            table {
                border-collapse: collapse;
                width: 500px;
            }

            th, td {
                padding: 4px;
            }
        </style>
    </head>
    <body>
        <main>
            <form action="/LindaSonrisa/modificarInfoUsuario" method="POST">
                <section class="content">
                    <table  cellspacing="8">
                        <tbody>
                            <tr>
                                <td style="color: #0cc; text-align: center;">Personal</td>
                                <td style="color: #0cc; text-align: center;">Domicilio</td>
                            </tr>
                            <tr>
                                <td>*Rut</td>
                                <td>Region</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="txtRut" value="" placeholder="1111111-1" required=""/></td>
                                <td><select name="cmbRegion">
                                        <option>RM</option>        
                                    </select></td>
                            </tr>
                            <tr>
                                <td>*Nombre(s)</td>
                                <td>Comuna</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="txtNombre" value="" required="" disabled /></td>
                                <td><select name="cmbComuna">
                                        <c:forEach var="comuna" items="${comunaController.listarComunas()}">
                                            <option><c:out value="${comuna}"/></option>
                                        </c:forEach>    
                                    </select></td>
                            </tr>
                            <tr>
                                <td>*Apellido Paterno</td>
                                <td>N° Calle</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="txtPaterno" value="" required="" disabled /></td>
                                <td><input type="text" name="txtNroCalle" value="" /></td>
                            </tr>
                            <tr>
                                <td>*Apellido Materno</td>
                                <td>Nro depto</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="txtMaterno" value="" required="" disabled /></td>
                                <td><input type="text" name="txtNroDepto" value="" /></td>
                            </tr>
                            <tr>
                                <td>*Fecha Nacimiento</td>
                                <td>Tipo Vivienda</td>
                            </tr>
                            <tr>
                                <td><input type="date" name="calFechaNacimiento" value="" required="" disabled /></td>
                                <td>Casa<input type="radio" name="rdTipoVivienda" value="1" />Depto.<input type="radio" name="rdTipoVivienda" value="0" /></td>
                            </tr>
                            <tr>
                                <td style="color: #0cc; text-align: center;">Contacto</td>
                                <td>Los * indican campos obligatorios</td>
                            </tr>
                            <tr>
                                <td>*Mail</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="txtMail" value="" required="" /></td>
                            </tr>
                            <tr>
                                <td>Teléfono Fijo</td>
                                <td>Ingrese su Contraseña Para Confirmar Cambios</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="txtTelefonoFijo" value="" /></td>
                                <td><input type="text" name="txtContraseña" value="" placeholder="******" /></td>
                            </tr>
                            <tr>
                                <td>*Teléfono Movil</td>

                            </tr>
                            <tr>
                                <td><input type="text" name="txtTelefonoMovil" value="" required="" /></td>
                                <td><input type="submit" value="Guardar Cambios" name="btnRegistrar" /></td>
                            </tr>
                        </tbody>
                    </table>
                </section> 
            </form>
        </main>
    </body>
</html>
