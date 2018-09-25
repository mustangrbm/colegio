/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import entidades.Cuota;
import java.util.Calendar;
import java.util.Date;
import managers.CuotasManager;

/**
 *
 * @author bustatech
 */
public class CuotasController {
//    public Couta ingresarcuota();
    static final double MONTOCUOTA=3000000d;
    

    public boolean generarCuotasAlumno() {

        //1- Seleccionar el alumno
        Alumno alumnoSeleccionado = new AlumnosController().seleccionarAlumno();

        try {
            //Generar las cuotas del mes de Febrero a Noviembre
            for (int i = 1; i <= 10; i++) {
                Calendar vencimiento = Calendar.getInstance();
                vencimiento.setTime(new Date());
                vencimiento.set(Calendar.MONTH, i);
                vencimiento.set(Calendar.DAY_OF_MONTH, 1);
                Cuota cuota = new Cuota();
                cuota.setAlumno(alumnoSeleccionado);
                cuota.setDescripcion("Cuota del mes #" + (i +1));
                cuota.setFechaVencimiento(vencimiento.getTime());
                cuota.setMonto(MONTOCUOTA);
                if (new CuotasManager().add(cuota)) {
                    System.out.println("Cuota del mes agregada #" +i);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   

    public void imprimirListaCuotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
