/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionDocumentos;

import dto.PresupuestoDTO;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abraham Coronel
 */
public interface IGestorPDF {

    public void generarReportePago(PresupuestoDTO presupuesto, BufferedImage imagenQR, String idTransaccion);
    
    public byte[] generarReportePagoEnMemoria(PresupuestoDTO presupuesto, BufferedImage imagenQR, String idTransaccion);

}
