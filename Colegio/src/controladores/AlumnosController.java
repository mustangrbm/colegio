/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import java.util.List;
import managers.AlumnosManager;
import util.LecturaDatosIngresados;

/**
 *
 * @author cbustamante
 */
public class AlumnosController {
    
    
    public Alumno registrarAlumno(){
        Alumno alumno = new Alumno();
        System.out.println("************************************");
        System.out.println("Registro de Alumnos  ");
        System.out.println("************************************");
        System.out.print("\nIngrese el Nombre :");
        alumno.setNombre(LecturaDatosIngresados.leer());
        System.out.print("\nIngrese el Apellido:");
        alumno.setApellido(LecturaDatosIngresados.leer());
        System.out.print("\nIngrese la cedula :");
        alumno.setCedula(Integer.parseInt(LecturaDatosIngresados.leer()));
        new AlumnosManager().add(alumno);
        
        return alumno;
    }
    
    public void imprimirListaAlumnos(){
        List<Alumno> listaAlumnos  =  new AlumnosManager().getAll();
        System.out.println("************************************");
        System.out.println("Lista de Alumnos  ");
        System.out.println("************************************");
        for (Alumno alumno : listaAlumnos){
            System.out.println("Nombre :" + alumno.getNombre() + " \t\t Apellido:" + alumno.getApellido() + "\t\t Cedula:" + alumno.getCedula());
        }
        
    }
    
    public Alumno seleccionarAlumno() {
        Alumno alumnoSeleccionado = null;
        List<Alumno> listaAlumnos = new AlumnosManager().getAll();

        do {
            try {

                System.out.println("-------------------------------------");
                System.out.println("Inscripciones - Seleccione el alumno");
                System.out.println("-------------------------------------");
                int contador = 0;
                for (Alumno alumno : listaAlumnos) {
                    System.out.println("{" + contador + "} - " + alumno.getNombre() + " " + alumno.getApellido());
                    contador++;
                }
                System.out.print("\n Codigo Alumno:");
                Integer idAlumno = Integer.parseInt(LecturaDatosIngresados.leer());
                alumnoSeleccionado = listaAlumnos.get(idAlumno);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al seleccionar el alumno, intente nuevamente");
            }
        } while (alumnoSeleccionado == null);
        System.out.println("Alumno Seleccionado : " + alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellido());
        return alumnoSeleccionado;
    }
}
