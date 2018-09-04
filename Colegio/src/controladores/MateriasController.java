/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;
import entidades.Materia;
import java.util.List;
import util.LecturaDatosIngresados;

/**
 *
 * @author cbustamante
 */
public class MateriasController {
    public Materia registrarmateria(){
        Materia materia = new Materia();
        System.out.println("************************************");
        System.out.println("Registro de Materia  ");
        System.out.println("************************************");
        System.out.print("\nIngrese la Materia :");
       materia.setMateria(LecturaDatosIngresados.leer());
        
        return materia;
    }
    
    public void imprimirListaMateria(List<Materia> listaMateria){
        System.out.println("************************************");
        System.out.println("Lista de Materia  ");
        System.out.println("************************************");
        Iterable<Materia> listaMaterias = null;
        for (Materia materia : listaMaterias){
            System.out.println("Materia :" + Materia.materia() + ";
                  
        }
        
    }

    public Materia registrarMateria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
