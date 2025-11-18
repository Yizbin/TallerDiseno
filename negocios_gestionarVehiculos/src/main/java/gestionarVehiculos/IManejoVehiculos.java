/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package gestionarVehiculos;

import dto.VehiculoDTO;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoVehiculos {

    List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente);
}
