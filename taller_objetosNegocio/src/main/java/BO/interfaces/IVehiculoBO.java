/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package BO.interfaces;

import dto.VehiculoDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public interface IVehiculoBO {

    public VehiculoDTO crearVehiculo(VehiculoDTO vehiculo) throws EntidadDuplicadaNegocioException, NegocioException;

    public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo) throws EntidadNoEncontradaNegocioException, NegocioException;

    public void eliminarVehiculo(String id) throws EntidadNoEncontradaNegocioException, NegocioException;

    public List<VehiculoDTO> buscarTodosLosVehiculos() throws NegocioException;

    public List<VehiculoDTO> buscarVehiculosPorCliente(String idCliente) throws NegocioException;
}
