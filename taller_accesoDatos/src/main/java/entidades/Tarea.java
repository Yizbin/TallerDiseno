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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Tarea")
public class Tarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tarea;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private String costo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_presupuesto", nullable = false)
    private Presupuesto presupuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TareaRefaccion> refaccionesUsadas;

    public Tarea() {
    }

    public Tarea(Long id_tarea, String descripcion, String costo, String estado, Presupuesto presupuesto, Empleado empleado, Set<TareaRefaccion> refaccionesUsadas) {
        this.id_tarea = id_tarea;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
        this.presupuesto = presupuesto;
        this.empleado = empleado;
        this.refaccionesUsadas = refaccionesUsadas;
    }

    public Tarea(String descripcion, String costo, String estado, Presupuesto presupuesto, Empleado empleado, Set<TareaRefaccion> refaccionesUsadas) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
        this.presupuesto = presupuesto;
        this.empleado = empleado;
        this.refaccionesUsadas = refaccionesUsadas;
    }

    public Long getId() {
        return id_tarea;
    }

    public void setId(Long id) {
        this.id_tarea = id;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
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

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Set<TareaRefaccion> getRefaccionesUsadas() {
        return refaccionesUsadas;
    }

    public void setRefaccionesUsadas(Set<TareaRefaccion> refaccionesUsadas) {
        this.refaccionesUsadas = refaccionesUsadas;
    }

}
