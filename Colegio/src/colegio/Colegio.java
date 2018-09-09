/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import controladores.AlumnosController;
import controladores.InscripcionController;
import controladores.MateriasController;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import entidades.Profesor;
import java.util.ArrayList;
import java.util.List;
import managers.AlumnosManager;
import managers.MateriasManager;
import managers.ProfesoresManager;
import util.LecturaDatosIngresados;

/**
 *
 * @author bustatech
 */
public class Colegio {

    private List<Alumno> listaAlumnos;
    private List<Profesor> listaProfesores;
    private List<Materia> listaMaterias;
    private List<Inscripcion> listaInscripciones;

    public Colegio() {
        listaAlumnos = new ArrayList();
        listaProfesores = new ArrayList();
        listaMaterias = new ArrayList();
        listaInscripciones = new ArrayList();
    }

    /**
     * Programa Principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Colegio().iniciar();
    }

    private void iniciar() {
        controladorMenuPrincipal();
    }

    private void controladorMenuPrincipal() {
        String opcionSeleccionada = "";

        do {
            imprimirMenuPrincipal();
            System.out.print("Seleccione una opcion : ");
            opcionSeleccionada = LecturaDatosIngresados.leer();

            //Control de Opciones del menu seleccionadas
            //Carga Datos Iniciales            
            if (opcionSeleccionada.equals("1")) {
                cargarDatos();
            } else if (opcionSeleccionada.equals("2")) { //Inscribir Alumnos
                Alumno alumno = new AlumnosController().registrarAlumno();
                listaAlumnos.add(alumno);
            } else if (opcionSeleccionada.equals("3")) { //Listar Alumnos
                new AlumnosController().imprimirListaAlumnos(listaAlumnos);
            } else if (opcionSeleccionada.equals("4")) { //Registrar Materias
                Materia materia = new MateriasController().registrarmateria();
                this.listaMaterias.add(materia);
            } else if (opcionSeleccionada.equals("5")) { //Inscribir Alumno
                Inscripcion inscripcion = new InscripcionController().inscribirAlumno(listaAlumnos, listaProfesores, listaMaterias);
                this.listaInscripciones.add(inscripcion);
            } else if (opcionSeleccionada.equals("6")) {//Resumen de datos cargados
                resumenDatosCargados();
            }
        } while (!opcionSeleccionada.equals("0"));
        System.out.println("Saliendo del sistema.. aiooo");

    }

    private void imprimirMenuPrincipal() {
        System.out.println("-------------------------------------------------------");
        System.out.println("    Bienvenido al sistema de colegio EscuelitaSoft");
        System.out.println("-------------------------------------------------------");
        System.out.println("(1) Cargar Datos iniciales");
        System.out.println("(2) Registrar Alumnos");
        System.out.println("(3) Listar Alumnos");
        System.out.println("(4) Registrar  Materias");
        System.out.println("(5) Inscribir Alumnos");
        System.out.println("(6) Resumen de datos cargados");
        System.out.println("(0) Salir del Sistema");
    }

    private void cargarDatos() {
        listaAlumnos.addAll(new AlumnosManager().cargarListaAlumnos());
        listaProfesores.addAll(new ProfesoresManager().cargarListaProfesores());
        listaMaterias.addAll(new MateriasManager().cargarListaMaterias());
    }

    private void resumenDatosCargados() {
        System.out.println("Resumenes de datos Ingresados al Sistema");
        System.out.println("----------------------------------------");
        System.out.println("Alumnos :" + listaAlumnos.size());
        System.out.println("Profesores :" + listaProfesores.size());
        System.out.println("Materias:" + listaMaterias.size());

    }

    private void registrarmaterias() {
        listaMaterias.addAll(new MateriasManager().cargarListaMaterias());
        listaMaterias.addAll(new MateriasManager().cargarListaMaterias());
        listaMaterias.addAll(new MateriasManager().cargarListaMaterias());
    }
}
