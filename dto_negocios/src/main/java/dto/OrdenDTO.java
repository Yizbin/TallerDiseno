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
public class OrdenDTO {

    private ClienteDTO cliente;

    private VehiculoDTO vehiculo;

    private LocalDate fechaIngreso;

    private String fallaReportada;

    private String servicioSolicitado;

    private Boolean estado; 

    public OrdenDTO() {
    }

    public OrdenDTO(ClienteDTO cliente, VehiculoDTO vehiculo, LocalDate fechaIngreso, String fallaReportada, String servicioSolicitado, Boolean estado) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
        this.fallaReportada = fallaReportada;
        this.servicioSolicitado = servicioSolicitado;
        this.estado = estado;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFallaReportada() {
        return fallaReportada;
    }

    public void setFallaReportada(String fallaReportada) {
        this.fallaReportada = fallaReportada;
    }

    public String getServicioSolicitado() {
        return servicioSolicitado;
    }

    public void setServicioSolicitado(String servicioSolicitado) {
        this.servicioSolicitado = servicioSolicitado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
