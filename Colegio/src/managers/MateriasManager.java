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
                materia.setIdMateria(rs.getInt("idmateria"));

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
                    
            String query =  "insert into materias (descripcion, cantmax) " 
                    + " VALUES ('" + materia.getDescripcion() + "', " + materia.getCantidadMaxima() + ");";
            System.out.println("QUERY:" + query);
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
             query = "update materias set descripcion='Base' where idmateria=4 and cantmax = 9 ";

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
             query = "update materias set descripcion='Base' where idmateria=4 and cantmax = 9 ;";

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

    public List<Materia> cargarListaMateria() {
        System.out.println("Cargando lista de materias");
        System.out.println("---------------------------");
        List<Materia> listaMateria = getAll();
        listaMateria.forEach((materia) -> {
            System.out.println("Materia Inscripta: " + materia);
        });
        return listaMateria;
    }
public Materia getById(Integer idMateria) {
                       
        try {
            Materia materia = new Materia();
            String query = "SELECT * FROM materias WHERE idmateria=" + idMateria;
            Statement statement = ConnectionManager.connect().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(query);
            while (rs.next()) {

                materia.setIdMateria(rs.getInt("idmateria"));
                materia.setDescripcion(rs.getString("descripcion"));
                materia.setCantidadMaxima(rs.getInt("cantmax"));
                
               
            }
            return materia;
        }
        catch(Exception ex){
            System.out.println("Materia - getById error " + ex);
            return null;
        }
    }
    
    
    public static void main(String[] args) {
       new MateriasManager().pruebaGetByIdMateria();
     //  new MateriasManager().pruebaAddMateria();
    //   new MateriasManager().pruebaUpdateMateria();
  //     new MateriasManager().pruebaDeleteMateria();
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
        Materia materia = new Materia(null, "Informatica" , 9);
        boolean resultado = new MateriasManager().add(materia);
        if (resultado) {
            System.out.println("CARGOOO la Materia");
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    private void pruebaUpdateMateria() {
        System.out.println("Prueba updatemateria ");
        Materia materia = new Materia(null, "base", 99);
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

    private void pruebaGetByIdMateria() {
        System.out.println("Prueba getById Materia");
        Materia materia =  new MateriasManager().getById(1);
        if (materia != null && materia.getDescripcion() !=null) {
            System.out.println("Se obtuvo la materia :" + materia);
        } else {
            System.out.println("NDEEE NDOIKOI");
        }

    }

    
}
