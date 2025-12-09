/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionVentas;

import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;

import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IManejoVentas {
    
    //Ventas
    public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException;
    
    public VentaDTO buscarVentaPorId(Long id) throws NegocioException;
    
    public List<VentaDTO> buscarTodasLasVentas() throws NegocioException;
    
    //Venta refaccion
    public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) throws EntidadDuplicadaNegocioException, NegocioException;

    public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) throws EntidadNoEncontradaNegocioException, NegocioException;

    public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException;

    public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) throws NegocioException;
}
