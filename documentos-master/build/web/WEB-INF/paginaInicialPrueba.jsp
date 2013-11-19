<%-- 
    Document   : paginaInicialPrueba
    Created on : 12/11/2013, 07:58:00 AM
    Author     : 201
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String login= (String)request.getAttribute("login"); %>
        <% Boolean error= (Boolean)request.getAttribute("error"); %>
       Bienvenido  <%=login %>       
            
       <form method="post"  name="cerrarSesion" action="CFuncionario?a=cerrarSesion">
           <br><input type="submit" name="cerrar sesion" value="cerrar"/> 
           
       </form>
                
        <h1></h1>
    </body>
</html>
