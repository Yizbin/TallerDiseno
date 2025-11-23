/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Mappers.interfaces.IRefaccionMapper;
import dto.RefaccionDTO;
import entidades.Refaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class RefaccionMapper implements IRefaccionMapper {

    @Override
    public Refaccion toEntity(RefaccionDTO dto) {
        if (dto == null) {
            return null;
        }

        Refaccion entidad = new Refaccion();
        entidad.setId_refaccion(dto.getId_refaccion());
        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setPrecioUnitario(dto.getPrecioUnitario());
        entidad.setStock(dto.getStock());
        entidad.setEstado(dto.getEstado());
        return entidad;
    }

    @Override
    public RefaccionDTO toDTO(Refaccion entidad) {
        if (entidad == null) {
            return null;
        }

        RefaccionDTO dto = new RefaccionDTO();
        dto.setId_refaccion(entidad.getId_refaccion());
        dto.setNombre(entidad.getNombre());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPrecioUnitario(entidad.getPrecioUnitario());
        dto.setStock(entidad.getStock());
        dto.setEstado(entidad.getEstado());
        return dto;
    }

    @Override
    public List<RefaccionDTO> toListDTO(List<Refaccion> entidades) {
        List<RefaccionDTO> lista = new ArrayList<>();
        if (entidades == null) {
            return lista;
        }

        for (Refaccion r : entidades) {
            lista.add(toDTO(r));
        }

        return lista;
    }

}
