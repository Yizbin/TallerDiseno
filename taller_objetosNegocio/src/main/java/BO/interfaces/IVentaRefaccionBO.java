/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.VentaRefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaRefaccionBO {
    
    public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) throws EntidadDuplicadaNegocioException, NegocioException;

    public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) throws EntidadNoEncontradaNegocioException, NegocioException;

    public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException;

    public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) throws NegocioException;
}
