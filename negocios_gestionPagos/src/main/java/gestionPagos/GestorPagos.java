/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gestionPagos;

import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;
import dto.enums.MetodoPago;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Abraham Coronel
 */
public class GestorPagos implements IGestorPagos {
    private final Map<MetodoPago, IEstrategiaPago> estrategias;

    public GestorPagos() {
        this.estrategias = new HashMap<>();
        this.estrategias.put(MetodoPago.PAYPAL, new PagoPaypal());
        this.estrategias.put(MetodoPago.MERCADOPAGO, new PagoMercado());
        this.estrategias.put(MetodoPago.TARJETA, new PagoTarjeta());
    }

    @Override
    public RespuestaPagoDTO procesarPago(SolicitudPagoDTO solicitud) {
        IEstrategiaPago estrategia = estrategias.get(solicitud.getMetodo());
        
        if (estrategia == null) {
            return new RespuestaPagoDTO(false, "Metodo de pago vacio", null);
        }
        
        return estrategia.pagar(solicitud);
    }
    
    
}
