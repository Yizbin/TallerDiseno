/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IEmpleadoMapper;
import dto.EmpleadoDTO;
import entidades.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class EmpleadoMapper implements IEmpleadoMapper {

    @Override
    public Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) {
            return null;
        }

        Empleado entidad = new Empleado();

        if (dto.getId_empleado() != null && !dto.getId_empleado().isEmpty()) {
            try {
                entidad.setId_empleado(Long.valueOf(dto.getId_empleado()));
            } catch (NumberFormatException e) {
                System.err.println("El ID del DTO no es un long válido: " + e.getMessage());
                entidad.setId_empleado(null);
            }
        }

        entidad.setNombre(dto.getNombre());
        entidad.setApellidoP(dto.getApellidoP());
        entidad.setApellidoM(dto.getApellidoM());
        entidad.setRol(dto.getRol());
        entidad.setUsuario(dto.getUsuario());
        entidad.setContrasenia(dto.getContrasenia());
        entidad.setActivo(dto.getActivo());

        return entidad;
    }

    @Override
    public EmpleadoDTO toDTO(Empleado entidad) {
        if (entidad == null) {
            return null;
        }

        EmpleadoDTO dto = new EmpleadoDTO();

        if (entidad.getId_empleado() != null) {
            dto.setId_empleado(String.valueOf(entidad.getId_empleado()));
        }

        dto.setNombre(entidad.getNombre());
        dto.setApellidoP(entidad.getApellidoP());
        dto.setApellidoM(entidad.getApellidoM());
        dto.setRol(entidad.getRol());
        dto.setUsuario(entidad.getUsuario());
        dto.setContrasenia(entidad.getContrasenia());
        dto.setActivo(entidad.getActivo());

        return dto;
    }

    @Override
    public List<EmpleadoDTO> toListDTO(List<Empleado> entidades) {
        if (entidades == null) {
            return null;
        }

        List<EmpleadoDTO> dtos = new ArrayList<>();
        for (Empleado entidad : entidades) {
            dtos.add(this.toDTO(entidad));
        }
        return dtos;
    }
}


