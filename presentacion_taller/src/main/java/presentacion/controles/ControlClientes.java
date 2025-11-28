/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlClientes implements IControlClientes {

    private final IGestorTaller taller;

    public ControlClientes(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public List<ClienteDTO> buscarTodosLosClientesActivos() {
        try {
            return taller.buscarTodosLosClientesActivos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se encontro clientes activos" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
