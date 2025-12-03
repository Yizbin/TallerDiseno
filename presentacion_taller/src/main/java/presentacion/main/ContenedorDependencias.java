/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.main;

import gestionEmpleados.IManejoEmpleados;
import gestionEmpleados.ManejoEmpleados;
import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import gestionPagos.GestorPagos;
import gestionPresupuestos.IManejoPresupuestos;
import gestionPresupuestos.ManejoPresupuestos;
import gestionServicios.IManejoServicios;
import interfaz.IGestorPagos;
import gestionTaller.GestorTaller;
import gestionTaller.IGestorTaller;
import gestionarClientes.IManejoClientes;
import gestionarClientes.ManejoClientes;
import gestionarTareas.IManejoTareas;
import gestionarTareas.ManejoTareas;
import gestionServicios.ManejoServicios;
import gestionServicios.IManejoServicios;
import gestionarVehiculos.IManejoVehiculos;
import gestionarVehiculos.ManejoVehiculos;
import presentacion.controles.ControlAutenticacion;
import presentacion.controles.ControlClientes;
import presentacion.controles.ControlCreacionUI;
import presentacion.controles.ControlEmpleados;
import presentacion.controles.ControlMensajes;
import presentacion.controles.ControlNavegacion;
import presentacion.controles.ControlOrdenes;
import presentacion.controles.ControlPagos;
import presentacion.controles.ControlPresupuestos;
import presentacion.controles.ControlServicios;
import presentacion.controles.ControlTareas;
import presentacion.controles.ControlValidaciones;
import presentacion.controles.ControlVehiculos;
import presentacion.controles.IControlAutenticacion;
import presentacion.controles.IControlClientes;
import presentacion.controles.IControlCreacionUI;
import presentacion.controles.IControlEmpleados;
import presentacion.controles.IControlMensajes;
import presentacion.controles.IControlNavegacion;
import presentacion.controles.IControlOrdenes;
import presentacion.controles.IControlPagos;
import presentacion.controles.IControlPresupuestos;
import presentacion.controles.IControlServicios;
import presentacion.controles.IControlTareas;
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
    private final IManejoEmpleados manejoEmpleados = ManejoEmpleados.getInstancia();
    private final IManejoPresupuestos manejoPresupuestos = ManejoPresupuestos.getInstancia();
    private final IManejoTareas manejoTareas = ManejoTareas.getInstancia();
    private final IManejoServicios manejoServicios = ManejoServicios.getInstancia();
            
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
    private final IControlPresupuestos controlPresupuestos;
    private final IControlTareas controlTareas;
    private final IControlEmpleados controlEmpleados;
    private final IControlServicios controlServicios;
    
    private final IControlNavegacion controlNavegacion;
    
   

    public ContenedorDependencias() {
        this.validacionServicio = new ValidacionesPresentacion();
        this.creacionPaneles = new CreacionPaneles();
        this.creacionTablas = new CreacionTablas();
        this.gestorPagos = new GestorPagos();
      
        this.tallerServicio = new GestorTaller(
                manejoOrdenes,
                manejoClientes,
                manejoVehiculos,
                manejoEmpleados,
                manejoPresupuestos,
                manejoTareas,
                manejoServicios
        );

        this.controlOrdenes = new ControlOrdenes(tallerServicio);
        this.controlClientes = new ControlClientes(tallerServicio);
        this.controlVehiculos = new ControlVehiculos(tallerServicio);
        this.controlAutenticacion = new ControlAutenticacion(tallerServicio);
        this.controlPagos = new ControlPagos(gestorPagos);
        this.controlServicios = new ControlServicios(tallerServicio);
        
        this.controlValidaciones = new ControlValidaciones(validacionServicio);
        this.controlCreacionUI = new ControlCreacionUI(creacionPaneles, creacionTablas);
        this.controlMensajes = new ControlMensajes();
        this.controlPresupuestos = new ControlPresupuestos(tallerServicio);
        this.controlTareas = new ControlTareas(tallerServicio);
        this.controlEmpleados = new ControlEmpleados(tallerServicio);

        this.controlNavegacion = new ControlNavegacion(
                controlOrdenes,
                controlClientes,
                controlVehiculos,
                controlValidaciones,
                controlMensajes,
                controlCreacionUI,
                controlPresupuestos,
                controlPagos,
                controlTareas,
                controlEmpleados,
                controlServicios
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

    public IManejoOrdenes getManejoOrdenes() {
        return manejoOrdenes;
    }

    public IManejoClientes getManejoClientes() {
        return manejoClientes;
    }

    public IManejoVehiculos getManejoVehiculos() {
        return manejoVehiculos;
    }

    public IManejoEmpleados getManejoEmpleados() {
        return manejoEmpleados;
    }

    public IManejoPresupuestos getManejoPresupuestos() {
        return manejoPresupuestos;
    }

    public IManejoTareas getManejoTareas() {
        return manejoTareas;
    }

    public IGestorPagos getGestorPagos() {
        return gestorPagos;
    }

    public IValidacionesPresentacion getValidacionServicio() {
        return validacionServicio;
    }

    public ICreacionPaneles getCreacionPaneles() {
        return creacionPaneles;
    }

    public ICreacionTablas getCreacionTablas() {
        return creacionTablas;
    }

    public IControlPagos getControlPagos() {
        return controlPagos;
    }

    public IControlPresupuestos getControlPresupuestos() {
        return controlPresupuestos;
    }

    public IControlTareas getControlTareas() {
        return controlTareas;
    }

    public IControlEmpleados getControlEmpleados() {
        return controlEmpleados;
    }

}
