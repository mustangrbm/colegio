/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Profesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cbustamante
 */
public class ProfesoresManager {
    public List<Profesor> cargarListaProfesores() {
        List<Profesor> listaProfesores = new ArrayList();
        System.out.println("Cargando lista de Profesores");
        System.out.println("---------------------------");

        listaProfesores = obtenerListaProfesores();
        for (Profesor profe : listaProfesores) {
            System.out.println("Profesores Habilitados: " + profe);
        }
        return listaProfesores;
    }
    private List<Profesor> obtenerListaProfesores() {
        List<Profesor> listaProfesores = new ArrayList();
        Profesor chapatin = new Profesor(1, "Chapatin", "Bonaparte", 32123);
        Profesor manuelJulio = new Profesor(2, "Manuel", "Julio", 323443252);
        listaProfesores.add(chapatin);
        listaProfesores.add(manuelJulio);
        return listaProfesores;
    }
    
}
