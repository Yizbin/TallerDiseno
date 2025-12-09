/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.VentaRefaccionDTO;
import entidades.Refaccion;
import entidades.VentaRefaccion;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaRefaccionMapper {
    public VentaRefaccion toEntity(VentaRefaccionDTO dto, Refaccion refaccion);
    
    public VentaRefaccionDTO toDTO(VentaRefaccion e);
}
