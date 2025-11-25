/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.PresupuestoDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlPresupuestos implements IControlPresupuestos {

    private final IGestorTaller taller;

    public ControlPresupuestos(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuesto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) {
        return null;
    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosPendientes() {
        try {
            return taller.buscarPresupuestosPendientes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

}
