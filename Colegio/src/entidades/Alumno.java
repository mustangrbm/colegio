/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bustatech
 */
public class Alumno extends Persona {

    private Integer idAlumno;

    private List<Materia> listaMaterias;
    private List<Cuota> listaCuotas;

    public Alumno() {
        listaMaterias = new ArrayList();
        listaCuotas = new ArrayList();

    }

    public Alumno(Integer idAlumno, String nombre, String apellido, Integer cedula) {
        super(nombre, apellido, cedula);
        this.idAlumno = idAlumno;
        listaMaterias = new ArrayList();
        listaCuotas = new ArrayList();
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<Cuota> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(List<Cuota> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + '}';
    }

}
