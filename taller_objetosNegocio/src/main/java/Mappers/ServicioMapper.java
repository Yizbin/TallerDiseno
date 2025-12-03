/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IServicioMapper;
import dto.ServicioDTO;
import entidades.Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class ServicioMapper implements IServicioMapper{

    @Override
    public ServicioDTO toDTO(Servicio entidad) {
         if (entidad == null) {
            return null;
        }

        ServicioDTO dto = new ServicioDTO();

        if (entidad.getId_servicio() != null) {
            dto.setId_servicio(entidad.getId_servicio().toString());
        }

        dto.setNombre(entidad.getNombre());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPrecio(entidad.getPrecio());

        return dto;
    }
    
    @Override
    public Servicio toEntity(ServicioDTO dto) {
       if (dto == null) {
            return null;
        }

        Servicio entidad = new Servicio();

        if (dto.getId_servicio() != null && !dto.getId_servicio().isEmpty()) {
            entidad.setId_servicio(Long.valueOf(dto.getId_servicio()));
        }

        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setPrecio(dto.getPrecio());

        return entidad;
    }

    @Override
    public List<ServicioDTO> toListDTO(List<Servicio> entidades) {
         if (entidades == null) {
            return null;
        }

        List<ServicioDTO> dtos = new ArrayList<>();
        for (Servicio entidad : entidades) {
            dtos.add(this.toDTO(entidad));
        }

        return dtos;
    }
    
}
    
    

