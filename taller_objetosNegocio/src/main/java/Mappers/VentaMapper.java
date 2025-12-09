/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IVentaMapper;
import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import entidades.Venta;
import entidades.VentaRefaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class VentaMapper implements IVentaMapper{
   private final VentaRefaccionMapper vrMapper = new VentaRefaccionMapper();
    @Override
    public Venta toEntity(VentaDTO dto, List<VentaRefaccion> detalles) {
          if (dto == null) return null;
        Venta e = new Venta();
        e.setId(Long.valueOf(dto.getId()));
        e.setFecha(dto.getFecha());
        e.setTotal(dto.getTotal());
        e.setRefacciones(detalles);
        return e;
    }

    @Override
    public VentaDTO toDTO(Venta e) {
        if (e == null) return null;
        VentaDTO dto = new VentaDTO();
        dto.setId(String.valueOf(e.getId()));
        dto.setFecha(e.getFecha());
        dto.setTotal(e.getTotal());

        List<VentaRefaccionDTO> lista = new ArrayList<>();
        if (e.getRefacciones() != null) {
            for (VentaRefaccion vr : e.getRefacciones()) {
                lista.add(vrMapper.toDTO(vr));
            }
        }
        dto.setRefacciones(lista);
        return dto;
    }
    
    
}
