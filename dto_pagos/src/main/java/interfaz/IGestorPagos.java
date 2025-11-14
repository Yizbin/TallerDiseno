/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;

/**
 *
 * @author Abraham Coronel
 */
public interface IGestorPagos {

    public RespuestaPagoDTO procesarPago(SolicitudPagoDTO solicitud);
}
