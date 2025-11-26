/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.PagarOrden;

import presentacion.controles.IControlNavegacion;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class PantallaSeleccionMetodoPago extends javax.swing.JFrame {

    private final IControlNavegacion navegacion;
    private final String idOrden;

    public PantallaSeleccionMetodoPago(IControlNavegacion navegacion, String idOrden) {
        this.navegacion = navegacion;
        this.idOrden = idOrden;
        initComponents();
        configurarVentana();
    }

    private void configurarVentana() {
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        panelDerecho = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panelImagenes = new javax.swing.JPanel();
        btnPaypal = new javax.swing.JButton();
        btnMercado = new javax.swing.JButton();
        btnTarjeta = new javax.swing.JButton();

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

        panelImagenes.setOpaque(false);

        btnPaypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Paypal.png"))); // NOI18N
        btnPaypal.setBorderPainted(false);
        btnPaypal.setContentAreaFilled(false);
        btnPaypal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaypalActionPerformed(evt);
            }
        });
        panelImagenes.add(btnPaypal);

        btnMercado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Mercado Pago.png"))); // NOI18N
        btnMercado.setBorderPainted(false);
        btnMercado.setContentAreaFilled(false);
        btnMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMercadoActionPerformed(evt);
            }
        });
        panelImagenes.add(btnMercado);

        btnTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Visa-Mastercard.png"))); // NOI18N
        btnTarjeta.setBorderPainted(false);
        btnTarjeta.setContentAreaFilled(false);
        btnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaActionPerformed(evt);
            }
        });
        panelImagenes.add(btnTarjeta);

        panelCentro.add(panelImagenes, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        navegacion.mostrarOrdenesPendientes();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnPaypalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaypalActionPerformed
        navegacion.mostrarFormularioPaypal(idOrden);
        this.dispose();
    }//GEN-LAST:event_btnPaypalActionPerformed

    private void btnMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMercadoActionPerformed
        navegacion.mostrarFormularioMercadoPago(idOrden);
        this.dispose();
    }//GEN-LAST:event_btnMercadoActionPerformed

    private void btnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaActionPerformed
        navegacion.mostrarFormularioTarjeta(idOrden);
        this.dispose();
    }//GEN-LAST:event_btnTarjetaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMercado;
    private javax.swing.JButton btnPaypal;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTarjeta;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
