/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Denuncia;
import datos.entidades.TipoDocumento;
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
public class TipoDocumentoDAO implements DAOInterface<TipoDocumento>{

    @Override
    public boolean save(TipoDocumento entity) {
       String sql="";
        boolean exito = false;
               
        
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getIdDocumento())==null) 
            {    
             statement=
                    c.prepareStatement("insert into tipo_documento values(?,?,?)");
            
            statement.setInt(1, entity.getIdDocumento());
            statement.setString(2, entity.getNombre());
            statement.setString(3, entity.getDescripcion());
            
            
            
            }
            else
            {
                 statement=
                    c.prepareStatement("update  tipo_documento set id_tipo=?, nombre=?,descripcion=? where id_tipo=?");
            
            statement.setInt(1, entity.getIdDocumento());
            statement.setString(2, entity.getNombre());
            statement.setString(3, entity.getDescripcion());
            
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
    public void delete(TipoDocumento entity) {
       try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from tipo_documento where id_tipo=?");
            
            statement.setInt(1, entity.getIdDocumento());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public TipoDocumento findById(Object id) {
       TipoDocumento entity =null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  id_tipo,nombre,descripcion from tipo_documento where id_tipo=?"
                    );
            
            statement.setInt(1, (Integer)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                 entity = new TipoDocumento();
                 
                 entity.setIdDocumento(results.getInt(1));
                 entity.setNombre(results.getString(2));
                 entity.setDescripcion(results.getString(3));
                 
                 
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;   
      
    }

    @Override
    public ArrayList<TipoDocumento> findAll() {
        ArrayList<TipoDocumento> entities = new ArrayList<TipoDocumento>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  id_tipo,nombre,descripcion from tipo_documento"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 TipoDocumento entity = new TipoDocumento();
                 entity.setIdDocumento(results.getInt(1));
                 entity.setNombre(results.getString(2));
                 entity.setDescripcion(results.getString(3));
                 
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
    TipoDocumento x=new TipoDocumento();
    TipoDocumentoDAO dao=new TipoDocumentoDAO();
    
    ArrayList<TipoDocumento> y=dao.findAll();
    for(int i=0;i<y.size();i++)
    {
      System.out.println(y.get(i));
    }
    
    }
    
}
