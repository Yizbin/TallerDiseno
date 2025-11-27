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
import dto.TareaDTO;
import dto.VehiculoDTO;
import excepciones.NegocioException;
import gestionEmpleados.IManejoEmpleados;
import gestionOrdenes.IManejoOrdenes;
import gestionPresupuestos.IManejoPresupuestos;
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
    
    public GestorTaller(IManejoOrdenes manejoOrdenes, IManejoClientes manejoClientes, IManejoVehiculos manejoVehiculos, IManejoEmpleados manejoEmpleados, IManejoPresupuestos manejoPresupuestos, IManejoTareas manejoTareas) {
        this.manejoOrdenes = manejoOrdenes;
        this.manejoClientes = manejoClientes;
        this.manejoVehiculos = manejoVehiculos;
        this.manejoEmpleados = manejoEmpleados;
        this.manejoPresupuestos = manejoPresupuestos;
        this.manejoTareas = manejoTareas;
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
    public EmpleadoDTO obtenerDatosUsuario(String usuario) {
        try {
            return this.manejoEmpleados.obtenerDatosUsuario(usuario);
        } catch (NegocioException ex) {
            System.err.println("Error obteniendo el usuario: " + ex.getMessage());
            return null;
        }
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
    
}
