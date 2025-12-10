/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presentacion.controles;

import dto.ClienteDTO;
import dto.PresupuestoDTO;
import dto.PresupuestoRefaccionDTO;
import dto.ServicioPresupuestoDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
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
     
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO);  
        
    public List<PresupuestoDTO> buscarTodosLosPresupuestos();   
        
    public PresupuestoDTO buscarPresupuestoPorId(String id);
        
    public List<PresupuestoDTO> buscarPresupuestosNoPagados();
    
    List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException;
        
    List<PresupuestoRefaccionDTO> buscarPorIdPresupuestoPR(String idPresupuesto) throws NegocioException;
}
