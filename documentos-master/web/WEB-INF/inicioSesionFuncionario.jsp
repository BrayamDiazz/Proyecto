<%-- 
    Document   : inicioSesionFuncionario
    Created on : 5/11/2013, 08:32:58 AM
    Author     : 201
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>inicio sesion Funcionario</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <script src="js/libs/jquery-1.9.0/jquery.min.js"></script>
       <script src="js/libs/jquery-validate-1.10.0/jquery.validate.min.js"></script>
        <style>
            .error
            {
                color:red
                    
            }
            input.error
            {
                background-color: #cccccc
            }
           
            li
            {
                
                color:red
                
            }
           
            
        </style> 
    </head>
    <body>
          
        <table BORDER="3" CELLSPACING="5" WIDTH="370"  align="center" >
            <TH COLSPAN=2 BGCOLOR="Green"><h1>Digite datos para inicio de sesion</h1></TH>
            <tr>
            <td align="center">
                
  
                <form  method="post" id="form1" name="inicioSesion" action="CFuncionario?a=inicio" >
                    
                    <br>Numero de documento: <input type="text" name="numeroDocumento" value=""/><br>
       
            <br>Contrase&ntildea:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="clave" value="" /><br>
            
            <% Boolean error= (Boolean)request.getAttribute("error"); %>
            <% String login= (String)request.getAttribute("login"); %>
                <%if(error==false){ %> 
            
<li>error en los datos digitados</li>
                     <% } %>
            <br><input type="submit" name="aceptar" value="aceptar"/> 
            
        </form>
      
        </td>
            </tr>           
        </table>
    <script>
             $("#form1").validate(                
        
        {
    errorLabelContainer:"#messagebox",
    wrapper:"li",
         rules:
                 {
             
             numeroDocumento:
                     {
                 required: true,
                 digits:true
                 
                 
            },
                  
            
           
        clave:{
            required:true
        }         
        },
        
                 messages:
                         {
                     
                     numeroDocumento:
                     {
                 required: "por favor digite el numero de su documento",
                 digits:"digite solo numeros"
            },
                         
            
            clave:
                     {
                 required: "por favor digite su clave"
                 
            },
                                    
                     
                     }                         
                         }
           );
                          </script>
    
    
    
    </body>
</html>
