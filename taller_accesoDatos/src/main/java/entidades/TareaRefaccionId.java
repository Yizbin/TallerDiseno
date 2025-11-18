/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Abraham Coronel
 */
@Embeddable
public class TareaRefaccionId implements Serializable {

    @Column(name = "id_tareas")
    private Long id_tarea;

    @Column(name = "id_refaccion")
    private Long id_refaccion;

    public TareaRefaccionId() {
    }

    public TareaRefaccionId(Long id_tarea, Long id_refaccion) {
        this.id_tarea = id_tarea;
        this.id_refaccion = id_refaccion;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tareas(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Long getId_refaccion() {
        return id_refaccion;
    }

    public void setId_refaccion(Long id_refaccion) {
        this.id_refaccion = id_refaccion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_tarea, id_refaccion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TareaRefaccionId that = (TareaRefaccionId) obj;
        return Objects.equals(id_tarea, that.id_tarea)
                && Objects.equals(id_refaccion, that.id_refaccion);
    }

}
