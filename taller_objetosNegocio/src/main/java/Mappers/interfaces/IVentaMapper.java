/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import entidades.Refaccion;
import entidades.Venta;
import entidades.VentaRefaccion;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaMapper {
        public Venta toEntity(VentaDTO dto, List<VentaRefaccion> detalles);
        
        public VentaDTO toDTO(Venta e);
}
