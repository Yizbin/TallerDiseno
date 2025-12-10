/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionTaller;

import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.RefaccionDTO;
import dto.ServicioDTO;
import dto.ServicioPresupuestoDTO;
import dto.TareaDTO;
import dto.VehiculoDTO;
import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import gestionEmpleados.IManejoEmpleados;
import gestionOrdenes.IManejoOrdenes;
import gestionPresupuestos.IManejoPresupuestos;
import gestionRefacciones.IManejoRefacciones;
import gestionServicios.IManejoServicios;
import gestionVentas.IManejoVentas;
import gestionarClientes.IManejoClientes;
import gestionarTareas.IManejoTareas;
import gestionarVehiculos.IManejoVehiculos;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class GestorTaller implements IGestorTaller {

    private final IManejoOrdenes manejoOrdenes;
    private final IManejoClientes manejoClientes;
    private final IManejoVehiculos manejoVehiculos;
    private final IManejoEmpleados manejoEmpleados;
    private final IManejoPresupuestos manejoPresupuestos;
    private final IManejoTareas manejoTareas;
    private final IManejoServicios manejoServicios;
    private final IManejoRefacciones manejoRefacciones;
    private final IManejoVentas manejoVentas;
    
    
    public GestorTaller(IManejoOrdenes manejoOrdenes, IManejoClientes manejoClientes, IManejoVehiculos manejoVehiculos, IManejoEmpleados manejoEmpleados, IManejoPresupuestos manejoPresupuestos, IManejoTareas manejoTareas, IManejoServicios manejoServicios, IManejoRefacciones manejoRefacciones, IManejoVentas manejoVentas) {
        this.manejoOrdenes = manejoOrdenes;
        this.manejoClientes = manejoClientes;
        this.manejoVehiculos = manejoVehiculos;
        this.manejoEmpleados = manejoEmpleados;
        this.manejoPresupuestos = manejoPresupuestos;
        this.manejoTareas = manejoTareas;
        this.manejoServicios = manejoServicios;
        this.manejoRefacciones = manejoRefacciones;
        this.manejoVentas = manejoVentas;
    }

    @Override
    public OrdenDTO crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException {
        return this.manejoOrdenes.crearOrden(orden);
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        try {
            return this.manejoEmpleados.autenticarUsuario(usuario, contrasena);
        } catch (NegocioException ex) {
            System.err.println("Error de negocio en autenticación: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException {
        return this.manejoClientes.buscarTodosLosClientesActivos();
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente) {
        return this.manejoVehiculos.obtenerVehiculosPorCliente(idCliente);
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosPendientes() throws NegocioException {
        return manejoPresupuestos.obtenerPresupuestosNoPagados();
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException {
        return manejoPresupuestos.buscarPresupuestoPorOrden(idOrden);
    }

    @Override
    public List<TareaDTO> obtenerTareasDeMecanico(String usuario) throws NegocioException {
        EmpleadoDTO empleado = manejoEmpleados.obtenerDatosUsuario(usuario);
        if (empleado == null) {
            throw new NegocioException("Usuario no encontrado");
        }

        return manejoTareas.buscarTareasAsignadas(empleado.getId_empleado());
    }

    @Override
    public void completarTareaMecanico(String idTarea) throws NegocioException {
        manejoTareas.marcarTareaComoCompletada(idTarea);
    }

    @Override
    public List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException {
        return manejoEmpleados.obtenerMecanicosParaTabla();
    }

    @Override
    public List<TareaDTO> obtenerTareasParaTabla() throws NegocioException {
        return manejoTareas.obtenerTareasParaTabla();
    }

    @Override
    public Boolean autenticarEmpleado(String usuario, String contrasena) {
        try {
            return manejoEmpleados.autenticarEmpleado(usuario, contrasena);
        } catch (Exception ex) {
            System.err.println("Error al autenticar empleado: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) {
        try {
            return manejoEmpleados.obtenerEmpleadoPorUsuario(usuario);
        } catch (Exception ex) {
            System.err.println("Error al obtener empleado por usuario: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo) {
        try {
            return manejoEmpleados.actualizarEstadoEmpleado(idEmpleado, activo);
        } catch (Exception ex) {
            System.err.println("Error al actualizar estado del empleado con ID " + idEmpleado + ": " + ex.getMessage());
            return null;
        }
    }

    @Override
    public EmpleadoDTO buscarPorId(String idEmpleado) {
        try {
            return manejoEmpleados.buscarPorId(idEmpleado);
        } catch (Exception ex) {
            System.err.println("Error al buscar empleado con ID " + idEmpleado + ": " + ex.getMessage());
            return null;
        }
    }

    @Override
    public EmpleadoDTO obtenerDatosUsuario(String usuario) {
        return obtenerEmpleadoPorUsuario(usuario);
    }

    @Override
    public boolean asignarTareaAMecanico(String idTarea, String idMecanico) throws NegocioException {
        return manejoTareas.asignarTareaAMecanico(idTarea, idMecanico);
    }

    @Override
    public List<TareaDTO> obtenerTareasSinAsignar() throws NegocioException {
        return manejoTareas.obtenerTareasSinAsignar();
    }

    @Override
    public List<TareaDTO> obtenerTareasCompletadasPorMecanico(String idMecanico) throws NegocioException {
        return manejoTareas.obtenerTareasCompletadasPorMecanico(idMecanico);
    }

    @Override
    public List<OrdenDTO> buscarOrdenesPorCliente(ClienteDTO cliente) throws NegocioException {
        return manejoOrdenes.buscarOrdenesPorCliente(cliente.getId_cliente());
    }

    @Override
    public ServicioDTO crearServicio(ServicioDTO dto) throws NegocioException {
        return manejoServicios.crearServicio(dto);
    }

    @Override
    public ServicioDTO actualizarServicio(ServicioDTO dto) throws NegocioException {
        return manejoServicios.actualizarServicio(dto);
    }

    @Override
    public ServicioDTO eliminarServicio(String id) throws NegocioException {
        return manejoServicios.eliminarServicio(id);
    }

    @Override
    public List<ServicioDTO> obtenerTodos() throws NegocioException {
       return manejoServicios.obtenerTodos();
    }

    @Override
    public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadDuplicadaNegocioException {
        return manejoRefacciones.crearRefaccion(refaccionDTO);
    }

    @Override
    public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadNoEncontradaNegocioException {
        return manejoRefacciones.actualizarRefaccion(refaccionDTO);
    }

    @Override
    public List<RefaccionDTO> buscarTodasLasRefacciones() throws NegocioException, EntidadDuplicadaNegocioException {
        return manejoRefacciones.buscarTodasLasRefacciones();
    }

    @Override
    public RefaccionDTO buscarRefaccionPorId(String id) throws NegocioException, EntidadNoEncontradaNegocioException {
        return manejoRefacciones.buscarRefaccionPorId(id);
    }

    @Override
    public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException {
        return manejoVentas.crearVenta(detalles);
    }

    @Override
    public VentaDTO buscarVentaPorId(Long id) throws NegocioException {
        return manejoVentas.buscarVentaPorId(id);
    }

    @Override
    public List<VentaDTO> buscarTodasLasVentas() throws NegocioException {
       return manejoVentas.buscarTodasLasVentas();
    }

    @Override
    public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) throws EntidadDuplicadaNegocioException, NegocioException {
       return manejoVentas.crearVentaRefaccion(dto);
    }

    @Override
    public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) throws EntidadNoEncontradaNegocioException, NegocioException {
        return manejoVentas.actualizarVentaRefaccion(dto);
    }

    @Override
    public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        return manejoVentas.buscarVentaRefaccionPorId(id);
    }

    @Override
    public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) throws NegocioException {
        return manejoVentas.buscarPorIdVenta(idVenta);
    }

    @Override
    public List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException {
        return manejoPresupuestos.buscarPorIdPresupuesto(idPresupuesto);
    }

    @Override
    public List<PresupuestoRefaccionDTO> buscarPorIdPresupuestoPR(String idPresupuesto) throws NegocioException {
       return manejoPresupuestos.buscarPorIdPresupuestoPR(idPresupuesto);
    }

    @Override
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadDuplicadaNegocioException, NegocioException {
        return manejoPresupuestos.crearPresupuesto(presupuestoDTO);
    }

    @Override
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadNoEncontradaNegocioException, NegocioException {
        return manejoPresupuestos.actualizarPresupuesto(presupuestoDTO);
    }

    @Override
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() throws EntidadDuplicadaNegocioException, NegocioException {
        return manejoPresupuestos.buscarTodosLosPresupuestos();
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
       return manejoPresupuestos.buscarPresupuestoPorId(id);
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosNoPagados() throws NegocioException {
        return manejoPresupuestos.obtenerPresupuestosNoPagados();
    }
    
}