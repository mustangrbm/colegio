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
public class Alumno  extends Persona{
    private Integer idAlumno;
    
    
    
    public Alumno() {
        
    }
    
    public Alumno(Integer idAlumno, String nombre, String apellido, Integer cedula) {
        super(nombre, apellido, cedula);
        this.idAlumno = idAlumno;
    }
    
    
  
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }


    
    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + '}';
    }
    
    
    
    
    
    
            
    
}
