/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.ITareaBO;
import DAO.EmpleadoDAO;
import DAO.TareaDAO;
import DAO.interfaces.IEmpleadoDAO;
import DAO.interfaces.ITareaDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.TareaMapper;
import Mappers.interfaces.ITareaMapper;
import dto.TareaDTO;
import entidades.Empleado;
import entidades.Tarea;
import excepciones.NegocioException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Abraham Coronel
 */
public class TareaBO implements ITareaBO {

    private static ITareaBO instancia;
    private final ITareaDAO tareaDAO = TareaDAO.getInstancia();
    private final ITareaMapper mapper;
    private final IEmpleadoDAO empleadoDAO = EmpleadoDAO.getInstancia();

    private TareaBO() {
        this.mapper = new TareaMapper();
    }

    public static ITareaBO getInstancia() {
        if (instancia == null) {
            instancia = new TareaBO();
        }
        return instancia;
    }

    @Override
    public List<TareaDTO> obtenerTareasPorMecanico(String idMecanico) throws NegocioException {
        try {
            Long id = Long.valueOf(idMecanico);
            List<Tarea> tareas = tareaDAO.buscarTareasPorEmpleado(id);
            return mapper.toListDTO(tareas);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de mecánico inválido.");
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public void completarTarea(String idTarea) throws NegocioException {
        try {
            Long id = Long.valueOf(idTarea);
            Tarea tarea = tareaDAO.buscarTareaPorId(id);

            if (tarea == null) {
                throw new NegocioException("No se encontro la tarea con ID: " + idTarea);
            }

            tarea.setEstado("Completada");
            tareaDAO.actualizarTarea(tarea);

        } catch (NumberFormatException e) {
            throw new NegocioException("ID de tarea invalido.");
        } catch (Exception e) {
            throw new NegocioException("Error al completar la tarea: " + e.getMessage());
        }
    }

    @Override
    public List<TareaDTO> buscarTareasDisponibles() throws NegocioException {
        try {
            List<Tarea> tareas = tareaDAO.buscarTareasDisponibles();

            return tareas.stream().map(t -> {
                String vehiculoModelo = null;

                if (t.getPresupuesto() != null && t.getPresupuesto().getVehiculo() != null) {
                    vehiculoModelo = t.getPresupuesto().getVehiculo().getModelo();
                }

                return new TareaDTO(
                        t.getId().toString(),
                        t.getDescripcion(),
                        t.getCosto(),
                        t.getEstado(),
                        t.getPresupuesto() != null ? t.getPresupuesto().getId().toString() : null,
                        vehiculoModelo
                );
            }).collect(Collectors.toList());

        } catch (PersistenciaException | EntidadNoEncontradaException e) {
            throw new NegocioException("Error al consultar tareas: " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean asignarTareaAMecanico(String idTarea, String idEmpleado) throws NegocioException {
        if (idTarea == null || idTarea.trim().isEmpty()) {
            throw new NegocioException("El ID de la tarea no puede estar vacío.");
        }

        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            throw new NegocioException("El ID del mecánico no puede estar vacío.");
        }

        try {
            Long tareaId = Long.valueOf(idTarea);
            Long empleadoId = Long.valueOf(idEmpleado);

            tareaDAO.asignarTareaAMecanico(tareaId, empleadoId);
            return true;

        } catch (NumberFormatException e) {
            throw new NegocioException("Los IDs deben ser números válidos.", e);
        } catch (EntidadNoEncontradaException | PersistenciaException e) {
            throw new NegocioException("No se pudo asignar la tarea: " + e.getMessage(), e);
        }
    }

}
