/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IVehiculoBO;
import DAO.VehiculoDAO;
import DAO.interfaces.IVehiculoDAO;
import Excepciones.EntidadDuplicadaException;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.VehiculoMapper;
import Mappers.interfaces.IVehiculoMapper;
import dto.VehiculoDTO;
import entidades.Vehiculo;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class VehiculoBO implements IVehiculoBO {

    private static IVehiculoBO instancia;
    private final IVehiculoDAO vehiculoDAO = VehiculoDAO.getInstancia();
    private final IVehiculoMapper mapper;

    private VehiculoBO() {
        this.mapper = new VehiculoMapper();
    }

    public static IVehiculoBO getInstancia() {
        if (instancia == null) {
            instancia = new VehiculoBO();
        }
        return instancia;
    }

    @Override
    public VehiculoDTO crearVehiculo(VehiculoDTO vehiculo) throws EntidadDuplicadaNegocioException, NegocioException {
        try {
            Vehiculo entidad = mapper.toEntity(vehiculo);
            Vehiculo entidadCreada = vehiculoDAO.crearVehiculo(entidad);
            return mapper.toDTO(entidadCreada);
        } catch (EntidadDuplicadaException e) {
            throw new EntidadDuplicadaNegocioException("El vehiculo con esas placas ya existe");
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al crear el vehiculo" + e.getMessage());
        }
    }

    @Override
    public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            Vehiculo entidad = mapper.toEntity(vehiculo);
            Vehiculo entidadCreada = vehiculoDAO.actualizarVehiculo(entidad);
            return mapper.toDTO(entidadCreada);
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException("No se encontro el vehiculo para actualizar");
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el vehiculo" + e.getMessage());
        }
    }

    @Override
    public void eliminarVehiculo(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            vehiculoDAO.eliminarVehiculo(Long.valueOf(id));
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException("No se encontro el vehiculo para eliminar");
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el vehiculo" + e.getMessage());
        }
    }

    @Override
    public List<VehiculoDTO> buscarTodosLosVehiculos() throws NegocioException {
        try {
            List<Vehiculo> listaEntidades = vehiculoDAO.buscarTodosLosVehiculos();
            return mapper.toListDTO(listaEntidades);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el vehiculo" + e.getMessage());
        }
    }

    @Override
    public List<VehiculoDTO> buscarVehiculosPorCliente(String idCliente) throws NegocioException {
        try {
            List<Vehiculo> listaEntidades = vehiculoDAO.buscarVehiculosPorCliente(Long.valueOf(idCliente));
            return mapper.toListDTO(listaEntidades);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el vehiculo" + e.getMessage());
        }
    }

}
