/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pride Factor Black
 */
@Entity
@Table(name = "venta_refaccion")
public class VentaRefaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_refaccion", nullable = false)
    private Refaccion refaccion;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precioUnitario", nullable = false)
    private Double precioUnitario;

    public VentaRefaccion() {
    }

    public VentaRefaccion(Long id, Venta venta, Refaccion refaccion, Integer cantidad, Double precioUnitario) {
        this.id = id;
        this.venta = venta;
        this.refaccion = refaccion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public VentaRefaccion(Refaccion refaccion, Integer cantidad, Double precioUnitario) {
        this.refaccion = refaccion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Refaccion getRefaccion() {
        return refaccion;
    }

    public void setRefaccion(Refaccion refaccion) {
        this.refaccion = refaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
