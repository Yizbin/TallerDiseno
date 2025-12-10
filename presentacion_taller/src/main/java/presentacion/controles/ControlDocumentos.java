/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.PresupuestoDTO;
import dto.RefaccionDTO;
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

    @Override
    public void generarPDFPresupuesto(PresupuestoDTO presupuesto) {
        try {
            byte[] pdfBytes = gestorPDF.generarPresupuesto(presupuesto);

            if (pdfBytes == null) {
                JOptionPane.showMessageDialog(null, "Error: El reporte se generó vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Cotización");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

            String nombreSugerido = "Cotizacion_Orden_" + 
                    (presupuesto.getOrden() != null ? presupuesto.getOrden().getIdOrden() : "Nueva") + 
                    ".pdf";
            fileChooser.setSelectedFile(new File(nombreSugerido));

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                // Asegurar extensión .pdf
                if (!fileToSave.getAbsolutePath().toLowerCase().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }

                try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                    fos.write(pdfBytes);
                    
                    int opcion = JOptionPane.showConfirmDialog(null, 
                            "Presupuesto guardado exitosamente.\nUbicación: " + fileToSave.getAbsolutePath() + "\n\n¿Deseas abrirlo ahora?",
                            "Éxito",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);

                    if (opcion == JOptionPane.YES_OPTION && Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(fileToSave);
                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar en disco: " + e.getMessage(), "Error IO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error interno: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @Override
    public void enviarPresupuestoPorCorreo(PresupuestoDTO presupuesto, String correoDestino) {
        try {
            byte[] pdfBytes = gestorPDF.generarPresupuesto(presupuesto);

            if (pdfBytes == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo generar el PDF para enviar.");
                return;
            }
            String asunto = "Cotización de Servicio - Taller Automotriz";
            
            String cuerpo = "Estimado(a) " + presupuesto.getCliente().getNombre() + ":\n\n"
                    + "Adjunto a este correo encontrará la cotización solicitada para el servicio de su vehículo "
                    + presupuesto.getOrden().getVehiculo().getModelo() + ".\n\n"
                    + "Total cotizado: $" + String.format("%.2f", presupuesto.getCostoTotal()) + "\n\n"
                    + "Quedamos a sus órdenes.\n"
                    + "Atte. Taller Diseño 77";

            String nombreArchivo = "Cotizacion_" + presupuesto.getOrden().getIdOrden() + ".pdf";

            gestorCorreo.enviarCorreoConAdjunto(correoDestino, asunto, cuerpo, pdfBytes, nombreArchivo);

            JOptionPane.showMessageDialog(null, "Correo enviado exitosamente a: " + correoDestino);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al enviar correo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void generarPDFCompra(List<RefaccionDTO> lista, double total) {
        byte[] pdfBytes = gestorPDF.generarReporteCompra(lista, total);
        
        if (pdfBytes == null) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Resumen de Compra");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
        fileChooser.setSelectedFile(new File("Compra_Refacciones.pdf"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".pdf")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
            }

            try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                fos.write(pdfBytes);
                
                int opcion = JOptionPane.showConfirmDialog(null, 
                        "Archivo guardado correctamente.\n¿Desea abrirlo?", 
                        "Éxito", JOptionPane.YES_NO_OPTION);
                
                if (opcion == JOptionPane.YES_OPTION && Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(fileToSave);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
            }
        }
    }

    @Override
    public void enviarCompraPorCorreo(List<RefaccionDTO> lista, double total, String correoDestino) {
       try {
            byte[] pdfBytes = gestorPDF.generarReporteCompra(lista, total);

            if (pdfBytes == null) {
                throw new Exception("El PDF no se pudo generar.");
            }

            String asunto = "Resumen de Compra - Refacciones";
            String cuerpo = "Estimado cliente:\n\n"
                    + "Adjunto encontrará el resumen de su compra de refacciones.\n"
                    + "Total pagado: $" + String.format("%.2f", total) + "\n\n"
                    + "Gracias por su preferencia.";
            
            String nombreArchivo = "Resumen_Compra.pdf";

            gestorCorreo.enviarCorreoConAdjunto(correoDestino, asunto, cuerpo, pdfBytes, nombreArchivo);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    
    }

}
