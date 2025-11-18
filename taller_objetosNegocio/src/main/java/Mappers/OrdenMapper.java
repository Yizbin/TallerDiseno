/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IClienteMapper;
import Mappers.interfaces.IOrdenMapper;
import Mappers.interfaces.IVehiculoMapper;
import dto.OrdenDTO;
import entidades.Cliente;
import entidades.Orden;
import entidades.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class OrdenMapper implements IOrdenMapper {

    private final IClienteMapper clienteMapper;
    private final IVehiculoMapper vehiculoMapper;

    public OrdenMapper(IClienteMapper clienteMapper, IVehiculoMapper vehiculoMapper) {
        this.clienteMapper = clienteMapper;
        this.vehiculoMapper = vehiculoMapper;
    }

    @Override
    public Orden toEntity(OrdenDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente clienteEntidad = clienteMapper.toEntity(dto.getCliente());

        Vehiculo vehiculoEntidad = vehiculoMapper.toEntitySinCliente(dto.getVehiculo());

        vehiculoEntidad.setCliente(clienteEntidad);

        Orden entidad = new Orden();

        if (dto.getIdOrden() != null && !dto.getIdOrden().isEmpty()) {
            try {
                entidad.setId_orden(Long.valueOf(dto.getIdOrden()));
            } catch (NumberFormatException e) {
                System.err.println("El id de la orden en el DTO no es un long valido" + e.getMessage());
                entidad.setId_orden(null);
            }
        }
        entidad.setFechaIngreso(dto.getFechaIngreso());
        entidad.setFallaReportada(dto.getFallaReportada());
        entidad.setServicioSolicitado(dto.getServicioSolicitado());
        entidad.setCliente(clienteEntidad);
        entidad.setVehiculo(vehiculoEntidad);
        return entidad;

    }

    @Override
    public OrdenDTO toDTO(Orden entidad) {
        if (entidad == null) {
            return null;
        }

        OrdenDTO dto = new OrdenDTO();

        if (entidad.getId_orden() != null) {
            dto.setIdOrden(String.valueOf(entidad.getId_orden()));
        }

        dto.setFechaIngreso(entidad.getFechaIngreso());
        dto.setFallaReportada(entidad.getFallaReportada());
        dto.setServicioSolicitado(entidad.getServicioSolicitado());
        dto.setEstado(entidad.getEstado());

        dto.setCliente(clienteMapper.toDTO(entidad.getCliente()));
        dto.setVehiculo(vehiculoMapper.toDTO(entidad.getVehiculo()));

        return dto;
    }

    @Override
    public List<OrdenDTO> toListDTO(List<Orden> entidades) {
        if (entidades == null) {
            return null;
        }

        List<OrdenDTO> dtos = new ArrayList<>();
        for (Orden entidad : entidades) {
            dtos.add(this.toDTO(entidad));
        }
        return dtos;
    }

}
