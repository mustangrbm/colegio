/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import entidades.Cuota;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import managers.CuotasManager;

/**
 *
 * @author bustatech
 */
public class CuotasController {
//    public Couta ingresarcuota();

    static final double MONTOCUOTA = 300000d;

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
                cuota.setDescripcion("Cuota del mes #" + (i + 1));
                cuota.setFechaVencimiento(vencimiento.getTime());
                cuota.setMonto(MONTOCUOTA);
                if (new CuotasManager().add(cuota)) {
                    System.out.println("Cuota del mes agregada #" + i);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void estadoCuentasPorAlumno() {
        //1- Seleccionar el alumno
        Alumno alumnoSeleccionado = new AlumnosController().seleccionarAlumno();
        List<Cuota> listaCuotas = new CuotasManager().getByAlumno(alumnoSeleccionado.getIdAlumno());
        System.out.println("Estado de cuentas del Alumno: " + alumnoSeleccionado.getNombre() + "  " + alumnoSeleccionado.getApellido());
        Double totalAPagar = 0d;
        if (listaCuotas != null) {
            System.out.println("Fecha Vencimiento \t\t Fecha Pago \t\t  Monto \t\t Estado");
            for (Cuota cuota : listaCuotas) {
                System.out.println(cuota.getFechaVencimiento() + "\t\t\t " + cuota.getFechaPago() + "\t\t\t" + cuota.getMonto() + "\t\t\t" + cuota.getPagado());
                if (cuota.getPagado() == false) {
                    totalAPagar = totalAPagar + cuota.getMonto();
                }
            }
            DecimalFormat df = new DecimalFormat("###,###,###.##");

            System.out.println("Total pendiente a pagar: " + df.format(totalAPagar));
        }

    }
}
