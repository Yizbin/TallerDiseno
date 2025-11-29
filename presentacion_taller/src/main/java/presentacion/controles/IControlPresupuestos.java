/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.PresupuestoDTO;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IControlPresupuestos {

    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuesto);
    
     public PresupuestoDTO crearPresupuestoConCliente(ClienteDTO cliente);
    
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden);
    
    public List<PresupuestoDTO> buscarPresupuestosPendientes();
}
