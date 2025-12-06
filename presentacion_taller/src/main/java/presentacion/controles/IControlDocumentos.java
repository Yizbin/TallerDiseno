/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.PresupuestoDTO;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlDocumentos {

    public BufferedImage generarQR(String texto, int ancho, int alto);

    public void generarPDF(PresupuestoDTO presupuesto, BufferedImage qr, String idTransaccion);
    
    public void enviarPDFPorCorreo(PresupuestoDTO presupuesto, BufferedImage qr, String idTransaccion, String correoDestino);
}
