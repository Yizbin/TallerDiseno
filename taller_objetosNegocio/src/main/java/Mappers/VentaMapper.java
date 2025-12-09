/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IVentaMapper;
import dto.VentaDTO;
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
public class VentaMapper implements IVentaMapper{
   private final VentaRefaccionMapper vrMapper = new VentaRefaccionMapper();
   
   @Override
    public Venta toEntity(VentaDTO dto) {
        if (dto == null) return null;

        Venta venta = new Venta();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            venta.setId(Long.valueOf(dto.getId()));
        }

        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());

        List<VentaRefaccion> detalles = new ArrayList<>();

        if (dto.getRefacciones() != null) {
            for (VentaRefaccionDTO d : dto.getRefacciones()) {
                VentaRefaccion vr = new VentaRefaccion();

                if (d.getId() != null && !d.getId().isEmpty()) {
                    vr.setId(Long.valueOf(d.getId()));
                }
                Refaccion ref = new Refaccion();
                ref.setId(Long.valueOf(d.getId_refaccion()));

                vr.setRefaccion(ref);
                vr.setCantidad(d.getCantidad());
                vr.setPrecioUnitario(d.getPrecioUnitario());

                vr.setVenta(venta);

                detalles.add(vr);
            }
        }

        venta.setRefacciones(detalles);

        return venta;
    }

    @Override
    public VentaDTO toDTO(Venta entidad) {
        if (entidad == null) return null;

        VentaDTO dto = new VentaDTO();
        dto.setId(entidad.getId() != null ? entidad.getId().toString() : null);
        dto.setFecha(entidad.getFecha());
        dto.setTotal(entidad.getTotal());

        List<VentaRefaccionDTO> detalles = new ArrayList<>();

        if (entidad.getRefacciones() != null) {
            for (VentaRefaccion vr : entidad.getRefacciones()) {

                VentaRefaccionDTO d = new VentaRefaccionDTO();
                d.setId(vr.getId() != null ? vr.getId().toString() : null);

                d.setId_refaccion(
                    vr.getRefaccion() != null && vr.getRefaccion().getId() != null 
                        ? vr.getRefaccion().getId().toString()
                        : null
                );

                d.setNombre(
                    vr.getRefaccion() != null ? vr.getRefaccion().getNombre() : null
                );

                d.setCantidad(vr.getCantidad());
                d.setPrecioUnitario(vr.getPrecioUnitario());

                detalles.add(d);
            }
        }

        dto.setRefacciones(detalles);

        return dto;
    }
    
    
}
