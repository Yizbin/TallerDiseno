/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Abraham Coronel
 */
public class RefaccionDTO {

    private String id_refaccion;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private int stock;
    private String estado;

    public RefaccionDTO() {
    }

    public RefaccionDTO(String id_refaccion, String nombre, String descripcion, double precioUnitario, int stock, String estado) {
        this.id_refaccion = id_refaccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
    }

    public RefaccionDTO(String nombre, String descripcion, double precioUnitario, int stock, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
