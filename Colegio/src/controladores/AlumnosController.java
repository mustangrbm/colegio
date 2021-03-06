/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import java.util.List;
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
        
        return alumno;
    }
    
    public void imprimirListaAlumnos(List<Alumno> listaAlumnos){
        System.out.println("************************************");
        System.out.println("Lista de Alumnos  ");
        System.out.println("************************************");
        for (Alumno alumno : listaAlumnos){
            System.out.println("Nombre :" + alumno.getNombre() + " \t\t Apellido:" + alumno.getApellido() + "\t\t Cedula:" + alumno.getCedula());
        }
        
    }
    
}
