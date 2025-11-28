/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.EmpleadoDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.enums.NavegacionOrigen;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlNavegacion {

    public void mostrarMenuPrincipal();

    public void mostrarMenuPrincipalAdmin();

    public void mostrarDatosCliente();

    public void mostrarDatosVehiculo(OrdenDTO orden, NavegacionOrigen origen);

    public void mostrarDatosOrden(OrdenDTO orden, NavegacionOrigen origenPantalla, NavegacionOrigen origenCliente);

    public void mostrarClientesRegistrados();

    public void mostrarVehiculosRegistrados(OrdenDTO orden, NavegacionOrigen origen);

    public void regresarDatosOrden(NavegacionOrigen origen, OrdenDTO orden, NavegacionOrigen origenCliente);

    public void regresarVehiculosRegistrados(NavegacionOrigen origen);

    public void mostrarOrdenesPendientes();

    public void mostrarTareasMecanico();

    public void mostrarPantallaSeleccionarCliente();

    public void mostrarPantallaSeleccionarOrden();

    public void mostrarPantallaGenerarPresupuesto();

    public void mostrarPantallaPresupuestoGenerado();

    public void mostrarPantallaSeleccionMetodoPago(String idOrden);

    public void mostrarFormularioPaypal(String idOrden);

    public void mostrarFormularioMercadoPago(String idOrden);

    public void mostrarFormularioTarjeta(String idOrden);

    public void mostrarReciboPago(String idTransaccion, PresupuestoDTO presupuesto);

    public void setUsuarioActivo(EmpleadoDTO empleado);

    void mostrarPantallaElegirMecanico();
    
    void mostrarPantallaElegirTarea(EmpleadoDTO empleado);

}
