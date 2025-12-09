/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.VentaRefaccion;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaRefaccionDAO {
    
    public VentaRefaccion crearVentaRefaccion(VentaRefaccion ventaRefaccion)throws EntidadDuplicadaException, PersistenciaException;

    public VentaRefaccion actualizarVentaRefaccion(VentaRefaccion ventaRefaccion) throws EntidadNoEncontradaException, PersistenciaException;

    public VentaRefaccion buscarVentaRefaccionPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException;

    public List<VentaRefaccion> buscarTodasLasVentaRefacciones() throws PersistenciaException;

    public List<VentaRefaccion> buscarPorIdVenta(Long idVenta)throws PersistenciaException;
}
