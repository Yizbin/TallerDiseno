/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.RefaccionDTO;
import dto.ServicioDTO;
import dto.enums.NavegacionOrigen;
import java.util.List;

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

    public void mostrarPantallaSeleccionarCliente(IControlNavegacion navegacion, IControlClientes clientes, 
            IControlCreacionUI creacion, IControlPresupuestos control, IControlOrdenes controlOrdenes, IControlPresupuestos presupuesto, OrdenDTO orden, IControlMensajes mensajes);

    public void mostrarPantallaSeleccionarOrden(IControlOrdenes controlOrdenes, IControlCreacionUI creacion, ClienteDTO clienteDTO, OrdenDTO orden, IControlPresupuestos controlPresupuesto, IControlMensajes mensajes, IControlClientes clientes);

    public void mostrarPantallaGenerarPresupuesto(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, PresupuestoDTO presupuesto, 
            ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlPresupuestos controlPresupuesto,IControlMensajes mensajes, IControlClientes clientes);

    public void mostrarPantallaPresupuestoGenerado(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, PresupuestoDTO presupuesto, 
            ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlPresupuestos controlPresupuesto, IControlMensajes mensajes, IControlClientes clientes);

    public void mostrarPantallaSeleccionMetodoPago(String idOrden);

    public void mostrarFormularioPaypal(String idOrden);

    public void mostrarFormularioMercadoPago(String idOrden);

    public void mostrarFormularioTarjeta(String idOrden);

    public void mostrarReciboPago(String idTransaccion, PresupuestoDTO presupuesto);

    public void setUsuarioActivo(EmpleadoDTO empleado);

    public void mostrarPantallaElegirMecanico();

    public void mostrarPantallaElegirTarea(String idMecanico);

    public void mostrarPantallaHistorialTareas();
    
    public void mostrarPantallaSeleccionarRefacciones(IControlRefacciones controlRefacciones, IControlCreacionUI creacion, IControlMensajes mensajes, IControlNavegacion navegacion, IControlVentas controlVentas, IControlValidaciones validaciones);
    
    public void mostrarPantallaPagoMercadoLibre(List<RefaccionDTO> lista, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, 
                               IControlVentas controlVentas, IControlValidaciones validaciones);
    
    public void mostrarPantallaPagoPayPal(List<RefaccionDTO> lista, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, 
                               IControlVentas controlVentas, IControlValidaciones validaciones);
    
    public void mostrarPantallaPagoTarjeta(List<RefaccionDTO> lista, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, 
                               IControlVentas controlVentas, IControlValidaciones validaciones);

    public void mostrarPantallaResumenDeCompra(List<RefaccionDTO> productosSeleccionados, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, IControlVentas controlVentas, IControlValidaciones validaciones);
}
