/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEmpleados;

import dto.EmpleadoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoEmpleados {

    // Autenticación general (usuarios del sistema)
    public Boolean autenticarUsuario(String usuario, String contrasena) throws NegocioException;

    // Obtener datos básicos de un usuario (EmpleadoDTO)
    public EmpleadoDTO obtenerDatosUsuario(String usuario) throws NegocioException;

    // Obtener lista de mecánicos activos para mostrar en tabla
    public List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException;

    // Métodos adicionales para completar el flujo de empleados
    // Autenticación específica de empleados
    public Boolean autenticarEmpleado(String usuario, String contrasena) throws NegocioException;

    // Obtener empleado por usuario
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) throws NegocioException;

    // Actualizar estado (activo/inactivo) de un empleado
    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo) throws NegocioException;

    // Buscar empleado por ID
    public EmpleadoDTO buscarPorId(String idEmpleado) throws NegocioException;
}
