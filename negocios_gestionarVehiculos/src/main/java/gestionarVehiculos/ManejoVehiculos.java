/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarVehiculos;

import BO.VehiculoBO;
import BO.interfaces.IVehiculoBO;
import dto.VehiculoDTO;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoVehiculos implements IManejoVehiculos {

    private static IManejoVehiculos instancia;
    private final IVehiculoBO vehiculoBO = VehiculoBO.getInstancia();

    private ManejoVehiculos() {
    }

    public static IManejoVehiculos getInstancia() {
        if (instancia == null) {
            instancia = new ManejoVehiculos();
        }
        return instancia;
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente) {
        try {
            return vehiculoBO.buscarVehiculosPorCliente(idCliente);
        } catch (NegocioException ex) {
            System.err.println("Error: No se pudo encontrar los vehiculos del cliente");
            return new ArrayList<>();
        }
    }

}
