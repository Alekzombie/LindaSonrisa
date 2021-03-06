<%-- 
    Document   : plantillaRegistrarServicio
    Created on : 20-05-2018, 16:30:05
    Author     : lmerino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h3>Ingrese Nuevo Servicio</h3>
         <form action="/LindaSonrisa/agregarServicio" method="POST">
            <section class="content">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Nombre Servicio</td>
                        <td><input type="text" name="txtDescripcion" value="" /></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="txtPrecio" placeholder="$0" value="" /></td>
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
                </tbody>
            </table>
            <input type="submit" value="Registrar" name="btnRegistrar" />
        </section>  
        </form>
        <c:if test="${mensaje!=null}">
            <script>
                alert("${mensaje}");
            </script>
        </c:if>
    </body>
</html>
