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
                materia.setDescripcion(rs.getString("descripcion"));
                materia.setCantidadMaxima(rs.getInt("cantmax"));

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

            String query = ");" + "insert into materia (descripcion, idmateria) "
                    + " VALUES ('" + materia.getDescripcion() + "', " + materia.getCantidadMaxima();
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Materia materia) {
        try {
            String query = "";
            if (materia.getIdMateria() != null) {
                query = ", idmateria ="
                        + "update materias  set descripcion='" + materia.getDescripcion()
                        + " WHERE idMateria =" + materia.getIdMateria();
            } else if (materia.getDescripcion() != null) {
                query = "update materias  set descripcion='" + materia.getDescripcion() + "'"
                        + " WHERE idMateria=" + materia.getDescripcion();
            }
            System.out.println("QUERY: " + query);
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(Materia materia) {
        try {
            String query = "";
            if (materia.getIdMateria() != null) {
                query = "delete from materias  where idmateria=" + materia.getIdMateria();
            } else if (materia.getDescripcion() != null) {
                query = "delete from materias  where descripcion =" + materia.getDescripcion();
            }
            Statement statement = ConnectionManager.connect().createStatement();

            int result = statement.executeUpdate(query);
            if (result > 0) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Materia> cargarListaMateria() {
        System.out.println("Cargando lista de materias");
        System.out.println("---------------------------");
        List<Materia> listaMateria = getAll();
        listaMateria.forEach((materia) -> {
            System.out.println("Materia Inscripta: " + materia);
        });
        return listaMateria;
    }

    public static void main(String[] args) {
 //       new MateriasManager().pruebaGetAll();
        new MateriasManager().pruebaAddMateria();
 //       new MateriasManager().pruebaUpdateMateria();
 //       new MateriasManager().pruebaDeleteMateria();
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
        Materia materia = new Materia(null, "Base", 9);
        boolean resultado = new MateriasManager().add(materia);
        if (resultado) {
            System.out.println("CARGOOO la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    private void pruebaUpdateMateria() {
        System.out.println("Prueba updatemateria ");
        Materia materia = new Materia(null, "Basedd", 99);
        boolean resultado = new MateriasManager().update(materia);
        if (resultado) {
            System.out.println("UPDATE de la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    private void pruebaDeleteMateria() {
        System.out.println("Prueba Delete Materia");
        Materia materia = new Materia(null, "Basedd", 99);
        boolean resultado = new MateriasManager().delete(materia);
        if (resultado) {
            System.out.println("Elimino la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }
}
