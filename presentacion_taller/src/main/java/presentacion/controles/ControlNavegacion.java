/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.OrdenDTO;
import presentacion.MenuPrincipal;
import presentacion.PantallaClientesRegistrados;
import presentacion.PantallaDatosCliente;
import presentacion.PantallaDatosOrden;
import presentacion.PantallaDatosVehiculo;
import presentacion.PantallaVehiculosRegistrados;
import presentacion.enums.NavegacionOrigen;

/**
 *
 * @author Abraham Coronel
 */
public class ControlNavegacion implements IControlNavegacion {

    private static ControlNavegacion instancia;

    private ControlNavegacion() {
    }

    public static ControlNavegacion getInstancia() {
        if (instancia == null) {
            instancia = new ControlNavegacion();
        }
        return instancia;
    }

    @Override
    public void mostrarMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);

    }

    @Override
    public void mostrarDatosCliente() {
        PantallaDatosCliente datosCliente = new PantallaDatosCliente();
        datosCliente.setVisible(true);
    }

    @Override
    public void mostrarDatosOrden(OrdenDTO orden, NavegacionOrigen origenPantalla, NavegacionOrigen origenCliente) {
        PantallaDatosOrden datosOrden = new PantallaDatosOrden(orden, origenPantalla, origenCliente);
        datosOrden.setVisible(true);
    }

    @Override
    public void mostrarDatosVehiculo(OrdenDTO orden, NavegacionOrigen origen) {
        PantallaDatosVehiculo datosVehiculo = new PantallaDatosVehiculo(orden, origen);
        datosVehiculo.setVisible(true);
    }

    @Override
    public void mostrarClientesRegistrados() {
        PantallaClientesRegistrados clientesRegistrados = new PantallaClientesRegistrados();
        clientesRegistrados.setVisible(true);
    }

    @Override
    public void mostrarVehiculosRegistrados(OrdenDTO orden, NavegacionOrigen origen) {
        PantallaVehiculosRegistrados vehiculosRegistrados = new PantallaVehiculosRegistrados(orden, origen);
        vehiculosRegistrados.setVisible(true);
    }

}
