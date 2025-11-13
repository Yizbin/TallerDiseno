/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarVehiculos;

import dto.VehiculoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoVehiculos implements IManejoVehiculos {

    public ManejoVehiculos() {
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculosMock() {
        List<VehiculoDTO> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(
                new VehiculoDTO("Toyota", "Corolla", "2022", "ABC-123", "15000", "Rojo")
        );

        listaVehiculos.add(
                new VehiculoDTO("Honda", "Civic", "2021", "XYZ-789", "30000", "Azul")
        );

        listaVehiculos.add(
                new VehiculoDTO("Nissan", "Versa", "2023", "NVM-456", "5000", "Blanco")
        );

        listaVehiculos.add(
                new VehiculoDTO("Ford", "Mustang", "2020", "FMC-001", "45000", "Negro")
        );

        listaVehiculos.add(
                new VehiculoDTO("Chevrolet", "Onix", "2022", "CHV-777", "22000", "Gris")
        );

        return listaVehiculos;
    }

}
