/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

/**
 *
 * @author BRAYAM
 */
public class Documento_Encontrado {
    private String tipo_documento;
    private int numero_documento;

    public Documento_Encontrado(String nombre, int numero_documento) {
        this.tipo_documento = nombre;
        this.numero_documento = numero_documento;
    }

    public Documento_Encontrado(){
    }
    
    public int getNumero_Documento() {
        return numero_documento;
    }
    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String gettipo_documento() {
        return tipo_documento;
    }

    public void settipo_documento(String nombre) {
        this.tipo_documento = nombre;
    }

    @Override
    public String toString() {
        return "Documento_Encontrado{" + "numero_documento=" + numero_documento + ", tipo_documento=" + tipo_documento + '}';
    }

    public void getNumero_Documento(String encontrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
    
}
