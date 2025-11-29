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
    public List<TareaDTO> obtenerTareasParaTabla() throws NegocioException {
        try {
            List<Tarea> tareas = tareaDAO.obtenerTareas();
            return mapper.toListDTO(tareas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener tareas: " + e.getMessage());
        }
    }

    @Override
    public boolean asignarTareaAMecanico(Long idTarea, Long idMecanico) throws NegocioException {
        try {
            if (idTarea == null || idMecanico == null) {
                throw new NegocioException("El ID de la tarea y del mecánico no pueden ser nulos.");
            }

            return tareaDAO.asignarTareaAMecanico(idTarea, idMecanico);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al asignar la tarea al mecánico: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new NegocioException("Error inesperado al asignar tarea: " + e.getMessage(), e);
        }
    }

    @Override
    public List<TareaDTO> obtenerTareasSinAsignar() throws NegocioException {
        try {
            List<Tarea> tareas = tareaDAO.buscarTareasSinAsignar();
            // AÑADE ESTA LÍNEA DE DEBUGGING
            System.out.println("BO → Tareas encontradas por DAO: " + tareas.size());

            return mapper.toListDTO(tareas);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener tareas sin asignar: " + e.getMessage(), e);
        }
    }

}
