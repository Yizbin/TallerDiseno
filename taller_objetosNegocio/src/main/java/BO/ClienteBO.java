/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IClienteBO;
import DAO.interfaces.IClienteDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadInactivaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.ClienteMapper;
import Mappers.interfaces.IClienteMapper;
import dto.ClienteDTO;
import entidades.Cliente;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadInactivaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ClienteBO implements IClienteBO {

    private final IClienteDAO cliente;
    private final IClienteMapper clienteMapper;

    public ClienteBO(IClienteDAO cliente) {
        this.cliente = cliente;
        this.clienteMapper = new ClienteMapper();
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) throws EntidadDuplicadaNegocioException, NegocioException {
        try {
            Cliente clienteEntidad = this.clienteMapper.toEntity(clienteDTO);

            Cliente clienteNuevo = this.cliente.crearCliente(clienteEntidad);

            return this.clienteMapper.toDTO(clienteNuevo);
        } catch (EntidadDuplicadaException e) {
            throw new EntidadDuplicadaNegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) throws EntidadNoEncontradaNegocioException, EntidadInactivaNegocioException, NegocioException {
        try {
            Cliente clienteEntidad = this.clienteMapper.toEntity(clienteDTO);

            Cliente clienteActualizado = this.cliente.actualizarCliente(clienteEntidad);

            return this.clienteMapper.toDTO(clienteActualizado);
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException(e.getMessage());
        } catch (EntidadInactivaException e) {
            throw new EntidadInactivaNegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public void desactivarCliente(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            Long idLong = Long.valueOf(id);

            this.cliente.desactivarCliente(idLong);
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> buscarTodosLosClientes() throws NegocioException {
        try {
            List<Cliente> listaEntidades = this.cliente.buscarTodosLosClientes();

            return this.clienteMapper.toListDTO(listaEntidades);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

}
