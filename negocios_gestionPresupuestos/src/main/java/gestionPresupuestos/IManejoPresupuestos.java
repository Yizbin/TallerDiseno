/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package gestionPresupuestos;

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
public interface IManejoPresupuestos {
    public List<PresupuestoDTO> obtenerPresupuestosNoPagados() throws NegocioException;
    
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException;
    
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadDuplicadaNegocioException, NegocioException;
    
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadNoEncontradaNegocioException, NegocioException;  
    
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() throws EntidadDuplicadaNegocioException, NegocioException;   
    
    public PresupuestoDTO buscarPresupuestoPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException;
    
    public List<PresupuestoDTO> buscarPresupuestosNoPagados() throws NegocioException;
    
    List<ServicioPresupuestoDTO> buscarPorIdPresupuesto(String idPresupuesto) throws NegocioException;
    
    List<PresupuestoRefaccionDTO> buscarPorIdPresupuestoPR(String idPresupuesto) throws NegocioException;
}
