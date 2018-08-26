/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author cbustamante
 */
public class Persona {
    public String nombre;
    public String apellido;
    public Integer cedula;

    public Persona() {        
    }
    
    public Persona(String nombre, String apellido, Integer cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    
    
}
