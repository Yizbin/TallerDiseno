/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.ServicioDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pride Factor Black
 */
public class ControlServicios implements IControlServicios{
    
    private final IGestorTaller taller;
            
     public ControlServicios(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public ServicioDTO crearServicio(ServicioDTO dto) {
         try {
            return taller.crearServicio(dto);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public ServicioDTO actualizarServicio(ServicioDTO dto) {
       try {
            return taller.actualizarServicio(dto);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public ServicioDTO eliminarServicio(String id) {
         try {
            return taller.eliminarServicio(id);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public ServicioDTO buscarServicioPorId(String id) {
         try {
            return taller.buscarServicioPorId(id);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ServicioDTO> buscarTodosLosServicios() {
         try {
            return taller.buscarTodosLosServicios();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
