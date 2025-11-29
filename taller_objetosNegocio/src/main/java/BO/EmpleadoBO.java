/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IEmpleadoBO;
import DAO.EmpleadoDAO;
import DAO.interfaces.IEmpleadoDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.EmpleadoMapper;
import Mappers.interfaces.IEmpleadoMapper;
import dto.EmpleadoDTO;
import entidades.Empleado;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Abraham Coronel
 */
public class EmpleadoBO implements IEmpleadoBO {

    private static IEmpleadoBO instancia;

    private final IEmpleadoDAO empleadoDAO = EmpleadoDAO.getInstancia();
    private final IEmpleadoMapper mapper;

    private EmpleadoBO() {
        this.mapper = new EmpleadoMapper();
    }

    public static IEmpleadoBO getInstancia() {
        if (instancia == null) {
            instancia = new EmpleadoBO();
        }
        return instancia;
    }

    @Override
    public Boolean autenticarEmpleado(String usuario, String contrasena) throws NegocioException {
        try {
            empleadoDAO.autenticarEmpleado(usuario, contrasena);
            return true;
        } catch (EntidadNoEncontradaException e) {
            return false;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error a la hora de autenticar: " + e.getMessage());
        }
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) throws NegocioException {
        try {
            Empleado e = empleadoDAO.buscarPorUsuario(usuario);

            return new EmpleadoDTO(
                    e.getId().toString(),
                    e.getNombre(),
                    e.getApellidoP(),
                    e.getApellidoM(),
                    e.getRol(),
                    e.getUsuario(),
                    null,
                    e.getActivo()
            );

        } catch (EntidadNoEncontradaException | PersistenciaException ex) {
            throw new NegocioException("Error al obtener datos del empleado: " + ex.getMessage());
        }
    }

    @Override
    public List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException {
        try {
            List<Empleado> mecanicos = empleadoDAO.obtenerMecanicos();
            return mapper.toListDTO(mecanicos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener mecánicos: " + e.getMessage());
        }
    }

    @Override
    public EmpleadoDTO buscarPorId(String idEmpleado) throws NegocioException {
        try {
            Long id = Long.valueOf(idEmpleado);
            Empleado empleado = empleadoDAO.buscarPorId(id);
            return mapper.toDTO(empleado);
        } catch (NumberFormatException e) {
            throw new NegocioException("El ID proporcionado no es válido: " + idEmpleado, e);
        } catch (EntidadNoEncontradaException e) {
            throw new NegocioException("No se encontró el empleado con ID: " + idEmpleado, e);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar empleado por ID: " + e.getMessage(), e);
        }
    }

    @Override
    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo) throws NegocioException {
        try {
            if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
                throw new NegocioException("El ID del empleado no puede estar vacío");
            }

            if (activo == null) {
                throw new NegocioException("El estado activo/inactivo no puede ser nulo");
            }

            Long id = Long.valueOf(idEmpleado);

            empleadoDAO.actualizarEstadoEmpleado(id, activo);

            Empleado actualizado = empleadoDAO.buscarPorId(id);

            return mapper.toDTO(actualizado);

        } catch (NumberFormatException e) {
            throw new NegocioException("El ID proporcionado no es válido: " + idEmpleado, e);
        } catch (EntidadNoEncontradaException e) {
            throw new NegocioException("No se encontró el empleado con ID: " + idEmpleado, e);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar estado del empleado: " + e.getMessage(), e);
        }
    }

}
