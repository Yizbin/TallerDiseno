/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
import excepciones.NegocioException;
import gestionTaller.IGestorTaller;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel
 */
public class ControlOrdenes implements IControlOrdenes {

    private final IGestorTaller taller;

    public ControlOrdenes(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public void crearOrden(OrdenDTO orden) {
        try {
            taller.crearOrden(orden);
            JOptionPane.showMessageDialog(null, "Orden creada correctamente!!!", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (DatosFaltantesEnOrdenException ex) {
            JOptionPane.showMessageDialog(null, "Error: falta rellenar datos para crear la orden." + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FechaInvalidaException ex) {
            JOptionPane.showMessageDialog(null, "Error: la fecha es invalida, ingresala de nuevo porfavor" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error: la orden no fue procesada correctamente" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public OrdenDTO crearOrdenConCliente(ClienteDTO cliente) {
        OrdenDTO ordenNueva = new OrdenDTO();
        ordenNueva.setCliente(cliente);
        return ordenNueva;
    }

    @Override
    public OrdenDTO crearOrdenConVehiculo(VehiculoDTO vehiculo) {
        OrdenDTO ordenNueva = new OrdenDTO();
        ordenNueva.setVehiculo(vehiculo);
        return ordenNueva;
    }

}
