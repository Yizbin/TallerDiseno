/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pride Factor Black
 */

@Entity
@Table(name = "ServicioPresupuesto")
public class ServicioPresupuesto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio_presupuesto;
    
    @ManyToOne
    private Servicio servicio;

    @ManyToOne
    private Presupuesto presupuesto;

    public ServicioPresupuesto() {
    }

    public ServicioPresupuesto(Long id_servicio_presupuesto, Servicio servicio, Presupuesto presupuesto) {
        this.id_servicio_presupuesto = id_servicio_presupuesto;
        this.servicio = servicio;
        this.presupuesto = presupuesto;
    }

    public Long getId_servicio_presupuesto() {
        return id_servicio_presupuesto;
    }

    public void setId_servicio_presupuesto(Long id_servicio_presupuesto) {
        this.id_servicio_presupuesto = id_servicio_presupuesto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    
}
