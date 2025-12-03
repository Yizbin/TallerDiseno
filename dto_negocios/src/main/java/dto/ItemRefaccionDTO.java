/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Pride Factor Black
 */
public class ItemRefaccionDTO {
   private String nombre;
    private int cantidad;
    private double precioUnitario;

    public ItemRefaccionDTO(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre; 
    }
    public int getCantidad() 
    { return cantidad; 
    }
    public double getPrecioUnitario()
    { return precioUnitario; 
    }
    public double getTotal() {
        return cantidad * precioUnitario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    
}
