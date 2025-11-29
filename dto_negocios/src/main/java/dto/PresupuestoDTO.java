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

    private OrdenDTO orden;
    
    private ClienteDTO cliente;

    public PresupuestoDTO() {
    }

    public PresupuestoDTO(String idPresupuesto, LocalDate fechaCreacion, Double costoTotal, Boolean estado, OrdenDTO orden, ClienteDTO cliente) {
        this.idPresupuesto = idPresupuesto;
        this.fechaCreacion = fechaCreacion;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.orden = orden;
        this.cliente = cliente;
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

    public OrdenDTO getOrden() {
        return orden;
    }

    public void setOrden(OrdenDTO orden) {
        this.orden = orden;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    
}
