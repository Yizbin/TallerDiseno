/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionTaller;

import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import dto.ClienteDTO;
import dto.OrdenDTO;
import dto.VehiculoDTO;
import excepciones.NegocioException;
import gestionOrdenes.IManejoOrdenes;
import gestionarClientes.IManejoClientes;
import gestionarVehiculos.IManejoVehiculos;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class GestorTaller implements IGestorTaller {

    private final IManejoOrdenes manejoOrdenes;
    private final IManejoClientes manejoClientes;
    private final IManejoVehiculos manejoVehiculos;

    public GestorTaller(IManejoOrdenes manejoOrdenes, IManejoVehiculos manejoVehiculos, IManejoClientes manejoClientes) {
        this.manejoOrdenes = manejoOrdenes;
        this.manejoVehiculos = manejoVehiculos;
        this.manejoClientes = manejoClientes;
    }

    @Override
    public void crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException {
        this.manejoOrdenes.crearOrden(orden);
    }

    @Override
    public Boolean autenticarUsuario(String usuario, String contrasena) {
        return this.manejoOrdenes.autenticarUsuario(usuario, contrasena);
    }

    @Override
    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException {
        return this.manejoClientes.buscarTodosLosClientesActivos();
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente) {
        return this.manejoVehiculos.obtenerVehiculosPorCliente(idCliente);
    }

}
