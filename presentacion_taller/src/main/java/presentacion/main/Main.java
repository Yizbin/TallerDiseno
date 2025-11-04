/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion.main;

import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import gestionarClientes.IManejoClientes;
import gestionarClientes.ManejoClientes;
import gestionarVehiculos.IManejoVehiculos;
import gestionarVehiculos.ManejoVehiculos;
import presentacion.IniciarSesion;
import presentacion.controles.ControlNavegacion;
import presentacion.controles.ControlOrdenes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlOrdenes;
import presentacion.utilerias.CreacionPaneles;
import presentacion.utilerias.ICreacionPaneles;
import presentacion.validaciones.IValidacionesPresentacion;
import presentacion.validaciones.ValidacionesPresentacion;

/**
 *
 * @author Abraham Coronel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IManejoOrdenes manejoServicio = ManejoOrdenes.getInstancia();
        IValidacionesPresentacion validacionServicio = ValidacionesPresentacion.getInstancia();
        IManejoClientes clientesServicio = ManejoClientes.getInstancia();
        ICreacionPaneles creacionPanelesServicio = CreacionPaneles.getInstancia();
        IManejoVehiculos vehiculosServicio = ManejoVehiculos.getInstancia();

        IControlOrdenes controlOrdenes = new ControlOrdenes(
                manejoServicio,
                validacionServicio,
                clientesServicio,
                creacionPanelesServicio,
                vehiculosServicio
        );

        IControlNavegacion controlNavegacion = new ControlNavegacion(controlOrdenes);

        java.awt.EventQueue.invokeLater(() -> {
            new IniciarSesion(controlOrdenes, controlNavegacion).setVisible(true);
        });
    }

}
