/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Pride Factor Black
 */
public class PresupuestoRefaccionDTO {
    private String id;            
    private String idPresupuesto;   
    private String idRefaccion;  
    private Integer cantidad;       
    private Double precioUnitario;  
    
   
    private String nombreRefaccion; 
    private Double total;           

    public PresupuestoRefaccionDTO() {
    }

    public PresupuestoRefaccionDTO(String idRefaccion, Integer cantidad, Double precioUnitario) {
        this.idRefaccion = idRefaccion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(String idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getNombreRefaccion() {
        return nombreRefaccion;
    }

    public void setNombreRefaccion(String nombreRefaccion) {
        this.nombreRefaccion = nombreRefaccion;
    }

    public Double getTotal() {
    
        if (cantidad != null && precioUnitario != null) {
            return cantidad * precioUnitario;
        }
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
