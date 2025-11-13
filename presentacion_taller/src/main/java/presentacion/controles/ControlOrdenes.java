/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
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
    public Boolean crearOrden(OrdenDTO orden) {
        Boolean exito = taller.crearOrden(orden);

        if (exito) {
            JOptionPane.showMessageDialog(null, "Orden creada correctamente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo crear la orden", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
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
