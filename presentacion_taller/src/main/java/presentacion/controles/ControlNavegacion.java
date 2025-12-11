/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import presentacion.GenerarPresupuesto.PantallaGenerarPresupuesto;
import presentacion.GenerarPresupuesto.PantallaPresupuestoGenerado;
import presentacion.GenerarPresupuesto.PantallaSeleccionarCliente;
import presentacion.GenerarPresupuesto.PantallaSeleccionarOrden;
import presentacion.AsignarTarea.PantallaElegirMecanico;
import presentacion.AsignarTarea.PantallaElegirTarea;
import presentacion.ComprarRefaccion.PantallaPagoMercadoLibre;
import presentacion.ComprarRefaccion.PantallaPagoPayPal;
import presentacion.ComprarRefaccion.PantallaPagoTarjeta;
import presentacion.ComprarRefaccion.PantallaResumenDeCompra;
import presentacion.ComprarRefaccion.PantallaSeleccionarRefacciones;
import presentacion.ComprarRefaccion.pantallaResumenRe;
import presentacion.GenerarPresupuesto.pantallaResumen;
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
import presentacion.VerHistorial.PantallaVerHistorial;

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
    private final IControlTareas tareas;
    private final IControlEmpleados controlEmpleados;
    private final IControlServicios controlServicios;
    private final IControlRefacciones controlRefacciones;
    private final IControlDocumentos controlDocumentos;
    private final IControlVentas controlVentas;

    private EmpleadoDTO empleadoActivo;
    private OrdenDTO orden;
    private ServicioDTO servicio;
    private PresupuestoDTO presupuestoDTO;

    public ControlNavegacion(IControlOrdenes controlOrdenes, IControlClientes clientes, IControlVehiculos vehiculos, IControlValidaciones validaciones, IControlMensajes mensajes, IControlCreacionUI creacion, IControlPresupuestos presupuesto, IControlPagos pagos, IControlTareas tareas, IControlEmpleados controlEmpleados, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlDocumentos controlDocumentos, IControlVentas controlVentas) {
        this.controlOrdenes = controlOrdenes;
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        this.validaciones = validaciones;
        this.mensajes = mensajes;
        this.creacion = creacion;
        this.presupuesto = presupuesto;
        this.pagos = pagos;
        this.tareas = tareas;
        this.controlEmpleados = controlEmpleados;
        this.controlServicios = controlServicios;
        this.controlRefacciones = controlRefacciones;
        this.controlDocumentos = controlDocumentos;
        this.controlVentas = controlVentas;
    }

    @Override
    public void mostrarMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal(this, controlRefacciones, creacion, mensajes, controlVentas, validaciones, clientes, presupuesto, controlOrdenes, presupuesto);
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
        if (empleadoActivo == null) {
            mensajes.mostrarErrorCampos("No se ha detectado una sesión activa.");
            return;
        }

        PantallaTareasMecanico pantalla = new PantallaTareasMecanico(
                this,
                this.mensajes,
                this.creacion,
                this.tareas,
                this.empleadoActivo,
                this.controlDocumentos
        );
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarMenuPrincipalAdmin() {
        MenuPrincipalAdmin menu = new MenuPrincipalAdmin(this);
        menu.setVisible(true);
    }

    @Override
    public void mostrarPantallaSeleccionarCliente(IControlNavegacion navegacion, IControlClientes clientes, 
            IControlCreacionUI creacion, IControlPresupuestos control, IControlOrdenes controlOrdenes, IControlPresupuestos presupuesto, OrdenDTO orden, IControlMensajes mensajes) {
        
        IControlClientes clientesSeguro = (clientes != null) ? clientes : this.clientes;
        
        IControlCreacionUI creacionSegura = (creacion != null) ? creacion : this.creacion;
        
        PantallaSeleccionarCliente pantalla = new PantallaSeleccionarCliente(
                navegacion, 
                clientesSeguro, 
                creacionSegura, 
                control, 
                controlOrdenes, 
                presupuesto, 
                orden, 
                mensajes
        );
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaSeleccionarOrden(IControlOrdenes controlOrdenes, IControlCreacionUI creacion, ClienteDTO clienteDTO, OrdenDTO orden, IControlPresupuestos controlPresupuesto, IControlMensajes mensajes, IControlClientes clientes) {      
        IControlOrdenes ordenesSeguro = (controlOrdenes != null) ? controlOrdenes : this.controlOrdenes;


        IControlCreacionUI creacionSegura = (creacion != null) ? creacion : this.creacion;

        IControlPresupuestos presupuestoSeguro = (controlPresupuesto != null) ? controlPresupuesto : this.presupuesto;

        IControlClientes clientesSeguro = (clientes != null) ? clientes : this.clientes;
        
        PantallaSeleccionarOrden pantalla = new PantallaSeleccionarOrden(
                this, 
                ordenesSeguro,    
                creacionSegura,  
                clienteDTO, 
                orden, 
                this.presupuestoDTO, 
                this.servicio, 
                this.controlServicios, 
                this.controlRefacciones, 
                presupuestoSeguro, 
                mensajes, 
                clientesSeguro    
        );
        pantalla.setVisible(true);
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
        PantallaReciboPago pantalla = new PantallaReciboPago(this, idTransaccion, presupuesto, this.controlDocumentos, this.mensajes);
        pantalla.setVisible(true);
    }

    @Override
    public void setUsuarioActivo(EmpleadoDTO empleado) {
        this.empleadoActivo = empleado;
    }

    @Override
    public void mostrarPantallaElegirMecanico() {
        PantallaElegirMecanico pantalla = new PantallaElegirMecanico(
                this.controlEmpleados,
                this.mensajes,
                this.creacion,
                this
        );
        pantalla.setVisible(true);

    }

    @Override
    public void mostrarPantallaElegirTarea(String idMecanico) {
        PantallaElegirTarea pantalla = new PantallaElegirTarea(
                idMecanico,
                this.tareas,
                this.mensajes,
                this.creacion,
                this
        );
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaHistorialTareas() {
        if (empleadoActivo == null) {
            mensajes.mostrarErrorCampos("No se ha detectado una sesión activa.");
            return;
        }

        PantallaVerHistorial pantalla = new PantallaVerHistorial(
                this,
                this.mensajes,
                this.creacion,
                this.tareas,
                this.controlDocumentos,
                this.empleadoActivo
        );

        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaGenerarPresupuesto(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, PresupuestoDTO presupuesto, 
            ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlPresupuestos controlPresupuesto,IControlMensajes mensajes, IControlClientes clientes) {
        IControlRefacciones refaccionesSeguras = (controlRefacciones != null) ? controlRefacciones : this.controlRefacciones;
       
        IControlCreacionUI creacionSegura = (creacion != null) ? creacion : this.creacion;

        IControlServicios serviciosSeguros = (controlServicios != null) ? controlServicios : this.controlServicios;

        if (creacionSegura == null) System.err.println("ERROR CRITICO: creacionUI es NULL en ControlNavegacion");

        PantallaGenerarPresupuesto pantalla = new PantallaGenerarPresupuesto(
                navegacion, 
                creacionSegura, 
                orden, 
                cliente, 
                presupuesto, 
                servicio, 
                serviciosSeguros, 
                refaccionesSeguras, 
                controlOrdenes, 
                controlPresupuesto, 
                mensajes, 
                clientes
        );
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaPresupuestoGenerado(IControlNavegacion navegacion, IControlCreacionUI creacion, OrdenDTO orden, ClienteDTO cliente, PresupuestoDTO presupuesto, 
            ServicioDTO servicio, IControlServicios controlServicios, IControlRefacciones controlRefacciones, IControlPresupuestos controlPresupuesto, IControlMensajes mensajes, IControlClientes clientes) {

        IControlMensajes mensajesSeguro = (mensajes != null) ? mensajes : this.mensajes;

        IControlPresupuestos presupuestoSeguro = (controlPresupuesto != null) ? controlPresupuesto : this.presupuesto;

        IControlCreacionUI creacionSegura = (creacion != null) ? creacion : this.creacion;

        IControlServicios serviciosSeguros = (controlServicios != null) ? controlServicios : this.controlServicios;
        IControlRefacciones refaccionesSeguras = (controlRefacciones != null) ? controlRefacciones : this.controlRefacciones;
        
    

        PantallaPresupuestoGenerado pantalla = new PantallaPresupuestoGenerado(
                navegacion, 
                creacionSegura, 
                orden, 
                cliente, 
                presupuesto, 
                servicio, 
                serviciosSeguros, 
                refaccionesSeguras, 
                presupuestoSeguro, 
                mensajesSeguro,   
                clientes
        );
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaSeleccionarRefacciones(IControlRefacciones controlRefacciones, IControlCreacionUI creacion, IControlMensajes mensajes, IControlNavegacion navegacion, IControlVentas controlVentas, IControlValidaciones validaciones) {
        
        IControlRefacciones refaccionesSeguras = (controlRefacciones != null) ? controlRefacciones : this.controlRefacciones;
        
        IControlCreacionUI creacionSegura = (creacion != null) ? creacion : this.creacion;

        PantallaSeleccionarRefacciones pantalla = new PantallaSeleccionarRefacciones(
            refaccionesSeguras, 
            creacionSegura,    
            mensajes, 
            navegacion, 
            controlVentas, 
            validaciones
        );
        pantalla.setVisible(true);
    }

    @Override
   public void mostrarPantallaPagoMercadoLibre(List<RefaccionDTO> lista, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, 
                                               IControlVentas controlVentas, IControlValidaciones validaciones) {
       
        IControlValidaciones validacionesSeguras = (validaciones != null) ? validaciones : this.validaciones;
        IControlMensajes mensajesSeguros = (mensajes != null) ? mensajes : this.mensajes;
        IControlVentas ventasSeguras = (controlVentas != null) ? controlVentas : this.controlVentas;
        IControlRefacciones refaccionesSeguras = (controlRefacciones != null) ? controlRefacciones : this.controlRefacciones;

        PantallaPagoMercadoLibre pantalla = new PantallaPagoMercadoLibre(lista, total, navegacion, mensajesSeguros, refaccionesSeguras, ventasSeguras, validacionesSeguras);
        pantalla.setVisible(true);
    }

    @Override
   public void mostrarPantallaPagoPayPal(List<RefaccionDTO> lista, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, 
                                               IControlVentas controlVentas, IControlValidaciones validaciones) {
        
        IControlValidaciones validacionesSeguras = (validaciones != null) ? validaciones : this.validaciones;
        IControlMensajes mensajesSeguros = (mensajes != null) ? mensajes : this.mensajes;
        IControlVentas ventasSeguras = (controlVentas != null) ? controlVentas : this.controlVentas;
        IControlRefacciones refaccionesSeguras = (controlRefacciones != null) ? controlRefacciones : this.controlRefacciones;

        PantallaPagoPayPal pantalla = new PantallaPagoPayPal(lista, total, navegacion, mensajesSeguros, refaccionesSeguras, ventasSeguras, validacionesSeguras);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaPagoTarjeta(List<RefaccionDTO> lista, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, 
                                               IControlVentas controlVentas, IControlValidaciones validaciones) {
        
        IControlValidaciones validacionesSeguras = (validaciones != null) ? validaciones : this.validaciones;
        IControlMensajes mensajesSeguros = (mensajes != null) ? mensajes : this.mensajes;
        IControlVentas ventasSeguras = (controlVentas != null) ? controlVentas : this.controlVentas;
        IControlRefacciones refaccionesSeguras = (controlRefacciones != null) ? controlRefacciones : this.controlRefacciones;


        PantallaPagoTarjeta pantalla = new PantallaPagoTarjeta(
                lista, 
                total, 
                navegacion, 
                mensajesSeguros,   
                refaccionesSeguras,  
                ventasSeguras,       
                validacionesSeguras  
        );
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaResumenDeCompra(List<RefaccionDTO> productosSeleccionados, double total, IControlNavegacion navegacion, IControlMensajes mensajes, IControlRefacciones controlRefacciones, IControlVentas controlVentas, IControlValidaciones validaciones) {
        PantallaResumenDeCompra pantalla = new PantallaResumenDeCompra(productosSeleccionados, total, navegacion, mensajes, controlRefacciones, controlVentas, validaciones);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaResumenRe(List<RefaccionDTO> productosSeleccionados, double total, IControlNavegacion navegacion, IControlDocumentos documentos, 
                             IControlMensajes mensajes) {
       IControlDocumentos docsParaUsar = (documentos != null) ? documentos : this.controlDocumentos;
        IControlMensajes msgsParaUsar = (mensajes != null) ? mensajes : this.mensajes;

        if (docsParaUsar == null || msgsParaUsar == null) {
            System.err.println("¡ADVERTENCIA! Se abrirá la pantalla ResumenRe sin controles de documentos o mensajes.");
        }
        pantallaResumenRe pantalla = new pantallaResumenRe(productosSeleccionados, total, navegacion, docsParaUsar, msgsParaUsar);
        pantalla.setVisible(true);
    }

    @Override
    public void mostrarPantallaResumen(PresupuestoDTO presupuesto, IControlDocumentos documentos, IControlMensajes mensajes,  IControlNavegacion navegacion) {
        IControlDocumentos docsParaUsar = (documentos != null) ? documentos : this.controlDocumentos;
        
        if (docsParaUsar == null) {
            System.err.println("¡ERROR GRAVE! Tanto el parámetro como this.controlDocumentos son NULL.");
        }
        pantallaResumen pantalla = new pantallaResumen(presupuesto, docsParaUsar, mensajes, navegacion);
        pantalla.setVisible(true);
    }

}
