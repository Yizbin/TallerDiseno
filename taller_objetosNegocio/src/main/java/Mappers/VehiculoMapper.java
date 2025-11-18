/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IVehiculoMapper;
import dto.VehiculoDTO;
import entidades.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class VehiculoMapper implements IVehiculoMapper {

    @Override
    public Vehiculo toEntity(VehiculoDTO dto) {
        if (dto == null) {
            return null;
        }

        Vehiculo entidad = new Vehiculo();

        entidad.setMarca(dto.getMarca());
        entidad.setModelo(dto.getModelo());
        entidad.setAnio(dto.getAnio());
        entidad.setPlacas(dto.getPlacas());
        entidad.setKm(dto.getKm());
        entidad.setColor(dto.getColor());
        return entidad;
    }

    @Override
    public VehiculoDTO toDTO(Vehiculo entidad) {
        if (entidad == null) {
            return null;
        }

        VehiculoDTO dto = new VehiculoDTO();

        dto.setMarca(entidad.getMarca());
        dto.setModelo(entidad.getModelo());
        dto.setAnio(entidad.getAnio());
        dto.setPlacas(entidad.getPlacas());
        dto.setKm(entidad.getKm());
        dto.setColor(entidad.getColor());
        return dto;
    }

    @Override
    public List<VehiculoDTO> toListDTO(List<Vehiculo> entidades) {
        if (entidades == null) {
            return null;
        }

        List<VehiculoDTO> dtos = new ArrayList<>();
        for (Vehiculo entidad : entidades) {
            dtos.add(this.toDTO(entidad));
        }
        return dtos;
    }

    @Override
    public Vehiculo toEntitySinCliente(VehiculoDTO dto) {
        if (dto == null) {
            return null;
        }
        Vehiculo entidad = new Vehiculo();

        entidad.setMarca(dto.getMarca());
        entidad.setModelo(dto.getModelo());
        entidad.setAnio(dto.getAnio());
        entidad.setPlacas(dto.getPlacas());
        entidad.setKm(dto.getKm());
        entidad.setColor(dto.getColor());

        return entidad;
    }
}
