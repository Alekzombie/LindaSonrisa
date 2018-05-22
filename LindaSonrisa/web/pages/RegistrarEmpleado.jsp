<%-- 
    Document   : RegistrarEmpleado
    Created on : 20-05-2018, 17:36:21
    Author     : lmerino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/normalize.css">
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
                width: 300px;
            }

            th, td {
                padding: 4px;
            }
        </style>
    </head>
    <body>
        <main>
            <form action="/LindaSonrisa/agregarEmpleado" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>RUT</td>
                            <td><input type="text" name="txtRut" value="" /></td>
                        </tr>
                        <tr>
                            <td>NOMBRE(S)</td>
                            <td><input type="text" name="txtNombre" value="" /></td>
                        </tr>
                        <tr>
                            <td>APELLIDO PATERNO</td>
                            <td><input type="text" name="txtPaterno" value="" /></td>
                        </tr>
                        <tr>
                            <td>APELLIDO MATERNO</td>
                            <td><input type="text" name="txtMaterno" value="" /></td>
                        </tr>
                        <tr>
                            <td>FECHA DE NACIMIENTO</td>
                            <td><input type="date" name="calFechaNacimiento" value="" /></td>
                        </tr>
                        <tr>
                            <td>CANTIDAD DE CARGAS</td>
                            <td><input type="number" min="1" name="txtCargas" value="" /></td>
                        </tr>
                        <tr>
                            <td>NOMBRE DE USUARIO</td>
                            <td><input type="text" name="txtNombreUsuario" value="" /></td>
                        </tr>
                        <tr>
                            <td>PASSWORD</td>
                            <td><input type="text" name="txtPassword" value="" /></td>
                        </tr>
                        <tr>
                            <td>TIPO USUARIO</td>
                            <td><select name="SS_TipoUsuario">
                                    <option>ADMIN</option>
                                    <option>SCTR</option>
                                    <option>CLT</option>
                                    <option>MDC</option>
                                </select></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Registrar" name="btnRegistrar" />
            </form>      
        </main>
    </body>
</html>
