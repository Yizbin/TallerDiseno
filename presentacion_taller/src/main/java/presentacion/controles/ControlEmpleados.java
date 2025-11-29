/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.EmpleadoDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Servin
 */
public class ControlEmpleados implements IControlEmpleados {

    private final IGestorTaller taller;

    public ControlEmpleados(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public Boolean autenticarEmpleado(String usuario, String contrasena) {
        try {
            return taller.autenticarEmpleado(usuario, contrasena);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: no se pudo autenticar al empleado. " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario) {
        try {
            return taller.obtenerEmpleadoPorUsuario(usuario);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: no se pudo obtener el empleado con usuario " + usuario + ". " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo) {
        try {
            return taller.actualizarEstadoEmpleado(idEmpleado, activo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: no se pudo actualizar el estado del empleado con ID " + idEmpleado + ". " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public EmpleadoDTO buscarPorId(String idEmpleado) {
        try {
            return taller.buscarPorId(idEmpleado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: no se pudo encontrar el empleado con ID " + idEmpleado + ". " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public List<EmpleadoDTO> obtenerMecanicosParaTabla() {
        try {
            return taller.obtenerMecanicosParaTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: no se pudieron obtener los mecánicos. " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    @Override
    public boolean asignarTareaAMecanico(String idTarea, String idMecanico) {
        try {
            return taller.asignarTareaAMecanico(idTarea, idMecanico);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al asignar tarea al mecánico: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
