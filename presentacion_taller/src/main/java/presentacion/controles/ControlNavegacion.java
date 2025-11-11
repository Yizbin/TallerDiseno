/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;
import dto.enums.NavegacionOrigen;
import presentacion.MenuPrincipal;
import presentacion.PantallaClientesRegistrados;
import presentacion.PantallaDatosCliente;
import presentacion.PantallaDatosOrden;
import presentacion.PantallaDatosVehiculo;
import presentacion.PantallaVehiculosRegistrados;

/**
 *
 * @author Abraham Coronel
 */
public class ControlNavegacion implements IControlNavegacion {

    private final IControlOrdenes controlOrdenes;

    public ControlNavegacion(IControlOrdenes controlOrdenes) {
        this.controlOrdenes = controlOrdenes;
    }

    @Override
    public void mostrarMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal(this);
        menu.setVisible(true);

    }

    @Override
    public void mostrarDatosCliente() {
        PantallaDatosCliente datosCliente = new PantallaDatosCliente(this.controlOrdenes, this);
        datosCliente.setVisible(true);
    }

    @Override
    public void mostrarDatosOrden(OrdenDTO orden, NavegacionOrigen origenPantalla, NavegacionOrigen origenCliente) {
        PantallaDatosOrden datosOrden = new PantallaDatosOrden(this.controlOrdenes, this, orden, origenPantalla, origenCliente);
        datosOrden.setVisible(true);
    }

    @Override
    public void mostrarDatosVehiculo(OrdenDTO orden, NavegacionOrigen origen) {
        PantallaDatosVehiculo datosVehiculo = new PantallaDatosVehiculo(this.controlOrdenes, this, orden, origen);
        datosVehiculo.setVisible(true);
    }

    @Override
    public void mostrarClientesRegistrados() {
        PantallaClientesRegistrados clientesRegistrados = new PantallaClientesRegistrados(this.controlOrdenes, this);
        clientesRegistrados.setVisible(true);
    }

    @Override
    public void mostrarVehiculosRegistrados(OrdenDTO orden, NavegacionOrigen origen) {
        PantallaVehiculosRegistrados vehiculosRegistrados = new PantallaVehiculosRegistrados(this.controlOrdenes, this, orden, origen);
        vehiculosRegistrados.setVisible(true);
    }

    @Override
    public void regresarDatosOrden(NavegacionOrigen origen, OrdenDTO orden, NavegacionOrigen origenCliente) {
        if (origen != null) {
            switch (origen) {
                case DATOS_VEHICULO -> this.mostrarDatosVehiculo(orden, origenCliente);
                case VEHICULOS_REGISTRADOS -> this.mostrarVehiculosRegistrados(orden, origenCliente);
                default -> this.mostrarVehiculosRegistrados(orden, origenCliente);
            }
        } else {
            this.mostrarMenuPrincipal();
        }
    }

    @Override
    public void regresarVehiculosRegistrados(NavegacionOrigen origen) {
        if (origen != null) {
            switch (origen) {
                case DATOS_CLIENTE -> this.mostrarDatosCliente();
                case CLIENTES_REGISTRADOS -> this.mostrarClientesRegistrados();
                default -> this.mostrarClientesRegistrados();
            }
        } else {
            this.mostrarClientesRegistrados();
        }

    }

}
