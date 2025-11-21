/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionPagos;

import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;

/**
 *
 * @author Abraham Coronel
 */
public class PagoPaypal implements IEstrategiaPago {

    private static final String CORREO = "correo";
    private static final String CONTRASENA = "contrasena";

    @Override
    public RespuestaPagoDTO pagar(SolicitudPagoDTO solicitud) {

        return null;
    }

}
