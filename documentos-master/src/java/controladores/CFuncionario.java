/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.DAO.FuncionarioDAO;
import datos.configuracion.Conexion;
import datos.entidades.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author camilo
 */
@WebServlet(name = "CFuncionario", urlPatterns = {"/CFuncionario"})
public class CFuncionario extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher;
        PrintWriter out = response.getWriter();
        String accion= request.getParameter("a");
        try {
            if(Conexion.getConexion()==null)
                out.print("no se pudo establecer conexión");
            else
            {
                FuncionarioDAO fdao = new FuncionarioDAO();
               
                if(accion.equals("crear")){
       dispatcher = request.getRequestDispatcher("WEB-INF/iFuncionarios.html");
       dispatcher.forward(request,response);
                }
       if(accion.equals("guardar")){          
         
        String nombre=request.getParameter("nombre");
        String apellido1=request.getParameter("apellidoU");
        String apellido2=request.getParameter("apellidoD");
        String nDocumento=request.getParameter("numeroDocumento");
        String clave=request.getParameter("clave");       
        Funcionario funcionario=new Funcionario(nDocumento,nombre,apellido1,apellido2,clave);
        fdao.save(funcionario);
       
      }
                
      if(accion.equals("fBorrar"))
      {     
       dispatcher = request.getRequestDispatcher("WEB-INF/iBorrar.html");
       dispatcher.forward(request,response);
      }     
      if(accion.equals("borrar"))
      {
      String nombre=request.getParameter("nombre");
          String apellido1=request.getParameter("apellidoU");
          String apellido2=request.getParameter("apellidoD");
          String nDocumento=request.getParameter("numeroDocumento");
          String clave=request.getParameter("clave"); 
          Funcionario funcionario=new Funcionario(nDocumento,nombre,apellido1,apellido2,clave);
          fdao.delete(funcionario);
      }
      if(accion.equals("fBuscar"))
      {      
       dispatcher = request.getRequestDispatcher("WEB-INF/iBuscar.html");
       dispatcher.forward(request,response);
      }
      if(accion.equals("buscar"))
      {
      
          String numDocumento=request.getParameter("numeroDocumento");
          Funcionario f = fdao.findById(numDocumento);
      
      if(f==null)
                {
                    out.print("No se encontró a ningún empleado con ese documento");
                    
                }   
                else
                {
                    out.println(f.getNombres());
                    out.println(f.getApellido1());
                    out.println(f.getApellido2());
                }
      }
      
      
      if(accion.equals("fMostrar"))
              {      
                 
                ArrayList<Funcionario> funcionarios;
                funcionarios =  fdao.findAll();
                out.println(" <table BORDER=\"1\"  WIDTH=\"300\"  align=\"center\" >");
                out.println("<TH COLSPAN=2 BGCOLOR=\"Green\"><h1>Funcionarios</h1></TH>");
                out.println("<tr BGCOLOR=\"Gray\">><td><b>Nombre</b></td><td><b>Apellido</b></td></tr>");
                for(int i=0;i<funcionarios.size();i++)
                {
                    
                    out.println("<tr>");                    
                    out.println("<td>");                    
                    out.println(funcionarios.get(i).getNombres());
                    out.println("</td>");                    
                    out.println("<td>");
                    out.println(funcionarios.get(i).getApellido1());
                    out.println("</td>");
                    out.println("</tr>");
                }    
                out.println("</table>");
                /*
                for(Funcionario f:funcionarios)
                {
                    out.println(f.getNombres()+" "+f.getApellido1());
                    out.println("<br>");
                } 
                */ 
                }
      if(accion.equals("fInicio"))
      { 
       if(request.getSession().getAttribute("login")==null){
       Boolean x=true;
       request.setAttribute("error", x); 
       dispatcher = request.getRequestDispatcher("WEB-INF/inicioSesionFuncionario.jsp");
       dispatcher.forward(request,response);
       }
       else
       {
             request.setAttribute("login",request.getSession().getAttribute("login"));
           dispatcher = request.getRequestDispatcher("WEB-INF/paginaInicialPrueba.jsp");
           dispatcher.forward(request,response);
       }
      
      }      
      
      if(accion.equals("inicio"))
              {  
                  
         String nDocumento=request.getParameter("numeroDocumento");
         String clave=request.getParameter("clave"); 
          
         
          
          Funcionario f=fdao.findById(nDocumento);
                
             if(!(f==null)){ 
             if(f.getNumeroDocumento().equals(nDocumento) )
              {
                  if(f.getClave().equals(clave)){
           request.getSession().setAttribute("login",f.getNombres());
           request.setAttribute("login",request.getSession().getAttribute("login"));
           dispatcher = request.getRequestDispatcher("WEB-INF/paginaInicialPrueba.jsp");
           dispatcher.forward(request,response);
           
                  }
                  else{
                      Boolean x=false; 
                      
              request.setAttribute("error", x); 
              dispatcher= request.getRequestDispatcher("WEB-INF/inicioSesionFuncionario.jsp");
              dispatcher.forward(request, response);    }   
              }              
              
             }
            if(f==null)
             { 
                 Boolean x=false; 
              request.setAttribute("error", x);
              dispatcher= request.getRequestDispatcher("WEB-INF/inicioSesionFuncionario.jsp");
              dispatcher.forward(request, response);
             }
              
              }
      
            if(accion.equals("cerrarSesion"))
            {
            
            out.println("cerrando sesion.............");
            request.getSession().removeAttribute("login");
            dispatcher= request.getRequestDispatcher("WEB-INF/inicioSesionFuncionario.jsp");
            dispatcher.forward(request, response);
            
            
            
            
           }
           
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
