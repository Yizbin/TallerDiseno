/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.enums.NavegacionOrigen;
import presentacion.GenerarPresupuesto.PantallaGenerarPresupuesto;
import presentacion.GenerarPresupuesto.PantallaPresupuestoGenerado;
import presentacion.GenerarPresupuesto.PantallaSeleccionarCliente;
import presentacion.GenerarPresupuesto.PantallaSeleccionarOrden;
import presentacion.MenuPrincipal;
import presentacion.MenuPrincipalAdmin;
import presentacion.PagarOrden.PantallaFormularioMercadoPago;
import presentacion.PagarOrden.PantallaFormularioPaypal;
import presentacion.PagarOrden.PantallaFormularioTarjeta;
import presentacion.PantallaClientesRegistrados;
import presentacion.PantallaDatosCliente;
import presentacion.PantallaDatosOrden;
import presentacion.PantallaDatosVehiculo;
import presentacion.PagarOrden.PantallaOrdenesPendientes;
import presentacion.PagarOrden.PantallaReciboPago;
import presentacion.PagarOrden.PantallaSeleccionMetodoPago;
import presentacion.TareaCompletada.PantallaTareasMecanico;
import presentacion.PantallaVehiculosRegistrados;

/**
 *
 * @author Abraham Coronel
 */
public class ControlNavegacion implements IControlNavegacion {

    private final IControlOrdenes controlOrdenes;
    private final IControlClientes clientes;
    private final IControlVehiculos vehiculos;
    private final IControlValidaciones validaciones;
    private final IControlMensajes mensajes;
    private final IControlCreacionUI creacion;
    private final IControlPresupuestos presupuesto;
    private final IControlPagos pagos;

    public ControlNavegacion(IControlOrdenes controlOrdenes, IControlClientes clientes, IControlVehiculos vehiculos, IControlValidaciones validaciones, IControlMensajes mensajes, IControlCreacionUI creacion, IControlPresupuestos presupuesto, IControlPagos pagos) {
        this.controlOrdenes = controlOrdenes;
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        this.validaciones = validaciones;
        this.mensajes = mensajes;
        this.creacion = creacion;
        this.presupuesto = presupuesto;
        this.pagos = pagos;
    }

    @Override
    public void mostrarMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal(this);
        menu.setVisible(true);
    }

    @Override
    public void mostrarDatosCliente() {
        PantallaDatosCliente datosCliente = new PantallaDatosCliente(this.controlOrdenes, this, this.validaciones, this.mensajes);
        datosCliente.setVisible(true);
    }

    @Override
    public void mostrarDatosOrden(OrdenDTO orden, NavegacionOrigen origenPantalla, NavegacionOrigen origenCliente) {
        PantallaDatosOrden datosOrden = new PantallaDatosOrden(this.controlOrdenes, this, orden, origenPantalla, origenCliente, this.validaciones, this.mensajes);
        datosOrden.setVisible(true);
    }

    @Override
    public void mostrarDatosVehiculo(OrdenDTO orden, NavegacionOrigen origen) {
        PantallaDatosVehiculo datosVehiculo = new PantallaDatosVehiculo(this, orden, origen, this.validaciones, this.mensajes);
        datosVehiculo.setVisible(true);
    }

    @Override
    public void mostrarClientesRegistrados() {
        PantallaClientesRegistrados clientesRegistrados = new PantallaClientesRegistrados(this.controlOrdenes, this, this.clientes, this.creacion);
        clientesRegistrados.setVisible(true);
    }

    @Override
    public void mostrarVehiculosRegistrados(OrdenDTO orden, NavegacionOrigen origen) {
        PantallaVehiculosRegistrados vehiculosRegistrados = new PantallaVehiculosRegistrados(this, orden, origen, this.vehiculos, this.creacion);
        vehiculosRegistrados.setVisible(true);
    }

    @Override
    public void regresarDatosOrden(NavegacionOrigen origen, OrdenDTO orden, NavegacionOrigen origenCliente) {
        if (origen != null) {
            switch (origen) {
                case DATOS_VEHICULO ->
                    this.mostrarDatosVehiculo(orden, origenCliente);
                case VEHICULOS_REGISTRADOS ->
                    this.mostrarVehiculosRegistrados(orden, origenCliente);
                default ->
                    this.mostrarVehiculosRegistrados(orden, origenCliente);
            }
        } else {
            this.mostrarMenuPrincipal();
        }
    }

    @Override
    public void regresarVehiculosRegistrados(NavegacionOrigen origen) {
        if (origen != null) {
            switch (origen) {
                case DATOS_CLIENTE ->
                    this.mostrarDatosCliente();
                case CLIENTES_REGISTRADOS ->
                    this.mostrarClientesRegistrados();
                default ->
                    this.mostrarClientesRegistrados();
            }
        } else {
            this.mostrarClientesRegistrados();
        }

    }

    @Override
    public void mostrarOrdenesPendientes() {
        PantallaOrdenesPendientes pantalla = new PantallaOrdenesPendientes(this, this.mensajes, this.creacion, this.presupuesto);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarTareasMecanico() {
        PantallaTareasMecanico pantalla = new PantallaTareasMecanico(this, this.mensajes, this.creacion);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarMenuPrincipalAdmin() {
        MenuPrincipalAdmin menu = new MenuPrincipalAdmin(this);
        menu.setVisible(true);
    }

    @Override
    public void mostrarPantallaSeleccionarCliente() {
        PantallaSeleccionarCliente pantalla = new PantallaSeleccionarCliente(this);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaSeleccionarOrden() {
        PantallaSeleccionarOrden pantalla = new PantallaSeleccionarOrden(this);
    }

    @Override
    public void mostrarPantallaGenerarPresupuesto() {
        PantallaGenerarPresupuesto pantalla = new PantallaGenerarPresupuesto(this);
    }

    @Override
    public void mostrarPantallaPresupuestoGenerado() {
        PantallaPresupuestoGenerado pantalla = new PantallaPresupuestoGenerado(this);
    }

    @Override
    public void mostrarPantallaSeleccionMetodoPago(String idOrden) {
        PantallaSeleccionMetodoPago pantalla = new PantallaSeleccionMetodoPago(this, idOrden);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarFormularioPaypal(String idOrden) {
        PantallaFormularioPaypal pantalla = new PantallaFormularioPaypal(this, this.presupuesto, idOrden, this.pagos, this.validaciones, this.mensajes);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarFormularioMercadoPago(String idOrden) {
        PantallaFormularioMercadoPago pantalla = new PantallaFormularioMercadoPago(this, idOrden, this.pagos, this.validaciones, this.mensajes, this.presupuesto);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarFormularioTarjeta(String idOrden) {
        PantallaFormularioTarjeta pantalla = new PantallaFormularioTarjeta(this, idOrden, this.pagos, this.validaciones, this.mensajes, this.presupuesto);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarReciboPago(String idTransaccion, PresupuestoDTO presupuesto) {
        PantallaReciboPago pantalla = new PantallaReciboPago(this, idTransaccion, presupuesto);
        pantalla.setVisible(true);
    }

}
