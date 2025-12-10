/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IVentaRefaccionMapper;
import dto.VentaRefaccionDTO;
import entidades.Refaccion;
import entidades.Venta;
import entidades.VentaRefaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class VentaRefaccionMapper implements IVentaRefaccionMapper{

    @Override
    public VentaRefaccionDTO toDTO(VentaRefaccion entidad) {
        if (entidad == null) {
            return null;
        }

        VentaRefaccionDTO dto = new VentaRefaccionDTO();

        if (entidad.getId() != null) {
            dto.setId(entidad.getId().toString()); 
        }

        dto.setCantidad(entidad.getCantidad());
        dto.setPrecioUnitario(entidad.getPrecioUnitario());

        if (entidad.getRefaccion() != null) {
            if (entidad.getRefaccion().getId() != null) {
                dto.setId_refaccion(entidad.getRefaccion().getId().toString());
            }
            dto.setNombre(entidad.getRefaccion().getNombre());
        }

        return dto;
    }

    @Override
    public VentaRefaccion toEntity(VentaRefaccionDTO dto) {
        if (dto == null) {
            return null;
        }

        VentaRefaccion entidad = new VentaRefaccion();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            try {
                entidad.setId(Long.valueOf(dto.getId()));
            } catch (NumberFormatException e) {
         
                System.out.println("Error convirtiendo ID: " + dto.getId());
            }
        }
        entidad.setCantidad(dto.getCantidad());
        entidad.setPrecioUnitario(dto.getPrecioUnitario());

        return entidad;
    }

    public VentaRefaccion toEntityCompleto(VentaRefaccionDTO dto, Venta venta, Refaccion refaccion) {
        if (dto == null) {
            return null;
        }

        VentaRefaccion entidad = toEntity(dto);

        if (venta != null) {
            entidad.setVenta(venta);
        }

        if (refaccion != null) {
            entidad.setRefaccion(refaccion);
            
            if (entidad.getPrecioUnitario() == null) {
                entidad.setPrecioUnitario(refaccion.getPrecioUnitario());
            }
        }
        return entidad;
    }

    @Override
    public List<VentaRefaccionDTO> toListDTO(List<VentaRefaccion> entidades) {
        if (entidades == null) return null;
        List<VentaRefaccionDTO> dtos = new ArrayList<>();
        for (VentaRefaccion e : entidades) {
            dtos.add(toDTO(e));
        }
        return dtos;
    }

    @Override
    public VentaRefaccion toEntity(VentaRefaccionDTO dto, Refaccion refaccion) {
        return toEntityCompleto(dto, null, refaccion);
    }
}