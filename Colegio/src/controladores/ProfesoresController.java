/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import entidades.Profesor;
import java.util.List;
import managers.ProfesoresManager;
import util.LecturaDatosIngresados;

/**
 *
 * @author cbustamante
 */
public class ProfesoresController {
    //TODO:
    //RegistrarMaterias
    //Listar Materias
    public Profesor registrarprofesor(){
        Profesor profesor = new Profesor();
        System.out.println("************************************");
        System.out.println("Registro de Profesores  ");
        System.out.println("************************************");
        System.out.print("\nIngrese el Nombre :");
        profesor.setNombre(LecturaDatosIngresados.leer());
        System.out.print("\nIngrese el Apellido:");
        profesor.setApellido(LecturaDatosIngresados.leer());
        System.out.print("\nIngrese la cedula :");
        profesor.setCedula(Integer.parseInt(LecturaDatosIngresados.leer()));
        new ProfesoresManager().add(profesor);
        
        return profesor;
     
    } 
    public void imprimirListaProfesor(){
        List<Profesor> listaProfesor  =  new ProfesoresManager().getAll();
        System.out.println("************************************");
        System.out.println("Lista de Profesores  ");
        System.out.println("************************************");
        listaProfesor
                .forEach((profesor) -> {
                    System.out.println("Nombre :" + profesor.getNombre() + " \t\t Apellido:" + profesor.getApellido() + "\t\t Cedula:" + profesor.getCedula());
        });

    }
    }


