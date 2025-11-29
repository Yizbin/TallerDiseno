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

        // 1. Obtener ID de Orden y Modelo de Vehículo (Manejo de Nulos)
        // Obtenemos el ID de la Orden. Si alguna parte de la cadena es nula, usamos "N/A".
        String idOrden = (entidad.getPresupuesto() != null
                && entidad.getPresupuesto().getOrden() != null)
                ? String.valueOf(entidad.getPresupuesto().getOrden().getId_orden())
                : "N/A";

        // Obtenemos el Modelo del Vehículo. Si alguna parte de la cadena es nula, usamos "N/A".
        String vehiculoModelo = (entidad.getPresupuesto() != null
                && entidad.getPresupuesto().getOrden() != null
                && entidad.getPresupuesto().getOrden().getVehiculo() != null)
                ? entidad.getPresupuesto().getOrden().getVehiculo().getModelo()
                : "N/A";

        // 2. Mapeo de campos directos
        String idTareaStr = entidad.getId() != null ? String.valueOf(entidad.getId()) : null;

        // Asegurarse que el costo no sea nulo antes de la conversión a String
        String costoStr = entidad.getCosto() != null ? entidad.getCosto() : "0";

        // 3. Construcción del DTO
        return new TareaDTO(
                idTareaStr,
                entidad.getDescripcion(),
                costoStr,
                entidad.getEstado(),
                idOrden,
                vehiculoModelo
        );
    }

    @Override
    public List<TareaDTO> toListDTO(List<Tarea> entidades) {
        List<TareaDTO> dtos = new ArrayList<>();
        if (entidades != null) {
            for (Tarea t : entidades) {
                // Si aquí ocurre una excepción, la lista se detiene. 
                // Asegúrate de revisar la consola para LazyInitializationException.
                dtos.add(toDTO(t));
            }
        }
        return dtos;
    }
//    @Override
//    public TareaDTO toDTO(Tarea entidad) {
//        if (entidad == null) {
//            return null;
//        }
//

////        String idOrden = "N/A";            Lo comente por si llega a tronar 
////        String vehiculo = "N/A";
////
////        if (entidad.getPresupuesto() != null
////                && entidad.getPresupuesto().getOrden() != null) {
////            idOrden = String.valueOf(entidad.getPresupuesto().getOrden().getId_orden());
////            if (entidad.getPresupuesto().getOrden().getVehiculo() != null) {
////                vehiculo = entidad.getPresupuesto().getOrden().getVehiculo().getModelo();
////            }
////        }
//        String idOrden = "N/A";
//        if (entidad.getPresupuesto() != null
//                && entidad.getPresupuesto().getOrden() != null) {
//            idOrden = String.valueOf(entidad.getPresupuesto().getOrden().getId_orden());
//        }
//
//        String vehiculo = "N/A";
//        if (entidad.getPresupuesto() != null
//                && entidad.getPresupuesto().getOrden() != null
//                && entidad.getPresupuesto().getOrden().getVehiculo() != null) {
//            vehiculo = entidad.getPresupuesto().getOrden().getVehiculo().getModelo();
//        }
//
//        String costoStr = entidad.getCosto() != null ? String.valueOf(entidad.getCosto()) : "0";
//
//        // Construcción del DTO
//        return new TareaDTO(
//                entidad.getId() != null ? String.valueOf(entidad.getId()) : null,
//                entidad.getDescripcion(),
//                costoStr,
//                entidad.getEstado(),
//                idOrden,
//                vehiculo
//        );
//    }
//
//    @Override
//    public List<TareaDTO> toListDTO(List<Tarea> entidades) {
//        List<TareaDTO> dtos = new ArrayList<>();
//        if (entidades != null) {
//            for (Tarea t : entidades) {
//                dtos.add(toDTO(t));
//            }
//        }
//        return dtos;
//    }
}
