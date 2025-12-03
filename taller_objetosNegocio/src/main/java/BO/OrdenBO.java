    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IOrdenBO;
import DAO.OrdenDAO;
import DAO.interfaces.IOrdenDAO;
import Excepciones.EntidadNoEncontradaException;
import Excepciones.PersistenciaException;
import Mappers.ClienteMapper;
import Mappers.OrdenMapper;
import Mappers.VehiculoMapper;
import Mappers.interfaces.IClienteMapper;
import Mappers.interfaces.IOrdenMapper;
import Mappers.interfaces.IVehiculoMapper;
import dto.OrdenDTO;
import entidades.Orden;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class OrdenBO implements IOrdenBO {

    private static IOrdenBO instancia;
    private final IOrdenDAO ordenDAO = OrdenDAO.getInstancia();
    private final IOrdenMapper ordenMapper;

    private OrdenBO() {
        IClienteMapper clienteMapper = new ClienteMapper();
        IVehiculoMapper vehiculoMapper = new VehiculoMapper();
        this.ordenMapper = new OrdenMapper(clienteMapper, vehiculoMapper);
    }

    public static IOrdenBO getInstancia() {
        if (instancia == null) {
            instancia = new OrdenBO();
        }
        return instancia;
    }

    @Override
    public OrdenDTO crearOrden(OrdenDTO ordenDTO) throws NegocioException {
        try {
            Orden ordenEntidad = ordenMapper.toEntity(ordenDTO);

            Orden ordenCreada = ordenDAO.crearOrden(ordenEntidad);

            return ordenMapper.toDTO(ordenCreada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al crear la orden: " + e.getMessage());
        }
    }

    @Override
    public OrdenDTO actualizarOrden(OrdenDTO ordenDTO) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            Orden ordenEntidad = ordenMapper.toEntity(ordenDTO);

            Orden ordenActualizada = ordenDAO.actualizarOrden(ordenEntidad);

            return ordenMapper.toDTO(ordenActualizada);
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException("La orden no se encontro para actualizar: " + e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar orden: " + e.getMessage());
        }
    }

    @Override
    public void eliminarOrden(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            ordenDAO.eliminarOrden(Long.valueOf(id));
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException("La orden no se encontro para eliminar: " + e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar orden: " + e.getMessage());
        }
    }

    @Override
    public OrdenDTO buscarOrdenPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
        try {
            Orden ordenEntidad = ordenDAO.buscarOrdenPorId(Long.valueOf(id));
            return ordenMapper.toDTO(ordenEntidad);
        } catch (EntidadNoEncontradaException e) {
            throw new EntidadNoEncontradaNegocioException("No se encontro la orden con el id: " + e.getMessage());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la orden: " + e.getMessage());
        }
    }

    @Override
    public List<OrdenDTO> buscarTodasLasOrdenes() throws NegocioException {
        try {
            List<Orden> listaEntidades = ordenDAO.buscarTodosLasOrdenes();
            return ordenMapper.toListDTO(listaEntidades);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la orden: " + e.getMessage());
        }
    }

    @Override
    public List<OrdenDTO> buscarTodasLasOrdenesPendientes() throws NegocioException {
        try {
            List<Orden> listaEntidades = ordenDAO.buscarTodosLasOrdenesPendientes();
            return ordenMapper.toListDTO(listaEntidades);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la orden: " + e.getMessage());
        }
    }

    @Override
    public List<OrdenDTO> buscarOrdenesPorCliente(String idCliente) throws NegocioException {
         try {
        List<Orden> lista = ordenDAO.buscarOrdenesPorCliente(Long.valueOf(idCliente));
        return ordenMapper.toListDTO(lista);

        }catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar ordenes del cliente: " + e.getMessage());
        }
    }

}
