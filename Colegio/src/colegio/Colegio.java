/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import entidades.Alumno;
import entidades.Profesor;

/**
 *
 * @author bustatech
 */
public class Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de colegio EscuelitaSoft");
        Alumno mati = new Alumno(1,"Matias","Bustamante",123123);

        System.out.println("Alumno:" + mati);
        
        
        Profesor manuelJulio = new Profesor(10,"Manuel","Julio",443322);
        System.out.println("Profesor:" + manuelJulio);
        
    }
    
}
