/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.Refaccion;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IRefaccionDAO {

    public Refaccion crearRefaccion(Refaccion refaccion) throws EntidadDuplicadaException, PersistenciaException;

    public Refaccion actualizarRefaccion(Refaccion refaccion) throws EntidadNoEncontradaException, PersistenciaException;

    public List<Refaccion> buscarTodasLasRefacciones() throws EntidadDuplicadaException, PersistenciaException;

    public Refaccion buscarRefaccionPorId(Long id) throws EntidadNoEncontradaException, PersistenciaException;
    
}
