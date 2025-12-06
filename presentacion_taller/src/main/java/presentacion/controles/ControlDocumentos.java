/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.PresupuestoDTO;
import gestionCorreos.IGestorCorreo;
import gestionDocumentos.IGestorPDF;
import gestionQR.IGestorQR;
import java.awt.image.BufferedImage;

/**
 *
 * @author Abraham Coronel
 */
public class ControlDocumentos implements IControlDocumentos {

    private final IGestorQR gestorQR;
    private final IGestorPDF gestorPDF;
    private final IGestorCorreo gestorCorreo;

    public ControlDocumentos(IGestorQR gestorQR, IGestorPDF gestorPDF, IGestorCorreo gestorCorreo) {
        this.gestorQR = gestorQR;
        this.gestorPDF = gestorPDF;
        this.gestorCorreo = gestorCorreo;
    }

    @Override
    public BufferedImage generarQR(String texto, int ancho, int alto) {
        return gestorQR.generarCodigoQR(texto, ancho, alto);
    }

    @Override
    public void generarPDF(PresupuestoDTO presupuesto, BufferedImage qr, String idTransaccion) {
        gestorPDF.generarReportePago(presupuesto, qr, idTransaccion);
    }

    @Override
    public void enviarPDFPorCorreo(PresupuestoDTO presupuesto, BufferedImage qr, String idTransaccion, String correoDestino) {
        byte[] pdfBytes = gestorPDF.generarReportePagoEnMemoria(presupuesto, qr, idTransaccion);

        if (pdfBytes != null) {
            String asunto = "Comprobante de Pago - Orden " + presupuesto.getOrden().getIdOrden();
            String mensaje = "Hola, adjunto encontrarás tu comprobante de pago.\nGracias por tu preferencia.";
            String nombreArchivo = "Recibo_" + idTransaccion + ".pdf";

            gestorCorreo.enviarCorreoConAdjunto(correoDestino, asunto, mensaje, pdfBytes, nombreArchivo);
        }
    }

}
