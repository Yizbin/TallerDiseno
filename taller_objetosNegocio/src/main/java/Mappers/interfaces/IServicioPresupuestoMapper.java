/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.ServicioPresupuestoDTO;
import entidades.Presupuesto;
import entidades.Servicio;
import entidades.ServicioPresupuesto;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IServicioPresupuestoMapper {
    
    public ServicioPresupuestoDTO toDTO(ServicioPresupuesto entidad);
    public ServicioPresupuesto toEntity(ServicioPresupuestoDTO dto, Presupuesto presupuesto, Servicio servicio);
    public List<ServicioPresupuestoDTO> toListDTO(List<ServicioPresupuesto> lista);
}
