/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarClientes;

import BO.ClienteBO;
import BO.interfaces.IClienteBO;
import dto.ClienteDTO;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author payde
 */
public class ManejoClientes implements IManejoClientes {

    private static IManejoClientes instancia;
    private final IClienteBO clienteBO = ClienteBO.getInstancia();

    private ManejoClientes() {
    }

    public static IManejoClientes getInstancia() {
        if (instancia == null) {
            instancia = new ManejoClientes();
        }
        return instancia;
    }

    @Override
    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException {
        try {
            return clienteBO.buscarTodosLosClientesActivos();
        } catch (NegocioException ex) {
            System.err.println("Error: No se pudo encontrar los vehiculos del cliente");
            return new ArrayList<>();
        }
    }

}
