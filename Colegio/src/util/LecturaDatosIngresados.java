/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author cbustamante
 */
public class LecturaDatosIngresados {
    public static String leer() {
        String opcionSeleccionada;
        Scanner scanInput = new Scanner(System.in);
        opcionSeleccionada = scanInput.nextLine();//leer la opcion ingresada            
        return opcionSeleccionada;
    }
}
