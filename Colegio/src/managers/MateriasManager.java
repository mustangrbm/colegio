/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Materia;
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
public class MateriasManager {
  public List<Materia> getAll() {
        List<Materia> listaMateria = new ArrayList();
        try {

            String query = "SELECT * FROM MATERIAS ";
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idmateria"));
                materia.setDescripcion(rs.getString("Descripcion"));
                materia.setidMateria(rs.getInt("Idmateria"));
                listaMateria.add(materia);
            }
            return listaMateria;

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;

}

  
    public boolean add(Materia materia) {
        try {

            String query = "insert into materia (descripcion, idmateria) "
                    + " VALUES ('" + materia.getDescripcion() + "', " + materia.idMateria + ");";
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return false;
    }

    public boolean update(Materia materia) {
        try {
            String query = "";
            if (materia.getIdMateria() != null) {
                query = ", idmateria ="
                       + "update materia  set descripcion='" + materia.getdescripcion() + "' " + materia.idMateria + 
                        " WHERE idMateria =" + materia.getIdMateria();
            }
            else if (materia.getidMateria() != null) {
                query = "update materia  set descripcion='" + materia.getidMateria() + "'"
                       + " WHERE idMateria=" + materia.getidMateria();
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

    public boolean delete(Materia materia) {
        try {
            String query = "";
            if (materia.getidMateria() == null) {
                if (materia.getidMateria() != null) {
                    query = "delete from materia  where idmateria=" + materia.getidMateria();
                }
            } else {
                query = "delete from materia  where idmateria =" + materia.getIdMateria();
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
    
    public List<Materia> cargarListaMateria() {
        System.out.println("Cargando lista de Profesores");
        System.out.println("---------------------------");
        List<Materia> listaMateria = getAll();
        listaMateria.forEach((materia) -> {
            System.out.println("Materia Inscripta: " + materia);
        });
        return listaMateria;
    }

    public static void main(String[] args) {
        new MateriasManager().pruebaGetAll();    
        new MateriasManager().pruebaAddMateria();
//        new MateriasManager().pruebaUpdateMateria();
//        new MateriasManager().pruebaDeleteMateria();
    }

   private void pruebaGetAll() {
        System.out.println("Prueba del Materias Manager");

        List<Materia> listaMateria = new MateriasManager().getAll();
        listaMateria.forEach((materia) -> {
            System.out.println("materia registrado en la base: " + materia);
        });
    }

    private void pruebaAddMateria() {
        System.out.println("Prueba Add Materia");
        Materia materia = new Materia(null, "ingles", 9);
        boolean resultado = new MateriasManager().add(materia);
        if (resultado) {
            System.out.println("CARGOOO la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }
    private void pruebaUpdateMateria() {
        System.out.println("Prueba updatemateria ");
        Materia materia = new Materia(null, "Ingles", 99);
        boolean resultado = new MateriasManager().update(materia);
        if (resultado) {
            System.out.println("UPDATE de la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    private void pruebaDeleteMateria() {
        System.out.println("Prueba Delete Materia");
        Materia materia = new Materia(null, "Ingles", 99);
        boolean resultado = new MateriasManager().delete(materia);
        if (resultado) {
            System.out.println("Elimino la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }
        }



