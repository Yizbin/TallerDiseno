/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "tarea_refaccion")
public class TareaRefaccion implements Serializable {

    @EmbeddedId
    private TareaRefaccionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_tarea")
    @JoinColumn(name = "id_tarea")
    private Tarea tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_refaccion")
    @JoinColumn(name = "id_refaccion")
    private Refaccion refaccion;

    @Column(name = "cantidadUsada")
    private int cantidadUsada;

    public TareaRefaccion() {
    }

    public TareaRefaccion(TareaRefaccionId id, Tarea tarea, Refaccion refaccion, int cantidadUsada) {
        this.id = id;
        this.tarea = tarea;
        this.refaccion = refaccion;
        this.cantidadUsada = cantidadUsada;
    }

    public TareaRefaccion(Tarea tarea, Refaccion refaccion, int cantidadUsada) {
        this.tarea = tarea;
        this.refaccion = refaccion;
        this.cantidadUsada = cantidadUsada;
    }

    public TareaRefaccionId getId() {
        return id;
    }

    public void setId(TareaRefaccionId id) {
        this.id = id;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Refaccion getRefaccion() {
        return refaccion;
    }

    public void setRefaccion(Refaccion refaccion) {
        this.refaccion = refaccion;
    }

    public int getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(int cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

}
