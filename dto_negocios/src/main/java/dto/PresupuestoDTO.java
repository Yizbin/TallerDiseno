/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoDTO {

    private String idPresupuesto;

    private LocalDate fechaCreacion;

    private Double costoTotal;

    private Boolean estado;

    private String idOrden;

    public PresupuestoDTO() {
    }

    public PresupuestoDTO(String idPresupuesto, LocalDate fechaCreacion, Double costoTotal, Boolean estado, String idOrden) {
        this.idPresupuesto = idPresupuesto;
        this.fechaCreacion = fechaCreacion;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.idOrden = idOrden;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

}
