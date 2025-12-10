/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "fechaPago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "metodoPago", nullable = false)
    private String metodoPago;

    @Column(name = "referencia")
    private String referencia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_presupuesto", nullable = true) 
    private Presupuesto presupuesto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = true)
    private Venta venta;

    public Pago() {
    }

    public Pago(Double monto, LocalDateTime fechaPago, String metodoPago, String referencia, Presupuesto presupuesto) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.referencia = referencia;
        this.presupuesto = presupuesto;
        this.venta = null;
    }

    public Pago(Double monto, LocalDateTime fechaPago, String metodoPago, String referencia, Venta venta) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.referencia = referencia;
        this.venta = venta;
        this.presupuesto = null; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
        // Si asignamos presupuesto, nos aseguramos que venta sea null (opcional, por seguridad)
        if(presupuesto != null) {
            this.venta = null;
        }
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
        // Si asignamos venta, nos aseguramos que presupuesto sea null (opcional, por seguridad)
        if(venta != null) {
            this.presupuesto = null;
        }
    }

}
