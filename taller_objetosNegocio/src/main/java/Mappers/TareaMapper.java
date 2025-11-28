/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.ITareaMapper;
import dto.TareaDTO;
import entidades.Tarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class TareaMapper implements ITareaMapper {

    @Override
    public TareaDTO toDTO(Tarea entidad) {
        if (entidad == null) {
            return null;
        }

//        String idOrden = "N/A";            Lo comente por si llega a tronar 
//        String vehiculo = "N/A";
//
//        if (entidad.getPresupuesto() != null
//                && entidad.getPresupuesto().getOrden() != null) {
//            idOrden = String.valueOf(entidad.getPresupuesto().getOrden().getId_orden());
//            if (entidad.getPresupuesto().getOrden().getVehiculo() != null) {
//                vehiculo = entidad.getPresupuesto().getOrden().getVehiculo().getModelo();
//            }
//        }

        String idOrden = "N/A";
        if (entidad.getPresupuesto() != null && entidad.getPresupuesto().getOrden() != null) {
            idOrden = String.valueOf(entidad.getPresupuesto().getOrden().getId_orden());
        }

        String vehiculo = "N/A";
        if (entidad.getPresupuesto() != null && entidad.getPresupuesto().getVehiculo() != null) {
            vehiculo = entidad.getPresupuesto().getVehiculo().getModelo();
        }
        return new TareaDTO(
                entidad.getId() != null ? String.valueOf(entidad.getId()) : null,
                entidad.getDescripcion(),
                entidad.getCosto(),
                entidad.getEstado(),
                idOrden,
                vehiculo
        );
    }

    @Override
    public List<TareaDTO> toListDTO(List<Tarea> entidades) {
        List<TareaDTO> dtos = new ArrayList<>();
        if (entidades != null) {
            for (Tarea t : entidades) {
                dtos.add(toDTO(t));
            }
        }
        return dtos;
    }

}
