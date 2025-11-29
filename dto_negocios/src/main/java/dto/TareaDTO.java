/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Abraham Coronel
 */
public class TareaDTO {

    private String idTarea;
    private String descripcion;
    private String costo;
    private String estado;
    private String idOrden;
    private String vehiculoModelo;
    private String vehiculoPlacas;

    public TareaDTO() {
    }

    public TareaDTO(String idTarea, String descripcion, String costo, String estado, String idOrden, String vehiculoModelo, String vehiculoPlacas) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
        this.idOrden = idOrden;
        this.vehiculoModelo = vehiculoModelo;
        this.vehiculoPlacas = vehiculoPlacas;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getVehiculoModelo() {
        return vehiculoModelo;
    }

    public void setVehiculoModelo(String vehiculoModelo) {
        this.vehiculoModelo = vehiculoModelo;
    }

    public String getVehiculoPlacas() {
        return vehiculoPlacas;
    }

    public void setVehiculoPlacas(String vehiculoPlacas) {
        this.vehiculoPlacas = vehiculoPlacas;
    }

}
