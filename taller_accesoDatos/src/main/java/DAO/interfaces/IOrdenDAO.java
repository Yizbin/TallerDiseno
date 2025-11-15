/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.Orden;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IOrdenDAO {

    public Orden crearOrden(Orden orden) throws PersistenciaException;

    public Orden actualizarOrden(Orden orden) throws EntidadNoEncontradaException, PersistenciaException;

    public void eliminarOrden(Long id) throws EntidadNoEncontradaException, PersistenciaException;

    public List<Orden> buscarTodosLasOrdenes() throws PersistenciaException;

    public List<Orden> buscarTodosLasOrdenesPendientes() throws PersistenciaException;
}
