/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionarClientes;

import dto.ClienteDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author payde
 */
public interface IManejoClientes {

    public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException;
}
