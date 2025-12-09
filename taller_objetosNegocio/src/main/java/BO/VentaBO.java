/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IVentaBO;
import DAO.VentaDAO;
import DAO.interfaces.IVentaDAO;
import Excepciones.PersistenciaException;
import Mappers.VentaMapper;
import Mappers.VentaRefaccionMapper;
import dto.RefaccionDTO;
import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import entidades.Refaccion;
import entidades.Venta;
import entidades.VentaRefaccion;
import excepciones.NegocioException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class VentaBO implements IVentaBO{

    @Override
    public VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VentaDTO buscarVentaPorId(Long id) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaDTO> buscarTodasLasVentas() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
