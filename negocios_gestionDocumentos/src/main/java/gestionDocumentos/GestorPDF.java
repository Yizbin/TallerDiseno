/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionDocumentos;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import dto.PresupuestoDTO;
import dto.TareaDTO;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Abraham Coronel
 */
public class GestorPDF implements IGestorPDF {

    @Override
    public void generarReportePago(PresupuestoDTO presupuesto, BufferedImage imagenQR, String idTransaccion) {
        String dest = "Recibo_Pago_" + idTransaccion + ".pdf";

        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph titulo = new Paragraph("COMPROBANTE DE PAGO")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold()
                    .setFontColor(ColorConstants.DARK_GRAY);
            document.add(titulo);

            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            table.setWidth(UnitValue.createPercentValue(100));

            table.addCell(new Cell().add(new Paragraph("Referencia de Pago:").setBold()));
            table.addCell(new Cell().add(new Paragraph(idTransaccion)));

            table.addCell(new Cell().add(new Paragraph("Folio de Orden:").setBold()));
            table.addCell(new Cell().add(new Paragraph(presupuesto.getOrden().getIdOrden())));

            String nombreCliente = presupuesto.getOrden().getCliente().getNombre() + " "
                    + presupuesto.getOrden().getCliente().getApellidoP();
            table.addCell(new Cell().add(new Paragraph("Cliente:").setBold()));
            table.addCell(new Cell().add(new Paragraph(nombreCliente)));

            String vehiculo = presupuesto.getOrden().getVehiculo().getMarca() + " "
                    + presupuesto.getOrden().getVehiculo().getModelo() + " ("
                    + presupuesto.getOrden().getVehiculo().getPlacas() + ")";
            table.addCell(new Cell().add(new Paragraph("Vehículo:").setBold()));
            table.addCell(new Cell().add(new Paragraph(vehiculo)));

            table.addCell(new Cell().add(new Paragraph("Monto Pagado:").setBold()));
            table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", presupuesto.getCostoTotal()))
                    .setFontSize(14).setBold().setFontColor(ColorConstants.BLUE)));

            String fecha = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            table.addCell(new Cell().add(new Paragraph("Fecha de Emision:").setBold()));
            table.addCell(new Cell().add(new Paragraph(fecha)));

            document.add(table);

            document.add(new Paragraph("\nEscanee este codigo para validar su recibo:").setTextAlignment(TextAlignment.CENTER));

            if (imagenQR != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(imagenQR, "png", baos);
                ImageData data = ImageDataFactory.create(baos.toByteArray());
                Image img = new Image(data);

                img.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.CENTER);
                document.add(img);
            }

            document.add(new Paragraph("\nGracias por su preferencia.")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setItalic()
                    .setFontSize(10));

            document.close();
            System.out.println("PDF creado exitosamente: " + dest);

            abrirPDF(dest);

        } catch (IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void abrirPDF(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(archivo);
                } else {
                    System.out.println("Apertura automatica no soportada en este sistema.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el PDF: " + e.getMessage());
        }
    }

    @Override
    public byte[] generarReportePagoEnMemoria(PresupuestoDTO presupuesto, BufferedImage imagenQR, String idTransaccion) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph titulo = new Paragraph("COMPROBANTE DE PAGO")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold()
                    .setFontColor(ColorConstants.DARK_GRAY);
            document.add(titulo);
            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            table.setWidth(UnitValue.createPercentValue(100));

            agregarFila(table, "Referencia:", idTransaccion);
            agregarFila(table, "Orden:", presupuesto.getOrden().getIdOrden());

            String cliente = presupuesto.getOrden().getCliente().getNombre() + " "
                    + presupuesto.getOrden().getCliente().getApellidoP();
            agregarFila(table, "Cliente:", cliente);

            String vehiculo = presupuesto.getOrden().getVehiculo().getModelo() + " - "
                    + presupuesto.getOrden().getVehiculo().getPlacas();
            agregarFila(table, "Vehiculo:", vehiculo);

            table.addCell(new Cell().add(new Paragraph("Monto:").setBold()));
            table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", presupuesto.getCostoTotal()))
                    .setFontSize(14).setBold().setFontColor(ColorConstants.BLUE)));

            String fecha = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            agregarFila(table, "Fecha:", fecha);

            document.add(table);

            document.add(new Paragraph("\nEscanee para validar:").setTextAlignment(TextAlignment.CENTER));

            if (imagenQR != null) {
                ByteArrayOutputStream imgBaos = new ByteArrayOutputStream();
                ImageIO.write(imagenQR, "png", imgBaos);
                ImageData data = ImageDataFactory.create(imgBaos.toByteArray());
                Image img = new Image(data);
                img.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.CENTER);
                document.add(img);
            }

            document.add(new Paragraph("\nDocumento generado digitalmente.")
                    .setTextAlignment(TextAlignment.CENTER).setItalic().setFontSize(10));

            document.close();

            System.out.println("PDF generado en memoria exitosamente.");

            return baos.toByteArray();

        } catch (IOException e) {
            System.err.println("Error generando PDF en memoria: " + e.getMessage());
            return null;
        }
    }

    private void agregarFila(Table table, String titulo, String valor) {
        table.addCell(new Cell().add(new Paragraph(titulo).setBold()));
        table.addCell(new Cell().add(new Paragraph(valor != null ? valor : "")));
    }

    @Override
    public byte[] generarReporteTareas(List<TareaDTO> tareas, String nombreMecanico) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph titulo = new Paragraph("REPORTE DE ACTIVIDAD - MECANICO")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(18)
                    .setBold();
            document.add(titulo);
            document.add(new Paragraph("\n"));

            String fechaHoy = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            document.add(new Paragraph("Mecanico: " + nombreMecanico).setBold());
            document.add(new Paragraph("Fecha de Emision: " + fechaHoy));
            document.add(new Paragraph("Total de Tareas Completadas: " + tareas.size()));
            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{15, 25, 40, 20}));
            table.setWidth(UnitValue.createPercentValue(100));

            table.addHeaderCell(new Cell().add(new Paragraph("Orden").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("Vehículo").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("Descripción").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("Estado").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY));

            for (TareaDTO t : tareas) {
                table.addCell(new Cell().add(new Paragraph(t.getIdOrden() != null ? t.getIdOrden() : "N/A")));

                String vehiculo = (t.getVehiculoModelo() != null ? t.getVehiculoModelo() : "")
                        + (t.getVehiculoPlacas() != null ? " (" + t.getVehiculoPlacas() + ")" : "");
                table.addCell(new Cell().add(new Paragraph(vehiculo)));

                table.addCell(new Cell().add(new Paragraph(t.getDescripcion())));
                table.addCell(new Cell().add(new Paragraph(t.getEstado())));
            }

            document.add(table);

            document.add(new Paragraph("\nFin del reporte.").setTextAlignment(TextAlignment.CENTER).setFontSize(10).setItalic());

            document.close();
            return baos.toByteArray();

        } catch (Exception e) {
            System.err.println("Error generando reporte de tareas: " + e.getMessage());
            return null;
        }
    }

    @Override
   public byte[] generarPresupuesto(PresupuestoDTO presupuesto) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);


            Paragraph titulo = new Paragraph("COTIZACIÓN DE SERVICIO")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold()
                    .setFontColor(ColorConstants.DARK_GRAY);
            document.add(titulo);

            document.add(new Paragraph("\n"));

            Table infoTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            infoTable.setWidth(UnitValue.createPercentValue(100));

            String nombreCliente = (presupuesto.getCliente() != null) 
                    ? presupuesto.getCliente().getNombre() + " " + presupuesto.getCliente().getApellidoP() 
                    : "N/A";
            agregarFila(infoTable, "Cliente:", nombreCliente);

            String datosVehiculo = "N/A";
            if (presupuesto.getOrden() != null && presupuesto.getOrden().getVehiculo() != null) {
                datosVehiculo = presupuesto.getOrden().getVehiculo().getMarca() + " " +
                                presupuesto.getOrden().getVehiculo().getModelo() + " - " +
                                presupuesto.getOrden().getVehiculo().getPlacas();
            }
            agregarFila(infoTable, "Vehículo:", datosVehiculo);

            String fecha = (presupuesto.getFechaCreacion() != null) 
                    ? presupuesto.getFechaCreacion().toString() 
                    : java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            agregarFila(infoTable, "Fecha de Emisión:", fecha);

            document.add(infoTable);
            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{4, 1.5f, 2, 2.5f}));
            table.setWidth(UnitValue.createPercentValue(100));

 
            table.addHeaderCell(new Cell().add(new Paragraph("Concepto").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell(new Cell().add(new Paragraph("Cant.").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell(new Cell().add(new Paragraph("P. Unit").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell(new Cell().add(new Paragraph("Importe").setBold().setFontColor(ColorConstants.WHITE))
                    .setBackgroundColor(ColorConstants.GRAY).setTextAlignment(TextAlignment.CENTER));


            if (presupuesto.getServicios() != null) {
                for (dto.ServicioPresupuestoDTO s : presupuesto.getServicios()) {
                    table.addCell(new Cell().add(new Paragraph("(S) " + s.getNombreServicio())));
                    table.addCell(new Cell().add(new Paragraph("1")).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", s.getCosto()))).setTextAlignment(TextAlignment.RIGHT));
                    table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", s.getCosto()))).setTextAlignment(TextAlignment.RIGHT));
                }
            }

            if (presupuesto.getRefacciones() != null) {
                for (dto.PresupuestoRefaccionDTO r : presupuesto.getRefacciones()) {
                    table.addCell(new Cell().add(new Paragraph("(R) " + r.getNombreRefaccion())));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(r.getCantidad()))).setTextAlignment(TextAlignment.CENTER));
                    table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", r.getPrecioUnitario()))).setTextAlignment(TextAlignment.RIGHT));
                    
                    double subtotal = r.getCantidad() * r.getPrecioUnitario();
                    table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", subtotal))).setTextAlignment(TextAlignment.RIGHT));
                }
            }

            document.add(table);

            presupuesto.calcularTotal();
            Paragraph totalParrafo = new Paragraph("\nTOTAL A PAGAR: $" + String.format("%.2f", presupuesto.getCostoTotal()))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(14)
                    .setBold()
                    .setFontColor(ColorConstants.BLUE);
            document.add(totalParrafo);

            document.add(new Paragraph("\n\nEste documento es una estimación de costos y tiene una vigencia de 15 días.\nNo representa un comprobante fiscal.")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setItalic()
                    .setFontSize(9)
                    .setFontColor(ColorConstants.GRAY));

            document.close();
            System.out.println("PDF de Presupuesto generado en memoria.");
            
            return baos.toByteArray();

        } catch (Exception e) {
            System.err.println("Error generando PDF de presupuesto: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
