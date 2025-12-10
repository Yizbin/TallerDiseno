/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IOrdenMapper;
import Mappers.interfaces.IPresupuestoMapper;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.ServicioPresupuestoDTO;
import entidades.Presupuesto;
import entidades.PresupuestoRefaccion;
import entidades.Refaccion;
import entidades.Servicio;
import entidades.ServicioPresupuesto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoMapper implements IPresupuestoMapper {
    
    private final IOrdenMapper ordenMapper;
    private final PresupuestoRefaccionMapper refaccionMapper;
    private final ServicioPresupuestoMapper servicioMapper;
    
    public PresupuestoMapper() {
        this.ordenMapper = new OrdenMapper(new ClienteMapper(), new VehiculoMapper());       
        this.refaccionMapper = new PresupuestoRefaccionMapper();
        this.servicioMapper = new ServicioPresupuestoMapper();
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
        dto.setRefacciones(refaccionMapper.toListDTO(entidad.getRefacciones()));
        dto.setServicios(servicioMapper.toListDTO(entidad.getServicios()));
        

        dto.calcularTotal();
        
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
            if (dto.getOrden().getVehiculo() != null) {
                String idVehiculoStr = dto.getOrden().getVehiculo().getIdVehiculo();
                
                if (idVehiculoStr != null && !idVehiculoStr.isEmpty()) {
                    entidades.Vehiculo v = new entidades.Vehiculo();
                    
                    try {
                        v.setId_vehiculo(Long.valueOf(idVehiculoStr)); 
                        entidad.setVehiculo(v);
                        
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir ID de vehículo: " + idVehiculoStr);
                    }
                }
            }
        }
        List<entidades.PresupuestoRefaccion> listaRefacciones = new java.util.ArrayList<>();
        if (dto.getRefacciones() != null) {
            for (dto.PresupuestoRefaccionDTO itemDTO : dto.getRefacciones()) {
                entidades.Refaccion ref = new entidades.Refaccion();
                if (itemDTO.getIdRefaccion() != null) {
                    ref.setId(Long.valueOf(itemDTO.getIdRefaccion()));
                    entidades.PresupuestoRefaccion detalle = refaccionMapper.toEntity(itemDTO, entidad, ref);
                    listaRefacciones.add(detalle);
                }
            }
        }
        entidad.setRefacciones(listaRefacciones);

        List<entidades.ServicioPresupuesto> listaServicios = new java.util.ArrayList<>();
        if (dto.getServicios() != null) {
            for (dto.ServicioPresupuestoDTO itemDTO : dto.getServicios()) {
                entidades.Servicio serv = new entidades.Servicio();
                if (itemDTO.getIdServicio() != null) {
                    serv.setId_servicio(Long.valueOf(itemDTO.getIdServicio()));
                    entidades.ServicioPresupuesto detalle = servicioMapper.toEntity(itemDTO, entidad, serv);
                    listaServicios.add(detalle);
                }
            }
        }
        entidad.setServicios(listaServicios);

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
