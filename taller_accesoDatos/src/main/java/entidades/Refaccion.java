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
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Refaccion")
public class Refaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_refaccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioUnitario")
    private double precioUnitario;

    @Column(name = "stock")
    private int stock;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "refaccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TareaRefaccion> tareasDondeSeUsa;

    public Refaccion() {
    }

    public Refaccion(Long id_refaccion, String nombre, String descripcion, double precioUnitario,
                     int stock, String estado, Set<TareaRefaccion> tareasDondeSeUsa) {
        this.id_refaccion = id_refaccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
        this.tareasDondeSeUsa = tareasDondeSeUsa;
    }

    public Refaccion(String nombre, String descripcion, double precioUnitario,
                     int stock, String estado, Set<TareaRefaccion> tareasDondeSeUsa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
        this.tareasDondeSeUsa = tareasDondeSeUsa;
    }

    public Long getId() {
        return id_refaccion;
    }

    public void setId(Long id) {
        this.id_refaccion = id;
    }

    public Long getId_refaccion() {
        return id_refaccion;
    }

    public void setId_refaccion(Long id_refaccion) {
        this.id_refaccion = id_refaccion;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // ⭐️ Getter y setter del campo nuevo
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<TareaRefaccion> getTareasDondeSeUsa() {
        return tareasDondeSeUsa;
    }

    public void setTareasDondeSeUsa(Set<TareaRefaccion> tareasDondeSeUsa) {
        this.tareasDondeSeUsa = tareasDondeSeUsa;
    }
}
