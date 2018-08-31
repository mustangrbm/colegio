/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import controladores.AlumnosController;
import entidades.Alumno;
import entidades.Materia;
import entidades.Profesor;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
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

    public Colegio() {
        listaAlumnos = new ArrayList();
        listaProfesores = new ArrayList();
        listaMaterias = new ArrayList();
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
            if (opcionSeleccionada.equals("1")){ 
                cargarDatos();
            }
            //Inscribir Alumnos
            else if (opcionSeleccionada.equals("2")){ 
                Alumno alumno = new AlumnosController().registrarAlumno();
                this.listaAlumnos.add(alumno);
            }
            //Listar Alumnos
            else if (opcionSeleccionada.equals("3")){ 
                new AlumnosController().imprimirListaAlumnos(listaAlumnos);
            }
            //Resumen de datos cargados
            else if (opcionSeleccionada.equals("6")){
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
        System.out.println("(2) Inscribir Alumno");
        System.out.println("(3) Listar Alumnos");
        System.out.println("(4) Registrar  Materias");
        System.out.println("(5) Inscribir Alumnos");
        System.out.println("(6) Resumen de datos cargados");
        System.out.println("(0) Salir del Sistema");
    }

    private void cargarDatos() {
        listaAlumnos.addAll(new AlumnosManager().cargarListaAlumnos());
        listaProfesores.addAll(new ProfesoresManager().cargarListaProfesores());
        listaMaterias.addAll( new MateriasManager().cargarListaMaterias());
    }
    private void resumenDatosCargados() {
        System.out.println("Resumenes de datos Ingresados al Sistema");
        System.out.println("----------------------------------------");
        System.out.println("Alumnos :" + listaAlumnos.size());
        System.out.println("Profesores :" + listaProfesores.size());
        System.out.println("Materias:" + listaMaterias.size());
        
    }

}
