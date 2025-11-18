/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Mappers.interfaces;

import dto.VehiculoDTO;
import entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IVehiculoMapper {

    public Vehiculo toEntity(VehiculoDTO dto);
    
    public VehiculoDTO toDTO(Vehiculo entidad);
    
    public List<VehiculoDTO> toListDTO(List<Vehiculo> entidades);
    
    public Vehiculo toEntitySinCliente(VehiculoDTO dto);
}
