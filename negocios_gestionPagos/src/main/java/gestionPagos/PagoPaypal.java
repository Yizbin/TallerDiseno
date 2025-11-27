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
public class PagoPaypal implements IEstrategiaPago {

    private final IPagoBO pagoBO = PagoBO.getInstancia();
    private final SimuladorBanco paypalApi = SimuladorBanco.getInstancia();

    @Override
    public RespuestaPagoDTO pagar(SolicitudPagoDTO solicitud) {
        String correo = solicitud.getDatosPago().get("correo");
        String contrasena = solicitud.getDatosPago().get("contrasena");

        if (correo == null || !correo.contains("@")) {
            return new RespuestaPagoDTO(false, "Formato de correo inválido", null);
        }

        try {
            paypalApi.autorizarPagoDigital(correo, contrasena, solicitud.getMonto());

            String idTransaccion = "PAY-" + UUID.randomUUID().toString().substring(0, 8);

            PagoDTO nuevoPago = new PagoDTO();
            nuevoPago.setMonto(solicitud.getMonto());
            nuevoPago.setFechaPago(LocalDateTime.now());
            nuevoPago.setMetodoPago(solicitud.getMetodo());
            nuevoPago.setReferencia(idTransaccion);
            nuevoPago.setIdPresupuesto(solicitud.getOrdenId());

            pagoBO.registrarPago(nuevoPago);

            return new RespuestaPagoDTO(true, "Pago con PayPal exitoso", idTransaccion);

        } catch (RuntimeException e) {
            return new RespuestaPagoDTO(false, "PayPal rechazo el pago: " + e.getMessage(), null);
        } catch (NegocioException e) {
            return new RespuestaPagoDTO(false, "Error del sistema: " + e.getMessage(), null);
        }
    }
}
