/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Mappers.interfaces;

import dto.OrdenDTO;
import entidades.Orden;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IOrdenMapper {
    public Orden toEntity(OrdenDTO dto);
    
    public OrdenDTO toDTO(Orden entidad);
    
    public List<OrdenDTO> toListDTO(List<Orden> entidades);
}
