/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IServicioPresupuestoMapper;
import dto.ServicioPresupuestoDTO;
import entidades.Presupuesto;
import entidades.Servicio;
import entidades.ServicioPresupuesto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class ServicioPresupuestoMapper implements IServicioPresupuestoMapper{
    
    public ServicioPresupuestoDTO toDTO(ServicioPresupuesto entidad) {
        if (entidad == null) {
            return null;
        }

        ServicioPresupuestoDTO dto = new ServicioPresupuestoDTO();

        if (entidad.getId() != null) {
            dto.setId(entidad.getId().toString());
        }

        if (entidad.getServicio() != null) {
            if (entidad.getServicio().getId_servicio() != null) {
                dto.setIdServicio(entidad.getServicio().getId_servicio().toString());
            }
            dto.setNombreServicio(entidad.getServicio().getNombre());
            dto.setDescripcion(entidad.getServicio().getDescripcion());
        }

        dto.setCosto(entidad.getCosto());

        return dto;
    }

    public ServicioPresupuesto toEntity(ServicioPresupuestoDTO dto, Presupuesto presupuesto, Servicio servicio) {
        if (dto == null) {
            return null;
        }

        ServicioPresupuesto entidad = new ServicioPresupuesto();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            entidad.setId(Long.valueOf(dto.getId()));
        }

        entidad.setPresupuesto(presupuesto);
        entidad.setServicio(servicio);

        if (dto.getCosto() != null) {
            entidad.setCosto(dto.getCosto());
        } else if (servicio != null) {
            entidad.setCosto(servicio.getPrecio());
        }

        return entidad;
    }
    
    public List<ServicioPresupuestoDTO> toListDTO(List<ServicioPresupuesto> lista) {
        List<ServicioPresupuestoDTO> dtos = new ArrayList<>();
        if (lista != null) {
            for (ServicioPresupuesto e : lista) {
                dtos.add(toDTO(e));
            }
        }
        return dtos;
    }
}