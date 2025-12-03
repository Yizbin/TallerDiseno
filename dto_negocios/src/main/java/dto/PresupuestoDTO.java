/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    

    private List<ItemServicioDTO> servicios = new ArrayList<>();
    private List<ItemRefaccionDTO> refacciones = new ArrayList<>();

    public PresupuestoDTO() {
        this.servicios = new ArrayList<>();
        this.refacciones = new ArrayList<>();
        this.costoTotal = 0.0;
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

    public List<ItemServicioDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ItemServicioDTO> servicios) {
        this.servicios = servicios;
    }

    public List<ItemRefaccionDTO> getRefacciones() {
        return refacciones;
    }

    public void setRefacciones(List<ItemRefaccionDTO> refacciones) {
        this.refacciones = refacciones;
    }

     public void addRefaccion(ItemRefaccionDTO item) {
        if (refacciones == null) {
            refacciones = new ArrayList<>();
        }
        refacciones.add(item);
    }
     
     public void addServicio(ItemServicioDTO item) {
        if (servicios == null) {
            servicios = new ArrayList<>();
        }
        servicios.add(item);
}


     
    public void calcularTotal() {
        double suma = 0;

        for (ItemServicioDTO s : servicios) {
            suma += s.getTotal();
        }

        for (ItemRefaccionDTO r : refacciones) {
            suma += r.getTotal();
        }

        this.costoTotal = suma;
    }

    public double getTotal() {
        return costoTotal;
    }
    
   
}
