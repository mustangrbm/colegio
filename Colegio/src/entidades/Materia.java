/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author bustatech
 */
public class Materia {

    public static void add(Materia Sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String materia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Integer idMateria;
    private String descripcion;
    private Integer cantidadMaxima;

    public Materia(Integer idMateria, String descripcion, Integer cantidadMaxima) {
        this.idMateria = idMateria;
        this.descripcion = descripcion;
        this.cantidadMaxima = cantidadMaxima;
    }

    public Materia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(Integer cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", descripcion=" + descripcion + ", cantidadMaxima=" + cantidadMaxima + '}';
    }

    public void setMateria(String leer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}