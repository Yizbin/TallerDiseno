/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.GenerarPresupuesto;
import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.RefaccionDTO;
import dto.ServicioDTO;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import presentacion.controles.IControlClientes;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlRefacciones;
import presentacion.controles.IControlServicios;
/**
 *
 * @author Pride Factor Black
 */
public class PantallaGenerarPresupuesto extends javax.swing.JFrame {
    private final IControlNavegacion navegacion;
    private final IControlCreacionUI creacion;
    private final OrdenDTO orden;
    private final ClienteDTO cliente;
    private final PresupuestoDTO presupuesto;
    private final ServicioDTO servicio;
    private final IControlServicios controlServicios;
    private final IControlRefacciones controlRefacciones;

    public PantallaGenerarPresupuesto(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, PresupuestoDTO presupuesto, ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones) {
        initComponents();
        configurarVentana();
        this.navegacion = navegacion;
        this.orden = orden;
        this.creacion = creacion;
        this.cliente = cliente;
        this.presupuesto = presupuesto;
        this.servicio = servicio;
        this.controlServicios = controlServicios;
        this.controlRefacciones = controlRefacciones;
        
        jScrollPane3_Servicios.setOpaque(false);
        jScrollPane3_Servicios.getViewport().setOpaque(false);
        jScrollPane3_Servicios.setBorder(null);
        jScrollPane3_Servicios.getViewport().setBorder(null);
        cargarInformacionOrden();
        cargarServicios();
        
        jScrollPane2_Refacciones.setOpaque(false);
        jScrollPane2_Refacciones.getViewport().setOpaque(false);
        jScrollPane2_Refacciones.setBorder(null);
        jScrollPane2_Refacciones.getViewport().setBorder(null);
        
        cargarRefacciones();
    }

        private void configurarVentana() {
         this.setLocationRelativeTo(null);
    }
        private void cargarInformacionOrden() {

        if (cliente != null) {
            lblCliente.setText(cliente.getNombre() + " " + cliente.getApellidoP());
        }

        if (orden != null) {
            lblVehiculo.setText(orden.getVehiculo().getPlacas());
            lblFolio.setText(String.valueOf(orden.getIdOrden()));
        }
    }
        private void cargarServicios() {
           List<ServicioDTO> listaServicios = controlServicios.obtenerTodos();
           
           JPanel contenedor = new JPanel();
           contenedor.setOpaque(false);
           contenedor.setLayout(new javax.swing.BoxLayout(contenedor, javax.swing.BoxLayout.Y_AXIS));
           
           for (ServicioDTO servicio : listaServicios) {

              String nombre = servicio.getNombre();
              String descripcion = servicio.getDescripcion();
              double precio = servicio.getPrecio(); 

              JPanel panelServicio = creacion.crearPanelServicio(nombre, precio, descripcion);

              panelServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

              panelServicio.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                  // Acción al hacer click, puedes guardar el servicio seleccionado
            }
        });
        contenedor.add(panelServicio);
        contenedor.add(creacion.crearSeparador(8));
    }
        jScrollPane3_Servicios.setViewportView(contenedor);
}
        
        private void cargarRefacciones() {
            List<RefaccionDTO> refacciones = controlRefacciones.buscarTodasLasRefacciones();

            JPanel contenedor = new JPanel();
            contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
            contenedor.setOpaque(false);

            for (RefaccionDTO ref : refacciones) {

                JPanel panel = creacion.crearPanelRefaccion(
                        ref.getNombre(),
                        ref.getPrecioUnitario(),
                        ref.getStock()
                );

            // Spinner para elegir cantidad
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, ref.getStock(), 1));

            // Lo agregamos al panel (a la derecha)
            ((JPanel) panel.getComponent(1)).add(spinner);

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
    //                int cantidad = (int) spinner.getValue();
    //                agregarRefaccion(ref, cantidad);
            }
        });

        contenedor.add(panel);
    }

        jScrollPane2_Refacciones.setViewportView(contenedor);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2_Refacciones = new javax.swing.JScrollPane();
        jScrollPane3_Servicios = new javax.swing.JScrollPane();
        btnRegresar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblVehiculo = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane2_Refacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 310, 130));
        getContentPane().add(jScrollPane3_Servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 310, 130));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonRegresar.png"))); // NOI18N
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonSiguiente.png"))); // NOI18N
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, -1, -1));

        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 110, 30));

        lblVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, 30));
        getContentPane().add(lblFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 110, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PantallaGenerarPresupuestoCUA.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
       navegacion.mostrarPantallaPresupuestoGenerado();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
//        navegacion.mostrarPantallaSeleccionarOrden(clienteDTO);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JScrollPane jScrollPane2_Refacciones;
    private javax.swing.JScrollPane jScrollPane3_Servicios;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblVehiculo;
    // End of variables declaration//GEN-END:variables
}
