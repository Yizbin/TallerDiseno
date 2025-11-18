/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Abraham Coronel
 */
public class VehiculoDTO {

    private String marca;

    private String modelo;

    private String anio;

    private String placas;

    private String km;

    private String color;

    private ClienteDTO cliente;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String marca, String modelo, String anio, String placas, String km, String color, ClienteDTO cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placas = placas;
        this.km = km;
        this.color = color;
        this.cliente = cliente;
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

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

}
