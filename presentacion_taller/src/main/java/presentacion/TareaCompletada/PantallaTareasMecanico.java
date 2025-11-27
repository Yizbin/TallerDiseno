/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.TareaCompletada;

import dto.EmpleadoDTO;
import dto.TareaDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlTareas;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class PantallaTareasMecanico extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final IControlMensajes mensajes;
    private final IControlCreacionUI creacion;
    private final IControlTareas controlTareas;
    private final EmpleadoDTO mecanicoActual;

    private DefaultTableModel modeloTablaTareas;

    public PantallaTareasMecanico(IControlNavegacion navegacion, IControlMensajes mensajes, IControlCreacionUI creacion, IControlTareas controlTareas, EmpleadoDTO mecanicoActual) {
        this.navegacion = navegacion;
        this.mensajes = mensajes;
        this.creacion = creacion;
        this.controlTareas = controlTareas;
        this.mecanicoActual = mecanicoActual;

        initComponents();
        configurarModeloTabla();
        estilizarTabla();
        configurarVentana();

        cargarTareas();
        agregarListenerTabla();
    }

    private void configurarVentana() {
        this.setLocationRelativeTo(null);
    }

    private void estilizarTabla() {
        creacion.aplicarEstiloTabla(scrollPaneOrdenes, tablaTareas);
    }

    private void configurarModeloTabla() {
        String[] columnas = {"ID", "Descripción", "Vehículo", "Orden", "Estado"};
        modeloTablaTareas = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaTareas.setModel(modeloTablaTareas);

        tablaTareas.getColumnModel().getColumn(0).setMinWidth(0);
        tablaTareas.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaTareas.getColumnModel().getColumn(0).setWidth(0);
    }

    private void cargarTareas() {
        modeloTablaTareas.setRowCount(0);
        if (mecanicoActual == null) {
            return;
        }

        List<TareaDTO> lista = controlTareas.consultarTareasPendientes(mecanicoActual.getUsuario());

        for (TareaDTO t : lista) {
            modeloTablaTareas.addRow(new Object[]{
                t.getIdTarea(),
                t.getDescripcion(),
                t.getVehiculoModelo(),
                t.getIdOrden(),
                t.getEstado()
            });
        }
    }

    private void agregarListenerTabla() {
        tablaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = tablaTareas.getSelectedRow();
                    if (fila != -1) {
                        String idTarea = (String) modeloTablaTareas.getValueAt(fila, 0);
                        String desc = (String) modeloTablaTareas.getValueAt(fila, 1);

                        confirmarTerminarTarea(idTarea, desc);
                    }
                }
            }
        });
    }

    private void confirmarTerminarTarea(String idTarea, String descripcion) {
        Boolean confirmar = mensajes.mostrarConfirmacion(this,
                "¿Deseas marcar como COMPLETADA la tarea:\n" + descripcion + "?",
                "Confirmar Tarea");

        if (confirmar) {
            boolean exito = controlTareas.completarTarea(idTarea);
            if (exito) {
                cargarTareas(); 
            }
        }
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
