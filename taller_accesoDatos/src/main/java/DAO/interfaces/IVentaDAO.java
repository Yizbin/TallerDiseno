/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.PersistenciaException;
import entidades.Venta;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public interface IVentaDAO {
    
    public Venta crearVenta(Venta venta) throws PersistenciaException;
    
    public Venta buscarVentaPorId(Long id) throws PersistenciaException;
    
    public List<Venta> buscarTodasLasVentas() throws PersistenciaException;
    
}
