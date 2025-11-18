/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlVehiculos {

    public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente);
}
