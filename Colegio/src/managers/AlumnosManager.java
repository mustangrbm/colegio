/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cbustamante
 */
public class AlumnosManager {

    private List<Alumno> obtenerListaAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList();
        Alumno mati = new Alumno(1, "Matias", "Bustamante Fernandez", 32312);
        Alumno seba = new Alumno(2, "Sebastian", "Bustamante Rotela", 234123);
        Alumno diana = new Alumno(3, "Diana", "Bustamante Rotela", 234234);
        Alumno sofi = new Alumno(4, "Sofia", "Bustamante Fernandez", 234524);
        listaAlumnos.add(seba);
        listaAlumnos.add(mati);
        listaAlumnos.add(diana);
        listaAlumnos.add(sofi);
        return listaAlumnos;
    }

    public List<Alumno>  cargarListaAlumnos() {
        System.out.println("Cargando lista de alumnos");
        System.out.println("---------------------------");
        List<Alumno> listaAlumnos =obtenerListaAlumnos();
        for (Alumno alumno : obtenerListaAlumnos()) {
            System.out.println("Alumno Inscripto: " + alumno);
        }
        return listaAlumnos;
    }

}
