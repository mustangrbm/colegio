/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import entidades.Profesor;
import java.util.List;
import util.LecturaDatosIngresados;

/**
 *
 * @author bustatech
 */
public class InscripcionController {

    public Inscripcion inscribirAlumno(List<Alumno> listaAlumnos, List<Profesor> listaProfesores, List<Materia> listaMaterias) {
        //1- Seleccionar el alumno
        Alumno alumnoSeleccionado = seleccionarAlumno(listaAlumnos);
        //2- Seleccionar la materia con el profesor
        Profesor profesorSeleccionado = seleccionarProfesor(listaProfesores);
        //3- Asignar los datos al objeto Inscripcion                
        Materia materiaSeleccionada = seleccionarMateria(listaMaterias);

        Inscripcion inscripcion = new Inscripcion(1, alumnoSeleccionado, profesorSeleccionado, materiaSeleccionada);
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

    private Profesor seleccionarProfesor(List<Profesor> listaProfesor) {
        Profesor profesorSeleccionado = null;

        do {
            try {

                System.out.println("-------------------------------------");
                System.out.println("Inscripciones - Seleccione el Profesor");
                System.out.println("-------------------------------------");
                int contador = 0;
                for (Profesor profesor : listaProfesor) {
                    System.out.println("{" + contador + "} - " + profesor.getNombre() + " " + profesor.getApellido());
                    contador++;
                }
                System.out.print("\n Codigo Profesor:");
                Integer idProfesor = Integer.parseInt(LecturaDatosIngresados.leer());
                profesorSeleccionado = listaProfesor.get(idProfesor);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al seleccionar el profesor, intente nuevamente");
            }
        } while (profesorSeleccionado == null);
        System.out.println("Profesor Seleccionado : " + profesorSeleccionado.getNombre() + " " + profesorSeleccionado.getApellido());
        return profesorSeleccionado;

    }
    private Materia seleccionarMateria(List<Materia> listaMateria) {
        Materia materiaSeleccionada = null;

        do {
            try {

                System.out.println("-------------------------------------");
                System.out.println("Inscripciones - Seleccione la Materia");
                System.out.println("-------------------------------------");
                int contador = 0;
                for (Materia materia : listaMateria) {
                    System.out.println("{" + contador + "} - " + materia.getDescripcion());
                    contador++;
                }
                System.out.print("\n Codigo Materia:");
                Integer idMateria = Integer.parseInt(LecturaDatosIngresados.leer());
                materiaSeleccionada = listaMateria.get(idMateria);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al seleccionar la materia, intente nuevamente");
            }
        } while (materiaSeleccionada == null);
        System.out.println("Materia Seleccionada : " + materiaSeleccionada.getDescripcion());
        return materiaSeleccionada;

        public void imprimirListaInscripcion(List<Alumno> listaAlumnos){
        System.out.println("************************************");
        System.out.println("Lista de Alumnos  ");
        System.out.println("************************************");
        for (Alumno alumno : listaAlumnos){
            System.out.println(alumno.getApellido() + "Nombre :" +º alumno.getNombre() + " \t\t Apellido:" + "\t\t Cedula:" + alumno.getCedula());
    }

}
