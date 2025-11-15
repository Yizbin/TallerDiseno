/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;
import gestionTaller.IGestorTaller;



/**
 *
 * @author Abraham Coronel
 */
public class ControlPagos implements IControlPagos {

    private final IGestorTaller taller;

    public ControlPagos(IGestorTaller taller) {
        this.taller= taller;
    }

    @Override
    public RespuestaPagoDTO procesarPago(SolicitudPagoDTO solicitud) {
        return taller.procesarPago(solicitud);
    }

}
