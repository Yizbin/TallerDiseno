/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Presupuesto")
public class Presupuesto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_presupuesto;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name = "costoTotal")
    private double costoTotal;

    @Column(name = "estado")
    private Boolean estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden", unique = true, nullable = false)
    private Orden orden;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;


    @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tarea> tareas;


    @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresupuestoRefaccion> refacciones = new ArrayList<>();

    @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicioPresupuesto> servicios = new ArrayList<>();


    public Presupuesto() {
        this.refacciones = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.tareas = new ArrayList<>();
    }

    public Presupuesto(Long id_presupuesto, LocalDate fechaCreacion, double costoTotal, Boolean estado, Orden orden, List<Tarea> tareas) {
        this.id_presupuesto = id_presupuesto;
        this.fechaCreacion = fechaCreacion;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.orden = orden;
        this.tareas = tareas;
        this.refacciones = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public Presupuesto(LocalDate fechaCreacion, double costoTotal, Boolean estado, Orden orden, List<Tarea> tareas) {
        this.fechaCreacion = fechaCreacion;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.orden = orden;
        this.tareas = tareas;
        this.refacciones = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public Long getId() {
        return id_presupuesto;
    }

    public void setId(Long id) {
        this.id_presupuesto = id;
    }

    public Long getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(Long id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<PresupuestoRefaccion> getRefacciones() {
        return refacciones;
    }

    public void setRefacciones(List<PresupuestoRefaccion> refacciones) {
        this.refacciones = refacciones;
        if (refacciones != null) {
            for (PresupuestoRefaccion pr : refacciones) {
                pr.setPresupuesto(this);
            }
        }
    }

    public List<ServicioPresupuesto> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioPresupuesto> servicios) {
        this.servicios = servicios;
        if (servicios != null) {
            for (ServicioPresupuesto sp : servicios) {
                sp.setPresupuesto(this);
            }
        }
    }
}