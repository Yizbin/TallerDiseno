/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IPresupuestoBO;
import DAO.PresupuestoDAO;
import DAO.interfaces.IPresupuestoDAO;
import Excepciones.PersistenciaException;
import Mappers.PresupuestoMapper;
import Mappers.interfaces.IPresupuestoMapper;
import dto.PresupuestoDTO;
import entidades.Presupuesto;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Abraham Coronel
 */
public class PresupuestoBO implements IPresupuestoBO {

    private static IPresupuestoBO instancia;
    private final IPresupuestoDAO presupuestoDAO = PresupuestoDAO.getInstancia();
    private final IPresupuestoMapper mapper;

    private PresupuestoBO() {
        this.mapper = new PresupuestoMapper();
    }

    public static IPresupuestoBO getInstancia() {
        if (instancia == null) {
            instancia = new PresupuestoBO();
        }
        return instancia;
    }

    @Override
    public PresupuestoDTO crearPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadDuplicadaNegocioException, NegocioException {
      try {
            Presupuesto presupuestoEntidad = this.mapper.toEntity(presupuestoDTO);

            Presupuesto presupuestoNuevo = this.presupuestoDAO.crearPresupuesto(presupuestoEntidad);

            return this.mapper.toDTO(presupuestoNuevo);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public PresupuestoDTO actualizarPresupuesto(PresupuestoDTO presupuestoDTO) throws EntidadNoEncontradaNegocioException, NegocioException {
      try {
            Presupuesto presupuestoEntidad = this.mapper.toEntity(presupuestoDTO);

            Presupuesto presupuestoActualizado = this.presupuestoDAO.actualizarPresupuesto(presupuestoEntidad);

            return this.mapper.toDTO(presupuestoActualizado);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<PresupuestoDTO> buscarTodosLosPresupuestos() throws EntidadDuplicadaNegocioException, NegocioException {
       try {
            List<Presupuesto> lista = this.presupuestoDAO.buscarTodosLosPresupuestos();
            return this.mapper.toListDTO(lista);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException {
       try {
            Long idLong = Long.valueOf(id);

            Presupuesto presupuesto = this.presupuestoDAO.buscarPresupuestoPorId(idLong);

            return this.mapper.toDTO(presupuesto);

        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }

    }

    @Override
    public List<PresupuestoDTO> buscarPresupuestosNoPagados() throws NegocioException {
        try {
            List<Presupuesto> entidades = presupuestoDAO.buscarPresupuestoNoPagados();
            return mapper.toListDTO(entidades);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error recuperando presupuestos pendientes: " + e.getMessage());
        }
    }

    @Override
    public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException {
        if (idOrden == null || idOrden.trim().isEmpty()) {
            throw new NegocioException("El ID de la orden es requerido.");
        }

        try {
            Long id = Long.valueOf(idOrden);

            entidades.Presupuesto presupuestoEntidad = presupuestoDAO.buscarPresupuestoPorOrden(id);

            if (presupuestoEntidad == null) {
                throw new NegocioException("No se encontro un presupuesto asociado a la orden " + idOrden);
            }

            return mapper.toDTO(presupuestoEntidad);

        } catch (NumberFormatException e) {
            throw new NegocioException("El ID de la orden no tiene un formato valido.");
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en la capa de datos: " + e.getMessage());
        }
    }

}
