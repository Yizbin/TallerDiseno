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
    public List<TareaDTO> obtenerTareasParaTabla() {
        try {
            return taller.obtenerTareasParaTabla();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    @Override
    public List<TareaDTO> obtenerTareasSinAsignar() {
        try {
            return taller.obtenerTareasSinAsignar();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al obtener tareas sin asignar: ", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    @Override
    public boolean asignarTareaAMecanico(String idTarea, String idMecanico) {
        try {
            return taller.asignarTareaAMecanico(idTarea, idMecanico);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al asignar tarea: ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
