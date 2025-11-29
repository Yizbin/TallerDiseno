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
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author Abraham Coronel
 */
public interface IGestorTaller {

    // Órdenes
    public OrdenDTO crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException;

    // Autenticación general
    public Boolean autenticarUsuario(String usuario, String contrasena);

    // Clientes
    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException;

    // Vehículos
    public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente);

    // Empleados
    public Boolean autenticarEmpleado(String usuario, String contrasena);
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario);
    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo);
    public EmpleadoDTO buscarPorId(String idEmpleado);
    public List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException;
    public EmpleadoDTO obtenerDatosUsuario(String usuario);

    // Presupuestos
    public List<PresupuestoDTO> buscarPresupuestosPendientes() throws NegocioException;
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException;

    // Tareas
    public List<TareaDTO> obtenerTareasDeMecanico(String usuario) throws NegocioException;
    public void completarTareaMecanico(String idTarea) throws NegocioException;
    public List<TareaDTO> obtenerTareasParaTabla() throws NegocioException;
    public boolean asignarTareaAMecanico(String idTarea, String idMecanico) throws NegocioException;
    List<TareaDTO> obtenerTareasSinAsignar() throws NegocioException;

}
