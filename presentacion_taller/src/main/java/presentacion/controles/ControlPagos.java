/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;
import gestionPagos.IGestorPagos;

/**
 *
 * @author Abraham Coronel
 */
public class ControlPagos implements IControlPagos {

    private final IGestorPagos pagos;

    public ControlPagos(IGestorPagos pagos) {
        this.pagos = pagos;
    }

    @Override
    public RespuestaPagoDTO procesarPago(SolicitudPagoDTO solicitud) {
        return pagos.procesarPago(solicitud);
    }

}
