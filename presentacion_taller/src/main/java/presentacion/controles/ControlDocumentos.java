/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.PresupuestoDTO;
import dto.TareaDTO;
import gestionCorreos.IGestorCorreo;
import gestionDocumentos.IGestorPDF;
import gestionQR.IGestorQR;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
            String mensaje = "Hola, adjunto encontraras tu comprobante de pago.\nGracias por tu preferencia.";
            String nombreArchivo = "Recibo_" + idTransaccion + ".pdf";

            gestorCorreo.enviarCorreoConAdjunto(correoDestino, asunto, mensaje, pdfBytes, nombreArchivo);
        }
    }

    @Override
    public void guardarReporteTareas(List<TareaDTO> tareas, String nombreMecanico) {
        byte[] pdfBytes = gestorPDF.generarReporteTareas(tareas, nombreMecanico);

        if (pdfBytes != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Reporte de Tareas");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

            fileChooser.setSelectedFile(new File("Reporte_Tareas_" + nombreMecanico.replace(" ", "_") + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                if (!fileToSave.getAbsolutePath().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }

                try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                    fos.write(pdfBytes);
                    JOptionPane.showMessageDialog(null, "Reporte guardado exitosamente en:\n" + fileToSave.getAbsolutePath());

                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(fileToSave);
                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void imprimirReporteTareasCompletadas(List<TareaDTO> tareas, String nombreMecanico) {
        if (tareas == null || tareas.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay tareas completadas para imprimir.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            byte[] pdfBytes = gestorPDF.generarReporteTareas(tareas, nombreMecanico);

            if (pdfBytes == null) {
                JOptionPane.showMessageDialog(null,
                        "No se pudo generar el reporte.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            File tempFile = File.createTempFile("Reporte_Tareas_", ".pdf");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(pdfBytes);
            }
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(tempFile);

            } else {
                JOptionPane.showMessageDialog(null,
                        "No se pudo abrir el archivo automáticamente.\n"
                        + "Ubicación del archivo temporal:\n" + tempFile.getAbsolutePath(),
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar o abrir el reporte: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
