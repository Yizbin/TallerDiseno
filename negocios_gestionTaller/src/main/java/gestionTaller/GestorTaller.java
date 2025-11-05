/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gestionTaller;

import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
import gestionOrdenes.IManejoOrdenes;
import gestionOrdenes.ManejoOrdenes;
import gestionarClientes.IManejoClientes;
import gestionarClientes.ManejoClientes;
import gestionarVehiculos.IManejoVehiculos;
import gestionarVehiculos.ManejoVehiculos;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class GestorTaller implements IGestorTaller {
    
    private final IManejoOrdenes manejoOrdenes;
    private final IManejoClientes manejoClientes;
    private final IManejoVehiculos manejoVehiculos;
    
    private static IGestorTaller instancia;

    private GestorTaller(IManejoOrdenes manejoOrdenes, IManejoClientes manejoClientes, IManejoVehiculos manejoVehiculos) {
        this.manejoOrdenes = manejoOrdenes;
        this.manejoClientes = manejoClientes;
        this.manejoVehiculos = manejoVehiculos;
    }
    
    public static IGestorTaller getInstancia() {
        if (instancia == null) {
            IManejoOrdenes ord = ManejoOrdenes.getInstancia();
            IManejoClientes cli = ManejoClientes.getInstancia();
            IManejoVehiculos veh = ManejoVehiculos.getInstancia();
            instancia = new GestorTaller(ord, cli, veh);
        }
        return instancia;
    }

    @Override
    public Boolean crearOrden(OrdenDTO orden) {
        return this.manejoOrdenes.crearOrden(orden);
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        return this.manejoOrdenes.autenticarUsuario(usuario, contrasena);
    }

    @Override
    public List<ClienteDTO> obtenerClienteMock() {
        return this.manejoClientes.obtenerClientes();
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculosMock() {
        return this.manejoVehiculos.obtenerVehiculosMock();
    }

}
