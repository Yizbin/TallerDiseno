/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionOrdenes;

import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import Excepciones.OrdenNoEncontradaException;
import dto.OrdenDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IManejoOrdenes {

    public OrdenDTO crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException;
    
    public OrdenDTO actualizarOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException;
    
    public void eliminarOrden(String id) throws OrdenNoEncontradaException, DatosFaltantesEnOrdenException;
    
    public List<OrdenDTO> buscarOrdenPorId(String id) throws NegocioException;
    
    public List<OrdenDTO> buscarTodasLasOrdenes(String id) throws NegocioException;
    
    public List<OrdenDTO> buscarTodasLasOrdenesPendientes(String id) throws NegocioException;
    
    public List<OrdenDTO> buscarOrdenesPorCliente(String idCliente) throws NegocioException;
    
}
