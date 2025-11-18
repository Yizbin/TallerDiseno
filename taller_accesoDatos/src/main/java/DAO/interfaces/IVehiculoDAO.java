/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.interfaces;

import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IVehiculoDAO {

    public Vehiculo crearVehiculo(Vehiculo vehiculo) throws EntidadDuplicadaException, PersistenciaException;

    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws EntidadNoEncontradaException, PersistenciaException;

    public void eliminarVehiculo(Long id) throws EntidadNoEncontradaException, PersistenciaException;

    public List<Vehiculo> buscarTodosLosVehiculos() throws PersistenciaException;

    public List<Vehiculo> buscarVehiculosPorCliente(Long idCliente) throws PersistenciaException;
}
