/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GenerarPresupuesto;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.ServicioDTO;
import dto.ServicioPresupuestoDTO;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.ControlRefacciones;
import presentacion.controles.ControlServicios;
import presentacion.controles.IControlClientes;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlOrdenes;
import presentacion.controles.IControlPresupuestos;
import presentacion.controles.IControlRefacciones;
import presentacion.controles.IControlServicios;

/**
 *
 * @author Pride Factor Black
 */
public class PantallaPresupuestoGenerado extends javax.swing.JFrame {
    private final IControlNavegacion navegacion;
    private final IControlCreacionUI creacion;
    private final ClienteDTO cliente;
    private final PresupuestoDTO presupuesto;
    private final OrdenDTO orden;
    private final ServicioDTO servicio;
    private final IControlServicios controlServicios;
    private final IControlRefacciones controlRefacciones;
    private final IControlPresupuestos controlPresupuestos;
    private final IControlMensajes mensajes;
    private final IControlClientes clientes;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    
    public PantallaPresupuestoGenerado(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, 
            PresupuestoDTO presupuesto, ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlPresupuestos controlPresupuestos,IControlMensajes mensajes, IControlClientes clientes) {
        initComponents();
        configurarVentana();
        this.navegacion = navegacion;     
        this.creacion = creacion;
        this.orden = orden;
        this.cliente =cliente;
        this.presupuesto=presupuesto;
        this.servicio=servicio;
        this.controlServicios = controlServicios;
        this.controlRefacciones = controlRefacciones;
        this.controlPresupuestos = controlPresupuestos;
        this.mensajes=mensajes;
        this.clientes=clientes;
        configurarTabla();
        
        
        jScrollPaneCliente.setOpaque(false);
        jScrollPaneCliente.getViewport().setOpaque(false);
        jScrollPaneCliente.setBorder(null);
        jScrollPaneCliente.getViewport().setBorder(null);

        tabla.setShowGrid(false);                           
        tabla.setForeground(Color.WHITE);                  
        tabla.setBackground(new Color(0, 0, 0, 0));           

        tabla.setSelectionBackground(new Color(255, 255, 255, 40));  
        tabla.setSelectionForeground(Color.WHITE);  
        
        crearPanelClienteYTotal();
        cargarDatosDePresupuesto();
    }

        private void configurarVentana() {
         this.setLocationRelativeTo(null);
    }
        
     private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[]{"Tipo", "Nombre", "Cantidad", "Precio Unitario", "Subtotal"},
                0
        );
        tabla = new JTable(modeloTabla);
        tabla.setFillsViewportHeight(true);
        tabla.setOpaque(false);
        tabla.setBackground(new Color(0, 0, 0, 0));
        tabla.setForeground(Color.WHITE);
        tabla.setShowGrid(false);

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportView(tabla);
    }

    private void crearPanelClienteYTotal() {
        JPanel panelInternoCliente = new JPanel();
        panelInternoCliente.setOpaque(false);
        panelInternoCliente.setLayout(new BoxLayout(panelInternoCliente, BoxLayout.Y_AXIS));

        if (cliente != null) {
            JLabel n = new JLabel("Nombre: " + safeString(cliente.getNombre()));
            JLabel a = new JLabel("Apellido: " + safeString(cliente.getApellidoP()));
            JLabel t = new JLabel("Teléfono: " + safeString(cliente.getTelefono()));
            JLabel c = new JLabel("Correo: " + safeString(cliente.getCorreo()));

            n.setForeground(Color.WHITE);
            a.setForeground(Color.WHITE);
            t.setForeground(Color.WHITE);
            c.setForeground(Color.WHITE);

            panelInternoCliente.add(n);
            panelInternoCliente.add(a);
            panelInternoCliente.add(t);
            panelInternoCliente.add(c);
        } else {
            JLabel lbl = new JLabel("No hay cliente seleccionado");
            lbl.setForeground(Color.WHITE);
            panelInternoCliente.add(lbl);
        }
        jScrollPaneCliente.setViewportView(panelInternoCliente);
    }

    private String safeString(String s) {
        return s == null ? "" : s;
    }

    private void cargarDatosDePresupuesto() {
        modeloTabla.setRowCount(0);

        if (presupuesto != null) {
            
            if (presupuesto.getServicios() != null) {
                for (ServicioPresupuestoDTO s : presupuesto.getServicios()) {
                    modeloTabla.addRow(new Object[]{
                        "Servicio",
                        s.getNombreServicio(),
                        1, 
                        String.format("$ %.2f", s.getCosto()),
                        String.format("$ %.2f", s.getCosto())
                    });
                }
            }

            if (presupuesto.getRefacciones() != null) {
                for (PresupuestoRefaccionDTO r : presupuesto.getRefacciones()) {
                    modeloTabla.addRow(new Object[]{
                        "Refacción",
                        r.getNombreRefaccion(),
                        r.getCantidad(),
                        String.format("$ %.2f", r.getPrecioUnitario()),
                        String.format("$ %.2f", r.getTotal())
                    });
                }
            }
            presupuesto.calcularTotal();
            double total = presupuesto.getCostoTotal() == null ? 0.0 : presupuesto.getCostoTotal();
            lblTotal.setText(String.format("Total: $ %.2f", total));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        btnRegresar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPaneCliente = new javax.swing.JScrollPane();
        lblTotal = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 550, 210));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRegresar.png"))); // NOI18N
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 50));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAceptar.png"))); // NOI18N
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, -1, 50));
        getContentPane().add(jScrollPaneCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 210, 180));

        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 90, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PantallaPresupuestoGeneradoCUA.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        navegacion.mostrarPantallaGenerarPresupuesto(navegacion, creacion, orden, cliente, presupuesto, servicio, controlServicios, controlRefacciones, controlPresupuestos, mensajes, clientes);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        PresupuestoDTO creado = controlPresupuestos.crearPresupuesto(presupuesto);

        if (creado != null) {
            // Usamos tu control de mensajes inyectado
            mensajes.mostrarExito("¡Presupuesto guardado con éxito! ID: " + creado.getIdPresupuesto());
            navegacion.mostrarMenuPrincipal();
        } else {
            mensajes.mostrarError(this, "No se pudo guardar el presupuesto.");
        }
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneCliente;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}

