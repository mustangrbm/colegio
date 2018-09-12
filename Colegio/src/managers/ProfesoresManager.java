/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Profesor;
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
public class ProfesoresManager {

    public List<Profesor> getAll() {
        List<Profesor> listaProfesor = new ArrayList();
        try {

            String query = "SELECT * FROM PROFESORES ";
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("idprofesores"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setCedula(rs.getInt("cedula"));
                listaProfesor.add(profesor);
            }
            return listaProfesor;

        } catch (SQLException | ClassNotFoundException ex) {
        }
        return null;
    }

    public boolean add(Profesor profesor) {
        try {

            String query = "insert into profesores (nombre, apellido, cedula) "
                    + " VALUES ('" + profesor.getNombre() + "', '" + profesor.getApellido() + "'," + profesor.cedula + ");";
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return false;
    }

    public boolean update(Profesor profesor) {
        try {
            String query = "";
            if (profesor.getIdProfesor() != null) {
                query = "update profesores  set nombre='" + profesor.getNombre() + "' "
                        + ",  apellido= '" + profesor.getApellido() + "' "
                        + ", cedula =" + profesor.cedula + 
                        " WHERE idprofesores =" + profesor.getIdProfesor();
            }
            else if (profesor.getCedula() != null) {
                query = "update profesores  set nombre='" + profesor.getNombre() + "'"
                        + " ,  apellido= '" + profesor.getApellido() + "' "
                        + " WHERE cedula=" + profesor.getCedula();
            }
            System.out.println("QUERY: " + query);
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return false;
    }

    public boolean delete(Profesor profesor) {
        try {
            String query = "";
            if (profesor.getIdProfesor() == null) {
                if (profesor.getCedula() != null) {
                    query = "delete from profesores  where cedula=" + profesor.getCedula();
                }
            } else {
                query = "delete from profesores  where idprofesores =" + profesor.getIdProfesor();
            }
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return false;
    }

    

    public List<Profesor> cargarListaProfesor() {
        System.out.println("Cargando lista de Profesores");
        System.out.println("---------------------------");
        List<Profesor> listaProfesor = getAll();
        listaProfesor.forEach((profesor) -> {
            System.out.println("Profesor Inscripto: " + profesor);
        });
        return listaProfesor;
    }

    public static void main(String[] args) {
        new ProfesoresManager().pruebaGetAll();    
//        new ProfesoresManager().pruebaAddProfesor();
//        new ProfesoresManager().pruebaUpdateProfesor();
//        new ProfesoresManager().pruebaDeleteProfesor();
    }

    private void pruebaGetAll() {
        System.out.println("Prueba del Profesor Manager");

        List<Profesor> listaProfesor = new ProfesoresManager().getAll();
        listaProfesor.forEach((profesor) -> {
            System.out.println("Profesor registrado en la base: " + profesor);
        });
    }

    private void pruebaAddProfesor() {
        System.out.println("Prueba Add Profesor");
        Profesor profesor = new Profesor(null, "benito", "barrios", 999999);
        boolean resultado = new ProfesoresManager().add(profesor);
        if (resultado) {
            System.out.println("CARGOOO EL Profe");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }
    private void pruebaUpdateProfesor() {
        System.out.println("Prueba updateProfesor ");
        Profesor profesor = new Profesor(null, "Bodoke", "barrios", 999999);
        boolean resultado = new ProfesoresManager().update(profesor);
        if (resultado) {
            System.out.println("UPDATE EL PROFESOR");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    private void pruebaDeleteProfesor() {
        System.out.println("Prueba Delete Profesor");
        Profesor profesor = new Profesor(null, "Bodoke", "barrios", 999999);
        boolean resultado = new ProfesoresManager().delete(profesor);
        if (resultado) {
            System.out.println("Elimino EL Profesor");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

}
