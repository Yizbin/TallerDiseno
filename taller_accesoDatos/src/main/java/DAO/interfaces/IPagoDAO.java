/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.PersistenciaException;
import entidades.Pago;

/**
 *
 * @author Abraham Coronel
 */
public interface IPagoDAO {

    public Pago registrarPago(Pago pago) throws PersistenciaException;
    
    public Pago guardarPago(Pago pago) throws PersistenciaException;
}
