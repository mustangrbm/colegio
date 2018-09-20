/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Inscripcion;
import entidades.Materia;
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

                Integer idMateria = rs.getInt("idmateria");
                inscripcion.setFecha(rs.getDate("fecha"));
                //cargar el alumno
                Integer idAlumno = rs.getInt("idalumno");
                Integer idProfesor = null;
                inscripcion.setAlumno(new AlumnosManager().getById(idAlumno));
                //cargar profesor
                idProfesor = rs.getInt("idprofesor");
                inscripcion.setProfesor(new ProfesoresManager().getById(idProfesor));
                //cargar materia
                idMateria = rs.getInt("idmateria");
                inscripcion.setMateria(new MateriasManager().getById(idMateria));
                inscripcion.setFecha(rs.getDate("fecha"));
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
            String query = "insert into inscripciones (idalumno,idmateria, idprofesor) "
                    + " VALUES (" + inscripcion.getAlumno().getIdAlumno() + ","
                    + inscripcion.getMateria().getIdMateria() + ","
                    + inscripcion.getProfesor().getIdProfesor() + ");";
            Statement statement = ConnectionManager.connect().createStatement();
            System.out.println("QUERY ADD INSCRIPCION:" + query);

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

   
    public static void main(String[] args) {
        new InscripcionesManager().pruebaGetAll();
        new InscripcionesManager().pruebaAddInscripcion();
        new InscripcionesManager().pruebaGetAll();

//        new InscripcionsManager().pruebaUpdateInscripcion();
//        new InscripcionsManager().pruebaDeleteInscripcion();
    }

    private void pruebaGetAll() {
        System.out.println("Prueba del Inscripcion Manager");

        List<Inscripcion> listaInscripciones = new InscripcionesManager().getAll();
        for (Inscripcion inscripcion : listaInscripciones) {
            System.out.println("Inscripcion registradas : " + inscripcion.getIdInscripcion()
                    + "Alumno: " + inscripcion.getAlumno().getNombre() + inscripcion.getAlumno().getApellido()
                    + "Profesor: " + inscripcion.getProfesor().getNombre() + inscripcion.getProfesor().getApellido()
                    + "Materia: " + inscripcion.getMateria().getDescripcion()
                    + "Fecha: " + inscripcion.getFecha());
        }
    }
    private void pruebaAddInscripcion(){
        Inscripcion inscripcion =new Inscripcion ();
        inscripcion.setAlumno(new AlumnosManager().getById(1));
        inscripcion.setProfesor(new ProfesoresManager().getById(1));
        inscripcion.setMateria(new MateriasManager().getById(1));
        new InscripcionesManager().add(inscripcion);
    }

}
