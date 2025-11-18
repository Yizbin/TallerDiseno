/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Orden")
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;

    @Column(name = "fechaIngreso")
    private LocalDate fechaIngreso;

    @Column(name = "fallaReportada")
    private String fallaReportada;

    @Column(name = "servicioSolicitado")
    private String servicioSolicitado;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    @OneToOne(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Presupuesto presupuesto;

    public Orden() {
    }

    public Orden(Long id_orden, LocalDate fechaIngreso, String fallaReportada, String servicioSolicitado, Boolean estado, Cliente cliente, Vehiculo vehiculo, Presupuesto presupuesto) {
        this.id_orden = id_orden;
        this.fechaIngreso = fechaIngreso;
        this.fallaReportada = fallaReportada;
        this.servicioSolicitado = servicioSolicitado;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.presupuesto = presupuesto;
    }

    public Orden(LocalDate fechaIngreso, String fallaReportada, String servicioSolicitado, Boolean estado, Cliente cliente, Vehiculo vehiculo, Presupuesto presupuesto) {
        this.fechaIngreso = fechaIngreso;
        this.fallaReportada = fallaReportada;
        this.servicioSolicitado = servicioSolicitado;
        this.estado = estado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.presupuesto = presupuesto;
    }

    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

}
