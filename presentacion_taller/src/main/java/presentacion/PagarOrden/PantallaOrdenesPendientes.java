/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.PagarOrden;

import dto.PresupuestoDTO;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlPresupuestos;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class PantallaOrdenesPendientes extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final IControlMensajes mensajes;
    private final IControlCreacionUI creacion;
    private final IControlPresupuestos presupuestos;

    private DefaultTableModel modeloTablaOrdenes;

    public PantallaOrdenesPendientes(IControlNavegacion navegacion, IControlMensajes mensajes, IControlCreacionUI creacion, IControlPresupuestos presupuestos) {
        this.navegacion = navegacion;
        this.mensajes = mensajes;
        this.creacion = creacion;
        this.presupuestos = presupuestos;
        initComponents();
        configurarModeloTabla();
        estilizarTabla();
        cargarOrdenesPendientes();
        seleccionTabla();
        configurarVentana();
    }

    private void configurarVentana() {
        this.setLocationRelativeTo(null);
    }

    private void estilizarTabla() {
        creacion.aplicarEstiloTabla(scrollPaneOrdenes, tablaOrdenes);
    }

    private void cargarOrdenesPendientes() {
        try {

            List<PresupuestoDTO> listaPresupuestos = presupuestos.buscarPresupuestosPendientes();

            modeloTablaOrdenes.setRowCount(0);

            for (PresupuestoDTO p : listaPresupuestos) {
                String idOrden = (p.getOrden() != null) ? p.getOrden().getIdOrden() : "N/A";

                String cliente = (p.getOrden() != null && p.getOrden().getCliente() != null)
                        ? p.getOrden().getCliente().getNombre() + " " + p.getOrden().getCliente().getApellidoP()
                        : "Desconocido";

                String vehiculo = (p.getOrden() != null && p.getOrden().getVehiculo() != null)
                        ? p.getOrden().getVehiculo().getMarca() + " " + p.getOrden().getVehiculo().getModelo()
                        : "Desconocido";

                Double deuda = p.getCostoTotal();

                modeloTablaOrdenes.addRow(new Object[]{
                    idOrden,
                    cliente,
                    vehiculo,
                    String.format("$%.2f", deuda)
                });
            }
        } catch (Exception e) {
            mensajes.mostrarErrorCampos("Error cargando ordenes: " + e.getMessage());
        }
    }

    private void seleccionTabla() {
        tablaOrdenes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int filaSeleccionada = tablaOrdenes.getSelectedRow();

                if (filaSeleccionada != -1) {
                    String idOrden = (String) modeloTablaOrdenes.getValueAt(filaSeleccionada, 0);

                    PantallaSeleccionMetodoPago pantallaPago = new PantallaSeleccionMetodoPago(navegacion, idOrden);
                    pantallaPago.setVisible(true);
                    this.dispose();
                }
            }
        });
    }

    private void configurarModeloTabla() {
        String[] columnas = {"Num. Orden", "Cliente", "Vehículo", "Deuda"};

        modeloTablaOrdenes = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaOrdenes.setModel(modeloTablaOrdenes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        panelDerecho = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        scrollPaneOrdenes = new javax.swing.JScrollPane();
        tablaOrdenes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelIzquierdo.setBackground(new java.awt.Color(198, 40, 40));
        panelIzquierdo.setPreferredSize(new java.awt.Dimension(150, 0));
        panelIzquierdo.setLayout(new java.awt.BorderLayout());

        btnRegresar.setBackground(new java.awt.Color(198, 40, 40));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRegresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelIzquierdo.add(btnRegresar, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelIzquierdo, java.awt.BorderLayout.LINE_START);

        panelDerecho.setBackground(new java.awt.Color(198, 40, 40));
        panelDerecho.setPreferredSize(new java.awt.Dimension(150, 0));
        panelDerecho.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelDerecho, java.awt.BorderLayout.LINE_END);

        panelCentro.setBackground(new java.awt.Color(142, 0, 0));
        panelCentro.setLayout(new java.awt.BorderLayout());

        titulo.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Ordenes pendientes de pago");
        panelCentro.add(titulo, java.awt.BorderLayout.PAGE_START);

        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneOrdenes.setViewportView(tablaOrdenes);

        panelCentro.add(scrollPaneOrdenes, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        navegacion.mostrarMenuPrincipal();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JScrollPane scrollPaneOrdenes;
    private javax.swing.JTable tablaOrdenes;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
