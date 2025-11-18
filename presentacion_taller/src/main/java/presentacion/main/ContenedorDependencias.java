/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.main;

import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import gestionPagos.GestorPagos;
import interfaz.IGestorPagos;
import gestionTaller.GestorTaller;
import gestionTaller.IGestorTaller;
import gestionarClientes.IManejoClientes;
import gestionarClientes.ManejoClientes;
import gestionarVehiculos.IManejoVehiculos;
import gestionarVehiculos.ManejoVehiculos;
import presentacion.controles.ControlAutenticacion;
import presentacion.controles.ControlClientes;
import presentacion.controles.ControlCreacionUI;
import presentacion.controles.ControlMensajes;
import presentacion.controles.ControlNavegacion;
import presentacion.controles.ControlOrdenes;
import presentacion.controles.ControlPagos;
import presentacion.controles.ControlValidaciones;
import presentacion.controles.ControlVehiculos;
import presentacion.controles.IControlAutenticacion;
import presentacion.controles.IControlClientes;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlOrdenes;
import presentacion.controles.IControlPagos;
import presentacion.controles.IControlValidaciones;
import presentacion.controles.IControlVehiculos;
import presentacion.utilerias.CreacionPaneles;
import presentacion.utilerias.CreacionTablas;
import presentacion.utilerias.ICreacionPaneles;
import presentacion.utilerias.ICreacionTablas;
import presentacion.validaciones.IValidacionesPresentacion;
import presentacion.validaciones.ValidacionesPresentacion;

/**
 *
 * @author Abraham Coronel
 */
public class ContenedorDependencias {

    private final IManejoOrdenes manejoOrdenes = ManejoOrdenes.getInstancia();
    private final IManejoClientes manejoClientes = ManejoClientes.getInstancia();
    private final IManejoVehiculos manejoVehiculos = ManejoVehiculos.getInstancia();

    private final IGestorTaller tallerServicio;
    private final IGestorPagos gestorPagos;
    private final IValidacionesPresentacion validacionServicio;
    private final ICreacionPaneles creacionPaneles;
    private final ICreacionTablas creacionTablas;

    private final IControlOrdenes controlOrdenes;
    private final IControlClientes controlClientes;
    private final IControlVehiculos controlVehiculos;
    private final IControlAutenticacion controlAutenticacion;
    private final IControlPagos controlPagos;
    private final IControlValidaciones controlValidaciones;
    private final IControlCreacionUI controlCreacionUI;
    private final IControlMensajes controlMensajes;

    private final IControlNavegacion controlNavegacion;

    public ContenedorDependencias() {
        this.validacionServicio = new ValidacionesPresentacion();
        this.creacionPaneles = new CreacionPaneles();
        this.creacionTablas = new CreacionTablas();
        this.gestorPagos = new GestorPagos();

        this.tallerServicio = new GestorTaller(
                manejoOrdenes,
                manejoVehiculos,
                manejoClientes
        );

        this.controlOrdenes = new ControlOrdenes(tallerServicio);
        this.controlClientes = new ControlClientes(tallerServicio);
        this.controlVehiculos = new ControlVehiculos(tallerServicio);
        this.controlAutenticacion = new ControlAutenticacion(tallerServicio);
        this.controlPagos = new ControlPagos(gestorPagos);

        this.controlValidaciones = new ControlValidaciones(validacionServicio);
        this.controlCreacionUI = new ControlCreacionUI(creacionPaneles, creacionTablas);
        this.controlMensajes = new ControlMensajes();

        this.controlNavegacion = new ControlNavegacion(
                controlOrdenes,
                controlClientes,
                controlVehiculos,
                controlValidaciones,
                controlMensajes,
                controlCreacionUI
        );
    }

    public IControlOrdenes getControlOrdenes() {
        return controlOrdenes;
    }

    public IControlClientes getControlClientes() {
        return controlClientes;
    }

    public IControlVehiculos getControlVehiculos() {
        return controlVehiculos;
    }

    public IControlValidaciones getControlValidaciones() {
        return controlValidaciones;
    }

    public IControlMensajes getControlMensajes() {
        return controlMensajes;
    }

    public IControlAutenticacion getControlAutenticacion() {
        return controlAutenticacion;
    }

    public IControlCreacionUI getControlCreacionUI() {
        return controlCreacionUI;
    }

    public IControlNavegacion getControlNavegacion() {
        return controlNavegacion;
    }

    public IGestorTaller getTallerServicio() {
        return tallerServicio;
    }
}
