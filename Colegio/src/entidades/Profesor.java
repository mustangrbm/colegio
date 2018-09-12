/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author cbustamante
 */
public class Profesor  extends Persona{
    private Integer idProfesor;

    public Profesor(){
        
    }    
    public Profesor(Integer idProfesor, String nombre, String apellido, Integer cedula) {
        super(nombre, apellido, cedula);
        this.idProfesor = idProfesor;
    }
   
    
    
    
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    @Override
    public String rolPersona(){
        return "Profesor";
    }


    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + '}';
    }                    

}
