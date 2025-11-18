/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import dto.enums.MetodoPago;
import java.util.Map;

/**
 *
 * @author Abraham Coronel
 */
public class SolicitudPagoDTO {

    private double monto;
    private String ordenId;
    private MetodoPago metodo;
    private Map<String, String> datosPago;

    public SolicitudPagoDTO() {
    }

    public SolicitudPagoDTO(double monto, String ordenId, MetodoPago metodo, Map<String, String> datosPago) {
        this.monto = monto;
        this.ordenId = ordenId;
        this.metodo = metodo;
        this.datosPago = datosPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(String ordenId) {
        this.ordenId = ordenId;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public Map<String, String> getDatosPago() {
        return datosPago;
    }

    public void setDatosPago(Map<String, String> datosPago) {
        this.datosPago = datosPago;
    }

}
