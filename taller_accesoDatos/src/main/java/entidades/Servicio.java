/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pride Factor Black
 */
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="precio")
    private double precio;
    
     @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
     private Set<ServicioPresupuesto> serviciosEnPresupuestos;

    public Servicio() {
    }

    public Servicio(Long id_servicio, String nombre, String descripcion, double precio, Set<ServicioPresupuesto> serviciosEnPresupuestos) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.serviciosEnPresupuestos = serviciosEnPresupuestos;
    }

    public Servicio(String nombre, String descripcion, double precio, Set<ServicioPresupuesto> serviciosEnPresupuestos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.serviciosEnPresupuestos = serviciosEnPresupuestos;
    }

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<ServicioPresupuesto> getServiciosEnPresupuestos() {
        return serviciosEnPresupuestos;
    }

    public void setServiciosEnPresupuestos(Set<ServicioPresupuesto> serviciosEnPresupuestos) {
        this.serviciosEnPresupuestos = serviciosEnPresupuestos;
    }
    
     
}
