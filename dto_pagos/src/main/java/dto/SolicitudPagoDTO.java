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
    private OrdenDTO orden;
    private MetodoPago metodo;
    private Map<String, String> datosPago;

    public SolicitudPagoDTO() {
    }

    public SolicitudPagoDTO(double monto, OrdenDTO orden, MetodoPago metodo, Map<String, String> datosPago) {
        this.monto = monto;
        this.orden = orden;
        this.metodo = metodo;
        this.datosPago = datosPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public OrdenDTO getOrden() {
        return orden;
    }

    public void setOrden(OrdenDTO orden) {
        this.orden = orden;
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
