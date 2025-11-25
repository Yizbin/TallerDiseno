/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPagos;

import BO.PagoBO;
import BO.interfaces.IPagoBO;
import dto.PagoDTO;
import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;
import excepciones.NegocioException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author Abraham Coronel
 */
public class PagoTarjeta implements IEstrategiaPago {

    private final IPagoBO pagoBO = PagoBO.getInstancia();

    @Override
    public RespuestaPagoDTO pagar(SolicitudPagoDTO solicitud) {
        String numeroTarjeta = solicitud.getDatosPago().get("numeroTarjeta");
        String cvv = solicitud.getDatosPago().get("cvv");

        if (numeroTarjeta == null || numeroTarjeta.length() < 16 || cvv == null || cvv.length() < 3) {
            return new RespuestaPagoDTO(false, "Datos de tarjeta inválidos", null);
        }

        // Esta para simular un banco
        String idTransaccion = UUID.randomUUID().toString();

        PagoDTO nuevoPago = new PagoDTO();
        nuevoPago.setMonto(solicitud.getMonto());
        nuevoPago.setFechaPago(LocalDateTime.now());
        nuevoPago.setMetodoPago(solicitud.getMetodo());
        nuevoPago.setReferencia(idTransaccion);
        nuevoPago.setIdPresupuesto(obtenerIdPresupuestoPorOrden(solicitud.getOrdenId()));

        try {
            pagoBO.registrarPago(nuevoPago);
            return new RespuestaPagoDTO(true, "Pago con Tarjeta exitoso", idTransaccion);
        } catch (NegocioException e) {
            return new RespuestaPagoDTO(false, "Error guardando pago: " + e.getMessage(), null);
        }
    }

    private String obtenerIdPresupuestoPorOrden(String ordenId) {
        return ordenId;
    }

}
