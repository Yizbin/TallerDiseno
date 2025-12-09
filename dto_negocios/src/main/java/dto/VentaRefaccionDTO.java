/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Pride Factor Black
 */
public class VentaRefaccionDTO {
    private String id;
    private String id_refaccion;
    private String nombre;
    private Double precioUnitario;
    private int cantidad;

    public VentaRefaccionDTO() {
    }

    public VentaRefaccionDTO(String id, String id_refaccion, String nombre, Double precioUnitario, int cantidad) {
        this.id = id;
        this.id_refaccion = id_refaccion;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public VentaRefaccionDTO(String id_refaccion, String nombre, Double precioUnitario, int cantidad) {
        this.id_refaccion = id_refaccion;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_refaccion() {
        return id_refaccion;
    }

    public void setId_refaccion(String id_refaccion) {
        this.id_refaccion = id_refaccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    
}
