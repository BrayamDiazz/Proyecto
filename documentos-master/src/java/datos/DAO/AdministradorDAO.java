/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201
 */
public class AdministradorDAO implements DAOInterface<Administrador>{

    @Override
    public boolean save(Administrador entity) {
        String sql="";
        boolean exito = false;
        
           
        
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getNumeroDocumento())==null) 
            {    
             statement=
                    c.prepareStatement("insert into administrador values(?,?,?,?,?,?)");
            
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getClave());
            statement.setString(3, entity.getNumeroDocumento());
            statement.setString(4, entity.getNombres());
            statement.setString(5, entity.getApellido1());
            statement.setString(6, entity.getApellido2());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  administrador set login=?, clave=?,numero_documento=?,nombres=?,apellido1=?,apellido2=? where numero_documento=?");
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getClave());
            statement.setString(3, entity.getNumeroDocumento());
            statement.setString(4, entity.getNombres());
            statement.setString(5, entity.getApellido1());
            statement.setString(6, entity.getApellido2());
            statement.setString(7, entity.getNumeroDocumento());
            }    
            
            exito = statement.execute();
            
            exito=true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        
        return exito;
    }

    @Override
    public void delete(Administrador entity) {
          try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from administrador where numero_documento=?");
            
            statement.setString(1, entity.getNumeroDocumento());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public Administrador findById(Object id) {
        Administrador entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select numero_documento,login,clave,nombres,apellido1,apellido2 from administrador where numero_documento=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                 entity = new Administrador();
                 entity.setNumeroDocumento(results.getString(1));
                 entity.setLogin(results.getString(2));
                 entity.setClave(results.getString(3));
                 entity.setNombres(results.getString(4));
                 entity.setApellido1(results.getString(5));
                 entity.setApellido2(results.getString(6));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;
    }

    @Override
    public ArrayList<Administrador> findAll() {
        ArrayList<Administrador> entities = new ArrayList<Administrador>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select numero_documento,login,clave,nombres,apellido1,apellido2 from administrador"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Administrador entity = new Administrador();
                 entity.setNumeroDocumento(results.getString(1));
                 entity.setLogin(results.getString(2));
                 entity.setClave(results.getString(3));
                 entity.setNombres(results.getString(4));
                 entity.setApellido1(results.getString(5));
                 entity.setApellido2(results.getString(6));
                 entities.add(entity);
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entities;
    }
 
    public static void  main(String args[])
    {
   
        
     AdministradorDAO dao=new AdministradorDAO();
   Administrador x= new Administrador();
     x=dao.findById("1564646");
     
     System.out.print(x);
    /*
   ArrayList<Administrador> y=dao.findAll();
    for(int i=0;i<y.size();i++)
    {
      System.out.println(y.get(i));
    }
      */
  
    }
    
    
    
    }
