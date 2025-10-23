/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionOrdenes;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ManejoOrdenes implements IManejoOrdenes {

    public List<OrdenDTO> listaOrdenes;

    public ManejoOrdenes() {
        this.listaOrdenes = new ArrayList<>();
    }

    public List<ClienteDTO> crearListaClientesMock() {
        ClienteDTO cliente1 = new ClienteDTO("Jaime", "Valencia", "Escobedo",
                "6443345543", "jaimito@gmail.com", "Calle toron", "Colonia 1", "433");

        ClienteDTO cliente2 = new ClienteDTO("Cesar", "Guerrero", "Garcia",
                "655674366", "cesar@gmail.com", "Calle deadlock", "Colonia 5", "677");

        List<ClienteDTO> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        return listaClientes;
    }

    public List<VehiculoDTO> crearListaVehiculossMock() {
        VehiculoDTO vehiculo1 = new VehiculoDTO("Nissan", "Versa", "2020", "WER-123-ER", "50000", "Naranja");

        VehiculoDTO vehiculo2 = new VehiculoDTO("Toyota", "Tacoma", "2026", "WER-321-ER", "55000", "Negra");

        List<VehiculoDTO> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(vehiculo1);
        listaVehiculos.add(vehiculo2);
        return listaVehiculos;
    }

    public List<OrdenDTO> getOrdenesCreadas() {
        return this.listaOrdenes;
    }

    @Override
    public void crearOrden(OrdenDTO orden) {
        if (orden != null) {
            this.listaOrdenes.add(orden);
            System.out.println("Orden correcta");
        } else {
            System.out.println("Orden nula");

        }
    }

}
