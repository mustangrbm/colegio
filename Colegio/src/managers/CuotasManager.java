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
import java.util.List;
import util.ConnectionManager;

/**
 *
 * @author rodrigo
 */
public class CuotasManager {
    

    public List<Cuota> getAll()
{
        List<Cuota> listaCuota = new ArrayList();
        try {

            String query = "SELECT * FROM CUOTA ";
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Cuota cuota = new Cuota();
                cuota.setIdCuota(rs.getInt("idcuota"));
                cuota.setDescripcion(rs.getString("Descripcion"));
                cuota.setPago(rs.getString("pago"));
                cuota.setFecha_vencimiento(rs.getInt("fecha_vencimiento"));
                listaCuota.add(cuota);
            }
            return listaCuota;

        } catch (SQLException | ClassNotFoundException ex) {
        }
        return null;
 }       
 public Cuota getById(Integer idAlumno)  {
       
     try {
            Cuota cuota = new Cuota();
            String query = "SELECT * FROM Cuota WHERE idcuota=" + idAlumno;
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {

                cuota.setIdCuota(rs.getInt("idcuota"));
                cuota.setDescripcion(rs.getString("descripcion"));
                cuota.setPago(rs.getString("Pago"));
                cuota.setFecha_vencimiento(rs.getInt("fecha_vencimiento"));
               
            }
            return cuota;
} 
     catch (SQLException | ClassNotFoundException ex) {
        }
        return null;
    }
public static void main(String[] args) {
       new CuotaManager().pruebaGetAll();    
//       new CuotasManager().pruebaGetById();
//        new AlumnosManager().pruebaAddAlumno();
//        new AlumnosManager().pruebaUpdateAlumno();
//        new AlumnosManager().pruebaDeleteAlumno();
    }

    private void pruebaGetById() {
        System.out.println("Prueba de Cuota Manager getById");

        Cuota cuota = new CuotasManager().getById(3);
        if (cuota !=null && cuota.getDescripcion() !=null){
                        System.out.println("Cuota registrado en la base: " + cuota);
        }
        else
        {
            System.out.println("NDOIKOIIII");
        }
        }
     

    } 
      