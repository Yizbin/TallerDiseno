/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package BO.interfaces;


import dto.ClienteDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadInactivaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IClienteBO {

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) throws EntidadDuplicadaNegocioException, NegocioException;

    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) throws EntidadNoEncontradaNegocioException, EntidadInactivaNegocioException, NegocioException;

    public void desactivarCliente(String id) throws EntidadNoEncontradaNegocioException, NegocioException;

    public List<ClienteDTO> buscarTodosLosClientes() throws NegocioException;
    
    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException;
}
