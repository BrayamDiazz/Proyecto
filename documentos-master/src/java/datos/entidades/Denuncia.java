/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author 201
 */
public class Denuncia {
    private int idDenuncia;
    private Date fechaDenuncia,fechaPerdida;
    private Time horaPerdida;

    public Denuncia( Date fechaDenuncia, Date fechaPerdida, Time horaPerdida) {
        
        this.fechaDenuncia = fechaDenuncia;
        this.fechaPerdida = fechaPerdida;
        this.horaPerdida = horaPerdida;
    }

    public Denuncia() {
        
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Date getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public Date getFechaPerdida() {
        return fechaPerdida;
    }

    public void setFechaPerdida(Date fechaPerdida) {
        this.fechaPerdida = fechaPerdida;
    }

    public Time getHoraPerdida() {
        return horaPerdida;
    }

    public void setHoraPerdida(Time horaPerdida) {
        this.horaPerdida = horaPerdida;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "idDenuncia=" + idDenuncia + ", fechaDenuncia=" + fechaDenuncia + ", fechaPerdida=" + fechaPerdida + ", horaPerdida=" + horaPerdida + '}';
    }
    
            
    
    
}
