/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author bustatech
 */
public class Cuota {
    private Integer idCuota;
    private String descripcion;
    private Boolean pagado;
    private Date fechaVencimiento;
    private Date fechaPago;
    private Alumno alumno;
    public Cuota(){
        
    }
    public Cuota(Alumno alumno, String descripcion, Date fechaVencimiento) {
        this.idCuota = idCuota;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.pagado=false;
        this.alumno= alumno;
    }
    public void pagarCuota(){
        this.pagado=true;
        this.fechaPago = new Date();
    }
    

    
    public Integer getmonto() {
        Integer monto = null;
        return monto;
    }

    public void setMonto(Integer Monto) {
        Integer monto = null;
          this.getmonto() = monto;
        
                
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

   
    
    
    
    

    @Override
    public String toString() {
        return "Cuota{" + "idCuota=" + idCuota + ", descripcion=" + descripcion + ", pagado=" + pagado + ", fechaVencimiento=" + fechaVencimiento + ", fechaPago=" + fechaPago + '}';
    }

  
   
}
