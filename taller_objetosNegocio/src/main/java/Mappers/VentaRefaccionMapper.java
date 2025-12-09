/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IVentaRefaccionMapper;
import dto.VentaRefaccionDTO;
import entidades.Refaccion;
import entidades.VentaRefaccion;

/**
 *
 * @author Pride Factor Black
 */
public class VentaRefaccionMapper implements IVentaRefaccionMapper{

    @Override
    public VentaRefaccion toEntity(VentaRefaccionDTO dto, Refaccion refaccion) {
        if (dto == null) return null;
            VentaRefaccion e = new VentaRefaccion();
            e.setId(Long.valueOf(dto.getId_refaccion()));
            e.setRefaccion(refaccion);
            e.setCantidad(dto.getCantidad());
            e.setPrecioUnitario(dto.getPrecioUnitario());
            return e;
    }
    
    @Override
    public VentaRefaccionDTO toDTO(VentaRefaccion e) {
        if (e == null) {
          return null;
        }
        VentaRefaccionDTO dto = new VentaRefaccionDTO();
        dto.setId(String.valueOf(e.getId()));
        
        if (e.getRefaccion() != null) {
           
            dto.setId_refaccion(String.valueOf(e.getRefaccion().getId_refaccion()));
            dto.setNombre(e.getRefaccion().getNombre());           
        }
        dto.setPrecioUnitario(e.getPrecioUnitario());
        dto.setCantidad(e.getCantidad());
        return dto;
    }
    
}
