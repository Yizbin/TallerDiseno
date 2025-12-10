/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.VentaRefaccionDTO;
import entidades.Refaccion;
import entidades.VentaRefaccion;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaRefaccionMapper {
    public VentaRefaccion toEntity(VentaRefaccionDTO dto);
    
    public VentaRefaccionDTO toDTO(VentaRefaccion e);
    
     public List<VentaRefaccionDTO> toListDTO(List<VentaRefaccion> entidades);
     
     public VentaRefaccion toEntity(VentaRefaccionDTO dto, Refaccion refaccion);
}
