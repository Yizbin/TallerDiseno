/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IPagoMapper;
import dto.PagoDTO;
import dto.enums.MetodoPago;
import entidades.Pago;
import entidades.Presupuesto;

/**
 *
 * @author Abraham Coronel
 */
public class PagoMapper implements IPagoMapper {

    @Override
    public Pago toEntity(PagoDTO dto) {
        if (dto == null) {
            return null;
        }

        Pago entidad = new Pago();

        if (dto.getIdPago() != null) {
            entidad.setId(Long.valueOf(dto.getIdPago()));
        }
        entidad.setMonto(dto.getMonto());
        entidad.setFechaPago(dto.getFechaPago());
        if (dto.getMetodoPago() != null) {
            entidad.setMetodoPago(dto.getMetodoPago().name());
        }
        entidad.setReferencia(dto.getReferencia());

        if (dto.getIdPresupuesto() != null) {
            Presupuesto presupuestoRef = new Presupuesto();
            presupuestoRef.setId(Long.valueOf(dto.getIdPresupuesto()));
            entidad.setPresupuesto(presupuestoRef);
        }

        return entidad;
    }

    @Override
    public PagoDTO toDTO(Pago entidad) {
        if (entidad == null) {
            return null;
        }

        PagoDTO dto = new PagoDTO();
        dto.setIdPago(entidad.getId().toString());
        dto.setMonto(entidad.getMonto());
        dto.setFechaPago(entidad.getFechaPago());
        if (entidad.getMetodoPago() != null) {
            try {
                dto.setMetodoPago(MetodoPago.valueOf(entidad.getMetodoPago()));
            } catch (IllegalArgumentException e) {
                System.err.println("Error mapeando metodo de pago: " + entidad.getMetodoPago());
            }
        }
        dto.setReferencia(entidad.getReferencia());

        if (entidad.getPresupuesto() != null) {
            dto.setIdPresupuesto(entidad.getPresupuesto().getId().toString());
        }

        return dto;
    }

}
