/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.ComprarRefaccion;

import dto.RefaccionDTO;
import entidades.Refaccion;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlRefacciones;
import dto.RefaccionDTO; 
import javax.swing.table.DefaultTableModel;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlValidaciones;
import presentacion.controles.IControlVentas;
/**
 *
 * @author Pride Factor Black
 */
public class PantallaSeleccionarRefacciones extends javax.swing.JFrame {
    private final IControlRefacciones controlRefacciones;
    private final IControlCreacionUI creacion;
    private final IControlMensajes mensajes;
    private final IControlNavegacion navegacion;
    private final IControlVentas controlVentas;
    private final IControlValidaciones validaciones;
    private JPanel panelListaRefacciones;
    private JPanel panelListaSeleccionados;
    
    /**
     * Creates new form PantallaSeleccionarRefacciones
     */
    public PantallaSeleccionarRefacciones(IControlRefacciones controlRefacciones, IControlCreacionUI creacion, IControlMensajes mensajes, IControlNavegacion navegacion, IControlVentas controlVentas, IControlValidaciones validaciones) {
        initComponents();
        this.controlRefacciones = controlRefacciones;
        this.creacion=creacion;
        this.mensajes=mensajes;
        this.navegacion=navegacion;
        this.controlVentas=controlVentas;
        this.validaciones=validaciones;
        
        inicializarPanelesListas();
        
        cargarRefacciones();
        
        scrollPaneRefacciones.setOpaque(false);
        scrollPaneRefacciones.getViewport().setOpaque(false);
        scrollPaneRefacciones.setBorder(null);
        scrollPaneRefacciones.getViewport().setBorder(null);
        
        scrollPaneRefaccionesSeleccionados.setOpaque(false);
        scrollPaneRefaccionesSeleccionados.getViewport().setOpaque(false);
        scrollPaneRefaccionesSeleccionados.setBorder(null);
        scrollPaneRefaccionesSeleccionados.getViewport().setBorder(null);
    }

    private void inicializarPanelesListas() {
     
        panelListaRefacciones = new JPanel();
        panelListaRefacciones.setLayout(new BoxLayout(panelListaRefacciones, BoxLayout.Y_AXIS));
        panelListaRefacciones.setOpaque(false);
        scrollPaneRefacciones.setViewportView(panelListaRefacciones);
        
        panelListaSeleccionados = new JPanel();
        panelListaSeleccionados.setLayout(new BoxLayout(panelListaSeleccionados, BoxLayout.Y_AXIS));
        panelListaSeleccionados.setOpaque(false);
        scrollPaneRefaccionesSeleccionados.setViewportView(panelListaSeleccionados);
    }
    
    
    private void cargarRefacciones() {
        panelListaRefacciones.removeAll();

        var lista = controlRefacciones.buscarTodasLasRefacciones();

        for (RefaccionDTO r : lista) {
            JPanel panel = creacion.crearPanelRefaccion(
                    r.getNombre(),
                    r.getPrecioUnitario(),
                    r.getStock()
            );

            JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, r.getStock(), 1));
            spinner.setPreferredSize(new Dimension(60, 25));

            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    actualizarListaSeleccionados(); 
                }
            });

            JPanel panelDerecho = (JPanel) panel.getComponent(1);
            panelDerecho.add(spinner);

            panel.putClientProperty("refaccion", r);
            panel.putClientProperty("spinner", spinner);

            panelListaRefacciones.add(panel);
        }

        panelListaRefacciones.revalidate();
        panelListaRefacciones.repaint();
    }
    
    private void actualizarListaSeleccionados() {
        panelListaSeleccionados.removeAll(); 
        
        List<RefaccionDTO> seleccionados = getRefaccionesSeleccionadas();
        
        double totalEstimado = 0;

        for (RefaccionDTO r : seleccionados) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setOpaque(true);
            itemPanel.setBackground(new Color(255, 255, 255, 180)); 
            itemPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
            itemPanel.setMaximumSize(new Dimension(200, 60));
            
            JLabel lblNombre = new JLabel(r.getNombre());
            lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12));
            

            double subtotal = r.getPrecioUnitario() * r.getStock(); 
            totalEstimado += subtotal;
            
            JLabel lblDetalle = new JLabel(r.getStock() + " x $" + r.getPrecioUnitario() + " = $" + subtotal);
            lblDetalle.setFont(new java.awt.Font("Segoe UI", 0, 11));

            itemPanel.add(lblNombre);
            itemPanel.add(lblDetalle);

            panelListaSeleccionados.add(itemPanel);
            panelListaSeleccionados.add(javax.swing.Box.createRigidArea(new Dimension(0, 5)));
        }
        
        if (!seleccionados.isEmpty()) {
             JLabel lblTotal = new JLabel("Total: $" + totalEstimado);
             lblTotal.setForeground(Color.WHITE);
             lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14));
             panelListaSeleccionados.add(lblTotal);
        }

        panelListaSeleccionados.revalidate();
        panelListaSeleccionados.repaint();
    }
    
    public List<RefaccionDTO> getRefaccionesSeleccionadas() {
        List<RefaccionDTO> seleccionadas = new ArrayList<>();

        for (var comp : panelListaRefacciones.getComponents()) {
            if (comp instanceof JPanel panel) {

                RefaccionDTO r = (RefaccionDTO) panel.getClientProperty("refaccion");
                JSpinner spinner = (JSpinner) panel.getClientProperty("spinner");

                int cantidad = (int) spinner.getValue();

                if (cantidad > 0) {
                  
                    RefaccionDTO copia = new RefaccionDTO(
                            r.getId_refaccion(),
                            r.getNombre(),
                            r.getDescripcion(),
                            r.getPrecioUnitario(),
                            cantidad, 
                            r.getEstado()
                    );
                    seleccionadas.add(copia);
                }
            }
        }
        return seleccionadas;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneRefacciones = new javax.swing.JScrollPane();
        scrollPaneRefaccionesSeleccionados = new javax.swing.JScrollPane();
        btnContinuar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(scrollPaneRefacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 500, 240));
        getContentPane().add(scrollPaneRefaccionesSeleccionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 210, 240));

        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonSiguiente.png"))); // NOI18N
        btnContinuar.setBorderPainted(false);
        btnContinuar.setContentAreaFilled(false);
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRegresar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantallaSelñeccionarRefacciones.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
       List<RefaccionDTO> listaAEnviar = getRefaccionesSeleccionadas();

        if (listaAEnviar.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor selecciona una cantidad mayor a 0 en alguna refacción.");
            return;
        }
        double totalCalculado = 0.0;
        for (RefaccionDTO r : listaAEnviar) {

            totalCalculado += (r.getPrecioUnitario() * r.getStock());
        }
        navegacion.mostrarPantallaResumenDeCompra(listaAEnviar, totalCalculado, navegacion, mensajes, controlRefacciones, controlVentas, validaciones);
        this.dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       navegacion.mostrarMenuPrincipal();
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JScrollPane scrollPaneRefacciones;
    private javax.swing.JScrollPane scrollPaneRefaccionesSeleccionados;
    // End of variables declaration//GEN-END:variables
}
