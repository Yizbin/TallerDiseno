/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author Abraham Coronel
 */
@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_vehiculo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anio")
    private String anio;

    @Column(name = "placas")
    private String placas;

    @Column(name = "km")
    private String km;

    @Column(name = "color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orden> ordenes;

    public Vehiculo() {
    }

    public Vehiculo(Long id_vehiculo, String tipo, String marca, String modelo, String anio, String placas, String km, String color, Cliente cliente, List<Orden> ordenes) {
        this.id_vehiculo = id_vehiculo;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placas = placas;
        this.km = km;
        this.color = color;
        this.cliente = cliente;
        this.ordenes = ordenes;
    }

    public Vehiculo(String tipo, String marca, String modelo, String anio, String placas, String km, String color, Cliente cliente, List<Orden> ordenes) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placas = placas;
        this.km = km;
        this.color = color;
        this.cliente = cliente;
        this.ordenes = ordenes;
    }

    public Long getId() {
        return id_vehiculo;
    }

    public void setId(Long id) {
        this.id_vehiculo = id;
    }

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

}
