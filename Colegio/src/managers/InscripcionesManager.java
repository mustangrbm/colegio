/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Inscripcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionManager;

/**
 *
 * @author bustatech
 */
public class InscripcionesManager {
    
    public List<Inscripcion> getAll() {
        List<Inscripcion> listaInscripciones = new ArrayList();
        try {

            String query = "SELECT * FROM inscripciones ";
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idinscripcion"));
                               
                Integer idMateria=rs.getInt("idmateria");
                inscripcion.setFecha(rs.getDate("fecha"));
                //cargar el alumno
                Integer idAlumno=rs.getInt("idalumno");
                Integer idProfesor = null;
                inscripcion.setAlumno(new AlumnosManager().getById(idProfesor));
                //cargar profesor
                Integer idProfesor=rs.getInt("idprofesor");
                inscripcion.setProfesor(new ProfesoresManager().getById(idProfesor));
               //cargar materia
         
                
                listaInscripciones.add(inscripcion);
            }
            return listaInscripciones;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean add(Inscripcion inscripcion) {
        try {

//            String query = "insert into inscripcions (nombre, apellido, cedula) "
//                    + " VALUES ('" + inscripcion.getNombre() + "', '" + inscripcion.getApellido() + "'," + inscripcion.cedula + ");";
//            Statement statement = ConnectionManager.connect().createStatement();
//
//            int result = statement.executeUpdate(query);
//            if (result > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        return false;
    }

    public boolean update(Inscripcion inscripcion) {
//        try {
//            String query = "";
//            if (inscripcion.getIdInscripcion() != null) {
//                query = "update inscripcions  set nombre='" + inscripcion.getNombre() + "' "
//                        + ",  apellido= '" + inscripcion.getApellido() + "' "
//                        + ", cedula =" + inscripcion.cedula + 
//                        " WHERE idinscripcion =" + inscripcion.getIdInscripcion();
//            }
//            else if (inscripcion.getCedula() != null) {
//                query = "update inscripcions  set nombre='" + inscripcion.getNombre() + "'"
//                        + " ,  apellido= '" + inscripcion.getApellido() + "' "
//                        + " WHERE cedula=" + inscripcion.getCedula();
//            }
//            System.out.println("QUERY: " + query);
//            Statement statement = ConnectionManager.connect().createStatement();
//
//            int result = statement.executeUpdate(query);
//            if (result > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        return false;
    }

    public boolean delete(Inscripcion inscripcion) {
//        try {
//            String query = "";
//            if (inscripcion.getIdInscripcion() != null) {
//                query = "delete from inscripcions  where idinscripcion =" + inscripcion.getIdInscripcion();
//            } else if (inscripcion.getCedula() != null) {
//                query = "delete from inscripcions  where cedula=" + inscripcion.getCedula();
//            }
//            Statement statement = ConnectionManager.connect().createStatement();
//
//            int result = statement.executeUpdate(query);
//            if (result > 0) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        return false;
    }

    

    public List<Inscripcion> cargarListaInscripcions() {
        System.out.println("Cargando lista de inscripcions");
        System.out.println("---------------------------");
        List<Inscripcion> listaInscripciones = getAll();
        for (Inscripcion inscripcion : listaInscripciones) {
            System.out.println("Inscripcion Inscripto: " + inscripcion);
        }
        return listaInscripciones;
    }

    public static void main(String[] args) {
        new InscripcionesManager().pruebaGetAll();    
//        new InscripcionsManager().pruebaAddInscripcion();
//        new InscripcionsManager().pruebaUpdateInscripcion();
//        new InscripcionsManager().pruebaDeleteInscripcion();
    }

    private void pruebaGetAll() {
        System.out.println("Prueba del Inscripcion Manager");

        List<Inscripcion> listaInscripciones = new InscripcionesManager().getAll();
        for (Inscripcion inscripcion : listaInscripciones) {
            System.out.println("Inscripcion registrado en la base: " + inscripcion);
        }
    }
//
//    private void pruebaAddInscripcion() {
//        System.out.println("Prueba Add Inscripcion");
//        Inscripcion inscripcion = new Inscripcion(null, "matute", "matutin", 999999);
//        boolean resultado = new InscripcionsManager().add(inscripcion);
//        if (resultado) {
//            System.out.println("CARGOOO EL ALUMNO");
//        } else {
//            System.out.println("NDEEE NDOIKOI");
//        }
//
//    }
//    private void pruebaUpdateInscripcion() {
//        System.out.println("Prueba Add Inscripcion");
//        Inscripcion inscripcion = new Inscripcion(null, "PAPIRRUIN", "MATUTOO", 999999);
//        boolean resultado = new InscripcionsManager().update(inscripcion);
//        if (resultado) {
//            System.out.println("UPDATE EL ALUMNO");
//        } else {
//            System.out.println("NDEEE NDOIKOI");
//        }
//
//    }
//
//    private void pruebaDeleteInscripcion() {
//        System.out.println("Prueba Delete Inscripcion");
//        Inscripcion inscripcion = new Inscripcion(null, "matute", "matutin", 999999);
//        boolean resultado = new InscripcionsManager().delete(inscripcion);
//        if (resultado) {
//            System.out.println("Elimino EL ALUMNO");
//        } else {
//            System.out.println("NDEEE NDOIKOI");
//        }
//
//    }
}
