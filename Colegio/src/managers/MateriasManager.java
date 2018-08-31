/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entidades.Materia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cbustamante
 */
public class MateriasManager {

    public List<Materia> cargarListaMaterias() {
        List<Materia> listaMaterias = new ArrayList();
        System.out.println("Cargando lista de Materias");
        System.out.println("---------------------------");

        listaMaterias = obtenerListaMaterias();
        for (Materia materia : listaMaterias) {
            System.out.println("Materias Habilitadas : " + materia);
        }
        return listaMaterias;
    }

    private List<Materia> obtenerListaMaterias() {
        List<Materia> listaMateria = new ArrayList();
        Materia Matematica = new Materia(1, "Matematica", 30);
        Materia Sql = new Materia(2, "Sql", 40);
        listaMateria.add(Matematica);
        listaMateria.add(Sql);
        return listaMateria;
    }

}
