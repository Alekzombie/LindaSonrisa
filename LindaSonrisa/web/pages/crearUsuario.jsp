<%-- 
    Document   : crearUsuario
    Created on : 20-05-2018, 14:30:10
    Author     : hozonov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="comunaController" class="Controller.ComunaController"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/frame_style.css">
        <link rel="stylesheet" type="text/css" href="/LindaSonrisa/css/crearUsuarioStyle.css">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    </head>
    <body>
        <nav class="nav">
            <figure class="logo">
                <img class="logo-img" src="../images/logo_blanco.png">
            </figure>              
        </nav>
        <main class="main">
            <aside class="side">
                
                <!-- MODULOS AQUÍ -->
                
            </aside>
            <section class="content">
                <form action="/LindaSonrisa/crearUsuario" method="POST">
                
                    <article class="content-row">
                        <table border="0">
                            <thead>
                                <tr>
                                    <th class="title">Personal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>*Rut</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtRut" value="" placeholder="12345678-9" required="" /></td>
                                </tr>
                                <tr>
                                    <td>*Nombre(s)</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtNombre" value="" required="" /></td>
                                </tr>
                                <tr>
                                    <td>*Apellido Paterno</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtPaterno" value="" required="" /></td>
                                </tr>
                                <tr>
                                    <td>*Apellido Materno</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtMaterno" value="" required="" /></td>
                                </tr>
                                <tr>
                                    <td>*Fecha Nacimiento</td>
                                </tr>
                                <tr>
                                    <td><input type="date" name="calFechaNacimiento" value="" required="" /></td>
                                </tr>
                            </tbody>
                        </table>
                        <table border="0">
                            <thead>
                                <tr>
                                    <th class="title">Domicilio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Calle/Avenida/Pasaje</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtDireccion" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Número</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtNroCasa" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Número Depto.</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtNroDepto" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Comuna</td>
                                </tr>
                                <tr>
                                    <td>
                                        <select name="cmbComuna">
                                            <c:forEach var="comuna" items="${comunaController.listarComunas()}">
                                                <option><c:out value="${comuna}"/></option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
<!--                                <tr>
                                    <td>Región</td>
                                </tr>
                                <tr>
                                    <td>
                                        <select name="cmbRegion">
                                            <option>opcion</option>        
                                        </select>
                                    </td>
                                </tr>-->
                            </tbody>
                        </table>
                    </article>
                    <article class="content-row">
                        <table border="0">
                            <thead>
                                <tr>
                                    <th class="title">Contacto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>*Mail</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtMail" value="" required="" /></td>
                                </tr>
                                <tr>
                                    <td>Teléfono Fijo</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtTelefonoFijo" value="" /></td>
                                </tr>
                                <tr>
                                    <td>*Teléfono Movil</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtTelefonoMovil" value="" required="" /></td>
                                </tr>
                            </tbody>
                        </table>
                        <table border="0">
                            <thead>
                                <tr>
                                    <th class="title">Perfil</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>*Nombre de Usuario(sin espacios)</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtUsuario" value="" required="" /></td>
                                </tr>
                                <tr>
                                    <td>*Contraseña</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtContraseña" value="" required="" /></td>
                                </tr>
                                <tr>
                                    <td>*Ingresa otra vez tu Contraseña</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="txtContraseñaRepetida" value="" required="" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </article>
                    <article class="content-row last">
                            <span>Los * indican campos obligatorios.</span>
                            <span>Revisa que los campos obligatorios tengan la información requerida antes de continuar.</span>
                            <input class="button" type="submit" value="Registrar" name="btnRegistrar" class="btn btn-primary" />                    
                    </article>
                </form>
            </section> 
        </main>
    </body>
</html>
