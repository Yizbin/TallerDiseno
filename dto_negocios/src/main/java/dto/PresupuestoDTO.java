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

    private List<PresupuestoRefaccionDTO> refacciones;
    private List<ServicioPresupuestoDTO> servicios;

    public PresupuestoDTO() {
        this.refacciones = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.costoTotal = 0.0;
        this.estado = true;
        this.fechaCreacion = LocalDate.now(); 
    }

    public PresupuestoDTO(String idPresupuesto, LocalDate fechaCreacion, Double costoTotal, Boolean estado, OrdenDTO orden, ClienteDTO cliente) {
        this.idPresupuesto = idPresupuesto;
        this.fechaCreacion = fechaCreacion;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.orden = orden;
        this.cliente = cliente;
        this.refacciones = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public void calcularTotal() {
        double total = 0.0;

        if (this.refacciones != null) {
            for (PresupuestoRefaccionDTO r : this.refacciones) {
                if (r.getTotal() != null) {
                    total += r.getTotal();
                } else if (r.getCantidad() != null && r.getPrecioUnitario() != null) {
                    total += (r.getCantidad() * r.getPrecioUnitario());
                }
            }
        }

        if (this.servicios != null) {
            for (ServicioPresupuestoDTO s : this.servicios) {
                if (s.getCosto() != null) {
                    total += s.getCosto();
                }
            }
        }

        this.costoTotal = total;
    }

    public void addRefaccion(PresupuestoRefaccionDTO ref) {
        if (this.refacciones == null) {
            this.refacciones = new ArrayList<>();
        }
        this.refacciones.add(ref);
        calcularTotal(); 
    }

    public void addServicio(ServicioPresupuestoDTO serv) {
        if (this.servicios == null) {
            this.servicios = new ArrayList<>();
        }
        this.servicios.add(serv);
        calcularTotal(); 
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

    public List<PresupuestoRefaccionDTO> getRefacciones() {
        return refacciones;
    }

    public void setRefacciones(List<PresupuestoRefaccionDTO> refacciones) {
        this.refacciones = refacciones;
        calcularTotal(); 
    }

    public List<ServicioPresupuestoDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioPresupuestoDTO> servicios) {
        this.servicios = servicios;
        calcularTotal();
    }
     
}
