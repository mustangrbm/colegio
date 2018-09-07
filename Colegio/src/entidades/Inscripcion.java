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
public class Inscripcion {
    private Integer idInscripcion;
    private Alumno alumno;
    private Profesor profesor;
    private Materia materia;
   
    public Inscripcion(){
        
    }
    public Inscripcion(Integer idInscripcion, Alumno alumno, Profesor profesor, Materia materia) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.profesor = profesor;
        this.materia = materia;
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
    
    
    
}
