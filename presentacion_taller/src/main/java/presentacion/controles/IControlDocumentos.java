/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.PresupuestoDTO;
import dto.TareaDTO;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlDocumentos {

    public BufferedImage generarQR(String texto, int ancho, int alto);

    public void generarPDF(PresupuestoDTO presupuesto, BufferedImage qr, String idTransaccion);
    
    public void enviarPDFPorCorreo(PresupuestoDTO presupuesto, BufferedImage qr, String idTransaccion, String correoDestino);
    
    public void guardarReporteTareas(List<TareaDTO> tareas, String nombreMecanico);
    
    public void imprimirReporteTareasCompletadas(List<TareaDTO> tareas, String nombreMecanico);
    
    public void generarPDFPresupuesto(PresupuestoDTO presupuesto);
    
    public void enviarPresupuestoPorCorreo(PresupuestoDTO presupuesto, String correoDestino);
}
