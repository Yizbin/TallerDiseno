/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarTareas;

import BO.TareaBO;
import BO.interfaces.ITareaBO;
import dto.TareaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoTareas implements IManejoTareas {

    private static IManejoTareas instancia;
    private final ITareaBO tareaBO = TareaBO.getInstancia();

    private ManejoTareas() {
    }

    public static IManejoTareas getInstancia() {
        if (instancia == null) {
            instancia = new ManejoTareas();
        }
        return instancia;
    }

    @Override
    public List<TareaDTO> buscarTareasAsignadas(String idMecanico) throws NegocioException {
        try {
            return tareaBO.obtenerTareasPorMecanico(idMecanico);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de mecanico invalido");
        }
    }

    @Override
    public void marcarTareaComoCompletada(String idTarea) throws NegocioException {
        try {
            tareaBO.completarTarea(idTarea);
        } catch (NumberFormatException e) {
            throw new NegocioException("ID de tarea invalido");
        }
    }

    @Override
    public List<TareaDTO> buscarTareasDisponibles() throws NegocioException {
        try {
            return tareaBO.buscarTareasDisponibles();
        } catch (Exception e) {
            throw new NegocioException("Error al obtener tareas disponibles: " + e.getMessage(), e);
        }
    }

    @Override
    public void asignarTareaAMecanico(String idTarea, String idEmpleado) throws NegocioException {
        if (idTarea == null || idTarea.trim().isEmpty()) {
            throw new NegocioException("El ID de la tarea no puede estar vacío.");
        }

        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            throw new NegocioException("El ID del mecánico no puede estar vacío.");
        }

        try {
      
            tareaBO.asignarTareaAMecanico(idTarea, idEmpleado);

        } catch (Exception e) {
            throw new NegocioException("No se pudo asignar la tarea: " + e.getMessage(), e);
        }
    }

}
