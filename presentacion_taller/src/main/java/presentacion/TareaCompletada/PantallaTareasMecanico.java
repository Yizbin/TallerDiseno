/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.TareaCompletada;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class PantallaTareasMecanico extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final IControlMensajes mensajes;
    private final IControlCreacionUI creacion;

    private DefaultTableModel modeloTablaTareas;

    public PantallaTareasMecanico(IControlNavegacion navegacion, IControlMensajes mensajes, IControlCreacionUI creacion) {
        this.navegacion = navegacion;
        this.mensajes = mensajes;
        this.creacion = creacion;
        initComponents();
        configurarModeloTabla();
        estilizarTabla();
        seleccionTabla();
        configurarVentana();
        mock();
    }

    private void configurarVentana() {
        this.setLocationRelativeTo(null);
    }

    private void estilizarTabla() {
        creacion.aplicarEstiloTabla(scrollPaneOrdenes, tablaTareas);
    }

    private void seleccionTabla() {

        tablaTareas.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int filaSeleccionada = tablaTareas.getSelectedRow();

                if (filaSeleccionada != -1) {

                    String tarea = (String) modeloTablaTareas.getValueAt(filaSeleccionada, 0);
                    String orden = (String) modeloTablaTareas.getValueAt(filaSeleccionada, 2);

                    String mensaje = "Se ha marcado como completada la tarea:\n" + tarea + "\nPara la orden: " + orden;
                    mensajes.mostrarMensajeInformativo(PantallaTareasMecanico.this, mensaje, "Tarea Completa");
                    tablaTareas.clearSelection();
                }
            }
        });
    }

    private void configurarModeloTabla() {
        String[] columnas = {"Tarea", "Limite", "Orden", "Nota"};

        modeloTablaTareas = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaTareas.setModel(modeloTablaTareas);
    }

    private void mock() {
        modeloTablaTareas.addRow(new Object[]{"Cambiar Aceite", "18/10/2025", "252233", "Utilizar aceite premium."});
        modeloTablaTareas.addRow(new Object[]{"Cambio Llantas", "19/10/2025", "261628", "Solo cambiar llantas enfrente."});
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
        tablaTareas = new javax.swing.JTable();

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
        titulo.setText("Tareas Mecanico");
        panelCentro.add(titulo, java.awt.BorderLayout.PAGE_START);

        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPaneOrdenes.setViewportView(tablaTareas);

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
    private javax.swing.JTable tablaTareas;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
