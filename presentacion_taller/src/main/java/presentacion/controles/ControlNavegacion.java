/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;
import dto.enums.NavegacionOrigen;
import presentacion.MenuPrincipal;
import presentacion.MenuPrincipalAdmin;
import presentacion.PantallaClientesRegistrados;
import presentacion.PantallaDatosCliente;
import presentacion.PantallaDatosOrden;
import presentacion.PantallaDatosVehiculo;
import presentacion.PantallaOrdenesPendientes;
import presentacion.PantallaTareasMecanico;
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

    public ControlNavegacion(IControlOrdenes controlOrdenes, IControlClientes clientes, IControlVehiculos vehiculos, IControlValidaciones validaciones, IControlMensajes mensajes, IControlCreacionUI creacion) {
        this.controlOrdenes = controlOrdenes;
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        this.validaciones = validaciones;
        this.mensajes = mensajes;
        this.creacion = creacion;
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
        PantallaOrdenesPendientes pantalla = new PantallaOrdenesPendientes(this, this.mensajes, this.creacion);
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

}
