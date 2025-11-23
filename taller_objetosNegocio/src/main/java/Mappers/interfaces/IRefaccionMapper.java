/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.RefaccionDTO;
import entidades.Refaccion;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IRefaccionMapper {

    public Refaccion toEntity(RefaccionDTO dto);

    public RefaccionDTO toDTO(Refaccion entidad);

    public List<RefaccionDTO> toListDTO(List<Refaccion> entidades);
}
