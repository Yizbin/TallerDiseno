/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.PagarOrden;

import dto.PresupuestoDTO;
import javax.swing.ImageIcon;
import presentacion.controles.IControlNavegacion;
import presentacion.utilerias.GeneradorQR;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class PantallaReciboPago extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final String idTransaccion;
    private final PresupuestoDTO presupuesto;

    public PantallaReciboPago(IControlNavegacion navegacion, String idTransaccion, PresupuestoDTO presupuesto) {
        this.navegacion = navegacion;
        this.idTransaccion = idTransaccion;
        this.presupuesto = presupuesto;

        initComponents();
        configurarVentana();
        llenarDatos();
        mostrarQR();
    }

    public PantallaReciboPago() {
        this(null, "N/A", null);
    }

    private void configurarVentana() {
        this.setLocationRelativeTo(null);
    }

    private void llenarDatos() {
        if (this.presupuesto != null && this.presupuesto.getOrden() != null) {
            lblOrdenValor.setText(this.presupuesto.getOrden().getIdOrden());

            String nombreCliente = this.presupuesto.getOrden().getCliente().getNombre() + " "
                    + this.presupuesto.getOrden().getCliente().getApellidoP();
            lblClienteValor.setText(nombreCliente);

            String datosVehiculo = this.presupuesto.getOrden().getVehiculo().getModelo(); 
            lblVehiculoValor.setText(datosVehiculo);
            
            lblEstadoValor.setText("Pago exitoso.");
        }
    }

    private void mostrarQR() {
        String contenidoQR = "ORDEN:" + (presupuesto != null ? presupuesto.getOrden().getIdOrden() : "N/A")
                + "|REF:" + this.idTransaccion;

        ImageIcon iconoQR = GeneradorQR.generarQR(contenidoQR, 180, 180);

        if (iconoQR != null) {
            lblEspacioQR.setIcon(iconoQR);
            lblEspacioQR.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        panelDerecho = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        panelCentro = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        PanelTicket = new javax.swing.JPanel();
        PanelTexto = new javax.swing.JPanel();
        lblOrdenValor = new javax.swing.JLabel();
        lblClienteValor = new javax.swing.JLabel();
        lblVehiculoValor = new javax.swing.JLabel();
        lblEstadoValor = new javax.swing.JLabel();
        lblEspacioQR = new javax.swing.JLabel();

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

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAceptar.png"))); // NOI18N
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelDerecho.add(btnAceptar, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelDerecho, java.awt.BorderLayout.LINE_END);

        panelCentro.setBackground(new java.awt.Color(142, 0, 0));
        panelCentro.setLayout(new java.awt.BorderLayout());

        titulo.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Comprobante");
        panelCentro.add(titulo, java.awt.BorderLayout.PAGE_START);

        PanelTicket.setBackground(new java.awt.Color(255, 255, 255));
        PanelTicket.setOpaque(false);
        PanelTicket.setPreferredSize(new java.awt.Dimension(400, 500));
        PanelTicket.setLayout(new java.awt.BorderLayout());

        PanelTexto.setOpaque(false);
        PanelTexto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrdenValor.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        lblOrdenValor.setForeground(new java.awt.Color(255, 255, 255));
        lblOrdenValor.setText("ordenValor");
        PanelTexto.add(lblOrdenValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 110, 40));

        lblClienteValor.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        lblClienteValor.setForeground(new java.awt.Color(255, 255, 255));
        lblClienteValor.setText("cliente");
        PanelTexto.add(lblClienteValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        lblVehiculoValor.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        lblVehiculoValor.setForeground(new java.awt.Color(255, 255, 255));
        lblVehiculoValor.setText("vehiculo");
        PanelTexto.add(lblVehiculoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        lblEstadoValor.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        lblEstadoValor.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoValor.setText("estado");
        PanelTexto.add(lblEstadoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        lblEspacioQR.setText("QR");
        PanelTexto.add(lblEspacioQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -110, -1, 511));

        PanelTicket.add(PanelTexto, java.awt.BorderLayout.CENTER);

        panelCentro.add(PanelTicket, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        navegacion.mostrarMenuPrincipal();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        navegacion.mostrarMenuPrincipal();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTexto;
    private javax.swing.JPanel PanelTicket;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblClienteValor;
    private javax.swing.JLabel lblEspacioQR;
    private javax.swing.JLabel lblEstadoValor;
    private javax.swing.JLabel lblOrdenValor;
    private javax.swing.JLabel lblVehiculoValor;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
