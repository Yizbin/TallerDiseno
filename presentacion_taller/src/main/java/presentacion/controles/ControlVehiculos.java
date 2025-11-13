/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.VehiculoDTO;
import gestionTaller.IGestorTaller;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ControlVehiculos implements IControlVehiculos {

    private final IGestorTaller taller;

    public ControlVehiculos(IGestorTaller taller) {
        this.taller = taller;
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculosMock() {
        List<VehiculoDTO> listaVehiculos = taller.obtenerVehiculosMock();
        return listaVehiculos;
    }

}
