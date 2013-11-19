/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;
import datos.configuracion.Conexion;
import datos.entidades.Documento_Encontrado;
import datos.entidades.Documento_Encontrado;
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
public class Documento_EncontradoDAO implements DAOInterface<Documento_Encontrado>{
     @Override
    public boolean save(Documento_Encontrado entity) {
        String sql="";
         boolean exito = false;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.gettipo_documento())==null) 
            {    
             statement=c.prepareStatement("insert into Documento_Encontrado values(?,?)");
             statement.setString(1, entity.gettipo_documento());
             statement.setInt(2, entity.getNumero_Documento());
                
            }
            else
            {
                statement=c.prepareStatement("update  Documento_Encontrado set Tipo_Documento=?, Numero_documento=?");
                statement.setString(1, entity.gettipo_documento());
                statement.setInt(2, entity.getNumero_Documento());
                statement.setString(3, entity.gettipo_documento());
            }
            exito = statement.execute();
            
            exito=true;
            c.close();
        }
        catch (SQLException ex){
            Logger.getLogger(Documento_EncontradoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        
        return exito;
    }

    @Override
    public void delete(Documento_Encontrado entity) {
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=c.prepareStatement("delete from Documento_Encontrado where tipo_documento=?");
            statement.setString(1, entity.gettipo_documento());
            statement.execute();
            c.close();
           
        } 
        catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public Documento_Encontrado findById(Object id) {
        Documento_Encontrado entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select tipo_documento, numero_Documento from Documento_Encontrado where numero_documento=?"
                    );
            statement.setInt(1,(Integer)id);
            
            ResultSet results =statement.executeQuery();
            if(results.next())
            {
                 entity = new Documento_Encontrado();
                 entity.settipo_documento(results.getString(1));
                 entity.setNumero_documento(results.getInt(2));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }   
        return entity;
    }
    @Override
    public ArrayList<Documento_Encontrado> findAll() {
        ArrayList<Documento_Encontrado> entities = new ArrayList<Documento_Encontrado>();
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=c.prepareStatement("select Tipo_Documento, numero_Documento from Documento_Encontrado");
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Documento_Encontrado entity = new Documento_Encontrado();
                 entity.settipo_documento(results.getString(1));
                 entity.setNumero_documento(results.getInt(2));
                 entities.add(entity);
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entities;
    }
    

}