/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Usuario_Reporta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JHONATAN
 */
public class Usuario_ReportaDAO implements DAOInterface<Usuario_Reporta>{

    @Override
    public boolean save(Usuario_Reporta entity) {
        String sql="";
         boolean exito = false;
        
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getDocumento_usuario_reporta())==null) 
            {    
             statement=
                    c.prepareStatement("insert into usuario_reporta values(?,?,?,?,?,?,?)");
            
            statement.setString(1, entity.getDocumento_usuario_reporta());
            statement.setString(2, entity.getNombres());
            statement.setString(3, entity.getApellido1());
            statement.setString(4, entity.getApellido2());
            statement.setString(5, entity.getDireccion());
            statement.setString(6, entity.getTelefono());
            statement.setString(7, entity.getCorreo());
            
            }
            else
            {
                 statement=
                    c.prepareStatement("update  usuario_reporta set Documento_usuario_reporta=?, nombres=?,apellido1=?,apellido2=?,,Direccion=?,Telefono=?,Correo=? where Documento_usuario_reporta=?");
            statement.setString(1, entity.getDocumento_usuario_reporta());
            statement.setString(2, entity.getNombres());
            statement.setString(3, entity.getApellido1());
            statement.setString(4, entity.getApellido2());
            statement.setString(5, entity.getDireccion());
            statement.setString(1, entity.getTelefono());
            statement.setString(6, entity.getCorreo());
            statement.setString(8, entity.getDocumento_usuario_reporta());
            }    
            exito = statement.execute();
            exito=true;
            c.close();
          } catch (SQLException ex) {
            Logger.getLogger(Usuario_ReportaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        return exito;
    }
    @Override
    public void delete(Usuario_Reporta entity) {
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from usuario_reporta where Documento_usuario_reporta=?");
            
            statement.setString(1, entity.getDocumento_usuario_reporta());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_ReportaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public Usuario_Reporta findById(Object id) {
        Usuario_Reporta entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select Documento_usuario_reporta, nombres,apellido1,apellido2,Direccion,Telefono,Correo  from usuario_reporta where Documento_usuario_reporta=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =  statement.executeQuery();
            if(results.next())
            {
                 entity = new Usuario_Reporta();
                 entity.setDocumento_usuario_reporta(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setDireccion(results.getString(5));
                 entity.setTelefono(results.getString(6));
                 entity.setCorreo(results.getString(7));
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_ReportaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entity;
    }
    @Override
    public ArrayList<Usuario_Reporta> findAll() {
        ArrayList<Usuario_Reporta> entities = new ArrayList<Usuario_Reporta>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select Documento_usuario_denuncia, nombres,apellido1,apellido2,Fecha_nacimiento,Direccion,Telefono,Correo  from usuario_denuncia"
                    );
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Usuario_Reporta entity = new Usuario_Reporta();
                 entity.setDocumento_usuario_reporta(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setTelefono(results.getString(5));
                 entity.setDireccion(results.getString(6));
                 entity.setCorreo(results.getString(7));
                 entities.add(entity);
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_ReportaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entities;
    }
}
    

