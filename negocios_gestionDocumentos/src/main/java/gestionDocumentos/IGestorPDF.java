/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionDocumentos;

import dto.PresupuestoDTO;
import dto.TareaDTO;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IGestorPDF {

    public void generarReportePago(PresupuestoDTO presupuesto, BufferedImage imagenQR, String idTransaccion);

    public byte[] generarReportePagoEnMemoria(PresupuestoDTO presupuesto, BufferedImage imagenQR, String idTransaccion);

    public byte[] generarReporteTareas(List<TareaDTO> tareas, String nombreMecanico);

    public byte[] generarPresupuesto(PresupuestoDTO presupuesto);
}
