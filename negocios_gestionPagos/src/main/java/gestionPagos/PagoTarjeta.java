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
import gestionPagos.banco.SimuladorBanco;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author Abraham Coronel
 */
public class PagoTarjeta implements IEstrategiaPago {

    private final IPagoBO pagoBO = PagoBO.getInstancia();
    private final SimuladorBanco bancoExterno = SimuladorBanco.getInstancia();

    @Override
    public RespuestaPagoDTO pagar(SolicitudPagoDTO solicitud) {
        String numeroTarjeta = solicitud.getDatosPago().get("numeroTarjeta");
        String cvv = solicitud.getDatosPago().get("cvv");

        if (numeroTarjeta == null || numeroTarjeta.length() < 16) {
            return new RespuestaPagoDTO(false, "Formato de tarjeta inválido", null);
        }

        try {
            bancoExterno.autorizarPagoTarjeta(numeroTarjeta, cvv, solicitud.getMonto());

            String idTransaccion = UUID.randomUUID().toString();

            PagoDTO nuevoPago = new PagoDTO();
            nuevoPago.setMonto(solicitud.getMonto());
            nuevoPago.setFechaPago(LocalDateTime.now());
            nuevoPago.setMetodoPago(solicitud.getMetodo());
            nuevoPago.setReferencia(idTransaccion);
            nuevoPago.setIdPresupuesto(solicitud.getOrdenId());

            pagoBO.registrarPago(nuevoPago);

            return new RespuestaPagoDTO(true, "Pago aprobado.", idTransaccion);

        } catch (RuntimeException e) {
            return new RespuestaPagoDTO(false, "Rechazado por el banco: " + e.getMessage(), null);
        } catch (NegocioException e) {
            return new RespuestaPagoDTO(false, "Error interno guardando el pago: " + e.getMessage(), null);
        }
    }

}
