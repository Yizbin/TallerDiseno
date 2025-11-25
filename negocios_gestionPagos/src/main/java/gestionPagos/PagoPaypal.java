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
public class PagoPaypal implements IEstrategiaPago {

    private final IPagoBO pagoBO = PagoBO.getInstancia();

    @Override
    public RespuestaPagoDTO pagar(SolicitudPagoDTO solicitud) {

        String correo = solicitud.getDatosPago().get("correo");
        String contrasena = solicitud.getDatosPago().get("contrasena");

        if (correo == null || correo.trim().isEmpty() || !correo.contains("@")) {
            return new RespuestaPagoDTO(false, "Correo de PayPal inválido", null);
        }
        if (contrasena == null || contrasena.trim().isEmpty()) {
            return new RespuestaPagoDTO(false, "La contraseña es obligatoria", null);
        }

        String idTransaccion = "PAYPAL-" + UUID.randomUUID().toString().substring(0, 8);

        PagoDTO nuevoPago = new PagoDTO();
        nuevoPago.setMonto(solicitud.getMonto());
        nuevoPago.setFechaPago(LocalDateTime.now());
        nuevoPago.setMetodoPago(solicitud.getMetodo());
        nuevoPago.setReferencia(idTransaccion);
        nuevoPago.setIdPresupuesto(solicitud.getOrdenId());

        try {
            pagoBO.registrarPago(nuevoPago);
            return new RespuestaPagoDTO(true, "Pago con PayPal exitoso", idTransaccion);
        } catch (NegocioException e) {
            return new RespuestaPagoDTO(false, "Error guardando pago: " + e.getMessage(), null);
        }
    }
}
