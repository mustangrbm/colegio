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

    
    public Integer idMateria;
    private String descripcion;
    private Integer cantidadMaxima;
    public String idmateria;

    public Materia(Integer idMateria, String descripcion, Integer cantidadMaxima) {
        this.idMateria = idMateria;
        this.descripcion = descripcion;
        this.cantidadMaxima = cantidadMaxima;
    }

    public Materia() {
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


    
}
