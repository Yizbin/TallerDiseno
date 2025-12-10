/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Mappers.interfaces;

import dto.PresupuestoRefaccionDTO;
import entidades.Presupuesto;
import entidades.PresupuestoRefaccion;
import entidades.Refaccion;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IPresupuestoRefaccionMapper {
    public PresupuestoRefaccionDTO toDTO(PresupuestoRefaccion entidad);
    public PresupuestoRefaccion toEntity(PresupuestoRefaccionDTO dto, Presupuesto presupuesto, Refaccion refaccion);
    public List<PresupuestoRefaccionDTO> toListDTO(List<PresupuestoRefaccion> lista);
}
