/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BO.interfaces;

import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaBO {
    VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException;
    VentaDTO buscarVentaPorId(Long id) throws NegocioException;
    List<VentaDTO> buscarTodasLasVentas() throws NegocioException;
}
