/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.TareaDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.ArrayList;
import java.util.List;
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

}
