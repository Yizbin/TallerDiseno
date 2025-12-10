/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GenerarPresupuesto;

import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.ServicioPresupuestoDTO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.IControlDocumentos;
import presentacion.controles.IControlMensajes;

/**
 *
 * @author Pride Factor Black
 */
public class pantallaResumen extends javax.swing.JFrame {
    private PresupuestoDTO presupuesto;
    private JTable tabla;
    private DefaultTableModel modelo;
    private IControlDocumentos documentos;
    private IControlMensajes mensajes;
    /**
     * Creates new form pantallaResumen
     */
    public pantallaResumen(PresupuestoDTO presupuesto, IControlDocumentos documentos,IControlMensajes mensajes) {
        this.presupuesto = presupuesto;
        this.documentos=documentos;
        this.mensajes=mensajes;
        initComponents();
        configurarVentana();
        configurarTabla();
        cargarDatos();
        
        ScrollPaneResumen.setOpaque(false);
        ScrollPaneResumen.getViewport().setOpaque(false);
        ScrollPaneResumen.setBorder(null);
        ScrollPaneResumen.getViewport().setBorder(null);
    }
 
    private void configurarVentana() {
        this.setLocationRelativeTo(null);
        ScrollPaneResumen.setOpaque(false);
        ScrollPaneResumen.getViewport().setOpaque(false);
        ScrollPaneResumen.setBorder(null);
        ScrollPaneResumen.getViewport().setBorder(null);
    }

    private void configurarTabla() {
        String[] columnas = {"Concepto", "Cant.", "P.Unit", "Importe"};
        modelo = new DefaultTableModel(columnas, 0);
        
        tabla = new JTable(modelo);
        tabla.setOpaque(false);
        tabla.setBackground(new Color(0, 0, 0, 0)); 
        tabla.setForeground(Color.WHITE);            
        tabla.setShowGrid(false);                 
        tabla.setRowHeight(25);                     
        tabla.setFillsViewportHeight(true);
        
        tabla.setSelectionBackground(new Color(255, 255, 255, 50));
        tabla.setSelectionForeground(Color.WHITE);

        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);           
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        }
        ScrollPaneResumen.setViewportView(tabla);
    }

    private void cargarDatos() {
        if (presupuesto == null) {
            System.out.println("ERROR: El presupuesto llegó NULO a pantallaResumen.");
            return;
        }

        modelo.setRowCount(0);

        System.out.println("--- Cargando datos en pantallaResumen ---");

        if (presupuesto.getServicios() != null && !presupuesto.getServicios().isEmpty()) {
            for (ServicioPresupuestoDTO s : presupuesto.getServicios()) {
                System.out.println("Agregando Servicio: " + s.getNombreServicio());
                modelo.addRow(new Object[]{
                    "(S) " + s.getNombreServicio(),
                    "1",
                    String.format("$%.2f", s.getCosto()),
                    String.format("$%.2f", s.getCosto())
                });
            }
        } else {
            System.out.println("AVISO: No hay servicios en este presupuesto.");
        }
        if (presupuesto.getRefacciones() != null && !presupuesto.getRefacciones().isEmpty()) {
            for (PresupuestoRefaccionDTO r : presupuesto.getRefacciones()) {
                System.out.println("Agregando Refacción: " + r.getNombreRefaccion());
                modelo.addRow(new Object[]{
                    "(R) " + r.getNombreRefaccion(),
                    r.getCantidad(),
                    String.format("$%.2f", r.getPrecioUnitario()),
                    String.format("$%.2f", r.getTotal())
                });
            }
        } else {
            System.out.println("AVISO: No hay refacciones en este presupuesto.");
        }
        modelo.addRow(new Object[]{"", "", "", ""}); // Espacio vacío
        
        presupuesto.calcularTotal(); 
        double total = (presupuesto.getCostoTotal() != null) ? presupuesto.getCostoTotal() : 0.0;
        
        System.out.println("Total calculado: " + total);
        
        modelo.addRow(new Object[]{
            "TOTAL",
            "",
            "",
            String.format("$%.2f", total)
        });       
        tabla.setModel(modelo);
        tabla.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPaneResumen = new javax.swing.JScrollPane();
        descarga = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(ScrollPaneResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 360, 290));

        descarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/download.png"))); // NOI18N
        descarga.setBorderPainted(false);
        descarga.setContentAreaFilled(false);
        descarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descargaActionPerformed(evt);
            }
        });
        getContentPane().add(descarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/resumen.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descargaActionPerformed
        if (presupuesto == null) {
            mensajes.mostrarError(this, "No hay información del presupuesto para descargar.");
            return;
        }
        new Thread(() -> {
            try {

                documentos.generarPDFPresupuesto(presupuesto);
                
            } catch (Exception e) {
                mensajes.mostrarError(this, "Ocurrió un error al intentar guardar el PDF: " + e.getMessage());
            }
        }).start();
        this.dispose();
        
    }//GEN-LAST:event_descargaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneResumen;
    private javax.swing.JButton descarga;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
