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
import managers.AlumnosManager;
import managers.InscripcionesManager;
import managers.MateriasManager;
import managers.ProfesoresManager;
import util.LecturaDatosIngresados;

/**
 *
 * @author bustatech
 */
public class InscripcionController {

    public Inscripcion inscribirAlumno() {
        //1- Seleccionar el alumno
        Alumno alumnoSeleccionado = new AlumnosController().seleccionarAlumno();
        //2- Seleccionar la materia con el profesor
        Profesor profesorSeleccionado = seleccionarProfesor();
        //3- Asignar los datos al objeto Inscripcion                
        Materia materiaSeleccionada = seleccionarMateria();

        Inscripcion inscripcion = new Inscripcion(alumnoSeleccionado, profesorSeleccionado, materiaSeleccionada);
        new InscripcionesManager().add(inscripcion);
        return inscripcion;
    }

    

    private Profesor seleccionarProfesor() {
        Profesor profesorSeleccionado = null;
        List<Profesor> listaProfesor = new ProfesoresManager().getAll();
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
    private Materia seleccionarMateria() {
        Materia materiaSeleccionada = null;
        List<Materia> listaMateria =  new MateriasManager().getAll();
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

    }

}
