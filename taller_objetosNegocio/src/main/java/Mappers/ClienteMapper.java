/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IClienteMapper;
import dto.ClienteDTO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class ClienteMapper implements IClienteMapper {

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente entidad = new Cliente();

        if (dto.getId_cliente() != null && !dto.getId_cliente().isEmpty()) {
            try {
                entidad.setId(Long.valueOf(dto.getId_cliente()));
            } catch (NumberFormatException e) {
                System.err.println("El ID del DTO no es un long valido: " + e.getMessage());
                entidad.setId(null);
            }
        }

        entidad.setNombre(dto.getNombre());
        entidad.setApellidoP(dto.getApellidoP());
        entidad.setApellidoM(dto.getApellidoM());
        entidad.setTelefono(dto.getTelefono());
        entidad.setCorreo(dto.getCorreo());
        entidad.setCalle(dto.getCalle());
        entidad.setColonia(dto.getColonia());
        entidad.setNumExt(dto.getNumExt());
        return entidad;
    }

    @Override
    public ClienteDTO toDTO(Cliente entidad) {
        if (entidad == null) {
            return null;
        }

        ClienteDTO dto = new ClienteDTO();

        if (entidad.getId_cliente() != null) {
            dto.setId_cliente(String.valueOf(entidad.getId()));
        }

        dto.setNombre(entidad.getNombre());
        dto.setApellidoP(entidad.getApellidoP());
        dto.setApellidoM(entidad.getApellidoM());
        dto.setTelefono(entidad.getTelefono());
        dto.setCorreo(entidad.getCorreo());
        dto.setCalle(entidad.getCalle());
        dto.setColonia(entidad.getColonia());
        dto.setNumExt(entidad.getNumExt());
        return dto;
    }

    @Override
    public List<ClienteDTO> toListDTO(List<Cliente> entidades) {
        if (entidades == null) {
            return null;
        }

        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente entidad : entidades) {
            dtos.add(this.toDTO(entidad));
        }
        return dtos;
    }

}
