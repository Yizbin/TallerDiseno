/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Mappers.interfaces;

import dto.PagoDTO;
import entidades.Pago;

/**
 *
 * @author Abraham Coronel
 */
public interface IPagoMapper {
    public Pago toEntity(PagoDTO dto);
    
    public PagoDTO toDTO(Pago entidad);
}
