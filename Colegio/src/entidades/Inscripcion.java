/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author bustatech
 */
public class Inscripcion {
    private Integer idInscripcion;
    private Alumno alumno;
    private Profesor profesor;
    private Materia materia;
    private Date fecha;
   
    public Inscripcion(){
        fecha = new Date();
        
    }
    public Inscripcion( Alumno alumno, Profesor profesor, Materia materia) {
        this.alumno = alumno;
        this.profesor = profesor;
        this.materia = materia;
        fecha = new Date();
    }
    

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
