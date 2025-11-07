/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion.main;

import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import gestionTaller.GestorTaller;
import gestionTaller.IGestorTaller;
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
        IManejoOrdenes manejoOrdenes = new ManejoOrdenes();
        IManejoClientes manejoClientes = new ManejoClientes();
        IManejoVehiculos manejoVehiculos = new ManejoVehiculos();

        IGestorTaller tallerServicio = new GestorTaller(
                manejoOrdenes,
                manejoClientes,
                manejoVehiculos
        );

        IValidacionesPresentacion validacionServicio = new ValidacionesPresentacion();
        ICreacionPaneles creacionPanelesServicio = new CreacionPaneles();

        IControlOrdenes controlOrdenes = new ControlOrdenes(
                tallerServicio,
                validacionServicio,
                creacionPanelesServicio
        );

        IControlNavegacion controlNavegacion = new ControlNavegacion(controlOrdenes);

        java.awt.EventQueue.invokeLater(() -> {
            new IniciarSesion(controlOrdenes, controlNavegacion).setVisible(true);
        });
    }

}
