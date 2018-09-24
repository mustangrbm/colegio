/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bustatech
 */
public class CuotasController {
//    public Couta ingresarcuota();
    
    public boolean generarCuotasAlumno(Alumno alumno){
        
        try {
            //Generar las cuotas del mes de Febrero a Noviembre
            Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.set(Calendar.MONTH, 1);
        calendario.set(Calendar.MONTH, 2);
        calendario.set(Calendar.MONTH, 3);
        calendario.set(Calendar.MONTH, 4);
        calendario.set(Calendar.MONTH, 5);
        calendario.set(Calendar.MONTH, 6);
        calendario.set(Calendar.MONTH, 7);
        calendario.set(Calendar.MONTH, 8);
        calendario.set(Calendar.MONTH, 9);
        calendario.set(Calendar.MONTH, 10);
        
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
