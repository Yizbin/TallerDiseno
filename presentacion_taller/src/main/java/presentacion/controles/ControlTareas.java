/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.TareaDTO;
import entidades.Empleado;
import entidades.Tarea;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlTareas implements IControlTareas {

    private final IGestorTaller taller;

    public ControlTareas(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public List<TareaDTO> consultarTareasPendientes(String usuarioLogueado) {
        try {
            return taller.obtenerTareasDeMecanico(usuarioLogueado);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar tareas: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Boolean completarTarea(String idTarea) {
        try {
            taller.completarTareaMecanico(idTarea);
            JOptionPane.showMessageDialog(null, "¡Tarea completada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo completar la tarea: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public List<TareaDTO> buscarTareasDisponibles() {
        try {
            List<TareaDTO> tareasDisponibles = taller.buscarTareasDisponibles();

            if (tareasDisponibles.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "No hay tareas disponibles sin mecánico asignado.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            return tareasDisponibles;

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al buscar tareas disponibles: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return new ArrayList<>();
        }
    }

    @Override
    public Boolean asignarTareaAMecanico(String idTarea, String idEmpleado) {
        try {
            // Validación opcional
            if (idTarea == null || idTarea.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El ID de la tarea no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El ID del mecánico no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Llamada directa con String
            taller.asignarTareaAMecanico(idTarea, idEmpleado);

            JOptionPane.showMessageDialog(null, "¡Tarea asignada correctamente al mecánico!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo asignar la tarea: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
