/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.DAO.Documento_EncontradoDAO;
import datos.configuracion.Conexion;
import datos.entidades.Documento_Encontrado;
import datos.entidades.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BRAYAM
 */
@WebServlet(name = "CDocumento", urlPatterns = {"/CDocumento"})
public class CDocumento extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        String accion = request.getParameter("a");
        try {
            
            if(Conexion.getConexion()==null){
                out.print("no se pudo establecer conexión");
            }
            else{
                Documento_EncontradoDAO fdao = new Documento_EncontradoDAO();
                
                if(accion.equals("fBuscar"))
      {      
       dispatcher = request.getRequestDispatcher("WEB-INF/Documento.jsp");
       dispatcher.forward(request,response);
      }
      if(accion.equals("buscar"))
      {
      
          String numDocumento=request.getParameter("Numero_Documento");
          Documento_Encontrado f = fdao.findById(numDocumento);
      
      if(f==null)
                {
                    out.print("Documento no encontrado");
                    
                }   
                else
                {
                    out.println(f.gettipo_documento());
                    out.println(f.getNumero_Documento());
                    out.println("Documento Encontrado");
                   out.println(request.getParameter("Documento Encontrado"));
                }
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
