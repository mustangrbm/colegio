/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Profesor;
import java.util.List;
import util.LecturaDatosIngresados;

/**
 *
 * @author bustatech
 */
public class InscripcionController {

    public Inscripcion inscribirAlumno(List<Alumno> listaAlumnos, List<Profesor> listaProfesores) {
        //1- Seleccionar el alumno
        Alumno alumnoSeleccionado = seleccionarAlumno(listaAlumnos);
        //2- Seleccionar la materia con el profesor
        
        //3- Asignar los datos al objeto Inscripcion                

        Inscripcion inscripcion = new Inscripcion(); //parche temporal
        return inscripcion;
    }

    private Alumno seleccionarAlumno(List<Alumno> listaAlumnos) {
        Alumno alumnoSeleccionado = null;

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
