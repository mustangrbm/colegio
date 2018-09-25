

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
    private Integer monto;
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
    

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
        
    }
    
    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;    
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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    

    @Override
    public String toString() {
        return "Cuota{" + "idCuota=" + idCuota + ", descripcion=" + descripcion + ", pagado=" + pagado + ", fechaVencimiento=" + fechaVencimiento + ", fechaPago=" + fechaPago + '}';
    }

  
   
}
