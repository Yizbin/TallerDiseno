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
    private IEmpleadoMapper mapper;

    private EmpleadoBO() {
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
    public List<EmpleadoDTO> buscarTodosLosMecanicosActivos() throws NegocioException {
        try {
            List<Empleado> mecanicos = empleadoDAO.buscarMecanicosActivos();
            return mecanicos.stream().map(e -> new EmpleadoDTO(
                    e.getId().toString(),
                    e.getNombre(),
                    e.getApellidoP(),
                    e.getApellidoM(),
                    e.getRol(),
                    e.getUsuario(),
                    null,
                    e.getActivo()
            )).collect(Collectors.toList());
        } catch (EntidadNoEncontradaException e) {
            throw new NegocioException("No se encontró ningún mecánico activo en el sistema.", e);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar mecánicos: " + e.getMessage(), e);
        }
    }

    @Override
    public EmpleadoDTO seleccionarMecanico(String idEmpleado) throws NegocioException {
        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            throw new NegocioException("El ID del mecánico no puede estar vacío.");
        }
        try {
            Long id = Long.valueOf(idEmpleado); 
            
            Empleado e = empleadoDAO.buscarPorId(id);

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
        } catch (NumberFormatException e) {
            throw new NegocioException("El ID proporcionado no es un formato numérico válido.", e);
        } catch (EntidadNoEncontradaException | PersistenciaException ex) {
            throw new NegocioException("Error al buscar el mecánico con ID " + idEmpleado + ": " + ex.getMessage(), ex);
        }
    }
}

