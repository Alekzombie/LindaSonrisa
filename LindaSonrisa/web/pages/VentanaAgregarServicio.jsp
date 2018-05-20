<%-- 
    Document   : VentanaAgregarEmpleado
    Created on : 16-05-2018, 20:21:52
    Author     : lmerino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Nuevo Servicio</title>
        <link rel="stylesheet" type="text/css" href="../css/normalize.css">
        <link rel="stylesheet" type="text/css" href="../css/frame_style.css">
    </head>
    <body>
        <h1>AGREGAR NUEVO SERVICIO</h1>
        <form action="../agregarServicio" method="POST">
            <table border="0">
                <tbody>
                   <tr>
                        <td>Id</td>
                        <td><input type="text" name="txtId" value="" /></td>
                    </tr>
                    <tr>
                        <td>DESCRIPCION SERVICIO</td>
                        <td><input type="text" name="txtDescripcion" value="" /></td>
                    </tr>
                    <tr>
                        <td>PRECIO SERVICIO</td>
                        <td><input type="text" name="txtPrecio" value="" /></td>
                    </tr>
                    <tr>
                        <td>MODULOS</td>
                        <td><select name="cmbModulo">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select></td>
                    </tr>                  
                </tbody>
            </table>
            <input type="submit" value="GRABAR" name="btnGrabar" />
        </form>

    </body>
</html>
