/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.PagarOrden;

import dto.PresupuestoDTO;
import dto.RespuestaPagoDTO;
import dto.SolicitudPagoDTO;
import dto.enums.MetodoPago;
import java.util.HashMap;
import java.util.Map;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlPagos;
import presentacion.controles.IControlPresupuestos;
import presentacion.controles.IControlValidaciones;
import presentacion.validaciones.ValidacionException;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class PantallaFormularioTarjeta extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final String idOrden;
    private final IControlPagos controlPagos;
    private final IControlValidaciones validaciones;
    private final IControlMensajes mensajes;
    private final IControlPresupuestos controlPresupuestos;

    public PantallaFormularioTarjeta(IControlNavegacion navegacion, String idOrden, IControlPagos controlPagos, IControlValidaciones validaciones, IControlMensajes mensajes, IControlPresupuestos controlPresupuestos) {
        this.navegacion = navegacion;
        this.idOrden = idOrden;
        this.controlPagos = controlPagos;
        this.validaciones = validaciones;
        this.mensajes = mensajes;
        this.controlPresupuestos = controlPresupuestos;
        initComponents();
        configurarVentana();
    }

    private void configurarVentana() {
        this.setLocationRelativeTo(null);
    }

    private Boolean validarCampos() {
        try {
            // Validamos como campos numéricos porque son tarjeta y CVV
            validaciones.validarCampoVacio(textCorreo.getText(), "Número de Tarjeta");
            validaciones.validarCampoNumerico(textCorreo.getText(), "Número de Tarjeta");

            validaciones.validarCampoVacio(textContra.getText(), "CVV");
            validaciones.validarCampoNumerico(textContra.getText(), "CVV");
            return true;
        } catch (ValidacionException ex) {
            mensajes.mostrarErrorCampos(ex.getMessage());
            return false;
        }
    }

    private SolicitudPagoDTO recuperarDatosPago() {
        PresupuestoDTO presupuesto = controlPresupuestos.buscarPresupuestoPorOrden(this.idOrden);
        if (presupuesto == null) {
            mensajes.mostrarErrorCampos("Error crítico: Presupuesto no encontrado.");
            return null;
        }

        Map<String, String> datosPago = new HashMap<>();
        datosPago.put("numeroTarjeta", textCorreo.getText());
        datosPago.put("cvv", textContra.getText());

        // Monto real del DTO
        return new SolicitudPagoDTO(presupuesto.getCostoTotal(), this.idOrden, MetodoPago.TARJETA, datosPago);
    }

    private void procesarPago() {
        SolicitudPagoDTO solicitud = recuperarDatosPago();
        if (solicitud == null) {
            return;
        }

        RespuestaPagoDTO respuesta = controlPagos.procesarPago(solicitud);

        if (respuesta.getExito()) {
            mensajes.mostrarExito("Pago con Tarjeta aprobado.");
            navegacion.mostrarReciboPago(respuesta.getIdtransaccion(), this.idOrden);
            this.dispose();
        } else {
            mensajes.mostrarErrorCampos(respuesta.getMensaje());
        }
    }

    private void regresar() {
        navegacion.mostrarPantallaSeleccionMetodoPago(this.idOrden);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        panelDerecho = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        panelTarjeta = new javax.swing.JPanel();
        paypal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textContra = new javax.swing.JTextField();

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
        titulo.setText("Seleccion Metodo de pago");
        panelCentro.add(titulo, java.awt.BorderLayout.PAGE_START);

        panelBotones.setOpaque(false);

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(198, 40, 40));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelBotones.add(btnCancelar);

        btnPagar.setBackground(new java.awt.Color(198, 40, 40));
        btnPagar.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar Orden");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        panelBotones.add(btnPagar);

        panelCentro.add(panelBotones, java.awt.BorderLayout.PAGE_END);

        panelTarjeta.setOpaque(false);
        panelTarjeta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Visa-Mastercard.png"))); // NOI18N
        panelTarjeta.add(paypal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, 60));

        jLabel2.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero tarjeta:");
        panelTarjeta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        textCorreo.setBackground(new java.awt.Color(255, 255, 255));
        textCorreo.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        textCorreo.setForeground(new java.awt.Color(198, 40, 40));
        panelTarjeta.add(textCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 190, -1));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CVV:");
        panelTarjeta.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        textContra.setBackground(new java.awt.Color(255, 255, 255));
        textContra.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        panelTarjeta.add(textContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 190, -1));

        panelCentro.add(panelTarjeta, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        regresar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (validarCampos()) {
            procesarPago();
        }
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JPanel panelTarjeta;
    private javax.swing.JLabel paypal;
    private javax.swing.JTextField textContra;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
