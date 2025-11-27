/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.ITareaBO;
import DAO.TareaDAO;
import DAO.interfaces.ITareaDAO;
import Excepciones.PersistenciaException;
import Mappers.TareaMapper;
import Mappers.interfaces.ITareaMapper;
import dto.TareaDTO;
import entidades.Tarea;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class TareaBO implements ITareaBO {

    private static ITareaBO instancia;
    private final ITareaDAO tareaDAO = TareaDAO.getInstancia();
    private final ITareaMapper mapper;

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
}
