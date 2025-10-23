/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author Abraham Coronel
 */
public class OrdenDTO {

    private ClienteDTO cliente;

    private VehiculoDTO vehiculo;

    private LocalDateTime fechaIngreso;

    private String fallaReportada;

    private String servicioSolicitado;

    public OrdenDTO() {
    }

    public OrdenDTO(ClienteDTO cliente, VehiculoDTO vehiculo, LocalDateTime fechaIngreso, String fallaReportada, String servicioSolicitado) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
        this.fallaReportada = fallaReportada;
        this.servicioSolicitado = servicioSolicitado;
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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
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

}
