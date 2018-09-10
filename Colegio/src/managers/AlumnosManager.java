/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionManager;

/**
 *
 * @author cbustamante
 */
public class AlumnosManager {

    public List<Alumno> getAll() {
        List<Alumno> listaAlumnos = new ArrayList();
        try {

            String query = "SELECT * FROM ALUMNOS ";
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idalumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setCedula(rs.getInt("cedula"));
                listaAlumnos.add(alumno);
            }
            return listaAlumnos;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean add(Alumno alumno) {
        try {

            String query = "insert into alumnos (nombre, apellido, cedula) "
                    + " VALUES ('" + alumno.getNombre() + "', '" + alumno.getApellido() + "'," + alumno.cedula + ");";
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Alumno alumno) {
        try {
            String query = "";
            if (alumno.getIdAlumno() != null) {
                query = "update alumnos  set nombre='" + alumno.getNombre() + "' "
                        + ",  apellido= '" + alumno.getApellido() + "' "
                        + ", cedula =" + alumno.cedula + 
                        " WHERE idalumno =" + alumno.getIdAlumno();
            }
            else if (alumno.getCedula() != null) {
                query = "update alumnos  set nombre='" + alumno.getNombre() + "'"
                        + " ,  apellido= '" + alumno.getApellido() + "' "
                        + " WHERE cedula=" + alumno.getCedula();
            }
            System.out.println("QUERY: " + query);
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(Alumno alumno) {
        try {
            String query = "";
            if (alumno.getIdAlumno() != null) {
                query = "delete from alumnos  where idalumno =" + alumno.getIdAlumno();
            } else if (alumno.getCedula() != null) {
                query = "delete from alumnos  where cedula=" + alumno.getCedula();
            }
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    

    public List<Alumno> cargarListaAlumnos() {
        System.out.println("Cargando lista de alumnos");
        System.out.println("---------------------------");
        List<Alumno> listaAlumnos = getAll();
        for (Alumno alumno : listaAlumnos) {
            System.out.println("Alumno Inscripto: " + alumno);
        }
        return listaAlumnos;
    }

    public static void main(String[] args) {
//        new AlumnosManager().pruebaGetAll();    
        new AlumnosManager().pruebaAddAlumno();
        new AlumnosManager().pruebaUpdateAlumno();
        new AlumnosManager().pruebaDeleteAlumno();
    }

    private void pruebaGetAll() {
        System.out.println("Prueba del Alumno Manager");

        List<Alumno> listaAlumnos = new AlumnosManager().getAll();
        for (Alumno alumno : listaAlumnos) {
            System.out.println("Alumno registrado en la base: " + alumno);
        }
    }

    private void pruebaAddAlumno() {
        System.out.println("Prueba Add Alumno");
        Alumno alumno = new Alumno(null, "matute", "matutin", 999999);
        boolean resultado = new AlumnosManager().add(alumno);
        if (resultado) {
            System.out.println("CARGOOO EL ALUMNO");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }
    private void pruebaUpdateAlumno() {
        System.out.println("Prueba Add Alumno");
        Alumno alumno = new Alumno(null, "PAPIRRUIN", "MATUTOO", 999999);
        boolean resultado = new AlumnosManager().update(alumno);
        if (resultado) {
            System.out.println("UPDATE EL ALUMNO");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    private void pruebaDeleteAlumno() {
        System.out.println("Prueba Delete Alumno");
        Alumno alumno = new Alumno(null, "matute", "matutin", 999999);
        boolean resultado = new AlumnosManager().delete(alumno);
        if (resultado) {
            System.out.println("Elimino EL ALUMNO");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

}
