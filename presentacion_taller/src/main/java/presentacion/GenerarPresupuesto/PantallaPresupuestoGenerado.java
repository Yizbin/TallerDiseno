/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GenerarPresupuesto;

import dto.ClienteDTO;
import dto.ItemRefaccionDTO;
import dto.ItemServicioDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.ServicioDTO;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import presentacion.controles.ControlRefacciones;
import presentacion.controles.ControlServicios;
import presentacion.controles.IControlCreacionUI;
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
    
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    
    public PantallaPresupuestoGenerado(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, PresupuestoDTO presupuesto, ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlPresupuestos controlPresupuestos) {
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
        
        configurarTabla();
        crearPanelClienteYTotal();
        cargarDatosDePresupuesto();
        
        jScrollPaneCliente.setOpaque(false);
        jScrollPaneCliente.getViewport().setOpaque(false);
        jScrollPaneCliente.setBorder(null);
        jScrollPaneCliente.getViewport().setBorder(null);

        tabla.setShowGrid(false);                             // Quitamos líneas de la tabla
        tabla.setForeground(Color.WHITE);                     // Texto blanco en la tabla
        tabla.setBackground(new Color(0, 0, 0, 0));           // Fondo 100% transparente

        tabla.setSelectionBackground(new Color(255, 255, 255, 40));  // Selección semi-transparente
        tabla.setSelectionForeground(Color.WHITE);  
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

    // ------- HACER LA TABLA 100% TRANSPARENTE -------
    tabla.setOpaque(false);
    tabla.setBackground(new Color(0, 0, 0, 0));
    tabla.setForeground(Color.WHITE);

    tabla.setShowGrid(false); // Quitar líneas

    jScrollPane1.setOpaque(false);
    jScrollPane1.getViewport().setOpaque(false);
    jScrollPane1.setBorder(null);

    // selección bonita y transparente
    tabla.setSelectionBackground(new Color(255, 255, 255, 40));
    tabla.setSelectionForeground(Color.WHITE);

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


            for (ItemServicioDTO s : presupuesto.getServicios()) {

                modeloTabla.addRow(new Object[]{
                    "Servicio",
                    s.getNombre(),
                    s.getCantidad(),
                    String.format("%.2f", s.getPrecioUnitario()),
                    String.format("%.2f", s.getTotal())
                });
            }


            for (ItemRefaccionDTO r : presupuesto.getRefacciones()) {

                modeloTabla.addRow(new Object[]{
                    "Refacción",
                    r.getNombre(),
                    r.getCantidad(),
                    String.format("%.2f", r.getPrecioUnitario()),
                    String.format("%.2f", r.getTotal())
                });
        }

        presupuesto.calcularTotal();
        double total = presupuesto.getCostoTotal() == null ? 0.0 : presupuesto.getCostoTotal();
        lblTotal.setText(String.format("Total: %.2f", total));
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
        navegacion.mostrarPantallaGenerarPresupuesto(navegacion, creacion, orden, cliente, presupuesto, servicio, controlServicios, controlRefacciones, controlPresupuestos);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        PresupuestoDTO creado = controlPresupuestos.crearPresupuesto(presupuesto);

    if (creado != null) {
        JOptionPane.showMessageDialog(this, "Presupuesto creado correctamente");
        navegacion.mostrarMenuPrincipal();
    }
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

