/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AsignarTarea;

import dto.TareaDTO;
import dto.EmpleadoDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlTareas;

/**
 *
 * @author Angel Servin
 */
public class PantallaElegirTarea extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final IControlMensajes mensajes;
    private final IControlCreacionUI creacion;
    private final IControlTareas controlTareas;
    private final EmpleadoDTO empleadoContexto;

    private List<TareaDTO> listaTareas;
    private DefaultTableModel modeloTablaTareas;

    public PantallaElegirTarea(IControlNavegacion navegacion,
            IControlMensajes mensajes,
            IControlCreacionUI creacion,
            IControlTareas controlTareas,
            EmpleadoDTO empleadoContexto) {

        this.navegacion = navegacion;
        this.mensajes = mensajes;
        this.creacion = creacion;
        this.controlTareas = controlTareas;
        this.empleadoContexto = empleadoContexto;

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
        creacion.aplicarEstiloTabla(scrollPaneTareas, tablaTareas);
    }

    private void configurarModeloTabla() {
        String[] columnas = {"Descripción", "Estado", "Costo", "Vehículo"};
        modeloTablaTareas = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaTareas.setModel(modeloTablaTareas);
    }

    private void cargarTareas() {
        modeloTablaTareas.setRowCount(0); // Limpiar tabla

        try {
            listaTareas = controlTareas.buscarTareasDisponibles();

            if (listaTareas == null || listaTareas.isEmpty()) {
                System.out.println("No se encontraron tareas disponibles.");
                return;
            }

            System.out.println("Tareas obtenidas: " + listaTareas.size()); // Para depuración

            for (TareaDTO t : listaTareas) {
                String estadoTxt = (t.getEstado() != null && t.getEstado().equalsIgnoreCase("completada"))
                        ? "Completada"
                        : (t.getEstado() != null ? t.getEstado() : "Pendiente");

                String costoTxt = (t.getCosto() == null || t.getCosto().trim().isEmpty())
                        ? "-"
                        : t.getCosto();

                String vehiculoTxt = (t.getVehiculoModelo() == null || t.getVehiculoModelo().trim().isEmpty())
                        ? "-"
                        : t.getVehiculoModelo();

                modeloTablaTareas.addRow(new Object[]{
                    t.getDescripcion(),
                    estadoTxt,
                    costoTxt,
                    vehiculoTxt
                });

                System.out.println("Fila agregada: " + t.getDescripcion()); // Para depuración
            }

        } catch (Exception e) {
            e.printStackTrace(); // Para ver la excepción completa en consola
            mensajes.mostrarError(this, "Error al cargar las tareas: " + e.getMessage());
        }
    }

    private void agregarListenerTabla() {
        tablaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = tablaTareas.getSelectedRow();
                    if (fila != -1) {
                        TareaDTO tareaSeleccionada = listaTareas.get(fila);
                        mostrarConfirmacionTarea(tareaSeleccionada);
                    }
                }
            }
        });
    }

    private void mostrarConfirmacionTarea(TareaDTO tarea) {
        String mensaje = "El mecánico "
                + empleadoContexto.getNombre() + " "
                + empleadoContexto.getApellidoP() + " "
                + empleadoContexto.getApellidoM()
                + " hará la tarea:\n" + tarea.getDescripcion()
                + "\n¿Desea confirmar?";

        Boolean confirmar = mensajes.mostrarConfirmacion(this, mensaje, "Confirmar Asignación");

        if (!confirmar) {
            return;
        }

        try {
            // Asignar tarea
            boolean exito = controlTareas.asignarTareaAMecanico(
                    tarea.getIdTarea(),
                    empleadoContexto.getId_empleado()
            );

            if (exito) {
                mensajes.mostrarExito("Tarea asignada correctamente.");
                cargarTareas(); // ← actualiza la tabla
            } else {
                mensajes.mostrarError(this, "No se pudo asignar la tarea.");
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // útil para depurar
            mensajes.mostrarError(this, "Error inesperado: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPaneTareas = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        scrollPaneTareas.setViewportView(tablaTareas);

        jPanel1.add(scrollPaneTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 150, 470, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PantallaElegirTareas.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPaneTareas;
    private javax.swing.JTable tablaTareas;
    // End of variables declaration//GEN-END:variables
}
