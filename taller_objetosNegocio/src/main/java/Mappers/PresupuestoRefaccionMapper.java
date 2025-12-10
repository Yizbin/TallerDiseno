/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IPresupuestoRefaccionMapper;
import dto.PresupuestoRefaccionDTO;
import entidades.Presupuesto;
import entidades.PresupuestoRefaccion;
import entidades.Refaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class PresupuestoRefaccionMapper implements IPresupuestoRefaccionMapper{
    
    public PresupuestoRefaccionDTO toDTO(PresupuestoRefaccion entidad) {
        if (entidad == null) {
            return null;
        }

        PresupuestoRefaccionDTO dto = new PresupuestoRefaccionDTO();

        if (entidad.getId() != null) {
            dto.setId(entidad.getId().toString());
        }

        dto.setCantidad(entidad.getCantidad());
        dto.setPrecioUnitario(entidad.getPrecioUnitario());

        if (entidad.getRefaccion() != null) {
            if (entidad.getRefaccion().getId() != null) {
                dto.setIdRefaccion(entidad.getRefaccion().getId().toString());
            }
            dto.setNombreRefaccion(entidad.getRefaccion().getNombre());
        }

        dto.setTotal(dto.getCantidad() * dto.getPrecioUnitario());

        return dto;
    }

    public PresupuestoRefaccion toEntity(PresupuestoRefaccionDTO dto, Presupuesto presupuesto, Refaccion refaccion) {
        if (dto == null) {
            return null;
        }

        PresupuestoRefaccion entidad = new PresupuestoRefaccion();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            entidad.setId(Long.valueOf(dto.getId()));
        }
        entidad.setPresupuesto(presupuesto);
        entidad.setRefaccion(refaccion);
        entidad.setCantidad(dto.getCantidad());
        
        if (dto.getPrecioUnitario() != null) {
            entidad.setPrecioUnitario(dto.getPrecioUnitario());
        } else if (refaccion != null) {
            entidad.setPrecioUnitario(refaccion.getPrecioUnitario());
        }

        return entidad;
    }
    
    public List<PresupuestoRefaccionDTO> toListDTO(List<PresupuestoRefaccion> lista) {
        List<PresupuestoRefaccionDTO> dtos = new ArrayList<>();
        if (lista != null) {
            for (PresupuestoRefaccion e : lista) {
                dtos.add(toDTO(e));
            }
        }
        return dtos;
    }
}

