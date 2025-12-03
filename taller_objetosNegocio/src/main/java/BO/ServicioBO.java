/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IServicioBO;
import DAO.ServicioDAO;
import DAO.interfaces.IServicioDAO;
import Excepciones.PersistenciaException;
import Mappers.ServicioMapper;
import Mappers.interfaces.IServicioMapper;
import dto.ServicioDTO;
import entidades.Servicio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pride Factor Black
 */
public class ServicioBO implements IServicioBO{
    
   private static IServicioBO instancia;
    private final IServicioDAO servicioDAO = ServicioDAO.getInstancia();
    private final IServicioMapper mapper;

    private ServicioBO() {
        this.mapper = new ServicioMapper();
    }

    public static IServicioBO getInstancia() {
        if (instancia == null) {
            instancia = new ServicioBO();
        }
        return instancia;
    }

    @Override
    public ServicioDTO crearServicio(ServicioDTO dto) throws NegocioException {
         try {
            Servicio servicioEntidad = mapper.toEntity(dto);

            Servicio servicioNuevo = servicioDAO.crearServicio(servicioEntidad);

            return mapper.toDTO(servicioNuevo);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public ServicioDTO actualizarServicio(ServicioDTO dto) throws NegocioException {
         try {
            Servicio entidad = mapper.toEntity(dto);

            Servicio actualizado = servicioDAO.actualizarServicio(entidad);

            return mapper.toDTO(actualizado);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public ServicioDTO eliminarServicio(Long id) throws NegocioException {
        try {
            Long idLong = Long.valueOf(id);

            Servicio eliminado = servicioDAO.eliminarServicio(idLong);

            return mapper.toDTO(eliminado);

        } catch (NumberFormatException e) {
            throw new NegocioException("El ID del servicio no tiene un formato válido.");
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public ServicioDTO buscarPorId(Long id) throws NegocioException {
         try {
            Long idLong = Long.valueOf(id);
            Servicio entidad = servicioDAO.buscarPorId(id);
            return mapper.toDTO(entidad);

        } catch (NumberFormatException e) {
            throw new NegocioException("El ID de servicio no tiene un formato válido.");
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<ServicioDTO> obtenerTodos() throws NegocioException {
         try {
            List<Servicio> lista = servicioDAO.obtenerTodos();
            return mapper.toListDTO(lista);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}
