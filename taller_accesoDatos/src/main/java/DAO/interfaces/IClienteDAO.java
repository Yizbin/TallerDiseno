/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadInactivaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.Cliente;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IClienteDAO {

    public Cliente crearCliente(Cliente cliente) throws EntidadDuplicadaException, PersistenciaException;

    public Cliente actualizarCliente(Cliente cliente) throws EntidadNoEncontradaException, EntidadInactivaException, PersistenciaException;

    public void desactivarCliente(Long id) throws EntidadNoEncontradaException, PersistenciaException;

    public List<Cliente> buscarTodosLosClientes() throws PersistenciaException;
    
    public List<Cliente> buscarTodosLosClientesActivos() throws PersistenciaException;

}
