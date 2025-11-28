/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.EmpleadoDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
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
    public List<EmpleadoDTO> buscarTodosLosMecanicosActivos() {
        try {
            return taller.buscarTodosLosMecanicosActivos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: No se encontraron mecánicos activos. " + ex.getMessage(),
                    "Error de Búsqueda",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public EmpleadoDTO seleccionarMecanico(String idEmpleado) {
        try {
            return taller.seleccionarMecanico(idEmpleado);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error: No se pudo seleccionar el mecánico con ID: " + idEmpleado + ". " + ex.getMessage(),
                    "Error de Selección",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
