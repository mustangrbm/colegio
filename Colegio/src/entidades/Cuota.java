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

    public Cuota(Integer idCuota, String descripcion, Date fechaVencimiento) {
        this.idCuota = idCuota;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.pagado=false;
    }
    public void pagarCuota(){
        this.pagado=true;
        this.fechaPago = new Date();
    }
    

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
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
