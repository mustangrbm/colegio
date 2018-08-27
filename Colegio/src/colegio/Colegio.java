/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import entidades.Alumno;
import entidades.Profesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bustatech
 */
public class Colegio {

    /**
     * Programa Principal
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Colegio().iniciar();
        
    }
    private void iniciar(){
        System.out.println("Bienvenido al sistema de colegio EscuelitaSoft");
        System.out.println("Cargando lista de alumnos");
        System.out.println("---------------------------");
        
        List<Alumno> listaAlumnos = obtenerListaAlumnos();
        for (Alumno alumno : listaAlumnos){
            System.out.println("Alumno Inscripto: " + alumno);
        }                        
        
        System.out.println("Cargando lista de Profesores");
        System.out.println("---------------------------");
        
        List<Profesor> listaProfesores = obtenerListaProfesores();
        for (Profesor profe : listaProfesores){
            System.out.println("Profesores Habilitados: " + profe);
        }                        
        
        
    }
    
    private List<Alumno> obtenerListaAlumnos(){
        List<Alumno> listaAlumnos = new ArrayList();
        Alumno mati = new Alumno(1,"Matias","Bustamante Fernandez",32312);
        Alumno seba = new Alumno(2,"Sebastian","Bustamante Rotela",234123);
        Alumno diana = new Alumno(3,"Diana","Bustamante Rotela",234234);
        Alumno sofi = new Alumno(4,"Sofia","Bustamante Fernandez",234524);
        listaAlumnos.add(seba);
        listaAlumnos.add(mati);
        listaAlumnos.add(diana);
        listaAlumnos.add(sofi);
        return listaAlumnos;        
    }
    private List<Profesor> obtenerListaProfesores(){
        List<Profesor> listaProfesores = new ArrayList();
        Profesor chapatin = new Profesor(1,"Chapatin","Bonaparte",32123);
        Profesor manuelJulio = new Profesor(2,"Manuel","Julio",323443252);
        listaProfesores.add(chapatin);
        listaProfesores.add(manuelJulio);
        return listaProfesores;        
    }
    
    private Boolean inscribirAlumno(Alumno alumno){
        //Asignar materias
        
        
        //Cargar las cuotas
        
        return false;
    }
    
}
