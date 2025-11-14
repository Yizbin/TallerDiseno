/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlPagos {

    public RespuestaPagoDTO procesarPago(SolicitudPagoDTO solicitud);
}
