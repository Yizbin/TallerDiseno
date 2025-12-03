/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package BO.interfaces;

import dto.OrdenDTO;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IOrdenBO {
    public OrdenDTO crearOrden(OrdenDTO ordenDTO) throws NegocioException;
    
    public OrdenDTO actualizarOrden(OrdenDTO ordenDTO) throws EntidadNoEncontradaNegocioException, NegocioException;
    
    public void eliminarOrden(String id) throws EntidadNoEncontradaNegocioException, NegocioException;
    
    public OrdenDTO buscarOrdenPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException;
    
    public List<OrdenDTO> buscarTodasLasOrdenes() throws NegocioException;
    
    public List<OrdenDTO> buscarTodasLasOrdenesPendientes() throws NegocioException;
    
    public List<OrdenDTO> buscarOrdenesPorCliente(String idCliente) throws NegocioException;
}
