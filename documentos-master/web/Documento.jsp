<%-- 
    Document   : Documento
    Created on : 18-nov-2013, 19:02:40
    Author     : BRAYAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUSQUEDA DE DOCUMENTO</title>
    </head>
    <link href="Estilo.css" rel="stylesheet" type="text/css">
    
    <body>
        <form method="post" action="CDocumento">
        <table>
            <tr>
                <td>Tipo de Documento</td>
                <td>Numero de Documeno</td>
            </tr>
            <tr>
                <td><select name="tipoDocumento">
                        <option>Cedula de Cuidadania</option>
                        <option>Tarjeta de Identidad</option>
                        <option>Libreta Militar</option>
                        <option>Carné Estudiantil</option>
                        <option>Licencia de Conducción</option>
                    </td>
                <td></select><input type="text" name="Numero_Documento" value="" /></td>
                <td><input type="submit" value="BUSCAR" name="Buscar" /></td>
            </tr>
        </table>
        </form>
    </body>
</html>
