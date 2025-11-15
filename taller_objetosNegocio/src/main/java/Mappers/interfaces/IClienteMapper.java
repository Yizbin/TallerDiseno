/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Mappers.interfaces;

import dto.ClienteDTO;
import entidades.Cliente;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IClienteMapper {

    public Cliente toEntity(ClienteDTO dto);
    
    public ClienteDTO toDTO(Cliente entidad);
    
    public List<ClienteDTO> toListDTO(List<Cliente> entidades);
}
