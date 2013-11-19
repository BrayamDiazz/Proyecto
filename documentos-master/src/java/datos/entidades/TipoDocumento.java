/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

/**
 *
 * @author 201
 */
public class TipoDocumento {
    private int idDocumento;
    private String nombre,descripcion;

    public TipoDocumento(int idDocumento, String nombre, String descripcion) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoDocumento() {
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" + "idDocumento=" + idDocumento + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
