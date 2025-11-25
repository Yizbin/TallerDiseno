/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package BO.interfaces;

import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import dto.PresupuestoDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IPresupuestoBO {
    
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadDuplicadaNegocioException, NegocioException;
    
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadNoEncontradaException, PersistenciaException;
    
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() throws EntidadDuplicadaNegocioException, NegocioException;
    
    public PresupuestoDTO buscarPresupuestoPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException;
    
}
