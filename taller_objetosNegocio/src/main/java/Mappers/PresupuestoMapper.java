/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IOrdenMapper;
import Mappers.interfaces.IPresupuestoMapper;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import entidades.Presupuesto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoMapper implements IPresupuestoMapper {
    
    private final IOrdenMapper ordenMapper;
    
    public PresupuestoMapper() {
        this.ordenMapper = new OrdenMapper(new ClienteMapper(), new VehiculoMapper());
    }
    
    @Override
    public PresupuestoDTO toDTO(Presupuesto entidad) {
        if (entidad == null) {
            return null;
        }
        
        PresupuestoDTO dto = new PresupuestoDTO();
        
        if (entidad.getId() != null) {
            dto.setIdPresupuesto(entidad.getId().toString());
        }
        
        dto.setFechaCreacion(entidad.getFechaCreacion());
        dto.setCostoTotal(entidad.getCostoTotal());
        dto.setEstado(entidad.getEstado());
        
        if (entidad.getOrden() != null) {
            OrdenDTO ordenDTO = ordenMapper.toDTO(entidad.getOrden());
            dto.setOrden(ordenDTO);
        }
        
        return dto;
    }
    
    @Override
    public Presupuesto toEntity(PresupuestoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Presupuesto entidad = new Presupuesto();
        
        if (dto.getIdPresupuesto() != null && !dto.getIdPresupuesto().isEmpty()) {
            entidad.setId(Long.valueOf(dto.getIdPresupuesto()));
        }
        
        entidad.setFechaCreacion(dto.getFechaCreacion());
        entidad.setCostoTotal(dto.getCostoTotal());
        entidad.setEstado(dto.getEstado());
        
        if (dto.getOrden() != null) {
            entidad.setOrden(ordenMapper.toEntity(dto.getOrden()));
        }
        
        return entidad;
    }
    
    @Override
    public List<PresupuestoDTO> toListDTO(List<Presupuesto> entidades) {
        if (entidades == null) {
            return null;
        }
        
        List<PresupuestoDTO> dtos = new ArrayList<>();
        for (Presupuesto entidad : entidades) {
            dtos.add(this.toDTO(entidad));
        }
        return dtos;
    }
}
