/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.ServicioDTO;
import entidades.Servicio;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IServicioMapper {
    
    public ServicioDTO toDTO(Servicio entidad);

    public Servicio toEntity(ServicioDTO dto);

    public List<ServicioDTO> toListDTO(List<Servicio> entidades);
}
