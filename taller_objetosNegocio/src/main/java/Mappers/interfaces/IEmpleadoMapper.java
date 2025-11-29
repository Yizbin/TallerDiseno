/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.EmpleadoDTO;
import entidades.Empleado;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IEmpleadoMapper {

    Empleado toEntity(EmpleadoDTO dto);

    EmpleadoDTO toDTO(Empleado entidad);

    List<EmpleadoDTO> toListDTO(List<Empleado> entidades);
}
