/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Cuota;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import util.ConnectionManager;

/**
 *
 * @author rodrigo
 */
public class CuotasManager {

    /**
     *
     * @return
     */
    public List<Cuota> getAll() {
        List<Cuota> listaCuota = new ArrayList();
        try {

            String query = "SELECT * FROM CUOTAS  ";
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Cuota cuota = new Cuota();

                cuota.setIdCuota(rs.getInt(""));
                cuota.setDescripcion(rs.getString("descripcion"));
                cuota.setPagado(rs.getBoolean("pagado"));
                cuota.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                cuota.setFechaPago(rs.getDate("fecha_pago"));
                int idAlumno = rs.getInt("idalumno");
                cuota.setAlumno(new AlumnosManager().getById(idAlumno));

                listaCuota.add(cuota);
            }
            return listaCuota;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Cuota getById(Integer idCuota) {

        try {
            Cuota cuota = new Cuota();
            String id_Cuota = null;
            String query = "SELECT * FROM cuotas WHERE idcuota=" + idCuota;
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {

                cuota.setIdCuota(rs.getInt("id_alumno"));
                cuota.setDescripcion(rs.getString("descripcion"));
                cuota.setPagado(rs.getBoolean("pagado"));
                cuota.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                cuota.setFechaPago(rs.getDate("fecha_pago"));
                int idAlumno = rs.getInt("idalumno");
                cuota.setAlumno(new AlumnosManager().getById(idAlumno));
            }
            return cuota;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean add(Cuota cuota) {
        try {
            String id_Cuota = null;
            String query = "INSERT INTO cuotas "
                    + "(idalumno, descripcion, pagado,fecha_vencimiento) "
                    + "VALUES (" + cuota.getAlumno().getIdAlumno()
                    + ",'" + cuota.getDescripcion() + "',false,'"                    
                    + cuota.getFechaVencimiento() + "');";
            System.out.println("QUERY:" + query);
            Statement statement = ConnectionManager.connect().createStatement();
            int res = statement.executeUpdate(query);
            if (res > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean update(Cuota cuota) {
        try {
            String id_Cuota = null;
            String query = "UPDATE  cuotas SET pagado="+ cuota.getPagado() +","+
                    " fecha_pago='" + cuota.getFechaPago()+ "' WHERE idcuota= "+ cuota.getIdCuota();
                
            System.out.println("QUERY:" + query);
            Statement statement = ConnectionManager.connect().createStatement();
            int res = statement.executeUpdate(query);
            if (res > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new CuotasManager().pruebaGetAll();
//        new CuotasManager().pruebaAdd();
 //       new CuotasManager().pruebaUpdate();
        //    new CuotasManager().pruebaGetById();
//        new AlumnosManager().pruebaAddAlumno();
//        new AlumnosManager().pruebaUpdateAlumno();
//        new AlumnosManager().pruebaDeleteAlumno();
    }

    private void pruebaGetAll() {
        System.out.println("Prueba del Cuotas Manager");

        List<Cuota> listaCuota;
        listaCuota = new CuotasManager().getAll();
        for (Cuota cuota : listaCuota) {
            System.out.println("Cuota registrada : " + cuota.getDescripcion()
                    + "Alumno: " + cuota.getAlumno().getNombre() + cuota.getAlumno().getApellido()
                    + "Pagado: " + cuota.getPagado() + cuota.getPagado()
                    + "Fechavencimiento " + cuota.getFechaVencimiento());
        }
    }

    private void pruebaGetById() {
        System.out.println("Prueba de Cuota Manager getById");

        Cuota cuota = new CuotasManager().getById(3);
        if (cuota != null && cuota.getDescripcion() != null) {
            System.out.println("Cuota registrado en la base: " + cuota);
        } else {
            System.out.println("NDOIKOIIII");
        }
    }

    private void pruebaAdd() {
        System.out.println("Prueba de Cuota Manager add");

        Cuota cuota = new Cuota();
        cuota.setAlumno( new AlumnosManager().getById(3));
        cuota.setDescripcion("Cuota Mes Febrero");
        cuota.setPagado(false);
        //Manejo de fechas
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.set(Calendar.MONTH, 1);
        calendario.set(Calendar.YEAR, 2018);
        calendario.set(Calendar.DAY_OF_MONTH, 1);
        cuota.setFechaVencimiento(calendario.getTime());
        
        if (new CuotasManager().add(cuota)) {
            System.out.println("Cuota registrado en la base: " + cuota);
        } else {
            System.out.println("NDOIKOIIII");
        }
    }
    private void pruebaUpdate() {
        System.out.println("Prueba de Cuota Manager update");

        Cuota cuota = new CuotasManager().getById(5);
        cuota.setPagado(true);
        cuota.setFechaPago(new Date());
    
        if (new CuotasManager().update(cuota)) {
            System.out.println("Cuota registrado en la base: " + cuota);
        } else {
            System.out.println("NDOIKOIIII");
        }
    }
}
