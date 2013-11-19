/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import datos.configuracion.Conexion;
import datos.entidades.Denuncia;
import datos.entidades.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201
 */
public class DenunciaDAO implements DAOInterface<Denuncia>{

    
    
public int nextId()
{
     int entity=0;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  max(id_denuncia) from denuncia"
                    );
            
            
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
            
                 entity=results.getInt(1)+1;
                 
                 
            }    
            else
            {
            entity=1;
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        

return entity;

}

@Override
    public boolean save(Denuncia entity) {
        String sql="";
        boolean exito = false;
               
        
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getIdDenuncia())==null) 
            { 
            entity.setIdDenuncia(this.nextId());
             statement=
                    
                    c.prepareStatement("insert into denuncia values(?,?,?,?)");
            
            statement.setInt(1, entity.getIdDenuncia());
            statement.setDate(2, entity.getFechaDenuncia());
            statement.setDate(3, entity.getFechaPerdida());
            statement.setTime(4, entity.getHoraPerdida());
            
            
            }
            else
            {
                 statement=
                    c.prepareStatement("update  denuncia set id_denuncia=?, fecha_denuncia=?,fecha_perdida=?,hora_perdida=? where id_denuncia=?");
            statement.setInt(1, entity.getIdDenuncia());
            statement.setDate(2, entity.getFechaDenuncia());
            statement.setDate(3, entity.getFechaPerdida());
            statement.setTime(4, entity.getHoraPerdida());
            statement.setInt(5, entity.getIdDenuncia());
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
    public void delete(Denuncia entity) {
          try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from denuncia where id_denuncia=?");
            
            statement.setInt(1, entity.getIdDenuncia());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public Denuncia findById(Object id) {
           
        Denuncia entity =null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  id_denuncia,fecha_denuncia,fecha_perdida,hora_perdida from denuncia where id_denuncia=?"
                    );
            
            statement.setInt(1, (Integer)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                 entity = new Denuncia();
                 entity.setIdDenuncia(results.getInt(1));
                 entity.setFechaDenuncia(results.getDate(2));
                 entity.setFechaPerdida(results.getDate(3));
                 entity.setHoraPerdida(results.getTime(4));
                 
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;   
        
    }

    @Override
    public ArrayList<Denuncia> findAll() {
   
        ArrayList<Denuncia> entities = new ArrayList<Denuncia>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select  id_denuncia,fecha_denuncia,fecha_perdida,hora_perdida from denuncia"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Denuncia entity = new Denuncia();
                 entity.setIdDenuncia(results.getInt(1));
                 entity.setFechaDenuncia(results.getDate(2));
                 entity.setFechaPerdida(results.getDate(3));
                 entity.setHoraPerdida(results.getTime(4));
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
        DenunciaDAO dao=new DenunciaDAO();
        Denuncia x;
         Calendar c=Calendar.getInstance();
        c.set(1999,12,10);
        java.util.Date w=c.getTime();
        java.sql.Date z= new Date(w.getTime());
        Time time=new Time(24, 20, 10); 
         x=new Denuncia(z,z,time);
         dao.save(x);
        /*
    
        Denuncia x;
         Calendar c=Calendar.getInstance();
        c.set(1999,12,10);
        java.util.Date w=c.getTime();
        java.sql.Date z= new Date(w.getTime());
        Time time=new Time(10, 20, 10); 
       DenunciaDAO dao=new DenunciaDAO();
   x=new Denuncia(123,z,z,time);
        dao.save(x);
       Denuncia j=dao.findById(123);
       
       if(j==null)
        {
        System.out.println("No se encontro a nadie con ese documento");
        }
        else
        {
        System.out.println(j);
        
      
    ArrayList<Denuncia> y=dao.findAll();
    for(int i=0;i<y.size();i++)
    {
      System.out.println(y.get(i));
    }
    */
    }
    
     }

